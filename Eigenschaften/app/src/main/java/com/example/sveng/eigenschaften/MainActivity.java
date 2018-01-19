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

        startApp();
    }

    public void startApp() {


    }
}
