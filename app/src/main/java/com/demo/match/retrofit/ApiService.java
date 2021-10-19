package com.demo.match.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

  @GET("sapk01222019186652.json")
  Call<ResponseBody> getMatchDetails();
}
