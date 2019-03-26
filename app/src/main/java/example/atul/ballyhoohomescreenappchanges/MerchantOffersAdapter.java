package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by atul on 1/16/19.
 */
public class MerchantOffersAdapter extends RecyclerView.Adapter<MerchantOffersAdapter.MerchantOfferHolder> {
    private Context context;
    private List<ModelOfferList> modelOfferListList;
    Typeface tf;
    public MerchantOffersAdapter(Context context, List<ModelOfferList> modelOfferListList) {
        this.context = context;
        this.modelOfferListList = modelOfferListList;
    }

    @NonNull
    @Override
    public MerchantOfferHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        tf = Typeface.createFromAsset(context.getAssets(),
                "Madeleina Sans.otf");

        View view = LayoutInflater.from(context).inflate(R.layout.merchant_offer_adapter, viewGroup, false);
        MerchantOfferHolder merchantOfferHolder = new MerchantOfferHolder(view);
        return merchantOfferHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MerchantOfferHolder merchantOfferHolder, int i) {
            Picasso.with(context).load(modelOfferListList.get(i).offerImage).fit().centerCrop()
                    .into(merchantOfferHolder.iv_offer_image);

            merchantOfferHolder.tv_brand_name.setText(modelOfferListList.get(i).brandName);
            merchantOfferHolder.tv_brand_name.setTypeface(tf);
            merchantOfferHolder.tv_locality.setText(modelOfferListList.get(i).locality);
            merchantOfferHolder.tv_offer_price.setText(modelOfferListList.get(i).price);

    }

    @Override
    public int getItemCount() {
        return modelOfferListList.size();
    }

    public static class MerchantOfferHolder extends RecyclerView.ViewHolder {
        public ImageView iv_offer_image;
        public TextView tv_brand_name;
        public ImageView iv_veg_icon;
        public ImageView iv_non_veg_icon;
        public TextView tv_locality;
        public RatingBar rating_bar_merchant_ratings;
        public Button btn_book;
        public TextView tv_offer_price;

        public MerchantOfferHolder(@NonNull View itemView) {
            super(itemView);
            iv_offer_image = itemView.findViewById(R.id.iv_offer_image);
            tv_brand_name = itemView.findViewById(R.id.tv_brand_name);
            iv_veg_icon = itemView.findViewById(R.id.iv_veg_icon);
            iv_non_veg_icon = itemView.findViewById(R.id.iv_non_veg_icon);
            tv_locality = itemView.findViewById(R.id.tv_locality);
            rating_bar_merchant_ratings = itemView.findViewById(R.id.rating_bar_merchant_ratings);
            btn_book = itemView.findViewById(R.id.btn_book);
            tv_offer_price = itemView.findViewById(R.id.tv_offer_price);
        }
    }
}
