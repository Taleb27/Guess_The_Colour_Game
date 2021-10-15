package y2020.aoc.bayan.taleb;


import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

        TextView TextViewWelcom;
        Button buttonback;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);

            TextViewWelcom = findViewById(R.id.TextViewWelcome);
            buttonback = findViewById(R.id.buttonback);
            String name = getIntent().getStringExtra("name");
            TextViewWelcom.setText("welcome"+name);


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
}

