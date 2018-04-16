package collision_detection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class AcceptedTimeOfAirCraftUsingHashMapCD {
	public static void main(String[] args) {
		getMapOfAcceptedTimes();

	}

	public static HashMap<String, String> getMapOfAcceptedTimes() {
		boolean isAccepted = false;
		boolean isTime = false;
		boolean isCall = false;
		boolean isYpos = false;
		boolean isXpos = false;
		boolean tempFlag = false;
		String timestamp = null;
		String airCraftName = null;
		String tempTS = "";
		String xpos = null;
		String ypos = null;
		ArrayList<String> listAirCraftAcceptTime = new ArrayList<>();
		ArrayList<String> listAirCraftNames = new ArrayList<>();
		HashMap<String, ArrayList<CDPojoj>> mapAirAccept = new HashMap<String, ArrayList<CDPojoj>>();
		ArrayList<CDPojoj> arrayList = new ArrayList<CDPojoj>();
		HashMap<String, CDPojoj> mapAirAcceptCD;
		CDPojoj cdpojo;
		ArrayList<CDDetectedPojo> colliedAirCrafts = new ArrayList<CDDetectedPojo>();
		// double totalElapsedTime = 0;
		// double elapsedTime;
		// ArrayList <String> listOfEvents = new ArrayList <String> ();
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			String filname = "Trial2.xml.log";
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("XML_files/" + filname));

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				switch (event.getEventType()) {

				case XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();
					// System.out.println("qname: "+ qName);
					if (qName.equalsIgnoreCase("new_control")) {
						isAccepted = true;
					}

					if (qName.equalsIgnoreCase("time")) {
						isTime = true;
					}

					if (qName.equalsIgnoreCase("call")) {
						isCall = true;
					}

					if (qName.equalsIgnoreCase("xpos")) {
						isXpos = true;
					}

					if (qName.equalsIgnoreCase("ypos")) {
						isYpos = true;
					}

					break;

				case XMLStreamConstants.CHARACTERS:
					Characters characters = event.asCharacters();
					if (isAccepted) {

						// if (!listOfEvents.contains(characters.getData())) {
						// listOfEvents.add(characters.getData());
						// }
						if (characters.getData().equals("accepted")) {
							tempFlag = true;
							// System.out.println("Value of new_control :" + characters.getData());
						}

					}

					if (isTime) {

						// System.out.println(" timestamp : " + characters.getData());
						timestamp = characters.getData();
						// listAirCraftNamesAcceptTime.add(timestamp);
						isTime = false;

					}

					if (isCall) {

						// System.out.println(" aircraftname : " + characters.getData());
						airCraftName = characters.getData();
						// listAirCraftNamesAcceptTime.add(airCraftName);
						isCall = false;
					}

					if (isXpos) {

						// System.out.println(" Xpos : " + characters.getData());
						xpos = characters.getData();
						// listAirCraftNamesAcceptTime.add(airCraftName);
						isXpos = false;
					}

					if (isYpos) {

						// System.out.println(" Ypos : " + characters.getData());
						ypos = characters.getData();
						// System.out.println();
						// System.out.println();
						cdpojo = new CDPojoj();

						cdpojo.setAirCraftID(airCraftName);
						cdpojo.setTSString(timestamp);
						// tempTS=timestamp;
						cdpojo.setXpos(Double.parseDouble(xpos));
						cdpojo.setYpos(Double.parseDouble(ypos));
						// System.out.println(cdpojo);
						arrayList.add(cdpojo);
						if (!tempTS.equals(timestamp)) {
							// System.out.println(arrayList);
							// System.out.println();
							mapAirAccept.put(tempTS, arrayList);
							arrayList = new ArrayList<CDPojoj>();
						}

						tempTS = timestamp;

						// airCraftName = characters.getData();
						// listAirCraftNamesAcceptTime.add(airCraftName);
						isYpos = false;
					}

					// if(tempFlag) {
					// listAirCraftNames.add(airCraftName);
					// System.out.println("List1 Status :"+listAirCraftNames);
					// listAirCraftAcceptTime.add(timestamp);
					// System.out.println("List2 Status :"+listAirCraftAcceptTime);
					// System.out.println("timestamp :" + timestamp);
					// System.out.println("aircraft:"+ airCraftName);
					// mapAirAccept.put(airCraftName, timestamp);
					tempFlag = false;

					// }

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
		// System.out.println(mapAirAccept.get("Wed Jan 17 08:34:22 2018"));
		// System.out.println("hashmap : "+mapAirAccept);
		// return mapAirAccept;
		// System.out.println(mapAirAccept);
		// System.out.println(mapAirAccept.keySet());
		// System.out.println(mapAirAccept.get("Thu Mar 1 13:40:44 2018"));
		Iterator it = mapAirAccept.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			// System.out.println("Key: "+pair.getKey()+"Value :"+pair.getValue());
			ArrayList<CDPojoj> currentCDpojoListStart2End = (ArrayList<CDPojoj>) pair.getValue();
			ArrayList<CDPojoj> currentCDpojoListEnd2Start = (ArrayList<CDPojoj>) pair.getValue();
			// System.out.println(currentCDpojoListStart2End);
			for (int i = 0; i < currentCDpojoListStart2End.size(); i++) {
				for (int j = 0; j < currentCDpojoListEnd2Start.size(); j++) {
					String ts1 = currentCDpojoListStart2End.get(i).getTSString();
					String ts2 = currentCDpojoListEnd2Start.get(j).getTSString();
					// System.out.println(ts1);
					// System.out.println(ts2);

					double xDist = currentCDpojoListStart2End.get(i).getXpos()
							- currentCDpojoListEnd2Start.get(j).getXpos();
					double yDist = currentCDpojoListStart2End.get(i).getYpos()
							- currentCDpojoListEnd2Start.get(j).getYpos();
					double xDistSq = xDist * xDist;
					double yDistSq = yDist * yDist;
					double addXYDist = xDistSq + yDistSq;
					double actDist = Math.sqrt(addXYDist);

					double xDistFrmCenter = currentCDpojoListStart2End.get(i).getXpos() - 84.6;
					double yDistFrmCenter = currentCDpojoListStart2End.get(i).getYpos() - 49.5;
					double xDistFrmCenterSq = xDistFrmCenter * xDistFrmCenter;
					double yDistFrmCenterSq = yDistFrmCenter * yDistFrmCenter;
					double addXYDistFrmCenter = xDistFrmCenterSq + yDistFrmCenterSq;
					double actDistFrmCenter = Math.sqrt(addXYDistFrmCenter);

					double x2DistFrmCenter = currentCDpojoListStart2End.get(j).getXpos() - 84.6;
					double y2DistFrmCenter = currentCDpojoListStart2End.get(j).getYpos() - 49.5;
					double x2DistFrmCenterSq = x2DistFrmCenter * x2DistFrmCenter;
					double y2DistFrmCenterSq = y2DistFrmCenter * y2DistFrmCenter;
					double addXY2DistFrmCenter = x2DistFrmCenterSq + y2DistFrmCenterSq;
					double act2DistFrmCenter = Math.sqrt(addXY2DistFrmCenter);

					if (act2DistFrmCenter < 175 && act2DistFrmCenter < 175) {
						if (xDist != 0 && yDist != 0) {
							if (actDist < 10 && actDist != 0) {

								System.out.println("AirCraft 1 :" + currentCDpojoListStart2End.get(i).getAirCraftID()
										+ currentCDpojoListStart2End.get(i).getXpos()
										+ currentCDpojoListStart2End.get(i).getYpos());
								System.out.println("AirCraft 2 :" + currentCDpojoListStart2End.get(j).getAirCraftID()
										+ currentCDpojoListEnd2Start.get(j).getXpos()
										+ currentCDpojoListEnd2Start.get(j).getYpos());
								System.out.println("Distance :" + actDist);
								//System.out.println(ts1);
								//System.out.println(ts2);
								CDDetectedPojo cdd = new CDDetectedPojo();
								cdd.setAirCraftID1(currentCDpojoListStart2End.get(i).getAirCraftID());
								cdd.setAirCraftID2(currentCDpojoListEnd2Start.get(j).getAirCraftID());
								cdd.setDistance(actDist);
								cdd.setTS1String(currentCDpojoListStart2End.get(i).getTSString());
								cdd.setTS2String(currentCDpojoListEnd2Start.get(j).getTSString());
								colliedAirCrafts.add(cdd);
							}
						}
					}

				}
			}

			// System.out.println(pair.getValue());

			// long diffInMillies=currentTS.getTime()-StartOfSim.getTime();

			// mapOfDateDiff.put((String) pair.getKey(), diffInMillies/1000l);

			// System.out.println(pair.getKey() + " = " + pair.getValue());
			// it.remove(); // avoids a ConcurrentModificationException
		}

		// System.out.println(colliedAirCrafts);
		System.out.println();
		// ArrayList<CDDetectedPojo> colliedAirCraftsSorted = new
		// ArrayList<CDDetectedPojo>();

		// System.out.println(colliedAirCraftsSorted);
		System.out.println();
		ArrayList<String> flist = new ArrayList<String>();
		for (int k = 0; k < colliedAirCrafts.size(); k++) {
			flist.add(colliedAirCrafts.get(k).AirCraftID1);
			flist.add(colliedAirCrafts.get(k).AirCraftID2);
		}
		Set<String> hs = new HashSet<String>();
		hs.addAll(flist);
		//System.out.println("set :" + hs);
		System.out.println("Collided Aircrafts List :" + hs);
		//System.out.println("len :" + hs.size());
		System.out.println("Total Nof of collided aircrafts :" + hs.size());
		int cdScore=0;
		if(hs.size()!=0) {
		if (hs.size() % 2 == 0) {
			cdScore=(hs.size()/2)*10;
		}else {
			
			cdScore=((hs.size()+1)/2)*10;
		}
		}else {
			System.out.println("No Collision Detected");
		}
		
		System.out.println("Collision Detection Demerit Points :" + cdScore );
		return null;
	}
}