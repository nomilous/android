package nomilous.server.sensor;

import nomilous.Util;
import nomilous.server.Updates;
import nomilous.client.Subscriber;

import android.content.Context;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class OrientationServer  {

    private Subscriber subscriber;

    public OrientationServer( Context appContext, Object caller ) {

        this.subscriber = (Subscriber) caller;

        sensorManager = (SensorManager) appContext.getSystemService( 

            Context.SENSOR_SERVICE 

        );

    }


    private static SensorManager sensorManager = null;

    
}
