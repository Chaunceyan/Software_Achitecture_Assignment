


package softarch.portal.db.json;

import java.util.Date;
import java.util.List;

import softarch.portal.data.RawData;
import softarch.portal.data.RegularData;
import softarch.portal.data.UserProfile;
import softarch.portal.db.abs.*;
import softarch.portal.db.sql.SQLDatabaseException;

public class JSonDatabaseFacade implements DatabaseFacade{

	JSonUserDatabase userDB;
	/**
	 * Creates a new database facade.
	 */
	public JSonDatabaseFacade() {
		userDB = new JSonUserDatabase();
	}

	/**
	 * Inserts a new user profile into the user database.
	 */
	@Override
	public void insert(UserProfile profile)
			throws SQLDatabaseException {
		// TODO Auto-generated method stub
		userDB.insert(profile);
	}

	@Override
	public void update(UserProfile profile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserProfile findUser(String username) {
		// TODO Auto-generated method stub
		return userDB.findUser(username);
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List findRecords(String informationType, String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findRecordsFrom(String informationType, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(RegularData rd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumberOfRegularRecords(String informationType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getRawData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RawData getRawData(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRawData(RegularData rd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRawData(RawData rd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRawData(RawData rd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumberOfRawRecords() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Updates an existing user profile in the user database.
	 */
}
