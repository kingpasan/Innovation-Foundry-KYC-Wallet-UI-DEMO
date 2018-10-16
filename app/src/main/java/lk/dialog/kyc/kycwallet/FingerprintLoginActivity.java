package lk.dialog.kyc.kycwallet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kevalpatel2106.fingerprintdialog.AuthenticationCallback;
import com.kevalpatel2106.fingerprintdialog.FingerprintDialogBuilder;
import com.kevalpatel2106.fingerprintdialog.FingerprintUtils;

public class FingerprintLoginActivity extends AppCompatActivity implements AuthenticationCallback {

    private final int show_fingerprint_prompt = 500;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint_login);


        Handler handler = new Handler();

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        final FingerprintDialogBuilder dialogBuilder = new FingerprintDialogBuilder(FingerprintLoginActivity.this)
                .setTitle("Authentication Required")
                .setSubtitle("Verify to Login in to Your Wallet")
                .setDescription("Place Your Finger on the Fingerprint Scanner to Verify Your Identity")
                .setNegativeButton("CANCEL");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialogBuilder.show(getSupportFragmentManager(), callback);
            }
        }, show_fingerprint_prompt);
    }

    final AuthenticationCallback callback = new AuthenticationCallback() {
        @Override
        public void fingerprintAuthenticationNotSupported() {
            Toast.makeText(FingerprintLoginActivity.this,
                    "This Device doesn't support Fingerprint Authentication. Please Use Passcode.", Toast.LENGTH_LONG).show();
            Intent fingerprintNotAvailable = new Intent(FingerprintLoginActivity.this, PasscodeActivity.class);
            startActivity(fingerprintNotAvailable);
            finish();
        }

        @Override
        public void hasNoFingerprintEnrolled() {
            quickVibrate();
            Toast.makeText(FingerprintLoginActivity.this,
                    "No Fingerprints Available on the device. Please Add a new Fingerprint", Toast.LENGTH_LONG).show();
            FingerprintUtils.openSecuritySettings(FingerprintLoginActivity.this);
        }

        @Override
        public void onAuthenticationError(final int errorCode, @Nullable final CharSequence errString) {
            quickVibrate();
            Toast.makeText(FingerprintLoginActivity.this,
                    "Authentication Error. Please Try Again.!", Toast.LENGTH_SHORT).show();
            Intent authenticationError = new Intent(FingerprintLoginActivity.this, HomeActivity.class);
            startActivity(authenticationError);
            finish();
        }

        @Override
        public void onAuthenticationHelp(final int helpCode, @Nullable final CharSequence helpString) {
        }

        @Override
        public void authenticationCanceledByUser() {
            Toast.makeText(FingerprintLoginActivity.this,
                    "Canceled By User.", Toast.LENGTH_LONG).show();
            Intent authenticationCancel = new Intent(FingerprintLoginActivity.this, HomeActivity.class);
            startActivity(authenticationCancel);
            finish();
        }

        @Override
        public void onAuthenticationSucceeded() {
            Toast.makeText(FingerprintLoginActivity.this,
                    "Authentication Successful.", Toast.LENGTH_LONG).show();

            Intent authenticationSuccess = new Intent(FingerprintLoginActivity.this, DashBoaradActivity.class);
            startActivity(authenticationSuccess);
            finish();
        }

        @Override
        public void onAuthenticationFailed() {
        }
    };

    public void quickVibrate() {
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(500);
        }

    }

    @Override
    public void fingerprintAuthenticationNotSupported() {
    }

    @Override
    public void hasNoFingerprintEnrolled() {

    }

    @Override
    public void onAuthenticationError(int errorCode, @Nullable CharSequence errString) {

    }

    @Override
    public void onAuthenticationHelp(int helpCode, @Nullable CharSequence helpString) {

    }

    @Override
    public void authenticationCanceledByUser() {

    }

    @Override
    public void onAuthenticationSucceeded() {

    }

    @Override
    public void onAuthenticationFailed() {
    }
}