package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by atul on 3/20/19.
 */
public class BallyhooSaloonMenuAdapter extends RecyclerView.Adapter<BallyhooSaloonMenuAdapter
        .BallyhooSaloonMenuHolder> {
    private Context context;
    private List<String>stringList;

    public BallyhooSaloonMenuAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public BallyhooSaloonMenuHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.ballyhoo_saloon_menu_adapter,viewGroup,false);
        BallyhooSaloonMenuHolder ballyhooSaloonMenuHolder = new BallyhooSaloonMenuHolder(view);
        return ballyhooSaloonMenuHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BallyhooSaloonMenuHolder ballyhooSaloonMenuHolder, int i) {
    ballyhooSaloonMenuHolder.tv_category_name.setText(stringList.get(i));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class BallyhooSaloonMenuHolder extends RecyclerView.ViewHolder{
            TextView tv_category_name;
        public BallyhooSaloonMenuHolder(@NonNull View itemView) {
            super(itemView);
            tv_category_name = itemView.findViewById(R.id.tv_category_name);
        }
    }
}
