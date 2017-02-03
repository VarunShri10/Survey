/*
 * @author Varun
 * Date : 27-01-2017
 * This class provide Survey Implementation
 */
package Survey;

import java.io.IOException;

//Class that drives the project
public class DrivingClass {

	public static void main(String[] args) throws IOException {
		
		//Getting all file destinations ready
		String answerFile = "C:\\Users\\Varun\\workspace\\OOpsProject\\src\\Survey\\Answers.txt";
		String questionFile = "C:\\Users\\Varun\\workspace\\OOpsProject\\src\\Survey\\Questions.txt";
		String reportFile = "C:\\Users\\Varun\\workspace\\OOpsProject\\src\\Survey\\Report.txt"; 
		
		ReaderClass readerObject = new ReaderClass();
		WriterClass writerObject = new WriterClass();
		
		//Reads question from file, reads the answer then calls file writing function
		readerObject.operation(questionFile, answerFile, reportFile);
		readerObject.close();
		
		//Shows the answers user entered
		System.out.println("Fetching your answers: ");
		readerObject.operation(answerFile);
		writerObject.reset(answerFile);
		System.out.println();

		//Shows all the answers entered till date
		System.out.println("Fetching reports:");
		readerObject.operation(reportFile);
	
		//Finally closes all files
		readerObject.close();
	}
}