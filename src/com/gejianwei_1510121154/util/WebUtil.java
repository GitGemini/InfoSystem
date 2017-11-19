package com.gejianwei_1510121154.util;

import java.lang.reflect.Field;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
		T t = null;
		try {
			t = (T) beanClass.newInstance();
			Enumeration<String> eur = request.getParameterNames();
			while(eur.hasMoreElements()) {
				String name = eur.nextElement();
				String value = request.getParameter(name);
				Field[] fields = beanClass.getDeclaredFields();
				for(Field f: fields) {
					if(f.getName().equals(name)) {
						f.setAccessible(true);
						f.set(t, value);
					}
				}
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return t;		
	}

}
