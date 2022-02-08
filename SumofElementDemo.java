public class SumofElementDemo extends Thread{
	int st_id,end_id;
	double[] arr;
	double partialsum=0;
	
	public SumofElementDemo(double[] arr,int st_id, int end_id){	
		this.arr = arr;
		this.st_id = st_id;
		this.end_id = end_id;
		this.partialsum = 0.0;
	}
	public void run(){
		for(int i=st_id;i<end_id;i++){
			partialsum=partialsum+arr[i];
		}
	}
}

class Main{
	public static void main(String[] args){
		int size=1000;
		double finalsum=0.0;
		double[] arr = new double[size];
		for(int i=0;i<size;i++){
			arr[i]=i;
		}
		SumofElementDemo[] s = new SumofElementDemo[10]; // 10 threads;
		for(int i=0;i<10;i++){
			s[i] = new SumofElementDemo(arr, (i*size)/10, ((i+1)*size)/10);
			s[i].start();
		}
		for(int i=0;i<10;i++){
			try{
				s[i].join();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		for(int i=0;i<10;i++){
			System.out.println("The partial sum of thread"+(i+1)+" is "+s[i].partialsum);
			finalsum+=s[i].partialsum;
		}
		double sum=0.0;
		for(int i=0;i<1000;i++){
			sum+=i;
		}
		System.out.println("Sum with multithreading: "+finalsum);
		System.out.println("Sum without multithreading: "+sum);

	}
}