package vsper.example.android.username;

/**
 * Event to send the data to view. Can be made generic.
 */
class DataEvent
{
	private String data;


	DataEvent(String data)
	{
		this.data = data;
	}


	public String getData()
	{
		return data;
	}


	public void setData(String data)
	{
		this.data = data;
	}

}
