# [ 백준 ] #2292 : 벌집 - JAVA
## 문제
[*문제링크](https://www.acmicpc.net/problem/2292)

![img](https://github.com/saranghein/BaekJoon/assets/98319061/2dd60b0d-0ac9-46f4-bc80-6f1effa56ebb)


## 풀이

| N     | 지나는 방의 최소  개수(count) | 증가된 방 번호 수   |
|-------|----------------------|--------------|
| 1     | 1                    |              |
| 2~7   | 2                    | +6           |
| 8~19  | 3                    | +12          |
| 20~37 | 4                    | +18          |
| 38~61 | 5                    | +24          |
| ...   | ...                  | ...          |


+ 즉, 같은 최소 개수를 가지는 방의 범위(range)은 `6*count`씩 늘어난다. 

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine(), " ");
        int N=Integer.parseInt(st.nextToken());
        int count=1;//거리
        int range=2;//범위
        if(N==1)System.out.println(1);
        else{
            while(range <= N){//범위 보다 작으면
                range+=6*count;//범위 늘리기 
                count++;//거리 늘리기
            }
            System.out.println(count);
        }

    }
}
```

## 고찰
+ 범위가 6씩 늘어나는 점을 찾아내야 한다. 
+ 1일 때는 따로 처리하고 N이 2일때 조건 부터 처리하도록 한다. 