import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main class of the program
 * 
 * @author Varik Hoang <varikmp@uw.edu>
 */
public class RadixSortMain {
	/**
	 * The main method of the program
	 * 
	 * @param theArguments the arguments of the program
	 * @throws IOException 
	 */
	
	public static void main(String[] theArguments) throws IOException {

		
		Deque<Integer> master = new LinkedDeque<Integer>();
		readFileIntoDeque("input100.txt", master);
		RadixSort.sort(master);
		writeDequeToFile("output100.txt", master);
	}

	/**
	 * The method reads all elements from the input file into queue
	 * 
	 * @param filename the input file
	 * @param queue    the queue
	 * @throws FileNotFoundException
	 */
	public static void readFileIntoDeque(String filename, Deque<Integer> queue) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String s;
		try {
			while ((s = br.readLine()) != null) {
				queue.addRear(Integer.parseInt(s));//add lines from file to queue
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * The method removes all elements in queue and writes them to output file
	 * 
	 * @param filename the output file name
	 * @param queue    the queue
	 * @throws IOException
	 */
	public static void writeDequeToFile(String filename, Deque<Integer> queue) throws IOException {
		File myFile = new File(filename);
			BufferedWriter bw = new BufferedWriter(new FileWriter(myFile));
			try {
			while (!queue.isEmpty()) {
				bw.write(queue.remove().toString());//add number to file with newline
				bw.newLine();
			}
			}

		catch (IOException e) {
			e.printStackTrace();
		}
			bw.close();
		
	}
}
