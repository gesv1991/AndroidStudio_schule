package com.example.sveng.eigenschaften;

import android.annotation.TargetApi;
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

    private float tdensity;
    private String tdensityDPI;
    private float theightPX;
    private int twidthPX;
    private int tmassstab;
    private String tlocale;
    private float treleaseVers;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startApp();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startApp() {

        DisplayMetrics metrics = new DisplayMetrics();
        TextView tvDensity = findViewById(R.id.tvDensity);
        TextView tvDensityDPI = findViewById(R.id.tvDensityDPI);
        TextView tvHeightPx = findViewById(R.id.tvHeightPx);
        TextView tvWidthPx = findViewById(R.id.tvWidthPx);
        TextView tvLocale = findViewById(R.id.tvLocale);
        TextView tvVersionSdk = findViewById(R.id.tvVersionSdk);
        TextView tvRelease = findViewById(R.id.tvRelease);

        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        tvDensity.setText(Float.toString(metrics.density));
        tvDensityDPI.setText(Integer.toString(metrics.densityDpi));
        tvHeightPx.setText(Integer.toString(metrics.heightPixels));
        tvWidthPx.setText(Integer.toString(metrics.widthPixels));


        tvVersionSdk.setText(Integer.toString(SDK_INT));
        tvRelease.setText(RELEASE);


  /*      Locale aLocale = new Locale.Builder().setLanguage("sr").setScript("Latn").setRegion("RS").build();
        Locale.Builder lB = new Locale.Builder();

        tvLocale.setText((lB.getClass().getCountry()+" " +aLocale.getDisplayLanguage()));

        aLocale.getLanguage();

*/

    }
}
