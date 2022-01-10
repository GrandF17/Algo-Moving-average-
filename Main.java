import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N >= 1 && N <= 10000) {
            int[] Arr = new int[N];

            Scanner stringScanner = new Scanner(System.in);
            StringBuilder str = new StringBuilder(stringScanner.nextLine());
            String[] subStr = str.toString().split(" ");
            for(int i = 0; i < Arr.length; i++) {
                Arr[i] = Integer.parseInt(subStr[i]);
            }

            int K = scanner.nextInt();

            //-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
            if(K >= 1 && K <= N) {
                double[] ArrNew = new double[Arr.length - K + 1];

                //first step
                ArrNew[0] = 0;
                for(int j = 0; j < K; j++) {
                    ArrNew[0] += Arr[j];
                }
                double currentSum = ArrNew[0];
                ArrNew[0] /= K;

                //other steps
                for(int i = K; i < Arr.length; i++) {
                    ArrNew[i - K + 1] = currentSum + Arr[i] - Arr[i - K];
                    currentSum = ArrNew[i - K + 1];
                    ArrNew[i - K + 1] /= K;
                }

                str = new StringBuilder("");
                for(int i = 0; i < ArrNew.length; i++) {
                    str.append(ArrNew[i]).append(" ");
                }
                System.out.println(str);
            }
        }
    }
}