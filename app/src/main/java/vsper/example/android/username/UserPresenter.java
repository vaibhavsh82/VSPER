package vsper.example.android.username;

/**
 * Created by vsharma10 on 4/23/17.
 */

class UserPresenter
{

	private final UserRepository mRepository;

	public UserPresenter() {
		mRepository = new UserRepository();
	}

	UserPresenter(UserRepository repository)
	{
		mRepository = repository;
	}

	void getUserName(UserCallback callback) {
		mRepository.getUserName(callback);
	}
}
