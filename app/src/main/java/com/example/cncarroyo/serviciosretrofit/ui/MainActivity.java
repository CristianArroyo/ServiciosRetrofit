package com.example.cncarroyo.serviciosretrofit.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cncarroyo.serviciosretrofit.DashBoardActivity;
import com.example.cncarroyo.serviciosretrofit.MTWClient;
import com.example.cncarroyo.serviciosretrofit.R;
import com.example.cncarroyo.serviciosretrofit.Retrofit.MTWServices;
import com.example.cncarroyo.serviciosretrofit.Retrofit.Request.RequestLogin;
import com.example.cncarroyo.serviciosretrofit.Retrofit.Response.ResponseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   //Definicion de componentes
    EditText edEmail;
    EditText edPassword;
    Button   btnLogin;

   //Se realiza el llamdo al client y services
    MTWClient mtwClient;
    MTWServices mtwServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitInit();
        findViews();


     //Eventos click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //asigna valor de los editext a variables
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();

                //evalua si las casillas tienen informacion
               if (email.isEmpty()){

                    edEmail.setError("Ingrese Email");

               }else if (password.isEmpty()){

                    edPassword.setError("Ingrese Password");
               }else {

                   // Instancia de llamada para login ingresando como parametro email y password
                   RequestLogin requestLogin = new RequestLogin(email,password);

                   // llamada al servicio realizar login entragando parametro requestLogin este
                   // espera de respuesta datos tipo responseAuth.
                   Call<ResponseAuth> call = mtwServices.realizarLogin(requestLogin);

                   //Manejo del calback de respuesta
                   call.enqueue(new Callback<ResponseAuth>() {
                       @Override
                       public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {

                           //la respuesta esta entre cod 200 < 300 , esta sera correcta
                            if (response.isSuccessful()){

                                 Toast.makeText(getApplicationContext(),"Sesion iniciada correctamente",Toast.LENGTH_LONG).show();

                                 //con el login ingresado correctamente se redirige a la activity DashBoard
                                 Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
                                 startActivity(intent);

                                 finish();

                            }else {

                                   //login no es correcto se desplegara excepcion en pantalla
                                  Toast.makeText(getApplicationContext(),"error al ingresar, revise sus datos",Toast.LENGTH_LONG).show();

                            }

                       }

                       @Override
                       public void onFailure(Call<ResponseAuth> call, Throwable t) {

                           Toast.makeText(getApplicationContext(),"No Conectado",Toast.LENGTH_LONG).show();

                       }
                   });

               }


            }
        });


    }


    //Metodo que implementa las instancias y servicios para la conexion
    private void retrofitInit(){
        mtwClient = MTWClient.getInstance();
        mtwServices = mtwClient.getMtwServices();
    }

     private void findViews(){

         edEmail    = (EditText) findViewById(R.id.edEmail);
         edPassword = (EditText) findViewById(R.id.edPassword);
         btnLogin   = (Button)   findViewById(R.id.btnLogin);

     }


}
