package Test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class SWEA_1225_D3_암호생성기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
          
        for (int t = 1; t <= 10; t++) {
            sc.nextInt();
            for (int i = 0; i < 8; i++) { // 배열 입력
            	que.offer(sc.nextInt());
            }
             
            int cnt = 1; // 뺄 값 
            while (true) {
                int val = que.poll(); // 앞에서 뱀
                val -= cnt++;
                if (val <= 0) {
                    que.offer(0);
                    break;
                }
                que.offer(val);
                if (cnt >= 6) cnt = 1;
            }
             
            System.out.print("#" + t + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(que.poll() + " ");
            }
            System.out.println();
            que.clear();
        }
    }
}
