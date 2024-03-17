import java.util.*;
import java.util.HashMap;
public class test{
	public int bucket_create(int[] a, int n) {
		Map<Integer, Integer> mp = new HashMap<>();
		for(int i=0; i<n; i++) {
			if (mp.containsKey(a[i])) 
            {
                mp.put(a[i], mp.get(a[i]) + 1);
            } 
            else
            {
                mp.put(a[i], 1);
            }
		}
		int num=0;
		int bucket=0;
		while(num<n) {
			int keyMax = Collections.max(mp.entrySet(), Map.Entry.comparingByValue()).getKey();
	        int keyVal = mp.get(keyMax);
	        if(keyVal>=2) {
	        	int v = (keyVal)+(keyVal-1);
	        	bucket+=1;
	        	num+=v;
	        }
	        mp.put(keyMax, mp.get(keyMax) - 1);

		}
		if(num<n) {
			bucket+=(n-num);
		}
		return bucket;
	}
	public static void main(String args[]) {
		test Test = new test();
		int a[] = {1,1,1,1,1,1,2,2,2,2,2,2,4,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,3,3,3,10,10,10,11,11,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,20};
		int n = a.length;
		int results = Test.bucket_create(a, n);
		System.out.println(results);
		
	}
}