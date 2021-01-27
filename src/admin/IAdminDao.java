package admin;

import java.util.Map;

public interface IAdminDao {

	boolean adminLogin(Map<String, String> loginInfo);

}
