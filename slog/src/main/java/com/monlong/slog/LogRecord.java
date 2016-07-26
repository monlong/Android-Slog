package com.monlong.slog;

/**
 * @ClassName: LogRecord
 * @Description: 日志记录对象
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public class LogRecord {

	/**
	 * 等级
	 */
	private int level;

	/**
	 * 类型
	 */
	private LogType type;

	/**
	 * 标签
	 */
	private String tag;

	/**
	 * 内容
	 */
	private String message;

	/**
	 * 打印时间
	 */
	private long millis;

	/**
	 * 调用日志打印的类名称
	 */
	private String className;

	/**
	 * 调用日志打印所在类中方法名称
	 */
	private String methodName;

	/**
	 * 调用日志打印所在文件中名称
	 */
	private String fileName;

	/**
	 * 调用日志打印所在类中行数
	 */
	private long lineNumber;

	/**
	 * 当前调用打印日志的线程ID
	 */
	private long threadID;

	public LogRecord(int level, String tag, String msg) {
		this.tag = tag;
		this.level = level;
		this.message = msg;
		this.millis = System.currentTimeMillis();
		this.threadID = Thread.currentThread().getId();
		initSource();
	}

	/**
	 * 获取当前所在类信息
	 */
	private void initSource() {
		boolean sawLogger = false;
		for (StackTraceElement element : new Throwable().getStackTrace()) {
			String current = element.getClassName();
			if (current.startsWith(Slog.class.getName())) {
				sawLogger = true;
			} else if (sawLogger) {
				this.fileName = element.getFileName();
				this.className = element.getClassName();
				this.methodName = element.getMethodName();
				this.lineNumber = element.getLineNumber();
				break;
			}
		}
	}

	public LogType getType() {
		return type;
	}

	public void setType(LogType type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getMillis() {
		return millis;
	}

	public void setMillis(long millis) {
		this.millis = millis;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(long lineNumber) {
		this.lineNumber = lineNumber;
	}

	public long getThreadID() {
		return threadID;
	}

	public void setThreadID(long threadID) {
		this.threadID = threadID;
	}
}
