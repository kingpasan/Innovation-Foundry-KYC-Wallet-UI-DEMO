package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

//    String authMethod =null;
//    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();

//        SharedPreferences prefs = getSharedPreferences("Registration", MODE_PRIVATE);
//        String registrationStatus = prefs.getString("RegistrationStatus", null);
//
//        if(registrationStatus != null && !registrationStatus.isEmpty()){
//
//            authMethod = prefs.getString("AuthMethod", null);
//                if(("fingerprint").equals(authMethod)){
//                     intent = new Intent(SplashActivity.this, FingerprintLoginActivity.class);
//                }else if(("passcode").equals(authMethod)){
//                     intent = new Intent(SplashActivity.this, PasscodeActivity.class);
//                }
//        }else{
//            intent = new Intent(SplashActivity.this, HomeActivity.class);
//        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, 3000);
    }
}
