package admin;

import java.util.Map;

import db.DBClass;

public class IAdminDaoImpl implements IAdminDao{
	private static IAdminDaoImpl dao;
	private DBClass db;
	
	private IAdminDaoImpl(){
		db = DBClass.getInstance();
	}
	public static IAdminDao getInstance(){
		if(dao == null){
			dao = new IAdminDaoImpl();
		}
		return dao;
	}
	@Override
	public boolean adminLogin(Map<String, String> loginInfo) {
		return db.adminLogin(loginInfo);
	}
}
