package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by atul on 3/18/19.
 */
public class OtherCategoriesOfferAdapter extends RecyclerView.Adapter<OtherCategoriesOfferAdapter.OtherCategoriesViewHolder> {
    private List<String> stringList;
    private Context context;

    public OtherCategoriesOfferAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
    }

    @NonNull
    @Override
    public OtherCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.other_category_offer_adapter, viewGroup, false);
        OtherCategoriesViewHolder otherCategoriesViewHolder = new OtherCategoriesViewHolder(view);
        return otherCategoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OtherCategoriesViewHolder otherCategoriesViewHolder, int i) {
        Picasso.with(context).load("https://res.cloudinary.com/dp67gawk6/image/upload/v1550214073/merchant/7898130226/45.jpg")
                .fit().into(otherCategoriesViewHolder.iv_offer_image);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class OtherCategoriesViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_offer_image;

        public OtherCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_offer_image = itemView.findViewById(R.id.iv_offer_image);

        }
    }
}
