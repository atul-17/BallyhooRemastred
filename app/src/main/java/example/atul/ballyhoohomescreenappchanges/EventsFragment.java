package example.atul.ballyhoohomescreenappchanges;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 2/14/19.
 */
public class EventsFragment extends Fragment {
    @BindView(R.id.recycler_view_event_offers)
    RecyclerView recycler_view_event_offers;
    EventsAdapter eventsAdapter;
    List<String> stringList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        linearLayoutManager = new LinearLayoutManager(getContext());
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        setOffersAdapter();
    }

    public void setOffersAdapter() {
        stringList.add("atul");
        stringList.add("atul");
        stringList.add("atul");
        stringList.add("atul");
        stringList.add("atul");
        stringList.add("atul");
        stringList.add("atul");
        stringList.add("atul");
        stringList.add("atul");

        recycler_view_event_offers.setLayoutManager(linearLayoutManager);
        eventsAdapter = new EventsAdapter(stringList, getContext());
        recycler_view_event_offers.setAdapter(eventsAdapter);
    }

}
