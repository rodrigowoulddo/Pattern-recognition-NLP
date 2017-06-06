import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Operations {

	private static String[] stopWrds = { "n","de","k","the "," ", "n,", "is,", ",", "at", "can", "by", "our", "to", "a", "of", "was", "and",
			"the", "without", "see", "unless", "due", "also", "must", "might", "like", "]", "[", "}", "{", "<", ">",
			"?", "\"", "\\", "/", ")", "(", "will", "may", "can", "much", "every", "the", "in", "other", "the", "many",
			"any", "an", "or", "for", "in", "an", "an ", "is", "a", "about", "above", "after", "again", "against",
			"all", "am", "an", "and", "any", "are", "aren’t", "as", "at", "be", "because", "been", "before", "being",
			"below", "between", "both", "but", "by", "can’t", "cannot", "could", "couldn’t", "did", "didn’t", "do",
			"does", "doesn’t", "doing", "don’t", "down", "during", "each", "few", "for", "from", "further", "had",
			"hadn’t", "has", "hasn’t", "have", "haven’t", "having", "he", "he’d", "he’ll", "he’s", "her", "here",
			"here’s", "hers", "herself", "him", "himself", "his", "how", "how’s", "i ", " i", "i’d", "i’ll", "i’m",
			"i’ve", "if", "in", "into", "is", "isn’t", "it", "it’s", "its", "itself", "let’s", "me", "more", "most",
			"mustn’t", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "ought", "our", "ours",
			"ourselves", "out", "over", "own", "same", "shan’t", "she", "she’d", "she’ll", "she’s", "should",
			"shouldn’t", "so", "some", "such", "than", "that", "that’s", "their", "theirs", "them", "themselves",
			"then", "there", "there’s", "these", "they", "they’d", "they’ll", "they’re", "they’ve", "this", "those",
			"through", "to", "too", "under", "until", "up", "very", "was", "wasn’t", "we", "we’d", "we’ll", "we’re",
			"we’ve", "were", "weren’t", "what", "what’s", "when", "when’s", "where", "where’s", "which", "while", "who",
			"who’s", "whom", "why", "why’s", "with", "won’t", "would", "wouldn’t", "you", "you’d", "you’ll", "you’re",
			"you’ve", "your", "yours", "yourself", "yourselves", "Without", "See", "Unless", "Due", "Also", "Must",
			"Might", "Like", "Will", "May", "Can", "Much", "Every", "The", "In", "Other", "This", "The", "Many", "Any",
			"An", "Or", "For", "In", "An", "An ", "Is", "A", "About", "Above", "After", "Again", "Against", "All", "Am",
			"An", "And", "Any", "Are", "Aren’t", "As", "At", "Be", "Because", "Been", "Before", "Being", "Below",
			"Between", "Both", "But", "By", "Can’t", "Cannot", "Could", "Couldn’t", "Did", "Didn’t", "Do", "Does",
			"Doesn’t", "Doing", "Don’t", "Down", "During", "Each", "Few", "For", "From", "Further", "Had", "Hadn’t",
			"Has", "Hasn’t", "Have", "Haven’t", "Having", "He", "He’d", "He’ll", "He’s", "Her", "Here", "Here’s",
			"Hers", "Herself", "Him", "Himself", "His", "How", "How’s", "I ", " I", "I’d", "I’ll", "I’m", "I’ve", "If",
			"In", "Into", "Is", "Isn’t", "It", "It’s", "Its", "Itself", "Let’s", "Me", "More", "Most", "Mustn’t", "My",
			"Myself", "No", "Nor", "Not", "Of", "Off", "On", "Once", "Only", "Ought", "Our", "Ours", "Ourselves", "Out",
			"Over", "Own", "Same", "Shan’t", "She", "She’d", "She’ll", "She’s", "Should", "Shouldn’t", "So", "Some",
			"Such", "Than", "That", "That’s", "Their", "Theirs", "Them", "Themselves", "Then", "There", "There’s",
			"These", "They", "They’d", "They’ll", "They’re", "They’ve", "This", "Those", "Through", "To", "Too",
			"Under", "Until", "Up", "Very", "Was", "Wasn’t", "We", "We’d", "We’ll", "We’re", "We’ve", "Were", "Weren’t",
			"What", "What’s", "When", "When’s", "Where", "Where’s", "Which", "While", "Who", "Who’s", "Whom", "Why",
			"Why’s", "With", "Won’t", "Would", "Wouldn’t", "You", "You’d", "You’ll", "You’re", "You’ve", "Your",
			"Yours", "Yourself", "Yourselves" };

	public static LinkedList<String> removeStopWords(LinkedList<String> wordList) {
		
		LinkedList<String> wordListAux = (LinkedList<String>) wordList.clone();
		
		for (int i = 0; i < wordList.size(); i++) {
			for (String stopWord : stopWrds) {
				if(wordList.get(i).trim().equalsIgnoreCase(stopWord) || wordList.get(i).isEmpty() ){
					wordListAux.remove(stopWord);
				}
			}
		}
		wordListAux.removeAll(Arrays.asList(null,""));
		return wordListAux;
	}

	private static String removeComn(String word) {
		try {
			if (word.substring(word.length() - 1).equalsIgnoreCase(",")) {
				word = word.substring(0, word.length() - 1);
				return removeComn(word);
			} else {
				return word;
			}

		} catch (Exception e) {
			return word;
		}

	}

	public static int getTotalCountOfWord(String text, String target) {

		int countOfWords = 0;

		LinkedList<String> wordList = new LinkedList<String>(Arrays.asList(text.split(" ")));

		for (String word : wordList) {

			if (word.trim().contains(target)) {
				countOfWords++;
			}
		}

		return countOfWords;
	}

	public static int[][] generateFrequencyMatrix(String[] words, String[] texts) {

		int[][] frequancyMatrix = new int[words.length][texts.length];

		int x = 0;
		int y = 0;

		for (String word : words) {
			y = 0;
			for (String text : texts) {
				frequancyMatrix[x][y] = getTotalCountOfWord(text, word);
				y++;
			}
			x++;
		}

		return frequancyMatrix;

	}

	public static float[][] generateTF(int[][] frequancyMatrix) {

		float[][] tf = new float[frequancyMatrix.length][frequancyMatrix[0].length];

		for (int i = 0; i < frequancyMatrix.length; i++) {
			for (int j = 0; j < frequancyMatrix[i].length; j++) {

				if (frequancyMatrix[i][j] == 0)
					tf[i][j] = 0;
				else {

					tf[i][j] = (float) ((float) 1 + Math.log10(frequancyMatrix[i][j]));
				}
			}
		}

		return tf;

	}

	public static int[][] generateDF(String[] words, String[] texts) {

		int[][] documentFrequency = new int[words.length][1];

		int x = 0;
		int y = 0;

		for (String word : words) {
			y = 0;
			for (String text : texts) {
				documentFrequency[x][y] = getDocumentFrequency(word, texts);
			}
			x++;
		}
		return documentFrequency;
	}

	public static float[][] generateIDF(int numberOfDocuments, int[][] documentFrequency) {

		float[][] idf = new float[documentFrequency.length][1];

		for (int j = 0; j < documentFrequency.length; j++) {
			idf[j][0] = (float) Math.log10((float) numberOfDocuments / documentFrequency[j][0]);
		}

		return idf;

	}

	private static int getDocumentFrequency(String term, String[] texts) {

		int frequency = 0;
		for (String text : texts) {
			if (text.toLowerCase().contains(term.toLowerCase()))
				frequency++;
		}

		return frequency;

	}

	public static float[][] generateTfIdfMatrix(float[][] tf, float[][] idf) {

		float[][] tf_idf = new float[tf.length][tf[0].length];

		for (int i = 0; i < tf_idf.length; i++) {
			for (int j = 0; j < tf_idf[i].length; j++) {
				tf_idf[i][j] = tf[i][j] * idf[i][0];
			}
		}

		return tf_idf;
	}

	public static float[] generateTfIdfCount(float[][] tf_idf) {

		float[] tfIdfCount = new float[tf_idf[0].length];

		for (int j = 0; j < tf_idf[0].length; j++) {
			for (int i = 0; i < tf_idf.length; i++) {
				tfIdfCount[j] += tf_idf[i][j];
			}
		}
		return tfIdfCount;
	}

	public static ArrayList<Ranked> generateRank(float[] tfIdfCount, String[] texts) {

		ArrayList<Ranked> rank = new ArrayList<Ranked>(tfIdfCount.length);

		for (int i = 0; i < tfIdfCount.length; i++) {

			Ranked r = new Ranked();
			r.setTfidf(tfIdfCount[i]);
			r.setName(texts[i].substring(0, 5));
			rank.add(r);
		}

		rank.sort(Comparator.comparingDouble(Ranked::getTfidf));
		return rank;
	}

	public static ArrayList<Ranked> generateCompleteRank(String[] words, String[] texts) {
		float[][] tfIdfMatrix = generateTfIdfMatrix(generateTF(generateFrequencyMatrix(words, texts)),
				generateIDF(texts.length, generateDF(words, texts)));
		float[] tfIdfCount = Operations.generateTfIdfCount(tfIdfMatrix);

		return generateRank(tfIdfCount, texts);
	}

	public static ArrayList<Ranked> generateSuperTfList(String[] texts) {

		String InitialallWords = "";

		for (int i = 0; i < texts.length; i++) {
			InitialallWords += " " + texts[i];
		}

		LinkedList<String> allWordList = new LinkedList<String>(Arrays.asList(InitialallWords.split(" ")));

		for (int i = 0; i < allWordList.size(); i++) {
			allWordList.set(i, removeComn(allWordList.get(i)));
		}

		allWordList = removeStopWords(allWordList);

		Set<String> set = new HashSet<String>(allWordList);

		String[] listofWords = set.toArray(new String[set.size()]);

		int[][] frequancyMatrix = generateFrequencyMatrix(listofWords, texts);

		float[][] tf = generateTF(frequancyMatrix);
		
		int[][] df = generateDF(listofWords, texts);
		
		float[][] idf = generateIDF(texts.length, df);
		
		float[][] tf_idf = generateTfIdfMatrix(tf, idf);

		ArrayList<Ranked> rank = new ArrayList<Ranked>();

		for (int i = 0; i < tf_idf.length; i++) {
			Ranked r = new Ranked();
			r.name = listofWords[i];
			float countOfWord = 0;
			for (int j = 0; j < tf_idf[i].length; j++) {
				countOfWord += Float.parseFloat(tf_idf[i][j] + "");
			}
			r.tfidf = countOfWord;
			rank.add(r);
		}

		rank.sort(Comparator.comparingDouble(Ranked::getTfidf));
		return rank;
	}

	public static void printMatrix(Object[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printMatrix(float[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(String.format("%.2f",matrix[i][j]) + " ");
			}
			System.out.println();
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printArray(ArrayList<Ranked> rank) {

		for (int counter = rank.size() - 1; counter >= 0; counter--)
			System.out.println(rank.get(counter).toString());

	}

	public static void printArray(ArrayList<Ranked> rank, int number) {

		int total = 0;
		for (int counter = rank.size() - 1; counter >= 0; counter--) {
			System.out.println(rank.get(counter).toString());
			total++;
			if (total >= number)
				return;
		}
	}

}
