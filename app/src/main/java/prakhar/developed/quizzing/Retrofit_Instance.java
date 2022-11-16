package prakhar.developed.quizzing;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Instance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://b4e7d359-c58f-4aa3-a314-726b3baa3852.mock.pstmn.io/";

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }

        return retrofit;
    }
}
