package com.psru.ginraidee.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.psru.ginraidee.R;
import com.psru.ginraidee.util.BottomNavHelper;

public class WeeklyPlannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_planner);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        MaterialButton btnAddMenu = findViewById(R.id.btnAddMenu);
        btnAddMenu.setOnClickListener(v -> {
            Toast.makeText(this, "ไปหน้าสุ่มเมนูเพื่อเพิ่มเข้าแผนประจำวัน", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ChoiceActivity.class));
        });

        BottomNavHelper.setup(this, R.id.navWeekly);
    }
}
