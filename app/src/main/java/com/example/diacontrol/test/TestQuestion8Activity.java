package com.example.diacontrol.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.diacontrol.R;
import com.example.diacontrol.test.models.Answer;
import com.example.diacontrol.test.models.FindriscTest;
import com.example.diacontrol.test.models.Question;

public class TestQuestion8Activity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_question8);

		ImageView btnBack = findViewById(R.id.btn_back);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});

		Question q = FindriscTest.getQuestion(8);

		TextView questionHeader = findViewById(R.id.question_header);
		questionHeader.setText(q.getQuestionHeader());

		TextView questionText = findViewById(R.id.question);
		questionText.setText(q.getQuestion());

		RadioGroup rgAnswers = findViewById(R.id.rgAnswers);
		for(Answer a : q.getAnswers()){
			AppCompatRadioButton rb = new AppCompatRadioButton(this);
			rb.setButtonDrawable(R.drawable.drawable_radio_btn);
			rb.setTextAppearance(R.style.textRegular1);
			rb.setText(a.getAnswer());
			rb.setId(a.getId());
			if (FindriscTest.isUserAnswerExist(q.getId()) && FindriscTest.getUserAnswer(q.getId()).getId() == a.getId())
				rb.setChecked(true);
			else if (a.getId() == q.getAnswers().get(0).getId()) rb.setChecked(true);
			rgAnswers.addView(rb);
		}
		rgAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup radioGroup, int i) {
				FindriscTest.addUserAnswer(q.getId(), i);
			}
		});

		Button btnContinue = findViewById(R.id.btnContinueTest);
		btnContinue.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(TestQuestion8Activity.this, TestResultActivity.class);
				startActivity(intent);
			}
		});
	}
}