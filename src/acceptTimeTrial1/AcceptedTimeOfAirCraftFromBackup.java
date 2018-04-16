//package acceptTimeTrial1;
//
//
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.ArrayList;
//
//import javax.xml.stream.XMLEventReader;
//import javax.xml.stream.XMLInputFactory;
//import javax.xml.stream.XMLStreamConstants;
//import javax.xml.stream.XMLStreamException;
//import javax.xml.stream.events.Characters;
//import javax.xml.stream.events.EndElement;
//import javax.xml.stream.events.StartElement;
//import javax.xml.stream.events.XMLEvent;
//
//public class AcceptedTimeOfAirCraftFromBackup {
//   public static void main(String[] args) {
//      boolean isAccepted = false;
//      boolean isTime = false;
//      boolean isCall = false;
//      boolean tempFlag =false;
//      String timestamp = null;
//      String airCraftName = null;
//      ArrayList <String> listAirCraftAcceptTime = new ArrayList<>();
//      ArrayList <String> listAirCraftNames = new ArrayList<>();
//     // double totalElapsedTime = 0;
//     // double elapsedTime;
//          // ArrayList <String> listOfEvents = new ArrayList <String> ();
//      try {
//         XMLInputFactory factory = XMLInputFactory.newInstance();
//         XMLEventReader eventReader =
//         factory.createXMLEventReader(new FileReader("XML_files/Trial1_01_26_18.xml.log"));
//
//         while(eventReader.hasNext()) {
//            XMLEvent event = eventReader.nextEvent();
//               
//            switch(event.getEventType()) {
//              
//        case XMLStreamConstants.START_ELEMENT:
//            	      StartElement startElement = event.asStartElement();
//                  String qName = startElement.getName().getLocalPart();
//                  //System.out.println("qname: "+ qName);
//             if (qName.equalsIgnoreCase("new_control")) {
//            	 isAccepted = true;
//               } 
//             
//             if (qName.equalsIgnoreCase("time")) {
//            	 isTime = true;
//               } 
//             
//             if (qName.equalsIgnoreCase("call")) {
//            	 isCall = true;
//               } 
//               break;
//
//               
//               
//        case XMLStreamConstants.CHARACTERS:
//            	    	Characters characters = event.asCharacters();
//               if(isAccepted) {
//               
////                 if (!listOfEvents.contains(characters.getData())) {
////                	 listOfEvents.add(characters.getData());
////                 }
//                if (characters.getData().equals("accepted")) {
//                	tempFlag=true;
//                	 System.out.println("Value of new_control :" + characters.getData());
//                }
//                
//                 
//                  
//               }
//               
//               if (isTime) {
//					
//					//	System.out.println(" timestamp : " + characters.getData());
//						 timestamp = characters.getData();
//						 //listAirCraftNamesAcceptTime.add(timestamp);
//						isTime=false;
//					
//						
//					
//               }
//               
//               
//               if (isCall) {
//					
//				//	System.out.println(" aircraftname : " + characters.getData());
//            	   airCraftName = characters.getData();
//            	   //listAirCraftNamesAcceptTime.add(airCraftName);
//            	   isCall=false;
//
//				
//          }
//               
//               if(tempFlag) {
//            	   listAirCraftNames.add(airCraftName);
//            	   System.out.println("List1 Status :"+listAirCraftNames);
//            	   listAirCraftAcceptTime.add(timestamp);
//            	   System.out.println("List2 Status :"+listAirCraftAcceptTime);
//            	   tempFlag=false;
//            	   
//               }
//               
//               
//               break;
//
//        case XMLStreamConstants.END_ELEMENT:
//                  EndElement endElement = event.asEndElement();
//                  
//               if(endElement.getName().getLocalPart().equalsIgnoreCase("wrapper")) {
//               // System.out.println("End of Element ");
//               //   System.out.println();
//               }
//               break;
//            } 
//         }
//      } catch (FileNotFoundException e) {
//         e.printStackTrace();
//      } catch (XMLStreamException e) {
//         e.printStackTrace();
//      }
////   System.out.println("List of diffrent events :");
////      for(int i = 0; i < listOfEvents.size(); i++) {
////          System.out.println(listOfEvents.get(i));
////      }
////   
////     System.out.println(listAirCraftNamesAcceptTime.toString());
////      System.out.println("timestamp :" + timestamp);
////      System.out.println("airCraftName :" + airCraftName);
//      
//   }
//}