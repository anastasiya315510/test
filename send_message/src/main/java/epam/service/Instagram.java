package epam.service;

import org.springframework.stereotype.Service;

import epam.inter.IMessage;
@Service
public class Instagram implements IMessage {

	@Override
	public String send(String text, String address) {
		
		return address + ": " +text;
	}

}
