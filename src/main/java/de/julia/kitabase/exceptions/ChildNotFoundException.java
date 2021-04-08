package de.julia.kitabase.exceptions;

@SuppressWarnings("serial")
public class ChildNotFoundException extends RuntimeException {

	public ChildNotFoundException(Object o) {
		super("Could not find child " + o);
	}
}
