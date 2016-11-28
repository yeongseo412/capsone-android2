package example.zxing;

import android.app.Application;
import android.content.Context;

/**
 *
 */
public class SampleApplication extends Application {

    private static Context mContext;

    private boolean scanCheck = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }

    public boolean getGlobalScanCheck() {
        return scanCheck;
    }

    public void setGlobalScanCheck(boolean check) {
        this.scanCheck = check;
    }
}
