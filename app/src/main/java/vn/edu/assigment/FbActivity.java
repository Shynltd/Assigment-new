package vn.edu.assigment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import android.content.Intent;
import android.os.Bundle;

public class FbActivity extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);

        callbackManager = CallbackManager.Factory.create();
//                try {
//
//            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(),
//
//                    PackageManager.GET_SIGNATURES);
//
//            for (Signature signature : info.signatures) {
//
//                MessageDigest md = MessageDigest.getInstance("SHA");
//
//                md.update(signature.toByteArray());
//
//                String hashKey = new String(Base64.encode(md.digest(), 0));
//
//                Log.e("ABC", "printHashKey() Hash Key: " + hashKey);
//
//            }
//
//        } catch (NoSuchAlgorithmException e) {
//
//            Log.e("ABC", "printHashKey()", e);
//
//        } catch (Exception e) {
//
//            Log.e("ABC", "printHashKey()", e);
//
//        }
//
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
