package com.psru.ginraidee.controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.psru.ginraidee.R;
import com.psru.ginraidee.model.AiSuggestion;
import com.psru.ginraidee.model.Food;
import com.psru.ginraidee.model.FoodManager;
import com.psru.ginraidee.util.BottomNavHelper;

import java.util.ArrayList;
import java.util.List;

public class MenuCatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_catalog);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        RecyclerView rvMenuCatalog = findViewById(R.id.rvMenuCatalog);
        rvMenuCatalog.setLayoutManager(new LinearLayoutManager(this));
        SuggestionAdapter adapter = new SuggestionAdapter();
        rvMenuCatalog.setAdapter(adapter);

        List<Food> allFoods = FoodManager.getInstance().getFoodList();
        List<AiSuggestion> list = new ArrayList<>();
        for (Food f : allFoods) {
            list.add(new AiSuggestion(f.getFoodName(), f.getTag() + " • " + f.getCalories() + " แคลอรี", f));
        }
        adapter.submit(list);

        BottomNavHelper.setup(this, R.id.navHome);
    }
}
