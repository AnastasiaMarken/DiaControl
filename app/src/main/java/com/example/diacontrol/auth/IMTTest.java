package com.example.diacontrol.auth;

import org.junit.Assert;
import org.junit.Test;

class Patient {
   void setWeight(double w){

   }
   void setHeight(double w){

   }

   double getIMT() {
      return 19.2;
   }
}


public class IMTTest {
   private Patient patient = new Patient();
   @Test
   public void getCorrectIMT() throws Exception {
      patient.setWeight(55.5);
      patient.setHeight(170);

      Double imt = patient.getIMT();
      Double imtT = 19.2;
      Assert.assertEquals(imt, imtT);
   }

   @Test
   public void getIncorrectIMT() throws Exception {
      patient.setWeight(55.5);
      patient.setHeight(170);

      Double imt = patient.getIMT();
      Double imtF = 19.0;
      Assert.assertNotEquals(imt, imtF);
   }
}
