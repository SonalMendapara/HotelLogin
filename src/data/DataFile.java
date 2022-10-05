package data;

import utilities.Xls_Reader;

public class DataFile {

	Xls_Reader d = new Xls_Reader("C:\\testing\\LoginTestNG.xlsx");
	
	public String wrongEmail = d.getCellData("HotelLogin", "Email", 2);
	public String wrongPassword = d.getCellData("HotelLogin", "Password", 2);
	public String emptyEmailErr = d.getCellData("HotelLogin", "Error message", 2);
	public String emptyPasswordErr = d.getCellData("HotelLogin", "Error message", 3);
	public String wrongEmailAndPasswordErr = d.getCellData("HotelLogin", "Error message", 4);
}
