package m223.apiu904.db;

import java.util.*;

public interface DatenbankZugriffInterface
{
	/**
	 * �ffnet einen Datenbankzugriff, falls noch nicht
	 * offen, so dass anschliessend
	 * executeSql m�glich ist
	 * 
	 * @return true, wenn Zugriff auf Datenbank m�glich
	 * @author Bettina T�tsch
	 */
	boolean openDatabase();
	
	/**
	 * Schliesst einen Datenbankzugriff
	 * 
	 * @return true, wenn erfolgreich
	 * @author Bettina T�tsch
	 */
	boolean closeDatabase();
	
	/**
	 * 
	 * @return Map mit Tabellennamen als Schl�ssel und Tabellenobjekten
	 */
	public Map<String,Tabelle> getTabellen();
	
	/**
	 * 
	 * @param tn Tabellenname
	 * @param where
	 * @param orderBy 
	 * @return Liste der Zeilen
	 */
	List<Zeile> getZeilen(String tn, String where,String orderBy);
	
	boolean addZeile(Zeile z);
	boolean updateZeile(Zeile z);
	boolean removeZeile(Zeile z);
}
