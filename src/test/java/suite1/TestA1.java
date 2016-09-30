package suite1;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.CommonUtils;
import Utility.Constants;
import Utility.DataProviders;
import Utility.ExcelReader;



public class TestA1 {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="getDataSuite1")
	public void testA1(Hashtable<String, String>data){
		//System.out.println(data.get("Iteration")+"---------"+data.get("TestData")+"---------"+data.get("Browser")+"--------"+data.get("RunMode"));

		ExcelReader excel=new ExcelReader(Constants.SUITE1_PATH);
		
		CommonUtils.checkExecution("Suite1","TestA1", data.get(Constants.TEST_RUNMODE_COL), excel);
		
		/*
		System.out.println("Suite is: "+CommonUtils.isSuiteExecutable("Suite1"));
		System.out.println("The Test is: "+CommonUtils.isTestExecutable("TestA3", excel));
		System.out.println("Data Run mode is: "+data.get("RunMode"));
		*/
	}
	/*
	@DataProvider
	public static Object[][] getdata() {
		ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\Suite1.xlsx");
		return CommonUtils.getdata("TestData", "TestA1", excel);
	}
*/
}
