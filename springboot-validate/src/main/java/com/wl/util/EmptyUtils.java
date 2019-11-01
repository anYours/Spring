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
     * �ж϶����Ƿ�Ϊ��
     *
     * @param obj ����
     * @return {@code true}: Ϊ��<br>{@code false}: ��Ϊ��
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
     * �ж϶����Ƿ�Ϊ��(�������0Ҳ�ᱻ��Ϊ�ǿ�)
     *
     * @param obj ����
     * @return {@code true}: Ϊ��<br>{@code false}: ��Ϊ��
     */
	public static boolean isEmptyInclue0(Object obj) {
    	boolean flag = isEmpty(obj);
        if(obj.equals(0)){
        	flag = true;
        }
        return flag;
    }

    /**
     * �ж϶����Ƿ�ǿ�
     *
     * @param obj ����
     * @return {@code true}: �ǿ�<br>{@code false}: ��
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
