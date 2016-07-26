package com.monlong.slog.format;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @ClassName: JsonFormat
 * @Description: Json格式化
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public class JsonFormat extends LogFormat {

	/**
	 * 层级之间缩进字符数量
	 */
	private static final int INDENT_SPACE = 4;

	/**
	 * JSON对象起始标签字符
	 */
	private static final String OBJECT_PREFIX = "{";

	/**
	 * JSON数组起始标签字符
	 */
	private static final String ARRAY_PREFIX = "[";

	/**
	 * 换行符
	 */
	public static final String LINE_SEPARATOR = "\n";

	@Override
	public String[] format(String log) {
		if (TextUtils.isEmpty(log)) {
			return new String[] {};
		}
		try {
			if (log.startsWith(OBJECT_PREFIX)) {
				JSONObject object = new JSONObject(log);
				log = object.toString(INDENT_SPACE);
			}
			if (log.startsWith(ARRAY_PREFIX)) {
				JSONArray array = new JSONArray(log);
				log = array.toString(INDENT_SPACE);
			}
			return log.split(LINE_SEPARATOR);
		} catch (JSONException e) {
		}
		return new String[] { log };
	}
}
