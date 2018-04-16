package core;



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

public class Events {
   public static void main(String[] args) {
      boolean isEvent = false;
     // double totalElapsedTime = 0;
     // double elapsedTime;
           ArrayList <String> listOfEvents = new ArrayList <String> ();
      try {
         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLEventReader eventReader =
         factory.createXMLEventReader(new FileReader("XML_files/Trial1.xml.log"));

         while(eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
               
            switch(event.getEventType()) {
              
        case XMLStreamConstants.START_ELEMENT:
            	      StartElement startElement = event.asStartElement();
                  String qName = startElement.getName().getLocalPart();
                  //System.out.println("qname: "+ qName);
             if (qName.equalsIgnoreCase("call")) {
            	 isEvent = true;
               } 
               break;

               
               
        case XMLStreamConstants.CHARACTERS:
            	    	Characters characters = event.asCharacters();
               if(isEvent) {
                // System.out.println("Event :" + characters.getData());
                 if (!listOfEvents.contains(characters.getData())) {
                	 listOfEvents.add(characters.getData());
                 }
                  isEvent = false;
                  
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
   System.out.println("List of diffrent events :");
      for(int i = 0; i < listOfEvents.size(); i++) {
          System.out.println(listOfEvents.get(i));
      }
   
   }
}