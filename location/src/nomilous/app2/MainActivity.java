package nomilous.app2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.location.Location;

import nomilous.server.Updates;
import nomilous.client.Subscriber;

import nomilous.Util;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final TextView showLocation = (TextView)findViewById(R.id.showLocation);
        final TextView showAcceleration = (TextView)findViewById(R.id.showAcceleration);
        final TextView showMagneticField = (TextView)findViewById(R.id.showMagneticField);
        final TextView showOrientation = (TextView)findViewById(R.id.showOrientation);

        showLocation.setText( "GPS" );
        showAcceleration.setText( "Accelerometer" );
        showMagneticField.setText( "Compass" );
        showOrientation.setText( "Orientation" );

        Updates.subscribe( getApplicationContext(),

            Updates.ROTATION_UPDATE, 
            //Updates.ACCELERATION_UPDATE,
            //Updates.MAGNETIC_FIELD_UPDATE,

            new Subscriber() {

                @Override
                public void onMessage( int event, Object payload ) {


                    switch( event ) {

                        case Updates.GPS_LOCATION_UPDATE:

                            Location location = (Location) payload;
                            showLocation.setText(  
                            location.getLatitude() + " " + location.getLongitude()
                            );
                            break;

                        case Updates.ACCELERATION_UPDATE:

                            float[] avec = (float[]) payload;
                            showAcceleration.setText(
                            avec[0] + " " + avec[1] + " " + avec[2]
                            );
                            break;

                        case Updates.MAGNETIC_FIELD_UPDATE:

                            float[] with = (float[]) payload;
                            showMagneticField.setText(
                            with[0] + " " + with[1] + " " + with[2]
                            );
                            break;

                        case Updates.ROTATION_UPDATE:
                            float[] orient = (float[]) payload;
                            showOrientation.setText(
                            orient[0] + " " + orient[1] + " " + orient[2]
                            );
                            break;

                    }

                }

            }

        );

    }

}
