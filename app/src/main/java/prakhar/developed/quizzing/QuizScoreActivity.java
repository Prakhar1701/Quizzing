package prakhar.developed.quizzing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import prakhar.developed.quizzing.databinding.ActivityQuizScoreBinding;

public class QuizScoreActivity extends AppCompatActivity {

    ActivityQuizScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        binding.textViewScore.setText(intent.getStringExtra("Score"));

        binding.buttonRestartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ActivityStartQuiz = new Intent(QuizScoreActivity.this, QuizActivity.class);
                finish();
                startActivity(ActivityStartQuiz);
            }
        });
    }
}