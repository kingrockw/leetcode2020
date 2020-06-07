package cn.rock.y2020.m06.d07;

import java.util.Stack;

public class Solution150 {

    /*
    根据逆波兰表示法，求表达式的值。

有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

说明：

整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
示例 1：

输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: ((2 + 1) * 3) = 9
示例 2：

输入: ["4", "13", "5", "/", "+"]
输出: 6
解释: (4 + (13 / 5)) = 6
示例 3：

输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
输出: 22
解释:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String token: tokens){
            switch (token){
                case "+" : {
                    Integer pop1 = stack.pop();
                    Integer pop2 = stack.pop();
                    stack.push(pop2+pop1);
                    break;
                }
                case "-" :{
                    Integer pop1 = stack.pop();
                    Integer pop2 = stack.pop();
                    stack.push(pop2 - pop1);
                    break;
                }
                case "*" :{
                    Integer pop1 = stack.pop();
                    Integer pop2 = stack.pop();
                    stack.push(pop2 * pop1);
                    break;
                }
                case "/" :{
                    Integer pop1 = stack.pop();
                    Integer pop2 = stack.pop();
                    stack.push(pop2/pop1);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
            }

        }
       return  stack.pop();
    }

    public static String convert(String input){
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i=0 ;i<input.length();i++){
            char c = input.charAt(i);
            switch (c){
                case '(':{
                    stack.push(c);
                    break;
                }
                case ')':{
                    while (!stack.empty()){
                        Character pop = stack.pop();
                        if (pop ==  '('){
                            break;
                        }else {
                            sb.append(pop);
                        }
                    }
                    break;
                }
                case '-':
                case '+':{
                    while (!stack.empty()){
                        Character peek = stack.peek();
                        if (peek == '('){
                            break;
                        }
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                }
                case '*':{
                    stack.push(c);
                    break;
                }
                case '/':{
                    stack.push(c);
                    break;
                }
                default:{
                    sb.append(c);
                }
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
//        System.out.println(evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(convert("9+(3-1)*3+10/2"));
        String s = "";
    }
}
