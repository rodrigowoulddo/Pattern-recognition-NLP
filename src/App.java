import java.awt.print.Printable;

public class App {

	
	public static void main(String[] args) {
		
			
		String txt1 = Documents.getArchieve("1.txt");
		String txt2 = Documents.getArchieve("2.txt");
		String txt3 = Documents.getArchieve("3.txt");
		String txt4 = Documents.getArchieve("4.txt");
		
		String[] texts = {txt1,txt2,txt3,txt4};
		String[] words = {"pattern","software"};
		
		int[][] matrix = Operations.generateFrequencyMatrix(words, texts);
		
		
		
		Operations.printMatrix(matrix);
		Operations.printMatrix(Operations.generateTF(matrix));
	}
}
