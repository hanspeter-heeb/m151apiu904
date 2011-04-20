package m223.apiu904.model;

import java.util.ArrayList;
import java.util.List;

import m223.apiu904.db.DatenbankZugriff;
import m223.apiu904.db.Tabelle;
import m223.apiu904.db.Zeile;

public class Section extends ActiveRecord
{
	static private String table ="jos_sections";

	public Section()
	{super(table);
	}
	
	public Section(String primaryKey)
	{super(table, primaryKey);
	}

	public void setTitle(String t)
	{	setFeld("title", t);
	}
	
	public String getTitle()
	{	return getFeld("title");
	}
	
	public boolean isPublished()
	{	return getFeld("published").equals("1");
	}
	
	public void setPublished(boolean p)
	{	setFeld("published", p?"1":"0");
	}
	
	public List<Category> getCategories()
	{	List<Category> li=new ArrayList<Category>();
		for (Zeile z : DatenbankZugriff.getDatenbankZugriff().getZeilen("jos_categories", "section="+getPrimary(), ""))
		{
			Category c = new Category();
			c.reload(z.getPrimary());
			li.add(c);
		}
		return li;
	}
	
}
