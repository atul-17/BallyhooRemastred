package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by atul on 3/8/19.
 */
public class BallyhooHomeFilterCollectionsAdapter extends RecyclerView.Adapter<BallyhooHomeFilterCollectionsAdapter.BallyhooHomeFilterCollectionsViewHolder> {
    private Context context;
    private List<String> stringList;

    public BallyhooHomeFilterCollectionsAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public BallyhooHomeFilterCollectionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.ballyhoo_home_filter_collections_adapter, viewGroup, false);
        BallyhooHomeFilterCollectionsViewHolder ballyhooHomeFilterCollectionsViewHolder = new BallyhooHomeFilterCollectionsViewHolder(view);
        return ballyhooHomeFilterCollectionsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BallyhooHomeFilterCollectionsViewHolder ballyhooHomeFilterCollectionsViewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class BallyhooHomeFilterCollectionsViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_home_collection_item;
        public TextView tv_home_filter_collection_item;

        public BallyhooHomeFilterCollectionsViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_home_collection_item = itemView.findViewById(R.id.iv_home_collection_item);
            tv_home_filter_collection_item = itemView.findViewById(R.id.tv_home_filter_collection_item);
        }
    }
}
