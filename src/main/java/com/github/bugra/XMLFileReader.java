package com.github.bugra;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 /*
  * XML File Reader using SAX Parser for text and name fields, and returns an array field
  * whose first index is name and second one is text. 
  * @bugra
  */
public class XMLFileReader{
	
	public ArrayList nameTextArrayList = new ArrayList();
	private  String xmlFile;
	public XMLFileReader(String xmlFile){
		this.xmlFile = xmlFile;
		
	}
	public ArrayList parser() {
		 
	    try {
	 
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
	 
		DefaultHandler handler = new DefaultHandler() {
	 
		boolean bnname = false;
		boolean btname = false;
		
		ArrayList<String> nameArrayList = new ArrayList<String>();
		ArrayList<String> textArrayList = new ArrayList<String>();
		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
			if (qName.equalsIgnoreCase("NAME")) {
				bnname = true;
			}
	 
			if (qName.equalsIgnoreCase("TEXT")) {
				btname = true;
			}
	 
		}
	 
		public void endElement(String uri, String localName,
			String qName) throws SAXException {
		}
	 
		public void characters(char ch[], int start, int length) throws SAXException {
	 
			if (bnname) {
				nameArrayList.add(new String(ch, start, length));
				bnname = false;
			}
	 
			if (btname) {
				textArrayList.add(new String(ch, start, length));
				btname = false;
			} 
			 
			    nameTextArrayList.add(nameArrayList);
			    nameTextArrayList.add(textArrayList);
		}

	     };
	 
	       saxParser.parse(xmlFile, handler);
	 
	     } catch (Exception e) {
	       e.printStackTrace();
	     }
	   
	    return nameTextArrayList;
	   }
		
}