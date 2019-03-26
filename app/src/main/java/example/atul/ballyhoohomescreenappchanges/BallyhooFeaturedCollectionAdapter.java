package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

/**
 * Created by atul on 3/12/19.
 */
public class BallyhooFeaturedCollectionAdapter extends RecyclerView.Adapter<BallyhooFeaturedCollectionAdapter.BallyhooFeaturedCollectionHolder> {

    private Context context;
    private List<String> stringList;

    public BallyhooFeaturedCollectionAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public BallyhooFeaturedCollectionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.featured_collections_adapter_layout, viewGroup, false);
        BallyhooFeaturedCollectionHolder holder = new BallyhooFeaturedCollectionHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BallyhooFeaturedCollectionHolder ballyhooFeaturedCollectionHolder, int i) {

        Transformation transformation = new RoundedTransformationBuilder()
                .cornerRadiusDp(5)
                .oval(false)
                .build();
        Picasso.with(context)
                .load(R.drawable.food_2)
                .fit()
                .transform(transformation)
                .into(ballyhooFeaturedCollectionHolder.iv_collection_pic);

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class BallyhooFeaturedCollectionHolder extends RecyclerView.ViewHolder {
        public ImageView iv_collection_pic;


        public BallyhooFeaturedCollectionHolder(@NonNull View itemView) {
            super(itemView);
            iv_collection_pic = itemView.findViewById(R.id.iv_collection_pic);
        }
    }
}
