package com.cg.lrceditor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        setupAds();
    }


    public void startEditor(View view) {
        EditText editText = findViewById(R.id.lyrics_textbox);
        String data = editText.getText().toString().trim();

        if(data.isEmpty()) {
            Toast.makeText(this, "You haven't typed/pasted any lyrics", Toast.LENGTH_SHORT).show();
            return;
        }

        data = "\n" + data;
        String[] timestamps = new String[1];
        timestamps[0] = "00:00.00";

        Intent intent = new Intent(this, EditorActivity.class);
        intent.putExtra("LYRICS", data.split("\\n"));
        intent.putExtra("TIMESTAMPS", timestamps);
        startActivity(intent);
    }

    private void setupAds() {
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
