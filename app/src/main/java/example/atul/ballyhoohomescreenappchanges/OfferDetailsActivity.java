package example.atul.ballyhoohomescreenappchanges;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 1/14/19.
 */
public class OfferDetailsActivity extends AppCompatActivity {

    @BindView(R.id.vp_offers_pic)
    ViewPager vp_offers_pic;
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    TabLayoutAdapter tabLayoutAdapter;
    CustomPagerAdapter customPagerAdapter;
    @BindView(R.id.worm_dots_indicator)
    WormDotsIndicator wormDotsIndicator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offers_details_layout);
        ButterKnife.bind(this);
        tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        tabLayoutAdapter.addFragment(new OfferBasicDetailsFragment(),
                "Details");

        tabLayoutAdapter.addFragment(new LunchBuffetFragment(),
                "Offers");

        tabLayoutAdapter.addFragment(new EventsFragment(),
                "Events");

        tabLayoutAdapter.addFragment(new ReviewFragment()
                , "Reviews");

        viewPager.setAdapter(tabLayoutAdapter);
        tab_layout.setupWithViewPager(viewPager);
        customPagerAdapter = new CustomPagerAdapter(this);
        vp_offers_pic.setAdapter(customPagerAdapter);
        wormDotsIndicator.setViewPager(vp_offers_pic);
//        viewPager.setCurrentItem(2);

    }


}
