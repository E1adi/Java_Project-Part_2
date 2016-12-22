package com.hit.memoryunits;

import java.util.HashMap;
import java.util.Map;
import com.hit.constants.*;

public class RAM {
	
	private Map<java.lang.Long,Page<byte[]>> _memory; 
	private Integer _capacity;
	
	public RAM(int initialCapacity) {
		if(initialCapacity > 0) {
			_capacity = initialCapacity;
			_memory = new HashMap<java.lang.Long,Page<byte[]>>(initialCapacity);
		}
		else {
			_capacity = Constants.virtualMemoryDefaultSize;
			_memory = new HashMap<java.lang.Long,Page<byte[]>>(Constants.virtualMemoryDefaultSize);
		}
	}
	
	public java.util.Map<java.lang.Long,Page<byte[]>> getPages() {
		return _memory;
	}
	
	public void setPages(java.util.Map<java.lang.Long,Page<byte[]>> pages) {
		_memory.putAll(pages);
	}
	
	public Page<byte[]> getPage(java.lang.Long pageId) {
		if(_memory.containsKey(pageId)) {
			return _memory.get(pageId);
		}
		else {
			return null;
		}
	}
	
	public void addPage(Page<byte[]> addPage) throws 
}
