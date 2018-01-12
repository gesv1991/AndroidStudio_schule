package com.example.sveng.intents;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.goToPage2);


        startButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        startActivity(new Intent(this, SecondActivity.class));
    }

}

