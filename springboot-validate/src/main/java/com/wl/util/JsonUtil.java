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
 * Json数据处理工具类
 * 
 */
public class JsonUtil {

	/**
	 * Map转成Json
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
	 * Json转成Map
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
	 * Map转成Json
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
	 * Json转成Map
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
	 * 将日期转成带毫秒的格式,日期格式：yyyy-MM-dd HH:mm:ss.SSS
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
	 * 将Json字符串转换为指定对象
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
				 * 改写数字的处理逻辑，将数字值分为整型与浮点型。
				 */
				double dbNum = in.nextDouble();

				// 数字超过long的最大值，返回浮点类型
				if (dbNum > Integer.MAX_VALUE) {
					return dbNum;
				}

				// 判断数字是否为整数值
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
			// 序列化无需实现
		}

	}
	
}
