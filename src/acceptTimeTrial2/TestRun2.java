package acceptTimeTrial2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestRun2 {

	public static void main(String[] args) {

		String startTime = StartTimeOfSimulator2.getStartTimeOfSimulator();
		System.out.println();
		//System.out.println("Start time of simulator : " + startTime);
		HashMap<String, String> mapOfAcceptTS = AcceptedTimeOfAirCraftUsingHashMap2.getMapOfAcceptedTimes();

		// string to date conversion logic
		Date startTS = null;
		SimpleDateFormat formatter6 = new SimpleDateFormat("EE MMM dd HH:mm:ss yyyy");
		// System.out.println("STartTime :"+ startTime);
		String date1 = startTime;
		try {
			startTS = formatter6.parse(date1);
			// System.out.println(startTS);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date todaysDate = new Date();
		long diffInMillies = todaysDate.getTime() - startTS.getTime();

		// System.out.println("diffInSeconds :"+diffInMillies/1000l);

		HashMap<String, String> mapInString = AcceptedTimeOfAirCraftUsingHashMap2.getMapOfAcceptedTimes();
		HashMap<String, Date> dateMap = convertStringMap2DateMap(mapInString);

		String startTimeOfSim = StartTimeOfSimulator2.getStartTimeOfSimulator();
		HashMap<String, Long> mapTimeDiffInSec = getTimeDiffStartAccept(startTS, dateMap);
		System.out.println();
		System.out.println("----Grading for Trial 2---- ");
		System.out.println();
		System.out.println("---Grading Criteria of AirCB#---");
		System.out.println("Demerit Points/Credits Classification , ");
		System.out.println("Abbrevation , OST : Optimum Start Time");
		System.out.println("Acceptance Time : 1. 0-OST(too early) : +2 points ");
		System.out.println("Acceptance Time : 2. OST-OST+9 seconds(optimum time) : +0 points ");
		System.out.println("Acceptance Time : 3. OST+9-OST+18 seconds(late) : +2 points ");
		System.out.println("Acceptance Time : 4. OST+18-above seconds(too late) : +2 points ");
		System.out.println("Acceptance Time : 5. never accepted : +4 points ");
		System.out.println();
		System.out.println("Start Time of Simulator :" + startTimeOfSim);
		System.out.println();
		System.out.println("<AirCraftName = Accepted Timestamp > : " + dateMap);
		System.out.println();
		System.out.println("<AirCraftName = Time Taken to accept the aircraft in Seconds > : " + mapTimeDiffInSec);
		System.out.println();
		int totalScore = 0;

		int score_AirCB1 = 0;
		Long currentTSInSecAirCB1 = (Long) mapTimeDiffInSec.get("AirCB1"); // set aircraft name
		long threshold_AirCB1 = 23; // set threshold
		if (currentTSInSecAirCB1 != null) {
			if (currentTSInSecAirCB1 > 0 && currentTSInSecAirCB1 < threshold_AirCB1) {
				score_AirCB1 = score_AirCB1 + 2;
			} else if (currentTSInSecAirCB1 >= threshold_AirCB1 && currentTSInSecAirCB1 < threshold_AirCB1 + 9) {
				score_AirCB1 = score_AirCB1 +0;
			} else if (currentTSInSecAirCB1 >= threshold_AirCB1 + 9 && currentTSInSecAirCB1 < threshold_AirCB1 + 18) {
				score_AirCB1 = score_AirCB1 + 2;
			} else if (currentTSInSecAirCB1 >= threshold_AirCB1 + 18) {
				score_AirCB1 = score_AirCB1 +2;
			}
		}
		System.out.println(" Score of AirCB1: " + score_AirCB1 + "");
		totalScore = totalScore + score_AirCB1; // set score_AirCraftName

		int score_AirCB2 = 0;
		Long currentTSInSecAirCB2 = (Long) mapTimeDiffInSec.get("AirCB2"); // set aircraft name
		long threshold_AirCB2 = 19; // set threshold
		if (currentTSInSecAirCB2 != null) {
			if (currentTSInSecAirCB2 > 0 && currentTSInSecAirCB2 < threshold_AirCB2) { //
				score_AirCB2 = score_AirCB2 + 2;
			} else if (currentTSInSecAirCB2 >= threshold_AirCB2 && currentTSInSecAirCB2 < threshold_AirCB2 + 9) { //
				score_AirCB2 = score_AirCB2 +0;
			} else if (currentTSInSecAirCB2 >= threshold_AirCB2 + 9 && currentTSInSecAirCB2 < threshold_AirCB2 + 18) { //
				score_AirCB2 = score_AirCB2 + 2;
			} else if (currentTSInSecAirCB2 >= threshold_AirCB2 + 18) { //
				score_AirCB2 = score_AirCB2 +2;
			}else {
				score_AirCB2 = score_AirCB2 +4;
			}
		}else {
			score_AirCB2 = score_AirCB2 +4;
		}
		System.out.println(" Score of AirCB2: " + score_AirCB2 + "");
		totalScore = totalScore + score_AirCB2; // set score_AirCraftName

		int score_AirCB3 = 0;
		Long currentTSInSecAirCB3 = (Long) mapTimeDiffInSec.get("AirCB3"); // set aircraft name
		long threshold_AirCB3 = 6; // set threshold
		if (currentTSInSecAirCB3 != null) {
			if (currentTSInSecAirCB3 > 0 && currentTSInSecAirCB3 < threshold_AirCB3) { //
				score_AirCB3 = score_AirCB3 + 2;
			} else if (currentTSInSecAirCB3 >= threshold_AirCB3 && currentTSInSecAirCB3 < threshold_AirCB3 + 9) { //
				score_AirCB3 = score_AirCB3 +0;
			} else if (currentTSInSecAirCB3 >= threshold_AirCB3 + 9 && currentTSInSecAirCB3 < threshold_AirCB3 + 18) { //
				score_AirCB3 = score_AirCB3 + 2;
			} else if (currentTSInSecAirCB3 >= threshold_AirCB3 + 18) { //
				score_AirCB3 = score_AirCB3 +2;
			}else {
				score_AirCB3 = score_AirCB3 +4;
			}
		}else {
			score_AirCB3 = score_AirCB3 +4;
		}
		System.out.println(" Score of AirCB3: " + score_AirCB3 + "");
		totalScore = totalScore + score_AirCB3; // set score_AirCraftName

		int score_AirCB41 = 0;
		Long currentTSInSecAirCB41 = (Long) mapTimeDiffInSec.get("AirCB41"); // set aircraft name
		long threshold_AirCB41 = 127; // set threshold
		if (currentTSInSecAirCB41 != null) {
			if (currentTSInSecAirCB41 > 0 && currentTSInSecAirCB41 < threshold_AirCB41) { //
				score_AirCB41 = score_AirCB41 + 2;
			} else if (currentTSInSecAirCB41 >= threshold_AirCB41 && currentTSInSecAirCB41 < threshold_AirCB41 + 9) { //
				score_AirCB41 = score_AirCB41 +0;
			} else if (currentTSInSecAirCB41 >= threshold_AirCB41 + 9
					&& currentTSInSecAirCB41 < threshold_AirCB41 + 18) { //
				score_AirCB41 = score_AirCB41 + 2;
			} else if (currentTSInSecAirCB41 >= threshold_AirCB41 + 18) { //
				score_AirCB41 = score_AirCB41 +2;
			}else {
				score_AirCB41 = score_AirCB41 +4;
			}
		}else {
			score_AirCB41 = score_AirCB41 +4;
		}
		System.out.println(" Score of AirCB41: " + score_AirCB41 + "");
		totalScore = totalScore + score_AirCB41; // set score_AirCraftName

		int score_AirCB5 = 0;
		Long currentTSInSecAirCB5 = (Long) mapTimeDiffInSec.get("AirCB5"); // set aircraft name
		long threshold_AirCB5 = 108; // set threshold
		if (currentTSInSecAirCB5 != null) {
			if (currentTSInSecAirCB5 > 0 && currentTSInSecAirCB5 < threshold_AirCB5) { //
				score_AirCB5 = score_AirCB5 + 2;
			} else if (currentTSInSecAirCB5 >= threshold_AirCB5 && currentTSInSecAirCB5 < threshold_AirCB5 + 9) { //
				score_AirCB5 = score_AirCB5 +0;
			} else if (currentTSInSecAirCB5 >= threshold_AirCB5 + 9 && currentTSInSecAirCB5 < threshold_AirCB5 + 18) { //
				score_AirCB5 = score_AirCB5 + 2;
			} else if (currentTSInSecAirCB5 >= threshold_AirCB5 + 18) { //
				score_AirCB5 = score_AirCB5 +2;
			}else {
				score_AirCB5 = score_AirCB5 +4;
			}
		}else {
			score_AirCB5 = score_AirCB5 +4;
		}
		System.out.println(" Score of AirCB5: " + score_AirCB5 + "");
		totalScore = totalScore + score_AirCB5; // set score_AirCraftName

		int score_AirCB4 = 0;
		Long currentTSInSecAirCB4 = (Long) mapTimeDiffInSec.get("AirCB4"); // set aircraft name
		long threshold_AirCB4 = 181; // set threshold
		if (currentTSInSecAirCB4 != null) {
			if (currentTSInSecAirCB4 > 0 && currentTSInSecAirCB4 < threshold_AirCB4) { //
				score_AirCB4 = score_AirCB4 + 2;
			} else if (currentTSInSecAirCB4 >= threshold_AirCB4 && currentTSInSecAirCB4 < threshold_AirCB4 + 9) { //
				score_AirCB4 = score_AirCB4 +0;
			} else if (currentTSInSecAirCB4 >= threshold_AirCB4 + 9 && currentTSInSecAirCB4 < threshold_AirCB4 + 18) { //
				score_AirCB4 = score_AirCB4 + 2;
			} else if (currentTSInSecAirCB4 >= threshold_AirCB4 + 18) { //
				score_AirCB4 = score_AirCB4 +2;
			}else {
				score_AirCB4 = score_AirCB4 +4;
			}
		}else {
			score_AirCB4 = score_AirCB4 +4;
		}
		System.out.println(" Score of AirCB4: " + score_AirCB4 + "");
		totalScore = totalScore + score_AirCB4; // set score_AirCraftName

		int score_AirCB43 = 0;
		Long currentTSInSecAirCB43 = (Long) mapTimeDiffInSec.get("AirCB43"); // set aircraft name
		long threshold_AirCB43 = 201; // set threshold
		if (currentTSInSecAirCB43 != null) {
			if (currentTSInSecAirCB43 > 0 && currentTSInSecAirCB43 < threshold_AirCB43) { //
				score_AirCB43 = score_AirCB43 + 2;
			} else if (currentTSInSecAirCB43 >= threshold_AirCB43 && currentTSInSecAirCB43 < threshold_AirCB43 + 9) { //
				score_AirCB43 = score_AirCB43 +0;
			} else if (currentTSInSecAirCB43 >= threshold_AirCB43 + 9
					&& currentTSInSecAirCB43 < threshold_AirCB43 + 18) { //
				score_AirCB43 = score_AirCB43 + 2;
			} else if (currentTSInSecAirCB43 >= threshold_AirCB43 + 18) { //
				score_AirCB43 = score_AirCB43 +2;
			}else {
				score_AirCB43 = score_AirCB43 +4;
			}
		}else {
			score_AirCB43 = score_AirCB43 +4;
		}
		System.out.println(" Score of AirCB43: " + score_AirCB43 + "");
		totalScore = totalScore + score_AirCB43; // set score_AirCraftName

		int score_AirCB45 = 0;
		Long currentTSInSecAirCB45 = (Long) mapTimeDiffInSec.get("AirCB45"); // set aircraft name
		long threshold_AirCB45 = 232; // set threshold
		if (currentTSInSecAirCB45 != null) {
			if (currentTSInSecAirCB45 > 0 && currentTSInSecAirCB45 < threshold_AirCB45) { //
				score_AirCB45 = score_AirCB45 + 2;
			} else if (currentTSInSecAirCB45 >= threshold_AirCB45 && currentTSInSecAirCB45 < threshold_AirCB45 + 9) { //
				score_AirCB45 = score_AirCB45 +0;
			} else if (currentTSInSecAirCB45 >= threshold_AirCB45 + 9
					&& currentTSInSecAirCB45 < threshold_AirCB45 + 18) { //
				score_AirCB45 = score_AirCB45 + 2;
			} else if (currentTSInSecAirCB45 >= threshold_AirCB45 + 18) { //
				score_AirCB45 = score_AirCB45 +2;
			}else {
				score_AirCB45 = score_AirCB45 +4;
			}
		}else {
			score_AirCB45 = score_AirCB45 +4;
		}
		System.out.println(" Score of AirCB45: " + score_AirCB45 + "");
		totalScore = totalScore + score_AirCB45; // set score_AirCraftName

		int score_AirCB7 = 0;
		Long currentTSInSecAirCB7 = (Long) mapTimeDiffInSec.get("AirCB7"); // set aircraft name
		long threshold_AirCB7 = 231; // set threshold
		if (currentTSInSecAirCB7 != null) {
			if (currentTSInSecAirCB7 > 0 && currentTSInSecAirCB7 < threshold_AirCB7) { //
				score_AirCB7 = score_AirCB7 + 2;
			} else if (currentTSInSecAirCB7 >= threshold_AirCB7 && currentTSInSecAirCB7 < threshold_AirCB7 + 9) { //
				score_AirCB7 = score_AirCB7 +0;
			} else if (currentTSInSecAirCB7 >= threshold_AirCB7 + 9 && currentTSInSecAirCB7 < threshold_AirCB7 + 18) { //
				score_AirCB7 = score_AirCB7 + 2;
			} else if (currentTSInSecAirCB7 >= threshold_AirCB7 + 18) { //
				score_AirCB7 = score_AirCB7 +2;
			}else {
				score_AirCB7 = score_AirCB7 +4;
			}
		}else {
			score_AirCB7 = score_AirCB7 +4;
		}
		System.out.println(" Score of AirCB7: " + score_AirCB7 + "");
		totalScore = totalScore + score_AirCB7; // set score_AirCraftName

		int score_AirCB44 = 0;
		Long currentTSInSecAirCB44 = (Long) mapTimeDiffInSec.get("AirCB44"); // set aircraft name
		long threshold_AirCB44 = 243; // set threshold
		if (currentTSInSecAirCB44 != null) {
			if (currentTSInSecAirCB44 > 0 && currentTSInSecAirCB44 < threshold_AirCB44) { //
				score_AirCB44 = score_AirCB44 + 2;
			} else if (currentTSInSecAirCB44 >= threshold_AirCB44 && currentTSInSecAirCB44 < threshold_AirCB44 + 9) { //
				score_AirCB44 = score_AirCB44 +0;
			} else if (currentTSInSecAirCB44 >= threshold_AirCB44 + 9
					&& currentTSInSecAirCB44 < threshold_AirCB44 + 18) { //
				score_AirCB44 = score_AirCB44 + 2;
			} else if (currentTSInSecAirCB44 >= threshold_AirCB44 + 18) { //
				score_AirCB44 = score_AirCB44 +2;
			}else {
				score_AirCB44 = score_AirCB44 +4;
			}
		}else {
			score_AirCB44 = score_AirCB44 +4;
		}
		System.out.println(" Score of AirCB44: " + score_AirCB44 + "");
		totalScore = totalScore + score_AirCB44; // set score_AirCraftName

		int score_AirCB38 = 0;
		Long currentTSInSecAirCB38 = (Long) mapTimeDiffInSec.get("AirCB38"); // set aircraft name
		long threshold_AirCB38 = 268; // set threshold
		if (currentTSInSecAirCB38 != null) {
			if (currentTSInSecAirCB38 > 0 && currentTSInSecAirCB38 < threshold_AirCB38) { //
				score_AirCB38 = score_AirCB38 + 2;
			} else if (currentTSInSecAirCB38 >= threshold_AirCB38 && currentTSInSecAirCB38 < threshold_AirCB38 + 9) { //
				score_AirCB38 = score_AirCB38 +0;
			} else if (currentTSInSecAirCB38 >= threshold_AirCB38 + 9
					&& currentTSInSecAirCB38 < threshold_AirCB38 + 18) { //
				score_AirCB38 = score_AirCB38 + 2;
			} else if (currentTSInSecAirCB38 >= threshold_AirCB38 + 18) { //
				score_AirCB38 = score_AirCB38 +2;
			}else {
				score_AirCB38 = score_AirCB38 +4;
			}
		}else {
			score_AirCB38 = score_AirCB38 +4;
		}
		System.out.println(" Score of AirCB38: " + score_AirCB38 + "");
		totalScore = totalScore + score_AirCB38; // set score_AirCraftName

		int score_AirCB17 = 0;
		Long currentTSInSecAirCB17 = (Long) mapTimeDiffInSec.get("AirCB17"); // set aircraft name
		long threshold_AirCB17 = 300; // set threshold
		if (currentTSInSecAirCB17 != null) {
			if (currentTSInSecAirCB17 > 0 && currentTSInSecAirCB17 < threshold_AirCB17) { //
				score_AirCB17 = score_AirCB17 + 2;
			} else if (currentTSInSecAirCB17 >= threshold_AirCB17 && currentTSInSecAirCB17 < threshold_AirCB17 + 9) { //
				score_AirCB17 = score_AirCB17 +0;
			} else if (currentTSInSecAirCB17 >= threshold_AirCB17 + 9
					&& currentTSInSecAirCB17 < threshold_AirCB17 + 18) { //
				score_AirCB17 = score_AirCB17 + 2;
			} else if (currentTSInSecAirCB17 >= threshold_AirCB17 + 18) { //
				score_AirCB17 = score_AirCB17 +2;
			}else {
				score_AirCB17 = score_AirCB17 +2;
			}
		}else {
			score_AirCB17 = score_AirCB17 +2;
		}
		System.out.println(" Score of AirCB17: " + score_AirCB17 + "");
		totalScore = totalScore + score_AirCB17; // set score_AirCraftName

		int score_AirCB15 = 0;
		Long currentTSInSecAirCB15 = (Long) mapTimeDiffInSec.get("AirCB15"); // set aircraft name
		long threshold_AirCB15 = 318; // set threshold
		if (currentTSInSecAirCB15 != null) {
			if (currentTSInSecAirCB15 > 0 && currentTSInSecAirCB15 < threshold_AirCB15) { //
				score_AirCB15 = score_AirCB15 + 2;
			} else if (currentTSInSecAirCB15 >= threshold_AirCB15 && currentTSInSecAirCB15 < threshold_AirCB15 + 9) { //
				score_AirCB15 = score_AirCB15 +0;
			} else if (currentTSInSecAirCB15 >= threshold_AirCB15 + 9
					&& currentTSInSecAirCB15 < threshold_AirCB15 + 18) { //
				score_AirCB15 = score_AirCB15 + 2;
			} else if (currentTSInSecAirCB15 >= threshold_AirCB15 + 18) { //
				score_AirCB15 = score_AirCB15 +2;
			}else {
				score_AirCB15 = score_AirCB15 +4;
			}
		}else {
			score_AirCB15 = score_AirCB15 +4;
		}
		System.out.println(" Score of AirCB15: " + score_AirCB15 + "");
		totalScore = totalScore + score_AirCB15; // set score_AirCraftName

		int score_AirCB8 = 0;
		Long currentTSInSecAirCB8 = (Long) mapTimeDiffInSec.get("AirCB8"); // set aircraft name
		long threshold_AirCB8 = 313; // set threshold
		if (currentTSInSecAirCB8 != null) {
			if (currentTSInSecAirCB8 > 0 && currentTSInSecAirCB8 < threshold_AirCB8) { //
				score_AirCB8 = score_AirCB8 + 2;
			} else if (currentTSInSecAirCB8 >= threshold_AirCB8 && currentTSInSecAirCB8 < threshold_AirCB8 + 9) { //
				score_AirCB8 = score_AirCB8 +0;
			} else if (currentTSInSecAirCB8 >= threshold_AirCB8 + 9 && currentTSInSecAirCB8 < threshold_AirCB8 + 18) { //
				score_AirCB8 = score_AirCB8 + 2;
			} else if (currentTSInSecAirCB8 >= threshold_AirCB8 + 18) { //
				score_AirCB8 = score_AirCB8 +2;
			}else {
				score_AirCB8 = score_AirCB8 +4;
			}
		}else {
			score_AirCB8 = score_AirCB8 +4;
		}
		System.out.println(" Score of AirCB8: " + score_AirCB8 + "");
		totalScore = totalScore + score_AirCB8; // set score_AirCraftName

		int score_AirCB40 = 0;
		Long currentTSInSecAirCB40 = (Long) mapTimeDiffInSec.get("AirCB40"); // set aircraft name
		long threshold_AirCB40 = 317; // set threshold
		if (currentTSInSecAirCB40 != null) {
			if (currentTSInSecAirCB40 > 0 && currentTSInSecAirCB40 < threshold_AirCB40) { //
				score_AirCB40 = score_AirCB40 + 2;
			} else if (currentTSInSecAirCB40 >= threshold_AirCB40 && currentTSInSecAirCB40 < threshold_AirCB40 + 9) { //
				score_AirCB40 = score_AirCB40 +0;
			} else if (currentTSInSecAirCB40 >= threshold_AirCB40 + 9
					&& currentTSInSecAirCB40 < threshold_AirCB40 + 18) { //
				score_AirCB40 = score_AirCB40 + 2;
			} else if (currentTSInSecAirCB40 >= threshold_AirCB40 + 18) { //
				score_AirCB40 = score_AirCB40 +2;
			}else {
				score_AirCB40 = score_AirCB40 +4;
			}
		}else {
			score_AirCB40 = score_AirCB40 +4;
		}
		System.out.println(" Score of AirCB40: " + score_AirCB40 + "");
		totalScore = totalScore + score_AirCB40; // set score_AirCraftName

		int score_AirCB42 = 0;
		Long currentTSInSecAirCB42 = (Long) mapTimeDiffInSec.get("AirCB42"); // set aircraft name
		long threshold_AirCB42 = 343; // set threshold
		if (currentTSInSecAirCB42 != null) {
			if (currentTSInSecAirCB42 > 0 && currentTSInSecAirCB42 < threshold_AirCB42) { //
				score_AirCB42 = score_AirCB42 + 2;
			} else if (currentTSInSecAirCB42 >= threshold_AirCB42 && currentTSInSecAirCB42 < threshold_AirCB42 + 9) { //
				score_AirCB42 = score_AirCB42 +0;
			} else if (currentTSInSecAirCB42 >= threshold_AirCB42 + 9
					&& currentTSInSecAirCB42 < threshold_AirCB42 + 18) { //
				score_AirCB42 = score_AirCB42 + 2;
			} else if (currentTSInSecAirCB42 >= threshold_AirCB42 + 18) { //
				score_AirCB42 = score_AirCB42 +2;
			}else {
				score_AirCB42 = score_AirCB42 +4;
			}
		}else {
			score_AirCB42 = score_AirCB42 +4;
		}
		System.out.println(" Score of AirCB42: " + score_AirCB42 + "");
		totalScore = totalScore + score_AirCB42; // set score_AirCraftName

		int score_AirCB57 = 0;
		Long currentTSInSecAirCB57 = (Long) mapTimeDiffInSec.get("AirCB57"); // set aircraft name
		long threshold_AirCB57 = 409; // set threshold
		if (currentTSInSecAirCB57 != null) {
			if (currentTSInSecAirCB57 > 0 && currentTSInSecAirCB57 < threshold_AirCB57) { //
				score_AirCB57 = score_AirCB57 + 2;
			} else if (currentTSInSecAirCB57 >= threshold_AirCB57 && currentTSInSecAirCB57 < threshold_AirCB57 + 9) { //
				score_AirCB57 = score_AirCB57 +0;
			} else if (currentTSInSecAirCB57 >= threshold_AirCB57 + 9
					&& currentTSInSecAirCB57 < threshold_AirCB57 + 18) { //
				score_AirCB57 = score_AirCB57 + 2;
			} else if (currentTSInSecAirCB57 >= threshold_AirCB57 + 18) { //
				score_AirCB57 = score_AirCB57 +2;
			}else {
				score_AirCB57 = score_AirCB57 +4;
			}
		}else {
			score_AirCB57 = score_AirCB57 +4;
		}
		System.out.println(" Score of AirCB57: " + score_AirCB57 + "");
		totalScore = totalScore + score_AirCB57; // set score_AirCraftName

		int score_AirCB6 = 0;
		Long currentTSInSecAirCB6 = (Long) mapTimeDiffInSec.get("AirCB6"); // set aircraft name
		long threshold_AirCB6 = 433; // set threshold
		if (currentTSInSecAirCB6 != null) {
			if (currentTSInSecAirCB6 > 0 && currentTSInSecAirCB6 < threshold_AirCB6) { //
				score_AirCB6 = score_AirCB6 + 2;
			} else if (currentTSInSecAirCB6 >= threshold_AirCB6 && currentTSInSecAirCB6 < threshold_AirCB6 + 9) { //
				score_AirCB6 = score_AirCB6 +0;
			} else if (currentTSInSecAirCB6 >= threshold_AirCB6 + 9 && currentTSInSecAirCB6 < threshold_AirCB6 + 18) { //
				score_AirCB6 = score_AirCB6 + 2;
			} else if (currentTSInSecAirCB6 >= threshold_AirCB6 + 18) { //
				score_AirCB6 = score_AirCB6 +2;
			}else {
				score_AirCB6 = score_AirCB6 +4;
			}
		}else {
			score_AirCB6 = score_AirCB6 +4;
		}
		System.out.println(" Score of AirCB6: " + score_AirCB6 + "");
		totalScore = totalScore + score_AirCB6; // set score_AirCraftName

		int score_AirCB58 = 0;
		Long currentTSInSecAirCB58 = (Long) mapTimeDiffInSec.get("AirCB58"); // set aircraft name
		long threshold_AirCB58 = 481; // set threshold
		if (currentTSInSecAirCB58 != null) {
			if (currentTSInSecAirCB58 > 0 && currentTSInSecAirCB58 < threshold_AirCB58) { //
				score_AirCB58 = score_AirCB58 + 2;
			} else if (currentTSInSecAirCB58 >= threshold_AirCB58 && currentTSInSecAirCB58 < threshold_AirCB58 + 9) { //
				score_AirCB58 = score_AirCB58 +0;
			} else if (currentTSInSecAirCB58 >= threshold_AirCB58 + 9
					&& currentTSInSecAirCB58 < threshold_AirCB58 + 18) { //
				score_AirCB58 = score_AirCB58 + 2;
			} else if (currentTSInSecAirCB58 >= threshold_AirCB58 + 18) { //
				score_AirCB58 = score_AirCB58 +2;
			}else {
				score_AirCB58 = score_AirCB58 +4;
			}
		}else {
			score_AirCB58 = score_AirCB58 +4;
		}
		System.out.println(" Score of AirCB58: " + score_AirCB58 + "");
		totalScore = totalScore + score_AirCB58; // set score_AirCraftName

		int score_AirCB11 = 0;
		Long currentTSInSecAirCB11 = (Long) mapTimeDiffInSec.get("AirCB11"); // set aircraft name
		long threshold_AirCB11 = 442; // set threshold
		if (currentTSInSecAirCB11 != null) {
			if (currentTSInSecAirCB11 > 0 && currentTSInSecAirCB11 < threshold_AirCB11) { //
				score_AirCB11 = score_AirCB11 + 2;
			} else if (currentTSInSecAirCB11 >= threshold_AirCB11 && currentTSInSecAirCB11 < threshold_AirCB11 + 9) { //
				score_AirCB11 = score_AirCB11 +0;
			} else if (currentTSInSecAirCB11 >= threshold_AirCB11 + 9
					&& currentTSInSecAirCB11 < threshold_AirCB11 + 18) { //
				score_AirCB11 = score_AirCB11 + 2;
			} else if (currentTSInSecAirCB11 >= threshold_AirCB11 + 18) { //
				score_AirCB11 = score_AirCB11 +2;
			}else {
				score_AirCB11 = score_AirCB11 +4;
			}
		}else {
			score_AirCB11 = score_AirCB11 +4;
		}
		System.out.println(" Score of AirCB11: " + score_AirCB11 + "");
		totalScore = totalScore + score_AirCB11; // set score_AirCraftName

		int score_AirCB26 = 0;
		Long currentTSInSecAirCB26 = (Long) mapTimeDiffInSec.get("AirCB26"); // set aircraft name
		long threshold_AirCB26 = 485; // set threshold
		if (currentTSInSecAirCB26 != null) {
			if (currentTSInSecAirCB26 > 0 && currentTSInSecAirCB26 < threshold_AirCB26) { //
				score_AirCB26 = score_AirCB26 + 2;
			} else if (currentTSInSecAirCB26 >= threshold_AirCB26 && currentTSInSecAirCB26 < threshold_AirCB26 + 9) { //
				score_AirCB26 = score_AirCB26 +0;
			} else if (currentTSInSecAirCB26 >= threshold_AirCB26 + 9
					&& currentTSInSecAirCB26 < threshold_AirCB26 + 18) { //
				score_AirCB26 = score_AirCB26 + 2;
			} else if (currentTSInSecAirCB26 >= threshold_AirCB26 + 18) { //
				score_AirCB26 = score_AirCB26 +2;
			}else {
				score_AirCB26 = score_AirCB26 +4;
			}
		}else {
			score_AirCB26 = score_AirCB26 +4;
		}
		System.out.println(" Score of AirCB26: " + score_AirCB26 + "");
		totalScore = totalScore + score_AirCB26; // set score_AirCraftName

		int score_AirCB28 = 0;
		Long currentTSInSecAirCB28 = (Long) mapTimeDiffInSec.get("AirCB28"); // set aircraft name
		long threshold_AirCB28 = 497; // set threshold
		if (currentTSInSecAirCB28 != null) {
			if (currentTSInSecAirCB28 > 0 && currentTSInSecAirCB28 < threshold_AirCB28) { //
				score_AirCB28 = score_AirCB28 + 2;
			} else if (currentTSInSecAirCB28 >= threshold_AirCB28 && currentTSInSecAirCB28 < threshold_AirCB28 + 9) { //
				score_AirCB28 = score_AirCB28 +0;
			} else if (currentTSInSecAirCB28 >= threshold_AirCB28 + 9
					&& currentTSInSecAirCB28 < threshold_AirCB28 + 18) { //
				score_AirCB28 = score_AirCB28 + 2;
			} else if (currentTSInSecAirCB28 >= threshold_AirCB28 + 18) { //
				score_AirCB28 = score_AirCB28 +2;
			}else {
				score_AirCB28 = score_AirCB28 +4;
			}
		}else {
			score_AirCB28 = score_AirCB28 +4;
		}
		System.out.println(" Score of AirCB28: " + score_AirCB28 + "");
		totalScore = totalScore + score_AirCB28; // set score_AirCraftName

		int score_AirCB16 = 0;
		Long currentTSInSecAirCB16 = (Long) mapTimeDiffInSec.get("AirCB16"); // set aircraft name
		long threshold_AirCB16 = 497; // set threshold
		if (currentTSInSecAirCB16 != null) {
			if (currentTSInSecAirCB16 > 0 && currentTSInSecAirCB16 < threshold_AirCB16) { //
				score_AirCB16 = score_AirCB16 + 2;
			} else if (currentTSInSecAirCB16 >= threshold_AirCB16 && currentTSInSecAirCB16 < threshold_AirCB16 + 9) { //
				score_AirCB16 = score_AirCB16 +0;
			} else if (currentTSInSecAirCB16 >= threshold_AirCB16 + 9
					&& currentTSInSecAirCB16 < threshold_AirCB16 + 18) { //
				score_AirCB16 = score_AirCB16 + 2;
			} else if (currentTSInSecAirCB16 >= threshold_AirCB16 + 18) { //
				score_AirCB16 = score_AirCB16 +2;
			}else {
				score_AirCB16 = score_AirCB16 +4;
			}
		}else {
			score_AirCB16 = score_AirCB16 +4;
		}
		System.out.println(" Score of AirCB16: " + score_AirCB16 + "");
		totalScore = totalScore + score_AirCB16; // set score_AirCraftName

		int score_AirCB9 = 0;
		Long currentTSInSecAirCB9 = (Long) mapTimeDiffInSec.get("AirCB9"); // set aircraft name
		long threshold_AirCB9 = 519; // set threshold
		if (currentTSInSecAirCB9 != null) {
			if (currentTSInSecAirCB9 > 0 && currentTSInSecAirCB9 < threshold_AirCB9) { //
				score_AirCB9 = score_AirCB9 + 2;
			} else if (currentTSInSecAirCB9 >= threshold_AirCB9 && currentTSInSecAirCB9 < threshold_AirCB9 + 9) { //
				score_AirCB9 = score_AirCB9 +0;
			} else if (currentTSInSecAirCB9 >= threshold_AirCB9 + 9 && currentTSInSecAirCB9 < threshold_AirCB9 + 18) { //
				score_AirCB9 = score_AirCB9 + 2;
			} else if (currentTSInSecAirCB9 >= threshold_AirCB9 + 18) { //
				score_AirCB9 = score_AirCB9 +2;
			}else {
				score_AirCB9 = score_AirCB9 +4;
			}
		}else {
			score_AirCB9 = score_AirCB9 +4;
		}
		System.out.println(" Score of AirCB9: " + score_AirCB9 + "");
		totalScore = totalScore + score_AirCB9; // set score_AirCraftName

		int score_AirCB59 = 0;
		Long currentTSInSecAirCB59 = (Long) mapTimeDiffInSec.get("AirCB59"); // set aircraft name
		long threshold_AirCB59 = 542; // set threshold
		if (currentTSInSecAirCB59 != null) {
			if (currentTSInSecAirCB59 > 0 && currentTSInSecAirCB59 < threshold_AirCB59) { //
				score_AirCB59 = score_AirCB59 + 2;
			} else if (currentTSInSecAirCB59 >= threshold_AirCB59 && currentTSInSecAirCB59 < threshold_AirCB59 + 9) { //
				score_AirCB59 = score_AirCB59 +0;
			} else if (currentTSInSecAirCB59 >= threshold_AirCB59 + 9
					&& currentTSInSecAirCB59 < threshold_AirCB59 + 18) { //
				score_AirCB59 = score_AirCB59 + 2;
			} else if (currentTSInSecAirCB59 >= threshold_AirCB59 + 18) { //
				score_AirCB59 = score_AirCB59 +2;
			}else {
				score_AirCB59 = score_AirCB59 +4;
			}
		}else {
			score_AirCB59 = score_AirCB59 +4;
		}
		System.out.println(" Score of AirCB59: " + score_AirCB59 + "");
		totalScore = totalScore + score_AirCB59; // set score_AirCraftName

		int score_AirCB10 = 0;
		Long currentTSInSecAirCB10 = (Long) mapTimeDiffInSec.get("AirCB10"); // set aircraft name
		long threshold_AirCB10 = 573; // set threshold
		if (currentTSInSecAirCB10 != null) {
			if (currentTSInSecAirCB10 > 0 && currentTSInSecAirCB10 < threshold_AirCB10) { //
				score_AirCB10 = score_AirCB10 + 2;
			} else if (currentTSInSecAirCB10 >= threshold_AirCB10 && currentTSInSecAirCB10 < threshold_AirCB10 + 9) { //
				score_AirCB10 = score_AirCB10 +0;
			} else if (currentTSInSecAirCB10 >= threshold_AirCB10 + 9
					&& currentTSInSecAirCB10 < threshold_AirCB10 + 18) { //
				score_AirCB10 = score_AirCB10 + 2;
			} else if (currentTSInSecAirCB10 >= threshold_AirCB10 + 18) { //
				score_AirCB10 = score_AirCB10 +2;
			}else {
				score_AirCB10 = score_AirCB10 +4;
			}
		}else {
			score_AirCB10 = score_AirCB10 +4;
		}
		System.out.println(" Score of AirCB10: " + score_AirCB10 + "");
		totalScore = totalScore + score_AirCB10; // set score_AirCraftName

		int score_AirCB13 = 0;
		Long currentTSInSecAirCB13 = (Long) mapTimeDiffInSec.get("AirCB13"); // set aircraft name
		long threshold_AirCB13 = 597; // set threshold
		if (currentTSInSecAirCB13 != null) {
			if (currentTSInSecAirCB13 > 0 && currentTSInSecAirCB13 < threshold_AirCB13) { //
				score_AirCB13 = score_AirCB13 + 2;
			} else if (currentTSInSecAirCB13 >= threshold_AirCB13 && currentTSInSecAirCB13 < threshold_AirCB13 + 9) { //
				score_AirCB13 = score_AirCB13 +0;
			} else if (currentTSInSecAirCB13 >= threshold_AirCB13 + 9
					&& currentTSInSecAirCB13 < threshold_AirCB13 + 18) { //
				score_AirCB13 = score_AirCB13 + 2;
			} else if (currentTSInSecAirCB13 >= threshold_AirCB13 + 18) { //
				score_AirCB13 = score_AirCB13 +2;
			}else {
				score_AirCB13 = score_AirCB13 +4;
			}
		}else {
			score_AirCB13 = score_AirCB13 +4;
		}
		System.out.println(" Score of AirCB13: " + score_AirCB13 + "");
		totalScore = totalScore + score_AirCB13; // set score_AirCraftName

		int score_AirCB54 = 0;
		Long currentTSInSecAirCB54 = (Long) mapTimeDiffInSec.get("AirCB54"); // set aircraft name
		long threshold_AirCB54 = 612; // set threshold
		if (currentTSInSecAirCB54 != null) {
			if (currentTSInSecAirCB54 > 0 && currentTSInSecAirCB54 < threshold_AirCB54) { //
				score_AirCB54 = score_AirCB54 + 2;
			} else if (currentTSInSecAirCB54 >= threshold_AirCB54 && currentTSInSecAirCB54 < threshold_AirCB54 + 9) { //
				score_AirCB54 = score_AirCB54 +0;
			} else if (currentTSInSecAirCB54 >= threshold_AirCB54 + 9
					&& currentTSInSecAirCB54 < threshold_AirCB54 + 18) { //
				score_AirCB54 = score_AirCB54 + 2;
			} else if (currentTSInSecAirCB54 >= threshold_AirCB54 + 18) { //
				score_AirCB54 = score_AirCB54 +2;
			}else {
				score_AirCB54 = score_AirCB54 +4;
			}
		}else {
			score_AirCB54 = score_AirCB54 +4;
		}
		System.out.println(" Score of AirCB54: " + score_AirCB54 + "");
		totalScore = totalScore + score_AirCB54; // set score_AirCraftName

		int score_AirCB12 = 0;
		Long currentTSInSecAirCB12 = (Long) mapTimeDiffInSec.get("AirCB12"); // set aircraft name
		long threshold_AirCB12 = 624; // set threshold
		if (currentTSInSecAirCB12 != null) {
			if (currentTSInSecAirCB12 > 0 && currentTSInSecAirCB12 < threshold_AirCB12) { //
				score_AirCB12 = score_AirCB12 + 2;
			} else if (currentTSInSecAirCB12 >= threshold_AirCB12 && currentTSInSecAirCB12 < threshold_AirCB12 + 9) { //
				score_AirCB12 = score_AirCB12 +0;
			} else if (currentTSInSecAirCB12 >= threshold_AirCB12 + 9
					&& currentTSInSecAirCB12 < threshold_AirCB12 + 18) { //
				score_AirCB12 = score_AirCB12 + 2;
			} else if (currentTSInSecAirCB12 >= threshold_AirCB12 + 18) { //
				score_AirCB12 = score_AirCB12 +2;
			}else {
				score_AirCB12 = score_AirCB12 +4;
			}
		}else {
			score_AirCB12 = score_AirCB12 +4;
		}
		System.out.println(" Score of AirCB12: " + score_AirCB12 + "");
		totalScore = totalScore + score_AirCB12; // set score_AirCraftName

		int score_AirCB27 = 0;
		Long currentTSInSecAirCB27 = (Long) mapTimeDiffInSec.get("AirCB27"); // set aircraft name
		long threshold_AirCB27 = 665; // set threshold
		if (currentTSInSecAirCB27 != null) {
			if (currentTSInSecAirCB27 > 0 && currentTSInSecAirCB27 < threshold_AirCB27) { //
				score_AirCB27 = score_AirCB27 + 2;
			} else if (currentTSInSecAirCB27 >= threshold_AirCB27 && currentTSInSecAirCB27 < threshold_AirCB27 + 9) { //
				score_AirCB27 = score_AirCB27 +0;
			} else if (currentTSInSecAirCB27 >= threshold_AirCB27 + 9
					&& currentTSInSecAirCB27 < threshold_AirCB27 + 18) { //
				score_AirCB27 = score_AirCB27 + 2;
			} else if (currentTSInSecAirCB27 >= threshold_AirCB27 + 18) { //
				score_AirCB27 = score_AirCB27 +2;
			}else {
				score_AirCB27 = score_AirCB27 +4;
			}
		}else {
			score_AirCB27 = score_AirCB27 +4;
		}
		System.out.println(" Score of AirCB27: " + score_AirCB27 + "");
		totalScore = totalScore + score_AirCB27; // set score_AirCraftName

		int score_AirCB49 = 0;
		Long currentTSInSecAirCB49 = (Long) mapTimeDiffInSec.get("AirCB49"); // set aircraft name
		long threshold_AirCB49 = 677; // set threshold
		if (currentTSInSecAirCB49 != null) {
			if (currentTSInSecAirCB49 > 0 && currentTSInSecAirCB49 < threshold_AirCB49) { //
				score_AirCB49 = score_AirCB49 + 2;
			} else if (currentTSInSecAirCB49 >= threshold_AirCB49 && currentTSInSecAirCB49 < threshold_AirCB49 + 9) { //
				score_AirCB49 = score_AirCB49 +0;
			} else if (currentTSInSecAirCB49 >= threshold_AirCB49 + 9
					&& currentTSInSecAirCB49 < threshold_AirCB49 + 18) { //
				score_AirCB49 = score_AirCB49 + 2;
			} else if (currentTSInSecAirCB49 >= threshold_AirCB49 + 18) { //
				score_AirCB49 = score_AirCB49 +2;
			}else {
				score_AirCB49 = score_AirCB49 +4;
			}
		}else {
			score_AirCB49 = score_AirCB49 +4;
		}
		System.out.println(" Score of AirCB49: " + score_AirCB49 + "");
		totalScore = totalScore + score_AirCB49; // set score_AirCraftName

		int score_AirCB24 = 0;
		Long currentTSInSecAirCB24 = (Long) mapTimeDiffInSec.get("AirCB24"); // set aircraft name
		long threshold_AirCB24 = 733; // set threshold
		if (currentTSInSecAirCB24 != null) {
			if (currentTSInSecAirCB24 > 0 && currentTSInSecAirCB24 < threshold_AirCB24) { //
				score_AirCB24 = score_AirCB24 + 2;
			} else if (currentTSInSecAirCB24 >= threshold_AirCB24 && currentTSInSecAirCB24 < threshold_AirCB24 + 9) { //
				score_AirCB24 = score_AirCB24 +0;
			} else if (currentTSInSecAirCB24 >= threshold_AirCB24 + 9
					&& currentTSInSecAirCB24 < threshold_AirCB24 + 18) { //
				score_AirCB24 = score_AirCB24 + 2;
			} else if (currentTSInSecAirCB24 >= threshold_AirCB24 + 18) { //
				score_AirCB24 = score_AirCB24 +2;
			}else {
				score_AirCB24 = score_AirCB24 +4;
			}
		}else {
			score_AirCB24 = score_AirCB24 +4;
		}
		System.out.println(" Score of AirCB24: " + score_AirCB24 + "");
		totalScore = totalScore + score_AirCB24; // set score_AirCraftName

		int score_AirCB19 = 0;
		Long currentTSInSecAirCB19 = (Long) mapTimeDiffInSec.get("AirCB19"); // set aircraft name
		long threshold_AirCB19 = 758; // set threshold
		if (currentTSInSecAirCB19 != null) {
			if (currentTSInSecAirCB19 > 0 && currentTSInSecAirCB19 < threshold_AirCB19) { //
				score_AirCB19 = score_AirCB19 + 2;
			} else if (currentTSInSecAirCB19 >= threshold_AirCB19 && currentTSInSecAirCB19 < threshold_AirCB19 + 9) { //
				score_AirCB19 = score_AirCB19 +0;
			} else if (currentTSInSecAirCB19 >= threshold_AirCB19 + 9
					&& currentTSInSecAirCB19 < threshold_AirCB19 + 18) { //
				score_AirCB19 = score_AirCB19 + 2;
			} else if (currentTSInSecAirCB19 >= threshold_AirCB19 + 18) { //
				score_AirCB19 = score_AirCB19 +2;
			}else {
				score_AirCB19 = score_AirCB19 +4;
			}
		}else {
			score_AirCB19 = score_AirCB19 +4;
		}
		System.out.println(" Score of AirCB19: " + score_AirCB19 + "");
		totalScore = totalScore + score_AirCB19; // set score_AirCraftName

		int score_AirCB46 = 0;
		Long currentTSInSecAirCB46 = (Long) mapTimeDiffInSec.get("AirCB46"); // set aircraft name
		long threshold_AirCB46 = 806; // set threshold
		if (currentTSInSecAirCB46 != null) {
			if (currentTSInSecAirCB46 > 0 && currentTSInSecAirCB46 < threshold_AirCB46) { //
				score_AirCB46 = score_AirCB46 + 2;
			} else if (currentTSInSecAirCB46 >= threshold_AirCB46 && currentTSInSecAirCB46 < threshold_AirCB46 + 9) { //
				score_AirCB46 = score_AirCB46 +0;
			} else if (currentTSInSecAirCB46 >= threshold_AirCB46 + 9
					&& currentTSInSecAirCB46 < threshold_AirCB46 + 18) { //
				score_AirCB46 = score_AirCB46 + 2;
			} else if (currentTSInSecAirCB46 >= threshold_AirCB46 + 18) { //
				score_AirCB46 = score_AirCB46 +2;
			}else {
				score_AirCB46 = score_AirCB46 +4;
			}
		}else {
			score_AirCB46 = score_AirCB46 +4;
		}
		System.out.println(" Score of AirCB46: " + score_AirCB46 + "");
		totalScore = totalScore + score_AirCB46; // set score_AirCraftName

		int score_AirCB50 = 0;
		Long currentTSInSecAirCB50 = (Long) mapTimeDiffInSec.get("AirCB50"); // set aircraft name
		long threshold_AirCB50 = 831; // set threshold
		if (currentTSInSecAirCB50 != null) {
			if (currentTSInSecAirCB50 > 0 && currentTSInSecAirCB50 < threshold_AirCB50) { //
				score_AirCB50 = score_AirCB50 + 2;
			} else if (currentTSInSecAirCB50 >= threshold_AirCB50 && currentTSInSecAirCB50 < threshold_AirCB50 + 9) { //
				score_AirCB50 = score_AirCB50 +0;
			} else if (currentTSInSecAirCB50 >= threshold_AirCB50 + 9
					&& currentTSInSecAirCB50 < threshold_AirCB50 + 18) { //
				score_AirCB50 = score_AirCB50 + 2;
			} else if (currentTSInSecAirCB50 >= threshold_AirCB50 + 18) { //
				score_AirCB50 = score_AirCB50 +2;
			}else {
				score_AirCB50 = score_AirCB50 +4;
			}
		}else {
			score_AirCB50 = score_AirCB50 +4;
		}
		System.out.println(" Score of AirCB50: " + score_AirCB50 + "");
		totalScore = totalScore + score_AirCB50; // set score_AirCraftName

		int score_AirCB47 = 0;
		Long currentTSInSecAirCB47 = (Long) mapTimeDiffInSec.get("AirCB47"); // set aircraft name
		long threshold_AirCB47 = 848; // set threshold
		if (currentTSInSecAirCB47 != null) {
			if (currentTSInSecAirCB47 > 0 && currentTSInSecAirCB47 < threshold_AirCB47) { //
				score_AirCB47 = score_AirCB47 + 2;
			} else if (currentTSInSecAirCB47 >= threshold_AirCB47 && currentTSInSecAirCB47 < threshold_AirCB47 + 9) { //
				score_AirCB47 = score_AirCB47 +0;
			} else if (currentTSInSecAirCB47 >= threshold_AirCB47 + 9
					&& currentTSInSecAirCB47 < threshold_AirCB47 + 18) { //
				score_AirCB47 = score_AirCB47 + 2;
			} else if (currentTSInSecAirCB47 >= threshold_AirCB47 + 18) { //
				score_AirCB47 = score_AirCB47 +2;
			}else {
				score_AirCB47 = score_AirCB47 +4;
			}
		}else {
			score_AirCB47 = score_AirCB47 +4;
		}
		System.out.println(" Score of AirCB47: " + score_AirCB47 + "");
		totalScore = totalScore + score_AirCB47; // set score_AirCraftName

		int score_AirCB14 = 0;
		Long currentTSInSecAirCB14 = (Long) mapTimeDiffInSec.get("AirCB14"); // set aircraft name
		long threshold_AirCB14 = 851; // set threshold
		if (currentTSInSecAirCB14 != null) {
			if (currentTSInSecAirCB14 > 0 && currentTSInSecAirCB14 < threshold_AirCB14) { //
				score_AirCB14 = score_AirCB14 + 2;
			} else if (currentTSInSecAirCB14 >= threshold_AirCB14 && currentTSInSecAirCB14 < threshold_AirCB14 + 9) { //
				score_AirCB14 = score_AirCB14 +0;
			} else if (currentTSInSecAirCB14 >= threshold_AirCB14 + 9
					&& currentTSInSecAirCB14 < threshold_AirCB14 + 18) { //
				score_AirCB14 = score_AirCB14 + 2;
			} else if (currentTSInSecAirCB14 >= threshold_AirCB14 + 18) { //
				score_AirCB14 = score_AirCB14 +2;
			}else {
				score_AirCB14 = score_AirCB14 +4;
			}
		}else {
			score_AirCB14 = score_AirCB14 +4;
		}
		System.out.println(" Score of AirCB14: " + score_AirCB14 + "");
		totalScore = totalScore + score_AirCB14; // set score_AirCraftName

		int score_AirCB53 = 0;
		Long currentTSInSecAirCB53 = (Long) mapTimeDiffInSec.get("AirCB53"); // set aircraft name
		long threshold_AirCB53 = 894; // set threshold
		if (currentTSInSecAirCB53 != null) {
			if (currentTSInSecAirCB53 > 0 && currentTSInSecAirCB53 < threshold_AirCB53) { //
				score_AirCB53 = score_AirCB53 + 2;
			} else if (currentTSInSecAirCB53 >= threshold_AirCB53 && currentTSInSecAirCB53 < threshold_AirCB53 + 9) { //
				score_AirCB53 = score_AirCB53 +0;
			} else if (currentTSInSecAirCB53 >= threshold_AirCB53 + 9
					&& currentTSInSecAirCB53 < threshold_AirCB53 + 18) { //
				score_AirCB53 = score_AirCB53 + 2;
			} else if (currentTSInSecAirCB53 >= threshold_AirCB53 + 18) { //
				score_AirCB53 = score_AirCB53 +2;
			}else {
				score_AirCB53 = score_AirCB53 +4;
			}
		}else {
			score_AirCB53 = score_AirCB53 +4;
		}
		System.out.println(" Score of AirCB53: " + score_AirCB53 + "");
		totalScore = totalScore + score_AirCB53; // set score_AirCraftName

		int score_AirCB18 = 0;
		Long currentTSInSecAirCB18 = (Long) mapTimeDiffInSec.get("AirCB18"); // set aircraft name
		long threshold_AirCB18 = 899; // set threshold
		if (currentTSInSecAirCB18 != null) {
			if (currentTSInSecAirCB18 > 0 && currentTSInSecAirCB18 < threshold_AirCB18) { //
				score_AirCB18 = score_AirCB18 + 2;
			} else if (currentTSInSecAirCB18 >= threshold_AirCB18 && currentTSInSecAirCB18 < threshold_AirCB18 + 9) { //
				score_AirCB18 = score_AirCB18 +0;
			} else if (currentTSInSecAirCB18 >= threshold_AirCB18 + 9
					&& currentTSInSecAirCB18 < threshold_AirCB18 + 18) { //
				score_AirCB18 = score_AirCB18 + 2;
			} else if (currentTSInSecAirCB18 >= threshold_AirCB18 + 18) { //
				score_AirCB18 = score_AirCB18 +2;
			}else {
				score_AirCB18 = score_AirCB18 +4;
			}
		}else {
			score_AirCB18 = score_AirCB18 +4;
		}
		System.out.println(" Score of AirCB18: " + score_AirCB18 + "");
		totalScore = totalScore + score_AirCB18; // set score_AirCraftName

		int score_AirCB63 = 0;
		Long currentTSInSecAirCB63 = (Long) mapTimeDiffInSec.get("AirCB63"); // set aircraft name
		long threshold_AirCB63 = 945; // set threshold
		if (currentTSInSecAirCB63 != null) {
			if (currentTSInSecAirCB63 > 0 && currentTSInSecAirCB63 < threshold_AirCB63) { //
				score_AirCB63 = score_AirCB63 + 2;
			} else if (currentTSInSecAirCB63 >= threshold_AirCB63 && currentTSInSecAirCB63 < threshold_AirCB63 + 9) { //
				score_AirCB63 = score_AirCB63 +0;
			} else if (currentTSInSecAirCB63 >= threshold_AirCB63 + 9
					&& currentTSInSecAirCB63 < threshold_AirCB63 + 18) { //
				score_AirCB63 = score_AirCB63 + 2;
			} else if (currentTSInSecAirCB63 >= threshold_AirCB63 + 18) { //
				score_AirCB63 = score_AirCB63 +2;
			}else {
				score_AirCB63 = score_AirCB63 +4;
			}
		}else {
			score_AirCB63 = score_AirCB63 +4;
		}
		System.out.println(" Score of AirCB63: " + score_AirCB63 + "");
		totalScore = totalScore + score_AirCB63; // set score_AirCraftName

		int score_AirCB51 = 0;
		Long currentTSInSecAirCB51 = (Long) mapTimeDiffInSec.get("AirCB51"); // set aircraft name
		long threshold_AirCB51 = 926; // set threshold
		if (currentTSInSecAirCB51 != null) {
			if (currentTSInSecAirCB51 > 0 && currentTSInSecAirCB51 < threshold_AirCB51) { //
				score_AirCB51 = score_AirCB51 + 2;
			} else if (currentTSInSecAirCB51 >= threshold_AirCB51 && currentTSInSecAirCB51 < threshold_AirCB51 + 9) { //
				score_AirCB51 = score_AirCB51 +0;
			} else if (currentTSInSecAirCB51 >= threshold_AirCB51 + 9
					&& currentTSInSecAirCB51 < threshold_AirCB51 + 18) { //
				score_AirCB51 = score_AirCB51 + 2;
			} else if (currentTSInSecAirCB51 >= threshold_AirCB51 + 18) { //
				score_AirCB51 = score_AirCB51 +2;
			}else {
				score_AirCB51 = score_AirCB51 +4;
			}
		}else {
			score_AirCB51 = score_AirCB51 +4;
		}
		System.out.println(" Score of AirCB51: " + score_AirCB51 + "");
		totalScore = totalScore + score_AirCB51; // set score_AirCraftName

		int score_AirCB29 = 0;
		Long currentTSInSecAirCB29 = (Long) mapTimeDiffInSec.get("AirCB29"); // set aircraft name
		long threshold_AirCB29 = 983; // set threshold
		if (currentTSInSecAirCB29 != null) {
			if (currentTSInSecAirCB29 > 0 && currentTSInSecAirCB29 < threshold_AirCB29) { //
				score_AirCB29 = score_AirCB29 + 2;
			} else if (currentTSInSecAirCB29 >= threshold_AirCB29 && currentTSInSecAirCB29 < threshold_AirCB29 + 9) { //
				score_AirCB29 = score_AirCB29 +0;
			} else if (currentTSInSecAirCB29 >= threshold_AirCB29 + 9
					&& currentTSInSecAirCB29 < threshold_AirCB29 + 18) { //
				score_AirCB29 = score_AirCB29 + 2;
			} else if (currentTSInSecAirCB29 >= threshold_AirCB29 + 18) { //
				score_AirCB29 = score_AirCB29 +2;
			}else {
				score_AirCB29 = score_AirCB29 +4;
			}
		}else {
			score_AirCB29 = score_AirCB29 +4;
		}
		System.out.println(" Score of AirCB29: " + score_AirCB29 + "");
		totalScore = totalScore + score_AirCB29; // set score_AirCraftName

		int score_AirCB55 = 0;
		Long currentTSInSecAirCB55 = (Long) mapTimeDiffInSec.get("AirCB55"); // set aircraft name
		long threshold_AirCB55 = 1012; // set threshold
		if (currentTSInSecAirCB55 != null) {
			if (currentTSInSecAirCB55 > 0 && currentTSInSecAirCB55 < threshold_AirCB55) { //
				score_AirCB55 = score_AirCB55 + 2;
			} else if (currentTSInSecAirCB55 >= threshold_AirCB55 && currentTSInSecAirCB55 < threshold_AirCB55 + 9) { //
				score_AirCB55 = score_AirCB55 +0;
			} else if (currentTSInSecAirCB55 >= threshold_AirCB55 + 9
					&& currentTSInSecAirCB55 < threshold_AirCB55 + 18) { //
				score_AirCB55 = score_AirCB55 + 2;
			} else if (currentTSInSecAirCB55 >= threshold_AirCB55 + 18) { //
				score_AirCB55 = score_AirCB55 +2;
			}else {
				score_AirCB55 = score_AirCB55 +4;
			}
		}else {
			score_AirCB55 = score_AirCB55 +4;
		}
		System.out.println(" Score of AirCB55: " + score_AirCB55 + "");
		totalScore = totalScore + score_AirCB55; // set score_AirCraftName

		int score_AirCB52 = 0;
		Long currentTSInSecAirCB52 = (Long) mapTimeDiffInSec.get("AirCB52"); // set aircraft name
		long threshold_AirCB52 = 1029; // set threshold
		if (currentTSInSecAirCB52 != null) {
			if (currentTSInSecAirCB52 > 0 && currentTSInSecAirCB52 < threshold_AirCB52) { //
				score_AirCB52 = score_AirCB52 + 2;
			} else if (currentTSInSecAirCB52 >= threshold_AirCB52 && currentTSInSecAirCB52 < threshold_AirCB52 + 9) { //
				score_AirCB52 = score_AirCB52 +0;
			} else if (currentTSInSecAirCB52 >= threshold_AirCB52 + 9
					&& currentTSInSecAirCB52 < threshold_AirCB52 + 18) { //
				score_AirCB52 = score_AirCB52 + 2;
			} else if (currentTSInSecAirCB52 >= threshold_AirCB52 + 18) { //
				score_AirCB52 = score_AirCB52 +2;
			}else {
				score_AirCB52 = score_AirCB52 +4;
			}
		}else {
			score_AirCB52 = score_AirCB52 +4;
		}
		System.out.println(" Score of AirCB52: " + score_AirCB52 + "");
		totalScore = totalScore + score_AirCB52; // set score_AirCraftName

		int score_AirCB60 = 0;
		Long currentTSInSecAirCB60 = (Long) mapTimeDiffInSec.get("AirCB60"); // set aircraft name
		long threshold_AirCB60 = 1056; // set threshold
		if (currentTSInSecAirCB60 != null) {
			if (currentTSInSecAirCB60 > 0 && currentTSInSecAirCB60 < threshold_AirCB60) { //
				score_AirCB60 = score_AirCB60 + 2;
			} else if (currentTSInSecAirCB60 >= threshold_AirCB60 && currentTSInSecAirCB60 < threshold_AirCB60 + 9) { //
				score_AirCB60 = score_AirCB60 +0;
			} else if (currentTSInSecAirCB60 >= threshold_AirCB60 + 9
					&& currentTSInSecAirCB60 < threshold_AirCB60 + 18) { //
				score_AirCB60 = score_AirCB60 + 2;
			} else if (currentTSInSecAirCB60 >= threshold_AirCB60 + 18) { //
				score_AirCB60 = score_AirCB60 +2;
			}else {
				score_AirCB60 = score_AirCB60 +2;
			}
		}else {
			score_AirCB60 = score_AirCB60 +2;
		}
		System.out.println(" Score of AirCB60: " + score_AirCB60 + "");
		totalScore = totalScore + score_AirCB60; // set score_AirCraftName

		int score_AirCB30 = 0;
		Long currentTSInSecAirCB30 = (Long) mapTimeDiffInSec.get("AirCB30"); // set aircraft name
		long threshold_AirCB30 = 1056; // set threshold
		if (currentTSInSecAirCB30 != null) {
			if (currentTSInSecAirCB30 > 0 && currentTSInSecAirCB30 < threshold_AirCB30) { //
				score_AirCB30 = score_AirCB30 + 2;
			} else if (currentTSInSecAirCB30 >= threshold_AirCB30 && currentTSInSecAirCB30 < threshold_AirCB30 + 9) { //
				score_AirCB30 = score_AirCB30 +0;
			} else if (currentTSInSecAirCB30 >= threshold_AirCB30 + 9
					&& currentTSInSecAirCB30 < threshold_AirCB30 + 18) { //
				score_AirCB30 = score_AirCB30 + 2;
			} else if (currentTSInSecAirCB30 >= threshold_AirCB30 + 18) { //
				score_AirCB30 = score_AirCB30 +2;
			}else {
				score_AirCB30 = score_AirCB30 +4;
			}
		}else {
			score_AirCB30 = score_AirCB30 +4;
		}
		System.out.println(" Score of AirCB30: " + score_AirCB30 + "");
		totalScore = totalScore + score_AirCB30; // set score_AirCraftName

		int score_AirCB62 = 0;
		Long currentTSInSecAirCB62 = (Long) mapTimeDiffInSec.get("AirCB62"); // set aircraft name
		long threshold_AirCB62 = 1056; // set threshold
		if (currentTSInSecAirCB62 != null) {
			if (currentTSInSecAirCB62 > 0 && currentTSInSecAirCB62 < threshold_AirCB62) { //
				score_AirCB62 = score_AirCB62 + 2;
			} else if (currentTSInSecAirCB62 >= threshold_AirCB62 && currentTSInSecAirCB62 < threshold_AirCB62 + 9) { //
				score_AirCB62 = score_AirCB62 +0;
			} else if (currentTSInSecAirCB62 >= threshold_AirCB62 + 9
					&& currentTSInSecAirCB62 < threshold_AirCB62 + 18) { //
				score_AirCB62 = score_AirCB62 + 2;
			} else if (currentTSInSecAirCB62 >= threshold_AirCB62 + 18) { //
				score_AirCB62 = score_AirCB62 +2;
			}else {
				score_AirCB62 = score_AirCB62 +4;
			}
		}else {
			score_AirCB62 = score_AirCB62 +4;
		}
		System.out.println(" Score of AirCB62: " + score_AirCB62 + "");
		totalScore = totalScore + score_AirCB62; // set score_AirCraftName

		int score_AirCB35 = 0;
		Long currentTSInSecAirCB35 = (Long) mapTimeDiffInSec.get("AirCB35"); // set aircraft name
		long threshold_AirCB35 = 1118; // set threshold
		if (currentTSInSecAirCB35 != null) {
			if (currentTSInSecAirCB35 > 0 && currentTSInSecAirCB35 < threshold_AirCB35) { //
				score_AirCB35 = score_AirCB35 + 2;
			} else if (currentTSInSecAirCB35 >= threshold_AirCB35 && currentTSInSecAirCB35 < threshold_AirCB35 + 9) { //
				score_AirCB35 = score_AirCB35 +0;
			} else if (currentTSInSecAirCB35 >= threshold_AirCB35 + 9
					&& currentTSInSecAirCB35 < threshold_AirCB35 + 18) { //
				score_AirCB35 = score_AirCB35 + 2;
			} else if (currentTSInSecAirCB35 >= threshold_AirCB35 + 18) { //
				score_AirCB35 = score_AirCB35 +2;
			}else {
				score_AirCB35 = score_AirCB35 +4;
			}
		}else {
			score_AirCB35 = score_AirCB35 +4;
		}
		System.out.println(" Score of AirCB35: " + score_AirCB35 + "");
		totalScore = totalScore + score_AirCB35; // set score_AirCraftName

		int score_AirCB48 = 0;
		Long currentTSInSecAirCB48 = (Long) mapTimeDiffInSec.get("AirCB48"); // set aircraft name
		long threshold_AirCB48 = 1154; // set threshold
		if (currentTSInSecAirCB48 != null) {
			if (currentTSInSecAirCB48 > 0 && currentTSInSecAirCB48 < threshold_AirCB48) { //
				score_AirCB48 = score_AirCB48 + 2;
			} else if (currentTSInSecAirCB48 >= threshold_AirCB48 && currentTSInSecAirCB48 < threshold_AirCB48 + 9) { //
				score_AirCB48 = score_AirCB48 +0;
			} else if (currentTSInSecAirCB48 >= threshold_AirCB48 + 9
					&& currentTSInSecAirCB48 < threshold_AirCB48 + 18) { //
				score_AirCB48 = score_AirCB48 + 2;
			} else if (currentTSInSecAirCB48 >= threshold_AirCB48 + 18) { //
				score_AirCB48 = score_AirCB48 +2;
			}else {
				score_AirCB48 = score_AirCB48 +4;
			}
		}else {
			score_AirCB48 = score_AirCB48 +4;
		}
		System.out.println(" Score of AirCB48: " + score_AirCB48 + "");
		totalScore = totalScore + score_AirCB48; // set score_AirCraftName
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("Total Demerit Score of Trial 2 : "+totalScore+"");
		// int totalScore2=0;
		// Long currentTSInSecAirCB8 =(Long) mapTimeDiffInSec.get("AirCB1") ;
		// //System.out.println("test:"+currentTSInSecAirCB8);
		// if(currentTSInSecAirCB8 != null ) {
		// if (currentTSInSecAirCB8 > 0 && currentTSInSecAirCB8 < 32) {
		// totalScore2 = totalScore2 + 2;
		// }else if (currentTSInSecAirCB8 >= 32 && currentTSInSecAirCB8 < 60 ) {
		// totalScore2 = totalScore2 +0;
		// }else if (currentTSInSecAirCB8 >= 60 && currentTSInSecAirCB8 < 90 ) {
		// totalScore2 = totalScore2 + 2;
		// }else if (currentTSInSecAirCB8 >= 90 ) {
		// totalScore2 = totalScore2 +2;
		// }
		// }

		// Long totalScore3=(long) (totalScore1+totalScore2);
		// System.out.println(" Score of AirCB1: "+totalScore2 +"");
		// System.out.println("Total Score of Trial 1 : "+totalScore3+"/20");

	}

	public static HashMap<String, Long> getTimeDiffStartAccept(Date StartOfSim, HashMap<String, Date> mapInDate) {

		HashMap<String, Long> mapOfDateDiff = new HashMap<String, Long>();
		Iterator it = mapInDate.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();

			Date currentTS = (Date) pair.getValue();

			long diffInMillies = currentTS.getTime() - StartOfSim.getTime();

			mapOfDateDiff.put((String) pair.getKey(), diffInMillies / 1000l);

			// System.out.println(pair.getKey() + " = " + pair.getValue());
			// it.remove(); // avoids a ConcurrentModificationException
		}

		//System.out.println("Diff in Start and Accepted Time in Seconds with respect to start time of simulator.");
		//System.out.println("<AirCraftName = Time Taken to accept the aircraft in Seconds > : : " + mapOfDateDiff);
		//System.out.println();

		return mapOfDateDiff;

	}

	public static HashMap<String, Date> convertStringMap2DateMap(HashMap<String, String> mapInString) {

		HashMap<String, Date> mapInDate = new HashMap<String, Date>();
		Iterator it = mapInString.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();

			Date currentTS = null;
			SimpleDateFormat formatter6 = new SimpleDateFormat("EE MMM dd HH:mm:ss yyyy");
			// System.out.println("STartTime :"+ startTime);
			String currentTSinString = (String) pair.getValue();
			try {
				currentTS = formatter6.parse(currentTSinString);
				// System.out.println(currentTS);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			mapInDate.put((String) pair.getKey(), currentTS);

			// System.out.println(pair.getKey() + " = " + pair.getValue());
			// it.remove(); // avoids a ConcurrentModificationException
		}

		//System.out.println();
		//System.out.println("<AirCraftName = Accepted Timestamp > : " + mapInDate);
		//System.out.println();

		return mapInDate;

	}

}
