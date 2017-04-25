package vsper.example.android.username;

/**
 * Event to pass error to View
 */
class ErrorEvent
{
	private String error;


	ErrorEvent(String error)
	{
		this.error = error;
	}


	String getError()
	{
		return error;
	}
}
