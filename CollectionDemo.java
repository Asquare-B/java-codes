import java.util.*;
class CollectionDemo{
	public static String identity(Set s){
		return "SET";
	}
	public static String identity(List l){
		return "List";
	}
	public static String identity(Collection l){
		return "Not known";
	}
	public static void main(String[] args){
		Collection[] cdemo = new Collection[3];
		cdemo[0] = new HashSet();
		cdemo[1] = new ArrayList();
		cdemo[2] = new HashMap().values;
		for(int i=0;i<3;i++)
			System.out.println(identity(cdemo[i]));
	}
}