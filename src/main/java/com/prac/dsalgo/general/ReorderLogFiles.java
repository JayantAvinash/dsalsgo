package com.prac.dsalgo.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/reorder-log-files/
public class ReorderLogFiles {
	
	public String[] reorderLogFiles(String[] logs) {
        String[] orderedLogs = new String[logs.length];
        Comparator<LetterLog> comparator = new Comparator<LetterLog>() {
            
            public int compare(LetterLog l1, LetterLog l2) {
                int val = l1.log.compareTo(l2.log);
                if(val == 0) {
                    val = l1.identifier.compareTo(l2.identifier);
                }
                return val;
            }
        };
        PriorityQueue<LetterLog> letterLogs = new PriorityQueue<LetterLog>(comparator);
        int i = logs.length - 1;
        for(int  j = logs.length - 1; j >= 0; j--) {
            if(isNumberLog(logs[j])) {
                orderedLogs[i] = logs[j];
                i--;
            } else {
                letterLogs.offer(getLetterLog(logs[j]));
            }
        }
        i = 0;
        while(!letterLogs.isEmpty()) {
            LetterLog l = letterLogs.poll();
            orderedLogs[i] = l.identifier + " " + l.log;
            i++;
        }
        return orderedLogs;
    }
    
    public boolean isNumberLog(String s) {
        String log = s.substring(s.indexOf(" ") + 1, s.length());
        
        if(log.charAt(0) - '0' < 10) {
            return true;
        }
        return false;
    }
    
    public LetterLog getLetterLog(String s) {
        int  i = s.indexOf(" ");
        return new LetterLog(s.substring(0, i), s.substring(i + 1, s.length()));
    }
    
    class LetterLog {
        String identifier;
        String log;
        LetterLog(String identifier, String log) {
            this.identifier = identifier;
            this.log = log;
        }
    }
    
    public String[] reorderLogFilesv1(String[] logs) {
    	Arrays.sort(logs, (l1, l2) -> {
    		String[] l1Arr = l1.split(" ");
    		String[] l2Arr = l2.split(" ");
    		boolean isDigit1 = Character.isDigit(l1Arr[1].charAt(0));
    		boolean isDigit2 = Character.isDigit(l2Arr[1].charAt(0));
    		if(!isDigit1 && !isDigit2) {
    			int cmp = l1.substring(l1.indexOf(" "), l1.length()).compareTo(l2.substring(l2.indexOf(" "), l2.length()));
    			if(cmp == 0) {
    				cmp = l1Arr[0].compareTo(l2Arr[0]);
    			}
    			return cmp;
    		}
    		return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
    	});
    	return logs;
    }

	public static void main(String[] args) {
		String[] s = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		ReorderLogFiles rlf = new ReorderLogFiles();
		String[] orderedLogs = rlf.reorderLogFilesv1(s);
		for(int i = 0; i < orderedLogs.length; i++) {
			System.out.print(orderedLogs[i] + ", ");
		}
		
	}

}
