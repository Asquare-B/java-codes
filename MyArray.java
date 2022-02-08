import java.util.*;
class MyArray{
	Random rand = new Random();
	public double[] arr;
	private int count_a,count_b,count_ab;
	public double a,b;
	public MyArray(double a,double b){
		count_a=0;
		count_ab=0;
		count_b=0;
		this.a = a;
		this.b = b;
		arr = new double[999];
		for(int i=0;i<999;i++){
			arr[i]=rand.nextInt(10000);
		}
	}
	public int getCountA(){ 
		return count_a;
	}
	public int getCountB(){
		return count_b;
	}
	public int getCountAB(){
		return count_ab;
	}
	public synchronized void incrementCountA(){ 
		count_a++;
	}
	public synchronized void incrementCountAB(){
		count_ab++;
	}
	public synchronized void incrementCountB(){
		count_b++;
	}
}
class Demo extends Thread{
	private MyArray ar1;

	int stid,endid;

	public Demo(MyArray myarr, int stid, int endid){
		ar1 = myarr;
		this.stid = stid;
		this.endid=endid;
	}

	public void run(){
		double a1 = ar1.a;
		double b1 = ar1.b;
		for(int i=stid;i<endid;i++){
			if(ar1.arr[i] <= a1){
				ar1.arr[i] = -1;
				ar1.incrementCountA();
			}
			else if(ar1.arr[i]>a1 && ar1.arr[i]<b1){
				ar1.arr[i] = 0;
				ar1.incrementCountAB();
			}
			else if(ar1.arr[i]>=b1){
				ar1.arr[i] = 1;
				ar1.incrementCountB();
			}
		}
	}
}
class mainclass{
	public static void main(String[] args){
		// while entering the arguments please enter double values like {-0.1,0.23},{-0.23,0.89}
		int a1 = Integer.parseInt(args[0]);
		int b1 = Integer.parseInt(args[1]);
		MyArray myarr = new MyArray(a1,b1);
		Demo[] th = new Demo[9];
		for(int i=0;i<9;i++){
			th[i] = new Demo(myarr, (i*999)/9 , ((i+1)*999)/9 );
			th[i].start();
		}
		for(int i=0;i<9;i++){
			try{
				th[i].join();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("Count a = " + myarr.getCountA() );
		System.out.println("Count b = " + myarr.getCountB() );
		System.out.println("Count ab = " + myarr.getCountAB() );
	}
}