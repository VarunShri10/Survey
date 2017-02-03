/*
 * @author Varun
 * Date : 27-01-2017
 * This class Write Contents in a file
 */
package Survey;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Class that writes into a file
public class WriterClass {

	//Initializes variables
	BufferedWriter bufferedWriterObject = null;
	FileWriter fileWriterObject = null;
	
	//Writes into a file 
	void write(String input, String file) throws IOException{
		fileWriterObject = new FileWriter(file, true);
		bufferedWriterObject = new BufferedWriter(fileWriterObject);
		bufferedWriterObject.write (input);
		bufferedWriterObject.append('\n');
		close();
	}
	
	//Resets the file contents, without deleting the file
	void reset (String file) throws IOException{
		PrintWriter pw = new PrintWriter(new File (file));
		pw.print("");
		pw.close();
	}
	
	//closes Buffered Writer and File Writer
	void close() throws IOException{
		if (bufferedWriterObject != null)
			bufferedWriterObject.close();

		if (fileWriterObject != null)
			fileWriterObject.close();
	}
}
