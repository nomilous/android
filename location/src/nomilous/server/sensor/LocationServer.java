package nomilous.server.sensor;

import nomilous.server.Updates;
import nomilous.client.Subscriber;

public class LocationServer {

    private final int eventCode = Updates.GPS_LOCATION_UPDATE;
    private Subscriber subscriber;
    

    public LocationServer( Object caller ) {

        this.subscriber = (Subscriber) caller;

    }

    private void send( String message ) {

        this.subscriber.onMessage( eventCode, message );

    }

}
