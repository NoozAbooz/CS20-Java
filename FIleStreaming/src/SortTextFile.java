import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
 
public class SortTextFile
{
	public static void removeDuplicates() throws Exception {
        // PrintWriter object for output.txt 
        PrintWriter pw = new PrintWriter("temp.txt"); 
          
        // BufferedReader object for input.txt 
        BufferedReader br = new BufferedReader(new FileReader("dictionary3.txt")); 
          
        String line = br.readLine(); 
          
        // set store unique values 
        HashSet<String> hs = new HashSet<String>(); 
          
        // loop for each line of input.txt 
        while(line != null) 
        { 
            // write only if not 
            // present in hashset 
            if(hs.add(line)) 
                pw.println(line); 
              
            line = br.readLine(); 
              
        } 
          
        pw.flush(); 
          
        // closing resources 
        br.close(); 
        pw.close(); 
          
        System.out.println("File operation performed successfully"); 
	}
	
    public static void main(String[] args) throws Exception
    {
    	removeDuplicates();
        BufferedReader reader = null; 
 
        BufferedWriter writer = null;
 
        //Create an ArrayList object to hold the lines of input file
 
        ArrayList<String> lines = new ArrayList<String>();
 
        try
        {
            //Creating BufferedReader object to read the input file
 
            reader = new BufferedReader(new FileReader("temp.txt"));
 
            //Reading all the lines of input file one by one and adding them into ArrayList
 
            String currentLine = reader.readLine();
 
            while (currentLine != null)
            {
                lines.add(currentLine);
 
                currentLine = reader.readLine();
            }
 
            //Sorting the ArrayList
 
            Collections.sort(lines);
 
            //Creating BufferedWriter object to write into output file
 
            writer = new BufferedWriter(new FileWriter("output.txt"));
 
            //Writing sorted lines into output file
 
            for (String line : lines)
            {
                writer.write(line);
 
                writer.newLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //Closing the resources
 
            try
            {
                if (reader != null)
                {
                    reader.close();
                }
 
                if(writer != null)
                {
                    writer.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}