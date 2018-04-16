package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class ParseWholeFile {
	public static void main(String[] args) {

		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("XML_files/Trial1.xml.log"));

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				switch (event.getEventType()) {

				case XMLStreamConstants.START_ELEMENT:

					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();
					System.out.println("Node : " + qName);

					break;

				case XMLStreamConstants.CHARACTERS:

					Characters characters = event.asCharacters();

					System.out.println("	Value : " + characters.getData());

					break;

				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement = event.asEndElement();

					if (endElement.getName().getLocalPart().equalsIgnoreCase("info")) {
						System.out.println("End Element of 'info' tag  ");
						//System.out.println();
					}
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}