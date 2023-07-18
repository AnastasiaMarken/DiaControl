package com.example.diacontrol.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diacontrol.R;
import com.example.diacontrol.test.models.FindriscTest;
import com.example.diacontrol.test.models.TestResult;

public class TestResultActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_result);

		ImageView btnBack = findViewById(R.id.btn_back);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});

		TestResult r = FindriscTest.getUserResult();

		TextView tvResult = findViewById(R.id.tvResult);
		tvResult.setText(FindriscTest.getUserScoreText());
		tvResult.setTextColor(getResources().getColor(FindriscTest.getUserScoreTextColor()));

		TextView tvLevel = findViewById(R.id.tvLevel);
		tvLevel.setText(r.getRiskLevelDescription());

		TextView tvStatistics = findViewById(R.id.tvStatistics);
		tvStatistics.setText(r.getStatistics() + "\n" + r.getRecommendation());


	}
}