package vsper.example.android.username;

import android.support.annotation.VisibleForTesting;

import de.greenrobot.event.EventBus;

/**
 * Presenter responsible for getting the data. Do all the business logic here and return
 * just the needed/massages data to View.
 */
class UserPresenter implements GenericCallback<String, String>
{

	private final UserRepository mRepository;

	UserPresenter() {
		mRepository = new UserRepository();
	}

	@VisibleForTesting
	public UserPresenter(UserRepository repository)
	{
		mRepository = repository;
	}

	void getUserName() {
		mRepository.getUserName(this);
	}


	@Override
	public void onSuccess(String data)
	{
		DataEvent dataEvent = new DataEvent(data);
		EventBus.getDefault().post(dataEvent);
	}


	@Override
	public void onFailure(String error)
	{
		ErrorEvent errorEvent = new ErrorEvent(error);
		EventBus.getDefault().post(errorEvent);
	}
}
