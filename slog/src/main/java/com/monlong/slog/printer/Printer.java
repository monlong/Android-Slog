package com.monlong.slog.printer;

import com.monlong.slog.LogRecord;
import com.monlong.slog.config.LogConfiguration;

/**
 * @ClassName: Printer
 * @Description: 日志打印类
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public abstract class Printer {

    /**
     * 日志打印
     *
     * @param logRecord 日志对象（内容、时间、类名、方法名等）
     * @param config    打印配置
     */
    public abstract void print(LogRecord logRecord, LogConfiguration config);
}
