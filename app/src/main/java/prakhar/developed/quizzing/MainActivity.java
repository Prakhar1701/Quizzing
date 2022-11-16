package prakhar.developed.quizzing;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import prakhar.developed.quizzing.API_Interface;
import prakhar.developed.quizzing.model.MCQs;
import prakhar.developed.quizzing.model.Questions;
import prakhar.developed.quizzing.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    API_Interface apiInterface;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = Retrofit_Instance.getRetrofit().create(API_Interface.class);

        //------------------------------------------------------------------------------------------
        listView = findViewById(R.id.listView);
        ArrayList<String> postsTitle = new ArrayList<>();
        //------------------------------------------------------------------------------------------


        apiInterface.getMCQs().enqueue(new Callback<MCQs>() {


            @Override
            public void onResponse(Call<MCQs> call, Response<MCQs> response) {
//                Toast.makeText(MainActivity.this, "List is not empty", Toast.LENGTH_LONG).show();
                MCQs MCQresponce = response.body();

                Result result = MCQresponce.getResult();

                result.getTimeInMinutes();

                List<Questions> question = result.getQuestion();


//                question.get(0).getLable();

                Toast.makeText(MainActivity.this, String.valueOf(question.size()), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MCQs> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();
            }
        });

//---------------------------------------------------------------------------------------------------------------------------
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, postsTitle);
        listView.setAdapter(arrayAdapter);
//----------------------------------------------------------------------------------------------------------------------------
    }
}