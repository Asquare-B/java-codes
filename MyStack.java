interface MyList{
	boolean isEmpty();
	boolean isFull();
	double pop();
	void push(double item) throws StackisFull;
}

class StackisFull extends Exception{
	StackisFull(String s){
		System.out.println(s);	
	}
}
class SizeLimit extends Exception{
	SizeLimit(String s){
		System.out.println(s);	
	}
}
class MyStack implements MyList {
	private double[] arr;
    	private int top;
	private int maxCapacity;
	private int count=0;
    
    	public MyStack(int m){
        	arr = new double[m];
        	top=-1;
        	maxCapacity=m;
    	}
    	public boolean isEmpty(){
        	return(top==-1)? true:false;
    	}
    	public boolean isFull(){
        	if(top==(maxCapacity-1))
			return true;
		else 
			return false;
    	}
    	public void push(double item) throws StackisFull{
        	if(!isFull()){
            		arr[++top]=item;
        	}
        	else{
            		//raise exception of max 
            		throw new StackisFull("Size is full");
        	}
    	}
    	public double pop(){
        	return (!isEmpty()) ? arr[top--] : -1;
    	}
	public void sizeChange() throws SizeLimit{
		maxCapacity = maxCapacity + (maxCapacity/2);
		count++;
		if(count==10){
			throw new SizeLimit("10 time size udapate is done");
		}
	}
	public void toPrint(){
		System.out.println("The stack");
		for(int i=0;i<=top;i++){
			System.out.println(""+arr[i]);
		}
	}
}

class Driver{
    	public static void main(String[] args){
        	MyStack stk = new MyStack(5);
		try{
        		stk.push(1.5);
	        	stk.push(2.5);
		        stk.push(3.5);
		        stk.push(4.5);
		        stk.push(5.5);
	        	stk.push(6.5);
			stk.push(7.5);
			stk.push(8.5);
			stk.push(9.5);
			stk.push(10.5);
			stk.push(11.5);
			stk.push(12.5);
			stk.push(13.5);
			stk.push(14.5);
			stk.push(15.5);
			stk.push(16.5);
			stk.push(17.5);
			stk.push(18.5);
			stk.push(19.5);
        	}
	        catch(StackisFull e){
				stk.sizeChange();
				System.out.println("max capacity is changed");
        	}
		finally{
			stk.toPrint();
		}
    	}
}