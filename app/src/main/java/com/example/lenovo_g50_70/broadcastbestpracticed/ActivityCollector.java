package com.example.lenovo_g50_70.broadcastbestpracticed;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo-G50-70 on 2017/3/13.
 */

public class ActivityCollector {
    public static List<Activity> activities=new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for(Activity activity:activities){
            if(activity!=null){
                activity.finish();
            }
        }
    }
}
