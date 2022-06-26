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

public class FirstFragment extends Fragment {

    TextView tvBundle;
    Button buttonMsg;
    EditText editText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_first, container, false);
        tvBundle = v.findViewById(R.id.textBundle);

        buttonMsg = v.findViewById(R.id.btnSecondFragmentMessage);
        editText = v.findViewById(R.id.editText);

        buttonMsg.setOnClickListener(view -> {
            SecondFragment fragmentSecond = new SecondFragment();
            Bundle bundle = new Bundle();
            bundle.putString("msg", editText.getText().toString());

            fragmentSecond.setArguments(bundle);

            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, fragmentSecond);
            transaction.commit();
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (getArguments() != null && getArguments().containsKey("msg"))
            this.tvBundle.setText(getArguments().getString("msg"));
    }
}