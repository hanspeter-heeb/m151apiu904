package m223.apiu904.db;

import java.util.*;



/**
 * 
 * @author 
 *
 */
public class Tabelle
{
	private List<String> feldnamen;
	private List<String> feldtypen;
	private String name;
	private String primaryKey;

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}


	
	/**
	 * 
	 * @param where Where Anweisung f�r Sql
	 * @param orderBy f�r Sql
	 * @return Liste der Zeilen aus der Datenbank
	 * @author 
	 */
	public List<Zeile> getZeilen(String where, String orderBy)
	{ 
		return DatenbankZugriff.getDatenbankZugriff().getZeilen(this.name,where,orderBy);
	}
	
	/**
	 * Eine bestehende Zeile aus der Datenbank laden
	 * @param where Where Anweisung für Sql
	 * @param orderBy für Sql
	 * @return Erste Zeile aus der Datenbank, die Bedingung erfüllt
	 * @author 
	 */
	public Zeile getZeile(String where, String orderBy)
	{
		return DatenbankZugriff.getDatenbankZugriff().getZeilen(this.name,where,orderBy).get(0);
	}
	
	/**
	 * Eine neue Zeile zu dieser Tabelle
	 * @return Neue Zeile ohne id
	 * @author 
	 */
	public Zeile getZeile()
	{
		return getZeile("","");
	}

	public List<String> getFeldnamen()
	{
		return feldnamen;
	}

	public List<String> getFeldtypen()
	{
		return feldtypen;
	}

	public String getName()
	{
		return name;
	}

	void setFeldnamen(List<String> feldnamen)
	{
		this.feldnamen = feldnamen;
	}

	void setFeldtypen(List<String> feldtypen)
	{
		this.feldtypen = feldtypen;
	}

	void setName(String name)
	{
		this.name = name;
	}
	
	
}
