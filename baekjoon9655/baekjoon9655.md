# [ 백준 ] #9655 : 돌 게임 - JAVA
## 문제
[*문제링크](https://www.acmicpc.net/problem/9655)

![img](https://github.com/saranghein/BaekJoon/assets/98319061/7ed85146-af8a-4381-983f-70c5bdcbe1e5)

+ 상근이가 먼저 시작
+ 번갈아 가며 1개 또는 3개의 돌을 가져 갈 수 있음
+ 마지막 돌을 가져 가는 사람이 승리

+ 입력 : N (돌 개수)
+ 출력 : 상근이 이기면 SK, 창영이 이기면 CY

## 풀이
+ DP 문제

|N| 승자   |
|---|------|
|1| 상근 승 |
|2| 창영 승 |
|3| 상근 승 |
|4|창영 승|
|5|상근이 처음에 1개 가져간 경우 : 상근 승<br>상근이 처음에 3개 가져간 경우 : 상근 승|

+ ```dp[n]```이 홀수면 -> 상근 승
+ ```dp[n]```이 짝수면 -> 창영 승

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());

        int []dp=new int[1001];//완벽하게 게임을 했을 때 이기는 사람배열
        dp[1]=1;//상근
        dp[2]=0;//창영
        dp[3]=1;//상근
        for(int i=4;i<=N;i++){
            dp[i]=Math.min(dp[i-1],dp[i-3])//직전게임에서 이기는 사람
                    +1;//현재 게임에서 이기는 사람
        }
        if(dp[N]%2==0){
            System.out.println("CY");
        }else System.out.println("SK");
    }
}

```


## 고찰
+ 다음과 같이 dp배열 초기화를 1,2,3로 할 때와 1,0,1으로 했을 때 메모리 사용량이 차이가 났다
  + 짝, 홀의 여부만 확인하므로 1,0,1로 하는 것이 메모리 사용량이 효율적이다. 
```java
//메모리 14304KB
dp[1]=1;
dp[2]=0;
dp[3]=1;

//메모리 14368KB
dp[1]=1;
dp[2]=2;
dp[3]=3;


```
![image](https://github.com/saranghein/BaekJoon/assets/98319061/81901183-018e-402b-a14b-d216f158d951)

## 알고리즘 분류
+ Dynamic Programming