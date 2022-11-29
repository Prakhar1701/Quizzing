package prakhar.developed.quizzing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import prakhar.developed.quizzing.databinding.ActivityMainBinding;
import prakhar.developed.quizzing.model.MCQs;
import prakhar.developed.quizzing.model.Options;
import prakhar.developed.quizzing.model.Questions;
import prakhar.developed.quizzing.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    API_Interface apiInterface;
    int quizCount = 0;
    int totalQuizCount = 6;
    int score = 0;
    ArrayList<Integer> selectedOptionsKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        selectedOptionsKey = new ArrayList<>();
        loadNewQuestion();

//----------------------------------------------------------------------------------------------------------------------------
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadNewQuestion();
            }
        });
//----------------------------------------------------------------------------------------------------------------------------
        binding.buttonOption1.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View view) {


                if (count % 2 == 0) {
                    binding.buttonOption1.setBackgroundColor(Color.YELLOW);
                    selectedOptionsKey.add(1);
                } else if (count % 2 != 0) {
                    binding.buttonOption1.setBackgroundColor(Color.rgb(103, 80, 164));
                    selectedOptionsKey.remove(Integer.valueOf(1));
                }
                count++;


            }
        });
    }

    String quizOutOf() {
        String quizNumber = String.valueOf(quizCount + 1) + " / " + String.valueOf(totalQuizCount);
        return quizNumber;
    }

    void updateScore(ArrayList<Integer> correctAnswersKey) {

        if (selectedOptionsKey == correctAnswersKey) {
            score++;
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
                ArrayList<Integer> correctAnswersKey = question.get(quizCount).getCorrect_answers();
                updateScore(correctAnswersKey);

                //-----------------------------------------------------------------------------------------
                quizCount++;
            }

            @Override
            public void onFailure(Call<MCQs> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();
            }
        });
    }
}