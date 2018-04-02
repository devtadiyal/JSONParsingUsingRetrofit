package com.androiddeft.jsonretrofit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androiddeft.jsonretrofit.api.ApiService;
import com.androiddeft.jsonretrofit.beans.Employee;
import com.androiddeft.jsonretrofit.beans.Request1;
import com.androiddeft.jsonretrofit.helper.RetroClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Request1 loginRequest;
    //private ArrayList<Employee> employeeList;
    private Employee employeeList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private EmployeesAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginRequest=new Request1();


        //Hardcodede value pass in api
        loginRequest.password="123456@sD";
        loginRequest.email="dst@gmail.com";
        loginRequest.firstName="dev";
        loginRequest.lastName="tadiyal";
        loginRequest.phone=(long) 999066299;
        loginRequest.socialID=1;

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<Employee> call = api.getMyJSON(loginRequest);

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    employeeList = response.body();
                    Log.e("Res...",""+employeeList.getMessage()+" ");
                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    //eAdapter = new EmployeesAdapter(employeeList);
                  /*  RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);*/
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
}
