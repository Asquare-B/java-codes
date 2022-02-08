class exp1 extends Exception {
	public exp1(String s) {
		super(s);
	}
}
class exp2 extends Exception {
	public exp2(String s) {
		super(s);
	}
}
class demo {
	public void expthrowing (int n) throws exp1,exp2{
		if(n%3==0){
			throw new exp1("number divisible by 3");
		}
		else{
			throw new exp2("number not divisible by 3");
		}
	}
	public static void main(String[] args) {
		int arr[] = { 210, 514, 5690, 3423, 2345, 234, 39};
		int i = 0;
		demo e1 = new demo();
		while (i < arr.length) {
			try{
				e1.expthrowing(arr[i]);
			}
			catch(exp1 | exp2 e){
				System.out.println(e);
				i++;
			}
		}
	}
}
