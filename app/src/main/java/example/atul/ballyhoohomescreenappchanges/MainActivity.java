package example.atul.ballyhoohomescreenappchanges;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_discover_tabs)
    RecyclerView recycler_discover_tabs;

    @BindView(R.id.main_recycler_view)
    RecyclerView main_recycler_view;

    //    @BindView(R.id.recycler_view_category_offers)
//    RecyclerView recycler_view_category_offers;
//
    @BindView(R.id.recycler_view_promotional_offers)
    RecyclerView recycler_view_promotional_offers;


    DiscoverTabsAdapter discoverTabsAdapter;
    LinearLayoutManager discoverTabManager;
    LinearLayoutManager hashTagsManager;
    HashTagsAdapter hashTagsAdapter;
    LinearLayoutManager categoryBasedManager;
    HomeScreenFilterAdapter homeScreenFilterAdapter;
    PromotionalOffersAdapter promotionalOffersAdapter;
    LinearLayoutManager promotionalOffersManager;
    private static String BASEURL = "https://ballyhoo-ajayballyhoo.c9users.io/";
    ProgressDialog progressDialog;
    List<ModelDiscover> modelDiscoverList = new ArrayList<>();
    List<ModelHastag> modelHastagList = new ArrayList<>();
    List<ModelOffersUI> modelOffersUIList = new ArrayList<>();
    List<ModelSponser> modelSponserList = new ArrayList<>();
    GridLayoutManager gridLayoutManager;
    @BindView(R.id.bottom_navigation)
    public BottomNavigationView bottomNavigation;
    @BindView(R.id.iv_banner)
    ImageView iv_banner;
    // Observable is a data stream that do some work and emits data.
    //data stream coming from an backend api
    io.reactivex.Observable<String> animalsObservable = io.reactivex.Observable.just("Cat", "Dog", "Fox,Tiger");
    Observer<String> animalObserver;
    private Disposable disposable;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MenuBuilder menuBuilder = (MenuBuilder) toolbar.getMenu();
        menuBuilder.setOptionalIconsVisible(true);
        discoverTabManager = new LinearLayoutManager(MainActivity.this);
        hashTagsManager = new LinearLayoutManager(MainActivity.this);
        categoryBasedManager = new LinearLayoutManager(MainActivity.this);
        promotionalOffersManager = new LinearLayoutManager(MainActivity.this);
        discoverTabManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hashTagsManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryBasedManager.setOrientation(LinearLayoutManager.VERTICAL);
        promotionalOffersManager.setOrientation(LinearLayoutManager.VERTICAL);
        progressDialog = new ProgressDialog(MainActivity.this);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);

        bottomNavigation.inflateMenu(R.menu.custom_tab_menu_items);
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigation);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position == 0 || position == 1 ) {
//                    return 1; // ITEMS AT POSITION 1 AND 2 OCCUPY 1 SPACES
//                } else {
//                    return 2; // OTHER ITEMS OCCUPY ONLY A two SPACE
//                }
//            }
//
//        });

        animalObserver = getAnimalObserver();
        animalsObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //can be used to filter out
                .filter(new Predicate<String>() {

                    @Override
                    public boolean test(String s) throws Exception {
                        return s.startsWith("D");
                    }
                })
                .subscribe(animalObserver);
        addData();
        addDiscoverTab();
        setCategoryBasedOffersAdapter();
        addPromotionData();


        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.action_enquiry:
                        Intent intent = new Intent(MainActivity.this, PersonalizedActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.action_search:
                        Intent searchIntent = new Intent(MainActivity.this, BallyhooSelectCategorySearchActivity.class);
                        startActivity(searchIntent);
                        break;
                }
                return true;
            }
        });

