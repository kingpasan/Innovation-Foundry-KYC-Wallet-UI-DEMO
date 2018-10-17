package lk.dialog.kyc.kycwallet;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NumberVerifyActivity extends AppCompatActivity {

    //    private String authMethod;
    Button btnVerify;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_number_verify);
        setTitle("Activation");

//        SharedPreferences.Editor editor = getSharedPreferences("Registration", MODE_PRIVATE).edit();
//        editor.putString("RegistrationStatus", "success");
//        editor.apply();

        init();

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NumberVerifyActivity.this, PhotoCaptureActivity.class);
                startActivity(intent);
            }
        });

    }


    private void init() {
        btnVerify = (Button) findViewById(R.id.btnVerify);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
