package com.example.diacontrol.test.models;

import com.example.diacontrol.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindriscTest {
   private static Map<Integer, Question> questions = new HashMap<>();
   private static Map<Integer, Answer> answers = new HashMap<>();
   private static ArrayList<TestResult> results = new ArrayList<>();
   private static Map<Integer, Answer> userAnswers = new HashMap<>();

   public static void addQuestion(Question q) {
      questions.put(q.getId(), q);
   }

   public static void addAnswers(Answer a) {
      answers.put(a.getId(), a);
   }

   public static void addResult(TestResult r) {
      results.add(r);
   }

   public static Question getQuestion(int id_q) {
      return questions.get(id_q);
   }

   public static boolean isUserAnswerExist(int question_id) {
      return userAnswers.containsKey(question_id);
   }

   public static Answer getUserAnswer(int question_id) {
      return userAnswers.get(question_id);
   }

   public static void addUserAnswer(int question_id, int answer_id) {
      userAnswers.put(question_id, answers.get(answer_id));
   }

   public static int getUserScore() {
      int score = 0;
      for(Map.Entry<Integer, Answer> item : userAnswers.entrySet()){
         score += item.getValue().getScore();
      }
      return score;
   }

   public static String getUserScoreText() {
      int score = getUserScore();
      if (score % 10 == 1 && score / 10 != 1) return score + " балл";
      else if (score % 10 >= 2 && score % 10 <= 4 && score / 10 != 1) return score + " балла";
      else return score + " баллов";
   }

   public static int getUserScoreTextColor() {
      int score = getUserScore();
      if (score <= 11) return R.color.green_indicator;
      else if (score <= 14) return R.color.yellow_indicator;
      else return R.color.red_indicator;
   }

   public static TestResult getUserResult() {
      int score = getUserScore();
      for(TestResult result : results){
         if (score <= result.getMaxScore() && score >= result.getMinScore()) return result;
      }
      return results.get(0);
   }


}
