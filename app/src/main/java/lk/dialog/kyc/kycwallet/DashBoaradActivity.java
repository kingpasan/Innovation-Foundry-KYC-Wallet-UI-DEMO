package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DashBoaradActivity extends AppCompatActivity {

    Button settings;
    Button test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        init();

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoaradActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoaradActivity.this, AppCompatPreferenceActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init(){
        settings = (Button)findViewById(R.id.btn_dashboard);
        test = (Button)findViewById(R.id.button30);
    }
}
