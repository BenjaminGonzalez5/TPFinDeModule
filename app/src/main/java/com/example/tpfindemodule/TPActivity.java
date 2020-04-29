package com.example.tpfindemodule;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TPActivity extends AppCompatActivity implements View.OnClickListener {
    protected TPApp TPApp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TPApp = (TPApp) getApplication();
    }

    protected void showBackBtn() {
        ImageView imageView = findViewById(R.id.buttonBack);
        if (imageView != null) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(this);
        }
    }

    protected void setTitle(String title) {
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        if (textViewTitle != null) {
            textViewTitle.setText(title);
        }
    }

    protected void displayToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBack:
                finish();
                break;
        }
    }
}