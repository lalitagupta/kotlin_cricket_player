package com.demo.shaadi.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

  @GET("api/")
  Call<ResponseBody> getShaadiUsers(@Query("results") String results);
}
