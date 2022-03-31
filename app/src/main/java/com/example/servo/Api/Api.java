package com.example.servo.Api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("student/signup")
    Call<ResponseBody> createStudent(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password2") String password2,
            @Field("contact_number") String contact_number,
            @Field("roll_number") String roll_number,
            @Field("room_number") String room_number
    );


}
