package by.htp.library.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.library.command.Command;
import by.htp.library.command.exception.CommandException;

public class ShowCatalogCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		
		
		//List<Book>
		//request.setAttribute("book" , list);
		return null;
	}

}
