package dev.codefoundry.queue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class QueriesFixedLength {
	static int[] solve(int[] arr, int[] queries) {
		int[] result = new int[queries.length];
		int m = 0;
		for (int qry : queries) {
			Deque<Integer> q = new LinkedList<Integer>();
			int i = 0;
			for (; i < qry; ++i) {
				while(!q.isEmpty() && arr[i] >= arr[q.peekLast()]) q.removeLast();
				
				q.addLast(i);
			}
			
			int min = arr[q.peekLast()];
			
			for (; i < arr.length; ++i) {
				
				if (arr[q.peek()] < min) {
					min = arr[q.peek()];
				}
				
				while(!q.isEmpty() && q.peek() < i - qry) {
					q.removeFirst();
				}
				
				while(!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
					q.removeLast();
				}
				
				q.addLast(i);
			}
			
			if (arr[q.peek()] < min) min = arr[q.peek()];
			
			result[m++] = min;
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/gmazra/Documents/r.txt"));

		String[] nq = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nq[0]);

		int q = Integer.parseInt(nq[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int arrItr = 0; arrItr < n; arrItr++) {
			int arrItem = Integer.parseInt(arrItems[arrItr]);
			arr[arrItr] = arrItem;
		}

		int[] queries = new int[q];

		for (int queriesItr = 0; queriesItr < q; queriesItr++) {
			int queriesItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			queries[queriesItr] = queriesItem;
		}

		int[] result = solve(arr, queries);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bufferedWriter.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}
