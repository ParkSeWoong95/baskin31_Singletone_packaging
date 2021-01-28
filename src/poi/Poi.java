package poi;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import notify.NotifyVO;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import user.UserVO;
import admin.AdminVO;

public class Poi {
	public static void main(String[] args) {
		List<NotifyVO> notifyList = getNotifyList();
		for (NotifyVO notify : notifyList) {
			System.out.println(notify.getDate());
		}
	}
	
	public static AdminVO getAdmin() {
		AdminVO admin = new AdminVO();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("admin");
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
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("userList");
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
	
	public static List<NotifyVO> getNotifyList() {
		List<NotifyVO> notifyList = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("notifyList");
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {
				
				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					NotifyVO notify = new NotifyVO();
					notify.setSeq((int)row.getCell(0).getNumericCellValue());
					notify.setTitle(row.getCell(1).getStringCellValue());
					notify.setContents(row.getCell(2).getStringCellValue());
					notify.setDate(row.getCell(3).getStringCellValue());
					notify.setReadView((int)row.getCell(4).getNumericCellValue());
					notifyList.add(notify);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notifyList;
	}
}
