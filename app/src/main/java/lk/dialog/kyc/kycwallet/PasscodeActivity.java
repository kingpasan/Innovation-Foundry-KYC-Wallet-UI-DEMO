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

public class PasscodeActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_passcode);

        PasscodeView passcodeView = (PasscodeView) findViewById(R.id.passcodeView);
        passcodeView.setListener(new PasscodeView.PasscodeViewListener() {
            @Override
            public void onFail() {
                Toast.makeText(getApplication(), "Passcode Registration Failed.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String passcode) {
                Toast.makeText(getApplication(), "Passcode Registered Successfully.", Toast.LENGTH_SHORT).show();

                SharedPreferences.Editor editor = getSharedPreferences("Registration", MODE_PRIVATE).edit();
                editor.putString("AuthMethod", "passcode");
                editor.putString("Passcode", passcode);
                editor.apply();

                Intent intent = new Intent(PasscodeActivity.this, PersonActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
