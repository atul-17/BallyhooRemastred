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
public class BallyhooSaloonOffersListing extends AppCompatActivity {
    @BindView(R.id.recycler_view_saloons)
    RecyclerView recycler_view_saloons;
    BallyhooSaloonOffersListingAdapter ballyhooSaloonOffersListingAdapter;
    List<String> stringList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ballyhoo_saloon_offers_listing_activity_layout);
        ButterKnife.bind(this);
        linearLayoutManager = new LinearLayoutManager(BallyhooSaloonOffersListing.this);
        recycler_view_saloons.setLayoutManager(linearLayoutManager);
        stringList.add("");
        stringList.add("");
        stringList.add("");
        ballyhooSaloonOffersListingAdapter = new BallyhooSaloonOffersListingAdapter(BallyhooSaloonOffersListing.this, stringList);
        recycler_view_saloons.setAdapter(ballyhooSaloonOffersListingAdapter);

        recycler_view_saloons.addOnItemTouchListener(new RecyclerItemClickListener(BallyhooSaloonOffersListing.this, recycler_view_saloons, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(BallyhooSaloonOffersListing.this, BallyhooSaloonOffersDetailsActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}
