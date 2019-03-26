package example.atul.ballyhoohomescreenappchanges;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaygoo.widget.RangeSeekBar;
import com.jaygoo.widget.SeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atul on 2/19/19.
 */
public class AddReviewActivity extends AppCompatActivity {
    RangeSeekBar seekbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_review_activity);
//       seekbar = findViewById(R.id.seekbar);




    }
}
