package example.atul.ballyhoohomescreenappchanges;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by atul on 3/20/19.
 */
public class OtherCategoriesBasicDetailsEventsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.other_categories_basic_details_events_fragment_layout, container, false);
        return view;


    }
}
