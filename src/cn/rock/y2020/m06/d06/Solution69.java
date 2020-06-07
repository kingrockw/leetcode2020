package cn.rock.y2020.m06.d06;

public class Solution69 {
    transient int a = 1;
    public int mySqrt(int x) {
        double sqrt = Math.sqrt(x);
        return (int)Math.floor(sqrt);
    }
}
