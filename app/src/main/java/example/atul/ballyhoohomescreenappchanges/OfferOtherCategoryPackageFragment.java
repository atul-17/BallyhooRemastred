package example.atul.ballyhoohomescreenappchanges;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
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
 * Created by atul on 3/18/19.
 */
public class OfferOtherCategoryPackageFragment extends Fragment {
    @BindView(R.id.recycler_view_package_fragment)
    RecyclerView recycler_view_package_fragment;
    OtherCategoriesPackageAdapter otherCategoriesPackageAdapter;
    List<String> stringList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    BottomSheetDialog bottomSheetDialog;
    RecyclerView package_price_recycler_view;
    LinearLayoutManager layoutManager;
    OtherCategoriesPriceAdapter otherCategoriesPriceAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offer_other_category_package_fragment, container, false);
        ButterKnife.bind(this, view);
        stringList.add("");
        stringList.add("");
        stringList.add("");
        otherCategoriesPackageAdapter = new OtherCategoriesPackageAdapter(stringList, getContext());
        linearLayoutManager = new LinearLayoutManager(getContext());
        recycler_view_package_fragment.setLayoutManager(linearLayoutManager);
        recycler_view_package_fragment.setAdapter(otherCategoriesPackageAdapter);

        recycler_view_package_fragment.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recycler_view_package_fragment, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                settUpBottomSheetFragment();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }) {
        });
        return view;


    }
    public void settUpBottomSheetFragment(){
        Resources resources = getResources();
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet_price_recycler_view, null);
        recycler_view_package_fragment = view.findViewById(R.id.package_price_recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        recycler_view_package_fragment.setLayoutManager(layoutManager);
        otherCategoriesPriceAdapter = new OtherCategoriesPriceAdapter(getContext(),stringList);
        recycler_view_package_fragment.setAdapter(otherCategoriesPriceAdapter);
        bottomSheetDialog = new BottomSheetDialog(getContext());
        bottomSheetDialog.setTitle("Choose your Price Option");
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();

    }
}
