package example.atul.ballyhoohomescreenappchanges;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.LruCache;


@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class TextAwesome extends android.support.v7.widget.AppCompatTextView {

	private final static String NAME = "FONTAWESOME";
	private static LruCache<String, Typeface> sTypefaceCache = new LruCache<String, Typeface>(12);

	public TextAwesome(Context context) {
		super(context);
		init();

	}

	public TextAwesome(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public void init() {

		Typeface typeface = sTypefaceCache.get(NAME);

		if (typeface == null) {

			typeface = Typeface.createFromAsset(getContext().getAssets(), "fontawesome-webfont.ttf");
			sTypefaceCache.put(NAME, typeface);

		}

		setTypeface(typeface);

	}

}


