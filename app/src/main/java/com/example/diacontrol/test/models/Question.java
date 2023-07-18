package com.example.diacontrol.test.models;

import java.util.ArrayList;

public class Question {
   private int id;
   private String question;
   private ArrayList<Answer> answers = new ArrayList<>();

   public Question(int id, String question) {
      this.id = id;
      this.question = question;
   }

   public void addAnswer(Answer a) {
      answers.add(a);
   }

   public int getId() {
      return id;
   }

   public String getQuestion() {
      return question;
   }

   public String getQuestionHeader() {
      return "Вопрос: " + id + " из 8";
   }

   public ArrayList<Answer> getAnswers() {
      return answers;
   }
}
