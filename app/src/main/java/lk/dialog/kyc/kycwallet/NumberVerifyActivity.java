package lk.dialog.kyc.kycwallet;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class NumberVerifyActivity extends AppCompatActivity {

    private String authMethod;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_verify);

        SharedPreferences.Editor editor = getSharedPreferences("Registration", MODE_PRIVATE).edit();
        editor.putString("RegistrationStatus", "success");
        editor.apply();
    }
}
