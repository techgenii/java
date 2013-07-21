public class PermuteString {

    // find all permutations of a string
    // Speed: O(n) , Size:
    public static void permuteString(String beginningString, String endingString) {
        if (endingString.length() <= 1)
            System.out.println(beginningString + endingString);
        else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                    permuteString(beginningString + endingString.charAt(i), newString);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    // swapping two characters in a string
    private static String swapChars(String str, int lIdx, int rIdx) {
        StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(lIdx), r = sb.charAt(rIdx);
        sb.setCharAt(lIdx, r);
        sb.setCharAt(rIdx, l);
        return sb.toString();
    }


    public static void main(String[] args) {

        System.out.println("Permute Strings!");

        // Permute String
        System.out.println("-- Permute String - Recursive --");
        permuteString("", "DOG");
        permuteString("", "CAT");
        permuteString("", "ABCDEFG");
        System.out.println("-- Permute String - Non-Recursive --");
    }
}
