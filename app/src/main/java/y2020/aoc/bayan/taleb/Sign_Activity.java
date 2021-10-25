package y2020.aoc.bayan.taleb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;

import java.net.PasswordAuthentication;

public class Sign_Activity extends AppCompatActivity {
    private String Username;
    private int PersonNum;
    private String email;
    private String Pass;
    private String RePass;
    private String City;
    private int age;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_);
    }
}
