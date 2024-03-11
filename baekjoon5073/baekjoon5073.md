# [ 백준 ] #5073 : 삼각형과 세 변 - JAVA
## 문제
[*문제링크](https://www.acmicpc.net/problem/5073)

![img](https://github.com/saranghein/BaekJoon/assets/98319061/d6c14204-95d1-4202-818a-faeb0b73a696)

+ 세 변의 길이가 모두 같은 경우 -> Equilateral
+ 두 변의 길이만 같은 경우 -> Isosceles
+ 세 변의 길이가 모두 다른 경우 -> Scalene
+ 삼각형의 조건을 만족하지 못하는 경우 -> Invalid 

+ 입력 : 양의 정수 3개
+ 출력 : Equilateral, Isosceles, Scalene, Invalid 중 맞는 결과 출력

## 풀이
+ while 문과 if 조건문을 사용해 해결하도록 한다. 
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] list =new int[3];
        while (true){
            StringTokenizer st=new StringTokenizer(br.readLine(), " ");
            list[0]=Integer.parseInt(st.nextToken());
            list[1]=Integer.parseInt(st.nextToken());
            list[2]=Integer.parseInt(st.nextToken());
            if(list[0]==0&&list[1]==0&&list[2]==0)break;
            Arrays.sort(list);
            String result= check(list);
            System.out.println(result);

        }
    }
    public static String check(int[]list){

        int a=list[0];
        int b=list[1];
        int c=list[2];

        if(!(c<b+a))return "Invalid";
        else if(a==b && b==c)return "Equilateral";
        else if(a==b || b==c || c==a)return "Isosceles";
        else return "Scalene";
    }
}
```

## 고찰
+ array를 정렬할 때는 Arrrays.sort()함수를 사용하도록 한다.