package m223.apiu904.model;

import java.util.*;

import m223.apiu904.db.DatenbankZugriff;
import m223.apiu904.db.Zeile;

public class TestLaufPruefung
{
	public static void main(String[] args)
	{
		DatenbankZugriff datenbank = DatenbankZugriff.getDatenbankZugriff();
		datenbank.setZugangsdaten();
		Zeile sek = datenbank.getTabellen().get("jos_sections").getZeile();
		sek.setFeld("title","Internes");
		sek.save();
		String id = sek.getFeld(0);
		List<Zeile> cat = datenbank.getTabellen().get("jos_categories").getZeilen("section = 5", "");
		for (Zeile z : cat)
		{
			z.setFeld("section", ""+id);
			z.save();
		}
		cat = datenbank.getTabellen().get("jos_categories").getZeilen("section = 6", "");
		for (Zeile z : cat)
		{
			z.setFeld("section", ""+id);
			z.save();
		}
		cat = datenbank.getTabellen().get("jos_categories").getZeilen("section = "+id, "");
		for (Zeile z : cat)
		{
			Zeile s = datenbank.getTabellen().get("jos_sections").getZeile("id = "+z.getFeld("section"),"");
			System.out.print(z.getFeld("id"));
			System.out.print(z.getFeld("title"));
			System.out.print(s.getFeld("id"));
			System.out.print(s.getFeld("title"));
			System.out.print(s.getFeld("ordering"));
		}
	}
}
