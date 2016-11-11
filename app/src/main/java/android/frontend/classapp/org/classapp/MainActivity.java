package android.frontend.classapp.org.classapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    public ListView listViewTask;
   public ArrayList<Classes> clases;
     AlertDialog.Builder dialog ;

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
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("CLASES");
        //

dialog= new AlertDialog.Builder(this);
        clases = new ArrayList<Classes>();
        dialog.setTitle("INFORMACION");
        accessData(null);




        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {dialog.cancel();}
        });

        dialog.show();

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

    public void accessData (View view) {
         JsonAsyncTask jsonAsnTask = new JsonAsyncTask(this);
        jsonAsnTask.execute("http://wzw.io/web/admin/api/meetup");//("http://bizgen.co/web/admin/api/idea");//("http://classapp.org/web/admin/api/class");
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