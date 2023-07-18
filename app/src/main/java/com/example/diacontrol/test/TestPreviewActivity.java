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

		//		ФИГНЯ
		Question q0 = new Question(1, "Ваш возраст:");
		Answer a01 = new Answer(1, "муж","До 45 лет", 0);
		Answer a02 = new Answer(2, "муж","45-54 года", 2);
		Answer a03 = new Answer(3, "жен","55-64 года", 3);
		Answer a04 = new Answer(4, "жен","Старше 65 лет", 4);
		q0.addAnswer(a01);
		q0.addAnswer(a02);
		q0.addAnswer(a03);
		q0.addAnswer(a04);
		FindriscTest.addQuestion(q0);
		FindriscTest.addAnswers(a01);
		FindriscTest.addAnswers(a02);
		FindriscTest.addAnswers(a03);
		FindriscTest.addAnswers(a04);

		Question q1 = new Question(2, "Индекс массы тела:");
		Answer a1 = new Answer(5, "Менее 25 кг/м²", 0);
		Answer a2 = new Answer(6, "25-30 кг/м²", 1);
		Answer a3 = new Answer(7, "Более 30 кг/м²", 3);
		q1.addAnswer(a1);
		q1.addAnswer(a2);
		q1.addAnswer(a3);
		FindriscTest.addQuestion(q1);
		FindriscTest.addAnswers(a1);
		FindriscTest.addAnswers(a2);
		FindriscTest.addAnswers(a3);

		Question q3 = new Question(3, "Окружность талии на уровне пупка:");
		Answer a31 = new Answer(8, "муж","Меньше, чем 94 см", 0);
		Answer a322 = new Answer(9, "муж","94-102 см", 3);
		Answer a32 = new Answer(10, "муж","Больше 102 см", 4);
		Answer a33 = new Answer(11, "жен","Меньше, чем 80 см", 0);
		Answer a344 = new Answer(12, "жен","80-88 см", 3);
		Answer a34 = new Answer(13, "жен","Больше 88 см", 4);
		q3.addAnswer(a31);
		q3.addAnswer(a32);
		q3.addAnswer(a322);
		q3.addAnswer(a33);
		q3.addAnswer(a34);
		q3.addAnswer(a344);
		FindriscTest.addQuestion(q3);
		FindriscTest.addAnswers(a31);
		FindriscTest.addAnswers(a32);
		FindriscTest.addAnswers(a322);
		FindriscTest.addAnswers(a33);
		FindriscTest.addAnswers(a34);
		FindriscTest.addAnswers(a344);

		q0 = new Question(4, "Как часто Вы едите овощи, фрукты или ягоды?");
		a01 = new Answer(14, "муж","Каждый день", 0);
		a02 = new Answer(15, "муж","Не каждый день", 1);

		q0.addAnswer(a01);
		q0.addAnswer(a02);

		FindriscTest.addQuestion(q0);
		FindriscTest.addAnswers(a01);
		FindriscTest.addAnswers(a02);

		q0 = new Question(5, "Делаете ли Вы физические упражнения по 30 минут каждый день или 3 часа в течении недели?");
		a01 = new Answer(16, "муж","Да", 0);
		a02 = new Answer(17, "муж","Нет", 2);

		q0.addAnswer(a01);
		q0.addAnswer(a02);

		FindriscTest.addQuestion(q0);
		FindriscTest.addAnswers(a01);
		FindriscTest.addAnswers(a02);

		q0 = new Question(6, "Принимали ли Вы когда-либо регулярно лекарства для снижения артериального давления?");
		a01 = new Answer(18, "муж","Нет", 0);
		a02 = new Answer(19, "муж","Да", 2);

		q0.addAnswer(a01);
		q0.addAnswer(a02);

		FindriscTest.addQuestion(q0);
		FindriscTest.addAnswers(a01);
		FindriscTest.addAnswers(a02);

		q0 = new Question(7, "Обнаруживали ли у вас когда-либо уровень глюкозы (сахара) в крови выше нормы?");
		a01 = new Answer(20, "муж","Нет", 0);
		a02 = new Answer(21, "муж","Да", 5);

		q0.addAnswer(a01);
		q0.addAnswer(a02);

		FindriscTest.addQuestion(q0);
		FindriscTest.addAnswers(a01);
		FindriscTest.addAnswers(a02);

		q0 = new Question(8, "Был ли у Ваших родственников сахарный диабет 1 или 2 типа?");
		a01 = new Answer(22, "муж","Нет", 0);
		a02 = new Answer(23, "муж","Да: дедушка/бабушка, тетя/дядя, двоюродные братья/сестры", 2);
		Answer a022 = new Answer(24, "муж","Да: родители, брат/сестра или собственный ребенок", 5);

		q0.addAnswer(a01);
		q0.addAnswer(a02);
		q0.addAnswer(a022);

		FindriscTest.addQuestion(q0);
		FindriscTest.addAnswers(a01);
		FindriscTest.addAnswers(a02);
		FindriscTest.addAnswers(a022);




		TestResult r1 = new TestResult(0,6,"низкая", "Примерно у 1-го из 100 будет диабет", "Рекомендуем проверять сахар в крови 1 раз в год");
		TestResult r2 = new TestResult(7,11,"немного повышенная", "Примерно у 1-го из 25 будет диабет", "Рекомендуем обратиться к врачу-терапевту или эндокринологу");
		TestResult r3 = new TestResult(12,14,"умеренная", "Примерно у 1-го из 6 будет диабет", "Рекомендуем обратиться к врачу-терапевту или эндокринологу, а также иметь дома глюкометр для периодического измерения сахара в крови");
		TestResult r4 = new TestResult(15,20,"высокая", "Примерно у 1-го из 3 будет диабет", "Рекомендуем срочно обратиться к врачу-терапевту или эндокринологу, а также иметь дома глюкометр для регулярного измерения сахара в крови");
		TestResult r5 = new TestResult(21,27,"очень высокая", "Примерно у 1-го из 2 будет диабет", "Рекомендуем срочно обратиться к врачу-терапевту или эндокринологу, а также иметь дома глюкометр для регулярного измерения сахара в крови");

		FindriscTest.addResult(r1);
		FindriscTest.addResult(r2);
		FindriscTest.addResult(r3);
		FindriscTest.addResult(r4);
		FindriscTest.addResult(r5);
		//		ФИГНЯ
	}
}