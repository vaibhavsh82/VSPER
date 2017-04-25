package vsper.example.android.username.retorfit;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Interface for retrofit network call
 */
interface MyRetroInterface {
    @GET("courses.v1")
	Observable<Elements> groupList();

}
