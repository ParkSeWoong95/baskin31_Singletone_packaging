package poi;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import user.UserVO;
import admin.AdminVO;

public class Poi {
	public static void main(String[] args) {
		List<UserVO> userList = getUserList();
		for (UserVO user : userList) {
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getPoint());
			System.out.println(user.getPw());
		}
	}
	
	public static AdminVO getAdmin() {
		AdminVO admin = new AdminVO();
		try {
			FileInputStream file = new FileInputStream("input\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {
				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					admin.setId(row.getCell(0).getStringCellValue());
					admin.setPw(row.getCell(1).getStringCellValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	public static List<UserVO> getUserList() {
		List<UserVO> userList = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("input\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {
				
				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					UserVO user = new UserVO();
					user.setId(row.getCell(0).getStringCellValue());
					user.setName(row.getCell(1).getStringCellValue());
					user.setPw(row.getCell(2).getStringCellValue());
					user.setPoint((int)row.getCell(3).getNumericCellValue());
					user.setActivate(row.getCell(4).getBooleanCellValue());
					userList.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
}
