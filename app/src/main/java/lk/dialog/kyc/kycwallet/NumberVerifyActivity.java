package lk.dialog.kyc.kycwallet;

import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NumberVerifyActivity extends AppCompatActivity {

    private String authMethod;
    Button btnVerify;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_verify);

        SharedPreferences.Editor editor = getSharedPreferences("Registration", MODE_PRIVATE).edit();
        editor.putString("RegistrationStatus", "success");
        editor.apply();

        init();

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NumberVerifyActivity.this, DashBoaradActivity.class);
                startActivity(intent);
            }
        });
    }



    private void init(){
        btnVerify = (Button) findViewById(R.id.btnVerify);
    }
}
