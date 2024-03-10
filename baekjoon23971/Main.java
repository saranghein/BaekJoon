package baekjoon23971;
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
