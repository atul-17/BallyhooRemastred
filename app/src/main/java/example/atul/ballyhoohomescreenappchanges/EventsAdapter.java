package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by atul on 2/14/19.
 */
public class EventsAdapter  extends RecyclerView.Adapter<EventsAdapter.EventsHolder> {

    private List<String> stringList;
    private Context context;


    public EventsAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.offers_adapter,viewGroup,false);
        EventsHolder eventsHolder = new EventsHolder(view);
        return eventsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventsHolder eventsHolder, int i) {
//        Picasso.with(context).load(R.drawable.food_2) .into(eventsHolder.iv_offer_image);
        eventsHolder.frame_layout_event_day.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class EventsHolder extends RecyclerView.ViewHolder{
        FrameLayout frame_layout_event_day;
        RoundedImageView iv_offer_image;
        public EventsHolder(@NonNull View itemView) {
            super(itemView);
            frame_layout_event_day = (FrameLayout)itemView.findViewById(R.id.frame_layout_event_day);
            iv_offer_image = (RoundedImageView)itemView.findViewById(R.id.iv_offer_image);
        }
    }
}
