# [ 백준 ] #23971 : ZOAC 4 - JAVA
## 문제
[*문제링크](https://www.acmicpc.net/problem/23971)

![img](https://github.com/saranghein/BaekJoon/assets/98319061/89a8e805-34cd-4bec-ad9e-18e4bb59f255)

+ H 행 W 열 
+ 세로로 N 칸 또는 가로로 M칸 이상 비우고 앉아야함 
  + 다른 모든 참가자와 세로줄 차가 N보다 크거나 가로준 차가 M보다 큰 곳에만
+ 입력 : H W N M
+ 출력 : 최대 몇 명 수용? 

## 풀이
+ 최대로 수용하기 위해서는 나란히 앉아야 한다. 
  + 즉, `(가로 앉은 인원 수) * (세로 앉은 인원 수)`를 구하면 된다. 
+ 앉고 나서 N, M 만큼 띄어 앉으므로 N+1, M+1칸에 다음 사람이 앉을 수 있다.
+ `가로 앉은 인원수 = H/(N+1)` 
  + 이때 정수가 나오게 하기 위해 내림을 적용하여 `(int)ceil(H/(N+1))`
+ `세로 앉은 인원수 = W/(M+1)`
  + 세로도 내림을 적용하여 `(int)ceil(W/(M+1))`

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.ceil;

public class Main {
  static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException {
    StringTokenizer st=new StringTokenizer(br.readLine(), " ");

    double H=Double.parseDouble(st.nextToken());
    double W=Double.parseDouble(st.nextToken());

    double N=Double.parseDouble(st.nextToken());
    double M=Double.parseDouble(st.nextToken());

    //한 자리를 않고 N, M 만큼 자리를 띄움
    int height=(int)ceil(H/(N+1));
    int width=(int)ceil(W/(M+1));
    System.out.println(height*width);
  }
}
```