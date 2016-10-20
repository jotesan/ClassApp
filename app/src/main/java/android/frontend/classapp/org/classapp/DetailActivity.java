package android.frontend.classapp.org.classapp;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.provider.ContactsContract;
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
        TextView nom = (TextView) findViewById(R.id.textView1);
        TextView detalle = (TextView) findViewById(R.id.textView3);
        ImageView imagen = (ImageView) findViewById(R.id.imageView2);

        //Bundle bundle = getIntent().getExtras();
        //bundle = getIntent().getExtras();

         // String n = (String) bundle.getStringArrayList();

        int photo = (int) getIntent().getExtras().get("I");
        imagen.setImageResource(photo);
      String n = (String) getIntent().getExtras().get("N");
        nom.setText(n);
        String d = (String) getIntent().getExtras().get("D");
       detalle.setText(d);



    }
}
