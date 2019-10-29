package com.example.cncarroyo.serviciosretrofit.Retrofit.Request;

/**
 * Created by cncarroyo on 29/10/2019.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* Archivo para invio de informacion de login */
    public class RequestLogin {

        /*@SerializedName se utiliza para asignar el nombre del atrubuto json real  en caso que el
        atrubuto java tenga nombre diferente
         */

        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("password")
        @Expose
        private String password;

        /**
         * No args constructor for use in serialization
         *
         */
        public RequestLogin() {
        }

        /**
         *
         * @param password
         * @param email
         */
        public RequestLogin(String email, String password) {
            super();
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

