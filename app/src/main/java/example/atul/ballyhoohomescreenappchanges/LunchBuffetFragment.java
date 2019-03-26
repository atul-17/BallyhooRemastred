package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 1/31/19.
 */
public class LunchBuffetFragment extends Fragment {
//    @BindView(R.id.recyler_view_merchant_offers)
//    RecyclerView recyler_view_merchant_offers;
    OffersAdapter offersAdapter;
    List<String> stringList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_filter_double_items, container, false);
        ButterKnife.bind(this, view);
        linearLayoutManager = new LinearLayoutManager(getContext());
        stringList.add("atul");
        stringList.add("atul");
        stringList.add("atul");
//        setOffersAdapter();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }



//    public void setOffersAdapter() {
//
//
//        recyler_view_merchant_offers.setLayoutManager(linearLayoutManager);
//        offersAdapter = new OffersAdapter(stringList, getContext());
//        recyler_view_merchant_offers.setAdapter(offersAdapter);
//
//    }

}
