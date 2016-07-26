package com.monlong.slog.printer;

import com.monlong.slog.LogRecord;
import com.monlong.slog.config.LogConfiguration;
import com.monlong.slog.factory.LogParser;
import com.monlong.slog.format.LogFormat;

/**
 * @ClassName: LogPrinter
 * @Description: 日志打印
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public class LogPrinter extends Printer {

    @Override
    public void print(LogRecord record, LogConfiguration config) {
        StringBuilder builder = new StringBuilder();

        // 顶部边框
        if (config.isShowBorder()) {
            println(record, config.topBorder());
        }

        // 类、方法、行信息
        if (config.isShowHeader()) {
            if (config.isShowBorder()) {
                builder.append(config.leftBorder());
                builder.append(config.indentSpaces());
            }
            builder.append(record.getClassName());
            builder.append(".");
            builder.append(record.getMethodName());
            builder.append("(");
            builder.append(record.getFileName());
            builder.append(":");
            builder.append(record.getLineNumber());
            builder.append(")");
            println(record, builder.toString());
        }

        // 分割线
        if (config.isShowBorder()) {
            println(record, config.leftBorder() + config.middleBorder());
        }

        // 消息内容
        LogFormat format = LogParser.parser(record.getMessage());
        String[] messages = format.format(record.getMessage());
        for (int i = 0; i < messages.length; i++) {
            builder.delete(0, builder.length());
            if (config.isShowBorder()) {
                builder.append(config.leftBorder());
                builder.append(config.indentSpaces());
            }
            builder.append(messages[i]);
            println(record, builder.toString());
        }

        // 底部边框
        if (config.isShowBorder()) {
            println(record, config.bottomBorder());
        }
    }

    private void println(LogRecord record, String msg) {
        android.util.Log.println(record.getLevel(), record.getTag(), msg);
    }
}
