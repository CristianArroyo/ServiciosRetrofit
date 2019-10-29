package com.example.cncarroyo.serviciosretrofit;

import com.example.cncarroyo.serviciosretrofit.Common.Constantes;
import com.example.cncarroyo.serviciosretrofit.Retrofit.MTWServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cncarroyo on 29/10/2019.
 */

public class MTWClient {

    // Se crea instancia de clase como null
    private static MTWClient instance = null;

    // Se crea instancia de interface MTWServices
    private MTWServices mtwServices;

    // Instanciamos retrofit para poder realizar conexion Singleton
    private Retrofit retrofit;

    // Constructor de clase con definicion de patron sigleton
    public MTWClient() {

        retrofit = new Retrofit.Builder()
                 //URL Base al que se realizara la conexion
                .baseUrl(Constantes.MTW_BASE_URL)
                 // los datos seran convertidos a gson por medio de GsonConverterFactory
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         // Se genera la instancia de la clase con los parametros dados
         mtwServices = retrofit.create(MTWServices.class);
    }

    //Patron Singleton
    public static MTWClient getInstance(){

        // si la instancia es nula devuelve una instancia
        if(instance == null) {
            instance = new MTWClient();
        }
        //si no es nula trabaja con la instancia hayada
        return instance;
    }


    // nos permite consumir los servicios desde la API
    public MTWServices getMtwServices(){

        return mtwServices;

    }
}
