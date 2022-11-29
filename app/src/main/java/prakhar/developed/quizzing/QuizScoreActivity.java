package prakhar.developed.quizzing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import prakhar.developed.quizzing.databinding.ActivityQuizScoreBinding;

public class QuizScoreActivity extends AppCompatActivity {

    ActivityQuizScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}