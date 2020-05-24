package Leetcode;

/**
 * 5416. 检查单词是否为句中其他单词的前缀
 */
public class main5416 {
    /**
     * 我的题解
     */
    //public int isPrefixOfWord(String sentence, String searchWord) {
    //    String[] s = sentence.split(" ");
    //    for (int i = 0; i < s.length; i++) {
    //        int index = 0;
    //        int j = 0;
    //
    //        while (index < searchWord.length()) {
    //            if (j < s[i].length()) {
    //                if (s[i].charAt(j) == searchWord.charAt(index)) {
    //                    index++;
    //                    j++;
    //                } else {
    //                    break;
    //                }
    //            } else {
    //                break;
    //            }
    //        }
    //        if (index == searchWord.length()) {
    //            return i + 1;
    //        }
    //    }
    //    return -1;
    //}

    /**
     * 利用string的startsWith()
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence == null || sentence.length() == 0 || searchWord == null || searchWord.length() == 0) {
            return -1;
        }
        String[] str = sentence.split(" ");
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (s.startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        main5416 p = new main5416();
        int res = p.isPrefixOfWord(new String("hello from the other side"), new String("they"));
        System.out.println(res);
    }
}
