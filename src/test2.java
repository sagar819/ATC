import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class test2 {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub

		PrintWriter writer = new PrintWriter("Report/the-file-name.txt", "UTF-8");
		writer.println("The first line");
		writer.println("The second line");
		writer.println("********");
		
		writer.close();
	}

}
