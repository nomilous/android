package nomilous.server;

import nomilous.client.Subscriber;

import android.os.Handler;
import java.util.ArrayList;

class Messenger extends android.os.Handler {

    //
    // http://developer.android.com/reference/android/os/Handler.html
    //

    public void subscribe( int event, Subscriber newSubscriber ) {

        initSubscribersArray();

        //
        // TODO: check handler not already registered... 
        //      

        ((ArrayList)
            
             this.subscribers.get( event ) 

        ).add( newSubscriber );



        // 
        // TEMPORARY: send message
        // 

        newSubscriber.onMessage( event, "TEST UPDATE" );

    }



    //
    // private
    //

    private ArrayList<Object> subscribers = null;

    private void initSubscribersArray() {

        if( this.subscribers != null ) return;

        this.subscribers = new ArrayList<Object>();

        for( int i = 0; i < Updates.HIGHEST_EVENT_CODE; i++ ) {

            this.subscribers.add( new ArrayList<Object>() );

        }

    }

}
