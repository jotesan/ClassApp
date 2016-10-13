package android.frontend.classapp.org.classapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class DetailActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_item);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("DETALLES");
        TextView nom = (TextView) findViewById(R.id.textViewname);
        TextView detalle = (TextView) findViewById(R.id.textViewDetails);


        String n = (String) getIntent().getExtras().getSerializable("titulo");
        nom.setText(n);
        String d = (String) getIntent().getExtras().getSerializable("descripcion");
        detalle.setText(d);

    }
}
