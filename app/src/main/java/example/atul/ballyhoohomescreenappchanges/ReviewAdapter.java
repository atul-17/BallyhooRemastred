package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by atul on 2/15/19.
 */
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder> {
    private Context context;
    private List<String> stringList;

    public ReviewAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_review_adapter_layout, viewGroup, false);
        ReviewHolder reviewHolder = new ReviewHolder(view);
        return reviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder reviewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class ReviewHolder extends RecyclerView.ViewHolder {

        public ReviewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
