package android.frontend.classapp.org.classapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Post extends AppCompatActivity {

    private TextView name;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        name = (TextView) findViewById(R.id.name);
        description = (TextView) findViewById(R.id.description);
    }




   public  String getName(){
       return  name.getText().toString();
   }

    public  String gerDescription(){
        return  description.getText().toString();
    }


    public  void execute(){
        JsonAsyncTask jsonAsyncTask = new JsonAsyncTask(this);
        jsonAsyncTask.execute(" \"http://bizgen.co/web/app_dev.php\"+ \"/admin/api/form/meetup/create\"");
    }

}
