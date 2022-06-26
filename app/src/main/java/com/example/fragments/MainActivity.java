package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFragmentFirst, btnFragmentSecond;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnFragmentFirst = findViewById(R.id.btnFirstFragment);
        this.btnFragmentSecond = findViewById(R.id.btnSecondFragment);

        View.OnClickListener onClickListener = view -> {
            switch (view.getId())
            {
                case R.id.btnFirstFragment: fragment = new FirstFragment(); break;
                case R.id.btnSecondFragment: fragment = new SecondFragment(); break;
            }

            openFragment();
        };

        this.btnFragmentFirst.setOnClickListener(onClickListener);
        this.btnFragmentSecond.setOnClickListener(onClickListener);
    }

    public void openFragment()
    {
        if (this.fragment == null)
            return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, this.fragment);
        transaction.commit();
    }
}