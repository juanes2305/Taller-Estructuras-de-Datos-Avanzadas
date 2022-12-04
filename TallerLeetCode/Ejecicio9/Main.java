package Ejecicio9;


import java.util.*;
import java.io.*;
import java.math.*;
 
class Main{
    public static final int [] x8 = {0 , 1,1,1,0,-1,-1,-1};
    public static final int [] y8 = {-1,-1,0,1,1, 1, 0,-1};
    public static final int [] y4 = {0,1,0,-1};
    public static final int [] x4 = {1,0,-1,0};
    public static final int MOD = 1000000007;
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        PrintWriter output = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //st = new StringTokenizer(buff.readLine());
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ok = 0;
        if( a == 1 ){
            if(b == 10 || b == 2){
                ok = 1;
            }
        }
        else if( a == 10 ){
            if(b == 9 || b == 1){
                ok = 1;
            }
        }
        else{
            if(b == (a-1) || b == (a+1)){
                ok = 1;
            }
        }
        output.print(ok == 1 ?"Yes":"No");
        output.flush();
    }
}