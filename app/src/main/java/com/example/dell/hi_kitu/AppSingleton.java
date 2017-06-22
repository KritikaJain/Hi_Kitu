package com.example.dell.hi_kitu;

import android.content.Context;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
/**
 * Created by dell on 01-Jun-17.
 */

public class AppSingleton {


    private static AppSingleton as;
    private RequestQueue rq;
    private static Context context;

    private AppSingleton(Context context) {
        context = context;
        rq = getRequestQueue();


    }

    public static synchronized AppSingleton getInstance(Context context) {
        if (as == null) {
            as = new AppSingleton(context);
        }
        return as;
    }

    public RequestQueue getRequestQueue() {
        if (rq == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            rq = Volley.newRequestQueue(context.getApplicationContext());
        }
        return rq;
    }

    public <T> void addToRequestQueue(Request<T> req,String tag) {
        req.setTag(tag);
        getRequestQueue().add(req);
    }


    public void cancelPendingRequests(Object tag) {
        if (rq != null) {
            rq.cancelAll(tag);
        }
    }
}
