package prakhar.developed.quizzing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import prakhar.developed.quizzing.databinding.ActivityStartQuizBinding;

public class StartQuizActivity extends AppCompatActivity {

    ActivityStartQuizBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}