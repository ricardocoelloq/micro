package login.studio.projectmicro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "documento")
public class Documento {
	
	@Id
	private String number;
	
	private String expiryDate;
	private String emissionDate;
	private DocumentType documentType;
	
	public Documento() {
		
	}
	
	public Documento(String number, String expiryDate, String emissionDate, DocumentType documentType) {
		super();
		this.number = number;
		this.expiryDate = expiryDate;
		this.emissionDate = emissionDate;
		this.documentType = documentType;
	}



	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getEmissionDate() {
		return emissionDate;
	}
	public void setEmissionDate(String emissionDate) {
		this.emissionDate = emissionDate;
	}
	public DocumentType getDocumentType() {
		return documentType;
	}
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

}
