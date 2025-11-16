package com.example.profilemanager;

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
import androidx.activity.result.contract.ActivityResultContracts;
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

ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>(){
            @Override
            public void onActivityResult(ActivityResult result){
                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);

                    String drawableName = "flag_02";
                    switch (data.getIntExtra("imageId",R.id.flagid00)){
                        case R.id.flagid00:
                            drawableName = "flag_00";
                            break;
                        case R.id.flagid01:
                            drawableName = "flag_01";
                            break;
                        case R.id.flagid02:
                            drawableName = "flag_02";
                            break;
                        case R.id.flagid03:
                            drawableName = "flag_03";
                            break;
                        case R.id.flagid04:
                            drawableName = "flag_04";
                            break;
                        case R.id.flagid05:
                            drawableName = "flag_05";
                            break;
                        case R.id.flagid06:
                            drawableName = "flag_06";
                            break;
                        case R.id.flagid07:
                            drawableName = "flag_07";
                            break;
                        case R.id.flagid08:
                            drawableName = "flag_08";
                            break;
                    }
                    int resID = getResources().getIndentifier(drawableName,"drawable", getPackageName());
                    avatarImage.setImageResource(resID);
                }
            }
        });

public void OnSetAvatarButton(View view){
    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
    profileActivityResultLauncher.launch(intent);
}