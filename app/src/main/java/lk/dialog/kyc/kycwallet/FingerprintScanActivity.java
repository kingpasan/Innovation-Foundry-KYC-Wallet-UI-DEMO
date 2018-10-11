package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FingerprintScanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint_scan);

        Handler handler =  new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FingerprintScanActivity.this, FingerprintConfirmActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
