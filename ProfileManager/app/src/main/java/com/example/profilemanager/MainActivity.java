package com.example.profilemanager;

import static androidx.activity.result.ActivityResultCallerKt.registerForActivityResult;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OnOpenInGoogleMaps(View View) {
        EditText teamAddress = (EditText) findViewById(R.id.teamPostalCode);

        Uri gmmIntentUri = Uri.parse("http://maps.google.com/maps?q=" + teamAddress.getText());

        Intent mapIntenet = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntenet.setPackage(("com.google.android.apps.maps"));

        startActivity(mapIntenet);
    }

    ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @SuppressLint("NonConstantResourceId")
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        ImageView avatarImage = findViewById(R.id.imageView);

                        String drawableName = "flag_00";
                        int imageId = data.getIntExtra("imageId", R.id.flag_00);

                        if (imageId == R.id.flag_00) {
                            drawableName = "flag_00";
                        } else if (imageId == R.id.flag_01) {
                            drawableName = "flag_01";
                        } else if (imageId == R.id.flag_02) {
                            drawableName = "flag_02";
                        } else if (imageId == R.id.flag_03) {
                            drawableName = "flag_03";
                        } else if (imageId == R.id.flag_04) {
                            drawableName = "flag_04";
                        } else if (imageId == R.id.flag_05) {
                            drawableName = "flag_05";
                        } else if (imageId == R.id.flag_06) {
                            drawableName = "flag_06";
                        } else if (imageId == R.id.flag_07) {
                            drawableName = "flag_07";
                        } else if (imageId == R.id.flag_08) {
                            drawableName = "flag_08";
                        }
                        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
                        avatarImage.setImageResource(resID);
                    }
                }
        });

public void OnSetAvatarButton(View view) {
    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
    profileActivityResultLauncher.launch(intent);
}
}