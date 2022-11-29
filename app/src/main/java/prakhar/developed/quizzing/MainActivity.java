package prakhar.developed.quizzing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadNewQuestion();

//----------------------------------------------------------------------------------------------------------------------------
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadNewQuestion();
            }
        });
//----------------------------------------------------------------------------------------------------------------------------
    }

    String quizOutOf() {
        String quizNumber = String.valueOf(quizCount + 1) + " / " + String.valueOf(totalQuizCount);
        return quizNumber;
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
                quizCount++;
            }

            @Override
            public void onFailure(Call<MCQs> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();
            }
        });
    }
}