package com.example.sveng.ereigniss;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button gutButton;
    private Button schlechtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gutButton = (Button) findViewById(R.id.gutButton);
        gutButton.setOnClickListener(this);
        schlechtButton = (Button) findViewById(R.id.schlechtButton);
        schlechtButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.gutButton) {
            Toast.makeText(getApplicationContext(), "Das freut uns!",
                    Toast.LENGTH_LONG).show();

        }
        if(view.getId() == R.id.schlechtButton) {
            Toast.makeText(getApplicationContext(), "Das ist schade!",
                    Toast.LENGTH_LONG).show();
        }
    }
}