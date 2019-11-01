package com.wl.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
/**
 * 
 * @author zhangmh
 *
 */
public class EmptyUtils {

    private EmptyUtils() {
    }

    /**
     * 判断对象是否为空
     *
     * @param obj 对象
     * @return {@code true}: 为空<br>{@code false}: 不为空
     */
    @SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String && obj.toString().trim().length() == 0) {
            return true;
        }
        if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            return true;
        }
        if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        }
        if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        }
        return false;
    }
    
    /**
     * 判断对象是否为空(这个方法0也会被认为是空)
     *
     * @param obj 对象
     * @return {@code true}: 为空<br>{@code false}: 不为空
     */
	public static boolean isEmptyInclue0(Object obj) {
    	boolean flag = isEmpty(obj);
        if(obj.equals(0)){
        	flag = true;
        }
        return flag;
    }

    /**
     * 判断对象是否非空
     *
     * @param obj 对象
     * @return {@code true}: 非空<br>{@code false}: 空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
