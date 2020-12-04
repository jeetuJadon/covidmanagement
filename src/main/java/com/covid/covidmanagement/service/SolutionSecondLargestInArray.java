package com.covid.covidmanagement.service;

import java.util.HashMap;
import java.util.Map;

class Solution {


	private static int solve(String s) {
		int cnt = 0;
		for(char c : s.toCharArray()){
			cnt += c == 'a' ? 1 : 0;
		}
		if(cnt %3 != 0)
			return 0;
		int res = 0, k = cnt/3, sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			sum += s.charAt(i) == 'a' ? 1 : 0;
			if(sum == 2*k && map.containsKey(k) && i < s.length() - 1 && i > 0) {
				res += map.get(k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return res;
	}

	public static int solution(String S) {
		// write your code in Java SE 8
		Integer totalCount = 0;
		Map<Integer, Integer> tmpMap = new HashMap<>();
		for(char c : S.toCharArray()){
			if(c=='a')
				totalCount++;
		}
		if(totalCount %3 != 0)
			return 0;
		Integer partsLength = totalCount/3;
		Integer addition = 0, result = 0;

		for(int i=0;i<S.length();i++) {
			if(S.charAt(i)=='a') {
				addition++;
			}
			if(i < S.length() - 1 && i > 0 &&
					addition == 2*partsLength &&
					tmpMap.containsKey(partsLength)  ) {
				result =result + tmpMap.get(partsLength);
			}
			if(tmpMap.containsKey(addition))
				tmpMap.put(addition,tmpMap.get(addition)+1);
			else
				tmpMap.put(addition,1);

		}
		return result;
	}
	public  static void  main (String args[]){

		System.out.println( solution("abbbaa"));


	}
}