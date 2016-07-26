package com.monlong.slog.format;

/**
 * @ClassName: LogFormat
 * @Description: 日志格式化抽象类
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public abstract class LogFormat {

    /**
     * 日志如何格式化由子类实现，父类提供统一入口
     *
     * @param msg 需要打印的消息内容
     * @return 日志消息数组（由于控制台一行文字字数限制需要换行打印）
     */
    public abstract String[] format(String msg);
}
