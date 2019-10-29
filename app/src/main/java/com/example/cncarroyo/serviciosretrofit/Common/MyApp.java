package com.example.cncarroyo.serviciosretrofit.Common;

import android.app.Application;
import android.content.Context;

/**
 * Created by cncarroyo on 29/10/2019.
 */

public class MyApp extends Application {


    private static MyApp instance;

    //Metodo que devolvera la instancia de la aplicacion
    public static MyApp getInstance(){

        return  instance;

    }

   //Metodo que devolvera la instancia de la palicacion
    public static Context getContext(){

        return instance;

    }

   //Metodo que se craera solo una vez en la aplicacion
   //para asignar este metodo se debe integrar en el manifest en la etiqueta <aplication> android:name="Common.MyApp"
    @Override
    public  void onCreate(){
        instance = this;
        super.onCreate();
    }

}
