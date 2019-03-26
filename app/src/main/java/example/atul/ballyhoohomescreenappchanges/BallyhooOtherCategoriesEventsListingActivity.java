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
 * Created by atul on 3/20/19.
 */
public class BallyhooOtherCategoriesEventsListingActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view_other_category_offers)
    RecyclerView recycler_view_other_category_offers;
    BallyhooEventsOtherCategoriesAdapter eventsOtherCategoriesAdapter;
    LinearLayoutManager linearLayoutManager;
    List<String>stringList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_categories_events_listing_activity_layout);
        ButterKnife.bind(this);
        stringList.add("");
        stringList.add("");
        stringList.add("");
        linearLayoutManager = new LinearLayoutManager(BallyhooOtherCategoriesEventsListingActivity.this);
        recycler_view_other_category_offers.setLayoutManager(linearLayoutManager);
        eventsOtherCategoriesAdapter = new BallyhooEventsOtherCategoriesAdapter(BallyhooOtherCategoriesEventsListingActivity.this,stringList);

        recycler_view_other_category_offers.setAdapter(eventsOtherCategoriesAdapter);

        recycler_view_other_category_offers.addOnItemTouchListener(new RecyclerItemClickListener(BallyhooOtherCategoriesEventsListingActivity.this, recycler_view_other_category_offers, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(BallyhooOtherCategoriesEventsListingActivity.this,BallyhooOtherCategoriesEventDetailsActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

}
