package logic.studio.projectmicro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import logic.studio.projectmicro.commos.GenericServiceImpl;
import logic.studio.projectmicro.dao.api.UserDaoAPI;
import logic.studio.projectmicro.service.api.UserServiceAPI;
import login.studio.projectmicro.model.User;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl extends GenericServiceImpl<User, Integer> implements UserServiceAPI {

	@Autowired
	private UserDaoAPI userDaoAPI;

	@Override
	public CrudRepository<User, Integer> getDao() {
		// TODO Auto-generated method stub
		return userDaoAPI;
	}

	@Override
	public User findUserByEmail(String email) {
		return userDaoAPI.findUserByEmail(email);
	}
}
