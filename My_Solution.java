package misc;

import java.util.HashMap;

public class main_misc {
	//private static long[][] cache = new long[999][999];//
    //private static String[] cache = new String[999]; 
	//private static HashMap<String,Integer> cache = new HashMap<>();
	
	public static void main(String[] args) {
		
		//
	int[] v = {100,90,90,80,75,60};
	int[] u = {50,65,77,90,102};
	int[] l = climbing(v,u);
	for(int i = 0;i < l.length;i++) {
		System.out.println(l[i]);
	}
    

		
	}
	private static int[] no_duplicates(int[]v) {
		//if i get the index of the rankings with no duplicates,i can just sum 1 to the index and i will have the current ranking
		//O(m)
		int j = 0;
		int last = v[0];
		int[] l = new int[v.length];
		for(int i = 0;i < v.length;i++) {
			if(v[i] == last && i != 0) {
				continue;
			}
			last = v[i];
			l[j] = last;
			j++;
		}
		return l;
	}
	private static int mod_bSearch(int[]v,int k) {
		//I want to find how many elements bigger(EQUAL DO NOT COUNT) than k exists in v
		//O(log(m))
		int h = 0;
		int l = v.length-1;
		
		int j = 0;
		while(l >= h) {
			if(k >= v[0]) {
				break;
			}
			if(v[(h+l)/2] < k) {
				j = 1 + (h+l)/2;
				l = (h+l)/2 - 1;
			}
			if(v[(h+l)/2] >= k) {
				j = ((h+l)/2) +1;
				h = (h+l)/2 +1;
				if(k == v[(h+l)/2]) {
					j--;
				}
			}
		}
		return j;
	}
	private static int[] climbing(int[]v,int[]u) {
		//m = v.length and n = u.length
		//O(m + nlog(m))
		//the ranking is:how many elements bigger than u[i] exists in v + 1
		v = no_duplicates(v);
		for(int i = 0;i < u.length;i++){
			u[i] = mod_bSearch(v,u[i]) + 1;
		}
		return u;
	}
	
	
	
	}
	


	
	

	
		
	
	


	

	
	

