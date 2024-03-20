package baekjoon9655;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());

        int []dp=new int[1001];//완벽하게 게임을 했을 때 이기는 사람배열
        dp[1]=1;//상근
        dp[2]=0;//창영
        dp[3]=1;//상근
        for(int i=4;i<=N;i++){
            dp[i]=Math.min(dp[i-1],dp[i-3])//직전게임에서 이기는 사람
                    +1;//현재 게임에서 이기는 사람
        }
        if(dp[N]%2==0){
            System.out.println("CY");
        }else System.out.println("SK");
    }
}
