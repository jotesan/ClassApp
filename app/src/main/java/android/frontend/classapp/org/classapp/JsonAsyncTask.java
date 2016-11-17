package android.frontend.classapp.org.classapp;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by ruben on 10/11/2016.
 */
public class JsonAsyncTask extends AsyncTask<String, String, Void> {


    private Post post;

    private WebRequest webRequest;

    public  JsonAsyncTask(Post post){
        webRequest = new WebRequest();
        attach(post);
    }

    public  void attach(Post post){
        this.post = post;
    }

    public  void detach(){
        this.post = null;
    }


    @Override
    protected  void onPreExecute(){

    }


    @Override
    protected Void doInBackground(String... params) {
        String json = "{\"meetup\":{\"id\":1,\"name\":\"aaaa\",\"description\":\"aaaabbbb\",\"latitude\":6,\"longitude\":1,\"open\":1}}";
      if(webRequest.postJson(params[0],json)){
          Log.d("", webRequest.getResponseCode() + "post");
      };
            return  null;
    }
}
