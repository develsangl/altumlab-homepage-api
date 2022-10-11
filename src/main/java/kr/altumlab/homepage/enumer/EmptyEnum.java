package kr.altumlab.homepage.enumer;

public enum EmptyEnum implements BaseEnum {
	;
	
	@Override
	public String getDescr() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
