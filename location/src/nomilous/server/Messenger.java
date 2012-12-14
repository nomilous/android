package nomilous.server;

import nomilous.client.Subscriber;
import nomilous.server.sensor.LocationServer;

import android.os.Handler;
import android.content.Context;
import java.util.ArrayList;



class Messenger implements Subscriber {

    public void subscribe( Context appContext, int eventCode, Subscriber newSubscriber ) {

        initSubscribersArray();
        initServer( appContext, eventCode );

        //
        // TODO: check handler not already registered... 
        //      

        ((ArrayList)
            
             this.subscribers.get( eventCode ) 

        ).add( newSubscriber );

    }

    //
    // private
    //

    @Override
    public void onMessage( int eventCode, Object payload ) {

        ArrayList<Subscriber> subscriberList = 

            (ArrayList<Subscriber>) this.subscribers.get( eventCode );

        for( Subscriber subscriber : subscriberList )

            subscriber.onMessage( eventCode, payload );

    }

    private ArrayList<Object> servers = null;

    private void initServer( Context appContext, int eventCode ) {

        if( this.servers == null ) {

            //
            // init Array of servers
            //

            this.servers = new ArrayList<Object>();

            for( int i = 0; i < Updates.HIGHEST_EVENT_CODE; i++ )

                this.servers.add( null );

        }

        if( this.servers.get( eventCode ) != null ) return;

        switch( eventCode ) {

            case Updates.GPS_LOCATION_UPDATE:

                this.servers.set( eventCode, new LocationServer( appContext, this ));
                break;

        }

    }

    private ArrayList<Object> subscribers = null;

    private void initSubscribersArray() {

        if( this.subscribers != null ) return;

        this.subscribers = new ArrayList<Object>();

        for( int i = 0; i < Updates.HIGHEST_EVENT_CODE; i++ ) {

            this.subscribers.add( new ArrayList<Object>() );

        }

    }

}
