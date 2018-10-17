package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DashBoaradActivity extends AppCompatActivity {

    private Button btnProfile,btnScore,settings,showQR,showCerti;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        init();

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoaradActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoaradActivity.this, ScoreViewActivity.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoaradActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        showQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoaradActivity.this, QRViewActivity.class);
                startActivity(intent);
            }
        });

        showCerti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoaradActivity.this, CertificateViewActivity.class);
                startActivity(intent);
            }
        });


    }


    private void init() {
        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnScore = (Button) findViewById(R.id.btnScore);
        settings = (Button)findViewById(R.id.btn_settings);
        showQR = (Button) findViewById(R.id.gena_qr);
        showCerti = (Button)findViewById(R.id.certi_view);
    }
}
