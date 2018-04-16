package CreateReportTrial1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestRunTrial1 {
	public TestRunTrial1() throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated constructor stub
		 
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		 PrintWriter writer = new PrintWriter("Report/Trial1_Report.txt", "UTF-8");
		//writer.println("The first line");
		//writer.println("The second line");
		//writer.close();
		String startTime=StartTimeOfSimulatorTrail1.getStartTimeOfSimulator();
		//writer.println();
		writer.println("Start time of simulator : " +startTime);
		HashMap<String,String> mapOfAcceptTS=FinalAcceptedTimeOfAirCraftUsingHashMap.getMapOfAcceptedTimes();
	
		//string to date conversion logic
		Date startTS = null;
		SimpleDateFormat formatter6=new SimpleDateFormat("EE MMM dd HH:mm:ss yyyy");  
	    //writer.println("STartTime :"+ startTime);  
		String date1=startTime;
	      try {
			startTS=formatter6.parse(date1);
		//	writer.println(startTS);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      Date todaysDate = new Date();
	      long  diffInMillies= todaysDate.getTime() - startTS.getTime();
	    
	    //  writer.println("diffInSeconds :"+diffInMillies/1000l);
	
	      
	     HashMap<String, String> mapInString=FinalAcceptedTimeOfAirCraftUsingHashMap.getMapOfAcceptedTimes();
	     HashMap<String, Date> dateMap=convertStringMap2DateMap(mapInString); 
	     
	     String startTimeOfSim=StartTimeOfSimulatorTrail1.getStartTimeOfSimulator();
	     HashMap <String,Long> mapTimeDiffInSec = getTimeDiffStartAccept(startTS, dateMap);
          writer.println();
	      writer.println("----Grading for Trial 1---- ");
	      writer.println();
	      writer.println("---Grading Criteria of AirCBXX---");
	      writer.println(" Demerit Points/Credits Classification , ");
	      writer.println("Acceptance Time : 1. 0-Threshold seconds(too early) : +2 points ");
	      writer.println("Acceptance Time : 2. Threshold-Threshold+28 seconds(optimum time) : +0 points ");
	      writer.println("Acceptance Time : 3. Threshold+28-Threshold+28+28 seconds(late) : +2 points ");
	      writer.println("Acceptance Time : 4. Threshold+28+28-above seconds(too late) : +2 points ");
	      writer.println("Acceptance Time : 5. never accepted : +4 points ");
	      writer.println();
//	      writer.println("---Grading Criteria of AirCB1---");
//	      writer.println("Points/Credits Classification , ");
//	      writer.println("Acceptance Time : 1. 0-32 seconds(too early) : +2 points ");
//	      writer.println("Acceptance Time : 2. 32-60 seconds(optimum time) : +10 points ");
//	      writer.println("Acceptance Time : 3. 60-90 seconds(late) : +6 points ");
//	      writer.println("Acceptance Time : 4. 90-above seconds(too late) : +3 points ");
//	      writer.println("Acceptance Time : 5. never accepted : +0 points ");
	      writer.println();
	      writer.println("Start Time of Simulator :" + startTimeOfSim);
	      //writer.println();
		  writer.println("<AirCraftName = Accepted Timestamp > : "+dateMap);
	      //writer.println();
		  writer.println("<AirCraftName = Time Taken to accept the aircraft in Seconds > : "+mapTimeDiffInSec);
		  //writer.println();
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
	         writer.println("Demerit Score of AirCB1: "+totalScoreAirCB1+"");
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
		         writer.println("Demerit Score of AirCB8: "+totalScoreAirCB8+"");
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
			         writer.println("Demerit Score of AirCB6: "+totalScoreAirCB6+"");
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
				          writer.println("Demerit Score of AirCB15: "+totalScoreAirCB15+"");
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
					         writer.println("Demerit Score of AirCB10: "+totalScoreAirCB10+"");
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
						          writer.println("Demerit Score of AirCB9: "+totalScoreAirCB9+"");
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
							          writer.println("Demerit Score of AirCB4: "+totalScoreAirCB4+"");
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
								          writer.println("Demerit Score of AirCB7: "+totalScoreAirCB7+"");
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
									          writer.println("Demerit Score of AirCB12: "+totalScoreAirCB12+"");
									          grandTotal=grandTotal+totalScoreAirCB12;
						          
	        //  Long totalScore3=(long) (totalScore1+totalScore2);
	        //  writer.println("Demerit Score of AirCB1: "+totalScore2 +"");
	        writer.println(" Demerit Score of Trial 1 ( Accept time ): "+grandTotal+"");
	        ArrayList <CDFinalBean> hs =   AcceptedTimeOfAirCraftUsingHashMapCDTrial1.getMapOfAcceptedTimes();
	        ArrayList <CDFinalBean> sortedList = new ArrayList<CDFinalBean>();
	        //Set<CDFinalBean> hs2 =   AcceptedTimeOfAirCraftUsingHashMapCDTrial1.getMapOfAcceptedTimes();
	        
	        for (int i=0;i<hs.size();i++) {
	        	 for (int j=0;j<hs.size();j++) {
	        		 if(i!=j && hs.size() > i && hs.size() > j) {
	        			
	        		 if (   hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft1()) || hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft2())  ) {
	        			
	        			 if (	hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft1()) || hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft2())   ){
//	        				System.out.println("First if :");
//	        				 System.out.println(hs.get(i));
//	        				 System.out.println(hs.get(j));
	        				 hs.remove(i);
	        				 
		        		 }
	        			 
	        			 
	        		 }
	        		 

	        				
	        	 }
	        		 if(i!=j && hs.size() > i && hs.size() > j) {
	        		 if (	hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft1()) && hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft2())   ){
//        				 System.out.println("second  if :");
//        				 System.out.println(hs.get(i));
//        				 System.out.println(hs.get(j));
        				 hs.remove(i);
	        		 }
	        		 }
	        		 
	        		 
	        		 if(i!=j && hs.size() > i && hs.size() > j) {
		        		 if (	hs.get(i).getAirCraft1().equals(hs.get(i).getAirCraft2())   ){
//	        				 System.out.println("second  if :");
//	        				 System.out.println(hs.get(i));
	        				 //System.out.println(hs.get(j));
	        				 hs.remove(i);
		        		 }
		        		 }
	        		 
	        }
	        }
	        for (int i=0;i<hs.size();i++) {
	        	 for (int j=0;j<hs.size();j++) {
	        		 if(i!=j && hs.size() > i && hs.size() > j) {
	        			
	        		 if (   hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft1()) || hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft2())  ) {
	        			
	        			 if (	hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft1()) || hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft2())   ){
//	        				System.out.println("First if :");
//	        				 System.out.println(hs.get(i));
//	        				 System.out.println(hs.get(j));
	        				 hs.remove(i);
	        				 
		        		 }
	        			 
	        			 
	        		 }
	        		 

	        				
	        	 }
	        		 if(i!=j && hs.size() > i && hs.size() > j) {
	        		 if (	hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft1()) && hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft2())   ){
//       				 System.out.println("second  if :");
//       				 System.out.println(hs.get(i));
//       				 System.out.println(hs.get(j));
       				 hs.remove(i);
	        		 }
	        		 }
	        		 
	        		 
	        		 if(i!=j && hs.size() > i && hs.size() > j) {
		        		 if (	hs.get(i).getAirCraft1().equals(hs.get(i).getAirCraft2())   ){
//	        				 System.out.println("second  if :");
//	        				 System.out.println(hs.get(i));
	        				 //System.out.println(hs.get(j));
	        				 hs.remove(i);
		        		 }
		        		 }
	        		 
	        }
	        }
	        
	        
	        for (int i=0;i<hs.size();i++) {
	        	 for (int j=0;j<hs.size();j++) {
	        		 if(i!=j && hs.size() > i && hs.size() > j) {
	        			
	        		 if (   hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft1()) || hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft2())  ) {
	        			
	        			 if (	hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft1()) || hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft2())   ){
//	        				System.out.println("First if :");
//	        				 System.out.println(hs.get(i));
//	        				 System.out.println(hs.get(j));
	        				 hs.remove(i);
	        				 
		        		 }
	        			 
	        			 
	        		 }
	        		 

	        				
	        	 }
	        		 if(i!=j && hs.size() > i && hs.size() > j) {
	        		 if (	hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft1()) && hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft2())   ){
//      				 System.out.println("second  if :");
//      				 System.out.println(hs.get(i));
//      				 System.out.println(hs.get(j));
      				 hs.remove(i);
	        		 }
	        		 }
	        		 
	        		 
	        		 if(i!=j && hs.size() > i && hs.size() > j) {
		        		 if (	hs.get(i).getAirCraft1().equals(hs.get(i).getAirCraft2())   ){
	        			//	 System.out.println("second  if :");
	        			//	 System.out.println(hs.get(i));
	        				 //System.out.println(hs.get(j));
	        				 hs.remove(i);
		        		 }
		        		 }
	        		 
	        }
	        }
	        System.out.println("list 1 :"+hs);	 
	        //System.out.println("sorted list : " + sortedList);
