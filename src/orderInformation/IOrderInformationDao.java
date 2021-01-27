package orderInformation;

import java.util.List;

public interface IOrderInformationDao {

	List<OrderInformationVO> selectAllOrderInformation();

	OrderInformationVO selectOrderInformation(int order_seq);

	public boolean insertOrderInformation(OrderInformationVO orderInformation);

	List<OrderInformationVO> selectOrderInformation(String user_id);

	int refundOrder(int orderInfo_seq);

}
