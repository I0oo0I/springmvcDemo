package springmvcDemo.util;

import java.lang.reflect.Field;

import springmvcDemo.data.DataModel;
import springmvcDemo.data.DataModel2;

public class EqualsUtils {

	public static boolean equals(Object sources, Object target, String ... fields) {
		if(null == sources || null == target) {
			return false;
		}
		
		if(sources == target) {
			return true;
		}
		
		if(null != fields && fields.length > 0) {
			Class<?> sourceClass = sources.getClass();
			Class<?> targetClass = target.getClass();
			for(String field : fields) {
				try {
					//暂时，没有添加类型判断，200和200.00比较是有问题的
					Field filed = sourceClass.getDeclaredField(field);
					filed.setAccessible(true);
					String filedVaule = String.valueOf(filed.get(sources));
					
					Field filed2 = targetClass.getDeclaredField(field);
					filed2.setAccessible(true);
					String filedVaule2 = String.valueOf(filed2.get(target));
					
					if(! filedVaule.equals(filedVaule2)) {
						return false;
					}
					
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e ) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		DataModel model1 = new DataModel();
		model1.setId("1");
		model1.setName("花");
		model1.setAge("20");
		model1.setMoney("5000");
		DataModel2 model2 = new DataModel2();
		model2.setId("2");
		model2.setName("小红");
		model2.setAge(20);
		model2.setMoney(5000.0);
		System.out.println(equals(model1, model2, "money", "age"));
	}
}
