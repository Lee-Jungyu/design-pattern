package adaptor_pattern2;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator{
	Enumeration _enum;
	
	public EnumerationIterator(Enumeration _enum) {
		this._enum = _enum;
	}
	
	public boolean hasNext() {
		return _enum.hasMoreElements();
	}
	
	public Object next() {
		return _enum.nextElement();
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
