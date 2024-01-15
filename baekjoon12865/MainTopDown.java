package baekjoon12865;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//Fraction Knapsack: Greedy
//0/1 Knapsack: DP => DP방법을 사용
/*
N개의 물건
W 무게, K 최대 무게
V 가치
 */
//<1> Top-down
public class MainTopDown {
    static Integer[][]dp;
    static int[]W;
    static int[]V;
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        W=new int[N];
        V=new int[N];
        dp=new Integer[N][K+1];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            W[i]=Integer.parseInt(st.nextToken());
            V[i]=Integer.parseInt(st.nextToken());
        }
        System.out.println(knapsack(N-1,K));
    }
    static int knapsack(int i,int k){
        if(i<0)return 0;
        if(dp[i][k]==null){
            if(W[i]>k){
                dp[i][k]=knapsack(i-1,k);
            }
            else{
                dp[i][k]=Math.max(knapsack(i-1,k),knapsack(i-1,k-W[i])+V[i]);
            }
        }
        return dp[i][k];
    }

}
