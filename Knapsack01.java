import java.util.Scanner;
 
public class Knapsack01
{
    public void knapsack(int[][]S, int W, int N)
    {
        int[][] m = new int[N + 1][W + 1];
        int[][] sol = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++)
        {
            for (int j = 0; j <= W; j++)
            {
                int m1 = m[i - 1][j];
                int m2 = 0;
                if (j >= S[0][i])
                    m2 = m[i - 1][j - S[0][i]] + S[1][i];
                m[i][j] = Math.max(m1, m2);
                if(m2 > m1)
                    sol[i][j]= 1;    
                else
                    sol[i][j]= 0;
            }
        }        
        int[] selected = new int[N + 1];
        for (int n = N, w = W; n > 0; n--)
        {
            if (sol[n][w] != 0)
            {
                selected[n] = 1;
                w = w - S[0][n];
            }
            else
                selected[n] = 0;
        }
        System.out.print("\nItems with weight ");
        for (int i = 1; i < N + 1; i++)
            if (selected[i] == 1)
                System.out.print(S[0][i] +" ");
        System.out.println("are selected by knapsack algorithm.");
    }
    
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        Knapsack01 ks = new Knapsack01();
 
        System.out.print("Enter number of elements: ");
        int n = scan.nextInt();
 
        int[][] S= new int [2][n+1];

        for (int i = 1; i <= n; i++){
            System.out.print("Enter weight for element "+ i +": ");
            S[0][i] = scan.nextInt();
            System.out.print("Enter value for element "+ i +": ");
            S[1][i] = scan.nextInt();
        }
        System.out.println("Enter Max weight");
        int W = scan.nextInt();
 
        ks.knapsack(S, W, n);
        scan.close();
    }
}