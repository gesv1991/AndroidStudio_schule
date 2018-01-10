package com.example.sveng.saghallo;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private RadioGroup radioLanguage;
    private Button speak;
    private RadioButton radioButton;
    private EditText editText;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this, this);

        addListenerOnButton();
    }
    @Override
    public void onInit(int i) {
    }

    public void addListenerOnButton() {


        radioLanguage = (RadioGroup) findViewById(R.id.radioLanguage) ;
        speak = (Button) findViewById(R.id.speakButton);

        speak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int selectedId = radioLanguage.getCheckedRadioButtonId();
                speak = (RadioButton) findViewById(selectedId);
               text = editText.getText().toString();
/*
               if(speak.getText()=="Deutsch"){
                    tts.setLanguage(Locale.GERMAN);

                }
                else{
                    tts.setLanguage(Locale.ENGLISH);
                }*/
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
}


