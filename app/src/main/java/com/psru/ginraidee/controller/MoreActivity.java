package com.psru.ginraidee.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.psru.ginraidee.R;
import com.psru.ginraidee.util.BottomNavHelper;

import veiw.AboutActivity;
import veiw.HowToActivity;
import veiw.SettingsActivity;

public class MoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        findViewById(R.id.layoutSettings).setOnClickListener(v ->
                startActivity(new Intent(this, SettingsActivity.class)));

        findViewById(R.id.layoutHowTo).setOnClickListener(v ->
                startActivity(new Intent(this, HowToActivity.class)));

        findViewById(R.id.layoutAbout).setOnClickListener(v ->
                startActivity(new Intent(this, AboutActivity.class)));

        findViewById(R.id.layoutLogout).setOnClickListener(v -> {
            Toast.makeText(this, "ออกจากระบบเรียบร้อย", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        BottomNavHelper.setup(this, R.id.navMore);
    }
}
