package vsper.example.android.username;

import android.text.TextUtils;

/**
 * Repository to get the data of user
 */
class UserRepository
{

	void getUserName(UserCallback callback)
	{
		UserEntity userEntity = UserCache.getInstance().getUser();

		if (userEntity != null && !TextUtils.isEmpty(userEntity.userName)) {
			// send the data to repository
			callback.sendUser(userEntity.userName);

		} else {

			UserNetworkService service = new UserNetworkService();
			// In actual project this will be a Async call and will be returned through some
			// observer or callback
			userEntity = service.getUserNameAsyncFromNetwork();

			// save the data to cache for later retrieval
			UserCache.getInstance().setUser(userEntity);

			// send the data to repository
			callback.sendUser(userEntity.userName);
		}
	}
}
