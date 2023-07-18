package com.example.diacontrol.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diacontrol.R;
import com.example.diacontrol.test.models.Answer;
import com.example.diacontrol.test.models.FindriscTest;
import com.example.diacontrol.test.models.Question;

public class TestQuestion2Activity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_question2);

		ImageView btnBack = findViewById(R.id.btn_back);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});

		Question q = FindriscTest.getQuestion(2);

		TextView questionHeader = findViewById(R.id.question_header);
		questionHeader.setText(q.getQuestionHeader());

		TextView questionText = findViewById(R.id.question);
		questionText.setText(q.getQuestion());

		RadioGroup rgAnswers = findViewById(R.id.rgAnswers);
		for(Answer a : q.getAnswers()){
			AppCompatRadioButton rb = new AppCompatRadioButton(this);
			rb.setButtonDrawable(R.drawable.drawable_radio_btn);
			rb.setTextAppearance(R.style.textRegular1);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
				rb.setText(Html.fromHtml(a.getAnswer(), Html.FROM_HTML_MODE_LEGACY));
			} else rb.setText(a.getAnswer());
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

		EditText edHeight = findViewById(R.id.editTextHeight);
		EditText edWeight = findViewById(R.id.editTextWeight);
		edHeight.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				TextView tvResult = findViewById(R.id.imtCalculator);
				if (!edWeight.getText().toString().equals("") && !edHeight.getText().toString().equals("")) {
					double height = Double.parseDouble(edHeight.getText().toString());
					double weight = Double.parseDouble(edWeight.getText().toString());

					if (height != 0 && weight != 0) {
						double imt = weight / Math.pow(height/100, 2);
						int rbId = 0;
						if (imt < 25) rbId = 5;
						else if (imt >= 25 && imt <= 30) rbId = 6;
						else rbId = 7;
						RadioButton rb = findViewById(rbId);
						rb.setChecked(true);

						String result = getString(R.string.test_imt_calc) + ": " + String.format("%.1f", imt) + " " + getString(R.string.test_imt_rasm);
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
							tvResult.setText(Html.fromHtml(result, Html.FROM_HTML_MODE_LEGACY));
						} else tvResult.setText(getString(R.string.test_imt_calc) + ": " + String.format("%.1f", imt));
					} else tvResult.setText(getString(R.string.test_imt_calc));
				} else tvResult.setText(getString(R.string.test_imt_calc));
			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		});
		edWeight.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				TextView tvResult = findViewById(R.id.imtCalculator);
				if (!edWeight.getText().toString().equals("") && !edHeight.getText().toString().equals("")) {
					double height = Double.parseDouble(edHeight.getText().toString());
					double weight = Double.parseDouble(edWeight.getText().toString());

					if (height != 0 && weight != 0) {
						double imt = weight / Math.pow(height/100, 2);
						int rbId = 0;
						if (imt < 25) rbId = 5;
						else if (imt >= 25 && imt <= 30) rbId = 6;
						else rbId = 7;
						RadioButton rb = findViewById(rbId);
						rb.setChecked(true);

						String result = getString(R.string.test_imt_calc) + ": " + String.format("%.1f", imt) + " " + getString(R.string.test_imt_rasm);
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
							tvResult.setText(Html.fromHtml(result, Html.FROM_HTML_MODE_LEGACY));
						} else tvResult.setText(getString(R.string.test_imt_calc) + ": " + String.format("%.1f", imt));
					} else tvResult.setText(getString(R.string.test_imt_calc));
				} else tvResult.setText(getString(R.string.test_imt_calc));
			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		});


		Button btnContinue = findViewById(R.id.btnContinueTest);
		btnContinue.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(TestQuestion2Activity.this, TestQuestion3Activity.class);
				startActivity(intent);
			}
		});
	}
}