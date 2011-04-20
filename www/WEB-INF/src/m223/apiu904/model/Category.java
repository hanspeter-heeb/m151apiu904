package m223.apiu904.model;

public class Category extends ActiveRecord
{
	static private String table ="jos_categories";
	
	public Category()
	{super(table);
	}
	
	public Category(String primaryKey)
	{super(table, primaryKey);
	}

	public Section getSection()
	{	return new Section(getFeld("section"));
	}

	public void setSection(Section s)
	{	setFeld("section", s.getPrimary());
	}
}
