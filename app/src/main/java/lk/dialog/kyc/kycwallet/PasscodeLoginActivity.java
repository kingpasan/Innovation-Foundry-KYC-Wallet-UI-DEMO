package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hanks.passcodeview.PasscodeView;

public class PasscodeLoginActivity extends AppCompatActivity {

    private String loginPass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_passcode_login);

        SharedPreferences prefs = getSharedPreferences("Registration", MODE_PRIVATE);
        String loginPasscode = prefs.getString("Passcode", null);

        if(loginPasscode != null && !loginPasscode.isEmpty()){
            this.loginPass = loginPasscode;
        }else{
            Toast.makeText(getApplication(), "Please set a new Passcode before Logging.", Toast.LENGTH_LONG).show();
            Intent i = new Intent(PasscodeLoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }

        PasscodeView passcodeView = (PasscodeView) findViewById(R.id.passcodeView);
        passcodeView
                .setPasscodeLength(4)
                .setLocalPasscode(loginPass)
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail() {
                        Toast.makeText(getApplication(), "Please Try Again.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String number) {
                        Toast.makeText(getApplication(), "Successfully Logged in.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(PasscodeLoginActivity.this, HomeActivity.class);
                        startActivity(i);
                        finish();
                    }
                });


    }
}
