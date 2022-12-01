package SimpleNotepad;

import java.util.Stack;

public class Test {

	
	public static int [] fun(int []arr) {
		
		int N = arr.length ;
		int ans [] = new int [N] ;
	
		Stack <Integer> stk = new Stack <>() ;
		
		 stk.push(arr[N-1]);
		 
		 ans[N-1] = -1 ;
		 
		 
		 //
		 
		 
		 for(int i = N-2 ; i >= 0 ; i-- ) {
			 
			 
			 if (arr[i] >= stk.peek()) {
				 
				 while (!stk.isEmpty() && arr[i] > stk.peek()) {
					 
					 stk.pop();
				 }
				 
				 if(stk.isEmpty()) {
					 
					 ans[i] = -1 ;
					 
				 }else {
					 ans[i] = stk.peek();
				 }
			 }else {
				 
				 ans[i] = stk.peek();
			 }
		 }
		
		 
		return ans ;
		
	}
	public static void main(String[] args) {
	
		
		int arr[] = {1,2,4,8,9,10,5};
		
		
		
	// find the greatest element at the 

	int ans []	= fun(arr) ;
	
	
	// print array 
	
	
	for(int i = 0 ; i < ans.length ; i ++) {
		
		System.out.print(ans[i] + " ");
	}
	}

}
