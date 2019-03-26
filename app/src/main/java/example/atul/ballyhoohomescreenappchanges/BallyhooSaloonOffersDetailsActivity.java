package example.atul.ballyhoohomescreenappchanges;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 3/20/19.
 */
public class BallyhooSaloonOffersDetailsActivity extends AppCompatActivity {
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
        setContentView(R.layout.activities_and_saloon_offer_details);
        ButterKnife.bind(this);
        tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        tabLayoutAdapter.addFragment(new OfferActivitiesBasicDetailsFragment(),
                "Details");
        tabLayoutAdapter.addFragment(new BallyhooSaloonMenuFragment(),
                "Menu");
        tabLayoutAdapter.addFragment(new OfferOtherCategoryPackageFragment(),
                "Packages");
        tabLayoutAdapter.addFragment(new ReviewFragment()
                , "Reviews");

        viewPager.setAdapter(tabLayoutAdapter);
        tab_layout.setupWithViewPager(viewPager);
        customPagerAdapter = new CustomPagerAdapter(this);
        vp_offers_pic.setAdapter(customPagerAdapter);

        wormDotsIndicator.setViewPager(vp_offers_pic);

    }
}
