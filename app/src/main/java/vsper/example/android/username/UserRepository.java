package vsper.example.android.username;

import android.text.TextUtils;

import io.reactivex.functions.Consumer;
import vsper.example.android.username.retorfit.CourseNetworkService;

/**
 * Repository to get the data of user
 */
class UserRepository
{

	void getUserName(final GenericCallback<String, String> callback)
	{
		UserEntity userEntity = UserCache.getInstance().getUser();

		if (userEntity != null && !TextUtils.isEmpty(userEntity.userName))
		{
			// send the data to repository
			callback.onSuccess(userEntity.userName);

		}
		else
		{

			CourseNetworkService service = new CourseNetworkService();
			// For example getting a course name from list of courses available on Coursera open API
			service.getFirstCourseName()
					.subscribe(new Consumer<String>()
							   {
								   @Override
								   public void accept(String s) throws Exception
								   {
									   // send the data to presenter
									   callback.onSuccess(s);

									   UserEntity entity = new UserEntity(s);
									   // save the data to cache for later retrieval
									   UserCache.getInstance().setUser(entity);
								   }
							   }
							, new Consumer<Throwable>()
							{
								@Override
								public void accept(Throwable throwable) throws Exception
								{
									// error occurred. Let the presenter know.
									callback.onFailure(throwable.getMessage());
								}
							});

		}
	}
}
