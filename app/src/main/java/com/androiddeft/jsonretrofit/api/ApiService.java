package com.androiddeft.jsonretrofit.api;

import com.androiddeft.jsonretrofit.beans.Employee;
import com.androiddeft.jsonretrofit.beans.Request1;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Abhi on 06 Sep 2017 006.
 */

public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of EmployeeList
    */
    @POST("api/V1/Registration")
    Call<Employee> getMyJSON(@Body Request1 loginRequest);
}