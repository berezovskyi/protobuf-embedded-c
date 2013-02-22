package edu.tum.cs.ccts.protobuf.embedded;

import java.util.Comparator;
import java.util.HashMap;

import org.antlr.stringtemplate.StringTemplate;

@SuppressWarnings("rawtypes")
public class TemplateOrderComparator implements Comparator {

	private final HashMap<String, Integer> order;

	private final boolean ascending;

	public TemplateOrderComparator(HashMap<String, Integer> order,
			boolean ascending) {
		this.order = order;
		this.ascending = ascending;
	}

	@Override
	public int compare(Object o1, Object o2) {
		StringTemplate st1 = (StringTemplate) o1;
		StringTemplate st2 = (StringTemplate) o2;
		if (st1 != null && st2 != null) {
			Integer i1 = order.get(st1.getAttribute("name"));
			if (i1 == null) {
				// at the beginning of the file
				i1 = Integer.MAX_VALUE;
			}
			Integer i2 = order.get(st2.getAttribute("name"));
			if (i2 == null) {
				// at the beginning of the file
				i2 = Integer.MAX_VALUE;
			}
			if (!ascending) {
				return i2 - i1;
			} else {
				return i1 - i2;
			}
		}
		return 0;
	}

}
