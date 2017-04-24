package vsper.example.android.username;

/**
 * Cache to store the data in memory. This is volatile and can be cleared by OS when in need.
 */

class UserCache
{

	private static UserCache instance;
	private UserEntity mUser;

	static UserCache getInstance() {
		if (instance == null) {
			instance = new UserCache();
		}
		return instance;
	}

	UserEntity getUser() {
		return mUser;
	}

	void setUser(UserEntity mUserName)
	{
		this.mUser = mUserName;
	}
}
