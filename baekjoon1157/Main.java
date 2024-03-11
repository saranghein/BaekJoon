package baekjoon1157;

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
