package rough;

public class TestData {
	
	public static void main(String[] args) {
		//C:\Users\\carlos.torres\\Desktop
		
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
		
		for (int row = dataStartRowNum; row < dataStartRowNum+rows; row++) {
			
			for (int col = 0; col < cols; col++) {
			
				System.out.println(excel.getCellData(sheetName, col, row));
			}
			
		}
	}
	
	

}
