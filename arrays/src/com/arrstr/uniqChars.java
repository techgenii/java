import java.lang.String;

/**
 * Created with IntelliJ IDEA.
 * User: barbarabickham
 * Date: 7/20/13
 * Time: 9:28 PM
 */
public class uniqChars {

    // Algorithm to determine if a string has all unique characters
    // Speed: O(n)
    // Space: O(1)
    public static boolean uniqChars(String str) {
        int len = str.length();
        boolean[] char_set = new boolean[256];
        int val;

        // if string is null, empty, blank, or length = 0 or greater than 256 chars, return false
        if (len > 256) {
            return false;
        } else if (str == null || str.isEmpty() || str.equals("") || len == 0) {
            return false;
        }

        // if the length of the string is 1, return true (it's unique)
        if (len == 1)
            return true;

        // check to see if the characters are the same within the string
        for (int i=0; i < len; i++) {
            val=str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;

    }

    // Algorithm to determine if a string has all unique characters
    // Use bit vector, upper case characters work also...
    // Speed: O(n)
    // Space: O(1)
    public static boolean uniqChars2(String str) {
        int len = str.length();
        int charset;

        // if string is null, empty, blank, or length = 0 or greater than 256 chars, return false
        if (len > 256) {
            return false;
        } else if (str == null || str.isEmpty() || str.equals("") || len == 0) {
            return false;
        }

        // if the length of the string is 1, return true (it's unique)
        if (len == 1)
            return true;

        // check to see if the characters are the same within the string
        // lowercase characters only
        charset = 0;
        for (int i=0; i < len; i++) {
            int val=str.charAt(i) - 'a';
            if ((charset & (1 << val)) > 0) {
                return false;
            }
            charset |= (1 << val);
        }
        return true;

    }

    /**
     * @param args command line args
     */
    public static void main(String[] args) {
        String uniqStr = "query";
        String aStr = "multiple";
        String upperStr = "RockIng";
        String moreStr = "LeTter";
        boolean uniq;


        // uniqChars calls
        uniq = uniqChars(uniqStr);
        System.out.println("uniqChars lowercase: " + uniqStr + " " + uniq);

        uniq = uniqChars(aStr);
        System.out.println("uniqChars lowercase: " + aStr + " " + uniq);

        uniq = uniqChars(upperStr);
        System.out.println("uniqChars uppercase: " + upperStr + " " + uniq);

        uniq = uniqChars(moreStr);
        System.out.println("uniqChars uppercase: " + moreStr + " " + uniq);

        // uniqChars2 calls
        uniq = uniqChars2(uniqStr);
        System.out.println("uniqChars2 lowercase: " + uniqStr + " " + uniq);

        uniq = uniqChars2(aStr);
        System.out.println("uniqChars2 lowercase: " + aStr + " " + uniq);

        uniq = uniqChars2(upperStr);
        System.out.println("uniqChars2 uppercase: " + upperStr + " " + uniq);

        uniq = uniqChars2(moreStr);
        System.out.println("uniqChars2 uppercase: " + moreStr + " " + uniq);

    }
}
