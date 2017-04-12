package vb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Il n'existe pas de meilleure modification" );
        App monApp = new App() ;
		System.out.println("Max : " + monApp.max(4,5));
		System.out.println("Max : " + monApp.max(5,4));
		int monmax = 0;
		try {
        	CSVReader reader = new CSVReader (new FileReader ("data.csv"));
        	CSVWriter writer = new CSVWriter (new FileWriter ("data_filtered.csv"),',',CSVWriter.NO_QUOTE_CHARACTER);

        	try {
        		List<String []> myEntries = reader.readAll();
        		for (String[] entries : myEntries){
        			List<String> list = Arrays.asList(entries);
    		    	Vector<String> sortie = new Vector<String>();
    		    	CollectionUtils.select(list, new Predicate<String>(){

						public boolean evaluate(String arg0) {
							// TODO Auto-generated method stub
							int entier = Integer.parseInt(arg0);
							if (entier <50) { 
								return true;
							}
							else return false;
							
						}
    		    		
    		    	}, sortie);
    		    	System.out.println("sortie : " + sortie);
    		    	
    		    	writer.writeNext(sortie.toArray(new String[0]));
    		    	
    		    	for (String i : entries) {
        		    	monmax=monApp.max(monmax, Integer.parseInt(i));
        		    }
                }
        		System.out.println("Le max du fichier est : " + monmax);
        		
        	}
        	catch(FileNotFoundException e) {
               	System.out.println(e.getMessage());
            } 
        	reader.close();
        	writer.close();
		}
        catch (IOException e) {
        	e.printStackTrace();
        }
    }
    public int max(int a, int b)
    {
    	return a < b?b:a;
    }
}
