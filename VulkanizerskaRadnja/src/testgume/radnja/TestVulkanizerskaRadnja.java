package testgume.radnja;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gume.AutoGuma;
import gume.radnja.VulkanizerskaRadnja;

public class TestVulkanizerskaRadnja {
	VulkanizerskaRadnja v;
	AutoGuma a;
	@Before
	public void setUp() throws Exception {
		v=new VulkanizerskaRadnja();
		a=new AutoGuma();
	}

	@After
	public void tearDown() throws Exception {
		v=null;
		a=null;
	}

	@Test
	public void testDodajGumu() {
		a.setMarkaModel("Mishelin Winter");
		a.setPrecnik(19);
		a.setSirina(220);
		a.setVisina(45);
		v.dodajGumu(a);
		assertEquals(a, v.getGume().getFirst());
	}

	@Test (expected= java.lang.NullPointerException.class)
	public void testDodajGumuNull() {
		v.dodajGumu(null);
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testDodajGumuDuplikat() {
		a.setMarkaModel("Mishelin Winter");
		a.setPrecnik(19);
		a.setSirina(220);
		a.setVisina(45);
		v.dodajGumu(a);
		AutoGuma a1=new AutoGuma();
		a1.setMarkaModel("Mishelin Winter");
		a1.setPrecnik(19);
		a1.setSirina(220);
		a1.setVisina(45);
		v.dodajGumu(a1);
	}
	
	@Test
	public void testPronadjiGumu() {
		a.setMarkaModel("Mishelin Winter");
		a.setPrecnik(19);
		a.setSirina(220);
		a.setVisina(45);
		v.dodajGumu(a);
		assertEquals(1, v.pronadjiGumu("Mishelin Winter").size());
	}
	@Test
	public void testPronadjiGumuNull() {
		assertEquals(null, v.pronadjiGumu(null));
	}
	@Test
	public void testPronadjiGumuNePostojeca() {
		a.setMarkaModel("Mishelin Winter");
		a.setPrecnik(19);
		a.setSirina(220);
		a.setVisina(45);
		v.dodajGumu(a);
		assertEquals(0, v.pronadjiGumu("Dunav").size());
	}
	
	@Test
	public void testPronadjiGumuNekoliko() {
		a.setMarkaModel("Mishelin Winter");
		a.setPrecnik(19);
		a.setSirina(220);
		a.setVisina(45);
		AutoGuma a1=new AutoGuma();
		a.setMarkaModel("Mishelin Winter");
		a.setPrecnik(19);
		a.setSirina(220);
		a.setVisina(45);
		v.dodajGumu(a);
		v.dodajGumu(a1);
		assertEquals(2, v.pronadjiGumu("Mishelin Winter").size());
	}
	
}