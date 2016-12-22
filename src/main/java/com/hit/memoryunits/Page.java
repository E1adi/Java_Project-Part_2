package com.hit.memoryunits;

public class Page<T> implements java.io.Serializable {

	T _content;
	java.lang.Long _id;
	
	
	public Page(java.lang.Long id,
            T content) {
	}
	
	public java.lang.Long getPageId() {
		return _id;		
	}
	
	public void setPageId(java.lang.Long pageId) {
		_id = pageId;
	}
	
	public T getContent() {
		return _content;
		
	}
	
	public void setContent(T content) {
		_content = content;
	}
	
	public int hashCode() {
		return 0;
		
	}
	
	public boolean equals(java.lang.Object obj) {
		if(obj instanceof Page<?>) {
			return _id == ((Page<T>)obj).getPageId();
		}
		return false;
	}
	
	public java.lang.String toString() {
		return String.format("Page ID: {0}, Content: {1}" , _id, _content);
	}
}
