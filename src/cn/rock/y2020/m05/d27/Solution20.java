package cn.rock.y2020.m05.d27;

import java.util.*;

/**
 *
 * @author wjl48511
 * @create 2020/5/27-17:03
 **/
public class Solution20 {
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。

        示例 1:

        输入: "()"
        输出: true
        示例 2:

        输入: "()[]{}"
        输出: true
        示例 3:

        输入: "(]"
        输出: false
        示例 4:

        输入: "([)]"
        输出: false
        示例 5:

        输入: "{[]}"
        输出: true
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/valid-parentheses
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class CharList {
        private int size = 0;
        private int capacity = 16;
        private char [] clist = new char[capacity];

        public void add(char c){
            if (size + 1 > capacity){
                //扩容
                capacity = 2* capacity;
                clist = Arrays.copyOf(clist, capacity);
            }
            clist[size++] = c;
        }

        public int size() {
            return size;
        }

        public char getLast() {
            if (size == 0){
                return '\u0000';
            }
            return clist[size-1];
        }

        public void removeLast(){
            if (size > 0){
                clist[size---1] = 0;
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }


    }

    public boolean isValid(String s) {
        int result = 0;
        if (null == s || "".equals(s)) {
            return true;
        }
        CharList charList = new CharList();
        char last;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    charList.add(c);
                    break;
                case ')':
                    last = charList.getLast();
                    if (last == '('){
                        charList.removeLast();
                    }else {
                        return false;
                    }
                    break;
                case ']':
                    last = charList.getLast();
                    if (last == '['){
                        charList.removeLast();
                    }else {
                        return false;
                    }
                    break;
                case '}':
                    last = charList.getLast();
                    if (last == '{'){
                        charList.removeLast();
                    }else {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return charList.size() == 0;
    }
    public static void main(String []args){
        Solution20 solution20 = new Solution20();
        boolean valid = solution20.isValid("]");
        System.out.println(valid);
    }
}
