package baekjoon5073;

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
