package com.example.php1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ListUser extends AppCompatActivity {


    private ListView listView;


    ArrayList<Model> models= new ArrayList<Model>();

    Adapter adapter; // Adapter.java


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);




        listView=(ListView)findViewById(R.id.listview);

        //models= ListDetails.getList(); // listDetails is java file getList is the function in Listdetail.java


        //        myadapter=new MyCustomAdapter(listnewsData);
        adapter=new Adapter(getApplicationContext(),models);

        listView.setAdapter(adapter);

        String url="http://10.0.2.2/Project/php/7JSON_php_AndroidStudio_List.php";
        new MyAsyncTaskgetNews().execute(url);





    }



    // get news from server
    public class MyAsyncTaskgetNews extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            //before works
        }
        @Override
        protected String  doInBackground(String... params) {
            // TODO Auto-generated method stub
            try {
                String NewsData;
                //define the url we have to connect with
                URL url = new URL(params[0]);
                //make connect with url and send request
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                //waiting for 7000ms for response
                urlConnection.setConnectTimeout(7000);//set timeout to 5 seconds

                try {
                    //getting the response data
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    //convert the stream to string
                    NewsData = ConvertInputToStringNoChange(in);
                    //send to display data
                    publishProgress(NewsData);
                } finally {
                    //end connection
                    urlConnection.disconnect();
                }

            }catch (Exception ex){}
            return null;
        }
        protected void onProgressUpdate(String... progress) {

            try {

                //JSONObject jsonObject= new JSONObject(progress[0]);
                //display response data


                JSONArray jsonArray= new JSONArray(progress[0]);

                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject user= jsonArray.getJSONObject(i);

                    models.add(new Model(user.getInt("id"),user.getString("username"),user.getString("password")));




                //listnewsData.add(new AdapterItems(user.getInt("id"),user.getString("UserName"),user.getString("Password")));
                    //
                }
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),progress[0], Toast.LENGTH_LONG).show();

            } catch (Exception ex) {
            }


        }

        protected void onPostExecute(String  result2){


        }




    }

    // this method convert any stream to string
    public static String ConvertInputToStringNoChange(InputStream inputStream) {

        BufferedReader bureader=new BufferedReader( new InputStreamReader(inputStream));
        String line ;
        String linereultcal="";

        try{
            while((line=bureader.readLine())!=null) {

                linereultcal+=line;

            }
            inputStream.close();


        }catch (Exception ex){}

        return linereultcal;
    }

}
