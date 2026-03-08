package leetcode.array.spammessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 3295. Report Spam Message
// https://leetcode.com/problems/report-spam-message/description/
public class Solution {

    public boolean reportSpam(String[] message, String[] bannedWords) {

        Set<String> bannedWordsSet =
                new HashSet<>(Arrays.asList(bannedWords));

        int count = 0;
        for (String mes : message) {
            if (bannedWordsSet.contains(mes)){
                if (++count == 2) {
                    return true;
                };
            }
        }

        return false;
    }

    public static void main(String[] args) {
/*

        String[] message = new String[] { "hello","world","leetcode" };
        String[] bannedWords = new String[] { "world","hello" };
*/

        String[] message = new String[] { "l","i","l","i","l" };
        String[] bannedWords = new String[] { "d","a","i","v","a" };

        boolean result = new Solution()
                .reportSpam(message, bannedWords);

        System.out.println(result ? "Spam" : "Not spam");



    }

}
