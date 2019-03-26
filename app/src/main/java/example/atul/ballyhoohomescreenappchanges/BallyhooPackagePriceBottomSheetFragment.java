package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
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
 * Created by atul on 3/19/19.
 */
public class BallyhooPackagePriceBottomSheetFragment extends BottomSheetDialogFragment {
    @BindView(R.id.package_price_recycler_view)
    RecyclerView package_price_recycler_view;
    LinearLayoutManager recyclerlinearLayoutManager;
    Context context;
    List<String>stringList = new ArrayList<>();
    OtherCategoriesPriceAdapter otherCategoriesPriceAdapter;

    public BallyhooPackagePriceBottomSheetFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_price_recycler_view, container, false);
        ButterKnife.bind(this,view);

        recyclerlinearLayoutManager = new LinearLayoutManager(context);
        package_price_recycler_view.setLayoutManager(recyclerlinearLayoutManager);
        otherCategoriesPriceAdapter = new OtherCategoriesPriceAdapter(context,stringList);
        package_price_recycler_view.setAdapter(otherCategoriesPriceAdapter);
        return view;

    }
}
