public class Demo1 {
	public static class MyArray {
		public double[] arr;
		private static int count_a, count_b, count_ab;
		public double a,b;
		public MyArray(double a, double b) {
			count_a = 0;
			count_ab= 0;
			count_b = 0;
			this.a = a;
			this.b = b;
			arr = new double[999];
			for(int i=0;i<999;i++)
			{
				arr[i] = Math.random();
			}
		}
		public int getCountA() {
			return count_a;
		}
		public int getCountAB() {
			return count_ab;
		}
		public int getCountB() {
			return count_b;
		}
		public void incrementCountA() { count_a++;}
		public void incrementCountAB() { count_ab++;}
		public void incrementCountB() { count_b++;}
		


	}
	
	
	public static class ThreadA extends Thread{
		MyArray objRef;
		ThreadA(MyArray obj){
			objRef = obj;
		}
		
		public void run() {
			for (int i = 0; i < 999 ; i++)
			{
				if (objRef.arr[i] <= objRef.a) {
					objRef.incrementCountA();
					objRef.arr[i] = -1;
				}
			}
			
		}
	}
	
	public static class ThreadB extends Thread{
		MyArray objRef;
		ThreadB(MyArray obj){
			objRef = obj;
		}
		
		public void run() {
			for (int i = 0; i < 999 ; i++)
			{
				if (objRef.arr[i] >= objRef.b) {
					objRef.incrementCountB();
					objRef.arr[i] = 1;
				}
			}
			
		}
	}
	
	public static class ThreadAB extends Thread{
		MyArray objRef;
		ThreadAB(MyArray obj){
			objRef = obj;
		}
		
		public void run() {
			for (int i = 0; i < 999 ; i++)
			{
				if (objRef.arr[i] > objRef.a && objRef.arr[i] < objRef.b) {
					objRef.incrementCountAB();
					objRef.arr[i] = 0;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		double a1 = Double.parseDouble(args[0]);
		double b1 = Double.parseDouble(args[1]);
		MyArray obj1 = new MyArray(a1,b1);
		ThreadA thA = new ThreadA(obj1);
		ThreadB thB = new ThreadB(obj1);
		ThreadAB thAB = new ThreadAB(obj1);
		
		thA.start();
		thB.start();
		thAB.start();
		
		try {
			thA.join();
			thB.join();
			thAB.join();
			
		}
		catch (Exception e) { e.printStackTrace();
			
		}
		
		
		System.out.println("Count a = " + obj1.getCountA() );
		System.out.println("Count b = " + obj1.getCountB() );
		System.out.println("Count ab = " + obj1.getCountAB() );
		

	}
}