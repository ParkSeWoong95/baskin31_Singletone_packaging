package iTextPDF;

import icecream.IIcecreamService;
import icecream.IIcecreamServiceImpl;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import orderDetails.IOrderDetailsService;
import orderDetails.IOrderDetailsServiceImpl;
import orderDetails.OrderDetailsVO;
import orderInformation.OrderInformationVO;
import size.ISizeService;
import size.ISizeServiceImpl;
import size.SizeVO;
import user.IUserService;
import user.IUserServiceImpl;
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

public class IiTextServiceImpl implements IiTextPDFService {
	
	private static IiTextServiceImpl service;
	
	private IiTextServiceImpl(){
		
	}
	
	public static IiTextServiceImpl getInstance(){
		if(service == null){
			service = new IiTextServiceImpl();
		}
		return service;
	}
	
	private IOrderDetailsService iOrderDetailsService = IOrderDetailsServiceImpl.getInstance();
	private IUserService iUserService = IUserServiceImpl.getInstance();
	private ISizeService iSizeService = ISizeServiceImpl.getInstance();
	private IIcecreamService iIcecreamService = IIcecreamServiceImpl.getInstance();

	@Override
	public String makePDF(int order_seq) {
		try {
			Map<String, Object> orderDetails = iOrderDetailsService.selectOrderDetails(order_seq);
			OrderInformationVO orderInformation = (OrderInformationVO) orderDetails.get("order");
			List<OrderDetailsVO> orderDetailsList = (List<OrderDetailsVO>) orderDetails.get("details");
			UserVO user = iUserService.selectUser(orderInformation.getUser_id());
			SizeVO size = iSizeService.selectSize(orderInformation.getSize_seq());
			
			String fileName = "output\\OrderNo." + orderInformation.getSeq() + ".pdf";
			
			Document doc = new Document(PageSize.A6, 20, 20, 30, 30); // 페이지 사이즈와
			// 좌우상하 여백
			
			PdfWriter.getInstance(doc, new FileOutputStream(fileName));
			doc.open();
			Image img = Image.getInstance("logo\\Baskin-Robbins_logo.png");
			img.setAlignment(1);
			img.setAbsolutePosition(30, 100);
			doc.add(img);
			String resPath = "fonts\\malgun.ttf";
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
				cell = new PdfPCell(new Paragraph(iIcecreamService.selectIcecream(orderDetailsList.get(i).getIcecream_seq()).getKinds(), cellNormalFont));
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setFixedHeight(21);
				cell.setColspan(3);
				table1.addCell(cell);
			}
			doc.add(table1);
			doc.close();
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
