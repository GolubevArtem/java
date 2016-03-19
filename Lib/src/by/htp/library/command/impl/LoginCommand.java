package by.htp.library.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.library.command.Command;
import by.htp.library.command.exception.CommandException;
import by.htp.library.controller.PageName;
import by.htp.library.entity.User;
import by.htp.library.service.UserService;
import by.htp.library.service.exception.ServiceException;

public class LoginCommand implements Command{
	
	private static final String LOGIN="login";
	private static final String PASSWORD="password";

	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		String page;
		
		try {
			User user = UserService.checkLogin(request.getParameter(LOGIN), request.getParameter(PASSWORD));
			if(user != null){
				request.getSession(true).setAttribute(LOGIN, user);
				page = PageName.USER_PAGE;
			}else {
				page =  PageName.ERROR_PAGE;
			}
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		
		return page;
	}

}
