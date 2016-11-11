package android.frontend.classapp.org.classapp;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by GATO-GOKU on 06/11/2016.
 */

public class JsonAsyncTask extends AsyncTask<String,String, Void> {

    private MainActivity mainActivity;

    private WebRequest webRequest;
    /**
     * Default constructor
     * @param mainActivity
     */
    public JsonAsyncTask(MainActivity mainActivity) {
        webRequest = new WebRequest(this);
        attach(mainActivity);
    }

    /**
     * sets mainActivity reference
     * @param mainActivity
     */
    public void attach(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    /**
     * when task is finished this reference is not needed any longer
     */
    public void detach () {
        this.mainActivity = null;
    }

    /**
     * This is called before doInBackground and is a perfect place
     * to prepare the progress Bar.
     */
    @Override
    protected void onPreExecute () {
        Toast.makeText(this.mainActivity, "Starting Async Task", Toast.LENGTH_SHORT).show();
        // this.mainActivity.getProgressBar1().setVisibility(1);
        this.mainActivity.findViewById(R.id.listView);
    }

    /**
     * This is where the task begins and runs
     * String... url declares variable arguments list,
     * and we can get values using indexes: url[0], url[1],...
     * Whenever we consider that we make som progress we can
     * notify through publishProgress()
     */


    @Override



    protected Void doInBackground(String... url) {



        JSONArray classesJson =null;
        mainActivity.clases =  new ArrayList<Classes>();
       // Log.d("PELLODEBUG","URL passed to AsyncTask: " + url[0]);
        //String jsonData ="{'data': {'technologies':[{name : 'Backbone', description : 'JS MVC Framework' , difficulty: 6}, {name : 'Angular', description: 'JS MVC Framework' ,difficulty: 8}, {name : 'CouchDB', description: 'noSQL Database' ,dificultty: 9} ]}, 'responseDetails': null, 'responseStatus': 200} ";

         String jsonData = "";
        try {






            if (webRequest.get(url[0])) {
                jsonData = webRequest.getResponseString();
                mainActivity.dialog.setMessage("OK Total: " + "XD");
              this.parseJson(jsonData);//webRequest.getResponseString());
                classesJson = new JSONArray(jsonData);//webRequest.getResponseString());
                for (int i = 0; i < classesJson.length(); i++) {
                    try {
                        mainActivity.clases.add(new Classes(classesJson.getJSONObject(i).getString("name"), R.drawable.imagen, classesJson.getJSONObject(i).getString("description")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                mainActivity.dialog.setMessage("Error: " + webRequest.getExceptionMessage());

            }
        } catch (Exception e) {
            Log.d("PELLODEBUG","Exception processing JSON: " + e.getMessage());
        }
        // With this call we notify to progressUpdate
        Log.d("PELLODEBUG","doInBackbround publishes progress");





        // TODO Auto-generated method stub


return null;

    }

    /**
     * This method is called when we call this.publishProgress
     * and can be used to update contents,progress bars,... in the Activity
     */


    protected void onPostExecute(Void unused) {
        Toast.makeText(this.mainActivity, "Finished Async Task", Toast.LENGTH_SHORT).show();
        Log.d("PELLODEBUG","onPostExecute was called: ");
        //this.mainActivity.getProgressBar1().setVisibility(ProgressBar.INVISIBLE);

    }

    /**
     *
     * @param cadenaJSON
     * @return
     * @throws IllegalStateException
     * @throws IOException
     * @throws JSONException
     * @throws NoSuchAlgorithmException
     */
    public void parseJson (String cadenaJSON) throws IllegalStateException,
            IOException, JSONException, NoSuchAlgorithmException {

        String name = "";
        String description = "";

        // and from that object we get the array of data we need
        JSONArray registros = new JSONArray(cadenaJSON);

        Log.d("JSON parser> # records:" + registros.length(),"PELLODEBUG");

        // and now, for each record we process data.
        for (int i = 0; i < registros.length(); i++) {
            Log.d("PELLODEBUG","JSON parser> json record data: " + i + "] " + registros.get(i).toString());
            // We get name and description
            name = registros.getJSONObject(i).getString("name");
            description = registros.getJSONObject(i).getString("description");

            this.publishProgress(name, description);

        }

        Log.d("JSON parser> finished","PELLODEBUG");

    }



}
