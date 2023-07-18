package com.example.diacontrol.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.diacontrol.R;
import com.example.diacontrol.test.models.Answer;
import com.example.diacontrol.test.models.FindriscTest;
import com.example.diacontrol.test.models.Question;

public class TestQuestion3Activity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_question3);

		ImageView btnBack = findViewById(R.id.btn_back);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});

		RadioGroup rgSex = findViewById(R.id.rgSex);
		RadioGroup rgAnswers = findViewById(R.id.rgAnswers);
		Question q = FindriscTest.getQuestion(3);

		TextView questionHeader = findViewById(R.id.question_header);
		questionHeader.setText(q.getQuestionHeader());

		TextView questionText = findViewById(R.id.question);
		questionText.setText(q.getQuestion());


		if (FindriscTest.isUserAnswerExist(q.getId())) {
			AppCompatRadioButton rb;
			if (FindriscTest.getUserAnswer(q.getId()).getGender().equals("муж")) rb = findViewById(R.id.rbSexMan);
			else rb = findViewById(R.id.rbSexWoman);
			rb.setChecked(true);
		}
		rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup radioGroup, int i) {
				rgAnswers.removeAllViews();
				setAnswers(rgSex, rgAnswers, q);
			}
		});


		setAnswers(rgSex, rgAnswers, q);
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
				Intent intent = new Intent(TestQuestion3Activity.this, TestQuestion4Activity.class);
				startActivity(intent);
			}
		});
	}

	private void setAnswers(RadioGroup rgSex, RadioGroup rgAnswers, Question q) {
		String gender;
		if (rgSex.getCheckedRadioButtonId() == R.id.rbSexMan) gender = "муж";
		else gender = "жен";

		for(Answer a : q.getAnswers()){
			if (a.getGender().equals(gender)){
				AppCompatRadioButton rb = new AppCompatRadioButton(this);
				rb.setButtonDrawable(R.drawable.drawable_radio_btn);
				rb.setTextAppearance(R.style.textRegular1);
				rb.setText(a.getAnswer());
				rb.setId(a.getId());
				if (FindriscTest.isUserAnswerExist(q.getId()) && FindriscTest.getUserAnswer(q.getId()).getId() == a.getId())
					rb.setChecked(true);
				else if (!FindriscTest.isUserAnswerExist(q.getId()) && a.getId() == q.getAnswers().get(0).getId() || a.getId() == q.getAnswers().get(3).getId()) rb.setChecked(true);
				rgAnswers.addView(rb);
			}
		}
	}
}