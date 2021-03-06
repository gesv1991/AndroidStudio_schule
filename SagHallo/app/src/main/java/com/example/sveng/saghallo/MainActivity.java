package com.example.sveng.saghallo;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener, View.OnClickListener{

    private TextToSpeech tts;
    private RadioGroup radioLanguage;
    private Button speakButton;
    //   private RadioButton radioButton;
    //   private EditText editText;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int i) {
        radioLanguage = (RadioGroup) findViewById(R.id.radioLanguage) ;
        speakButton = (Button) findViewById(R.id.speakButton);
        speakButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        RadioButton selectedId = (RadioButton) radioLanguage.findViewById(radioLanguage.getCheckedRadioButtonId());
        EditText editText = (EditText)findViewById(R.id.speakText);

        Log.i("what", String.valueOf(speakButton));

        if(findViewById(R.id.radioDE)==selectedId){
            Log.i("deutsch", "Deutsch");
            tts.setLanguage(Locale.GERMAN);
            text = editText.getText().toString();
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
        else{
            Log.i("english", "English Else");
            tts.setLanguage(Locale.ENGLISH);
            text = editText.getText().toString();
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}