package com.example.ok.volly;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Adapter adapter;

List<Model> list = new ArrayList<Model>();


    int i;
    Context mContext;
    private static final String TAG = "MyActivity";
    RequestQueue queue;
String URL = "https://newsapi.org/v2/top-headlines?sources=marca&apiKey=7e9737cbf47d498f97dee197078a8257";

List<Model> h = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recy);

        adapter=new Adapter(this,h);

        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setHasFixedSize(true);



        recyclerView.setAdapter(adapter);

        queue=NetworkController.getInstance(this).getRequestQueue();




        JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.GET,URL,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("articles");

                    for ( i = 0 ; i< jsonArray.length();i++){

                        JSONObject all= jsonArray.getJSONObject(i);

                 //      Model model = new Model(all.getString("title"),all.getString("description"),all.getString("urlToImage"));


                        String tit =all.getString("title");
                        String desc =all.getString("description");
                        String img =all.getString("urlToImage");
                        Model model = new Model(tit,desc,img);
                        h.add(model);
                      //  Log.d(TAG, String.valueOf(list.get(1)));

                        Log.d(TAG,tit);



                        adapter.notifyItemChanged(i);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());

                } finally {
                    adapter.notifyItemChanged(i);

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println(error.getMessage());

            }
        });

        queue.add(objectRequest);


    }
}
