package example.atul.ballyhoohomescreenappchanges;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 3/25/19.
 */
public class BallyhooShowSearchedMerchantsActivity extends AppCompatActivity {
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    TabLayoutAdapter tabLayoutAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ballyhoo_show_searched_merchants_activity);
        ButterKnife.bind(this);
        tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        tabLayoutAdapter.addFragment(new BallyhooSearchedMerchantsListViewFragment(), "ListView");
        tabLayoutAdapter.addFragment(new BallyhooShowMerchantsMapViewFragment(), "MapView");
        viewPager.setAdapter(tabLayoutAdapter);
        tab_layout.setupWithViewPager(viewPager);

    }
}
