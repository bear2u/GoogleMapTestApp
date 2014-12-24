package com.example.kim.myapplication22;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kim on 2014-12-23.
 */
public class MyLocation {
    static Criteria criteria = null;
    public static double[] getMyLocation(Context context){


        double[] result = null;
        if(criteria == null){

            criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_COARSE); //정확도
            criteria.setAltitudeRequired(false);//고도
            criteria.setBearingRequired(false);
            criteria.setSpeedRequired(false);
        }
        LocationManager locationManager;

        locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.getBestProvider(criteria,true);
        if(provider == null)
            provider = "network";
        Location location = locationManager.getLastKnownLocation(provider);
        if(location == null){
             result = new double[]{0,0};
             Log.d("KTH","388 location is null!!");
        }else{
            result = new double[]{
              location.getLatitude(),location.getLongitude()
            };
        }
        return result;
    }//
}
