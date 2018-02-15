package ir.rayanpayamak;

import android.app.Application;
import android.graphics.Typeface;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import utils.LruBitmapCache;


public class App extends Application {

    public static Typeface FONT_IRAN_SANS;
    public static Typeface FONT_IRAN_SANS_BOLD;
    public static Typeface FONT_IRAN_SANS_LIGHT;

    public static String SERVER_ADDRESS = "http://rpd.ibben.org/";


    public static final String TAG = App.class.getSimpleName();

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private static App mInstance;


    @Override
    public void onCreate() {
        super.onCreate();

        FONT_IRAN_SANS = Typeface.createFromAsset(getAssets(), "fonts/iran_sans.ttf");
        FONT_IRAN_SANS_BOLD = Typeface.createFromAsset(getAssets(), "fonts/iran_sans_bold.ttf");
        FONT_IRAN_SANS_LIGHT = Typeface.createFromAsset(getAssets(), "fonts/iran_sans_light.ttf");
        mInstance = this;


    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue, new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }


    }

}
