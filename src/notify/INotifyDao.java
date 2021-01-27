package notify;

import java.util.List;
import java.util.Map;

public interface INotifyDao {

	boolean insertNotify(NotifyVO notify);

	List<NotifyVO> selectAllNotify();

	NotifyVO readNotify(int notify_seq);

	int updateNotify(Map<String, Object> notifyObj);

	int deleteNotify(int notify_seq);

}
