import java.lang.reflect.Array;
import java.util.Arrays;

class valid_anagram_242{
    public static boolean isAnagram_hash(String s,String t){
        //如果两个单词长度不相等，肯定不是anagram
        if(s.length()!=t.length()) return false;
        //创建26个0的数组,作为一个哈希表，昵称为alphabet-字母表
        int[] alphabet = new int[26];
        //遍历单词a和单词b，再对哈希表（26位的0数组）进行相应的+-操作；
        for(int i = 0; i < s.length();i++){
            //s的单词的第i位字母减去字母'a'得出相对位置，如"a"-'a'=0,"h"-a =7,再把alphabet的0数组的相对位置中的值+1，如果有多个该字母，就在该位置加多个1；
            alphabet[s.charAt(i) - 'a'] ++;
            //t的单词的第i位字母减去'a'得出相对位置，再把alphabet的相应位置的值-1，有多个相应字母，相当于多次-1.
            alphabet[t.charAt(i) - 'a'] --;
        }
        //s对alphabet的+的操作，刚好和t的-的操作抵消。两个单词遍历下来，若能完全抵消，使得alphabet变回26个0，则证明两个单词都有同样数量的同样字母，返回true
        for(int i = 0; i < 26;i++){
            //若alphabet里面哪个值没有变成0，证明s和t的字母种类和数量不一样，就不符合anagram的要求了
            if (alphabet[i] != 0) return false;
        }
        return true;
    }

    public static boolean isAnagram_order(String s, String t){
        //如果字母个数不一样，肯定不是异位词
        if (s.length()!=t.length()) return false;
        //把string转换成为char[] 字符
        char[] str_s = s.toCharArray();
        char[] str_t = t.toCharArray();
        //s，t的字符按字母大小排序
        Arrays.sort(str_s);
        Arrays.sort(str_t);
        //排序后如果一样，那就是异位词，反之则不成立。
        if (Arrays.equals(str_s,str_t)) return true;
        else return false;

    }
    public static void main(String[] args) {
        String s1 = "abcdefgab";
        String t1 = "bagfedcab";
        boolean res = isAnagram_hash(s1,t1);
        boolean res2 = isAnagram_order(s1,t1);
        System.out.println(res);
        System.out.println(res2);
    }
}