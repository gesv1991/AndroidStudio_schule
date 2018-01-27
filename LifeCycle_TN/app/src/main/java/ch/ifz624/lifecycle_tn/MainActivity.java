package ch.ifz624.lifecycle_tn;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int zaehler = 0;
    private TextView tvZaehler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvZaehler = (TextView)findViewById(R.id.tvZaehler);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        if (savedInstanceState != null) {
            zaehler = savedInstanceState.getInt("zahl");
            tvZaehler.setText(Integer.toString(zaehler));
            Log.d("restore", "RestoreState");
        }
        Log.d("Test: ", "onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("zahl", zaehler);
        Log.d("SaveInstance", "SaveInstance");
    }

  /*  @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        zaehler = savedInstanceState.getInt("zahl");
        tvZaehler.setText(Integer.toString(zaehler));
    }*/

    @Override
    public void onClick(View v) {
        zaehler++;
        tvZaehler.setText(Integer.toString(zaehler));
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d("Test: ", "onStart");
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.d("Test: ", "onRestart");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d("Test: ", "onResume");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d("Test: ", "onPause");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.d("Test: ", "onStop");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d("Test: ", "onDestroy");
    }


}