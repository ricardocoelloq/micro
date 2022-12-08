package logic.studio.projectmicro.dao.api;

import org.springframework.data.mongodb.repository.MongoRepository;

import login.studio.projectmicro.model.User;

public interface UserDaoAPI extends MongoRepository<User, Integer> {
	
	User findUserByEmail(String email);

}
