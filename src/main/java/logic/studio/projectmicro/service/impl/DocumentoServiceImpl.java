package logic.studio.projectmicro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import logic.studio.projectmicro.commos.GenericServiceImpl;
import logic.studio.projectmicro.dao.api.DocumentDaoAPI;
import logic.studio.projectmicro.service.api.DocumentServiceAPI;
import login.studio.projectmicro.model.Documento;
import login.studio.projectmicro.model.User;

@Service
public class DocumentoServiceImpl extends GenericServiceImpl<Documento, String> implements DocumentServiceAPI{

	@Autowired
	private DocumentDaoAPI documentDaoAPI;
	
	@Override
	public CrudRepository getDao() {
		// TODO Auto-generated method stub
		return documentDaoAPI;
	}
}
