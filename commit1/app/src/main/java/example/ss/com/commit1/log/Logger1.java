package example.ss.com.commit1.log;

import android.util.Log;

import example.ss.com.commit1.BuildConfig;


/*
 * created by taofu on 2019/5/6
 **/
public class Logger1 {

    private static boolean mIsDebug = BuildConfig.DEBUG;


    public static void v(String tag, String msg){
        if(mIsDebug){
            Log.v(tag, msg);
        }

    }
    public static void d(String tag, String msg){
        if(mIsDebug){
            Log.d(tag, msg);
        }
    }
    public static void i(String tag, String msg){
        if(mIsDebug){
            Log.i(tag, msg);
        }
    }
    public static void w(String tag, String msg,Throwable throwable){
        if(mIsDebug){
            Log.w(tag, msg,throwable);
        }
    }
    public static void e(String tag, String msg,Throwable throwable){
        if(mIsDebug){
            Log.e(tag, msg,throwable);
        }
    }



}
