package baekjoon10610;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class baekjoon10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        //1. 값이 1로 끝나야함
        //2. 모든 자리 수에 있는 값의 합이 3의 배수여야함
        List<Integer>list=new ArrayList<>();
        int sum=0;

        for(int i=0;i<n.length();i++){
            sum+=n.charAt(i)-'0';
            list.add(n.charAt(i)-'0');
        }
        Collections.sort(list);
        if(list.get(0)==0&&sum%3==0){//30배수가 맞다면
            for(int i=list.size()-1;i>=0;i--)//출력
                System.out.print(list.get(i));
        }
        else
            System.out.println(-1);
    }
}
