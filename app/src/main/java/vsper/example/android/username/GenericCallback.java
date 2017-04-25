package vsper.example.android.username;

/**
 * A generic callback for listening to a request that can pass or fail.
 */
interface GenericCallback<S, E>
{
	void onSuccess(S data);

	void onFailure(E error);
}
