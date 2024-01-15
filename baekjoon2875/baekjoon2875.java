package baekjoon2875;

import java.io.BufferedReader;
import  java.io.InputStreamReader;
import  java.io.IOException;
import  java.util.StringTokenizer;
public class baekjoon2875 {
    public static void main(String []args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int count=0;

        while(N>=2&&M>=1 &&M+N>=3+K){
            N-=2;
            M-=1;
            count++;
        }
        System.out.println(count);
    }

}
