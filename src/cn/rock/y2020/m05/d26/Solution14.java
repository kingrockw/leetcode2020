package cn.rock.y2020.m05.d26;

import cn.rock.y2020.m05.d25.Solution9;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 *
 * @author wjl48511
 * @create 2020/5/26-19:59
 **/
public class Solution14 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。

     示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     说明:

     所有输入只包含小写字母 a-z 。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/longest-common-prefix
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0 || strs[0] == null || "".equals(strs[0])){
            return "";
        }
        int i = 1;
        String preResult = strs[0].substring(0,1);
        String afterResult = "";
        while (true){
            for (String s : strs){
                if (!s.startsWith(preResult)){
                    return afterResult;
                }
            }
            afterResult = preResult;
            if (i< strs[0].length()){
                preResult = strs[0].substring(0,++i);
            }
            if (strs[0].equals(afterResult)){
                return strs[0];
            }


        }
    }
    public static void main(String []args){
        Solution14 solution14 = new Solution14();
        solution14.longestCommonPrefix(new String[]{"a"});
    }
}
