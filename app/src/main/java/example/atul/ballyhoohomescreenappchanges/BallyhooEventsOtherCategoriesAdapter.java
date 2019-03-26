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
public class BallyhooEventsOtherCategoriesAdapter  extends RecyclerView.Adapter<BallyhooEventsOtherCategoriesAdapter
        .BallyhooEventsOtherCategoriesHolder>{

    private Context context;
    private List<String> stringList;

    public BallyhooEventsOtherCategoriesAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public BallyhooEventsOtherCategoriesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.ballyhoo_events_other_categories_adapter,viewGroup,false);
        BallyhooEventsOtherCategoriesHolder ballyhooEventsOtherCategoriesHolder = new BallyhooEventsOtherCategoriesHolder(view);
        return ballyhooEventsOtherCategoriesHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BallyhooEventsOtherCategoriesHolder ballyhooEventsOtherCategoriesHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class BallyhooEventsOtherCategoriesHolder extends RecyclerView.ViewHolder{

        public BallyhooEventsOtherCategoriesHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
