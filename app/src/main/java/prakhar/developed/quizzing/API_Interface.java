package prakhar.developed.quizzing;

import prakhar.developed.quizzing.model.MCQs;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Interface {

    @GET("?quiz=true")
    Call<MCQs> getMCQs();
}
