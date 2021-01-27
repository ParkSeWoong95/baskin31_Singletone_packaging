package orderInformation;

import java.util.List;

import db.DBClass;

public class IOrderInformationDaoImpl implements IOrderInformationDao{

	private static IOrderInformationDao dao;
	private DBClass db;
	
	private IOrderInformationDaoImpl() {
		db = DBClass.getInstance();
	}
	
	public static IOrderInformationDao getInstance() {
		if(dao == null){
			dao = new IOrderInformationDaoImpl();
		}
		return dao;
	}

	@Override
	public List<OrderInformationVO> selectAllOrderInformation() {
		return db.selectAllOrderInformation();
	}

	@Override
	public OrderInformationVO selectOrderInformation(int order_seq) {
		return db.selectOrderInformation(order_seq);
	}

	@Override
	public boolean insertOrderInformation(OrderInformationVO orderInformation) {
		return db.insertOrderInformation(orderInformation);
	}

	@Override
	public List<OrderInformationVO> selectOrderInformation(String user_id) {
		return db.selectOrderInformation(user_id);
	}

	@Override
	public int refundOrder(int orderInfo_seq) {
		return db.refundOrder(orderInfo_seq);
	}

}
