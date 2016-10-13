package android.frontend.classapp.org.classapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView listViewTask;
    private ArrayList<Classes> clases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setContentView(R.layout.list_menu);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // setTitle("CLASES");
        clases = new ArrayList<Classes>();
        clases.add(new Classes("HOLA",R.drawable.imagen,"SOY CLASE 1"));
        clases.add(new Classes("HOLA",R.drawable.imagen,"SOY CLASE 2"));
        clases.add(new Classes("HOLA",R.drawable.imagen,"SOY CLASE 3"));
        AdapterBase AB = new AdapterBase(this, clases);
        listViewTask = (ListView) findViewById(R.id.listView);
        listViewTask.setAdapter(AB);


       /* listViewTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
               // intent.putExtra("imageViewIcon", clases.get(i).getImagen());
                intent.putExtra("textViewName", clases.get(i).getTitulo());
                intent.putExtra("textViewDetails", clases.get(i).getDescripion());

                startActivity(intent);

            }
        });*/


    }






}