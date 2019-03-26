package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by atul on 1/12/19.
 */
public class DiscoverTabsAdapter extends RecyclerView.Adapter<DiscoverTabsAdapter.DiscoverTabsHolder> {
    private Context context;
    private List<ModelDiscover>modelDiscoverList;

    public DiscoverTabsAdapter(Context context, List<ModelDiscover>modelDiscoverList) {
        this.context = context;
        this.modelDiscoverList = modelDiscoverList;
    }

    @NonNull
    @Override
    public DiscoverTabsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.discover_tabs_adapter_layout,viewGroup,false);
        DiscoverTabsHolder discoverTabsHolder = new DiscoverTabsHolder(view);
        return discoverTabsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoverTabsHolder discoverTabsHolder, int pos) {
//        Picasso.with(context).load(modelDiscoverList.get(pos).getImage()).fit().centerCrop().into(discoverTabsHolder.iv_discover_tab_pic);
        discoverTabsHolder.tv_discover_tab_name.setText(modelDiscoverList.get(pos).getTitle());

    }

    @Override
    public int getItemCount() {
        return modelDiscoverList.size();
    }

    public static class DiscoverTabsHolder extends RecyclerView.ViewHolder{
        public CircularImageView iv_discover_tab_pic;
        public TextView tv_discover_tab_name;
        public DiscoverTabsHolder(@NonNull View itemView) {
            super(itemView);
            iv_discover_tab_pic = itemView.findViewById(R.id.iv_discover_tab_pic);
            tv_discover_tab_name = itemView.findViewById(R.id.tv_discover_tab_name);
        }
    }
}
