package org.easyframeworks.examples;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.easyframeworks.base.dao.hibernate.IDictTypeDao;
import org.easyframeworks.base.entity.DictType;
import org.easyframeworks.utils.LoggerUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class exampleTest {

//	@Test
//	public void test() {
//		@SuppressWarnings("resource")
//		ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring-core-config.xml");
//		IDictGroupDao dao = (IDictGroupDao) appCtx.getBean("dictGroupDao");
////		LoggerUtils.info("DAO:" + dao);
////		String[] names = appCtx.getBeanDefinitionNames();
////		for(String name : names)
////		LoggerUtils.info("==========================:" + name);
//		DictType type = dao.getById(DictType.class, 2);
//		DictData dictDataNan = new DictData();
//		dictDataNan.setDictType(type);
//		dictDataNan.setName("男");
//		dictDataNan.setValue("1");
//		DictData dictDataNv = new DictData();
//		dictDataNv.setDictType(type);
//		dictDataNv.setName("女");
//		dictDataNv.setValue("0");
//		type.getDictDatas().add(dictDataNan);
//		type.getDictDatas().add(dictDataNv);
//		dao.updateEntity(type);
//	}
	@SuppressWarnings("resource")
	@Test
	public void testhql(){
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring-core-config.xml");
		IDictTypeDao dao = (IDictTypeDao) appCtx.getBean("dictTypeDao");
		List<DictType> types = dao.getByLikeProperty(DictType.class, "name", "类", "id", "DESC");
		/*解决非惰性加载主控方时，以子表数据条数显示记录，Set方式过滤*/
		Set<DictType> setTypes = new LinkedHashSet<DictType>(types);
		LoggerUtils.info("size:" + setTypes.size());
		for(DictType type : setTypes){
			LoggerUtils.info(type.getId() + "|" + type.getName() + "|" + type.getDictDatas().size());
		}
	}

}
