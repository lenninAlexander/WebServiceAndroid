package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.example.entities.Pokemon;
import com.example.services.PokemonService;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        Button btn = findViewById(R.id.RegistrarPokemon);
        EditText txtNombre = findViewById(R.id.txtNombre);
        EditText txtTipo = findViewById(R.id.txttipo);
        EditText txtUrl = findViewById(R.id.txtUrl);
        EditText txtLat = findViewById(R.id.txtLatitud);
        EditText txtLng = findViewById(R.id.txtLongitud);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);


         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String  nombre = txtNombre.getText().toString();
                 String tipo = txtTipo.getText().toString();
                 String url = txtUrl.getText().toString();
                 double lat = txtLat.getTextSize();
                 double lng = txtLng.getTextSize();
                 Pokemon pokemon = new Pokemon(nombre,tipo,url,lat,lng);
                 Call<Void> pokemoncall =  service.testPost(pokemon);
                 pokemoncall.enqueue(new Callback<Void>(){
                     @Override
                     public void onResponse (Call<Void> call , Response<Void> response)
                     {
                         Log.i("MAIN APP", "Es" +nombre);
                     }

                     @Override
                     public void onFailure(Call<Void> call, Throwable t) {

                     }
                 });
             }
         });
    }
}