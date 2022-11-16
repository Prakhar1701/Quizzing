package prakhar.developed.quizzing.model;

import java.util.ArrayList;

public class Result {
    private float timeInMinutes;
    ArrayList<Questions> question = new ArrayList<Questions>();

    public ArrayList<Questions> getQuestion() {
        return question;
    }

    public void setQuestion(ArrayList<Questions> question) {
        this.question = question;
    }

// Getter Methods

    public float getTimeInMinutes() {
        return timeInMinutes;
    }

    // Setter Methods 

    public void setTimeInMinutes(float timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }
}