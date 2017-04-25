package vsper.example.android.username.retorfit;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import vsper.example.android.username.retorfit.Elements;
import vsper.example.android.username.retorfit.RetrofitBuilder;

/**
 * Service to get the a course name from open coursera api on network
 */
public class CourseNetworkService
{
	public Observable<String> getFirstCourseName()
	{
		return RetrofitBuilder.getInstance().groupList()
				.subscribeOn(Schedulers.io())
				.map(new Function<Elements, String>()
				{
					@Override
					public String apply(Elements elements) throws Exception
					{
						return elements.elements.get(0).getName();
					}
				});
	}
}
