package by.htp.library.command;

import javax.servlet.http.HttpServletRequest;

import by.htp.library.command.exception.CommandException;

public interface Command {
	String execute(HttpServletRequest request) throws CommandException;
}
