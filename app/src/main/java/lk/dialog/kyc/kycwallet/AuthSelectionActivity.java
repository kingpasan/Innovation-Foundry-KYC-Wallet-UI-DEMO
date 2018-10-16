package lk.dialog.kyc.kycwallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuthSelectionActivity extends AppCompatActivity {

    Button btnUseFingerPrint, btnUsePasscode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_selection);
        init();

        btnUsePasscode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthSelectionActivity.this, PasscodeActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        btnUseFingerPrint = (Button)findViewById(R.id.btnUseFingerprint);
        btnUsePasscode = (Button)findViewById(R.id.btnUsePasscode);
    }
}
