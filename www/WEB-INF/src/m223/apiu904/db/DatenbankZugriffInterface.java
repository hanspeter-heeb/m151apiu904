package m223.apiu904.db;

import java.util.*;

public interface DatenbankZugriffInterface
{
	/**
	 * Öffnet einen Datenbankzugriff, falls noch nicht
	 * offen, so dass anschliessend
	 * executeSql möglich ist
	 * 
	 * @return true, wenn Zugriff auf Datenbank möglich
	 * @author Bettina Tütsch
	 */
	boolean openDatabase();
	
	/**
	 * Schliesst einen Datenbankzugriff
	 * 
	 * @return true, wenn erfolgreich
	 * @author Bettina Tütsch
	 */
	boolean closeDatabase();
	
	/**
	 * 
	 * @return Map mit Tabellennamen als Schlüssel und Tabellenobjekten
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
