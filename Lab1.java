import java.util.*;

class meshGrid{
	int[] x,y;
	Scanner sc= new Scanner(System.in);
	int[][] x1,y1;
	int xlen=0,ylen=0,i=0;
	
	void meshGrid(){
		int[] x = new int[100];
		int[] y = new int[100];
		System.out.print("Enter array x size:");
		xlen = sc.nextInt();
		System.out.println();
		System.out.print("Enter array y size:");
		ylen = sc.nextInt();
		System.out.println();
	}

	void inputArray(){
		
		System.out.println("Enter the x elements:");
		for(i=0;i<xlen;i++){
			System.out.println("element:");
			x[i] = sc.nextInt();
		}
		
		System.out.println("Enter the y elements:");
		for(i=0;i<ylen;i++){
			System.out.println("element:");
			y[i] = sc.nextInt();
		}
	}
	void output(){
		System.out.println("X array");
		for(i=0;i<xlen;i++){
			System.out.println(x[i]);
		}
		System.out.println("Y array");
		for(i=0;i<ylen;i++){
			System.out.println(y[i]);
		}
	}
}

public class Lab1{
	public static void main(String[] args) {
		meshGrid aab = new meshGrid();
		aab.inputArray();
		aab.output();
   	}
}