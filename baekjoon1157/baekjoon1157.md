# [ 백준 ] #1157 : 단어공부 - JAVA
## 문제
[*문제링크](https://www.acmicpc.net/problem/1157)

![img](https://github.com/saranghein/BaekJoon/assets/98319061/2e9dd4f3-5970-4abc-a373-fefcd7e1ab71)

+ 대소문자 구별하지 않고 대문자로 풀이한다.
+ 가장 많이 사용된 알파벳이 여러 개라면 "?"를 출력한다. 

## 풀이
+ Map을 사용하여 "Key : 알파벳, Value : 사용된 횟수" 로 저장해 풀이하였다. 
+ `Comparator`를 사용하여 사용된 횟수를 오름차 순으로 정렬하였다. 

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[]args)throws IOException {
        StringTokenizer st=new StringTokenizer(br.readLine(),"");
        String str=st.nextToken();
        ArrayList<String>list=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            list.add(Character.toString(str.charAt(i)).toUpperCase());
        }
        Map<String, Integer>table=new HashMap<>();
        for(String i: list){
            if(table.containsKey(i)){//key 값이 있다면
                table.replace(i,table.get(i),table.get(i)+1);
            }
            else {//key 값이 없다면 추가
                table.put(i,1);
            }
        }
        List<String> keySet = new ArrayList<>(table.keySet());
        // Value 값으로 오름차순 정렬
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return table.get(o1).compareTo(table.get(o2));
            }
        });
        //keySet.sort((o1, o2) -> table.get(o1).compareTo(table.get(o2)));
        String result= keySet.get(keySet.size()-1);//가장 큰 값을 갖는 알파벳
        if(keySet.size()>=2&& table.get(keySet.get(keySet.size()-2)).equals(table.get(result))){
            System.out.println("?");
        }
        else{
            System.out.println(result);
        }
    }
}
```

## 고찰
+ Map을 사용하는 것 까지는 도출할 수 있었으나 정렬하는 부분에서 어려움이 있었다. 
+ sort()메서드에서 compareTo()메서드를 오버라이딩하여 Value값들을 비교해 정렬하도록 구현하였다. 