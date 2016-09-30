package rough;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterizacion {
	
	/*@Test(dataProvider="getdata")
	public void testData(String i,String t,String b,String r){
		
		System.out.println(i+"---------"+t+"---------"+b+"--------"+r);
		
	}*/

	
	@Test(dataProvider="getdata")
	public void testData(Hashtable<String, String>data){
		
		System.out.println(data.get("Iteration")+"---------"+data.get("TestData")+"---------"+data.get("Browser")+"--------"+data.get("RunMode"));

		
	}
	
	@DataProvider
	public static Object[][] getdata() {
		ExcelReader excel=new ExcelReader("C:\\Users\\carlos.torres\\Desktop\\Data.xlsx");
		String sheetName="TestData";
		String testCase="LoginTest";
		int testCaseRowNum=1;
		
		
		while (!excel.getCellData(sheetName, 0, testCaseRowNum).equalsIgnoreCase(testCase)) {	
			testCaseRowNum++;
		}
		System.out.println("Test case starts from : "+testCaseRowNum);
	
	
		int colsSatartRowNum=testCaseRowNum+1;
		int dataStartRowNum=colsSatartRowNum+1;
		//Total cols in test are
		int cols=0;
		while(!excel.getCellData(sheetName, cols, colsSatartRowNum).trim().equals("")){
			cols++;
		}
		System.out.println("Total cols in a test are: "+cols);
	
		// Total rows in test are
		int rows=0;
		while(!excel.getCellData(sheetName, 0, dataStartRowNum+rows).trim().equals("")){
			rows++;
		}
		System.out.println("Total rows are: "+rows);
		
		//Printing the test data
		Object[][] data=new Object[rows][1];
		int i=0;
		for (int row = dataStartRowNum; row < dataStartRowNum+rows; row++) {
			Hashtable<String,String> table=new Hashtable<String, String>();
			for (int col = 0; col < cols; col++) {
				String testData=excel.getCellData(sheetName, col, row);
				String colName=excel.getCellData(sheetName, col, colsSatartRowNum);
				table.put(colName, testData);
			}
			data[i][0]=table;
			i++;
		}

		return data;
	}
	
	
	
	/*
	@DataProvider
	public static Object[][] getdata() {
		ExcelReader excel=new ExcelReader("C:\\Users\\carlos.torres\\Desktop\\Data.xlsx");
		String sheetName="TestData";
		String testCase="SingUpTest";
		int testCaseRowNum=1;
		
		
		while (!excel.getCellData(sheetName, 0, testCaseRowNum).equalsIgnoreCase(testCase)) {	
			testCaseRowNum++;
		}
		System.out.println("Test case starts from : "+testCaseRowNum);
	
	
		int colsSatartRowNum=testCaseRowNum+1;
		int dataStartRowNum=colsSatartRowNum+1;
		//Total cols in test are
		int cols=0;
		while(!excel.getCellData(sheetName, cols, colsSatartRowNum).trim().equals("")){
			cols++;
		}
		System.out.println("Total cols in a test are: "+cols);
	
		// Total rows in test are
		int rows=0;
		while(!excel.getCellData(sheetName, 0, dataStartRowNum+rows).trim().equals("")){
			rows++;
		}
		System.out.println("Total rows are: "+rows);
		
		//Printing the test data
		Object[][] data=new Object[rows][cols];
		for (int row = dataStartRowNum; row < dataStartRowNum+rows; row++) {
			for (int col = 0; col < cols; col++) {
				data[row-dataStartRowNum][col]=excel.getCellData(sheetName, col, row);
				//System.out.println(excel.getCellData(sheetName, col, row));
			}
		}
		return data;
	}*/
}
