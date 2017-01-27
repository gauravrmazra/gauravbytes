package com.gauravbytes.sort;

import java.util.Stack;

public class TopologicalSort {
	int[] topologicalSort(int[][] graph) {
		int[] sortedResult = new int[graph.length];
		int[] inDegree = new int[graph.length];
		for (int i = 0; i < inDegree.length; i++) {
			inDegree[i] = 0;
		}
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length && graph[i][j] != -1; j++) {
				inDegree[graph[i][j]]++;

			}
		}
		Stack<Integer> next = new Stack<Integer>();
		for (int i = 0; i < graph.length; i++) {
			if (inDegree[i] == 0) {
				next.push(i);
			}
		}
		int resultIndex = 0;
		while (!next.isEmpty()) {
			int i = next.pop();
			sortedResult[resultIndex] = i;
			resultIndex++;
			for (int j = 0; j < graph[i].length && graph[i][j] != -1; j++) {
				inDegree[graph[i][j]]--;
				if (inDegree[graph[i][j]] == 0) {
					next.push(graph[i][j]);
				}
			}

		}

		return sortedResult;
	}

	public static void main(String args[]) {
		TopologicalSort sort = new TopologicalSort();
		int[][] adjacencies = { { 2 }, { 3 }, { 3, 4 }, { 5 }, { 5 }, { 6, 10 }, { 7 },
		    { 12 }, { 9 }, { 10 }, { 11 }, { 12 }, { 13 }, { -1 } };
		System.out.println("Sort Results");
		int[] result = sort.topologicalSort(adjacencies);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "->");

		}
	}

}
