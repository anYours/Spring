package com.wl.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * Json���ݴ�������
 * 
 */
public class JsonUtil {

	/**
	 * Mapת��Json
	 * 
	 * @param map
	 * @return
	 */
	public static String toJson(Map<String, String> map) {
		Gson gson = new GsonBuilder().create();
		// Gson gson = new
		// GsonBuilder().enableComplexMapKeySerialization().create();
		String jsonStr = gson.toJson(map);
		return jsonStr;
	}

	/**
	 * Jsonת��Map
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static Map<String, String> toMap(String jsonStr) {
		Map<String, String> map;
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
				.create();
		map = gson.fromJson(jsonStr, new TypeToken<Map<String, String>>() {
		}.getType());
		return map;
	}

	/**
	 * Mapת��Json
	 * 
	 * @return
	 */
	public static String toJson(List<Map<String, String>> mapList) {
		Gson gson = new GsonBuilder().create();
		// Gson gson = new
		// GsonBuilder().enableComplexMapKeySerialization().create();
		String jsonStr = gson.toJson(mapList);
		return jsonStr;
	}

	/**
	 * Jsonת��Map
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static List<Map<String, String>> toMapList(String jsonStr) {
		Gson gson = new GsonBuilder().create();
		List<Map<String, String>> mapList = gson.fromJson(jsonStr,
				new TypeToken<ArrayList<Map<String, String>>>() {
				}.getType());
		return mapList;
	}
	
	public static Map<String, Object> toMapObject(String jsonStr) {
		Map<String, Object> map;
		Gson gson = new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, Object>>() {
		}.getType(), new MapTypeAdapter()).setDateFormat(DateFormatUtil.YYYYMMDDThhmmsssssZ).create();
		map = gson.fromJson(jsonStr, new TypeToken<Map<String, Object>>() {
		}.getType());
		return map;
	}

	/**
	 * ������ת�ɴ�����ĸ�ʽ,���ڸ�ʽ��yyyy-MM-dd HH:mm:ss.SSS
	 * @param map
	 * @return
	 */
	public static String toJsonOne(Map<String, Object> map) {
		Gson gson = new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, Object>>() {
		}.getType(), new MapTypeAdapter()).setDateFormat(DateFormatUtil.YYYYMMDDThhmmsssssZ).create();
		String jsonStr = gson.toJson(map).toString();
		return jsonStr;
	}
	
	public static List<Map<String, Object>> toMapListObject(String jsonStr) {
		List<Map<String, Object>> mapList;
		Gson gson = new GsonBuilder().registerTypeAdapter(new TypeToken<ArrayList<Map<String, Object>>>() {
		}.getType(), new MapTypeAdapter()).setDateFormat(DateFormatUtil.YYYYMMDDThhmmsssssZ).create();
		mapList = gson.fromJson(jsonStr, new TypeToken<ArrayList<Map<String, Object>>>() {
		}.getType());
		return mapList;
	}
	
	public static String toJsonMapList(List<Map<String, Object>> mapList) {
		Gson gson = new GsonBuilder().registerTypeAdapter(new TypeToken<ArrayList<Map<String, Object>>>() {
		}.getType(), new MapTypeAdapter()).setDateFormat(DateFormatUtil.YYYYMMDDThhmmsssssZ).create();
		String jsonStr = gson.toJson(mapList).toString();
		return jsonStr;
	}
	
	/**
	 * ��Json�ַ���ת��Ϊָ������
	 * @param jsonStr
	 * @param classOfT
	 * @return
	 */
	public static <T> T toObjectByJsonStr(String jsonStr, Class<T> classOfT){
		Gson gson = new GsonBuilder().registerTypeAdapter(new TypeToken<String>(){}.getType(),
				new MapTypeAdapter()).setDateFormat(DateFormatUtil.YYYYMMDDThhmmsssssZ).create();
		T t = gson.fromJson(jsonStr, classOfT);
		return t;
	}
	
	public static class MapTypeAdapter extends TypeAdapter<Object> {

		@Override
		public Object read(JsonReader in) throws IOException {
			JsonToken token = in.peek();
			switch (token) {
			case BEGIN_ARRAY:
				List<Object> list = new ArrayList<Object>();
				in.beginArray();
				while (in.hasNext()) {
					list.add(read(in));
				}
				in.endArray();
				return list;

			case BEGIN_OBJECT:
				Map<String, Object> map = new LinkedTreeMap<String, Object>();
				in.beginObject();
				while (in.hasNext()) {
					map.put(in.nextName(), read(in));
				}
				in.endObject();
				return map;

			case STRING:
				return in.nextString();

			case NUMBER:
				/**
				 * ��д���ֵĴ����߼���������ֵ��Ϊ�����븡���͡�
				 */
				double dbNum = in.nextDouble();

				// ���ֳ���long�����ֵ�����ظ�������
				if (dbNum > Integer.MAX_VALUE) {
					return dbNum;
				}

				// �ж������Ƿ�Ϊ����ֵ
				int lngNum = (int) dbNum;
				if (dbNum == lngNum) {
					return lngNum;
				} else {
					return dbNum;
				}

			case BOOLEAN:
				return in.nextBoolean();

			case NULL:
				in.nextNull();
				return null;

			default:
				throw new IllegalStateException();
			}
		}

		@Override
		public void write(JsonWriter out, Object value) throws IOException {
			// ���л�����ʵ��
		}

	}
	
}
