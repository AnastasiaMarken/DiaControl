package com.example.diacontrol.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.diacontrol.R;
import com.example.diacontrol.StartActivity;
import com.example.diacontrol.test.models.Answer;
import com.example.diacontrol.test.models.FindriscTest;
import com.example.diacontrol.test.models.Question;
import com.example.diacontrol.test.models.TestResult;

import javax.xml.transform.Result;

public class TestPreviewActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_preview);

		ImageView btnBack = findViewById(R.id.btn_back);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});

		Button btnStartTest = findViewById(R.id.btn_start_test);
		btnStartTest.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(TestPreviewActivity.this, TestQuestion1Activity.class);
				startActivity(intent);
			}
		});
	}
}
