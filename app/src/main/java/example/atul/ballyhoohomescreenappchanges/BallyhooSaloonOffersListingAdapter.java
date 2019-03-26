package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by atul on 3/20/19.
 */
public class BallyhooSaloonOffersListingAdapter extends RecyclerView.Adapter<BallyhooSaloonOffersListingAdapter
        .BallyhooSaloonOffersListingHolder> {

    private Context context;
    private List<String> stringList;

    public BallyhooSaloonOffersListingAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public BallyhooSaloonOffersListingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.ballyhoo_saloon_offers_listing_adapter, viewGroup, false);
        BallyhooSaloonOffersListingHolder ballyhooSaloonOffersListingHolder = new BallyhooSaloonOffersListingHolder(view);
        return ballyhooSaloonOffersListingHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BallyhooSaloonOffersListingHolder ballyhooSaloonOffersListingHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class BallyhooSaloonOffersListingHolder extends RecyclerView.ViewHolder {

        public BallyhooSaloonOffersListingHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
