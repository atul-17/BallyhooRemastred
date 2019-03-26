package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by atul on 3/25/19.
 */
public class BallyhooShowSearchedMerchantsAdapter extends RecyclerView.Adapter<BallyhooShowSearchedMerchantsAdapter
        .BallyhooShowSearchedMerchantsHolder> {

    private List<String>stringList;
    private Context context;

    public BallyhooShowSearchedMerchantsAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
    }

    @NonNull
    @Override
    public BallyhooShowSearchedMerchantsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BallyhooShowSearchedMerchantsHolder ballyhooShowSearchedMerchantsHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class BallyhooShowSearchedMerchantsHolder extends RecyclerView.ViewHolder{

        public BallyhooShowSearchedMerchantsHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
