package com.example.guest.meat.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.meat.R;
import com.example.guest.meat.adapters.RecipePagerAdapter;
import com.example.guest.meat.models.Recipe;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecipeDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private RecipePagerAdapter adapterViewPager;
    ArrayList<Recipe> mRecipes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);

        mRecipes = Parcels.unwrap(getIntent().getParcelableExtra("recipes"));
        int staringPostion = getIntent().getIntExtra("position", 0);

        adapterViewPager = new RecipePagerAdapter(getSupportFragmentManager(), mRecipes);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(staringPostion);
    }
}
