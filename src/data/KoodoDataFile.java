package data;

import utilities.Xls_Reader;

public class KoodoDataFile {
	Xls_Reader xl = new Xls_Reader("C:\\Practice\\KoodoLogin.xlsx");
	
	public String CorrectEmail = xl.getCellData("sheet1", 1, 2);
	public String WrongPassword = xl.getCellData("Sheet1", 1, 4);
	public String EmailValerr = xl.getCellData("Sheet1", 1,5 );
	public String PasswordvalErr = xl.getCellData("Sheet1", 1, 6);

}
