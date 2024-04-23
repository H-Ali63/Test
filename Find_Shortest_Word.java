package QuadB_Tech;

public class Find_Shortest_Word {
	public static void main(String[] args) {
        String inputString = "This is a sample string to test the function";
        String shortest = findShortestWord(inputString);
        System.out.println("Shortest word: " + shortest);
	}
    public static String findShortestWord(String str) {
        String[] words = str.split("\\s+");
        
        String shortestWord = "";
        int shortestLength = Integer.MAX_VALUE;
        
        for (String word : words) {
            if (word.length() < shortestLength) {
                shortestWord = word;
                shortestLength = word.length();
            }
        } 
        return shortestWord;
    
    }
}
