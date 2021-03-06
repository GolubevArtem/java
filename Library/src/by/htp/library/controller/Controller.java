package by.htp.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import by.htp.library.command.Command;
import by.htp.library.command.CommandHelper;
import by.htp.library.command.exception.CommandException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private final static Logger logger = LogManager.getLogger("by.htp.library.controller");

	private static final String COMMAND_NAME = "command";

	private final CommandHelper commandHelper = new CommandHelper();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = null;
		Command command = null;
		String page = null;
		try {
			commandName = request.getParameter(COMMAND_NAME);
			command = commandHelper.getCommand(commandName);
			page = command.execute(request);

		} catch (CommandException e) {
			// logging
		//	logger.error("логин невозможен");
			page = PageName.ERROR_PAGE;

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		} else {
			//response.sendError(response.SC_NO_CONTENT);
			// TO DO
		}
	}

}
