import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.w3c.dom.Node;
class XPathProcessor
{
		public static void main(String args[])
		{
			DocumentBuilderFactory obj_factory=DocumentBuilderFactory.newInstance();
			
			try
			{
				DocumentBuilder obj_builder=obj_factory.newDocumentBuilder();
				Document doc=obj_builder.parse("xpathprocessor.xml");
				obj_factory.setNamespaceAware(true);
				NodeList nodes;
				XPathFactory obj_xpathfactory = XPathFactory.newInstance();
				XPath xpath = obj_xpathfactory.newXPath();
				System.out.println("\nExpression:-/p/r/rPr/sz/");
				nodes = (NodeList) xpath.evaluate("/p/r/rPr/sz",doc, XPathConstants.NODESET);
				for (int i = 0; i < nodes.getLength(); i++) 
				{
					Element element = (Element)nodes.item(i);
					System.out.println("<"+element.getNodeName()+">"+nodes.item(i).getTextContent()+"</"+element.getNodeName()+">");
					
				}
				System.out.println("\nExpression:-/p/pPr/rPr/sz/");
				nodes= (NodeList) xpath.evaluate("/p/pPr/rPr/sz",doc, XPathConstants.NODESET);
				for (int i = 0; i < nodes.getLength(); i++) 
				{
					Element element = (Element)nodes.item(i);
					System.out.println("<"+element.getNodeName()+">"+nodes.item(i).getTextContent()+"</"+element.getNodeName()+">");
					
				}
				System.out.println("\nExpression:-//sz");
				nodes = (NodeList) xpath.evaluate("//sz",doc, XPathConstants.NODESET);
				for (int i = 0; i < nodes.getLength(); i++) 
				{
					Element element = (Element)nodes.item(i);
					System.out.println("<"+element.getNodeName()+">"+nodes.item(i).getTextContent()+"</"+element.getNodeName()+">");
					
				}
				System.out.println("\nExpression:-//r//sz");
				nodes = (NodeList) xpath.evaluate("//r//sz",doc, XPathConstants.NODESET);
				for (int i = 0; i < nodes.getLength(); i++) 
				{
					Element element = (Element)nodes.item(i);
					System.out.println("<"+element.getNodeName()+">"+nodes.item(i).getTextContent()+"</"+element.getNodeName()+">");
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}