package baekjoon11723;
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