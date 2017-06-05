import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class Documents {
	
	private static String path = "src\\Documents\\";
	
	
	public static String getArchieve(String fileName){	
		
		String document = "ERROR";
		
		File fileToRead = new File(path+fileName);
		
		try( FileReader fileStream = new FileReader( fileToRead ); 
		    BufferedReader bufferedReader = new BufferedReader( fileStream ) ) {
			
			document = "";

		    String line = null;

		    while( (line = bufferedReader.readLine()) != null ) {
		    	document += " "+line;
		    }

		    } catch ( Exception ex ) {
		    	ex.printStackTrace();
		    }
		
		return document;
		
	}
	
	
	

}
