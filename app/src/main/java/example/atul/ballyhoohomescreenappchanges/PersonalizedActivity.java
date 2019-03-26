package example.atul.ballyhoohomescreenappchanges;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 3/16/19.
 */
public class PersonalizedActivity extends AppCompatActivity {
    @BindView(R.id.fragment_container)
    FrameLayout fragment_container;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalized_activity_layout);
        ButterKnife.bind(this);

        PersonlizedEnquiryFirstFragment personlizedEnquiryFirstFragment = new PersonlizedEnquiryFirstFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,personlizedEnquiryFirstFragment);
        fragmentTransaction.commit();
    }
}
