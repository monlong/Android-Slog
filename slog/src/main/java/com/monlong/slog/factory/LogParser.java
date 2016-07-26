package com.monlong.slog.factory;

import com.monlong.slog.LogType;
import com.monlong.slog.format.LogFormat;
import com.monlong.slog.utils.Utils;

/**
 * @ClassName: LogParser
 * @Description: 日志格式化
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public class LogParser {

    public static LogFormat parser(String msg) {
        LogType logType;
        if (Utils.isJson(msg)) { // JSON
            logType = LogType.JSON;
        } else if (Utils.isXml(msg)) { // XML
            logType = LogType.XML;
        } else { // CHAR
            logType = LogType.CHAR;
        }
        return LogFactory.create(logType);
    }
}
