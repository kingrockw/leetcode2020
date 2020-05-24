package cn.rock.y2020.m05.d24;

public class Solution7 {
    public  static int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return 0;
        }
        boolean flag = false;
        String s = "";
        if (x < 0){
            flag = true;
            s = String.valueOf(-x);
        }else {
            s = String.valueOf(x);
        }

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        while (sb.length()> 0 && sb.charAt(0) == '0'){
            sb = sb.deleteCharAt(0);
        }
        if (flag && sb.length()> 0){
            sb.insert(0,'-');
        }
        try {
            return Integer.valueOf(sb.toString());
        }catch (Exception e){
            return  0;
        }
    }

    public  static int reverse1(int x) {
        long result = 0;
        while(x != 0){
            int n = x%10;
            x = x/10;
            result = result*10 + n;
            if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
                return 0;
            }
        }

        return (int)result;
    }
    public static void main(String[] args) {
        int reverse = reverse1(1534236469);
        System.out.println(reverse);
    }
}
