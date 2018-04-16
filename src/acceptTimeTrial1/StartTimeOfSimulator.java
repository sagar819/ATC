package acceptTimeTrial1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StartTimeOfSimulator {
	public static void main(String[] args) {
		StartTimeOfSimulator.getStartTimeOfSimulator();
	}
	
	public static String getStartTimeOfSimulator() {
		boolean isLog = false;
		boolean isTime = false;
		// boolean isCall = false;
		boolean tempFlag = false;
		String startTimeOfSim = null;
		String startTag = null;
		// String airCraftName = null;
		// double totalElapsedTime = 0;
		// double elapsedTime;
		// ArrayList <String> listOfEvents = new ArrayList <String> ();
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			 String filname="Trial1_01_04_perfect10.xml.log";
			XMLEventReader eventReader = factory
					.createXMLEventReader(new FileReader("XML_files/"+filname));

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				switch (event.getEventType()) {

				case XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();
					// System.out.println("qname: "+ qName);
					if (qName.equalsIgnoreCase("log")) {
						isLog = true;
					}

					if (qName.equalsIgnoreCase("time")) {
						isTime = true;
					}

					break;

				case XMLStreamConstants.CHARACTERS:
					Characters characters = event.asCharacters();
					if (isLog) {

						// if (!listOfEvents.contains(characters.getData())) {
						// listOfEvents.add(characters.getData());
						// }
						if (characters.getData().equals("start")) {
							tempFlag = true;
							startTag = characters.getData();
						}

						isLog = false;

					}

					if (!tempFlag && isTime) {

						// System.out.println(" timestamp : " + characters.getData());
						startTimeOfSim = characters.getData();
						isTime = false;
						tempFlag = false;

					}

					break;

				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement = event.asEndElement();

					if (endElement.getName().getLocalPart().equalsIgnoreCase("wrapper")) {
						// System.out.println("End of Element ");
						// System.out.println();
					}
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		// System.out.println("List of diffrent events :");
		// for(int i = 0; i < listOfEvents.size(); i++) {
		// System.out.println(listOfEvents.get(i));
		// }
		//
		//System.out.println("");
		//System.out.println("start logTag Value  :" + startTag);
		//System.out.println("startTimeOfSim :" + startTimeOfSim);
		// System.out.println("airCraftName :" + airCraftName);
		return startTimeOfSim;
	}
}