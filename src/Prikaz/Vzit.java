package Prikaz;

 public class Vzit implements Prikaz {
     public String vykonej() {
         return "Sebral jsi předmět a přidal ho do inventáře.";
     }

     public boolean ukoncit() {
         return false;
     }
 }

