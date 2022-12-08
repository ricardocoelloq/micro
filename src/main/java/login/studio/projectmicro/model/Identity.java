package login.studio.projectmicro.model;

public class Identity {
	private Documento identityDocument;
	
	public Identity() {

	}

	public Identity(Documento identityDocument) {
		super();
		this.identityDocument = identityDocument;
	}

	public Documento getIdentityDocument() {
		return identityDocument;
	}

	public void setIdentityDocument(Documento identityDocument) {
		this.identityDocument = identityDocument;
	}
	
	

}
