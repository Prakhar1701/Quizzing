package prakhar.developed.quizzing;

import java.util.List;

import prakhar.developed.quizzing.model.MCQs;
import prakhar.developed.quizzing.model.Options;
import prakhar.developed.quizzing.model.Questions;
import prakhar.developed.quizzing.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Interface {

    @GET("?quiz=true")
    Call<MCQs> getMCQs();
//    Call<List<Result>> getResult();
//    Call<List<Questions>> getQuestion();
//    Call<List<MCQs>> getOption();

}
