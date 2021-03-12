package com.example.exampleintent;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final static String TEXT = "PARAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.open_first_app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("example://intent");
                Intent runEchoIntent = new Intent(Intent.ACTION_VIEW, uri);
                runEchoIntent.putExtra(TEXT, "Hello from second app");
                ActivityInfo activityInfo =
                        runEchoIntent.resolveActivityInfo(getPackageManager(),
                                runEchoIntent.getFlags());
                if (activityInfo != null) {
                    startActivity(runEchoIntent);
                }

            }
        });
    }
}