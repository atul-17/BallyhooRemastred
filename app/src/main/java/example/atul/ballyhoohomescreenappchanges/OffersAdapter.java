package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by atul on 2/9/19.
 */
public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersViewHolder> {
    private List<String> stringList;
    private Context context;

    public OffersAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
    }

    @NonNull
    @Override
    public OffersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.offers_adapter, viewGroup, false);
        OffersViewHolder offersViewHolder = new OffersViewHolder(view);
        return offersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OffersViewHolder offersViewHolder, int i) {
//        Picasso.with(context).load(R.drawable.food_2).into(offersViewHolder.iv_offer_image);

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }


    public static class OffersViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView iv_offer_image;
        public OffersViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_offer_image = itemView.findViewById(R.id.iv_offer_image);
        }
    }
}
