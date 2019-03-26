package example.atul.ballyhoohomescreenappchanges;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 3/22/19.
 */
public class BallyhooSelectCategorySearchActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view_search_categories)
    RecyclerView recycler_view_search_categories;
    BallyhooSearchSelectCategoryAdapter ballyhooSearchSelectCategoryAdapter;
    LinearLayoutManager linearLayoutManager;
    List<String> stringList = new ArrayList<>();
    @BindView(R.id.recyclerview_pager_indicator)
    IndefinitePagerIndicator recyclerview_pager_indicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ballyhoo_select_category_seach_activity);
        ButterKnife.bind(this);
        stringList.add("");
        stringList.add("");
        stringList.add("");
        stringList.add("");
        stringList.add("");

        linearLayoutManager = new LinearLayoutManager(BallyhooSelectCategorySearchActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_view_search_categories.setLayoutManager(linearLayoutManager);
        ballyhooSearchSelectCategoryAdapter = new BallyhooSearchSelectCategoryAdapter(stringList, BallyhooSelectCategorySearchActivity.this);
        recycler_view_search_categories.setAdapter(ballyhooSearchSelectCategoryAdapter);
        recyclerview_pager_indicator.attachToRecyclerView(recycler_view_search_categories);
        recycler_view_search_categories.addOnItemTouchListener(new RecyclerItemClickListener(BallyhooSelectCategorySearchActivity.this, recycler_view_search_categories, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(BallyhooSelectCategorySearchActivity.this,BallyhooShowSearchedMerchantsActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}
