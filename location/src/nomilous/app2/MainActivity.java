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

        Updates.subscribe( getApplicationContext(),

            Updates.GPS_LOCATION_UPDATE, 

            new Subscriber() {

                @Override
                public void onMessage( int event, Object payload ) {

                    Location location = (Location) payload;

                    showLocation.setText(  

                        location.getLatitude() + " " + location.getLongitude()

                    );

                }

            }

        );

    }

}
