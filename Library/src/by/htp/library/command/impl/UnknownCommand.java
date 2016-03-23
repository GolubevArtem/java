package by.htp.library.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.library.command.Command;
import by.htp.library.command.exception.CommandException;
import by.htp.library.entity.User;

public class UnknownCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		// TODO Auto-generated method stub
		
		HttpSession ses = request.getSession(false);
		
		if(ses != null){
			User user = (User) ses.getAttribute("login");
			
		}else {
			// return login page
		}
		return null;
	}

}
