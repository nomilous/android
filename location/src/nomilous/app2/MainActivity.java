package nomilous.app2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.location.Location;
import java.net.URI;
import org.json.JSONArray;

import com.codebutler.android_websockets.SocketIOClient;

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
        
        SocketIOClient client = new SocketIOClient(

            URI.create("http://10.0.0.11:3000"), 
            new SocketIOClient.Handler() {
            
                @Override
                public void onConnect() { /* BROKEN */ }

                @Override
                public void on(String event, JSONArray arguments) {
                    Util.info(String.format("Got event %s: %s", event, arguments.toString()));
                }

                @Override
                public void onDisconnect(int code, String reason) {}

                @Override
                public void onError(Exception error) {}

            }
        );

        client.connect();

        showLocation.setText( "GPS" );
        showAcceleration.setText( "Accelerometer" );
        showMagneticField.setText( "Compass" );
        showOrientation.setText( "Orientation" );

        Updates.subscribe( getApplicationContext(),

            Updates.GPS_LOCATION_UPDATE | Updates.ACCELERATION_UPDATE | 
            Updates.MAGNETIC_FIELD_UPDATE | Updates.ROTATION_UPDATE,

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
