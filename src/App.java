
public class App {

	
	public static void main(String[] args) {
		
			
		String txt1 = Documents.getArchieve("1.txt");
		String txt2 = Documents.getArchieve("2.txt");
		String txt3 = Documents.getArchieve("3.txt");
		String txt4 = Documents.getArchieve("4.txt");
		String txt5 = Documents.getArchieve("5.txt");
		String txt6 = Documents.getArchieve("6.txt");
		String txt7 = Documents.getArchieve("7.txt");
		String txt8 = Documents.getArchieve("8.txt");
		String txt9 = Documents.getArchieve("9.txt");
		String txt10 = Documents.getArchieve("10.txt");
		String txt11 = Documents.getArchieve("11.txt");
		String txt12 = Documents.getArchieve("12.txt");
		String txt13 = Documents.getArchieve("13.txt");
		String txt14 = Documents.getArchieve("14.txt");
		String txt15 = Documents.getArchieve("15.txt");
		String txt16 = Documents.getArchieve("16.txt");
		String txt17 = Documents.getArchieve("17.txt");
		String txt18 = Documents.getArchieve("18.txt");
	
		String[] texts = {txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18};
		String[] words = {"software","pattern", "recognition" ,"molecule","structure" };
		
				System.out.println("Frequency matrix:");
				Operations.printMatrix(Operations.generateFrequencyMatrix(words, texts));
				System.out.println("------------------------");

				System.out.println("Term frequency (TF):");
				Operations.printMatrix(Operations.generateTF(Operations.generateFrequencyMatrix(words, texts)));
				System.out.println("------------------------");

				System.out.println("Document Frequency (DF):");
				Operations.printMatrix(Operations.generateDF(words, texts));
				System.out.println("------------------------");

				System.out.println("Inverse Document Frequency (IDF):");
				Operations.printMatrix(Operations.generateIDF(texts.length,Operations.generateDF(words, texts)));
				System.out.println("------------------------");

				
		System.out.println("Rank (TF-IDF):");
		Operations.printArray(Operations.generateCompleteRank(words, texts));
		System.out.println("------------------------");
		
		System.out.println("All words TF-IDF:");
		Operations.printArray(Operations.generateSuperTfList(texts),25);
		
		

	
	}
}
