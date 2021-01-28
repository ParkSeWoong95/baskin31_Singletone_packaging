package iMail;

public interface IMailService {
	/**
	 * 
	 * 메일 - 보내기 메서드
	 * 메일을 보내기 위해서는 네이버 계정에 SMTP이 '사용'으로 변환되어있어야함, 
	 * jar추가 링크 https://mvnrepository.com/artifact/javax.mail/mail/1.4.7
	 * Port번호는 587사용 
	 * @author 박세웅
	 * 
	 */
	// 주문한 것을 메일로 보내야함.
	public void naverMailSend(int order_seq);
}
