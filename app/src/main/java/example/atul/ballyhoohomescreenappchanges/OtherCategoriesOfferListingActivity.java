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
 * Created by atul on 3/18/19.
 */
public class OtherCategoriesOfferListingActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_other_category_offers)
    RecyclerView recycler_view_other_category_offers;
    List<String> stringList = new ArrayList<>();
    OtherCategoriesOfferAdapter otherCategoriesOfferAdapter;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_categories_offer_listing_activity);
        ButterKnife.bind(this);
        stringList.add("");
        stringList.add("");
        stringList.add("");
        stringList.add("");
        linearLayoutManager = new LinearLayoutManager(OtherCategoriesOfferListingActivity.this);
        recycler_view_other_category_offers.setLayoutManager(linearLayoutManager);
        otherCategoriesOfferAdapter = new OtherCategoriesOfferAdapter(stringList, OtherCategoriesOfferListingActivity.this);
        recycler_view_other_category_offers.setAdapter(otherCategoriesOfferAdapter);

        recycler_view_other_category_offers.addOnItemTouchListener(new RecyclerItemClickListener(OtherCategoriesOfferListingActivity.this,
                recycler_view_other_category_offers, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(OtherCategoriesOfferListingActivity.this, OfferActiviteisDetailsActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


    }
}
