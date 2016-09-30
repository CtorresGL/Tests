package Utility;

import java.util.Hashtable;

import org.testng.SkipException;



public class CommonUtils {
	
	
	public static void checkExecution(	String testSuiteName,
										String testCaseName,
										String dataRunMode,
										ExcelReader excel) {
		
		
		if (!isSuiteExecutable(testSuiteName)) {
			
			throw new SkipException("Skipping the Test: "+testCaseName+" as the Runmode of Test Suite "+testSuiteName+" is NO");
			
		}
		if (!isTestExecutable(testCaseName, excel)) {
			
			throw new SkipException("Skipping the Test: "+testCaseName+" as the Runmode of Test is NO");
			
		}
		if (dataRunMode.equalsIgnoreCase(Constants.RUNMODE_NO)) {
	
			throw new SkipException("Skipping the Test: "+testCaseName+" as the Runmode of Test Data is NO");
		}
		
	}
	
	
	
	
	public static boolean isTestExecutable(String testCaseName,ExcelReader excel) {
		String sheetName=Constants.TEST_CASE_SHEET;
		
		int rows=excel.getRowCount(sheetName);
		for (int rowNum = 2; rowNum < rows; rowNum++) {
			String testCase=	excel.getCellData(sheetName, Constants.TEST_CASE_COL, rowNum);
				if(testCase.equalsIgnoreCase(testCaseName)){
					String runMode=excel.getCellData(sheetName, Constants.TEST_RUNMODE_COL, rowNum).toUpperCase();
					if(runMode.equalsIgnoreCase(Constants.RUNMODE_YES)){
						return true;
					}
					else{
						return false;
					}
				}		
			}
		
		
		return false;
	}
	
	
	
	public static boolean isSuiteExecutable(String suiteName) {
		
		ExcelReader excel=new ExcelReader(Constants.TEST_SUITE_XLS_PATH);
		String sheetName=Constants.TEST_SUITE_SHEET;
		int rows=excel.getRowCount(sheetName);
		
		for (int rowNum = 2; rowNum < rows; rowNum++) {
		String testSuiteName=	excel.getCellData(sheetName, Constants.TEST_SUITE_COL, rowNum);
			if(testSuiteName.equalsIgnoreCase(suiteName)){
				String runMode=excel.getCellData(sheetName, Constants.SUITE_RUNMODE_COL, rowNum).toUpperCase();
				if(runMode.equalsIgnoreCase(Constants.RUNMODE_YES)){
					return true;
				}
				else{
					return false;
				}
			}		
		}
		return false;
		
	}
	
	

	public static Object[][] getdata(String sheetName,String testCase,ExcelReader excel) {
		//ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\Suite1.xlsx");
		//String sheetName="TestData";
		//String testCase="TestA1";
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


}
