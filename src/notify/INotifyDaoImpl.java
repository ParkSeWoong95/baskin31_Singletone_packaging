package notify;

import java.util.List;
import java.util.Map;

import db.DBClass;

public class INotifyDaoImpl implements INotifyDao{
	private static INotifyDao dao;
	private DBClass db;
	
	private INotifyDaoImpl(){
		db = DBClass.getInstance();
	}
	public static INotifyDao getInstance(){
		if(dao == null){
			dao = new INotifyDaoImpl();
		}
		return dao;
	}
	@Override
	public boolean insertNotify(NotifyVO notify) {
		return db.insertNotify(notify);
	}
	@Override
	public List<NotifyVO> selectAllNotify() {
		return db.selectAllNotify();
	}
	@Override
	public NotifyVO readNotify(int notify_seq) {
		return db.readNotify(notify_seq);
	}
	@Override
	public int updateNotify(Map<String, Object> notifyObj) {
		return db.updateNotify(notifyObj);
	}
	@Override
	public int deleteNotify(int notify_seq) {
		return db.deleteNotify(notify_seq);
	}

}
