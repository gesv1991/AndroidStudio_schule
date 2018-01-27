package com.example.sveng.mueckenfang;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton;
    private Button speichern;
    private LinearLayout namenseingabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Start Knopf
        startButton = (Button) findViewById(R.id.button);
        startButton.setOnClickListener(this);

        //Namenseingabe und Highscore
        namenseingabe = (LinearLayout) findViewById(R.id.namenseingabe);
        speichern = (Button) findViewById(R.id.speichern);
        speichern.setOnClickListener(this);

        //schaltet die Namenseingabe auf Unsichtbar.
        namenseingabe.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.button){
            /**
             * Wird ebenfalls für den Highscore benötigt
             */
            startActivityForResult(new Intent(this, GameActivity.class),1);
        }
        else if(view.getId() == R.id.speichern){
            schreibeHighscoreName();
            highscoreAnzeigen();
            namenseingabe.setVisibility(View.INVISIBLE);
        }
    }

    private void schreibeHighscoreName() {
        EditText et = (EditText) findViewById(R.id.spielername);
        String name = et.getText().toString().trim();
        SharedPreferences pref = getSharedPreferences("GAME", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("HIGHSCORE_NAME", name);
        editor.commit();                //commit() schreibt die Werte in den Speicher und schliesst den Editor.
    }

    private String leseHighscoreName(){
        SharedPreferences pref = getSharedPreferences("GAME", 0);
        return pref.getString("HIGHSCORE_NAME", "");
    }

    private void highscoreAnzeigen(){
        int highscore = leseHighscore();
        TextView tv = (TextView) findViewById(R.id.highscore);
        if (highscore>0){
            tv.setText(Integer.toString(highscore)+ " von " + leseHighscoreName());
        }
        else {
            tv.setText("-");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView tv = (TextView) findViewById(R.id.highscore);
        tv.setText(Integer.toString(leseHighscore()));
        highscoreAnzeigen();
    }

    private int leseHighscore() {
        SharedPreferences pref = getSharedPreferences("GAME", 0);
        return pref.getInt("HIGHSCORE", 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode> leseHighscore()){
                schreibeHighscore(resultCode);
                namenseingabe.setVisibility(View.VISIBLE);
            }
        }
    }

    private void schreibeHighscore(int highscore) {
        SharedPreferences pref = getSharedPreferences("GAME", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("HIGHSCORE", highscore);
        editor.commit();
    }
}