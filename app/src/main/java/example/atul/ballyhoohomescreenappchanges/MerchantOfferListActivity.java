package example.atul.ballyhoohomescreenappchanges;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 1/16/19.
 */
public class MerchantOfferListActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view_merchant_offers_list)
    RecyclerView recycler_view_merchant_offers_list;
    MerchantOffersAdapter merchantOffersAdapter;
    LinearLayoutManager linearLayoutManager;
    List<ModelOfferList>modelOfferLists;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_offers_list_layout);
        ButterKnife.bind(this);
        linearLayoutManager = new
                LinearLayoutManager(MerchantOfferListActivity.this);
        recycler_view_merchant_offers_list.setLayoutManager(linearLayoutManager);
        setMerchantOffersAdapter();


        recycler_view_merchant_offers_list.addOnItemTouchListener(new RecyclerItemClickListener(MerchantOfferListActivity.this, recycler_view_merchant_offers_list, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MerchantOfferListActivity.this,OfferDetailsActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    public void setMerchantOffersAdapter(){
        modelOfferLists = new ArrayList<>();

        ModelOfferList modelOfferList = new ModelOfferList();
        modelOfferList.offerImage = R.drawable.pizza;
        modelOfferList.brandName = "55 Wall Street";
        modelOfferList.locality = "JP Nagar";
        modelOfferList.price = "1000";

        ModelOfferList modelOfferList1 = new ModelOfferList();
        modelOfferList1.offerImage = R.drawable.food_4;
        modelOfferList1.brandName = "55 Wall Street";
        modelOfferList1.locality = "JP Nagar";
        modelOfferList1.price = "1000";

        ModelOfferList modelOfferList2 = new ModelOfferList();
        modelOfferList2.offerImage = R.drawable.food_2;
        modelOfferList2.brandName = "55 Wall Street";
        modelOfferList2.locality = "JP Nagar";
        modelOfferList2.price = "1000";



        modelOfferLists.add(modelOfferList);
        modelOfferLists.add(modelOfferList1);
        modelOfferLists.add(modelOfferList2);



        merchantOffersAdapter = new MerchantOffersAdapter(MerchantOfferListActivity.this,modelOfferLists);
        recycler_view_merchant_offers_list.setAdapter(merchantOffersAdapter);


    }
}
