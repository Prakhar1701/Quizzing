package prakhar.developed.quizzing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
//    API_Interface apiInterface;
//    int quizCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    }


}