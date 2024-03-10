package baekjoon2292;

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
