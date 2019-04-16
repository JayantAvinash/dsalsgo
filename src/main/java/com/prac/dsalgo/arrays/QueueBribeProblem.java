package com.prac.dsalgo.arrays;

import java.util.Scanner;

public class QueueBribeProblem {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		int bribes = 0;
        for(int i = q.length - 1; i >= 0; i--) {
           if((q[i] - i) > 3) {
               System.out.println("Too chaotic");
               return;
           }
            for(int j = Math.max(0, q[i]-2); j < i; j++) {
                if(q[j] > q[i]) {
                    bribes++;
                }
            }
            //bribes += noOfSmallElements;
        } 
        System.out.println(bribes);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
			/*Sample Input
			2
			5
			2 1 5 3 4
			5
			2 5 1 3 4
			
			Sample Output

			3
			Too chaotic*/
		}

		scanner.close();
	}
}
