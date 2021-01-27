package orderDetails;

import java.util.List;
import java.util.Map;

public interface IOrderDetailsService {
	/**
	 * 주문 상세내역 조회 - 관리자 / 유저 메서드
	 * 
	 * @param order_seq
	 * @return List<OrderDetailsVO>
	 * @author 정예진
	 */
	Map<String, Object> selectOrderDetails(int order_seq);

	/**
	 * 주문 상세 정보 추가 - 유저 메서드
	 * 
	 * @param OrderDetailsList
	 * @return 성공 시 true, 실패 시 false 반환
	 * @author 이학재
	 */
	boolean insertOrderDetails(List<OrderDetailsVO> OrderDetailsList);
}
