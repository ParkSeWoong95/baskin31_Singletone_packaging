package admin;

import java.util.Map;

public class IAdminServiceImpl implements IAdminService{
	private static IAdminServiceImpl service;
	private IAdminDao dao;
	
	private IAdminServiceImpl(){
		dao = IAdminDaoImpl.getInstance();
	}
	public static IAdminService getInstance(){
		if(service == null){
			service = new IAdminServiceImpl();
		}
		return service;
	}
	@Override
	public boolean adminLogin(Map<String, String> loginInfo) {
		return dao.adminLogin(loginInfo);
	}
}
