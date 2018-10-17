package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PersonActivity extends AppCompatActivity {

    Button btnPersonNext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_person);
        setTitle("Personal Information");

        init();

        //user clicks on person next button
        btnPersonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonActivity.this, AddressActivity.class);
                startActivity(intent);
            }
        });
    }





    private void init(){
        btnPersonNext = (Button) findViewById(R.id.btnPersonNext);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(PersonActivity.this, AuthSelectionActivity.class);
        startActivity(intent);
        return true;
    }
}