//	        ArrayList <CDFinalBean> sortedList2 = new ArrayList<CDFinalBean>();
//	        for (int i=0;i<sortedList.size();i++) {
//	        	 for (int j=0;j<sortedList.size();j++) {
//	        		 if(i!=j) {
//	        		 if (sortedList.get(i).getAirCraft1().equals(sortedList.get(j).getAirCraft1()) && sortedList.get(i).getAirCraft2().equals(sortedList.get(j).getAirCraft2())
//	        				
////	        				 && 
////	        				 ((hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft1()))
////	    	        				 && ( hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft2())))
////	        				 &&
////	        				 ((hs.get(i).getAirCraft1().equals(hs.get(j).getAirCraft2()))
////	    	        				 && ( hs.get(i).getAirCraft2().equals(hs.get(j).getAirCraft2())))
//	        				 ) {
//	        			 
//	        		 }else {
//	        			 sortedList2.add(sortedList.get(i));
//	        			 sortedList2.add(sortedList.get(j));
//	        		 }
//	        		 }
//	        	 }
//	        }
//	        
//	        System.out.println("sorted list : " + sortedList2);
	        
//	        writer.println("Collided Aircrafts List :" + hs);
//			//writer.println("len :" + hs.size());
//			writer.println("Total Nof of collided aircrafts :" + hs.size());
//			int cdScore=0;
//			if(hs.size()!=0) {
//			if (hs.size() % 2 == 0) {
//				cdScore=(hs.size()/2)*10;
//			}else {
//				
//				cdScore=((hs.size()+1)/2)*10;
//			}
//			}else {
//				writer.println("No Collision Detected");
//			}
//			
//			writer.println(" Demerit Score of Trial 1 (Collision Detection) :" + cdScore );
//			
//			int TotalTrial1=cdScore+grandTotal;
//			writer.println(" Total Demerit Score of Trial 1 :" + TotalTrial1 );
//			writer.println("*************************");
			
	      writer.close();
	       
	        
	
	}
	
	public static HashMap <String,Long>  getTimeDiffStartAccept(Date StartOfSim , HashMap<String, Date> mapInDate) throws FileNotFoundException, UnsupportedEncodingException{
		
		//PrintWriter writer = new PrintWriter("Report/Trial1_Report.txt", "UTF-8");
		//PrintWriter wr = new PrintWriter(new FileOutputStream(new File("Report/Trial1_Report.txt"),true /* append = true */));
		
		HashMap <String,Long> mapOfDateDiff = new HashMap<String,Long>();
		Iterator it = mapInDate.entrySet().iterator();
	      while (it.hasNext()) {
	          Map.Entry pair = (Map.Entry)it.next();
	          
	          Date currentTS = (Date) pair.getValue();
	  		  
	          long  diffInMillies=currentTS.getTime()-StartOfSim.getTime();
	          
	          
	          mapOfDateDiff.put((String) pair.getKey(), diffInMillies/1000l);
	          
	          
	        //  writer.println(pair.getKey() + " = " + pair.getValue());
	        //  it.remove(); // avoids a ConcurrentModificationException
	      }
		
	    //  wr.append("Diff in Start and Accepted Time in Seconds with respect to start time of simulator.");
	   //   wr.append("<AirCraftName = Time Taken to accept the aircraft in Seconds > : : "+mapOfDateDiff);
	    //  wr.close();
		
		
		
		return mapOfDateDiff;
		
	}
	
	public static HashMap <String,Date> convertStringMap2DateMap(HashMap<String, String> mapInString) throws FileNotFoundException, UnsupportedEncodingException{
	//	PrintWriter wr = new PrintWriter(new FileOutputStream(new File("Report/Trial1_Report.txt"),true /* append = true */));
		HashMap <String,Date> mapInDate = new HashMap<String,Date>();
		Iterator it = mapInString.entrySet().iterator();
	      while (it.hasNext()) {
	          Map.Entry pair = (Map.Entry)it.next();
	          
	          Date currentTS = null;
	  		SimpleDateFormat formatter6=new SimpleDateFormat("EE MMM dd HH:mm:ss yyyy");  
	  	 //   writer.println("STartTime :"+ startTime);  
	  		String currentTSinString= (String) pair.getValue();
	  	      try {
	  	    	currentTS=formatter6.parse(currentTSinString);
	  			//writer.println(currentTS);
	  		} catch (ParseException e1) {
	  			// TODO Auto-generated catch block
	  			e1.printStackTrace();
	  		}
	          
	          
	          mapInDate.put((String) pair.getKey(), currentTS);
	          
	          
	        //  writer.println(pair.getKey() + " = " + pair.getValue());
	        //  it.remove(); // avoids a ConcurrentModificationException
	      }
		
	      //wr.println();
	    //  wr.append("<AirCraftName = Accepted Timestamp > : "+mapInDate);
	    //  wr.println();
	      //wr.close();
		
	   
		return mapInDate;
		
		
		
	}
	
	
	
	
}
