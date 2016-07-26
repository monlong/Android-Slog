package com.monlong.slog.factory;

import com.monlong.slog.LogType;
import com.monlong.slog.format.CharFormat;
import com.monlong.slog.format.JsonFormat;
import com.monlong.slog.format.LogFormat;
import com.monlong.slog.format.XmlFormat;

/**
 * @ClassName: LogFactory
 * @Description: 日志格式化工厂
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public class LogFactory {

	/**
	 * 根据日志类型创建格式化工具
	 * 
	 * @param type
	 *            日志类型 {@link LogType}
	 * @return 格式化对象
	 */
	public static LogFormat create(LogType type) {
		switch (type) {
		case JSON:
			return new JsonFormat();
		case XML:
			return new XmlFormat();
		case CHAR:
			return new CharFormat();
		default:
			return new CharFormat();
		}
	}
}