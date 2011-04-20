package m223.apiu904.db;

import java.util.*;

import javax.swing.BorderFactory;

/**
 * Eine Objekt, des eine Zeile aus der Datenbank abbildet
 * (ActiveRecord, DBObject)
 * 
 * @author 
 *
 */
public class Zeile
{
	private Tabelle tabelle;
	private List<String> feldinhalte = new ArrayList<String>();

	public Zeile(Tabelle t)
	{
		tabelle = t;
		for (String s : t.getFeldnamen())
		{
			feldinhalte.add(null);
		}
	}
	
	/**
	 * Tabelle, zu welcher diese Zeile gehört.
	 * 
	 * @return Tabelle zu dieser Zeile
	 */
	public Tabelle getTabelle()
	{
		return tabelle;
	}

	/**
	 * Gibt den Inhalt des Feldes zurück
	 * @param spalte Nummer des Spalte
	 * @param wert Zugewiesener Wert
	 */
	public void setFeld(int spalte,String wert)
	{ 
		feldinhalte.set(spalte, 	wert);
	}
	
	/**
	 * Gibt den Inhalt des entsprechenden Feldes zurück.
	 * @param spalte Nummer des Spalte (des Feldes)
	 * @return Feldinhalt als String
	 */
	public String getFeld(int spalte)
	{
		return spalte>=feldinhalte.size() || feldinhalte.get(spalte)==null? "0" : feldinhalte.get(spalte);
	}


	
	/**
	 * Löscht den Datensatz aus der Datenbank
	 * 
	 * @return true Wenn Speicherung erfolgreich
	 */
	public boolean delete()
	{
		return DatenbankZugriff.getDatenbankZugriff().removeZeile(this);
	}
	
	/**
	 * Gibt alle Feldinhalte in Form einer Liste zurück
	 * @return Liste der Feldinhalte
	 */
	public List<String> getFeldinhalte()
	{
		return feldinhalte;
	}

	/**
	 * Weisst dem Feld mit dem betreffenden Namen 
	 * einen Wert zu.
	 * @param feld Name des Feldes (der Spalte)
	 * @param wert Zugewiesener Wert
	 */
	public void setFeld(String feld, String wert)
	{
		setFeld(tabelle.getFeldnamen().indexOf(feld), wert);
	}
	
	/**
	 * @author René Bigler
	 * @param string Name des Feldes
	 * @return Feldinhalt
	 */
	public String getFeld(String string)
	{
		int id = this.tabelle.getFeldnamen().lastIndexOf(string);
		return this.getFeld(id);
	}


	/**
	 * @author René Bigler
	 * Holt den Datensatz erneut aus der Datenbank
	 * 
	 * @return true Wenn Speicherung erfolgreich
	 */
	public boolean reload()
	{ List<Zeile> az = DatenbankZugriff.getDatenbankZugriff().getZeilen(this.tabelle.getName(), this.tabelle.getPrimaryKey() + " = '" + this.getPrimary() + "'", "");
		if(az.size()==0)
			return false;
		else
		{
			this.feldinhalte = az.get(0).feldinhalte;
			return true;
		}
	}
	
	/**
	 * Lädt den Datensatz mit der entsprechenden id
	 * 
	 * @param id Primärschlüssel
	 */
	public void reload(String id)
	{	setPrimary(id);
		reload();
	}

	/**
	 * Speichert den Datensatz, die Speicherung sollte erfolgreich sein,
	 * unabhängig, ob der Datensatz neu ist (id=null oder 0) oder
	 * ob er geladen wurde.
	 * 
	 * @return true Wenn Speicherung erfolgreich
	 */
	public boolean save()
	{
		if(getPrimary()==null || getPrimary().equals("0"))
			return create();
		else
			return DatenbankZugriff.getDatenbankZugriff().updateZeile(this);
	}
	
	/**
	 * Speichert einen neuen Datensatz
	 * 
	 * @return true Wenn Speicherung erfolgreich
	 */
	public boolean create()
	{
		return DatenbankZugriff.getDatenbankZugriff().addZeile(this);
	}

	/**
	 * Gibt den Wert des Primärschlüssels zurück
	 * @return Wert des Primärschlüssels
	 */
	public String getPrimary()
	{
		return  this.getFeld(this.tabelle.getPrimaryKey());
	}

	@Override
	public String toString()
	{
		String s="";
		for (String f : getFeldinhalte())
		{
			s+=f+" ";
		}
		return s;
	}

	/**
	 * Weisst dem Primärschlüssel einen Wert zu
	 * @param wert
	 */
	public void setPrimary(String wert)
	{
		setFeld(getTabelle().getPrimaryKey(), wert);
	}
	
	
}
