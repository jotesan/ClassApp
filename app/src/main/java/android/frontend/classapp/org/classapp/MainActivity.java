package android.frontend.classapp.org.classapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createList();
    }
    /*
    * 1.4.2 MainActivity
Esta es la ventana principal y debe cumplir lo siguiente:
 Usar un FrameLayout
 Tener un ListView
 Cada ítem debe tener un diseño similar al que se muestra
 Debe haber una clase que extienda BaseAdapter para gestionar la lista
 Cada Item debe ser un Pojo específico de cada grupo: ver especificaciones de Backend
para las Entidades: Idea, Beat, Class, Meetup o Event, según tu grupo.
 Al hacer clic en el ítem debe llevar al detalle: Intent con parámetro
    *
    * */


    public void createList() {

        String[] names = {"DOH", "HADOUKEN", "ITS A TRAP", "IM BATMAN", "FATALITY", "COMBO BREAKER", "GAAAAY", "DARTH VADER", "STAR WARS", "HOMER BOCADILLO", "KAMEHAMEHA", "NYANCAT"};

        List<String> subjectList = new ArrayList<String>(Arrays.asList(names));

        ListView listViewSubjects = (ListView) findViewById(R.id.lista);
        ArrayAdapter listViewAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.activity_main, R.id.marco, names);
        listViewSubjects.setAdapter(listViewAdapter);


        listViewSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           //algoXD

            }


        });

    }
}