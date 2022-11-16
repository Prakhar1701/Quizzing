package prakhar.developed.quizzing.model;

import java.util.ArrayList;

public class Questions {
    private String lable;
    ArrayList< Options> options = new ArrayList < Options> ();
    ArrayList < Integer> correct_answers = new ArrayList <Integer>() ;
   
    // Getter Methods 
   
    public String getLable() {
     return lable;
    }
   
    // Setter Methods 
   
    public void setLable(String lable) {
     this.lable = lable;
    }
   }