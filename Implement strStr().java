/*
描述
对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。

您在真实的面试中是否遇到过这个题？  
说明
在面试中我是否需要实现KMP算法？

不需要，当这种问题出现在面试中时，面试官很可能只是想要测试一下你的基础应用能力。当然你需要先跟面试官确认清楚要怎么实现这个题。
样例
如果 source = "source" 和 target = "target"，返回 -1。

如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。

挑战
O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）
*/
class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        int i=0;
        int j=0;
        if(source==null||target==null)
            return -1;
        while(i<source.length()&&j<target.length()){
            if(source.charAt(i)!=target.charAt(j)){
                if(source.charAt(i)==target.charAt(0))
                    j=1;
                else
                    j=0;
                i++;
                
            }else{
                i++;
                j++;
            }
        }
        if(j==target.length())
            return i-j;
        return -1;
    }
}