package m223.apiu904.db;

import java.sql.*;
import java.util.*;


/**
 * Fassade für den Zugriff auf die Datenbank
 * @see #setZugangsdaten() setZugangsdaten() änder für die allgemeinen Zugangsdaten
 * @author hheeb
 *
 */
public class DatenbankZugriff implements DatenbankZugriffInterface
{
	private static DatenbankZugriff datenbankZugriff = new DatenbankZugriff();
	private static DatenbankZugriffInterface datenbank;
	private Statement statement;
	
	private DatenbankZugriff()
	{
	}
	
	/**
	 * Eine zentrale Schalstelll für den Datenbankzugriff 
	 * 
	 * @return Immer gleiches Objekt (Singleton) für Datenbankzugriffe
	 * @author Hanspeter Heeb
	 */
	public static DatenbankZugriff getDatenbankZugriff()
	{	return datenbankZugriff;
	}
	
	/**
	 * Richtet den Zugriff auf die konkrete Datenbank ein.
	 * @param url Url der Datenbank
	 * @param usr Benutzer mit Datenbankzugriff
	 * @param pwd Passwort des Benutzers
	 * @return true wenn Zugung mit diesen Daten möglich
	 * @author Benjamin Amir
	 */
	public boolean setZugangsdaten(String url, String usr, String pwd)
	{
		if(url.equals("test")){
			datenbank = new DatenbankZugriffMock();
			return true;
		}else{
			datenbank = new DatenbankzugriffMySql(url, usr, pwd);
			return true;
		}
	}

	@Override
	public boolean closeDatabase()
	{
		return datenbank.closeDatabase();
	}

	@Override
	public Map<String, Tabelle> getTabellen()
	{
		return datenbank.getTabellen();
	}

	@Override
	public boolean openDatabase()
	{
		return datenbank.openDatabase();
	}

	@Override
	public List<Zeile> getZeilen(String tn, String where,String orderBy)
	{
		return datenbank.getZeilen(tn,where,orderBy);
	}

	@Override
	public boolean addZeile(Zeile z)
	{
		return datenbank.addZeile(z);
	}

	@Override
	public boolean removeZeile(Zeile z)
	{
		return datenbank.removeZeile(z);
	}

	@Override
	public boolean updateZeile(Zeile z)
	{
		return datenbank.updateZeile(z);
	}

	/**
	 * Standardzugangsdaten für den Datenbankzugriff
	 */
	public void setZugangsdaten()
	{
		setZugangsdaten("jdbc:mysql://localhost/m223", "m2", "SHAzMF2HUV9eJf7L");
	}
	

	
	
}
