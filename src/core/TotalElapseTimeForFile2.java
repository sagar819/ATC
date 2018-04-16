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

public class TotalElapseTimeForFile2 {
   public static void main(String[] args) {
      boolean isElapsedTime = false;
      double totalElapsedTime = 0;
      double elapsedTime;
           
      try {
         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLEventReader eventReader =
         factory.createXMLEventReader(new FileReader("XML_files/Trial2.xml.log"));

         while(eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
               
            switch(event.getEventType()) {
              
        case XMLStreamConstants.START_ELEMENT:
            	      StartElement startElement = event.asStartElement();
                  String qName = startElement.getName().getLocalPart();
                  //System.out.println("qname: "+ qName);
             if (qName.equalsIgnoreCase("elapsed_time")) {
            	 isElapsedTime = true;
               } 
               break;

               
               
        case XMLStreamConstants.CHARACTERS:
            	    	Characters characters = event.asCharacters();
               if(isElapsedTime) {
                 // System.out.println(" elapsed_time (String)" + characters.getData());
                  elapsedTime = Long.parseLong(characters.getData());
                  totalElapsedTime += elapsedTime;
                  isElapsedTime = false;
                  System.out.println("Elapsed Time :"+elapsedTime);
                  System.out.println("Total Elapsed Time :"+totalElapsedTime);
               }
               
               break;

        case XMLStreamConstants.END_ELEMENT:
                  EndElement endElement = event.asEndElement();
                  
               if(endElement.getName().getLocalPart().equalsIgnoreCase("info")) {
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
      System.out.println("For file 2 : Trial2.xml.log");
      long longTotalElapsedTime = (long) totalElapsedTime;
      System.out.println("Assuming that total elpased time is addition of all the 'elpased_time' node values.");
      System.out.println("The final value of Total elapsed Time : "+ longTotalElapsedTime);
      
   
   }
}