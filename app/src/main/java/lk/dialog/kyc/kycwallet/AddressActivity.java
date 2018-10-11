package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AddressActivity extends AppCompatActivity {

    Button btnAddressBack, btnAddressNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        init();

        //back to person activity
        btnAddressBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressActivity.this, PersonActivity.class);
                startActivity(intent);
            }
        });

        //next to mobile number verify activity
        btnAddressNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddressActivity.this, NumberVerifyActivity.class);
                startActivity(intent);
            }
        });


    }

    private void init(){
        btnAddressBack = (Button) findViewById(R.id.btnAddressBack);
        btnAddressNext = (Button) findViewById(R.id.btnAddressNext);
    }
}
