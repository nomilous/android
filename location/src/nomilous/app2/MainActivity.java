package nomilous.app2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import nomilous.server.sensor.Location;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView showLocation = (TextView)findViewById(R.id.showLocation);

        showLocation.setText(  Location.test()  );

    }
}
