package example.atul.ballyhoohomescreenappchanges;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 3/22/19.
 */
public class PersonlizedEnquiryFirstFragment extends Fragment {
    @BindView(R.id.btn_next)
    Button btn_next;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personlized_enquiry_first_fragment_layout,container,false);
        ButterKnife.bind(this,view);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonlizedEnquirySecondFragment personlizedEnquirySecondFragment = new PersonlizedEnquirySecondFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,personlizedEnquirySecondFragment);
                fragmentTransaction.commit();
            }
        });
        return view;

    }
}
