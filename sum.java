//extending a thread class for following function.
public class Sum extends Thread{
	int first, last;// to represent start and end entries
	long[] array;
	long tempsum=0;

	public Sum(long[] array, int first, int last){
		this.array = array;
		this.first = first;
		this.last = last;
		this.tempsum = 0;
	}
	public void run(){
		for(int i=first; i<last ;i++){
			if(i%3==0 || i%5==0){
				tempsum = tempsum + array[i];
			}
		}
	}
}
class main{
	public static void main(String[] args){
		int size=10000;
		long resultant=0;
		long[] array = new long[size];
		for(int i=0;i<size;i++){
			array[i]=i;
		}
		Sum[] s = new Sum[10]; // 10 threads;
		for(int i=0;i<10;i++){
			s[i] = new Sum(array, (i*size)/10, ((i+1)*size)/10);
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
			System.out.println("The temporary sum of thread"+(i+1)+" is "+s[i].tempsum);
			resultant += s[i].tempsum;
		}
		long sum=0;
		for(int i=0;i<10000;i++){
			if(i%3==0 || i%5==0)
				sum+=i;
		}
		System.out.println("\t \t Ishita Agarwal");
		System.out.println("\t \t 19MIC0102");
		System.out.println("Sum with multithreading: "+resultant);
		System.out.println("Sum without multithreading: "+sum);

		
	}
}