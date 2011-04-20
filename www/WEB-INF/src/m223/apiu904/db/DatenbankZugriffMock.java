package m223.apiu904.db;

import java.util.*;

class DatenbankZugriffMock implements DatenbankZugriffInterface
{	private boolean open=true;

	

	@Override
	public boolean closeDatabase()
	{	open=false;
		return open;
	}

	@Override
	public Map<String, Tabelle> getTabellen()
	{	Map<String, Tabelle> mock= new HashMap<String, Tabelle>();
		Tabelle t = new Tabelle();
		t.setName("klasse");
		List<String> f= new ArrayList<String>();
		f.add("id");
		f.add("name");
		t.setFeldnamen(f);
		f= new ArrayList<String>();
		f.add("int");
		f.add("String");
		t.setFeldtypen(f);
		mock.put(t.getName(),t);
		t = new Tabelle();
		t.setName("student");
		 f= new ArrayList<String>();
		f.add("id");
		f.add("vorname");
		f.add("name");
		f.add("klasse");
		t.setFeldnamen(f);
		f= new ArrayList<String>();
		f.add("int");
		f.add("String");
		f.add("String");
		f.add("int");
		t.setFeldtypen(f);
		mock.put(t.getName(),t);
		return mock;
	}
	
	

	@Override
	public List<Zeile> getZeilen(String tn, String where, String orderBy)
	{	List<Zeile> zn= new ArrayList<Zeile>();
		Tabelle t = this.getTabellen().get(tn);
		if(tn.equals("klasse"))
		{
			String[] as = {"1","apiu904"};
			zn.add(neueZeile(t,as));
			String[] bs = {"2","apiu804"};
			zn.add(neueZeile(t,bs));
		}else
		{
			String[] as = {"1","Hans","Meier","1"};
			zn.add(neueZeile(t,as));
			String[] bs = {"2","Anna","Müller","1"};
			zn.add(neueZeile(t,bs));
			String[] cs = {"3","Johann","Huber","2"};
			zn.add(neueZeile(t,cs));
			String[] ds = {"4","Johanna","Hilber","2"};
			zn.add(neueZeile(t,ds));
			String[] es = {"5","Ivana","Linka","2"};
			zn.add(neueZeile(t,es));
		}
		return zn;
	}

	private Zeile neueZeile(Tabelle t,String[] fldr)
	{
		Zeile z = new Zeile(t);
		int i=0;
		for (String f : fldr)
		{
			z.setFeld(i++, f);
		}
		return z;
	}

	@Override
	public boolean openDatabase()
	{	
		return false;
	}

	@Override
	public boolean addZeile(Zeile z)
	{
		return true;
	}

	@Override
	public boolean removeZeile(Zeile z)
	{
		return true;
	}

	@Override
	public boolean updateZeile(Zeile z)
	{
		return true;
	}

}
