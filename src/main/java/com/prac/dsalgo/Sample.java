package com.prac.dsalgo;

public class Sample {

	public static void main(String[] args) {
		//["2 03726945 0 4","0af admbife w q","bp nvmedogf dxn","a qtdnisj eznls","4k rswcdmprf x","5e tpoixwmfrszu","4kq ycgbw pmgp","ygm zfobjy cwsx","9 37505078 053","6 581295212437","c 918054182 688","p6 1043538731 5","b 5443051 7122","o5 2090115 436","2fw 7596601 71"]
		String s = "ttzoz 035658365825 9";
		String log = s.substring(s.indexOf(" ") + 1, s.length());
        /*if(log.indexOf(" ") != -1) {
            log = log.substring(0, log.indexOf(" "));
        }*/
		System.out.println(log.charAt(0) - '0');
	}

}
