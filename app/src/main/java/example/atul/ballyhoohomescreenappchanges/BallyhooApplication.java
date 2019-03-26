package example.atul.ballyhoohomescreenappchanges;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by atul on 1/28/19.
 */
public class BallyhooApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();

    }
}
