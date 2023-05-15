package com.example.playmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;


    MediaPlayer vectormp [] = new MediaPlayer[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button)findViewById(R.id.btnreproducir);
        btn_repetir = (Button)findViewById(R.id.btnrepetir);
        iv = (ImageView)findViewById(R.id.portada1);

        //Lista canciones a reproducir emn la carpeta raw
        vectormp[0] = MediaPlayer.create(this,R.raw.izalco);
        vectormp[1] = MediaPlayer.create(this,R.raw.breakfast);
        vectormp[2] = MediaPlayer.create(this,R.raw.midnigtbells);
        vectormp[3] = MediaPlayer.create(this,R.raw.tuna);
    }
    //Metodo para el Botton PlayPausa
    public void PlayPause (View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this,"Pausa", Toast.LENGTH_SHORT).show();
        }else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Play", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para el Botton Stop
    public void Stop(View view){
        if(vectormp[posicion]!= null){
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this,R.raw.izalco);
            vectormp[1] = MediaPlayer.create(this,R.raw.breakfast);
            vectormp[2] = MediaPlayer.create(this,R.raw.midnigtbells);
            vectormp[3] = MediaPlayer.create(this,R.raw.tuna);

            posicion =0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this,"Stop", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para el Botton Repetir una Pista
    public void Repetir(View view){
        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    //Metodo para Saltar Siguiente Cancion
    public void Siguiente(View view){
        if (posicion < vectormp.length -1){

            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if (posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                } else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                } else if (posicion == 3){
                    iv.setImageResource(R.drawable.portada4);
                }

            } else {
                posicion++;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                }else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if (posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                } else if (posicion == 3){
                    iv.setImageResource(R.drawable.portada4);
                }
            }

        } else {
            Toast.makeText(this,"No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para Regresar a la Canción Anterior
    public void Anterior(View view){
        if(posicion >= 1){

            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this,R.raw.izalco);
                vectormp[1] = MediaPlayer.create(this,R.raw.breakfast);
                vectormp[2] = MediaPlayer.create(this,R.raw.midnigtbells);
                vectormp[3] = MediaPlayer.create(this,R.raw.tuna);
                posicion--;

                if (posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                } else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                } else if (posicion == 3){
                    iv.setImageResource(R.drawable.portada4);
                }

                vectormp[posicion].start();

            } else {
                posicion--;

                if (posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if (posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                } else if (posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                } else if (posicion == 3){
                    iv.setImageResource(R.drawable.portada4);
                }
            }

        } else {
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }

}