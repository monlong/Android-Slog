package com.monlong.slog.format;

import android.text.TextUtils;

/**
 * @ClassName: CharFormat
 * @Description: 普通字符格式化
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public class CharFormat extends LogFormat {

	@Override
	public String[] format(String log) {
		if (TextUtils.isEmpty(log)) {
			return new String[] {};
		}
		return log.split("\n");
	}
}
