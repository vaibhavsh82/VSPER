package vsper.example.android.username;

/**
 * Service to get the UserEntity from network
 */

class UserNetworkService
{
	UserEntity getUserNameAsyncFromNetwork() {
		return new UserEntity("VSPER");
	}
}
