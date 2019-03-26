package example.atul.ballyhoohomescreenappchanges;

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
 * Created by atul on 3/20/19.
 */
public class BallyhooSaloonMenuFragment extends Fragment {
    @BindView(R.id.recycler_view_saloon_menu)
    RecyclerView recycler_view_saloon_menu;
    LinearLayoutManager linearLayoutManager;
    BallyhooSaloonMenuAdapter ballyhooSaloonMenuAdapter;
    List<String> stringList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ballyhoo_saloon_menu_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        linearLayoutManager = new LinearLayoutManager(getContext());
        stringList.add("Hair Cut");
        stringList.add("Spa");
        stringList.add("Hair Cut");
        stringList.add("Spa");
        stringList.add("Hair Cut");
        stringList.add("Spa");
        recycler_view_saloon_menu.setLayoutManager(linearLayoutManager);
        ballyhooSaloonMenuAdapter = new BallyhooSaloonMenuAdapter(getContext(), stringList);
        recycler_view_saloon_menu.setAdapter(ballyhooSaloonMenuAdapter);
        return view;

    }
}
