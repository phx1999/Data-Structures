import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        InputReader in = new InputReader(System.in);
        int T = in.nextInt();
        for (int o = 0; o < T; o++) {
            int n = in.nextInt();
            int m = in.nextInt();
            Node[] matrix = new Node[n + 1];
            for (int p = 1; p < n + 1; p++) {
                matrix[p] = new Node();
                matrix[p].key = p;
                matrix[p].son = new ArrayList<Node>();
                matrix[p].len = new ArrayList<Long>();
            }
            for (int p = 0; p < m; p++) {
                int x = in.nextInt();
                int y = in.nextInt();
                long mid = in.nextLong();
                if (x != y) {
                    matrix[x].son.add(matrix[y]);
                    matrix[y].father++;
                    matrix[x].len.add(mid);
                }
            }
            long[] max = new long[n + 1];
            Queue<Node> queue = new LinkedList<Node>();
            for (int q = 1; q < n + 1; q++) {
                if (matrix[q].father == 0) {
                    queue.add(matrix[q]);

                }
            }
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
//				for(int k=0;k<temp.son.size();k++)
//				{
//					Long length=temp.len.get(k);
//					if(max[temp.son.get(k).key]<length+max[temp.key])
//					{
//						max[temp.son.get(k).key]=length+max[temp.key];
//					}
//
//
//				}
                for (int z = 0; z < temp.son.size(); z++) {
                    temp.son.get(z).father--;

                }
                for (int z = 0; z < temp.son.size(); z++) {
                    if (temp.son.get(z).father == 0) {
                        queue.add(temp.son.get(z));
                    }
                    long length = temp.len.get(z);
                    if (max[temp.son.get(z).key] <= length + max[temp.key]) {
                        max[temp.son.get(z).key] = length + max[temp.key];
                    }
                }
            }
            long ans = 0;
            for (int w = 1; w < n + 1; w++) {
                if (max[w] >= ans)
                    ans = max[w];
            }
            System.out.println(ans);

        }
    }

    static class Node {
        int key;
        ArrayList<Long> len;
        int visit = 0;
        int father = 0;
        ArrayList<Node> son;
    }
}
