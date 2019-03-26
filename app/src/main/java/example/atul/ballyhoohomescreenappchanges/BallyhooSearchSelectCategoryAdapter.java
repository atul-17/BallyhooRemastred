package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by atul on 3/22/19.
 */
public class BallyhooSearchSelectCategoryAdapter extends RecyclerView.Adapter<BallyhooSearchSelectCategoryAdapter.BallyhooSelectCategoryHodler> {

    private List<String>stringList;
    private Context context;



    public BallyhooSearchSelectCategoryAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
    }

    @NonNull
    @Override
    public BallyhooSelectCategoryHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.ballyhoo_search_select_category_adapter_layout,viewGroup,false);
        BallyhooSelectCategoryHodler ballyhooSelectCategoryHodler = new BallyhooSelectCategoryHodler(view);
        return ballyhooSelectCategoryHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull BallyhooSelectCategoryHodler ballyhooSelectCategoryHodler, int i) {

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class BallyhooSelectCategoryHodler extends RecyclerView.ViewHolder{

        public BallyhooSelectCategoryHodler(@NonNull View itemView) {
            super(itemView);
        }
    }
}
