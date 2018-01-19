package com.example.sveng.mueckenfang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by sveng on 12.01.2018.
 */

public class GameActivity extends AppCompatActivity {
    private boolean spielLaeuft;
    private int runde;
    private int punkte;
    private int muecken;
    private int gefangeneMuecken;
    private int zeit;
    private float massstab;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        massstab = getResources().getDisplayMetrics().density;
        spielStarten();

    }

    // Ein neues Spiel starten
    // Zweck: .........................
    private void spielStarten() {
        Log.i("spielStartenStart", "spielStarten START");
        boolean spielLaeuft = true;
        runde = 0;		// ...
        punkte = 0;		// ...
        starteRunde();
        Log.i("spielStartenEnd", "spielStarten END");
    }

    // Eine Runde starten
    // Zweck: .........................
    private void starteRunde()    {
        Log.i("starteRundeStart", "starteRunde START");
        runde = runde + 1;		// ...
        muecken = runde * 10;	// ...
        gefangeneMuecken = 05;	// ...
        zeit = 60;	// ...
        bildschirmAktualisieren();
        Log.i("starteRundeEnd", "starteRunde END");
    }

    private void bildschirmAktualisieren()
    {
        TextView tvPunkte = (TextView) findViewById(R.id.points);
        tvPunkte.setText(Integer.toString(punkte));

        TextView tvRunde = (TextView) findViewById(R.id.round);
        tvRunde.setText(Integer.toString(runde));

        TextView tvMuecke = (TextView) findViewById(R.id.hits);
        tvMuecke.setText(Integer.toString(gefangeneMuecken));

        TextView tvZeit = (TextView) findViewById(R.id.time);
        tvZeit.setText(Integer.toString(zeit));

        FrameLayout flTreffer = (FrameLayout) findViewById(R.id.bar_hits);
        FrameLayout flZeit = (FrameLayout) findViewById(R.id.bar_time);

        ViewGroup.LayoutParams lpTreffer = flTreffer.getLayoutParams();

        //Breite wird auf einen geeigneten Wert geändert.
        lpTreffer.width = Math.round(massstab * 300 * Math.min(gefangeneMuecken,muecken) /muecken);

        ViewGroup.LayoutParams lpZeit = flZeit.getLayoutParams();
        lpZeit.width = Math.round(massstab * zeit * 300 / 60);

        // wird später programmiert
    }

}
