package com.hit.memoryunits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	
	public void setPages(java.util.Map<java.lang.Long,Page<byte[]>> pages) {
		_memory.clear();
		_memory.putAll(pages);
	}
	
	public java.util.Map<java.lang.Long,Page<byte[]>> getPages() {
		return _memory;
	}
	
	public void addPages(Page<byte[]>[] addPages) {
		for(Page<byte[]> page: addPages) {
			if(_memory.size() < _capacity) {
				_memory.put(page.getPageId(), page);
			}
		}
	}
	
	public Page<byte[]>[] getPages(java.lang.Long[] pageIds) {
		List<Page<byte[]>> returnValues = new ArrayList<Page<byte[]>>();
		for(Long id: pageIds) {
			if(_memory.containsKey(id)) {
				returnValues.add(_memory.get(id));
			}
		}
		return returnValues.toArray(null);
	}
	
	public void addPage(Page<byte[]> addPage) {
		if(_memory.size() < _capacity) {
			_memory.put(addPage.getPageId(), addPage);
		}
	}
	
	public Page<byte[]> getPage(java.lang.Long pageId) {
		if(_memory.containsKey(pageId)) {
			return _memory.get(pageId);
		}
		else {
			return null;
		}
	}
	
	public void removePages(Page<byte[]>[] removePages) {
		for(Page<byte[]> page: removePages) {
			_memory.remove(page.getPageId(), page);
		}
	}
	
	public void removePage(Page<byte[]> removePage) {
		_memory.remove(removePage.getPageId());
	}	
	
	public void setInitialCapacity(int initialCapacity) {
		_capacity = initialCapacity;
	}
	
	public int getInitialCapacity() {
		return _capacity;
	}
	
	public int getCurrentSize() {
		return _memory.size();
	}
}
