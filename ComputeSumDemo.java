import java.util.Scanner;
public class ComputeSumDemo extends Thread{
    	int[] arr;
    	int n,sum;
    	public ComputeSumDemo(){
        	arr = null;
        	n = 0;
    	}
    	public void getData(){
        	Scanner sc = new Scanner(System.in);
        	n = sc.nextInt();
		arr = new int[n];
        	for(int i=0;i<n;i++){
            		arr[i]=sc.nextInt();
        	}
    	}
   	public String toString(){
        	String str="";
        	str=str+"The arrayis\n";
        	for(int i=0;i<n;i++){
            		str=str+arr[i]+" ";
        	}
		str = str+"\nthe sum is:"+sum;
        	return str;
    	}
	public void run(){
	        for(int i=0;i<n;i++){
            		sum=sum+arr[i];
        	}
		
	}
}

class Main{
     	public static void main(String []args){
        	ComputeSumDemo obj = new ComputeSumDemo();
        	obj.getData();
		obj.start();
        	System.out.print(obj);
     	}
}