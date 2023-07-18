package com.example.diacontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diacontrol.test.TestPreviewActivity;

public class StartActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		Button btnLogin = findViewById(R.id.btn_login);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				Intent intent = new Intent(StartActivity.this, TestPreviewActivity.class);
//				startActivity(intent);
			}
		});

		TextView btnSingup = findViewById(R.id.btn_singup);
		btnSingup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ImageView hideLayer = findViewById(R.id.hideLayer);
				ConstraintLayout roleSelection = findViewById(R.id.role_selection);
				hideLayer.setVisibility(View.VISIBLE);
				roleSelection.setVisibility(View.VISIBLE);

				hideLayer.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						hideLayer.setVisibility(View.GONE);
						roleSelection.setVisibility(View.GONE);
					}
				});

				LinearLayout rolePatient = findViewById(R.id.role_patient);
				rolePatient.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
//						Intent intent = new Intent(StartActivity.this, TestPreviewActivity.class);
//						startActivity(intent);
					}
				});
				LinearLayout roleDoctor = findViewById(R.id.role_doctor);
				roleDoctor.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
//						Intent intent = new Intent(StartActivity.this, TestPreviewActivity.class);
//						startActivity(intent);
					}
				});
			}
		});



		TextView btnOpenTest = findViewById(R.id.btn_open_test);
		btnOpenTest.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(StartActivity.this, TestPreviewActivity.class);
				startActivity(intent);
			}
		});

	}
}