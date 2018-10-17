package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AddressActivity extends AppCompatActivity {

    Button btnAddressNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_address);
        setTitle("Location Information");

        init();

        //next to mobile number verify activity
        btnAddressNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddressActivity.this, NumberVerifyActivity.class);
                startActivity(intent);
            }
        });


    }

    private void init() {
        btnAddressNext = (Button) findViewById(R.id.btnAddressNext);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
