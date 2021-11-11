package y2020.aoc.bayan.taleb;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Sign_Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "FIREBASE";
    private FirebaseAuth mAuth;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private Button signUpButton;
    private EditText editTextUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_);
        mAuth = FirebaseAuth.getInstance();
            editTextEmail = findViewById(R.id.textEmail);
            editTextPassword = findViewById(R.id.textPass);
            editTextUsername = findViewById(R.id.textUsername);
            signUpButton = findViewById(R.id.ButtonSign);
            signUpButton.setOnClickListener(this);
            SharedPreferences sp= getSharedPreferences("setting",MODE_PRIVATE);
            String email = sp.getString("email", "");
            String password =sp.getString("password","");
            if (!email.equals("")&& !password.equals("")){
                editTextEmail.setText(email);
                editTextPassword.setText(password);

            }

    }


    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(editTextUsername)) {
            Toast t = Toast.makeText(this, "You must enter Username to register!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmail(editTextEmail) == false) {
            editTextEmail.setError("Enter valid email!");
        }

    }


    public void signup(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(Sign_Activity.this, WelcomeActivity.class);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Sign_Activity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    @Override
    public void onClick(View v) {
        signup(editTextEmail.getText().toString(), editTextPassword.getText().toString());
        welcomeActivity();
    }

    private void welcomeActivity() {
        Intent intent= new Intent(Sign_Activity.this, WelcomeActivity.class);
        startActivity(intent);
    }

}