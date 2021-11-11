package y2020.aoc.bayan.taleb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    private static final String TAG = "FIREBASE";
    private Button buttonlogin,buttonsignup;
    private EditText editTextName, editTetPassword;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth(return refrence to the instance of the project firebase
        mAuth = FirebaseAuth.getInstance();
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

           // intent.putExtra("name",editTextName.getText().toString());

            login(editTextName.getText().toString(),editTetPassword.getText().toString());



        }
    }

    @Override
    public boolean onLongClick(View v) {
        editTextName.setText("");

        editTetPassword.setText("");
        return true;
    }
    public void login(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }


    public void sign(View view) {
        Intent i = new Intent(MainActivity.this, Sign_Activity.class);
        startActivity(i);
    }
}