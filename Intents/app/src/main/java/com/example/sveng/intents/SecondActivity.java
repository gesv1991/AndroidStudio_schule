package com.example.sveng.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sveng on 12.01.2018.
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private Button startButton;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        startButton = (Button) findViewById(R.id.goToPage3);
        startButton.setOnClickListener(this);

        backButton = (Button) findViewById(R.id.backToPage1);
        backButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.goToPage3) {
            startActivity(new Intent(this, ThirdActivity.class));

        }
        if(view.getId() == R.id.backToPage1) {
            this.finish();

        }
    }
}


