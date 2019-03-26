package example.atul.ballyhoohomescreenappchanges;

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
 * Created by atul on 3/25/19.
 */
public class BallyhooSearchedMerchantsListViewFragment extends Fragment {
    @BindView(R.id.recycler_view_search_merchants)
    RecyclerView recycler_view_search_merchants;
    LinearLayoutManager linearLayoutManager;
    MerchantOffersAdapter offersAdapter;
    List<ModelOfferList>modelOfferLists;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ballyhoo_searched_merchants_listview_fragment, container, false);
        ButterKnife.bind(this,view);
        linearLayoutManager = new LinearLayoutManager(getContext());
        setMerchantOffersAdapter();
        offersAdapter = new MerchantOffersAdapter(getContext(),modelOfferLists);
        recycler_view_search_merchants.setLayoutManager(linearLayoutManager);
        recycler_view_search_merchants.setAdapter(offersAdapter);
        return view;

    }

    public void setMerchantOffersAdapter(){
        modelOfferLists = new ArrayList<>();

        ModelOfferList modelOfferList = new ModelOfferList();
        modelOfferList.offerImage = R.drawable.pizza;
        modelOfferList.brandName = "55 Wall Street";
        modelOfferList.locality = "JP Nagar";
        modelOfferList.price = "1000";

        ModelOfferList modelOfferList1 = new ModelOfferList();
        modelOfferList1.offerImage = R.drawable.food_4;
        modelOfferList1.brandName = "55 Wall Street";
        modelOfferList1.locality = "JP Nagar";
        modelOfferList1.price = "1000";

        ModelOfferList modelOfferList2 = new ModelOfferList();
        modelOfferList2.offerImage = R.drawable.food_2;
        modelOfferList2.brandName = "55 Wall Street";
        modelOfferList2.locality = "JP Nagar";
        modelOfferList2.price = "1000";



        modelOfferLists.add(modelOfferList);
        modelOfferLists.add(modelOfferList1);
        modelOfferLists.add(modelOfferList2);






    }
}
