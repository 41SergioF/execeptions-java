package model.exeptions;

public class DomainExeptions extends Exception{// ou RuntimeException

	private static final long serialVersionUID = 1L;
	
	public DomainExeptions(String msg) {
		super(msg);
	}
	
}
