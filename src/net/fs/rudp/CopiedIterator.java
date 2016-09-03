// Copyright (c) 2015 D1SM.net

package net.fs.rudp;

import java.util.Iterator;
import java.util.LinkedList;

public class CopiedIterator implements Iterator<Object> {
	private Iterator<?> iterator = null;

	public CopiedIterator(Iterator<? extends Object> itr) {
		LinkedList<Object> list = new LinkedList<>();
		while (itr.hasNext()) {
			list.add(itr.next());
		}
		this.iterator = list.iterator();
	}

	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	public void remove() {
		throw new UnsupportedOperationException("This is a read-only iterator.");
	}

	public Object next() {
		return this.iterator.next();
	}
}
