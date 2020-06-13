package com.example.tpfinal.request;

import android.util.Log;

import com.example.tpfinal.models.Inmueble;
import com.example.tpfinal.models.Propietario;
import com.example.tpfinal.models.TipoInmueble;
import com.example.tpfinal.models.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ApiClient {

    private static final String PATH="http://192.168.0.104:45455/api/";
    private static  MyApiInterface myApiInteface;


    public static MyApiInterface getMyApiClient(){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInteface=retrofit.create(MyApiInterface.class);
        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInteface;
    }


    public interface MyApiInterface {


        //-------------------------------------Propietario------------------------------------------------

         @POST("Propietario/login")
         Call <String> logear(@Body Usuario user);

         @GET("Propietario")
         Call<List<Propietario>> TraerPropietario(@Header("Authorization") String token);

         @PUT("Propietario/actualizar")
         Call<Propietario> ActualizarPropietario(@Header("Authorization") String token,@Body Propietario propietario);


         //---------------------------------Inmuebles------------------------------------------------

         @GET("Inmueble")
         Call<List<Inmueble>> TraerInmuebles(@Header("Authorization") String token);

         @GET("Inmueble/{id}")
         Call<List<Inmueble>> ObtenerInmueble(@Header("Authorization") String token,@Path("id")int id);

         @PUT("Inmueble/{id}")
         Call<Inmueble> ActualizarInmueble(@Header("Authorization") String token, @Path("id") int id, @Body Inmueble i);

         @POST("inmueble")
         Call<Inmueble> CrearInmueble(@Header("Authorization") String token, @Body Inmueble i);

        //-----------------------------------Tipo Inmueble--------------------------------------------

        @GET("TipoInmueble")
        Call<List<TipoInmueble>> TraerTipoInmueble(@Header("Authorization") String token);

        @DELETE("Inmueble/{id}")
        Call<String> borrarInmueble(@Header("Authorization") String token, @Path("id") int id);
    }
}
