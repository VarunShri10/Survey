/*
 * @author Varun
 * Date : 27-01-2017
 * This class reads contents from file
 */
package Survey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Reads data from file
public class ReaderClass {

	//Initializes the variables
	BufferedReader bufferedReaderObject = null;
	FileReader fileReaderObject = null;
	WriterClass writerObject = new WriterClass();
		
	//Overloaded function
	//Called when answers need to be written into another file simultaneously
	void operation(String file_read, String file_write, String report_file) throws IOException{
		
		fileReaderObject = new FileReader(file_read);
		bufferedReaderObject = new BufferedReader(fileReaderObject);
		Scanner scannerObject = new Scanner (System.in);
		
		String currentLine;
		String input;
		while ((currentLine = bufferedReaderObject.readLine()) != null){
			System.out.println(currentLine);
			input = scannerObject.nextLine();
			writerObject.write(input, report_file);
			writerObject.write(input, file_write);
		}		
		scannerObject.close();
	}
	
	//Overloaded function
	//Called when only a file is to be read
	void operation (String file_read) throws IOException{
		fileReaderObject = new FileReader(file_read);
		bufferedReaderObject = new BufferedReader(fileReaderObject);
		
		String currentLine;
		
		while ((currentLine = bufferedReaderObject.readLine()) != null){
			System.out.println(currentLine);				
		}
	}
	
	//Function to close Buffered Reader and File Reader
	void close() throws IOException{
		if (bufferedReaderObject != null)
			bufferedReaderObject.close();

		if (fileReaderObject != null)
			fileReaderObject.close();
		
	}
}
