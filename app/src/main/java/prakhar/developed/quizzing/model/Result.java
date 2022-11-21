package prakhar.developed.quizzing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {
    private float timeInMinutes;

//    @SerializedName("questions")           // If Object Name Is Not Same As In API.
//    @Expose
    ArrayList<Questions> questions = new ArrayList<Questions>();

    public float getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(float timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public ArrayList<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Questions> questions) {
        this.questions = questions;
    }
}