package epam.service;
import org.springframework.stereotype.Service;

import epam.inter.IMessage;

@Service
public class Facebook implements IMessage{

	@Override
	public String send(String text, String address) {
		
		return address+": "+ text;
	}

}
