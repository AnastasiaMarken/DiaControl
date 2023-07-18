package com.example.diacontrol.test.models;

public class Answer {
   private int id;
   private String gender;
   private String answer;
   private int score;

   public Answer(int id, String gender, String answer, int score) {
      this.id = id;
      this.gender = gender;
      this.answer = answer;
      this.score = score;
   }

   public Answer(int id, String answer, int score) {
      this.id = id;
      this.answer = answer;
      this.score = score;
   }

   public int getId() {
      return id;
   }

   public String getGender() {
      return gender;
   }

   public String getAnswer() {
      return answer;
   }

   public int getScore() {
      return score;
   }
}
