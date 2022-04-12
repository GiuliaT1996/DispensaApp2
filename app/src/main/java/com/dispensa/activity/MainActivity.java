package com.dispensa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.dispensa.service.AuthenticationService;
import com.dispensa.utilities.Constants;
import com.example.dispensa.R;

public class MainActivity extends AppCompatActivity {

    private AuthenticationService authenticationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureAmplify();
    }

    private void configureAmplify() {
        try {
            if (!Constants.getConfigured()) {
                Amplify.addPlugin(new AWSApiPlugin()); // UNCOMMENT this line once backend is deployed
                Amplify.addPlugin(new AWSDataStorePlugin());
                Amplify.addPlugin(new AWSCognitoAuthPlugin());
                Amplify.configure(getApplicationContext());

                Log.i("Amplify", "Initialized Amplify");

                Constants.setConfigured(true);
            }

            authenticationService = new AuthenticationService();

            authenticationService.signIn();
            authenticationService.checkConnection();
        } catch(AmplifyException error){
            Log.e("Amplify", "Could not initialize Amplify", error);
        }
    }

    public void onClickInsert(View view) {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);

    }

    public void onClickGetAllItemsFromDispensa(View view) {
        Intent intent = new Intent(this, DispensaActivity.class);
        startActivity(intent);
    }
}