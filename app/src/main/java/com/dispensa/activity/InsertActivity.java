package com.dispensa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.Dispensa;
import com.dispensa.service.AuthenticationService;
import com.dispensa.utilities.Utils;
import com.example.dispensa.R;
import com.google.android.material.textfield.TextInputEditText;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        AuthenticationService a = new AuthenticationService();
        a.checkConnection();
    }


    public void onClickCreateDispensa(View view) {

        TextInputEditText name = (TextInputEditText) findViewById(R.id.inputTextName);
        TextInputEditText trigger = (TextInputEditText) findViewById(R.id.inputTextTrigger);
        TextInputEditText quantity = (TextInputEditText) findViewById(R.id.inputTextQuantity);
        TextInputEditText dataScadenza = (TextInputEditText) findViewById(R.id.inputTextDataScadenza);
        TextInputEditText section = (TextInputEditText) findViewById(R.id.inputTextSection);

        String data = Utils.formatData(dataScadenza.getEditableText().toString().trim());

        Temporal.Date date = new Temporal.Date(data);

        Dispensa item = Dispensa.builder()
                .name(name.getEditableText().toString())
                .trigger(Integer.parseInt(trigger.getEditableText().toString().trim()))
                .quantity(Integer.parseInt(quantity.getEditableText().toString().trim()))
                .dataScadenza(date)
                .section(section.getEditableText().toString().trim())
                .build();


        Amplify.API.mutate(
                ModelMutation.create(item),
                response -> {
                    Log.i("Amplify", "Created");
                    if (response.hasErrors()) {
                        Log.e("Amplify", response.getErrors().get(0).getMessage());
                    } else {
                        Log.i("Amplify", "Created Note with id: " + response.getData().getId());
                    }
                },
                error -> Log.e("MyAmplifyApp", "Create failed", error)
        );
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickGoBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}