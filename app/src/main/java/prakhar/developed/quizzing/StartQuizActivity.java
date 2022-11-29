package prakhar.developed.quizzing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import prakhar.developed.quizzing.databinding.ActivityStartQuizBinding;

public class StartQuizActivity extends AppCompatActivity {

    ActivityStartQuizBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ActivityStartQuiz = new Intent(StartQuizActivity.this, QuizActivity.class);
                finish();
                startActivity(ActivityStartQuiz);
            }
        });
    }
}