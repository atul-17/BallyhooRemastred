package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
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
public class HomeScreenFilterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ModelOffersUI> modelOffersUIList;

    public HomeScreenFilterAdapter(Context context, List<ModelOffersUI> modelOffersUIList) {
        this.context = context;
        this.modelOffersUIList = modelOffersUIList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = null;

        switch (viewType) {
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.home_filter_single_item, viewGroup, false);
                return new HomefilterSingleItem(view);
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.home_filter_double_items, viewGroup, false);
                return new HomeFilterDoubleItem(view);

            case 3:
                view = LayoutInflater.from(context).inflate(R.layout.home_filter_nested_recylerview, viewGroup, false);
                return new HomeFilterNestedRecyclerView(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 1:
                HomefilterSingleItem homefilterSingleItem = (HomefilterSingleItem) viewHolder;
                homefilterSingleItem.tv_home_filter_single.setText(modelOffersUIList.get(i).getModelSingleItem().getTitle());
                Picasso.with(context).load(modelOffersUIList.get(i).getModelSingleItem().getImage()).fit().centerCrop().into(homefilterSingleItem.iv_home_filter_single);
                break;

            case 2:
                HomeFilterDoubleItem homeFilterDoubleItem = (HomeFilterDoubleItem) viewHolder;
                Picasso.with(context).load(modelOffersUIList.get(i).getModelTwoItems().getModelSingleItem1().getImage()).fit().centerCrop().into(homeFilterDoubleItem.iv_home_filter_deal_item_one);
                Picasso.with(context).load(modelOffersUIList.get(i).getModelTwoItems().getModelSingleItem2().getImage()).fit().centerCrop().into(homeFilterDoubleItem.iv_home_filter_deal_item_two);
                break;

            case 3:
                HomeFilterNestedRecyclerView homeFilterNestedRecyclerView = (HomeFilterNestedRecyclerView) viewHolder;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                BallyhooHomeFilterCollectionsAdapter homeFilterCollectionsAdapter = new BallyhooHomeFilterCollectionsAdapter(context, modelOffersUIList
                        .get(i).getModelHomeScreenCollectionsList().getStringList());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                homeFilterNestedRecyclerView.recycler_view_collections.setLayoutManager(linearLayoutManager);
                homeFilterNestedRecyclerView.recycler_view_collections.setAdapter(homeFilterCollectionsAdapter);
                homeFilterNestedRecyclerView.tv_collections_title.setText(modelOffersUIList.get(i).getModelHomeScreenCollectionsList().getTitle());


        }

    }


    @Override
    public int getItemCount() {
        return modelOffersUIList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (modelOffersUIList.get(position).getModelSingleItem() != null) {
            return 1;
        } else if (modelOffersUIList.get(position).getModelTwoItems() != null) {
            return 2;
        } else if (modelOffersUIList.get(position).getModelHomeScreenCollectionsList()!=null) {
            return 3;
        }
        return 0;

    }

    public static class HomeFilterDoubleItem extends RecyclerView.ViewHolder {

        public ImageView iv_home_filter_deal_item_one;
        public TextView tv_home_filter_deal_item_one;
        public ImageView iv_home_filter_deal_item_two;
        public TextView tv_home_filter_deal_item_two;

        public HomeFilterDoubleItem(@NonNull View itemView) {
            super(itemView);
            iv_home_filter_deal_item_one = itemView.findViewById(R.id.iv_home_filter_deal_item_one);
            iv_home_filter_deal_item_two = itemView.findViewById(R.id.iv_home_filter_deal_item_two);
            tv_home_filter_deal_item_one = itemView.findViewById(R.id.tv_home_filter_deal_item_one);
            tv_home_filter_deal_item_two = itemView.findViewById(R.id.tv_home_filter_deal_item_two);
        }
    }

    public static class HomeFilterNestedRecyclerView extends RecyclerView.ViewHolder {

        public RecyclerView recycler_view_collections;
        public TextView tv_collections_title;
        public HomeFilterNestedRecyclerView(@NonNull View itemView) {
            super(itemView);
            recycler_view_collections = itemView.findViewById(R.id.recycler_view_collections);
            tv_collections_title = itemView.findViewById(R.id.tv_collections_title);
        }
    }

    public static class HomefilterSingleItem extends RecyclerView.ViewHolder {
        public ImageView iv_home_filter_single;
        public TextView tv_home_filter_single;

        public HomefilterSingleItem(@NonNull View itemView) {
            super(itemView);
            iv_home_filter_single = itemView.findViewById(R.id.iv_home_filter_single);
            tv_home_filter_single = itemView.findViewById(R.id.tv_home_filter_single);
        }
    }
}
