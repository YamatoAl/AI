import java.util.*;
import java.lang.*;
import java.io.*;

public class AIWork_2_9{
	
	private static String FILENAME="test.txt";
	
	public static void main(String args[]) throws IOException{
			readFile();
	}
	
	public static void readFile() throws IOException{
		FileReader fr = new FileReader(FILENAME);
		BufferedReader br = new BufferedReader(fr);
		
		String input;
		for(;br.ready();){
			input=br.readLine();
			
			input=input.replaceAll("\\Q[\\E"," ");
			input=input.replaceAll("\\Q]\\E"," ");
			input=input.replaceAll(","," ");
			
			StringTokenizer token = new StringTokenizer(input," ");
			
			ArrayList<String> location = new ArrayList<String>();
			ArrayList<String> status = new ArrayList<String>();
			
			for(;token.hasMoreTokens();){
				location.add(token.nextToken());
				status.add(token.nextToken());
			}
			
			working(location,status);
		}
		
		fr.close();
		br.close();
	}
	
	public static void working(ArrayList<String> location, ArrayList<String> status){
		
		String action="";
		
		for(int i=0;i<location.size();i++){
			if(status.get(i).equals("Dirty"))action="Suck";
			else if(location.get(i).equals("A"))action="Right";
			else if(location.get(i).equals("B"))action="Left";
		}
		
		System.out.println(action);
	}
}