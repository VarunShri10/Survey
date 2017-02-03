/*
 * @author Varun
 * Date : 27-01-2017
 * This class display data of file
 */
package Survey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DisplayData {

	public void showFiledata() throws IOException{
		char array1[]=new char[1000];
		File reportObject=new File("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\Survey\\myReportFile.txt");
		FileReader fileReaderObject1=new FileReader(reportObject);
		fileReaderObject1.read(array1);
		System.out.println("");
		for(char c:array1){
			System.out.print(c);
		}
		fileReaderObject1.close();
		
		System.out.println("\nMYMCQ File : ");
		File reportObject1=new File("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\Survey\\myMCQ.txt");
		FileReader fileReaderObject11=new FileReader(reportObject1);
		BufferedReader br=new BufferedReader(fileReaderObject11);
		String dataString="";
		int countSum=0;
		while((dataString=br.readLine())!=null){
			countSum=countSum+Integer.parseInt(dataString);
		}
		showAReport(countSum,"C:\\Users\\Varun\\workspace\\OOpsProject\\src\\Survey\\myMCQ.txt");
			
		
	}
	void showAReport(int sum,String PATH) throws IOException{
		BufferedReader bufferObject=new BufferedReader(new FileReader(PATH));
		String data="";
		int value;
		int choice=1;
		float tempresult;
		while((data=bufferObject.readLine())!=null){
			value=Integer.parseInt(data);
			tempresult=((float)value/sum)*100;
			System.out.println(choice+"-"+(tempresult));
		}
		
		
	}
}
