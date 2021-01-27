package notify;

import java.util.List;
import java.util.Map;

public class INotifyServiceImpl implements INotifyService{

	private static INotifyServiceImpl service;
	private INotifyDao dao;
	
	private INotifyServiceImpl(){
		dao = INotifyDaoImpl.getInstance();
	}
	public static INotifyService getInstance(){
		if(service == null){
			service = new INotifyServiceImpl();
		}
		return service;
	}
	@Override
	public boolean insertNotify(NotifyVO notify) {
		return dao.insertNotify(notify);
	}
	@Override
	public List<NotifyVO> selectAllNotify() {
		return dao.selectAllNotify();
	}
	@Override
	public NotifyVO selectNotify(int notify_seq) {
		return dao.readNotify(notify_seq);
	}
	@Override
	public int updateNotify(Map<String, Object> notifyObj) {
		return dao.updateNotify(notifyObj);
	}
	@Override
	public int deleteNotify(int notify_seq) {
		return dao.deleteNotify(notify_seq);
	}
	
}
