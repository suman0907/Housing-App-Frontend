package com.example.sumansinghrajput.dreamtreasure;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Suman Singh Rajput on 23-03-2018.
 */

public interface AddAPI {
    @POST("{endPoint}")
    Call<PostAPIResponse> getData(@Path("endPoint") String endPoint, @Body AddModel info);
}
