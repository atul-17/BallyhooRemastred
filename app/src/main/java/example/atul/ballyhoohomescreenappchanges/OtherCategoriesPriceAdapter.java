package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import nl.dionsegijn.steppertouch.OnStepCallback;
import nl.dionsegijn.steppertouch.Stepper;
import nl.dionsegijn.steppertouch.StepperTouch;

/**
 * Created by atul on 3/19/19.
 */
public class OtherCategoriesPriceAdapter extends RecyclerView.Adapter<OtherCategoriesPriceAdapter
        .OtherCategoriesPriceHolder> {
    private Context context;
    private List<String> stringArrayList;

    public OtherCategoriesPriceAdapter(Context context, List<String> stringArrayList) {
        this.context = context;
        this.stringArrayList = stringArrayList;
    }

    @NonNull
    @Override
    public OtherCategoriesPriceHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View view = LayoutInflater.from(context).inflate(R.layout.ballyhoo_activities_select_price_adapter,viewGroup,false);
        OtherCategoriesPriceHolder otherCategoriesPriceHolder = new OtherCategoriesPriceHolder(view);
        return otherCategoriesPriceHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OtherCategoriesPriceHolder otherCategoriesPriceHolder, int i) {
        otherCategoriesPriceHolder.stepper_touch.enableSideTap(true);
        otherCategoriesPriceHolder.stepper_touch.stepper.setMax(10);
        otherCategoriesPriceHolder.stepper_touch.stepper.setMin(1);
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    public static class OtherCategoriesPriceHolder extends RecyclerView.ViewHolder{
        StepperTouch stepper_touch;

        public OtherCategoriesPriceHolder(@NonNull View itemView) {
            super(itemView);
           stepper_touch =  itemView.findViewById(R.id.stepper_touch);

        }
    }
}
