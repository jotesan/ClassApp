package android.frontend.classapp.org.classapp;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.JsonToken;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int notifyId = 0;
    public ListView listViewTask;
   public ArrayList<Classes> clases;
     AlertDialog.Builder dialog ;
    Vibrator vibrator;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);

        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        setContentView(R.layout.list_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("MainActivity");
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("CLASES");

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        //

dialog= new AlertDialog.Builder(this);
        clases = new ArrayList<Classes>();
        dialog.setTitle("INFORMACION");
        accessData(null);




        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {dialog.cancel();}
        });

        dialog.show();




    }





    public void display(){

        AdapterBase AB = new AdapterBase(this, clases);

        listViewTask = (ListView) findViewById(R.id.listView);
        listViewTask.setAdapter(AB);
        listViewTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("I", clases.get(i).getImagen());
                intent.putExtra("N", clases.get(i).getTitulo());
                intent.putExtra("D", clases.get(i).getDescripion());

                startActivity(intent);

            }
        });

    }



    public void vibrate ()  {
        int time = 1;

        if (vibrator.hasVibrator()) {
            vibrator.vibrate(time);
            // patterns: gap, vibrate time, gap, vibrate time, gap,...
            long[] pattern = { 1000, 100, 0, 200, 100, 200 };
            // vibrate patterns and repeat
           vibrator.vibrate(pattern, 1);

        }}


    public void notifyme(){



        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.imagen);
        mBuilder.setContentTitle("CLASSAPP NOTIFICACION");
        mBuilder.setContentText("LA LISTA DE ELEMENTOS SE HA ACTUALIZADO");

        // Disappear when clicked
        mBuilder.setAutoCancel(true);

        // Optional, notification priority from -2 to 2
        //mBuilder.setPriority(0); // default

        // This will be called from the notification
        Intent resultIntent = new Intent(this, MainActivity.class);

        // We create a stack for the new Activity
        // when we enter the notification and click back we will appear in the main.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(SplashActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        // This SETS the Activity to be called when clicking on notification
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Build notification and NOTIFY
        // notifyId allows us to update the notification, changing the number
        mNotificationManager.notify(notifyId, mBuilder.build());


        MediaPlayer player;
        player = MediaPlayer.create(MainActivity.this, R.raw.dragon_ball_notificacion);

            vibrate();

        player.start();



    }

    public void accessData (View view) {
         JsonAsyncTask jsonAsnTask = new JsonAsyncTask(this);
        jsonAsnTask.execute("http://classapp.org/web/admin/api/class");//("http://bizgen.co/web/admin/api/idea");//("http://classapp.org/web/admin/api/class");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:

                 Intent intentAbout = new Intent(MainActivity.this,aboutActivity.class);
                 startActivity(intentAbout);
                return true;
            case R.id.action_settings:


                Intent intentSettings = new Intent(MainActivity.this, SettingsActivity.class);
                 startActivity(intentSettings);
                return true;
          case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


}