//        recycler_view_category_offers.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this,
//                recycler_view_category_offers, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Intent intent = new Intent(MainActivity.this,MerchantOfferListActivity.class);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//
//            }
//        }));
//
//        recycler_view_promotional_offers.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this,
//                recycler_view_promotional_offers, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Intent intent = new Intent(MainActivity.this,MerchantOfferListActivity.class);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//
//            }
//        }));

        recycler_discover_tabs.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this,
                recycler_discover_tabs, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (modelDiscoverList.get(position).getTitle().equals("Activities")) {
                    Intent intent = new Intent(MainActivity.this, OtherCategoriesOfferListingActivity.class);
                    startActivity(intent);
                } else if (modelDiscoverList.get(position).getTitle().equals("Events")) {
                    Intent intent = new Intent(MainActivity.this, BallyhooOtherCategoriesEventsListingActivity.class);
                    startActivity(intent);
                } else if (modelDiscoverList.get(position).getTitle().equals("Saloons")) {
                    Intent intent = new Intent(MainActivity.this, BallyhooSaloonOffersListing.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        main_recycler_view.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this,
                main_recycler_view, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, MerchantOfferListActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


    }

    private Observer<String> getAnimalObserver() {
        //Observer is the counter part of Observable.
        // It receives the data emitted by Observable.
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("tag", "onSubscribe");
                //Disposable is used to dispose the
                //subscription when an Observer no longer
                // wants to listen to Observable.
                // to avoid memory leaks
                disposable = d;
            }

            @Override
            public void onNext(String s) {
                Log.d("tag", "Name: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("tag", "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("tag", "All items are emitted!");
            }
        };
    }

    public void addPromotionData() {
        ModelSponser modelSponser = new ModelSponser();
        modelSponser.setImage("https://res.cloudinary.com/ddu6cj9h0/image/upload/v1552042925/WhatsApp_Image_2019-03-08_at_4.30.12_PM_nnsrk7.jpg");
        modelSponser.setTitle("");

        ModelSponser modelSponser1 = new ModelSponser();
        modelSponser1.setImage("https://res.cloudinary.com/ddu6cj9h0/image/upload/v1552042925/WhatsApp_Image_2019-03-08_at_4.30.12_PM_nnsrk7.jpg");
        modelSponser1.setTitle("");

        ModelSponser modelSponser2 = new ModelSponser();
        modelSponser2.setImage("https://res.cloudinary.com/ddu6cj9h0/image/upload/v1552042925/WhatsApp_Image_2019-03-08_at_4.30.12_PM_nnsrk7.jpg");
        modelSponser2.setTitle("");

        ModelSponser modelSponser3 = new ModelSponser();
        modelSponser3.setImage("https://res.cloudinary.com/ddu6cj9h0/image/upload/v1552042925/WhatsApp_Image_2019-03-08_at_4.30.12_PM_nnsrk7.jpg");
        modelSponser3.setTitle("");
        ModelSponser modelSponser4 = new ModelSponser();
        modelSponser4.setImage("https://res.cloudinary.com/ddu6cj9h0/image/upload/v1552042925/WhatsApp_Image_2019-03-08_at_4.30.12_PM_nnsrk7.jpg");
        modelSponser4.setTitle("");

        modelSponserList.add(modelSponser1);
        modelSponserList.add(modelSponser2);
        modelSponserList.add(modelSponser2);
        modelSponserList.add(modelSponser);

        setPromotionalOffersAdapter();

    }

    public void addDiscoverTab() {
        ModelDiscover modelDiscover = new ModelDiscover();
        modelDiscover.setImage("https://res.cloudinary.com/dp67gawk6/image/upload/v1550214073/merchant/7898130226/45.jpg");
        modelDiscover.setTitle("Activities");

        ModelDiscover modelDiscover1 = new ModelDiscover();
        modelDiscover1.setImage("https://res.cloudinary.com/dp67gawk6/image/upload/v1550214073/merchant/7898130226/45.jpg");
        modelDiscover1.setTitle("Events");

        ModelDiscover modelDiscover2 = new ModelDiscover();
        modelDiscover2.setImage("https://res.cloudinary.com/dp67gawk6/image/upload/v1550214073/merchant/7898130226/45.jpg");
        modelDiscover2.setTitle("Saloons");


        ModelDiscover modelDiscover3 = new ModelDiscover();
        modelDiscover3.setImage("https://res.cloudinary.com/dp67gawk6/image/upload/v1550214073/merchant/7898130226/45.jpg");
        modelDiscover3.setTitle("Trending");

        ModelDiscover modelDiscover4 = new ModelDiscover();
        modelDiscover4.setImage("https://res.cloudinary.com/dp67gawk6/image/upload/v1550214073/merchant/7898130226/45.jpg");
        modelDiscover4.setTitle("Trending");

        ModelDiscover modelDiscover5 = new ModelDiscover();
        modelDiscover5.setImage("https://res.cloudinary.com/dp67gawk6/image/upload/v1550214073/merchant/7898130226/45.jpg");
        modelDiscover5.setTitle("Trending");


        modelDiscoverList.add(modelDiscover);
        modelDiscoverList.add(modelDiscover1);
        modelDiscoverList.add(modelDiscover2);
        modelDiscoverList.add(modelDiscover3);
        modelDiscoverList.add(modelDiscover4);
        modelDiscoverList.add(modelDiscover5);


        setRecycler_discover_tabs();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }

    public void getHomeScreenApi() {
//        progressDialog.setMessage("Loading...");
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .serializeNulls()
//                .create();
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(300, TimeUnit.SECONDS)
//                .addInterceptor(interceptor)
//                .readTimeout(300, TimeUnit.SECONDS)
//                .writeTimeout(300, TimeUnit.SECONDS)
//                .build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASEURL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(okHttpClient)
//                .build();
//
//        ApiService apiService = retrofit.create(ApiService.class);
//        Call<ModelHomeScreen> modelHomeScreenCall = apiService.homeScreenApi();
//        modelHomeScreenCall.enqueue(new Callback<ModelHomeScreen>() {
//            @Override
//            public void onResponse(Call<ModelHomeScreen> call, Response<ModelHomeScreen> response) {
//                if (response.body() != null) {
//                    progressDialog.dismiss();
//                    modelDiscoverList.addAll(response.body().getDiscover());
//                    modelHastagList.addAll(response.body().getHastag());
//                    modelSingleItemList.addAll(response.body().getOffer());
//                    modelSponserList.addAll(response.body().getSponser());
//
//
//                    setRecycler_discover_tabs();
////                    setHashTagsAdapter();
//                    setCategoryBasedOffersAdapter();
////                    setPromotionalOffersAdapter();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ModelHomeScreen> call, Throwable t) {
//                progressDialog.dismiss();
//                Log.d("tag", t.getMessage());
//            }
//        });
    }


