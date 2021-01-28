package common;

import icecream.IIcecreamDao;
import icecream.IIcecreamDaoImpl;
import icecream.IIcecreamService;
import icecream.IIcecreamServiceImpl;
import db.DBClass;

public class IServiceImpl implements IService {
	
	DBClass db; 
	private static IServiceImpl service;
	private IIcecreamDao dao;
	
	private IServiceImpl(){
		db = DBClass.getInstance();
	}
	
	public static IServiceImpl getInstance(){
		if(service == null){
			service = new IServiceImpl();
		}
		return service;
	}
	
	@Override
	public boolean writeDatabaseAsExcel() {
		return db.writeDatabaseAsExcel();
	}

}
