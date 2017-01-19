package com.hit.memoryunits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.hit.algorithm.IAlgoCache;

public class MemoryManagementUnit {
	
	private RAM _RAM = null;
	private IAlgoCache<java.lang.Long, java.lang.Long> _algo;
	
	public MemoryManagementUnit(int ramCapacity,
            com.hit.algorithm.IAlgoCache<java.lang.Long, java.lang.Long> algo) {
		if(ramCapacity > 0) {
			_RAM = new RAM(ramCapacity);
		}
		else {
			_RAM = new RAM(2048);
		}
		if(algo != null) {
			_algo = algo;
		}
		else {
			_algo = new com.hit.algorithm.SecondChanceAlgoCacheImpl<Long, Long>(_RAM.getInitialCapacity());
		}
	}
	
//	This method is the main method which returns array of pages that are requested from the user
//	Parameters:
//		pageIds - array of page id's
//	Returns:
//		returns array of pages that are requested from the user
//	Throws:
//		java.io.IOException
	public Page<byte[]>[] getPages(java.lang.Long[] pageIds)
            throws java.io.IOException, ClassNotFoundException {
		List<Long> requestedPages = Arrays.asList(pageIds);
		Page<byte[]> page = null;
		List<Page<byte[]>> pageToReturn = new ArrayList<Page<byte[]>>();
		HardDisk hd = HardDisk.getInstance();
		List<Long> presentPagesInMemory, missingPagesInMemory = Arrays.asList(pageIds);
		List<Long> keyToRemove;
		
		presentPagesInMemory = _algo.getElement(Arrays.asList(pageIds));
		if((presentPagesInMemory != null)) {
			Iterator<Long> presentPagesIterator = presentPagesInMemory.iterator();
			Iterator<Long> requestedPagesIterator = requestedPages.iterator();
			while(presentPagesIterator.hasNext() && requestedPagesIterator.hasNext()) {
				
			}
		}
		for(Long id: pageIds) {
			if((page = _RAM.getPage(id)) != null) {
				idList.clear();
				idList.add(id);
				_algo.getElement(idList);
				pageToReturn.add(page);
			}
			else {
				if(_RAM.getCurrentSize() < _RAM.getInitialCapacity()) {
					_RAM.addPage(hd.pageFault(id));
					pageToReturn.add(_RAM.getPage(id));
				}
				else {
					
				}
			}
		}
		return null;
	}
}
