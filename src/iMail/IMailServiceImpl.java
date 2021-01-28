package iMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


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
		String host = "smtp.naver.com"; // 네이버일 경우 네이버 계정, gmail경우
	      final String user = "ririnto@naver.com"; // 패스워드
	      final String password = "N6186qq!"; // SMTP 서버 정보를 설정한다.
	      Properties props = new Properties();
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", 587);
	      props.put("mail.smtp.auth", "true");
	      Session session = Session.getDefaultInstance(props,
	            new javax.mail.Authenticator() {
	               protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	                  return new javax.mail.PasswordAuthentication(user,
	                        password);
	               }
	            });
	      try {
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(user));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(
	               "ririnto@kakao.com")); // 메일 제목
	         message.setSubject("KTKO SMTP TEST1111"); // 메일 내용
	         message.setText("KTKO Success!!"); // send the message
	         Transport.send(message);
	         System.out.println("Success Message Send");
	      } catch (MessagingException e) {
	         e.printStackTrace();
	      }
	   }


}
