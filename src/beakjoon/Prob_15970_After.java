package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob_15970_After {
    private static class FastReader {
        BufferedReader bf;
        StringTokenizer st;

        FastReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            try {
                while (st == null || !st.hasMoreElements()) {
                    st = new StringTokenizer(bf.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static int N, total;
    static ArrayList<Integer>[] points;

    static void input() {
        int x, color;
        FastReader scan = new FastReader();
        N = scan.nextInt();
        points = new ArrayList[N];
        for (int i = 0; i < N; i++) points[i] = new ArrayList<Integer>(N);
        for (int i = 0; i < N; i++) {
            x = scan.nextInt();
            color = scan.nextInt() - 1;
            points[color].add(x);
        }
    }

    static int toRight(ArrayList<Integer> arr, int i) {
        return arr.get(i + 1) - arr.get(i);
    }

    static int toLeft(ArrayList<Integer> arr, int i) {
        return arr.get(i) - arr.get(i - 1);
    }

    static void solve() {
        for (ArrayList<Integer> li : points) {
            Collections.sort(li);
            for (int i = 0; i < li.size(); i++) {
                if (i == 0) total += toRight(li, i);
                else if (i == li.size() - 1) total += toLeft(li, i);
                else {
                    total += Math.min(toRight(li, i), toLeft(li, i));
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(total);
    }
}
