package CreateReportTrial1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestBlocks {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, ParseException {
		// TODO Auto-generated method stub
		PrintWriter writer = new PrintWriter("Report/Test_Report.txt", "UTF-8");

		String startTime = StartTimeOfSimulatorTrail1.getStartTimeOfSimulator();

		writer.println("Start time of simulator : " + startTime);
		HashMap<String, String> mapOfAcceptTS = FinalAcceptedTimeOfAirCraftUsingHashMap.getMapOfAcceptedTimes();

		// string to date conversion logic
		Date startTS = null;
		SimpleDateFormat formatter6 = new SimpleDateFormat("EE MMM dd HH:mm:ss yyyy");
		writer.println("STartTime :" + startTime);
		String date1 = startTime;
		startTS = formatter6.parse(date1);
		writer.println(startTS);
		
		HashMap<String, String> mapInString = FinalAcceptedTimeOfAirCraftUsingHashMap.getMapOfAcceptedTimes();
		HashMap<String, Date> dateMap = convertStringMap2DateMap(mapInString);

		String startTimeOfSim = StartTimeOfSimulatorTrail1.getStartTimeOfSimulator();
		HashMap<String, Long> mapTimeDiffInSec = getTimeDiffStartAccept(startTS, dateMap);
		System.out.println(mapTimeDiffInSec);
		

		
		
		
		
		
		writer.close();
	}

	public static HashMap<String, Long> getTimeDiffStartAccept(Date StartOfSim, HashMap<String, Date> mapInDate)
			throws FileNotFoundException, UnsupportedEncodingException {

		// PrintWriter writer = new PrintWriter("Report/Trial1_Report.txt", "UTF-8");
		// PrintWriter wr = new PrintWriter(new FileOutputStream(new
		// File("Report/Trial1_Report.txt"),true /* append = true */));

		HashMap<String, Long> mapOfDateDiff = new HashMap<String, Long>();
		Iterator it = mapInDate.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();

			Date currentTS = (Date) pair.getValue();

			long diffInMillies = currentTS.getTime() - StartOfSim.getTime();

			mapOfDateDiff.put((String) pair.getKey(), diffInMillies / 1000l);

			// writer.println(pair.getKey() + " = " + pair.getValue());
			// it.remove(); // avoids a ConcurrentModificationException
		}

		// wr.append("Diff in Start and Accepted Time in Seconds with respect to start
		// time of simulator.");
		// wr.append("<AirCraftName = Time Taken to accept the aircraft in Seconds > : :
		// "+mapOfDateDiff);
		// wr.close();

		return mapOfDateDiff;

	}

	public static HashMap<String, Date> convertStringMap2DateMap(HashMap<String, String> mapInString)
			throws FileNotFoundException, UnsupportedEncodingException {
		// PrintWriter wr = new PrintWriter(new FileOutputStream(new
		// File("Report/Trial1_Report.txt"),true /* append = true */));
		HashMap<String, Date> mapInDate = new HashMap<String, Date>();
		Iterator it = mapInString.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();

			Date currentTS = null;
			SimpleDateFormat formatter6 = new SimpleDateFormat("EE MMM dd HH:mm:ss yyyy");
			// writer.println("STartTime :"+ startTime);
			String currentTSinString = (String) pair.getValue();
			try {
				currentTS = formatter6.parse(currentTSinString);
				// writer.println(currentTS);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			mapInDate.put((String) pair.getKey(), currentTS);

			// writer.println(pair.getKey() + " = " + pair.getValue());
			// it.remove(); // avoids a ConcurrentModificationException
		}

		// wr.println();
		// wr.append("<AirCraftName = Accepted Timestamp > : "+mapInDate);
		// wr.println();
		// wr.close();

		return mapInDate;

	}
}
