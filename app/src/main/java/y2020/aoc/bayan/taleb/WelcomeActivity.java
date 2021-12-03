package y2020.aoc.bayan.taleb;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private TextView TextViewWelcom;
        private Button camera;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);
            camera=findViewById(R.id.buttonCamera);
            TextViewWelcom = findViewById(R.id.TextViewWelcome);

            String name = getIntent().getStringExtra("name");
            TextViewWelcom.setText("welcome");

        }@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "settings", Toast.LENGTH_LONG).show();
                break;
            case R.id.extmenu:

                break;
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=  new AlertDialog.Builder(this);
        builder.setMessage("are u sure");
        builder.setCancelable(false);
        builder.setPositiveButton("yes",this);
        builder.setNegativeButton("N0",this);
        AlertDialog dialog= builder.create();
        dialog.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
     if(which== dialog.BUTTON_POSITIVE){
         super.onBackPressed();

         dialog.cancel();
     }
        if(which== dialog.BUTTON_NEGATIVE){

            dialog.cancel();
        }

    }

    public void camera(View view) {
        Intent intent =new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }


}

