package iTextPDF;

import icecream.IcecreamVO;

import java.io.FileOutputStream;
import java.sql.DatabaseMetaData;
import java.util.List;
import java.util.Map;

import orderDetails.OrderDetailsVO;
import orderInformation.OrderInformationVO;
import size.SizeVO;
import user.UserVO;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import db.DBClass;

public class ITextPDF {
	public static boolean makePDF(Map<String, Object> list) {
		try {
			OrderInformationVO orderInformation = (OrderInformationVO) list.get("orderList");
			List<OrderDetailsVO> orderDetailsList = (List<OrderDetailsVO>) list.get("orderListDetails");
			UserVO user = (UserVO) list.get("user");
			SizeVO size = (SizeVO) list.get("size");
			List<IcecreamVO> icecreamList = (List<IcecreamVO>) list.get("icecreamList");
			DBClass db = DBClass.getInstance();
			
			Document doc = new Document(PageSize.A6, 20, 20, 30, 30); // 페이지 사이즈와
			// 좌우상하 여백
			
			PdfWriter.getInstance(doc, new FileOutputStream("output\\OrderNo." + orderInformation.getSeq() + ".pdf"));
			doc.open();
			Image img = Image.getInstance("Baskin-Robbins_logo.png");
			img.setAlignment(1);
			img.setAbsolutePosition(30, 100);
			doc.add(img);
			String resPath = "malgun.ttf";
			BaseFont bf = BaseFont.createFont(resPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font titleFont = new Font(bf, 16, Font.BOLD);
			Font cellTitleFont = new Font(bf, 10, Font.BOLD);
			Font cellNormalFont = new Font(bf, 10, Font.NORMAL);
			
			Paragraph title = new Paragraph("영수증", titleFont);
			title.setAlignment(Paragraph.ALIGN_CENTER);
			
			doc.add(new Paragraph(" "));
			doc.add(title);
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(" "));
			
			PdfPTable table1 = new PdfPTable(4);
			table1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.setTotalWidth(200f);
			table1.setLockedWidth(true);
			PdfPCell cell = null;
			
			cell = new PdfPCell(new Paragraph("아이디", cellTitleFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			cell = new PdfPCell(new Paragraph(orderInformation.getUser_id(), cellNormalFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setColspan(3);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("이름", cellTitleFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			cell = new PdfPCell(new Paragraph(user.getName(), cellNormalFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setColspan(3);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("사이즈명", cellTitleFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			cell = new PdfPCell(new Paragraph(size.getName(), cellNormalFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setColspan(3);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("가격", cellTitleFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf(size.getPrice()), cellNormalFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setColspan(3);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("수령 방법", cellTitleFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			cell = new PdfPCell(new Paragraph(orderInformation.getHowToPick(), cellNormalFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setColspan(3);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("스푼 갯수", cellTitleFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf(orderInformation.getSpoonCount()), cellNormalFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setColspan(3);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("환불 여부", cellTitleFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf(orderInformation.isRefund()), cellNormalFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setColspan(3);
			cell.setFixedHeight(21);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("선택한 맛", cellTitleFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setFixedHeight(21);
			cell.setRowspan(orderDetailsList.size());
			table1.addCell(cell);
			
			for (int i = 0; i < orderDetailsList.size(); i++) {
				cell = new PdfPCell(new Paragraph(db.selectIcecream(orderDetailsList.get(i).getIcecream_seq()).getKinds(), cellNormalFont));
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setFixedHeight(21);
				cell.setColspan(3);
				table1.addCell(cell);
			}
			doc.add(table1);
			doc.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
