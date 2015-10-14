package org.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {

	@SuppressWarnings("rawtypes")
	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {

		try {
			T t = clazz.newInstance();

			// ConvertUtils.register(new DateLocaleConverter(), Date.class);
			ConvertUtils.register(new Converter() {

				// 回调方法

				@Override
				public Object convert(Class type, Object value) {
					if (value == null) {
						return null;
					}
					// 转换为String
					String data = (String) value;
					// 将指定格式的字符串转换为Date
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date date = null;
					try {
						date = format.parse(data);
						return date;
					} catch (ParseException e) {
						e.printStackTrace();
						return null;
					}
				}
			}, Date.class);
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				if (value != null && !"".equals(value)) {
					BeanUtils.setProperty(t, name, value);
				}
			}
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static String makeId() {
		return UUID.randomUUID().toString();
	}
}
