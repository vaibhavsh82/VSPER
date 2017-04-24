package vsper.example.android.username;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * View to show the user name and a button to fetch the user name
 */
public class UserActivity extends AppCompatActivity implements UserCallback
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
		UserRepository repository = new UserRepository();
		userPresenter = new UserPresenter(repository);
	}

	public void onGetUserButtonClicked(View view) {

		userPresenter.getUserName(this);
	}


	@Override
	public void sendUser(String user)
	{
		userNameTextView.setText(user);
	}
}
