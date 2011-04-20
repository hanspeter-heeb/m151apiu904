package m223.apiu904.db;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestDatenbankschicht extends TestCase
{

	protected void setUp() throws Exception
	{
		DatenbankZugriff.getDatenbankZugriff().setZugangsdaten();
		super.setUp();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testSetUp()
	{	assertTrue(true);
	}
	
	public void testGetZeilen()
	{	List<Zeile> az = DatenbankZugriff.getDatenbankZugriff().getZeilen("jos_sections", "", "");
		assertNotNull(az);
		assertTrue(az.size()>5);
		assertNotNull(az.get(0));
		assertNotNull(az.get(0).getTabelle());
		assertEquals("jos_sections", az.get(0).getTabelle().getName());
	}
	
	public void testAddZeilen()
	{	Tabelle t = new Tabelle();
		t.setName("jos_sections");
		List<String> af = new ArrayList<String>();
		af.add("id");
		af.add("title");
		t.setFeldnamen(af);
		Zeile z = new Zeile(t);
		z.setFeld(0, null);
		z.setFeld(1, "Diverses");
		assertTrue(DatenbankZugriff.getDatenbankZugriff().addZeile(z));
		
	}
	
	public void testgetZeilenMitId()
	{	List<Zeile> az = DatenbankZugriff.getDatenbankZugriff().getZeilen("jos_sections", "id=1", "");
		assertEquals(1, az.size());
		assertEquals("Title: ", "Projekte", az.get(0).getFeld(1));
	}
	
	public void testUpdate()
	{	List<Zeile> az = DatenbankZugriff.getDatenbankZugriff().getZeilen("jos_sections", "id=1", "");
		assertEquals(1, az.size());
		assertEquals("Title: ", "Projekte", az.get(0).getFeld(1));
		az.get(0).setFeld(1, "Aufgaben");
		DatenbankZugriff.getDatenbankZugriff().updateZeile(az.get(0));
		az = DatenbankZugriff.getDatenbankZugriff().getZeilen("jos_sections", "id=1", "");
		assertEquals(1, az.size());
		assertEquals("Title: ", "Aufgaben", az.get(0).getFeld(1));
		az.get(0).setFeld(1, "Projekte");
		DatenbankZugriff.getDatenbankZugriff().updateZeile(az.get(0));
		az = DatenbankZugriff.getDatenbankZugriff().getZeilen("jos_sections", "id=1", "");
		assertEquals(1, az.size());
		assertEquals("Reset Title: ", "Projekte", az.get(0).getFeld(1));
		DatenbankZugriff.getDatenbankZugriff().updateZeile(az.get(0));
	}
	
	public void testProbelauf()
	{
		Zeile sek = DatenbankZugriff.getDatenbankZugriff().getTabellen().get("jos_sections").getZeile();
		sek.setFeld("title","Internes");
		assertTrue(true);
	}
	
}
