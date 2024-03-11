# [ 백준 ] #11723 : 집합 - JAVA
## 문제
[*문제링크](https://www.acmicpc.net/problem/11723)

![img](https://github.com/saranghein/BaekJoon/assets/98319061/b24adc44-2894-496e-9bd7-f75a082a6c15)

## 풀이
+ 비트 마스크를 이용한다.
+ 비트가 '1'이면 '켜져있다', 비트가 '0'이면 '꺼져있다'라고 표현한다.

| 연산                      | 	사용 예시(0~9)                                                                                                     |
|-------------------------|-----------------------------------------------------------------------------------------------------------------|
| 공집합과 꽉 찬 집합 구하기         | 	A = 0; / A = (1 << 10) - 1;                                                                                    |
| 원소 추가	                  | A\|= (1 << k);                                                                                                  |
| 원소 삭제	                  | A &= ~(1 << k);                                                                                                 |
  | 원소의 포함 여부 확인            | 	if((A & (1 << k)) == (1 << k))                                                                                 |
  | 원소의 토글(toggle)          | 	A ^= (1 << k);                                                                                                 |
  | 두 집합에 대해서 연산	           | A\| B→ A와 B의 합집합 <br>A & B     → A와 B의 교집합<br>A & (~B) → A에서 B를 뺀 차집합<br>A ^ B     → A와 B중 하나에만 포함된 원소들의 집합<br> |
  | 집합의 크기 구하기              | 	int bitCount(int A){<br>if(A == 0) return 0;<br>return A%2 + bitCount(A / 2);<br>}                             |
| 최소 원소 찾기                | 	int first = A & (-A);                                                                                          |
| 최소 원소 지우기| 	A &= (A - 1);                                                                                                  |
|모든 부분 집합 순회하기	|for (int subset = A ; subset>0; subset = ((subset - 1) & A)){ }|

```java
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[]args)throws IOException {
        StringBuilder sb = new StringBuilder();
        int S = 0;//공집합
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("all")) S = (1 << 21) - 1;//0~20로 꽉 찬 집합
            else if(str.equals("empty")) S = 0;//공집합
            else {
                int num = Integer.parseInt(st.nextToken());
                if(str.equals("add"))
                    S |= (1 << num);//원소 추가
                else if(str.equals("remove"))
                    S &= ~(1 << num);//원소 제거
                    //1 << num 켜진상태
                    // ~(1 << num)꺼진상태
                    //S &= ~(1 << num) S집합의 num번째 상태 off
                else if(str.equals("check"))
                    sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                else if(str.equals("toggle"))
                    S ^= (1 << num);
            }
        }
        System.out.println(sb);
    }
}
```

## 고찰
+ 비트 마스크를 사용해서 수행시간을 줄이고 메모리를 적게 사용할 수 있었다.
+ 비트 마스크를 이용한 집합 연산을 할 수 있다는 점을 알 수 있었다. 