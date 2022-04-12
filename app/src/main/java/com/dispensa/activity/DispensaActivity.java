package com.dispensa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Dispensa;
import com.example.dispensa.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DispensaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispensa);

        //List<DispensaDto> dispense = Utils.convertDispensa(getInfoFromDispensa());

        List<String> dispense = getInfoFromDispensa().stream().map(Dispensa::getName).collect(Collectors.toList());

        ListView lv = findViewById(R.id._dynamic);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dispense );

        lv.setAdapter(arrayAdapter);
    }

    private List<Dispensa> getInfoFromDispensa() {
        List<Dispensa> dispense = new ArrayList<>();

        Amplify.API.query(
                ModelQuery.list(Dispensa.class),
                response -> {
                Log.i("Amplify", "Recuperati Risultati");
                    for(Dispensa d : response.getData()) {
                        dispense.add(d);
                        Log.i("Amplify", "Recuperato: " + d.getName());
                    }
                },
                error -> Log.e("Amplify", "Query failure", error)

        );

        return dispense;
    }

    public void onClickGoBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}