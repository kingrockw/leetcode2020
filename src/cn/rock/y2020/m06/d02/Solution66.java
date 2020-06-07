package cn.rock.y2020.m06.d02;

import java.util.Arrays;

public class Solution66 {
    /*
    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i>-1 ;i--){
            if (digits[i]+1>9){
                digits[i] = 0;
                if (i == 0){
                     int[] r = new int[digits.length+1];
                     r[0] = 1;
                    System.arraycopy(digits, 0, r, 1,
                            Math.min(digits.length, r.length));
                    return r;
                }
            }else {
                digits[i] = digits[i] +1;
                return digits;
            }
        }
        return digits;
    }
}
