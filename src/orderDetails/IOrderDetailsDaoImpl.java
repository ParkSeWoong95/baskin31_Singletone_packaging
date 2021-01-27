package orderDetails;

import java.util.List;

import db.DBClass;

public class IOrderDetailsDaoImpl implements IOrderDetailsDao{
	private static IOrderDetailsDao dao;
	private DBClass db;
	
	private IOrderDetailsDaoImpl(){
		db = DBClass.getInstance();
	}
	public static IOrderDetailsDao getInstance(){
		if(dao == null){
			dao = new IOrderDetailsDaoImpl();
		}
		return dao;
	}
	@Override
	public List<OrderDetailsVO> selectOrderDetails(int order_seq) {
		return db.selectOrderDetails(order_seq);
	}
	@Override
	public boolean insertOrderDetails(List<OrderDetailsVO> orderDetailsList) {
		return db.insertOrderDetails(orderDetailsList);
	}

}
