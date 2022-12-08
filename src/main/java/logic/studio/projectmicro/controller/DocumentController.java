package logic.studio.projectmicro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import logic.studio.projectmicro.service.api.DocumentServiceAPI;
import login.studio.projectmicro.model.Identity;
import logic.studio.projectmicro.utils.ResponseHandler;
import login.studio.projectmicro.model.Documento;

@RestController
@RequestMapping("/document/api/v1")
@CrossOrigin("*")
public class DocumentController {
	@Autowired
	private DocumentServiceAPI documentoServiceAPI;

	
	@GetMapping("/{documentId}")
    ResponseEntity<Object> getDeviceById(@PathVariable String documentId){
		 try {
	            var document = documentoServiceAPI.get(documentId);

	            if(document == null)
	                return ResponseHandler.generateResponse("ID not found", HttpStatus.NOT_FOUND, null);

	            return ResponseHandler.generateResponse("ID found", HttpStatus.OK, documentoServiceAPI.get(documentId));
	        } catch (Exception error) {
	            return ResponseHandler.generateResponse("There was an error getting the ID",
	                    HttpStatus.INTERNAL_SERVER_ERROR, null);
	        }
	    }

	
	 @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	 ResponseEntity<Object> addIdentify(@RequestBody Identity identiyDocument){
		 try {
			 Documento document = documentoServiceAPI.get(identiyDocument.getIdentityDocument().getNumber());

	            if(document != null)
	                return ResponseHandler.generateResponse("ID already exists", HttpStatus.CONFLICT, null);

	            documentoServiceAPI.save(identiyDocument.getIdentityDocument());

	            return ResponseHandler.generateResponse("Added Device", HttpStatus.CREATED, null);
	        } catch (Exception error) {
	            return ResponseHandler.generateResponse("An error occurred while adding the id",
	                    HttpStatus.INTERNAL_SERVER_ERROR, null);
	        }
	    }

	  @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<Object> removeIdentify(@RequestBody Identity identiyDocument) {
		 try {
			Documento document = documentoServiceAPI.get(identiyDocument.getIdentityDocument().getNumber());
			
			 if(document == null)
	             return ResponseHandler.generateResponse("ID not found", HttpStatus.NOT_FOUND, null);
			
			 documentoServiceAPI.delete(identiyDocument.getIdentityDocument().getNumber());
	
			 return ResponseHandler.generateResponse("Removed Device", HttpStatus.OK, null);
		 } catch (Exception error) {
	         return ResponseHandler.generateResponse("An error occurred while deleting the id",
	                 HttpStatus.INTERNAL_SERVER_ERROR, null);
	     }
	}
	
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateDevice(@RequestBody Identity identiyDocument) {
		 try {
			 Documento document = documentoServiceAPI.get(identiyDocument.getIdentityDocument().getNumber());
			 
			 if(document == null)
	             return ResponseHandler.generateResponse("ID not found", HttpStatus.NOT_FOUND, null);
			 
			 documentoServiceAPI.save(identiyDocument.getIdentityDocument());
			 
			 return ResponseHandler.generateResponse("Updated ID", HttpStatus.OK, null);
		 } catch (Exception error) {
	            return ResponseHandler.generateResponse("An error occurred while updating the ID.",
	                    HttpStatus.INTERNAL_SERVER_ERROR, null);
	     }
	}

}
