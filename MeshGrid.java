import java.util.*;
class MeshGrid{
	double[] x;
	double[] y;
	double[] z;
	double[][] grid2dx;
	double[][] grid2dy;
	double[][][] grid3dx;
	double[][][] grid3dy;
	double[][][] grid3dz;
	int xn,yn,zn;

	public MeshGrid(){
		x=null;
		y=null;
		z=null;
		grid2dx=null;
		grid2dy=null;
		grid3dx=null;
		grid3dy=null;
		grid3dz=null;
	}

	public void generate3d(){
		grid3dx = new double[z.length][y.length][x.length];
		grid3dy = new double[z.length][y.length][x.length];
		grid3dz = new double[z.length][y.length][x.length];
		
		for(int i=0;i<z.length;i++){
			for(int j=0;j<y.length;j++){
				for(int k=0;k<x.length;k++){
					grid3dx[i][j][k]=x[k];
				}
			}
		}

		for(int i=0;i<z.length;i++){
			for(int j=0;j<y.length;j++){
				for(int k=0;k<x.length;k++){
					grid3dy[i][j][k]=y[j];
				}
			}
		}
		
		for(int i=0;i<z.length;i++){
			for(int j=0;j<y.length;j++){
				for(int k=0;k<x.length;k++){
					grid3dz[i][j][k]=z[i];
				}
			}
		}
	}
		
	public void generate2d(){ 
		grid2dx = new double[y.length][x.length];
		grid2dy = new double[y.length][x.length];
		
		for(int i=0;i<y.length;i++){
			for(int j=0;j<x.length;j++){
				grid2dx[i][j]=x[j];	
			}
		}
		for(int i=0;i<y.length;i++){
			for(int j=0;j<x.length;j++){
				grid2dy[i][j]=y[i];	
			}
		}
	}
	public void input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter x size:");
		xn = sc.nextInt();
		System.out.print("Enter y size:");
		yn = sc.nextInt();
		System.out.print("Enter z size:");
		zn = sc.nextInt();

		x = new double[xn];
		y = new double[yn];
		z = new double[zn];
		
		System.out.print("enter x array:");
		for(int i =0;i<x.length;i++){
			x[i] = sc.nextDouble();
		}
		System.out.print("enter y array:");
		for(int i =0;i<y.length;i++){
			y[i] = sc.nextDouble();
		}
		System.out.print("enter Z array:");
		for(int i =0;i<z.length;i++){
			z[i] = sc.nextDouble();
		}
		Arrays.sort(z);
		Arrays.sort(y);
		Arrays.sort(x);
		generate2d();
		generate3d();
	}
	public String toString(){
		String str = "";

		//printing X array
		str=str+"X=[";
		for(int i=0;i<x.length;i++){
			str = str+x[i];
			if(i!=(x.length-1)){
				str=str+",";
			}
		}
		str = str + "]\n ";

		//printing Y array
		str=str+"Y=[";
		for(int i=0;i<y.length;i++){
			str = str+y[i];
			if(i!=(y.length-1)){
				str=str+",";
			}
		}
		str = str + "]\n ";

		//printing Z array
		str=str+"Z=[";
		for(int i=0;i<z.length;i++){
			str = str+z[i];
			if(i!=(z.length-1)){
				str=str+",";
			}
		}
		str = str + "]\n ";

		//printing all the 2DMesh Grid
		str = str + "\n";
		str = str + "2D mesh grid x";
		str = str + "\n";
		for(int i=0;i<y.length;i++){
			for(int j=0;j<x.length;j++){
				str = str + grid2dx[i][j] + "\t";
			}
			str = str +"\n";
		}
		str=str+"\n";
		str = str + "2D mesh grid y\n";
		for(int i=0;i<y.length;i++){
			for(int j=0;j<x.length;j++){
				str = str + grid2dy[i][j] + "\t";
			}
			str = str +"\n";
		}

		//printing all 3D Mesh Grid
		str = str + "\n3D Mesg Grid\n";
		for(int i=0;i<z.length;i++){
			str=str+"x"+i+" = [\n";
			for(int j=0;j<y.length;j++){
				for(int k=0;k<x.length;k++){
					str = str + grid3dx[i][j][k]+"\t";
				}
				if(j!=(y.length-1)){
					str = str +"\n";
				}
				else{
					str=str+"\n]";
				}
			}
			str = str+"\n";
		}
		str = str+"\n";
		for(int i=0;i<z.length;i++){
			str=str+"y"+i+" = [\n";
			for(int j=0;j<y.length;j++){
				for(int k=0;k<x.length;k++){
					str = str + grid3dy[i][j][k]+"\t";
				}
				if(j!=(y.length-1)){
					str = str +"\n";
				}
				else{
					str=str+"\n]";
				}
			}
			str = str+"\n";
		}
		str = str+"\n";
		for(int i=0;i<z.length;i++){
			str=str+"z"+i+" = [\n";
			for(int j=0;j<y.length;j++){
				for(int k=0;k<x.length;k++){
					str = str + grid3dz[i][j][k]+"\t";
				}
				if(j!=(y.length-1)){
					str = str +"\n";
				}
				else{
					str=str+"\n]";
				}
			}
			str = str+"\n";
		}
		return str;
	}
}
class MainClass{
	public static void main(String args[]){
		MeshGrid mg = new MeshGrid();
		mg.input();
		System.out.println(mg);
	}
}