package in.lineofcode.xml;
/**
 * 
 * @author Gaurav Rai Mazra
 *
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class XmlBuilderTests {
	@Test
	public void testGetUsersXml()
	{
		XmlBuilder xmlBuilder = new XmlBuilder("Users");
		assertNotNull(xmlBuilder.toXml());
		assertEquals("<Users></Users>", xmlBuilder.toXml());
	}
	
	@Test
	public void testGetUserXml()
	{
		XmlBuilder xmlBuilder = new XmlBuilder("User");
		assertNotNull(xmlBuilder.toXml());
		assertEquals("<User></User>", xmlBuilder.toXml());
	}
	
	@Test
	public void testGetUsersXmlWithChildren()
	{
		XmlBuilder xmlBuilder = new XmlBuilder("Users");
		xmlBuilder.addChildren(new XmlBuilder("User"));
		assertEquals("<Users><User></User></Users>", xmlBuilder .toXml());
	}
	
	@Test
	public void testGetUserXmlWithAttributes()
	{
		XmlBuilder xmlBuilder = new XmlBuilder("User");
		xmlBuilder.addAttribute("active", "true");
		assertEquals("<User active=\"true\"></User>", xmlBuilder .toXml());
	}
}
