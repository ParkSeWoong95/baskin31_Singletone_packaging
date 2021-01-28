package iMail;

import iTextPDF.IiTextPDFService;
import iTextPDF.IiTextServiceImpl;
import icecream.IIcecreamService;
import icecream.IIcecreamServiceImpl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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

public class IMailServiceImpl implements IMailService {

	private static IMailServiceImpl service;

	public static IMailServiceImpl getInstance() {
		if (service == null) {
			service = new IMailServiceImpl();
		}
		return service;
	}

	@Override
	public void naverMailSend(int order_seq) {
		
		final IiTextPDFService iiTextPDFService = IiTextServiceImpl.getInstance();

		String host = "smtp.naver.com"; // 네이버일 경우 네이버 계정
		final String users = "atpdnd@naver.com"; // 패스워드, 왜 final ??
		final String password = "08941qkr@"; // SMTP 서버 정보를 설정한다. 왜 final ??
		Properties props = new Properties(); // HashTable형 new Properties 생성
		props.put("mail.smtp.host", host); // 생성된 props객체에 host, prot, auth 값을
											// 넣음
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(users,password);
					}
				});
		
		try {
			IOrderDetailsService iOrderDetailsService = IOrderDetailsServiceImpl.getInstance();
			Map<String, Object> orderDetails = iOrderDetailsService.selectOrderDetails(order_seq);
			OrderInformationVO orderInformation = (OrderInformationVO) orderDetails.get("order");
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(users));
			message.setHeader("Content-type", "text/HTML; charset=UTF-8");
			message.setHeader("format", "flowed");
			message.setHeader("Content-Transfer-Encoding", "8bit");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("atpdnd@gmail.com"));
			
			message.setSubject("아이스크림 주문 목록을 보냅니다"); // 메일 내용
			message.setText("메일보냄"); // send the message
			Transport.send(message);
			System.out.println("Success Message Send");
			
			
			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			
			// Fill the message;
			messageBodyPart.setText("테스트 메일");
			Multipart multipart = new MimeMultipart(); 
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart = new MimeBodyPart();
			File file = new File("output\\OrderNo." + orderInformation.getSeq() + ".pdf");
			FileDataSource fds = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setFileName(fds.getName());
			multipart.addBodyPart(messageBodyPart);
			
			// put parts in message
			message.setContent(multipart);
			Transport.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
