package baekjoon1783;

import java.io.BufferedReader;
import  java.io.InputStreamReader;
import  java.io.IOException;
import  java.util.StringTokenizer;

public class baekjoon1783 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());//세로길이
        int M=Integer.parseInt(st.nextToken());//가로길이
/*
	1) 2칸 위로, 1칸 오른쪽
	2) 1칸 위로, 2칸 오른쪽
	3) 1칸 아래로, 2칸 오른쪽
	4) 2칸 아래로, 1칸 오른쪽
*/
        int result=0;
        if(N==1)result=1;
        if(N==2)result=Math.min(4,(M+1)/2);
        if(N>=3){
            if(M>=7)result=M-2;
            else result=Math.min(4,M);
        }
        System.out.println(result);
    }

}
