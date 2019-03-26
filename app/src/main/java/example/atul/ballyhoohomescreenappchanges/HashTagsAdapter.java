package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
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
public class HashTagsAdapter extends RecyclerView.Adapter<HashTagsAdapter.HashTagsHolder>{
    private Context context;
    private List<ModelHastag> modelHastagList;

    public HashTagsAdapter(Context context, List<ModelHastag> modelHastagList) {
        this.context = context;
        this.modelHastagList = modelHastagList;
    }

    @NonNull
    @Override
    public HashTagsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.hash_tags_adapter_layout,viewGroup,false);
        HashTagsHolder hashTagsHolder = new HashTagsHolder(view);
        return hashTagsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HashTagsHolder hashTagsHolder, int i) {
        Picasso.with(context).load(modelHastagList.get(i).getImage()).fit().centerCrop().into(hashTagsHolder.iv_hash_tags_pic);
        hashTagsHolder.tv_hash_tag_name.setText(modelHastagList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return modelHastagList.size();
    }

    public static class HashTagsHolder extends RecyclerView.ViewHolder{
        public ImageView iv_hash_tags_pic;
        public TextView tv_hash_tag_name;
        public HashTagsHolder(@NonNull View itemView) {
            super(itemView);
            iv_hash_tags_pic = itemView.findViewById(R.id.iv_hash_tags_pic);
            tv_hash_tag_name = itemView.findViewById(R.id.tv_hash_tag_name);
        }
    }
}
