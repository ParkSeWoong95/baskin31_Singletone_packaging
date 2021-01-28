package poi;

import icecream.IcecreamVO;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import notify.NotifyVO;
import orderDetails.OrderDetailsVO;
import orderInformation.OrderInformationVO;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import size.SizeVO;
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
	
	public static List<SizeVO> getSizeList() {
		List<SizeVO> sizeList = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("sizeList");
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {
				
				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					SizeVO size = new SizeVO();
					size.setSeq((int)row.getCell(0).getNumericCellValue());
					size.setName(row.getCell(1).getStringCellValue());
					size.setGram((int)row.getCell(2).getNumericCellValue());
					size.setFlavorKinds((int)row.getCell(3).getNumericCellValue());
					size.setPrice((int)row.getCell(4).getNumericCellValue());
					size.setActivate(row.getCell(5).getBooleanCellValue());
					sizeList.add(size);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sizeList;
	}
	
	public static List<IcecreamVO> getIcecreamList() {
		List<IcecreamVO> icecreamList = new ArrayList<IcecreamVO>();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("icecreamList");
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {
				
				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					IcecreamVO icecream = new IcecreamVO();
					icecream.setSeq((int)row.getCell(0).getNumericCellValue());
					icecream.setKinds(row.getCell(1).getStringCellValue());
					icecream.setStock((int)row.getCell(2).getNumericCellValue());
					icecream.setActivate(row.getCell(3).getBooleanCellValue());
					icecreamList.add(icecream);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return icecreamList;
	}
	
	public static List<OrderInformationVO> getOrderInformationList() {
		List<OrderInformationVO> orderInformationList = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("orderInformationList");
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {
				
				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					OrderInformationVO orderInformation = new OrderInformationVO();
					orderInformation.setSeq((int)row.getCell(0).getNumericCellValue());
					orderInformation.setUser_id(row.getCell(1).getStringCellValue());
					orderInformation.setSize_seq((int)row.getCell(2).getNumericCellValue());
					orderInformation.setSpoonCount((int)row.getCell(3).getNumericCellValue());
					orderInformation.setHowToPick(row.getCell(4).getStringCellValue());
					orderInformation.setRefund(row.getCell(5).getBooleanCellValue());
					orderInformation.setActivate(row.getCell(6).getBooleanCellValue());
					orderInformationList.add(orderInformation);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInformationList;
	}
	
	public static List<OrderDetailsVO> getOrderDetailsList() {
		List<OrderDetailsVO> orderDetailsList = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("orderDetailsList");
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {
				
				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					OrderDetailsVO orderDetails = new OrderDetailsVO();
					orderDetails.setSeq((int)row.getCell(0).getNumericCellValue());
					orderDetails.setOrder_seq((int)row.getCell(1).getNumericCellValue());
					orderDetails.setIcecream_seq((int)row.getCell(2).getNumericCellValue());
					orderDetailsList.add(orderDetails);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetailsList;
	}
}
