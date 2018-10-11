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
        setContentView(R.layout.activity_person);

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
}
