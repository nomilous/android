package nomilous.server.sensor;

import nomilous.Util;
import nomilous.server.Updates;
import nomilous.client.Subscriber;

/*
 * 
 * REQUIRES:
 * 
 * AndroidManifest.xml
 * 
 * <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
 * 
 */

import android.content.Context;
import android.location.LocationManager;


public class LocationServer extends android.os.Handler  {

    private final int eventCode = Updates.GPS_LOCATION_UPDATE;
    private Subscriber subscriber;

    private static LocationManager locationManager = null;
    
    public LocationServer( Context appContext, Object caller ) {

        this.subscriber = (Subscriber) caller;

        reInitialize( appContext );

    }


    public void reInitialize( Context appContext ) {

        getLocationManager( appContext );

        if( ! ensureGPSEnabled() ) {

            Util.messageUser( appContext, "no GPS or not enabled" );
            return;

        }

    }

    private void getLocationManager( Context appContext ) {

        locationManager = (LocationManager) appContext.getSystemService(

            Context.LOCATION_SERVICE

        );

    }

    private boolean ensureGPSEnabled() {

        final boolean gpsEnabled = locationManager.isProviderEnabled(

            LocationManager.GPS_PROVIDER

        );

        //
        // Todo: Launch enable gps dialog fragment
        //

        return gpsEnabled;

    }


    private void send( String message ) {

        this.subscriber.onMessage( eventCode, message );

    }



}
