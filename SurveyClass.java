
/*
 * @author Varun
 * Date : 27-01-2017
 * This class provide Survey Implementation
 */
package Survey;

import java.io.*;
import java.util.Scanner;

public class SurveyClass {

	
	public static void main(String[] args) throws Exception {
		
		WriteReadFile writeReadObject=new WriteReadFile();
		writeReadObject.function();
		
		DisplayData displayDataObject=new DisplayData();
		displayDataObject.showFiledata();
	}
}
