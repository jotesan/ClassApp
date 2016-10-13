package android.frontend.classapp.org.classapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by Raúl on 11/10/2016.
 */
public class DetailActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_item);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("Detail Activity");
        TextView nom = (TextView) findViewById(R.id.textView2);
        TextView email = (TextView) findViewById(R.id.textView3);
        TextView phone = (TextView) findViewById(R.id.textView4);
        TextView nota = (TextView) findViewById(R.id.textView5);
        ImageView photo = (ImageView) findViewById(R.id.imageView2);

        String n = (String) getIntent().getExtras().getSerializable("nom");
        nom.setText(n);
        String e = (String) getIntent().getExtras().getSerializable("email");
        email.setText(e);
        int p = (int) getIntent().getExtras().getSerializable("tel");
        phone.setText(Integer.toString(p));
        float r = (float) getIntent().getExtras().getSerializable("nota");
        nota.setText(Float.toString(r));
       int i = (int) getIntent().getExtras().getSerializable("foto");
        photo.setImageResource(i);
    }
}
