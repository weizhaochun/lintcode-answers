/*
给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数。

 注意事项
最后的结果可能很大，所以我们返回一个字符串来代替这个整数。

您在真实的面试中是否遇到过这个题？ 
样例
给出 [1, 20, 23, 4, 8]，返回组合最大的整数应为8423201。

挑战 
在 O(nlogn) 的时间复杂度内完成。

标签 
排序 Works Applications
*/
public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
       int n=num.length;
       sort(num,0,n-1);
       String res="";
       int i=n-1;
       while(i>=0){
           if(num[i]==0&&i!=0)
                i--;
            else
                break;
       }
       for(;i>=0;i--){
           res+=num[i];
       }
       return res;
    }
    void sort(int[] a,int lo,int hi){
        if(hi<=lo)
            return;
        int lt=lo,i=lo+1,gt=hi;
        int v=a[lo];
        while(i<=gt){
            if(isLarge(a[i],v)>0){
                int temp=a[i];
                a[i]=a[gt];
                a[gt]=temp;
                gt--;
            }
            else if(isLarge(a[i],v)<0){
                int temp=a[i];
                a[i]=a[lt];
                a[lt]=temp;
                lt++;
                i++;
            }
            else
                i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
    int isLarge(int a,int b){
        String s="";
        return (s+a+b).compareTo(s+b+a);
    }
}