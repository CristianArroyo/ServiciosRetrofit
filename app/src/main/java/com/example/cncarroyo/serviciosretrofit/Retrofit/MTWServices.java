package com.example.cncarroyo.serviciosretrofit.Retrofit;

import com.example.cncarroyo.serviciosretrofit.Retrofit.Request.RequestLogin;
import com.example.cncarroyo.serviciosretrofit.Retrofit.Request.RequestSignup;
import com.example.cncarroyo.serviciosretrofit.Retrofit.Response.ResponseAuth;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by cncarroyo on 29/10/2019.
 */

public interface MTWServices {

    /* Peticion de login
       -peticion de tipo @Post,se designa endpoint de metodo al cual realizaremos la peticion
       -se crea metodo realizarlogin, Call indica que este sera asyncrono enviara en el @Body
        los atributos de la clase RequestLogin y esperara como respuesta los atributos definidos
        en la clase ResponseAuth
     */
    @POST("auth/login")
    Call<ResponseAuth>realizarLogin(@Body RequestLogin requestLogin);


    /* Peticion de Signup
       -peticion de tipo @Post, se designa endpoint de metodo al cual realizaremos la peticion
       -se crea metodo realizarSignup, Call indica que sera asyncrono enviara en el @Body los
        atributos de la clase RequestSingnup y esperara como respuesta los atributos definidos
        en la clase ReesponseAuth
     */
    @POST("auth/signup")
    Call<ResponseAuth> realizarSignup(@Body RequestSignup requestSignup);

}
