package prakhar.developed.quizzing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import prakhar.developed.quizzing.databinding.ActivityQuizBinding;
import prakhar.developed.quizzing.model.MCQs;
import prakhar.developed.quizzing.model.Options;
import prakhar.developed.quizzing.model.Questions;
import prakhar.developed.quizzing.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    API_Interface apiInterface;
    int quizCount = 0;
    int totalQuizCount = 6;
    int score = 0;
    int countOne = 0, countTwo = 0, countThree = 0, countFour = 0;
    ArrayList<Integer> selectedOptionsKey;
    ArrayList<Integer> correctAnswersKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        selectedOptionsKey = new ArrayList<>();
        loadNewQuestion();

//----------------------------------------------------------------------------------------------------------------------------
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore();
                if (quizCount < totalQuizCount) {
                    loadNewQuestion();
                    countOne = 0;
                    countTwo = 0;
                    countThree = 0;
                    countFour = 0;

                    binding.buttonOption1.setBackgroundColor(Color.rgb(103, 80, 164));
                    binding.buttonOption2.setBackgroundColor(Color.rgb(103, 80, 164));
                    binding.buttonOption3.setBackgroundColor(Color.rgb(103, 80, 164));
                    binding.buttonOption4.setBackgroundColor(Color.rgb(103, 80, 164));
                }
            }
        });
//----------------------------------------------------------------------------------------------------------------------------
        binding.buttonOption1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (countOne % 2 == 0) {
                    binding.buttonOption1.setBackgroundColor(Color.YELLOW);
                    selectedOptionsKey.add(1);
                } else if (countOne % 2 != 0) {
                    binding.buttonOption1.setBackgroundColor(Color.rgb(103, 80, 164));
                    selectedOptionsKey.remove(Integer.valueOf(1));
                }
                countOne++;

            }
        });

        binding.buttonOption2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (countTwo % 2 == 0) {
                    binding.buttonOption2.setBackgroundColor(Color.YELLOW);
                    selectedOptionsKey.add(2);
                } else if (countTwo % 2 != 0) {
                    binding.buttonOption2.setBackgroundColor(Color.rgb(103, 80, 164));
                    selectedOptionsKey.remove(Integer.valueOf(2));
                }
                countTwo++;

            }
        });

        binding.buttonOption3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (countThree % 2 == 0) {
                    binding.buttonOption3.setBackgroundColor(Color.YELLOW);
                    selectedOptionsKey.add(3);
                } else if (countThree % 2 != 0) {
                    binding.buttonOption3.setBackgroundColor(Color.rgb(103, 80, 164));
                    selectedOptionsKey.remove(Integer.valueOf(3));
                }
                countThree++;

            }
        });

        binding.buttonOption4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (countFour % 2 == 0) {
                    binding.buttonOption4.setBackgroundColor(Color.YELLOW);
                    selectedOptionsKey.add(4);
                } else if (countFour % 2 != 0) {
                    binding.buttonOption4.setBackgroundColor(Color.rgb(103, 80, 164));
                    selectedOptionsKey.remove(Integer.valueOf(4));
                }
                countFour++;

            }
        });

    }

    String quizOutOf() {
        String quizNumber = String.valueOf(quizCount + 1) + " / " + String.valueOf(totalQuizCount);
        return quizNumber;
    }


    void updateScore() {
//        Toast.makeText(QuizActivity.this, String.valueOf(selectedOptionsKey), Toast.LENGTH_LONG).show();

        Collections.sort(selectedOptionsKey);
        Collections.sort(correctAnswersKey);
        if (selectedOptionsKey.equals(correctAnswersKey)) {
            score++;
        }

        selectedOptionsKey.clear();

        if (quizCount == totalQuizCount) {
            Intent ActivityQuizScore = new Intent(QuizActivity.this, QuizScoreActivity.class);
            ActivityQuizScore.putExtra("Score", String.valueOf(score));

            finish();
            startActivity(ActivityQuizScore);
        }
    }

    void loadNewQuestion() {
        binding.textViewQuizNumber.setText(quizOutOf());
//--------------------------------------------------------------------------------------------------
        apiInterface = Retrofit_Instance.getRetrofit().create(API_Interface.class);
        apiInterface.getMCQs().enqueue(new Callback<MCQs>() {

            @Override
            public void onResponse(Call<MCQs> call, Response<MCQs> response) {

                MCQs MCQresponce = response.body();

                Result result = MCQresponce.getResult();
                List<Questions> question = result.getQuestions();

                String lable = question.get(quizCount).getLable();
                binding.textViewLable.setText(lable);

                List<Options> option = question.get(quizCount).getOptions();

                String optionOne = option.get(0).getLable();
                String optionTwo = option.get(1).getLable();
                String optionThree = option.get(2).getLable();
                String optionFour = option.get(3).getLable();

                binding.buttonOption1.setText(optionOne);
                binding.buttonOption2.setText(optionTwo);
                binding.buttonOption3.setText(optionThree);
                binding.buttonOption4.setText(optionFour);
                //-----------------------------------------------------------------------------------------

                //-----------------------------------------------------------------------------------------
                correctAnswersKey = question.get(quizCount).getCorrect_answers();
                quizCount++;
            }

            @Override
            public void onFailure(Call<MCQs> call, Throwable t) {
                Toast.makeText(QuizActivity.this, "Fail", Toast.LENGTH_LONG).show();
            }
        });

    }
}