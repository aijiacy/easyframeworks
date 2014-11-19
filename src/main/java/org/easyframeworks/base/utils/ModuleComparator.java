package org.easyframeworks.base.utils;

import java.util.Comparator;

import org.easyframeworks.base.entity.Module;

public class ModuleComparator implements Comparator<Module> {

	
	@Override
	public int compare(Module one, Module two) {
		return one.getSort() > two.getSort() ? 1 : (one.getSort() < two.getSort() ? -1 : 0);
	}

}
