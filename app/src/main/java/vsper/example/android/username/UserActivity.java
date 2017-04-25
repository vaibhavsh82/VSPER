package vsper.example.android.username;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

/**
 * View to show the user name and a button to fetch the user name
 */
public class UserActivity extends AppCompatActivity
{

	TextView userNameTextView;
	Button getUserNameButton;
	UserPresenter userPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_name);
		userNameTextView = (TextView)findViewById(R.id.userName);
		getUserNameButton = (Button) findViewById(R.id.getUserButton);
		userPresenter = new UserPresenter();
	}

	public void onGetUserButtonClicked(View view) {

		userPresenter.getUserName();
	}


	@Override
	protected void onStart()
	{
		super.onStart();
		EventBus.getDefault().register(this);
	}


	@Override
	protected void onStop()
	{
		super.onStop();
		EventBus.getDefault().unregister(this);
	}


	public void onEventMainThread(DataEvent dataEvent) {
		String userName = dataEvent.getData();
		userNameTextView.setText(userName);
	}

	public void onEventMainThread(ErrorEvent errorEvent) {
		// handle the error or display error dialog
		Log.e(getClass().getSimpleName(), errorEvent.getError());
	}
}
