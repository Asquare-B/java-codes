//Creating a public class extending from Thread class
public class SumofMultiples extends Thread{ 
	int start_id, end_id;
	long[] arr; // long because of big values for the array 
	long p_sum=0;// partial sum for storing the sum of every thread part

	// constructor method to get the array, start index and end index of the array
	public SumofMultiples(long[] arr, int start_id, int end_id){
		this.arr = arr;
		this.start_id = start_id;
		this.end_id = end_id;
		this.p_sum = 0;
	}

	// overiding the run method for the thread class 
	public void run(){
		// looping from start to end index and adding into p_sum after checking the divisibilty of 3 AND 5
		for(int x=start_id; x<end_id ;x++){
			if(x%3==0 || x%5==0){
				p_sum += arr[x];
			}
		}
	}
}

// driver class
class main{
	//main method
	public static void main(String[] args){
		int size=10000;// size of the array
		long finalsum=0;
		long[] arr = new long[size];
		// storing the values from 0,1,2..... before 10000 
		for(int x=0;x<size;x++){
			arr[x]=x;
		}
		
		// creating a object of 10 threads from the sumofmultiples class
		SumofMultiples[] s = new SumofMultiples[10]; // 10 threads;
		
		// dividing the array into 10 parts for each thread
		for(int x=0;x<10;x++){
			s[x] = new SumofMultiples(arr, (x*size)/10, ((x+1)*size)/10);
			s[x].start();// scheduling the threads
		}

		// joining the 10 threads so that whichever thread starts complete the work then move to next thread
		for(int x=0;x<10;x++){
			// doing in try and catch block to catch any exception is catches
			try{
				s[x].join();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		//Printing every threads partial sum and adding it to the final sum variable
		System.out.println("Partial sums of all 10 threads:");
		for(int x=0;x<10;x++){
			System.out.println("thread"+(x+1)+":"+s[x].p_sum);
			finalsum += s[x].p_sum;
		}
		

		// checking the Multithreading output via comparing to sum calculated without multithreading
		long sum=0;
		for(int x=0;x<10000;x++){
			if(x%3==0 || x%5==0)
				sum+=x;
		}
		
		System.out.print("\n");
		for(int x=0;x<50;x++){
			System.out.print("*");
		}
		System.out.print("\n AALAP BHAKTA - 19MIC0122\n");
		for(int x=0;x<50;x++){
			System.out.print("*");
		}
		System.out.print("\n\n");
		System.out.println("Sum with multithreading: "+finalsum);
		System.out.println("Sum without multithreading: "+sum);
		
		System.out.print("\n\n");

		// Comparing both sum
		if(finalsum == sum){
			System.out.println("Both the sums are eqaual hence the multithreaded output is correct");
			System.out.println("Sum of elements which are divisible by 3 or 5 below 10000 is : "+finalsum);
		}
		
	}
}