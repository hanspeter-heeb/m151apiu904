package m223.apiu904.model;

import java.util.List;

import m223.apiu904.db.DatenbankZugriff;
import m223.apiu904.db.Zeile;

/**
 * Basisklasse für die Klassen des Model. Diese adaptieren 
 * sich an die Klasse Zeile, indem Sie von dieser abgeleitet sind (Desingmuster «Adapter»).
 * Die Verwendung der Ableitung für den Adapter hat den Vorteil, dass alle Methoden
 * von Zeile zur Verfügung stehen und jedes Objekt der Modelklasse anstelle von 
 * eines Zeilenobjesktes tretten kann.
 * 
 * Jede Modelklasse entspricht einer Tabelle in der Datenbank (Desingmuster «Active Record»).
 * 
 * 
 * @author hheeb
 *
 */
abstract public class ActiveRecord extends Zeile
{

	public ActiveRecord(String tableName)
	{	super(DatenbankZugriff.getDatenbankZugriff().getTabellen().get(tableName));
	}
	public ActiveRecord(String tableName, String primaryKey	)
	{	super(DatenbankZugriff.getDatenbankZugriff().getTabellen().get(tableName));
		load(primaryKey);
	}
	
	public void load(String primaryKey)
	{
		this.setPrimary(primaryKey);
		this.reload();
	}
}
