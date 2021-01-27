package orderDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import orderInformation.IOrderInformationService;
import orderInformation.IOrderInformationServiceImpl;

public class IOrderDetailsServiceImpl implements IOrderDetailsService{
	private final IOrderInformationService iOrderInformationService = IOrderInformationServiceImpl.getInstance();
	private static IOrderDetailsServiceImpl service;
	private IOrderDetailsDao dao;
	
	private IOrderDetailsServiceImpl(){
		dao = IOrderDetailsDaoImpl.getInstance();
	}
	public static IOrderDetailsService getInstance(){
		if(service == null){
			service = new IOrderDetailsServiceImpl();
		}
		return service;
	}
	
	@Override
	public Map<String, Object> selectOrderDetails(int order_seq) {
		Map<String, Object> orderDetails = new HashMap<>();
		
		orderDetails.put("order", iOrderInformationService.selectOrderInfomation(order_seq));
		orderDetails.put("details", dao.selectOrderDetails(order_seq));
		
		return orderDetails;
	}
	
	@Override
	public boolean insertOrderDetails(List<OrderDetailsVO> OrderDetailsList) {
		return dao.insertOrderDetails(OrderDetailsList);
	}
}
