package softarch.portal.db.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * This is a interface implementing all the shared functions of all databases.
 * @author Chunxiang Yan
 */

public class JSonDatabase{

	protected Charset ENCODING;
	protected Gson gson;
	/**
	 * Constructor of the database entity.
	 */
	public JSonDatabase(){

		this.gson = new Gson();
		ENCODING = StandardCharsets.UTF_8;
	}
	
	/**
	 * Writes the entity back to JSON file.
	 * @return 
	 */
	public void JSONWrite(String jsonStr, Path path){
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
		    writer.write(jsonStr);
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return;
	}
	
	/**
	 * Reads strings from the JSON file
	 */
	public String JSONRead(Path path) {
		StringBuilder contents = new StringBuilder();
		try {
			Iterator strIterator = Files.readAllLines(path, ENCODING).iterator();
			while(strIterator.hasNext()) {
				contents.append(strIterator.next());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contents.toString();
	}
}
/*
	
	/**
	 * Executes the given SQL queries.
	 *
	public void executeSql(List queries)
		throws DatabaseException {

		for (Iterator i = queries.iterator(); i.hasNext(); )
			executeSql((String) i.next());
	}
	

	/**
	 * Executes the given SQL query.
	 * Note that no result will be returned.
	 *
	public void executeSql(String query)
		throws DatabaseException {

		

		// Connect to the database:
		try {
			Connection dbConnection = getConnection();
			Statement statement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			statement.executeUpdate(query);

			statement.close();
			dbConnection.close();
		}

		// Exception handling:
		catch (SQLException e) {
			throw new DatabaseException(
				"SQL Exception: " + e.getMessage());
		}
		catch (Exception e) {
			throw new DatabaseException(
				"Unexpected Exception: " + e.getMessage());
		}
	}
}
**/