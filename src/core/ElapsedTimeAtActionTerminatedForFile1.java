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

public class ElapsedTimeAtActionTerminatedForFile1 {
	public static void main(String[] args) {
		boolean isElapsedTime = false;
		boolean isAction = false;
		double totalElapsedTime = 0;
		double elapsedTimeTemp = 0;

		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("XML_files/Trial1.xml.log"));

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				switch (event.getEventType()) {

				case XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();

					if (qName.equalsIgnoreCase("elapsed")) {
						isElapsedTime = true;
					}
					if (qName.equalsIgnoreCase("action")) {
						isAction = true;
					}
					break;

				case XMLStreamConstants.CHARACTERS:
					Characters characters = event.asCharacters();

					if (isElapsedTime) {
						elapsedTimeTemp = Long.parseLong(characters.getData());
						isElapsedTime = false;

					}

					if (isAction) {
						if (characters.getData().equals("terminated")) {
							System.out.println(" action : " + characters.getData());
							System.out.println("elapsedTimeTemp :" + elapsedTimeTemp);
							totalElapsedTime += elapsedTimeTemp;
						}
					}

					break;

				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement = event.asEndElement();

					if (endElement.getName().getLocalPart().equalsIgnoreCase("wrapper")) {
						System.out.println("End of Element ");
						System.out.println();
					}
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

		System.out.println("For file :  Trail1.xml.log");
		System.out.println("Assuming that total elpased time is addition of all the 'elpased' node values when action node is 'terminated'");
		System.out.println("Total elapsed time in milliseconds : " + totalElapsedTime);
		System.out.println("Total elapsed time in seconds : " + totalElapsedTime / 1000);
	}
}