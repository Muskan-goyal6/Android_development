package com.example.muskangoyal.okhttpgithub;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Button b;
    RecyclerView recyclerView;
    EditText et1;
    public static final String TAG = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        et1= findViewById(R.id.et1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeNetworkCall("https://api.github.com/search/users?q="+et1.getText().toString());
            }
        });
    }

    public void makeNetworkCall(String url) {
        OkHttpClient client = new OkHttpClient();
        final RecyclerView recyclerView= findViewById(R.id.recyclerView);
       Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //this method runs on background thread not on main thread
                final String result = response.body().string();
                final ArrayList<GithubUser> githubUsers = parseJson(result);

                // to implement gson we made apiresult class --- if we use gson no need to parseJson placed at 1
                Gson gson = new Gson();
                final ApiResult apiResult= gson.fromJson(result,ApiResult.class);

               // Log.d(TAG,"onPostExecute" +githubUsers.size());
               // Log.d(TAG,"onPostExecute"+githubUsers.get(7).getProfileUrl());


                MainActivity.this.runOnUiThread(new Runnable() {
                    //code here runs on the main thread
                    //with this runnable the okhttp asyncs with UI thread
                    @Override
                    public void run() {
                        //UserAdapter userAdapter = new UserAdapter(apiResult.getItems()); //---to implement gson
                        UserAdapter userAdapter = new UserAdapter(githubUsers);
                        //JavaAdapter javaAdapter = new JavaAdapter(githubUsers);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        recyclerView.setAdapter(userAdapter);
                    }
                });
            }
        });

    }

    public ArrayList<GithubUser> parseJson(String s) {  ////-----1 no need of this method in gson
        //Parse the JSON
        ArrayList<GithubUser> githubUserArrayList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("items");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String login = jsonObj.getString("login");
                String url = jsonObj.getString("html_url");
                String profile = jsonObj.getString("avatar_url");
                String score = jsonObj.getString("score");

                Log.e("TAG", "parseJson: " + login);

                GithubUser githubUser = new GithubUser(login, url, profile, score);
                githubUserArrayList.add(githubUser);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("TAG", "parseJson: " + githubUserArrayList.size());
        return githubUserArrayList;
    }

}
