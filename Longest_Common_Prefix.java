package QuadB_Tech;
public class Longest_Common_Prefix {
	public static void main(String[] args) {
        String[] strings1 = {"flower", "flow", "flight"};
        System.out.println("Longest common prefix: " + longestCommonPrefix(strings1));

        String[] strings2 = {"dog", "racecar", "car"};
        System.out.println("Longest common prefix: " + longestCommonPrefix(strings2));
    }
    public static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            String currentString = strings[i];
            int j = 0;
            while (j < prefix.length() && j < currentString.length() && prefix.charAt(j) == currentString.charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
            if (prefix.isEmpty()) {
                break;
            }
        }
        return prefix;
    }
}
