import java.util.*;
interface MyList{
	boolean isEmpty();
	boolean isFull();
	double pop();
	void push(double item) throws StackisFull;
}
class StackisFull extends Exception{
	public StackisFull(String s){
		System.out.println(s);	
	}
}
class ChangeLimit extends Exception{
	public ChangeLimit(String s){
		System.out.println(s);	
	}
}
class Stackdemo implements MyList{
	int top;
	int size;
	double[] arr;
	int count;
	
	public Stackdemo(int m){
		this.arr = new double[m];
		this.top = -1;
		this.size = m;
		this.count = 0;
	}
	public boolean isEmpty(){
		if(top==-1){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isFull(){
		if(top == (size-1)){
			return true;
		}
		else{
			return false;
		}
	}
	public void push(double item) throws StackisFull{
		if(isFull() == false){
			top=++top;
			arr[top]=item;
		}
		else{
			throw new StackisFull("Size is full");
		}
	}
	public double pop(){
		if(isEmpty() == false){
			double t = arr[top];
			top=top-1;
			return t;
		}
		else{
			top=-1;
			return -1;
		}
	}
	public void sizeChange() throws ChangeLimit{
		count++;
		if(count<=10){
			double[] arr1 = new double[size];
			arr1=arr;
			int n = size;
			size=size+(int)(size/2);
			arr = new double[size];
			for(int i=0;i<size;i++){
				if(i<n){
					arr[i]=arr1[i];
				}
			}
			
		}
		else{
			throw new ChangeLimit("no more update");
		}
	}
	public void toPrint(){
		String str="";
		System.out.println("The stack");
		for(int i=top;i>=0;i--){
			System.out.println(""+arr[i]);
		}
		str = str + "stack size" +size+" top:"+top;
		System.out.println(str);
	}
}

class Driver{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Stack size:");
		int n = sc.nextInt();
		Stackdemo stk = new Stackdemo(n);

		int f=0;
		do{
			System.out.println("Options: \t1. Push element \t2. Pop element \t3. display details \nEnter choice:");
			int x = sc.nextInt();
			switch(x){
				case 1:
					try{
						System.out.print("Enter the element:");
						double d = sc.nextDouble();
						stk.push(d);
					}
					catch(StackisFull e){
						try{
							stk.sizeChange();
							System.out.println("max capacity is changed AND again push the number");
							
						}
						catch(ChangeLimit e1){
							System.out.println("The program updated the stack size 10 times but no more");
						}
			        	}
					break;
				case 2:
					if(stk.isEmpty() == false){
						System.out.println("the element deleted is:"+stk.pop());
					}
					else{
						System.out.println("the stack is empty");
					}
					break;
				case 3:
					stk.toPrint();
					break;
			}
			System.out.println("1-continue 0-end");
			f=sc.nextInt();
		}while(f==1);
	}
}