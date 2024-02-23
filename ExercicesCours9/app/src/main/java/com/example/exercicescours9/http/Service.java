package com.example.exercicescours9.http;


import com.example.exercicescours9.transfer.objComplexe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface Service {

    @GET("exos/{long}/list")
    Call<List<Long>> listLong(@Path("long") String strLong);

    @GET("exos/{truc}/list")
    Call<List<objComplexe>> listObj(@Path("truc") String StrObj);
}
