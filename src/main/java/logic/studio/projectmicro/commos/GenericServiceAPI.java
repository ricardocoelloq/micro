package logic.studio.projectmicro.commos;


import java.io.Serializable;
import java.util.List;

import login.studio.projectmicro.model.User;

public interface GenericServiceAPI<T, ID extends Serializable> {

	T save(T entity);
	
	void delete(ID id);
	
	T get(ID id);
	
	List<T> getAll();

}