package logic.studio.projectmicro.dao.api;

import org.springframework.data.mongodb.repository.MongoRepository;

import login.studio.projectmicro.model.Documento;

public interface DocumentDaoAPI extends MongoRepository<Documento, String> {

}
