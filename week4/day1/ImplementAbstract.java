package week4.day1;


import java.util.ArrayList;
import java.util.List;

public class ImplementAbstract extends LearnAbstract{

	List<String> obj=new ArrayList<String>();
	

	@Override
	public void retest() {
		obj.add("siva");
		obj.add("raj");
	
		System.out.println(obj.get(2));
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sanity() {
		// TODO Auto-generated method stub
		
	}


	//public static void main(String[] args) {
		//List<String> obj=new ArrayList<String>();
		//obj.
	//}
}
