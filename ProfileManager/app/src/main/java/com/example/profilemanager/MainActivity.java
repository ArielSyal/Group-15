package com.example.profilemanager;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void OnOpenInGoogleMaps(View View){
        EditText teamAddress = (EditText) findViewById(R.id.teamPostalCode);

        Uri gmmIntentUri = Uri.parse("http://maps.google.com/maps?q=" + teamPostalCode.getText());

        Intent mapIntenet = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntenet.setPackage(("com.google.android.apps.maps"));

        startActivity(mapIntenet);
    }
}