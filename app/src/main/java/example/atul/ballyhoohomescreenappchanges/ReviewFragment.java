package example.atul.ballyhoohomescreenappchanges;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaygoo.widget.RangeSeekBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 2/14/19.
 */
public class ReviewFragment extends Fragment {
    @BindView(R.id.recycler_view_user_reviews)
    RecyclerView recycler_view_user_reviews;
    LinearLayoutManager linearLayoutManager;
    ReviewAdapter reviewAdapter;
    @BindView(R.id.ta_review)
    TextAwesome ta_review;
    List<String> stringList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.review_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recycler_view_user_reviews.setLayoutManager(linearLayoutManager);

        stringList.add("atul");
        stringList.add("kaishik");
        stringList.add("kaishik");
        ta_review.setText(getContext().getResources().getString(R.string.fa_plus)+ " Add Review");
        reviewAdapter = new ReviewAdapter(getContext(), stringList);
        recycler_view_user_reviews.setLayoutManager(linearLayoutManager);
        recycler_view_user_reviews.setAdapter(reviewAdapter);

        ta_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),AddReviewActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
