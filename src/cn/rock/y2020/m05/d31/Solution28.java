package cn.rock.y2020.m05.d31;

public class Solution28 {
    /*
    实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int strStr(String haystack, String needle) {
        if(needle == null || "".equals(needle)){
            return 0;
        }
        if(haystack == null || "".equals(haystack)){
            return -1;
        }

//        int i = haystack.indexOf(needle);
        int needleLength = needle.length();
        int hayLength = haystack.length();
        for(int m = 0;m< hayLength;m++){
            char c = haystack.charAt(m);
            if (c == needle.charAt(0)){
                //匹配到第一个字母
                if (m + needleLength > hayLength){
                    return -1;
                }
                int j = m;
                boolean flag = true;
                for (int n = 1 ;n< needle.length();n++){
                    if (needle.charAt(n) == haystack.charAt(++j)){
                        continue;
                    }else {
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    return m;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        solution28.strStr("mississippi",
                "issip");
    }
}
