package orderInformation;

import java.util.List;

public class IOrderInformationServiceImpl implements IOrderInformationService{
	private static IOrderInformationService service;
	private IOrderInformationDao dao;
	
	private IOrderInformationServiceImpl(){
		dao = IOrderInformationDaoImpl.getInstance();
	}
	
	public static IOrderInformationService getInstance(){
		if(service == null){
			service = new IOrderInformationServiceImpl();
		}
		return service;
	}

	@Override
	public List<OrderInformationVO> selectAllOrderInfomation() {
		return dao.selectAllOrderInformation();
	}

	@Override
	public OrderInformationVO selectOrderInfomation(int order_seq) {
		return dao.selectOrderInformation(order_seq);
	}

	@Override
	public boolean insertOrderInformation(OrderInformationVO orderInformation) {
		return dao.insertOrderInformation(orderInformation);
	}

	@Override
	public List<OrderInformationVO> selectAllOrderInformation(String user_id) {
		return dao.selectOrderInformation(user_id);
	}

	@Override
	public int refundOrder(int orderInfo_seq) {
		return dao.refundOrder(orderInfo_seq);
	}
}
