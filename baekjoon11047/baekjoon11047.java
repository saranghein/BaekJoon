package baekjoon11047;

import  java.io.BufferedReader;
import  java.io.InputStreamReader;
import  java.io.IOException;
import java.util.StringTokenizer;
public class baekjoon11047 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int[] coin=new int[N];

        for(int i=0;i<N;i++){
            coin[i]=Integer.parseInt(br.readLine());
        }
        int count=0;

        for(int i=N-1;i>=0;i--){
            if(coin[i]<=K){
                count+=(K/coin[i]);
                K=K%coin[i];//나머지
            }
        }
        System.out.println(count);
    }

}