//    public void setViewModelForUi() {
//        for (ModelSingleItem modelOffer : modelSingleItemList) {
//            if (modelOffer.getTwinl().equals("0")) {
//                ModelTwoItems modelTwoItems = new ModelTwoItems();
//                modelTwoItems.setModelSingleItem1(modelOffer);
//                modelOffersUIList.add(m)
//            }
//        }
//    }

    public void setPromotionalOffersAdapter() {
        recycler_view_promotional_offers.setLayoutManager(hashTagsManager);
        promotionalOffersAdapter = new PromotionalOffersAdapter(MainActivity.this, modelSponserList);
        recycler_view_promotional_offers.setAdapter(promotionalOffersAdapter);
    }

    public void addData() {

        ModelSingleItem modelSingleItem = new ModelSingleItem();
        modelSingleItem.setImage("https://res.cloudinary.com/dp67gawk6/image/upload/v1550214073/merchant/7898130226/45.jpg");
        modelSingleItem.setTitle("Fine Dining");

        ModelSingleItem modelSingleItem1 = new ModelSingleItem();
        modelSingleItem1.setImage("https://res.cloudinary.com/dp67gawk6/image/upload/v1550214073/merchant/7898130226/45.jpg");
        modelSingleItem1.setTitle("Fine Dining");

        ModelTwoItems modelTwoItems = new ModelTwoItems();
        modelTwoItems.setModelSingleItem1(modelSingleItem1);
        modelTwoItems.setModelSingleItem2(modelSingleItem);

        ModelTwoItems modelTwoItems1 = new ModelTwoItems();
        modelTwoItems1.setModelSingleItem1(modelSingleItem1);
        modelTwoItems1.setModelSingleItem2(modelSingleItem);


        List<String> stringList = new ArrayList<>();

        stringList.add("");
        stringList.add("");
        stringList.add("");
        stringList.add("");

        ModelHomeScreenCollections modelHomeScreenCollections = new ModelHomeScreenCollections();
        modelHomeScreenCollections.setTitle("Trending");
        modelHomeScreenCollections.setStringList(stringList);

        ModelHomeScreenCollections modelHomeScreenCollections1 = new ModelHomeScreenCollections();
        modelHomeScreenCollections1.setTitle("Popular");
        modelHomeScreenCollections1.setStringList(stringList);


        ModelOffersUI modelOffersUI1 = new ModelOffersUI();
        modelOffersUI1.setModelSingleItem(modelSingleItem1);
        modelOffersUI1.setModelTwoItems(null);
        modelOffersUI1.setModelHomeScreenCollectionsList(null);


        ModelOffersUI modelOffersUI2 = new ModelOffersUI();
        modelOffersUI2.setModelSingleItem(null);
        modelOffersUI2.setModelTwoItems(modelTwoItems);
        modelOffersUI2.setModelHomeScreenCollectionsList(null);

        ModelOffersUI modelOffersUI3 = new ModelOffersUI();
        modelOffersUI3.setModelSingleItem(null);
        modelOffersUI3.setModelTwoItems(null);
        modelOffersUI3.setModelHomeScreenCollectionsList(modelHomeScreenCollections);

        ModelOffersUI modelOffersUI4 = new ModelOffersUI();
        modelOffersUI4.setModelSingleItem(modelSingleItem);
        modelOffersUI4.setModelTwoItems(null);
        modelOffersUI4.setModelHomeScreenCollectionsList(null);


        ModelOffersUI modelOffersUI5 = new ModelOffersUI();
        modelOffersUI5.setModelSingleItem(null);
        modelOffersUI5.setModelTwoItems(modelTwoItems1);
        modelOffersUI5.setModelHomeScreenCollectionsList(null);

        ModelOffersUI modelOffersUI6 = new ModelOffersUI();
        modelOffersUI6.setModelSingleItem(null);
        modelOffersUI6.setModelTwoItems(null);
        modelOffersUI6.setModelHomeScreenCollectionsList(modelHomeScreenCollections1);

        modelOffersUIList.add(modelOffersUI1);
        modelOffersUIList.add(modelOffersUI2);
        modelOffersUIList.add(modelOffersUI3);
        modelOffersUIList.add(modelOffersUI4);
        modelOffersUIList.add(modelOffersUI5);
        modelOffersUIList.add(modelOffersUI6);


    }

    public void setCategoryBasedOffersAdapter() {

        main_recycler_view.setLayoutManager(promotionalOffersManager); // set LayoutManager to RecyclerView
        main_recycler_view.setNestedScrollingEnabled(false);
        homeScreenFilterAdapter = new HomeScreenFilterAdapter(MainActivity.this, modelOffersUIList);
        main_recycler_view.setAdapter(homeScreenFilterAdapter);
    }

//    public void setHashTagsAdapter() {
//        recycler_view_hashtags_categories.setLayoutManager(hashTagsManager);
//        hashTagsAdapter = new HashTagsAdapter(MainActivity.this, modelHastagList);
//        recycler_view_hashtags_categories.setAdapter(hashTagsAdapter);
//    }

    public void setRecycler_discover_tabs() {
        discoverTabsAdapter = new DiscoverTabsAdapter(MainActivity.this, modelDiscoverList);
        recycler_discover_tabs.setLayoutManager(discoverTabManager);
        recycler_discover_tabs.setAdapter(discoverTabsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.profile:
                break;

            case R.id.orders:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
