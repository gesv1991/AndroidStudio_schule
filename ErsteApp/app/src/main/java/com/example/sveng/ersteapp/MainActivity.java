package com.example.sveng.ersteapp;

import android.media.AudioManager;
import android.media.MediaRouter;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
private TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int i){

        tts.setLanguage(new Locale("es", "ES"));

        tts.speak("Quiero saber si se aplica el idioma correcto. No importa como", TextToSpeech.QUEUE_ADD, null);
        //       tts.setAudioAttributes(AUDIO_SERVICE, );
   //     setVolumeControlStream(AudioManager.STREAM_MUSIC);

/*
        tts.setLanguage(Locale.GERMAN);
        tts.speak("Dave du homo", TextToSpeech.QUEUE_FLUSH, null);

        */
    }
}
