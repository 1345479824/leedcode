package algorithm;


import java.util.Arrays;

public class KMP {
    public void profix(char pattern[], int profix[]){
        profix[0] = 0;
        int i = 1;
        int len = 0;
        while (i < pattern.length) {
            if (pattern[len] == pattern[i]){
                len++;
                profix[i] = len;
                i++;
            }else{
                if (len > 0){ //如果没找到相等的就一直循环找下去，len等于0的时候，说明没找到，这时候profix[i]=0
                    len = profix[len - 1];
                }else{
                    profix[i] = 0;
                    i++;
                }
            }
        }
    }

    public void remove(int profix[]){
        for (int i = profix.length - 1; i > 0; i--){
            profix[i] = profix[i - 1];
        }
        profix[0] = -1;
    }
    public void search(char text[], char pattern[], int profix[]){
        int i = 0, j = 0; //i:text  j：pattern
        int textLen = text.length;
        int patternLen = pattern.length;
        while (i < textLen) {
            if (j == patternLen - 1 && text[i] == pattern[j]){
                System.out.println("第一个匹配的位置是-->" + (i - j));
            }
            if (text[i] == pattern[j]) {
                i++; j++;
            }else{
                j = profix[j];
                if (j == -1){
                    i++; j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        char[] pattern = new char[]{'a','b','a','b','c','a','b','a','a'};
        char[] text =    new char[]{'a','a'};
        int[] profix = new int[pattern.length];
        kmp.profix(pattern, profix);
        System.out.println(Arrays.toString(profix));
        kmp.remove(profix);
        kmp.search(text, pattern, profix);
    }
}
