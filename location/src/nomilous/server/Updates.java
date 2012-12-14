package nomilous.server;

import nomilous.server.Messenger;
import nomilous.client.Subscriber;

public class Updates {

    public static final int NOOP                  = 0;
    public static final int GPS_LOCATION_UPDATE   = 1;
    // Dodge bugs in android ArrayList by pre initializing to size
    public static final int HIGHEST_EVENT_CODE    = 2;

    public static void subscribe( int event, Subscriber newSubscriber ) {

        m.subscribe( event, newSubscriber );

    }

    private static Messenger m = new Messenger();

}