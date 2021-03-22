package de.julia.kitabase;

@SuppressWarnings("serial")
public class ChildNotFoundException extends RuntimeException {

	public ChildNotFoundException(Long id) {
		super("Could not find child " + id);
	}
}
