package acceptTimeTrial1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestRun {

	
	public static void main(String[] args) {
		
		String startTime=StartTimeOfSimulator.getStartTimeOfSimulator();
		System.out.println();
		System.out.println("Start time of simulator : " +startTime);
		HashMap<String,String> mapOfAcceptTS=AcceptedTimeOfAirCraftUsingHashMap.getMapOfAcceptedTimes();
	
		//string to date conversion logic
		Date startTS = null;
		SimpleDateFormat formatter6=new SimpleDateFormat("EE MMM dd HH:mm:ss yyyy");  
	    //System.out.println("STartTime :"+ startTime);  
		String date1=startTime;
	      try {
			startTS=formatter6.parse(date1);
		//	System.out.println(startTS);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      Date todaysDate = new Date();
	      long  diffInMillies= todaysDate.getTime() - startTS.getTime();
	    
	    //  System.out.println("diffInSeconds :"+diffInMillies/1000l);
	
	      
	     HashMap<String, String> mapInString=AcceptedTimeOfAirCraftUsingHashMap.getMapOfAcceptedTimes();
	     HashMap<String, Date> dateMap=convertStringMap2DateMap(mapInString); 
	     
	     String startTimeOfSim=StartTimeOfSimulator.getStartTimeOfSimulator();
	     HashMap <String,Long> mapTimeDiffInSec = getTimeDiffStartAccept(startTS, dateMap);
          System.out.println();
	      System.out.println("----Grading for Trial 1---- ");
	      System.out.println();
	      System.out.println("---Grading Criteria of AirCBXX---");
	      System.out.println(" Demerit Points/Credits Classification , ");
	      System.out.println("Acceptance Time : 1. 0-Threshold seconds(too early) : +2 points ");
	      System.out.println("Acceptance Time : 2. Threshold-Threshold+28 seconds(optimum time) : +0 points ");
	      System.out.println("Acceptance Time : 3. Threshold+28-Threshold+28+28 seconds(late) : +2 points ");
	      System.out.println("Acceptance Time : 4. Threshold+28+28-above seconds(too late) : +2 points ");
	      System.out.println("Acceptance Time : 5. never accepted : +4 points ");
	      System.out.println();
//	      System.out.println("---Grading Criteria of AirCB1---");
//	      System.out.println("Points/Credits Classification , ");
//	      System.out.println("Acceptance Time : 1. 0-32 seconds(too early) : +2 points ");
//	      System.out.println("Acceptance Time : 2. 32-60 seconds(optimum time) : +10 points ");
//	      System.out.println("Acceptance Time : 3. 60-90 seconds(late) : +6 points ");
//	      System.out.println("Acceptance Time : 4. 90-above seconds(too late) : +3 points ");
//	      System.out.println("Acceptance Time : 5. never accepted : +0 points ");
	      System.out.println();
	      System.out.println("Start Time of Simulator :" + startTimeOfSim);
	      System.out.println();
		  System.out.println("<AirCraftName = Accepted Timestamp > : "+dateMap);
	      System.out.println();
		  System.out.println("<AirCraftName = Time Taken to accept the aircraft in Seconds > : "+mapTimeDiffInSec);
		  System.out.println();
	      int grandTotal=0;
		  
	      int totalScoreAirCB1=0;
	      Long currentTSInSecAirCB1 =(Long) mapTimeDiffInSec.get("AirCB1") ;
	      long threshold_AirCB1 = 24;    
	      if(currentTSInSecAirCB1 != null) {
	      	  if (currentTSInSecAirCB1 > 0 && currentTSInSecAirCB1 < threshold_AirCB1) {
	        	  totalScoreAirCB1 = totalScoreAirCB1 +2;
	          }else if (currentTSInSecAirCB1 >= threshold_AirCB1 && currentTSInSecAirCB1 <  threshold_AirCB1+28  ) {
	        	  totalScoreAirCB1 = totalScoreAirCB1 +0;
	          }else if (currentTSInSecAirCB1 >= threshold_AirCB1+28 && currentTSInSecAirCB1 <  threshold_AirCB1+28+28  ) {
	        	  totalScoreAirCB1 = totalScoreAirCB1 +2;
	          }else if (currentTSInSecAirCB1 >= threshold_AirCB1+28+28 ) {
	        	  totalScoreAirCB1 = totalScoreAirCB1 +2;
	          }else {
	        	  totalScoreAirCB1 = totalScoreAirCB1 +2;
	          }
	      }else {
        	  totalScoreAirCB1 = totalScoreAirCB1 +2;
          }
	          System.out.println("Demerit Score of AirCB1: "+totalScoreAirCB1+"");
	          grandTotal=grandTotal+totalScoreAirCB1;
	          
	          int totalScoreAirCB8=0;
		      Long currentTSInSecAirCB8 =(Long) mapTimeDiffInSec.get("AirCB8") ;
		      long threshold_AirCB8 = 30;    
		      if(currentTSInSecAirCB8 != null) {
		      	  if (currentTSInSecAirCB8 > 0 && currentTSInSecAirCB8 < threshold_AirCB8) {
		        	  totalScoreAirCB8 = totalScoreAirCB8 +2;
		          }else if (currentTSInSecAirCB8 >= threshold_AirCB8 && currentTSInSecAirCB8 <  threshold_AirCB8+28  ) {
		        	  totalScoreAirCB8 = totalScoreAirCB8 +0;
		          }else if (currentTSInSecAirCB8 >= threshold_AirCB8+28 && currentTSInSecAirCB8 <  threshold_AirCB8+28+28  ) {
		        	  totalScoreAirCB8 = totalScoreAirCB8 +2;
		          }else if (currentTSInSecAirCB8 >= threshold_AirCB8+28+28 ) {
		        	  totalScoreAirCB8 = totalScoreAirCB8 +2;
		          }else {
		        	  totalScoreAirCB8 = totalScoreAirCB8 +4;
		          }
		      }else {
	        	  totalScoreAirCB8 = totalScoreAirCB8 +4;
	          }
		          System.out.println("Demerit Score of AirCB8: "+totalScoreAirCB8+"");
		          grandTotal=grandTotal+totalScoreAirCB8;
		          
		          
		          int totalScoreAirCB6=0;
			      Long currentTSInSecAirCB6 =(Long) mapTimeDiffInSec.get("AirCB6") ;
			      long threshold_AirCB6 = 352;    
			      if(currentTSInSecAirCB6 != null) {
			      	  if (currentTSInSecAirCB6 > 0 && currentTSInSecAirCB6 < threshold_AirCB6) {
			        	  totalScoreAirCB6 = totalScoreAirCB6 +2;
			          }else if (currentTSInSecAirCB6 >= threshold_AirCB6 && currentTSInSecAirCB6 <  threshold_AirCB6+28  ) {
			        	  totalScoreAirCB6 = totalScoreAirCB6 +0;
			          }else if (currentTSInSecAirCB6 >= threshold_AirCB6+28 && currentTSInSecAirCB6 <  threshold_AirCB6+28+28  ) {
			        	  totalScoreAirCB6 = totalScoreAirCB6 +2;
			          }else if (currentTSInSecAirCB6 >= threshold_AirCB6+28+28 ) {
			        	  totalScoreAirCB6 = totalScoreAirCB6 +2;
			          }else {
			        	  totalScoreAirCB6 = totalScoreAirCB6 +4;
			          }
			      }else {
		        	  totalScoreAirCB6 = totalScoreAirCB6 +4;
		          }
			          System.out.println("Demerit Score of AirCB6: "+totalScoreAirCB6+"");
			          grandTotal=grandTotal+totalScoreAirCB6;
		          
			          int totalScoreAirCB15=0;
				      Long currentTSInSecAirCB15 =(Long) mapTimeDiffInSec.get("AirCB15") ;
				      long threshold_AirCB15 = 352;    
				      if(currentTSInSecAirCB15 != null) {
				      	  if (currentTSInSecAirCB15 > 0 && currentTSInSecAirCB15 < threshold_AirCB15) {
				        	  totalScoreAirCB15 = totalScoreAirCB15 +2;
				          }else if (currentTSInSecAirCB15 >= threshold_AirCB15 && currentTSInSecAirCB15 <  threshold_AirCB15+28  ) {
				        	  totalScoreAirCB15 = totalScoreAirCB15 +0;
				          }else if (currentTSInSecAirCB15 >= threshold_AirCB15+28 && currentTSInSecAirCB15 <  threshold_AirCB15+28+28  ) {
				        	  totalScoreAirCB15 = totalScoreAirCB15 +2;
				          }else if (currentTSInSecAirCB15 >= threshold_AirCB15+28+28 ) {
				        	  totalScoreAirCB15 = totalScoreAirCB15 +2;
				          }else {
				        	  totalScoreAirCB15 = totalScoreAirCB15 +4;
				          }
				      }else {
			        	  totalScoreAirCB15 = totalScoreAirCB15 +4;
			          }
				          System.out.println("Demerit Score of AirCB15: "+totalScoreAirCB15+"");
				          grandTotal=grandTotal+totalScoreAirCB15;
				          
				          
				          
				          int totalScoreAirCB10=0;
					      Long currentTSInSecAirCB10 =(Long) mapTimeDiffInSec.get("AirCB10") ;
					      long threshold_AirCB10 = 630;    
					      if(currentTSInSecAirCB10 != null) {
					      	  if (currentTSInSecAirCB10 > 0 && currentTSInSecAirCB10 < threshold_AirCB10) {
					        	  totalScoreAirCB10 = totalScoreAirCB10 +2;
					          }else if (currentTSInSecAirCB10 >= threshold_AirCB10 && currentTSInSecAirCB10 <  threshold_AirCB10+28  ) {
					        	  totalScoreAirCB10 = totalScoreAirCB10 +0;
					          }else if (currentTSInSecAirCB10 >= threshold_AirCB10+28 && currentTSInSecAirCB10 <  threshold_AirCB10+28+28  ) {
					        	  totalScoreAirCB10 = totalScoreAirCB10 +2;
					          }else if (currentTSInSecAirCB10 >= threshold_AirCB10+28+28 ) {
					        	  totalScoreAirCB10 = totalScoreAirCB10 +2;
					          }else {
					        	  totalScoreAirCB10 = totalScoreAirCB10 +4;
					          }
					      }else {
				        	  totalScoreAirCB10 = totalScoreAirCB10 +4;
				          }
					          System.out.println("Demerit Score of AirCB10: "+totalScoreAirCB10+"");
					          grandTotal=grandTotal+totalScoreAirCB10;
					          
					          
					          int totalScoreAirCB9=0;
						      Long currentTSInSecAirCB9 =(Long) mapTimeDiffInSec.get("AirCB9") ;
						      long threshold_AirCB9 = 844;    
						      if(currentTSInSecAirCB9 != null) {
						      	  if (currentTSInSecAirCB9 > 0 && currentTSInSecAirCB9 < threshold_AirCB9) {
						        	  totalScoreAirCB9 = totalScoreAirCB9 +2;
						          }else if (currentTSInSecAirCB9 >= threshold_AirCB9 && currentTSInSecAirCB9 <  threshold_AirCB9+28  ) {
						        	  totalScoreAirCB9 = totalScoreAirCB9 +0;
						          }else if (currentTSInSecAirCB9 >= threshold_AirCB9+28 && currentTSInSecAirCB9 <  threshold_AirCB9+28+28  ) {
						        	  totalScoreAirCB9 = totalScoreAirCB9 +2;
						          }else if (currentTSInSecAirCB9 >= threshold_AirCB9+28+28 ) {
						        	  totalScoreAirCB9 = totalScoreAirCB9 +2;
						          }else {
						        	  totalScoreAirCB9 = totalScoreAirCB9 +4;
						          }
						      }else {
					        	  totalScoreAirCB9 = totalScoreAirCB9 +4;
					          }
						          System.out.println("Demerit Score of AirCB9: "+totalScoreAirCB9+"");
						          grandTotal=grandTotal+totalScoreAirCB9;
						          
						          
						          int totalScoreAirCB4=0;
							      Long currentTSInSecAirCB4 =(Long) mapTimeDiffInSec.get("AirCB4") ;
							      long threshold_AirCB4 = 860;    
							      if(currentTSInSecAirCB4 != null) {
							      	  if (currentTSInSecAirCB4 > 0 && currentTSInSecAirCB4 < threshold_AirCB4) {
							        	  totalScoreAirCB4 = totalScoreAirCB4 +2;
							          }else if (currentTSInSecAirCB4 >= threshold_AirCB4 && currentTSInSecAirCB4 <  threshold_AirCB4+28  ) {
							        	  totalScoreAirCB4 = totalScoreAirCB4 +0;
							          }else if (currentTSInSecAirCB4 >= threshold_AirCB4+28 && currentTSInSecAirCB4 <  threshold_AirCB4+28+28  ) {
							        	  totalScoreAirCB4 = totalScoreAirCB4 +2;
							          }else if (currentTSInSecAirCB4 >= threshold_AirCB4+28+28 ) {
							        	  totalScoreAirCB4 = totalScoreAirCB4 +2;
							          }else {
							        	  totalScoreAirCB4 = totalScoreAirCB4 +4;
							          }
							      }else {
						        	  totalScoreAirCB4 = totalScoreAirCB4 +4;
						          }
							          System.out.println("Demerit Score of AirCB4: "+totalScoreAirCB4+"");
							          grandTotal=grandTotal+totalScoreAirCB4;
							          
							          
							          int totalScoreAirCB7=0;
								      Long currentTSInSecAirCB7 =(Long) mapTimeDiffInSec.get("AirCB7") ;
								      long threshold_AirCB7 = 1042;    
								      if(currentTSInSecAirCB7 != null) {
								      	  if (currentTSInSecAirCB7 > 0 && currentTSInSecAirCB7 < threshold_AirCB7) {
								        	  totalScoreAirCB7 = totalScoreAirCB7 +2;
								          }else if (currentTSInSecAirCB7 >= threshold_AirCB7 && currentTSInSecAirCB7 <  threshold_AirCB7+28  ) {
								        	  totalScoreAirCB7 = totalScoreAirCB7 +0;
								          }else if (currentTSInSecAirCB7 >= threshold_AirCB7+28 && currentTSInSecAirCB7 <  threshold_AirCB7+28+28  ) {
								        	  totalScoreAirCB7 = totalScoreAirCB7 +2;
								          }else if (currentTSInSecAirCB7 >= threshold_AirCB7+28+28 ) {
								        	  totalScoreAirCB7 = totalScoreAirCB7 +2;
								          }else {
								        	  totalScoreAirCB7 = totalScoreAirCB7 +4;
								          }
								      }else {
							        	  totalScoreAirCB7 = totalScoreAirCB7 +4;
							          }
								          System.out.println("Demerit Score of AirCB7: "+totalScoreAirCB7+"");
								          grandTotal=grandTotal+totalScoreAirCB7;
								          
								          
								          int totalScoreAirCB12=0;
									      Long currentTSInSecAirCB12 =(Long) mapTimeDiffInSec.get("AirCB12") ;
									      long threshold_AirCB12 = 1234;    
									      if(currentTSInSecAirCB12 != null) {
									      	  if (currentTSInSecAirCB12 > 0 && currentTSInSecAirCB12 < threshold_AirCB12) {
									        	  totalScoreAirCB12 = totalScoreAirCB12 +2;
									          }else if (currentTSInSecAirCB12 >= threshold_AirCB12 && currentTSInSecAirCB12 <  threshold_AirCB12+28  ) {
									        	  totalScoreAirCB12 = totalScoreAirCB12 +0;
									          }else if (currentTSInSecAirCB12 >= threshold_AirCB12+28 && currentTSInSecAirCB12 <  threshold_AirCB12+28+28  ) {
									        	  totalScoreAirCB12 = totalScoreAirCB12 +2;
									          }else if (currentTSInSecAirCB12 >= threshold_AirCB12+28+28 ) {
									        	  totalScoreAirCB12 = totalScoreAirCB12 +2;
									          }else {
									        	  totalScoreAirCB12 = totalScoreAirCB12 +4;
									          }
									      }else {
								        	  totalScoreAirCB12 = totalScoreAirCB12 +4;
								          }
									          System.out.println("Demerit Score of AirCB12: "+totalScoreAirCB12+"");
									          grandTotal=grandTotal+totalScoreAirCB12;
						          
	        //  Long totalScore3=(long) (totalScore1+totalScore2);
	        //  System.out.println("Demerit Score of AirCB1: "+totalScore2 +"");
	        System.out.println("Total Demerit Score of Trial 1 : "+grandTotal+"");
	     
	      
   
	
	}
	
	public static HashMap <String,Long>  getTimeDiffStartAccept(Date StartOfSim , HashMap<String, Date> mapInDate){
		
		
		HashMap <String,Long> mapOfDateDiff = new HashMap<String,Long>();
		Iterator it = mapInDate.entrySet().iterator();
	      while (it.hasNext()) {
	          Map.Entry pair = (Map.Entry)it.next();
	          
	          Date currentTS = (Date) pair.getValue();
	  		  
	          long  diffInMillies=currentTS.getTime()-StartOfSim.getTime();
	          
	          
	          mapOfDateDiff.put((String) pair.getKey(), diffInMillies/1000l);
	          
	          
	        //  System.out.println(pair.getKey() + " = " + pair.getValue());
	        //  it.remove(); // avoids a ConcurrentModificationException
	      }
		
		System.out.println("Diff in Start and Accepted Time in Seconds with respect to start time of simulator.");
		System.out.println("<AirCraftName = Time Taken to accept the aircraft in Seconds > : : "+mapOfDateDiff);
		System.out.println();
		
		
		
		return mapOfDateDiff;
		
	}
	
	public static HashMap <String,Date> convertStringMap2DateMap(HashMap<String, String> mapInString){
		
		HashMap <String,Date> mapInDate = new HashMap<String,Date>();
		Iterator it = mapInString.entrySet().iterator();
	      while (it.hasNext()) {
	          Map.Entry pair = (Map.Entry)it.next();
	          
	          Date currentTS = null;
	  		SimpleDateFormat formatter6=new SimpleDateFormat("EE MMM dd HH:mm:ss yyyy");  
	  	 //   System.out.println("STartTime :"+ startTime);  
	  		String currentTSinString= (String) pair.getValue();
	  	      try {
	  	    	currentTS=formatter6.parse(currentTSinString);
	  			//System.out.println(currentTS);
	  		} catch (ParseException e1) {
	  			// TODO Auto-generated catch block
	  			e1.printStackTrace();
	  		}
	          
	          
	          mapInDate.put((String) pair.getKey(), currentTS);
	          
	          
	        //  System.out.println(pair.getKey() + " = " + pair.getValue());
	        //  it.remove(); // avoids a ConcurrentModificationException
	      }
		
		System.out.println();
		System.out.println("<AirCraftName = Accepted Timestamp > : "+mapInDate);
	      System.out.println();
		
		return mapInDate;
		
	}
	
	
	
	
}
