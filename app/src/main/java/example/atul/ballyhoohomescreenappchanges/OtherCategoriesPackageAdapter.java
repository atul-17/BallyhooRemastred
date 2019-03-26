package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by atul on 3/18/19.
 */
public class OtherCategoriesPackageAdapter extends RecyclerView.Adapter<OtherCategoriesPackageAdapter.OtherCategoriesPackageHolder>{

    private List<String>stringList;
    private Context context;
    private int randomColor;
    public OtherCategoriesPackageAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
    }

    @NonNull
    @Override
    public OtherCategoriesPackageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.other_category_offer_package_adapter,viewGroup,false);
        OtherCategoriesPackageHolder otherCategoriesPackageHolder = new OtherCategoriesPackageHolder(view);
        randomColor = MaterialColorPalette.getRandomColor("50");
        return otherCategoriesPackageHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OtherCategoriesPackageHolder otherCategoriesPackageHolder, int i) {
        otherCategoriesPackageHolder.event_package_cardview.setCardBackgroundColor(randomColor);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class OtherCategoriesPackageHolder extends RecyclerView.ViewHolder{
        public CardView event_package_cardview;
        public OtherCategoriesPackageHolder(@NonNull View itemView) {
            super(itemView);
            event_package_cardview = itemView.findViewById(R.id.event_package_cardview);
        }
    }
}
