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

import com.google.android.gms.maps.MapView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 3/12/19.
 */
public class OfferActivitiesBasicDetailsFragment extends Fragment {
    @BindView(R.id.recycler_view_featured_collections)
    RecyclerView recycler_view_featured_collections;
    LinearLayoutManager linearLayoutManager;
    BallyhooFeaturedCollectionAdapter adapter;
    List<String> stringList = new ArrayList<>();
    @BindView(R.id.map)
    MapView mapFragment;
    @BindView(R.id.riv_pic_1)
    RoundedImageView riv_pic_1;
    @BindView(R.id.riv_pic_2)
    RoundedImageView riv_pic_2;
    @BindView(R.id.riv_pic_3)
    RoundedImageView riv_pic_3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activities_and_saloon_basic_details,container,false);
        ButterKnife.bind(this,view);
        stringList.add("");
        stringList.add("");
        stringList.add("");
        stringList.add("");
        stringList.add("");
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapter = new BallyhooFeaturedCollectionAdapter(getContext(),stringList);
        recycler_view_featured_collections.setLayoutManager(linearLayoutManager);
        recycler_view_featured_collections.setAdapter(adapter);

        Transformation transformation = new RoundedTransformationBuilder()
                .cornerRadiusDp(5)
                .oval(false)
                .build();

        Picasso.with(getContext())
                .load(R.drawable.food_2)
                .fit()
                .transform(transformation)
                .into(riv_pic_1);
        Picasso.with(getContext())
                .load(R.drawable.food_2)
                .fit()
                .transform(transformation)
                .into(riv_pic_2);
        Picasso.with(getContext())
                .load(R.drawable.food_2)
                .fit()
                .transform(transformation)
                .into(riv_pic_3);

        return view;
    }
}
