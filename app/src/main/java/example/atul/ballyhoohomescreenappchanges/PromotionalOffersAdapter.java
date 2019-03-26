package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by atul on 1/12/19.
 */
public class PromotionalOffersAdapter extends RecyclerView.Adapter<PromotionalOffersAdapter.PromotionalOffersHolder> {
    private Context context;
    private List<ModelSponser>modelSponserList;

    public PromotionalOffersAdapter(Context context, List<ModelSponser>modelSponserList) {
        this.context = context;
        this.modelSponserList = modelSponserList;
    }

    @NonNull
    @Override
    public PromotionalOffersHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.promotional_offers_adapter,viewGroup,false);
        PromotionalOffersHolder promotionalOffersHolder = new PromotionalOffersHolder(view);
        return promotionalOffersHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionalOffersHolder promotionalOffersHolder, int i) {
        Picasso.with(context).load(modelSponserList.get(i).getImage()).fit().centerCrop().into(promotionalOffersHolder.iv_promotional_offer);
//        promotionalOffersHolder.tv_promotional_offer.setText(modelSponserList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return modelSponserList.size();
    }

    public static class PromotionalOffersHolder extends RecyclerView.ViewHolder{
        public ImageView iv_promotional_offer;
        public TextView tv_promotional_offer;
        public PromotionalOffersHolder(@NonNull View itemView) {
            super(itemView);
            iv_promotional_offer = itemView.findViewById(R.id.iv_promotional_offer);
//            tv_promotional_offer = itemView.findViewById(R.id.tv_promotional_offer);
        }
    }
}
