package vsper.example.android.username.retorfit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit build to make network request. Not perfect and modular code.
 */
class RetrofitBuilder {

    private static final String BASE_URL = "https://api.coursera.org/api/";
    private static MyRetroInterface apiService;

    private RetrofitBuilder() {

		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		// set your desired log level
		logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		// add your other interceptors …

		// add logging as last interceptor
		httpClient.addInterceptor(logging);

		Retrofit retrofit = new Retrofit.Builder()
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient.build())
				.build();
        apiService = retrofit.create(MyRetroInterface.class);
    }

    static MyRetroInterface getInstance() {
        if (apiService == null) {
            new RetrofitBuilder();
        }
        return apiService;
    }
}
