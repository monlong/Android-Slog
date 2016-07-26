package com.monlong.slog.config;

import java.util.Arrays;

/**
 * @ClassName: LogConfiguration
 * @Description: 日志打印配置
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public class LogConfiguration {

	/**
	 * 默认缩进字符长度
	 */
	public static final int DEFAULT_INDENT_SPACES = 2;

	/**
	 * 默认横向边框符号
	 */
	public static final String DEFAULT_HORIZONTAL_BORDER_CHAR = "═";

	/**
	 * 默认纵向边框符号
	 */
	public static final String DEFAULT_VERTICAL_BORDER_CHAR = "║";

	/**
	 * 默认顶部左角符号
	 */
	public static final String DEFAULT_TOP_CONNER = "╔";

	/**
	 * 默认底部左角符号
	 */
	public static final String DEFAULT_BOTTOM_CONNER = "╚";

	/**
	 * 默认横向符号长度
	 */
	public static final int DEFAULT_BORDER_LENGTH = 70;

	/**
	 * 是否显示边框
	 */
	private final boolean isShowBorder;

	/**
	 * 是否显示头部信息（类、方法、行数）
	 */
	private final boolean isShowHeader;

	/**
	 * 缩进字符数
	 */
	private final int indentSpaces;

	/**
	 * 横向边框线条符号
	 */
	private final String horizontalBorderChar;

	/**
	 * 垂直边框线条符号
	 */
	private final String verticalBorderChar;

	/**
	 * 顶部左角符号
	 */
	private String topConner;

	/**
	 * 底部左角符号
	 */
	private String bottomConner;

	/**
	 * 横向边框符号长度
	 */
	private final int borderLength;

	public LogConfiguration(Builder builder) {
		this.isShowBorder = builder.isShowBorder;
		this.isShowHeader = builder.isShowHeader;
		this.indentSpaces = builder.indentSpaces;
		this.horizontalBorderChar = builder.horizontalBorderChar;
		this.verticalBorderChar = builder.verticalBorderChar;
		this.borderLength = builder.borderLength;
		this.topConner = builder.topConner;
		this.bottomConner = builder.bottomConner;
	}

	public boolean isShowBorder() {
		return isShowBorder;
	}

	public boolean isShowHeader() {
		return isShowHeader;
	}

	/**
	 * 边框中内容缩进字符长度
	 * 
	 * @return
	 */
	public String indentSpaces() {
		char[] indentChars = new char[indentSpaces];
		Arrays.fill(indentChars, ' ');
		return new String(indentChars);
	}

	/**
	 * 左边边框字符
	 * 
	 * @return
	 */
	public String leftBorder() {
		return String.valueOf(verticalBorderChar);
	}

	/**
	 * 带左角字符的横向边框
	 * 
	 * @return
	 */
	public String topBorder() {
		StringBuilder builder = new StringBuilder(borderLength);
		builder.append(topConner);
		for (int i = 0; i < borderLength; i++) {
			builder.append(horizontalBorderChar);
		}
		return builder.toString();
	}

	/**
	 * 中间边框字符
	 * 
	 * @return
	 */
	public String middleBorder() {
		StringBuilder builder = new StringBuilder(borderLength);
		for (int i = 0; i < borderLength; i++) {
			builder.append(horizontalBorderChar);
		}
		return builder.toString();
	}

	/**
	 * 带左角符号的底部边框
	 * 
	 * @return
	 */
	public String bottomBorder() {
		StringBuilder builder = new StringBuilder(borderLength);
		builder.append(bottomConner);
		for (int i = 0; i < borderLength; i++) {
			builder.append(horizontalBorderChar);
		}
		return builder.toString();
	}

	public static class Builder {

		private boolean isShowBorder = true;
		private boolean isShowHeader = true;
		private String horizontalBorderChar = DEFAULT_HORIZONTAL_BORDER_CHAR;
		private String verticalBorderChar = DEFAULT_VERTICAL_BORDER_CHAR;
		private int borderLength = DEFAULT_BORDER_LENGTH;
		private int indentSpaces = DEFAULT_INDENT_SPACES;
		private String topConner = DEFAULT_TOP_CONNER;
		private String bottomConner = DEFAULT_BOTTOM_CONNER;

		public Builder showBorder(boolean isEnabled) {
			this.isShowBorder = isEnabled;
			return this;
		}

		public Builder showHeader(boolean isEnabled) {
			this.isShowHeader = isEnabled;
			return this;
		}

		public Builder indentSpaces(int indent) {
			this.indentSpaces = indent;
			return this;
		}

		public Builder horizontalBorderChar(String horizontalBorderChar) {
			this.horizontalBorderChar = horizontalBorderChar;
			return this;
		}

		public Builder verticalBorderChar(String verticalBorderChar) {
			this.verticalBorderChar = verticalBorderChar;
			return this;
		}

		public Builder topConner(String topConner) {
			this.topConner = topConner;
			return this;
		}

		public Builder bottomConner(String bottomConner) {
			this.bottomConner = bottomConner;
			return this;
		}

		public Builder borderLength(int borderLength) {
			this.borderLength = borderLength;
			return this;
		}

		public LogConfiguration build() {
			return new LogConfiguration(this);
		}
	}
}