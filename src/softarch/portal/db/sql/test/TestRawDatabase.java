package softarch.portal.db.sql.test;

import java.util.List;
import java.util.Iterator;

import softarch.portal.data.RawData;
import softarch.portal.db.sql.SQLRawDatabase;

/**
 * This is a test program for the raw database.
 * @author Niels Joncheere
 */
public class TestRawDatabase {
	public static void main(String[] args) {
		try {
			SQLRawDatabase rd = new SQLRawDatabase(
					"njonchee",
					"chivas12",
					"localhost/njonchee");
			System.out.println("NUMBER OF RECORDS");
			System.out.println(rd.getNumberOfRawRecords());
			System.out.println();
			System.out.println("RECORDS");
			List l = rd.getRawData();
			for (Iterator i = l.iterator(); i.hasNext(); )
				System.out.println(
					((RawData) i.next()).asXml());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
