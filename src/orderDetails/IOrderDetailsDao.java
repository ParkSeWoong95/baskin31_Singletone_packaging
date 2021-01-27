package orderDetails;

import java.util.List;

public interface IOrderDetailsDao {

	List<OrderDetailsVO> selectOrderDetails(int order_seq);

	boolean insertOrderDetails(List<OrderDetailsVO> orderDetailsList);


}
