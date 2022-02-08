public class MovingArray5 throws Exception{
	double[] arr;
	int[] src;
	
	public MovingArray5(int[] src, double avg){
		this.src= src;
		this.avg = 0.0;	
	}
	
	public int[] MovingAverage5(){
		int total;
		int count =5;
		for(int i=0; i<size; i++){
			total =0;
			if((i+5)!=(size-1)){
				for(int j=i;j<i+5;j++){
					total = total + src[j];
				}
				avg = total / count;
				arr[i]=avg;
			}
		}
		return arr;
	}
}
class main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of src:");
		int size = sc.nextInt();
		int[] src = new int[];
		System.out.println("src array elements:");
		for(int i=0;i<size;i++){
			src[i] = i+1;
			System.out.print(src[i]+" ");
		}
		int[] src = new int[];
		MovingArray5 m = new MovingArray(src,avg);		
	}
}