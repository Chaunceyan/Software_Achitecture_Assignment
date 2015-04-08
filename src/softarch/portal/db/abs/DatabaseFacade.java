package softarch.portal.db.abs;

import softarch.portal.data.RawData;
import softarch.portal.data.RegularData;
import softarch.portal.data.UserProfile;
import softarch.portal.db.sql.SQLDatabaseException;

import java.util.List;
import java.util.Date;

/**
 * This class is an interface for facade.
 * @author Chunxiang Yan
 */
public interface DatabaseFacade {

	/**
	 * Inserts a new user profile into the user database.
	 */
	public void insert(UserProfile profile)
		throws SQLDatabaseException;

	/**
	 * Updates an existing user profile in the user database.
	 */
	public void update(UserProfile profile)
		throws SQLDatabaseException;
	
	/**
	 * Returns the user with the specified username.
	 */
	public UserProfile findUser(String username)
		throws SQLDatabaseException;
	
	/**
	 * Checks whether a user with the specified username exists.
	 */
	public boolean userExists(String username)
		throws SQLDatabaseException;
	
	/**
	 * Returns a list containing all records of the given information type
	 * that match the given query string.
	 */
	public List findRecords(String informationType, String queryString)
		throws SQLDatabaseException;
	
	/**
	 * Returns a list containing all records of the given information type
	 * that were added after the given date.
	 */
	
	public List findRecordsFrom(String informationType, Date date)
		throws SQLDatabaseException;
	
	/**
	 * Adds a new regular data object to the regular database.
	 */
	public void add(RegularData rd)
		throws SQLDatabaseException;

	/**
	 * Returns the number of records of the given information type in the
	 * regular database.
	 */
	public int getNumberOfRegularRecords(String informationType)
		throws SQLDatabaseException;
	
	/**
	 * Returns a list of all raw data.
	 */
	public List getRawData()
		throws SQLDatabaseException;
	
	/**
	 * Returns a specific raw data object.
	 */
	public RawData getRawData(int id)
		throws SQLDatabaseException;
	
	public void addRawData(RegularData rd)
		throws SQLDatabaseException;

	/**
	 * Deletes a raw data object.
	 */
	public void deleteRawData(RawData rd)
		throws SQLDatabaseException;

	/**
	 * Updates a raw data object.
	 */
	public void updateRawData(RawData rd)
		throws SQLDatabaseException;

	/**
	 * Returns the number of records in the raw database.
	 */
	public int getNumberOfRawRecords()
			throws SQLDatabaseException;
}
