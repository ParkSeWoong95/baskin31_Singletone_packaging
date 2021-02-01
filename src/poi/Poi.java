package poi;

import icecream.IcecreamVO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	public static List<UserVO> readUserList() {
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
					user.setPoint((int) row.getCell(3).getNumericCellValue());
					user.setActivate(row.getCell(4).getBooleanCellValue());
					userList.add(user);
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	public static List<NotifyVO> readNotifyList() {
		List<NotifyVO> notifyList = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("notifyList");
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {

				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					NotifyVO notify = new NotifyVO();
					notify.setSeq((int) row.getCell(0).getNumericCellValue());
					notify.setTitle(row.getCell(1).getStringCellValue());
					notify.setContents(row.getCell(2).getStringCellValue());
					notify.setDate(row.getCell(3).getStringCellValue());
					notify.setReadView((int) row.getCell(4).getNumericCellValue());
					notifyList.add(notify);
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notifyList;
	}

	public static List<SizeVO> readSizeList() {
		List<SizeVO> sizeList = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("sizeList");
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {

				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					SizeVO size = new SizeVO();
					size.setSeq((int) row.getCell(0).getNumericCellValue());
					size.setName(row.getCell(1).getStringCellValue());
					size.setGram((int) row.getCell(2).getNumericCellValue());
					size.setFlavorKinds((int) row.getCell(3).getNumericCellValue());
					size.setPrice((int) row.getCell(4).getNumericCellValue());
					size.setActivate(row.getCell(5).getBooleanCellValue());
					sizeList.add(size);
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sizeList;
	}

	public static List<IcecreamVO> readIcecreamList() {
		List<IcecreamVO> icecreamList = new ArrayList<IcecreamVO>();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("icecreamList");
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {

				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					IcecreamVO icecream = new IcecreamVO();
					icecream.setSeq((int) row.getCell(0).getNumericCellValue());
					icecream.setKinds(row.getCell(1).getStringCellValue());
					icecream.setStock((int) row.getCell(2).getNumericCellValue());
					icecream.setActivate(row.getCell(3).getBooleanCellValue());
					icecreamList.add(icecream);
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return icecreamList;
	}

	public static List<OrderInformationVO> readOrderInformationList() {
		List<OrderInformationVO> orderInformationList = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("orderInformationList");
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {

				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					OrderInformationVO orderInformation = new OrderInformationVO();
					orderInformation.setSeq((int) row.getCell(0).getNumericCellValue());
					orderInformation.setUser_id(row.getCell(1).getStringCellValue());
					orderInformation.setSize_seq((int) row.getCell(2).getNumericCellValue());
					orderInformation.setSpoonCount((int) row.getCell(3).getNumericCellValue());
					orderInformation.setHowToPick(row.getCell(4).getStringCellValue());
					orderInformation.setRefund(row.getCell(5).getBooleanCellValue());
					orderInformation.setActivate(row.getCell(6).getBooleanCellValue());
					orderInformationList.add(orderInformation);
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInformationList;
	}

	public static List<OrderDetailsVO> readOrderDetailsList() {
		List<OrderDetailsVO> orderDetailsList = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("db\\Database.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("orderDetailsList");
			for (int rowindex = 1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {

				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					OrderDetailsVO orderDetails = new OrderDetailsVO();
					orderDetails.setSeq((int) row.getCell(0).getNumericCellValue());
					orderDetails.setOrder_seq((int) row.getCell(1).getNumericCellValue());
					orderDetails.setIcecream_seq((int) row.getCell(2).getNumericCellValue());
					orderDetailsList.add(orderDetails);
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetailsList;
	}

	public static boolean writeDatabaseAsExcel(Map<String, Object> lists) {
		AdminVO admin = (AdminVO) lists.get("admin");
		List<UserVO> userList = (List<UserVO>) lists.get("userList");
		List<NotifyVO> notifyList = (List<NotifyVO>) lists.get("notifyList");
		List<SizeVO> sizeList = (List<SizeVO>) lists.get("sizeList");
		List<IcecreamVO> icecreamList = (List<IcecreamVO>) lists.get("icecreamList");
		List<OrderInformationVO> orderInformationList = (List<OrderInformationVO>) lists.get("orderInformationList");
		List<OrderDetailsVO> orderDetailsList = (List<OrderDetailsVO>) lists.get("orderDetailsList");

		FileOutputStream file;
		XSSFWorkbook workbook;
		XSSFRow curRow;
		XSSFSheet sheet;

		try {
			file = new FileOutputStream("db\\Database.xlsx");
			workbook = new XSSFWorkbook();

			sheet = workbook.createSheet("admin");
			curRow = sheet.createRow(0);
			curRow.createCell(0).setCellValue("id");
			curRow.createCell(1).setCellValue("pw");
			curRow = sheet.createRow(1);
			curRow.createCell(0).setCellValue(admin.getId());
			curRow.createCell(1).setCellValue(admin.getPw());

			sheet = workbook.createSheet("userList");
			curRow = sheet.createRow(0);
			curRow.createCell(0).setCellValue("id");
			curRow.createCell(1).setCellValue("name");
			curRow.createCell(2).setCellValue("pw");
			curRow.createCell(3).setCellValue("point");
			curRow.createCell(4).setCellValue("isActivate");
			for (int i = 1; i < userList.size() + 1; i++) {
				curRow = sheet.createRow(i);
				curRow.createCell(0).setCellValue(userList.get(i - 1).getId());
				curRow.createCell(1).setCellValue(userList.get(i - 1).getName());
				curRow.createCell(2).setCellValue(userList.get(i - 1).getPw());
				curRow.createCell(3).setCellValue(userList.get(i - 1).getPoint());
				curRow.createCell(4).setCellValue(userList.get(i - 1).isActivate());
			}

			sheet = workbook.createSheet("notifyList");
			curRow = sheet.createRow(0);
			curRow.createCell(0).setCellValue("seq");
			curRow.createCell(1).setCellValue("title");
			curRow.createCell(2).setCellValue("contents");
			curRow.createCell(3).setCellValue("date");
			curRow.createCell(4).setCellValue("readView");
			for (int i = 1; i < notifyList.size() + 1; i++) {
				curRow = sheet.createRow(i);
				curRow.createCell(0).setCellValue(notifyList.get(i - 1).getSeq());
				curRow.createCell(1).setCellValue(notifyList.get(i - 1).getTitle());
				curRow.createCell(2).setCellValue(notifyList.get(i - 1).getContents());
				curRow.createCell(3).setCellValue(notifyList.get(i - 1).getDate());
				curRow.createCell(4).setCellValue(notifyList.get(i - 1).getReadView());
			}

			sheet = workbook.createSheet("icecreamList");
			curRow = sheet.createRow(0);
			curRow.createCell(0).setCellValue("seq");
			curRow.createCell(1).setCellValue("kinds");
			curRow.createCell(2).setCellValue("stock");
			curRow.createCell(3).setCellValue("isActivate");
			for (int i = 1; i < icecreamList.size() + 1; i++) {
				curRow = sheet.createRow(i);
				curRow.createCell(0).setCellValue(icecreamList.get(i - 1).getSeq());
				curRow.createCell(1).setCellValue(icecreamList.get(i - 1).getKinds());
				curRow.createCell(2).setCellValue(icecreamList.get(i - 1).getStock());
				curRow.createCell(3).setCellValue(icecreamList.get(i - 1).isActivate());
			}

			sheet = workbook.createSheet("sizeList");
			curRow = sheet.createRow(0);
			curRow.createCell(0).setCellValue("seq");
			curRow.createCell(1).setCellValue("name");
			curRow.createCell(2).setCellValue("gram");
			curRow.createCell(3).setCellValue("flavorKinds");
			curRow.createCell(4).setCellValue("price");
			curRow.createCell(5).setCellValue("isActivate");
			for (int i = 1; i < sizeList.size() + 1; i++) {
				curRow = sheet.createRow(i);
				curRow.createCell(0).setCellValue(sizeList.get(i - 1).getSeq());
				curRow.createCell(1).setCellValue(sizeList.get(i - 1).getName());
				curRow.createCell(2).setCellValue(sizeList.get(i - 1).getGram());
				curRow.createCell(3).setCellValue(sizeList.get(i - 1).getFlavorKinds());
				curRow.createCell(4).setCellValue(sizeList.get(i - 1).getPrice());
				curRow.createCell(5).setCellValue(sizeList.get(i - 1).isActivate());
			}

			sheet = workbook.createSheet("orderInformationList");
			curRow = sheet.createRow(0);
			curRow.createCell(0).setCellValue("seq");
			curRow.createCell(1).setCellValue("user_id");
			curRow.createCell(2).setCellValue("size_seq");
			curRow.createCell(3).setCellValue("spoonCount");
			curRow.createCell(4).setCellValue("howToPick");
			curRow.createCell(5).setCellValue("refund");
			curRow.createCell(6).setCellValue("isActivate");
			for (int i = 1; i < orderInformationList.size() + 1; i++) {
				curRow = sheet.createRow(i);
				curRow.createCell(0).setCellValue(orderInformationList.get(i - 1).getSeq());
				curRow.createCell(1).setCellValue(orderInformationList.get(i - 1).getUser_id());
				curRow.createCell(2).setCellValue(orderInformationList.get(i - 1).getSize_seq());
				curRow.createCell(3).setCellValue(orderInformationList.get(i - 1).getSpoonCount());
				curRow.createCell(4).setCellValue(orderInformationList.get(i - 1).getHowToPick());
				curRow.createCell(5).setCellValue(orderInformationList.get(i - 1).isRefund());
				curRow.createCell(6).setCellValue(orderInformationList.get(i - 1).isActivate());
			}

			sheet = workbook.createSheet("orderDetailsList");
			curRow = sheet.createRow(0);
			curRow.createCell(0).setCellValue("seq");
			curRow.createCell(1).setCellValue("order_seq");
			curRow.createCell(2).setCellValue("icecream_seq");
			for (int i = 1; i < orderDetailsList.size() + 1; i++) {
				curRow = sheet.createRow(i);
				curRow.createCell(0).setCellValue(orderDetailsList.get(i - 1).getSeq());
				curRow.createCell(1).setCellValue(orderDetailsList.get(i - 1).getOrder_seq());
				curRow.createCell(2).setCellValue(orderDetailsList.get(i - 1).getIcecream_seq());
			}
			workbook.write(file);
			file.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
