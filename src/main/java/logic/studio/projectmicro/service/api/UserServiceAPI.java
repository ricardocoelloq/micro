package logic.studio.projectmicro.service.api;

import logic.studio.projectmicro.commos.GenericServiceAPI;
import login.studio.projectmicro.model.User;

public interface UserServiceAPI extends GenericServiceAPI<User, Integer>{
	User findUserByEmail(String email);

}
