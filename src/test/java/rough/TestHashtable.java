package rough;

import java.util.Hashtable;

public class TestHashtable {
	
	public static void main(String[] args) {
		
		
		Hashtable<String,String> table=new Hashtable<String,String>();
		
		table.put("Iteration", "1");
		table.put("TestData", "Login1");
		table.put("Browser", "Chrome");
		table.put("RunMode", "y");
		
		System.out.println(table.get("TestData"));
		
		
	}

}
