package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by atul on 1/31/19.
 */
public class LunchBuffetOfferAdapter extends RecyclerView.Adapter<LunchBuffetOfferAdapter.LunchBuffetViewHolder> {
    private Context context;
    private List<String>stringList;
    @NonNull
    @Override
    public LunchBuffetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.offers_adapter,viewGroup,false);
        LunchBuffetViewHolder lunchBuffetViewHolder = new LunchBuffetViewHolder(view);
        return lunchBuffetViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LunchBuffetViewHolder lunchBuffetViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class LunchBuffetViewHolder extends RecyclerView.ViewHolder{

        public LunchBuffetViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
