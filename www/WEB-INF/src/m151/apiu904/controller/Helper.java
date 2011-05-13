package m151.apiu904.controller;
import m223.apiu904.db.Tabelle;
import m223.apiu904.model.*;

public class Helper
{
	private ActiveRecord activeRecord;
	public Helper(Object o)
	{
		if(o instanceof ActiveRecord)
			activeRecord = (ActiveRecord) o;
	}
	public String fieldsTable()
	{	String table="<table>\n";
		if(activeRecord!=null)
		{
			Tabelle t = activeRecord.getTabelle();
			for(int f=0;f<t.getFeldnamen().size();f++)
			{
				table+="<tr>\n";
				table+="<td>"+t.getFeldnamen().get(f)+"</td>\n";
				table+="<td>"+activeRecord.getFeld(t.getFeldnamen().get(f))+"</td>\n";
				table+="</tr>\n";
			}
		}
		return table+"</table>\n";
	}
}
