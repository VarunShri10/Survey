/*
 * @author Varun
 * Date : 27-01-2017
 * This class writes contents in respective File
 */
package Survey;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteReadFile {
	String PATHQUESTION="C:\\Users\\Varun\\workspace\\OOpsProject\\src\\Survey\\myQuestionFile.txt";
	String ANSWERPATH="C:\\Users\\Varun\\workspace\\OOpsProject\\src\\Survey\\myAnswerFile.txt";
	String REPORTPATH="C:\\Users\\Varun\\workspace\\OOpsProject\\src\\Survey\\myReportFile.txt";
	String MCQPATH="C:\\Users\\Varun\\workspace\\OOpsProject\\src\\Survey\\myMCQ.txt";
	public void function() throws Exception {
		int flag=0;
		File fileObject=new File(PATHQUESTION);
		File answerObject=new File(ANSWERPATH);
		File reportObject=new File(REPORTPATH);
		FileWriter fileWriterObject=new FileWriter(answerObject);
		FileWriter fileWriterReportObject=new FileWriter(reportObject,true);
		String s="";
		Scanner scannerObject=new Scanner(System.in);
		FileReader fileReaderObject=new FileReader(fileObject);
		char array[]=new char[1000];
		fileReaderObject.read(array);
		
		for(char c:array){
			System.out.print(c);
			if(c==13){
				System.out.println("Enter Answer : ");
				s=scannerObject.nextLine();
				while(s.equals("")){
					System.out.println("Enter Input ");
					s=scannerObject.nextLine();
				}
				if(flag==0){
					WriteMCQ(s);
					fileWriterObject.write(s);
					fileWriterObject.write('\n');
					fileWriterReportObject.write(s);
					fileWriterReportObject.write('\n');
				}
				else {
					fileWriterObject.write(s);
					fileWriterObject.write('\n');
					fileWriterReportObject.write(s);
					fileWriterReportObject.write('\n');
				}
				flag++;
			}
				
			
		}
		fileWriterObject.close();
		scannerObject.close();
		fileReaderObject.close();
		fileWriterReportObject.close();
		
		//bufferWriterObject.close();
	}
	
	void WriteMCQ(String s) throws Exception{
		FileReader fileReaderObject=new FileReader(MCQPATH);
		BufferedReader bufferReaderObject=new BufferedReader(fileReaderObject);
		String data="";
		String newData="";
		int number=Integer.parseInt(s);
		//System.out.println("Integer : "+number);
		int i=0;
		while((i<number-1))
		{
			bufferReaderObject.readLine();
			//System.out.println("Data : "+data);
			i++;
		}
		data=bufferReaderObject.readLine();
		//System.out.println("Fetched Data : "+data);
		int a=Integer.parseInt(data);
		a++;
		Integer b=a;
		newData=b.toString();
		WriteMcq(MCQPATH,newData,number);
		fileReaderObject.close();	
		
	
	}
	
	
	void WriteMcq(String PATH,String value,int position) throws Exception{
		
		List<String> lines = new ArrayList<String>();

	    // first, read the file and store the changes
	    BufferedReader in = new BufferedReader(new FileReader(PATH));
	    String line = in.readLine();
	    while (line != null) {
	        position--;
	        if(position == 0) {
	        	line = value;
	        }
	        lines.add(line);
	        line = in.readLine();
	    }
	    in.close();

	    PrintWriter out = new PrintWriter(PATH);
	    for (String l : lines)
	        out.println(l);
	    out.close();
	}

}
