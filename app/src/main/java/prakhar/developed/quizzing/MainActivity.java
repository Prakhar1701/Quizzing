package prakhar.developed.quizzing;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import prakhar.developed.quizzing.API_Interface;
import prakhar.developed.quizzing.model.MCQs;
import prakhar.developed.quizzing.model.Options;
import prakhar.developed.quizzing.model.Questions;
import prakhar.developed.quizzing.model.Result;
import prakhar.developed.quizzing.recyclerViewMCQ.RecyclerViewAdapter;
import prakhar.developed.quizzing.recyclerViewMCQ.RecyclerViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    API_Interface apiInterface;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<RecyclerViewModel> MCQ;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = Retrofit_Instance.getRetrofit().create(API_Interface.class);
        MCQ = new ArrayList<>();


        apiInterface.getMCQs().enqueue(new Callback<MCQs>() {


            @Override
            public void onResponse(Call<MCQs> call, Response<MCQs> response) {

                MCQs MCQresponce = response.body();

                Result result = MCQresponce.getResult();


                List<Questions> question = result.getQuestions();

                for (int i = 0; i < 6; i++) {
                    String lable = question.get(i).getLable();
                    List<Options> option = question.get(i).getOptions();

                    MCQ.add(new RecyclerViewModel(lable, option.get(0).getLable(), option.get(1).getLable(), option.get(2).getLable(),  option.get(3).getLable()));


                }
                initRecyclerView();
                Toast.makeText(MainActivity.this, String.valueOf(MCQ.size()), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MCQs> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();
            }
        });

//----------------------------------------------------------------------------------------------------------------------------

//        initRecyclerView();   why not here ?


//----------------------------------------------------------------------------------------------------------------------------
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(MCQ,MainActivity.this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}