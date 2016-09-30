package Utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="getDataSuite1")
	public static Object[][] getDataSuite1(Method m) {
		System.out.println(m.getName());
		ExcelReader excel=new ExcelReader(Constants.SUITE1_PATH);
		String testCase=m.getName();
		
		return CommonUtils.getdata("TestData", testCase, excel);
		
	}
	
	@DataProvider(name="getDataSuite2")
	public static Object[][] getDataSuite2(Method m) {
		System.out.println(m.getName());
		ExcelReader excel=new ExcelReader(Constants.SUITE2_PATH);
		String testCase=m.getName();
		
		return CommonUtils.getdata("TestData", testCase, excel);
		
	}

}
