package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DashBoaradActivity extends AppCompatActivity {

    private Button btnProfile,btnScore;

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

    }


    private void init() {
        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnScore = (Button) findViewById(R.id.btnScore);
    }
}
