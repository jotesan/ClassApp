package android.frontend.classapp.org.classapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);




        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.fade);





        Animation vueltas = AnimationUtils.loadAnimation(this, R.anim.anim);



        LayoutAnimationController controladorAnimacion =
                new LayoutAnimationController(vueltas);


        ImageView logo = (ImageView) findViewById(R.id.imageView);
        logo.startAnimation(vueltas);


        logo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent miIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(miIntent);
            }
        });


        animacion.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this,
                        MainActivity.class));

            }

            public void onAnimationRepeat(Animation arg0) {
                // TODO Auto-generated method stub

            }

            public void onAnimationStart(Animation arg0) {
                // TODO Auto-generated method stub

            }
        });


    }

}
