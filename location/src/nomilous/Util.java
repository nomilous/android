package nomilous;

import android.content.Context;
import android.widget.Toast;
import android.view.Gravity;

public class Util {

    public static void messageUser( Context context, String msg ) {

        Toast toast = Toast.makeText(

            context, msg, Toast.LENGTH_SHORT

        );

        toast.setGravity( Gravity.CENTER, 0, 0 );

        toast.show();

    }

}
