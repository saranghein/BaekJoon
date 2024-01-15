# [ 백준 ] #12865 : 평범한 배낭  - JAVA
## 문제
[*문제링크](https://www.acmicpc.net/problem/12865)

![img](https://github.com/saranghein/saranghein/assets/98319061/4db1de51-c27b-471a-82c2-462423218e5e)

+ 총 N개의 물건
+ 각 물건은 무게 W, 가치 V
+ 최대 K만큼의 무게
## 풀이
+ Fraction Knapsack은 Greedy방법으로 , 0/1 Knapsack은 DP방법으로 진행하는데 해당 문제는 Fraction할 수 없으므로 DP방법으로 진행한다. 
+ 총 3가지 방법으로 풀이하였다. (TopDown, BottomUp-2차원배열, BottomUp-1차원 배열)
### 1. Top Down 
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
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
```
### 2. Bottom Up - 2차원 배열 
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N + 1]; 
        int[] V = new int[N + 1]; 
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                
                if(W[i] > j) { //무게 초과
                    dp[i][j] = dp[i - 1][j];
                }
                else {//더 담을 수 있을 때
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
```
### 3. Bottom Up - 1차원 배열
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1]; // 가치
        int[] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {

            // K부터 탐색하여 담을 수 있는 무게 한계치가 넘지 않을 때까지 반복
            for (int j = K; j - W[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }
        System.out.println(dp[K]);
    }
}
```
## 알고리즘 분류
+ 다이나믹 프로그래밍
+ 배낭문제


## 고찰
오랜만에 알고리즘을 공부하기에 풀이과정을 참고하여 풀이하였다 ( [*참고 링크](https://st-lab.tistory.com/141) ).
계속 연습하여 스스로 바로 해결하였으면 좋겠다. 배낭문제에 관해서는 추후 게시물로 정리 예정이다. 

