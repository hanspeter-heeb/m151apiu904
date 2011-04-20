package m223.apiu904.model;

import java.util.List;

import m223.apiu904.db.DatenbankZugriff;
import junit.framework.TestCase;

/**
 * Testet die Modelklassen
 * 
 * @author hheeb
 *
 */
public class TestModelklasse extends TestCase
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
	
	public void testSectionNew()
	{
		Section s = new Section();
		assertEquals("0", s.getPrimary());
	}
	
	public void testSectionNewSaved()
	{
		Section s = new Section();
		s.save();
		assertFalse("0".equals(s.getPrimary()));
		s.delete();
	}
	
	public void testSectionDelete()
	{
		Section s = new Section();
		s.save();
		assertFalse("0".equals(s.getPrimary()));
		assertTrue(s.reload());
		s.delete();
		assertFalse(s.reload());
	}
	
	public void testSectionNewSavedRetrieved()
	{
		Section s = new Section();
		s.setPublished(true);
		s.save();
		String id = s.getPrimary();
		s = new Section();
		assertFalse(s.isPublished());
		s.setPrimary(id);
		s.reload();
		assertTrue(s.isPublished());
		s.delete();
	}
	
	public void testCategoryNew()
	{
		Category s = new Category();
		assertEquals("0", s.getPrimary());
	}
	
	public void testCategoryNewSaved()
	{
		Category s = new Category();
		s.save();
		assertFalse("0".equals(s.getPrimary()));
		s.delete();
	}
	
	public void testCategoryNewSavedRetrieved()
	{
		Category s = new Category();
		s.setFeld("title", "Test");
		s.save();
		String id = s.getPrimary();
		s = new Category();
		assertFalse(s.getFeld("title").equals("Test"));
		s.setPrimary(id);
		s.reload();
		assertTrue(s.getFeld("title").equals("Test"));
		s.delete();
	}
	
	public void testCategorySetSection()
	{	Category c = new Category();
		Section s = new Section();
		s.save();
		c.setSection(s);
		assertEquals(s.getPrimary(), c.getFeld("section"));
		s.delete();
	}
	
	public void testCategoryGetSection()
	{	Category c = new Category();
		Section s = new Section();
		s.save();
		c.setSection(s);
		c.save();
		String id = c.getPrimary();
		c = new Category();
		c.setPrimary(id);
		c.reload();
		assertEquals(s.getPrimary(), c.getSection().getPrimary());
		s.delete();
		c.delete();
	}
	
	public void testSectionGetCategories()
	{	Category c = new Category();
		Section s = new Section();
		s.setTitle("testSectionGetCategories");
		s.save();
		c.setSection(s);
		c.save();
		String cid = c.getPrimary();
		String sid = s.getPrimary();
		s=new Section();
		s.reload(sid);
		List<Category> cs = s.getCategories();
		assertEquals(1, cs.size());
		assertEquals(cid, cs.get(0).getPrimary());
		s.delete();
		c.delete();
	}
}
