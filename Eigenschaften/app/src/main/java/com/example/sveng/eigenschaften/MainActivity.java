package com.example.sveng.eigenschaften;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.util.Locale;

import static android.os.Build.VERSION.RELEASE;
import static android.os.Build.VERSION.SDK;
import static android.os.Build.VERSION.SDK_INT;
import static android.util.DisplayMetrics.DENSITY_DEVICE_STABLE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startApp();             // Starte die Methode
    }

    public void startApp() {

        TextView tvHeightPx = findViewById(R.id.tvHeightPx);
        TextView tvDensity = findViewById(R.id.tvDensity);
        TextView tvDensityDPI = findViewById(R.id.tvDensityDPI);
        TextView tvWidthPx = findViewById(R.id.tvWidthPx);
        TextView tvLocale = findViewById(R.id.tvLocale);
        TextView tvVersionSdk = findViewById(R.id.tvVersionSdk);
        TextView tvRelease = findViewById(R.id.tvRelease);

       DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        tvDensity.setText(Float.toString(metrics.density));
        tvDensityDPI.setText(Integer.toString(metrics.densityDpi));
        tvHeightPx.setText(Integer.toString(metrics.heightPixels));
        tvWidthPx.setText(Integer.toString(metrics.widthPixels));

        // Locale
        Locale config = getResources().getConfiguration().locale;
        tvLocale.setText(String.valueOf(config));
        tvVersionSdk.setText(Integer.toString(SDK_INT));
        tvRelease.setText(RELEASE);
    }
}
