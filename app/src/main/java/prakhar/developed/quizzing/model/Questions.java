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

    public ArrayList<Options> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Options> options) {
        this.options = options;
    }

    public ArrayList<Integer> getCorrect_answers() {
        return correct_answers;
    }

    public void setCorrect_answers(ArrayList<Integer> correct_answers) {
        this.correct_answers = correct_answers;
    }
}