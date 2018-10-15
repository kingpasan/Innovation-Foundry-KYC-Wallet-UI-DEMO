package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NumberVerifyActivity extends AppCompatActivity {

    Button btnVerify;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_verify);

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
