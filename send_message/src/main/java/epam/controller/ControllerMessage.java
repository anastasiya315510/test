package epam.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import epam.dto.MessageDTO;
import epam.inter.IMessage;


@RestController
public class ControllerMessage {
	
	@Autowired
	List<IMessage> listMess;
	
	
	@PostMapping("/send")
    String send(@RequestBody MessageDTO mess)	{
	    IMessage message = listMess.stream()
	    		.filter(m ->m.getClass().getSimpleName().equalsIgnoreCase(mess.getType()))
	    		.findFirst()
	    		.orElseThrow(() ->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type not found, try again!" ));
		return message.send(mess.getText(), mess.getAddress());
		
		
	}
}