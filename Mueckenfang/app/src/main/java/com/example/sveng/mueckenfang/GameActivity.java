package com.example.sveng.mueckenfang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
    }

    // Ein neues Spiel starten
    // Zweck: .........................
    private void spielStarten() {
        boolean spielLaeuft = true;
        runde = 0;		// ...
        punkte = 0;		// ...
        starteRunde();
    }

    // Eine Runde starten
    // Zweck: .........................
    private void starteRunde()
    {
        runde = runde + 1;		// ...
        muecken = runde * 10;	// ...
        gefangeneMuecken = 0;	// ...
        zeit = 60;	// ...
        bildschirmAktualisieren();
    }

    private void bildschirmAktualisieren()
    {
        // wird später programmiert
    }

}
