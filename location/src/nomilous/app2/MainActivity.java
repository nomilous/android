package nomilous.app2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import nomilous.server.Updates;
import nomilous.client.Subscriber;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final TextView showLocation = (TextView)findViewById(R.id.showLocation);

        Updates.subscribe( 

            Updates.GPS_LOCATION_UPDATE, 

            new Subscriber() {

                @Override
                public void onMessage( int event, Object payload ) {

                    showLocation.setText(  (String) payload  );

                }

            }

        );

    }

}
