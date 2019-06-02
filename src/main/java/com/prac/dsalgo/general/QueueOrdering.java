package com.prac.dsalgo.general;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


// problem: https://docs.google.com/document/d/1I72ZTD9Hhf9cKxn0GLqxtnemOnDVH2QCHkIebd_vGG0/edit
public class QueueOrdering {
	
	public void getServingOrder(List<List<Integer>> queueItems) {
		Comparator<IndexValue> comparator = new Comparator<IndexValue>() {

			@Override
			public int compare(IndexValue o1, IndexValue o2) {
				return o1.value - o2.value;
			}
		};
		PriorityQueue<IndexValue> itemQueue = new PriorityQueue<>(queueItems.size(), comparator);
		for(int i = 0; i < queueItems.size(); i++) {
			IndexValue iv = new IndexValue(i, queueItems.get(i).get(0));
			itemQueue.offer(iv);
		}
		int []indexTracker = new int[queueItems.size()];
		
		while(!itemQueue.isEmpty()) {
			IndexValue current = itemQueue.poll();
			System.out.print(current.value + " ");
			indexTracker[current.index]++;
			if(queueItems.get(current.index).size() > indexTracker[current.index]) {
				int nextItem = queueItems.get(current.index).get(indexTracker[current.index]);
				itemQueue.offer(new IndexValue(current.index, nextItem));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int queues = sc.nextInt();
		List<List<Integer>> queueItems = new ArrayList<>(queues);
		for(int i = 0; i < queues; i++) {
			int queueSize =sc.nextInt();
			List<Integer> currentQueue = new ArrayList<>(queueSize);
			for(int j = 0; j < queueSize; j++) {
				int items = sc.nextInt();
				currentQueue.add(items);
			}
			queueItems.add(currentQueue);
		}
		sc.close();
		QueueOrdering qo = new QueueOrdering();
		qo.getServingOrder(queueItems);
		
	}
	
	
	
	class IndexValue {
		int index;
		int value;
		public IndexValue(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

}
