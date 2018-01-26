package com.example.sveng.mueckenfang;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;

/**
 * Created by sveng on 12.01.2018.
 */

public class GameActivity extends AppCompatActivity implements View.OnClickListener, Runnable{
    private boolean spielLaeuft;
    private int runde;
    private int punkte;
    private int muecken;
    private int gefangeneMuecken;
    private int zeit;
    private float massstab;
    private Random zufallsgenerator = new Random();
    private ViewGroup spielbereich;
    private static final long HOECHSTALTER_MS = 200;
    private Handler handler = new Handler();
    private MediaPlayer mp;
    private MediaPlayer mpcrush;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        massstab = getResources().getDisplayMetrics().density;
        mp = MediaPlayer.create(this, R.raw.muecke);
        mpcrush = MediaPlayer.create(this, R.raw.crush2);

        spielStarten();
        spielbereich = (ViewGroup)findViewById(R.id.spielbereich);
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
        gefangeneMuecken = 0;	// ...
        zeit = 60;	// ...
        bildschirmAktualisieren();
        handler.postDelayed(this, 1000);
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
    }

    public void run() {
        zeitHerunterzaehlen();
    }

    private void zeitHerunterzaehlen() {
        zeit = zeit - 1;
        float zufallszahl = zufallsgenerator.nextFloat();
        double wahrscheinlichkeit = muecken * 1.5;
        if ( wahrscheinlichkeit > 1) {
            eineMueckeAnzeigen();
            if (zufallszahl < wahrscheinlichkeit -1 )
            {
                eineMueckeAnzeigen();
            }
        } else {
            if (zufallszahl < wahrscheinlichkeit) {
                eineMueckeAnzeigen();
            }
        }
        bildschirmAktualisieren();
        mueckenVerschwinden();

        if (!pruefeSpielEnde()) {
            if (!pruefeRundenende())
            {
                handler.postDelayed(this, 1000);
            }
        }
    }

    private boolean pruefeRundenende() {
        if (gefangeneMuecken >= muecken) {
            starteRunde();
            return true;
        }
        return false;
    }

    private boolean pruefeSpielEnde() {
        if (zeit == 0 && gefangeneMuecken < muecken) {
            gameOver();
            return true;
        }
        return false;
    }

    private void mueckenVerschwinden() {
        int nummer = 0;
        //Zählt die "Kinder" auf dem spielbereich Element.
        while (nummer < spielbereich.getChildCount()) {
            ImageView muecke = (ImageView) spielbereich.getChildAt(nummer);
            Date geburtsdatum = (Date)muecke.getTag(R.id.geburtsdatum);
            long alter = (new Date()).getTime() - geburtsdatum.getTime();
            if (alter > HOECHSTALTER_MS) {
                spielbereich.removeView(muecke);
            } else {
                nummer++;
            }
            mpcrush.start();
            if (mpcrush.isPlaying()){
     //           mpcrush.pause();
            }
            mpcrush.seekTo(0);
            mpcrush.start();

        }
    }

    private void eineMueckeAnzeigen() {
        int hoehe = spielbereich.getWidth();
        int breite = spielbereich.getHeight();
        int muecke_breite = (int) Math.round(massstab*50);
        int muecke_hoehe = (int) Math.round(massstab*42);
        int links = zufallsgenerator.nextInt(breite-muecke_breite);
        int oben = zufallsgenerator.nextInt(hoehe-muecke_hoehe);


        ImageView muecke = new ImageView(this);
        muecke.setImageResource(R.drawable.muecke);
        muecke.setTag(R.id.geburtsdatum, new Date());
        muecke.setOnClickListener(this);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(muecke_breite, muecke_hoehe);
        params.leftMargin = links;
        params.topMargin = oben;
        params.gravity = Gravity.TOP + Gravity.LEFT;
        spielbereich.addView(muecke,params);
 //             mp.start();
        if(mp.isPlaying()){
   //         mp.pause();
        }
        mp.seekTo(0);
  //          mp.start();
        mpcrush.pause();

    }
    @Override
    public void onDestroy(){
        mp.release();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        gefangeneMuecken++;
        punkte += 100;
        bildschirmAktualisieren();
        spielbereich.removeView(v);
        mp.pause();

    }
    private void gameOver() {
        Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.activity_gameover);
        dialog.show();
        spielLaeuft = false;
    }
}
