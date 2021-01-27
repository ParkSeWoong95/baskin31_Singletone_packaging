package orderInformation;

import java.util.List;

public interface IOrderInformationService {
	/**
	 * 전체 주문내역 가져오기 - 관리자 메서드
	 * 
	 * @return List<OrderInformationVO>
	 * @author 이학재
	 */
	List<OrderInformationVO> selectAllOrderInfomation();
	
	/**
	 * 주문내역 하나 가져오기 - 관리자 / 유저 메서드
	 * 
	 * @param order_seq
	 * @return OrderInformationVO
	 * @author 정예진
	 */
	OrderInformationVO selectOrderInfomation(int order_seq);

	/**
	 * 주문 정보 추가 - 유저 메서드
	 * 
	 * @param orderInformation
	 * @return 성공 시 true, 실패 시 false 반환
	 * @author 이학재
	 */
	boolean insertOrderInformation(OrderInformationVO orderInformation);

	/**
	 * 나의 주문내역 전체 보기 - 유저 메서드
	 * 
	 * @param user_id
	 * @return List<OrderInformationVO>
	 * @author 정예진
	 */
	List<OrderInformationVO> selectAllOrderInformation(String user_id);

	/**
	 * 환불 - 유저 메서드
	 * 
	 * @param orderInfo_seq
	 * @return 실패 시 0, 성공 시 양수 반환
	 * @author 정예진
	 */
	int refundOrder(int orderInfo_seq);
}
