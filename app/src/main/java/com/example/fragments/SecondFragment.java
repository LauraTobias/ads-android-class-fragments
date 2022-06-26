package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SecondFragment extends Fragment {

    TextView tvBundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_second, container, false);
        tvBundle = v.findViewById(R.id.textBundle);


        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (getArguments() != null && getArguments().containsKey("msg"))
            this.tvBundle.setText(getArguments().getString("msg"));
    }
}