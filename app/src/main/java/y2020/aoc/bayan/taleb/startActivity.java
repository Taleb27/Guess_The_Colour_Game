package y2020.aoc.bayan.taleb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startActivity extends AppCompatActivity  {
    private Button buttonGuess,buttonMath,buttonSettings,buttonAbout,buttonExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        buttonGuess = findViewById(R.id.Btnguess);
        buttonMath = findViewById(R.id.BtnMath);
        buttonSettings = findViewById(R.id.BtnSettings);
        buttonAbout = findViewById(R.id.BtnAbout);
        buttonExit = findViewById(R.id.BtnExit);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void sign(View view) {
        Intent i = new Intent(startActivity.this, GuessActivity.class);
        startActivity(i);
    }
    public void sign(View view) {
        Intent i = new Intent(startActivity.this, Math_Activity.class);
        startActivity(i);
    }
    public void sign(View view) {
        Intent i = new Intent(startActivity.this, Settings_Activity.class);
        startActivity(i);
    }
    public void sign(View view) {
        Intent i = new Intent(startActivity.this, AboutGame_Activity.class);
        startActivity(i);
    }

}