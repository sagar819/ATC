package weatherSpot;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import model.AirCraftSpecs;

public class AcceptedTimeOfAirCraft {
   public static void main(String[] args) {
      boolean isAccepted = false;
      boolean isTime = false;
      boolean isCall = false;
      boolean tempFlag =false;
      String timestamp = null;
      String airCraftName = null;
      //HashMap<String,AirCraftSpecs> mapAirAccept=new HashMap<String,AirCraftSpecs>();  
      //ArrayList <AirCraftSpecs> listAirAccept = new ArrayList<>();
      ArrayList <String> listAirCraftNamesAcceptTime = new ArrayList<>();

    
      
      SimpleDateFormat formatter6=new SimpleDateFormat("EE MMM dd HH:mm:ss yyyy");  
      String date1="Tue Dec 19 11:42:10 2017";
      try {
		Date date2=formatter6.parse(date1);
		System.out.println(date2);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
      HashMap<String,String> mapAirAccept=new HashMap<String,String>();  
      
      //  AirCraftSpecs acs2 = new AirCraftSpecs();
      //AirCraftSpecs acs3 = new AirCraftSpecs();
   //   double totalElapsedTime = 0;
    //  double elapsedTime;
   //        ArrayList <String> listOfEvents = new ArrayList <String> ();
      try {
         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLEventReader eventReader =
         factory.createXMLEventReader(new FileReader("XML_files/Trial1_01_04_perfect10.xml.log"));

         while(eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
               
            switch(event.getEventType()) {
              
        case XMLStreamConstants.START_ELEMENT:
            	      StartElement startElement = event.asStartElement();
                  String qName = startElement.getName().getLocalPart();
                  //System.out.println("qname: "+ qName);
             if (qName.equalsIgnoreCase("new_control")) {
            	 isAccepted = true;
               } 
             
             if (qName.equalsIgnoreCase("time")) {
            	 isTime = true;
               } 
             
             if (qName.equalsIgnoreCase("call")) {
            	 isCall = true;
               } 
               break;

               
               
        case XMLStreamConstants.CHARACTERS:
            	    	Characters characters = event.asCharacters();
               if(isAccepted) {
                System.out.println("Value of new_control :" + characters.getData());

             
                if (characters.getData().equals("accepted")) {
                	tempFlag=true;
                }
                
                 isAccepted = false;
                  
               }
               
               if (!tempFlag && isTime) {
            	   AirCraftSpecs acs1 = new AirCraftSpecs();
						//System.out.println(" timestamp : " + characters.getData());
						 timestamp = characters.getData();
						isTime=false;
						tempFlag=false;
						//mapAirAccept.putIfAbsent(airCraftName, characters.getData());
						listAirCraftNamesAcceptTime.add(timestamp);
					
               }
               
               
               if (!tempFlag && isCall) {
					
					//System.out.println(" timestamp : " + characters.getData());
            	   airCraftName = characters.getData();
					isTime=false;
					tempFlag=false;
					//mapAirAccept.putIfAbsent(airCraftName, characters.getData());
					//mapAirAccept.

					listAirCraftNamesAcceptTime.add(airCraftName);
          }
               break;

        case XMLStreamConstants.END_ELEMENT:
                  EndElement endElement = event.asEndElement();
                  
               if(endElement.getName().getLocalPart().equalsIgnoreCase("wrapper")) {
               // System.out.println("End of Element ");
               //   System.out.println();
               }
               break;
            } 
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (XMLStreamException e) {
         e.printStackTrace();
      }
//   System.out.println("List of diffrent events :");
//      for(int i = 0; i < listOfEvents.size(); i++) {
//          System.out.println(listOfEvents.get(i));
//      }
//   
      
//      System.out.println("timestamp :" + timestamp);
//      System.out.println("airCraftName :" + airCraftName);
      
      
      
      Iterator it = listAirCraftNamesAcceptTime.iterator();
      while (it.hasNext()) {
         System.out.println(it.next());
      }
   }
}