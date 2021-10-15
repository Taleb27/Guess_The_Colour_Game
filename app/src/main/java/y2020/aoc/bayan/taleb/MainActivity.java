package y2020.aoc.bayan.taleb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener  {

    private Button buttonlogin;
    private EditText editTextName, editTetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTetPassword = findViewById(R.id.editTextPassword);
        buttonlogin = findViewById(R.id.buttonlogin);
        //sets the required button to response to long click
        buttonlogin.setOnLongClickListener(this);

        SharedPreferences Settings = getSharedPreferences("Settings",MODE_PRIVATE);
        String email = Settings.getString("editTextName", "");
        String password = Settings.getString("editTetPassword", "");
        if(!email.equals("")&& !password.equals("")){
            editTextName.setText(email);
            editTetPassword.setText(password);
        }


    }

    public void login(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        if (!editTextName.getText().toString().equals("")) {
            //create sp file
            SharedPreferences Settings = getSharedPreferences("settings",MODE_PRIVATE);
            // open editor for edititng
            SharedPreferences.Editor editor= Settings.edit();
           //write the wanted settings
            editor.putString("editTextName",editTextName.getText().toString());
            editor.putString("editTextPassword",editTextName.getText().toString());
           //save and close file
            editor.commit();


            intent.putExtra("name",editTextName.getText().toString());
            startActivity(intent);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        editTextName.setText("");

        editTetPassword.setText("");
        return true;
    }
}