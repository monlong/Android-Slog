package com.monlong.slog;

import android.text.TextUtils;

import com.monlong.slog.config.LogConfiguration;
import com.monlong.slog.printer.LogPrinter;
import com.monlong.slog.printer.Printer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/**
 * @ClassName: Slog
 * @Description: 全局日志信息打印工具类
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public final class Slog {

    /**
     * 调用无TAG方法打印日志时使用的默认标签（全局）
     */
    private static final String TAG = "Slog";

    /**
     * 是否需要开启打印日志功能标示（全局）, 可手动设置
     */
    private static boolean isDebug = true;

    /**
     * 日志信息打印类
     */
    private static final Printer sPrinter = new LogPrinter();

    /**
     * 日志打印配置信息
     */
    private static LogConfiguration sConfiguration;

    private Slog() {
    }

    public static void init(LogConfiguration configuration) {
        Slog.sConfiguration = configuration;
    }

    public static void setDebug(boolean isDebug) {
        Slog.isDebug = isDebug;
    }

    // verbose
    public static void v(String msg) {
        print_console(LogLevel.VERBOSE, TAG, msg);
    }

    public static void v(String tag, String msg) {
        print_console(LogLevel.VERBOSE, tag, msg);
    }

    public static void v(int i) {
        print_console(LogLevel.VERBOSE, TAG, String.valueOf(i));
    }

    public static void v(String tag, int i) {
        print_console(LogLevel.VERBOSE, tag, String.valueOf(i));
    }

    public static void v(long l) {
        print_console(LogLevel.VERBOSE, TAG, String.valueOf(l));
    }

    public static void v(String tag, long l) {
        print_console(LogLevel.VERBOSE, tag, String.valueOf(l));
    }

    public static void v(float f) {
        print_console(LogLevel.VERBOSE, TAG, String.valueOf(f));
    }

    public static void v(String tag, float f) {
        print_console(LogLevel.VERBOSE, tag, String.valueOf(f));
    }

    public static void v(double d) {
        print_console(LogLevel.VERBOSE, TAG, String.valueOf(d));
    }

    public static void v(String tag, double d) {
        print_console(LogLevel.VERBOSE, tag, String.valueOf(d));
    }

    public static void v(char c) {
        print_console(LogLevel.VERBOSE, TAG, String.valueOf(c));
    }

    public static void v(String tag, char c) {
        print_console(LogLevel.VERBOSE, tag, String.valueOf(c));
    }

    public static void v(char[] chars) {
        print_console(LogLevel.VERBOSE, TAG, new String(chars,
                0, chars.length));
    }

    public static void v(String tag, char[] chars) {
        print_console(LogLevel.VERBOSE, tag, new String(chars,
                0, chars.length));
    }

    public static void v(Object o) {
        print_console(LogLevel.VERBOSE, TAG, String.valueOf(o));
    }

    public static void v(String tag, Object o) {
        print_console(LogLevel.VERBOSE, tag, String.valueOf(o));
    }

    public static void v(boolean b) {
        print_console(LogLevel.VERBOSE, TAG, String.valueOf(b));
    }

    public static void v(String tag, boolean b) {
        print_console(LogLevel.VERBOSE, tag, String.valueOf(b));
    }

    public static void v(Throwable tr) {
        print_console(LogLevel.VERBOSE, TAG, getStackTraceString(tr));
    }

    public static void v(String tag, Throwable tr) {
        print_console(LogLevel.VERBOSE, tag, getStackTraceString(tr));
    }

    // debug
    public static void d(String msg) {
        print_console(LogLevel.DEBUG, TAG, msg);
    }

    public static void d(String tag, String msg) {
        print_console(LogLevel.DEBUG, tag, msg);
    }

    public static void d(int i) {
        print_console(LogLevel.DEBUG, TAG, String.valueOf(i));
    }

    public static void d(String tag, int i) {
        print_console(LogLevel.DEBUG, tag, String.valueOf(i));
    }

    public static void d(long l) {
        print_console(LogLevel.DEBUG, TAG, String.valueOf(l));
    }

    public static void d(String tag, long l) {
        print_console(LogLevel.DEBUG, tag, String.valueOf(l));
    }

    public static void d(float f) {
        print_console(LogLevel.DEBUG, TAG, String.valueOf(f));
    }

    public static void d(String tag, float f) {
        print_console(LogLevel.DEBUG, tag, String.valueOf(f));
    }

    public static void d(double d) {
        print_console(LogLevel.DEBUG, TAG, String.valueOf(d));
    }

    public static void d(String tag, double d) {
        print_console(LogLevel.DEBUG, tag, String.valueOf(d));
    }

    public static void d(char c) {
        print_console(LogLevel.DEBUG, TAG, String.valueOf(c));
    }

    public static void d(String tag, char c) {
        print_console(LogLevel.DEBUG, tag, String.valueOf(c));
    }

    public static void d(char[] chars) {
        print_console(LogLevel.DEBUG, TAG, new String(chars, 0,
                chars.length));
    }

    public static void d(String tag, char[] chars) {
        print_console(LogLevel.DEBUG, tag, new String(chars, 0,
                chars.length));
    }

    public static void d(Object o) {
        print_console(LogLevel.DEBUG, TAG, String.valueOf(o));
    }

    public static void d(String tag, Object o) {
        print_console(LogLevel.DEBUG, tag, String.valueOf(o));
    }

    public static void d(boolean b) {
        print_console(LogLevel.DEBUG, TAG, String.valueOf(b));
    }

    public static void d(String tag, boolean b) {
        print_console(LogLevel.DEBUG, tag, String.valueOf(b));
    }

    public static void d(Throwable tr) {
        print_console(LogLevel.DEBUG, TAG, getStackTraceString(tr));
    }

    public static void d(String tag, Throwable tr) {
        print_console(LogLevel.DEBUG, tag, getStackTraceString(tr));
    }

    // info
    public static void i(String msg) {
        print_console(LogLevel.INFO, TAG, msg);
    }

    public static void i(String tag, String msg) {
        print_console(LogLevel.INFO, tag, msg);
    }

    public static void i(int i) {
        print_console(LogLevel.INFO, TAG, String.valueOf(i));
    }

    public static void i(String tag, int i) {
        print_console(LogLevel.INFO, tag, String.valueOf(i));
    }

    public static void i(long l) {
        print_console(LogLevel.INFO, TAG, String.valueOf(l));
    }

    public static void i(String tag, long l) {
        print_console(LogLevel.INFO, tag, String.valueOf(l));
    }

    public static void i(float f) {
        print_console(LogLevel.INFO, TAG, String.valueOf(f));
    }

    public static void i(String tag, float f) {
        print_console(LogLevel.INFO, tag, String.valueOf(f));
    }

    public static void i(double d) {
        print_console(LogLevel.INFO, TAG, String.valueOf(d));
    }

    public static void i(String tag, double d) {
        print_console(LogLevel.INFO, tag, String.valueOf(d));
    }

    public static void i(char c) {
        print_console(LogLevel.INFO, TAG, String.valueOf(c));
    }

    public static void i(String tag, char c) {
        print_console(LogLevel.INFO, tag, String.valueOf(c));
    }

    public static void i(char[] chars) {
        print_console(LogLevel.INFO, TAG, new String(chars, 0,
                chars.length));
    }

    public static void i(String tag, char[] chars) {
        print_console(LogLevel.INFO, tag, new String(chars, 0,
                chars.length));
    }

    public static void i(Object o) {
        print_console(LogLevel.INFO, TAG, String.valueOf(o));
    }

    public static void i(String tag, Object o) {
        print_console(LogLevel.INFO, tag, String.valueOf(o));
    }

    public static void i(boolean b) {
        print_console(LogLevel.INFO, TAG, String.valueOf(b));
    }

    public static void i(String tag, boolean b) {
        print_console(LogLevel.INFO, tag, String.valueOf(b));
    }

    public static void i(Throwable tr) {
        print_console(LogLevel.INFO, TAG, getStackTraceString(tr));
    }

    public static void i(String tag, Throwable tr) {
        print_console(LogLevel.INFO, tag, getStackTraceString(tr));
    }

    // warn
    public static void w(String msg) {
        print_console(LogLevel.WARN, TAG, msg);
    }

    public static void w(String tag, String msg) {
        print_console(LogLevel.WARN, tag, msg);
    }

    public static void w(int i) {
        print_console(LogLevel.WARN, TAG, String.valueOf(i));
    }

    public static void w(String tag, int i) {
        print_console(LogLevel.WARN, tag, String.valueOf(i));
    }

    public static void w(long l) {
        print_console(LogLevel.WARN, TAG, String.valueOf(l));
    }

    public static void w(String tag, long l) {
        print_console(LogLevel.WARN, tag, String.valueOf(l));
    }

    public static void w(float f) {
        print_console(LogLevel.WARN, TAG, String.valueOf(f));
    }

    public static void w(String tag, float f) {
        print_console(LogLevel.WARN, tag, String.valueOf(f));
    }

    public static void w(double d) {
        print_console(LogLevel.WARN, TAG, String.valueOf(d));
    }

    public static void w(String tag, double d) {
        print_console(LogLevel.WARN, tag, String.valueOf(d));
    }

    public static void w(char c) {
        print_console(LogLevel.WARN, TAG, String.valueOf(c));
    }

    public static void w(String tag, char c) {
        print_console(LogLevel.WARN, tag, String.valueOf(c));
    }

    public static void w(char[] chars) {
        print_console(LogLevel.WARN, TAG, new String(chars, 0,
                chars.length));
    }

    public static void w(String tag, char[] chars) {
        print_console(LogLevel.WARN, tag, new String(chars, 0,
                chars.length));
    }

    public static void w(Object o) {
        print_console(LogLevel.WARN, TAG, String.valueOf(o));
    }

    public static void w(String tag, Object o) {
        print_console(LogLevel.WARN, tag, String.valueOf(o));
    }

    public static void w(boolean b) {
        print_console(LogLevel.WARN, TAG, String.valueOf(b));
    }

    public static void w(String tag, boolean b) {
        print_console(LogLevel.WARN, tag, String.valueOf(b));
    }

    public static void w(Throwable tr) {
        print_console(LogLevel.WARN, TAG, getStackTraceString(tr));
    }

    public static void w(String tag, Throwable tr) {
        print_console(LogLevel.WARN, tag, getStackTraceString(tr));
    }

    // error
    public static void e(String msg) {
        print_console(LogLevel.ERROR, TAG, msg);
    }

    public static void e(String tag, String msg) {
        print_console(LogLevel.ERROR, tag, msg);
    }

    public static void e(int i) {
        print_console(LogLevel.ERROR, TAG, String.valueOf(i));
    }

    public static void e(String tag, int i) {
        print_console(LogLevel.ERROR, tag, String.valueOf(i));
    }

    public static void e(long l) {
        print_console(LogLevel.ERROR, TAG, String.valueOf(l));
    }

    public static void e(String tag, long l) {
        print_console(LogLevel.ERROR, tag, String.valueOf(l));
    }

    public static void e(float f) {
        print_console(LogLevel.ERROR, TAG, String.valueOf(f));
    }

    public static void e(String tag, float f) {
        print_console(LogLevel.ERROR, tag, String.valueOf(f));
    }

    public static void e(double d) {
        print_console(LogLevel.ERROR, TAG, String.valueOf(d));
    }

    public static void e(String tag, double d) {
        print_console(LogLevel.ERROR, tag, String.valueOf(d));
    }

    public static void e(char c) {
        print_console(LogLevel.ERROR, TAG, String.valueOf(c));
    }

    public static void e(String tag, char c) {
        print_console(LogLevel.ERROR, tag, String.valueOf(c));
    }

    public static void e(char[] chars) {
        print_console(LogLevel.ERROR, TAG, new String(chars, 0,
                chars.length));
    }

    public static void e(String tag, char[] chars) {
        print_console(LogLevel.ERROR, tag, new String(chars, 0,
                chars.length));
    }

    public static void e(Object o) {
        print_console(LogLevel.ERROR, TAG, String.valueOf(o));
    }

    public static void e(String tag, Object o) {
        print_console(LogLevel.ERROR, tag, String.valueOf(o));
    }

    public static void e(boolean b) {
        print_console(LogLevel.ERROR, TAG, String.valueOf(b));
    }

    public static void e(String tag, boolean b) {
        print_console(LogLevel.ERROR, tag, String.valueOf(b));
    }

    public static void e(Throwable tr) {
        print_console(LogLevel.ERROR, TAG, getStackTraceString(tr));
    }

    public static void e(String tag, Throwable tr) {
        print_console(LogLevel.ERROR, tag, getStackTraceString(tr));
    }

    /**
     * 将异常对象转换成字符串
     *
     * @param tr
     * @return
     */
    private static String getStackTraceString(Throwable tr) {
        if (tr == null) {
            return "";
        }

        Throwable t = tr;
        while (t != null) {
            if (t instanceof UnknownHostException) {
                return "";
            }
            t = t.getCause();
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }

    /**
     * 控制台打印
     *
     * @param level 打印等级
     * @param tag   打印标签
     * @param msg   打印消息
     */
    private static void print_console(int level, String tag, String msg) {
        if (isDebug) {
            if (sConfiguration == null) {
                sConfiguration = new LogConfiguration.Builder().build();
            }

            // TAG空判断
            tag = TextUtils.isEmpty(tag) ? TAG : tag;
            LogRecord logRecord = new LogRecord(level, tag, msg);
            sPrinter.print(logRecord, sConfiguration);
        }
    }
}
