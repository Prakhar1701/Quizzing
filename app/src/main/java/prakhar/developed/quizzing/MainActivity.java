package prakhar.developed.quizzing;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import java.util.List;
import prakhar.developed.quizzing.model.MCQs;
import prakhar.developed.quizzing.model.Questions;
import prakhar.developed.quizzing.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    API_Interface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = Retrofit_Instance.getRetrofit().create(API_Interface.class);



        apiInterface.getMCQs().enqueue(new Callback<MCQs>() {


            @Override
            public void onResponse(Call<MCQs> call, Response<MCQs> response) {

                MCQs MCQresponce = response.body();

                Result result = MCQresponce.getResult();
                List<Questions> question = result.getQuestions();
//                List<Options> option = question.get(0).getOptions();

            }

            @Override
            public void onFailure(Call<MCQs> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();
            }
        });

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    }
}