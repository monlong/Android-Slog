package com.monlong.slog.format;

import android.text.TextUtils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @ClassName: XmlFormat
 * @Description: Xml格式化
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public class XmlFormat extends LogFormat {

	/**
	 * 层级之间缩进字符数量
	 */
	private static final String INDENT_SPACE = "4";

	private static final String INDENT_AMOUNT = "{http://xml.apache.org/xslt}indent-amount";

	@Override
	public String[] format(String xml) {
		if (TextUtils.isEmpty(xml)) {
			return new String[] {};
		}
		try {
			Source xmlInput = new StreamSource(new StringReader(xml));
			StreamResult xmlOutput = new StreamResult(new StringWriter());
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(INDENT_AMOUNT, INDENT_SPACE);
			transformer.transform(xmlInput, xmlOutput);
			String out = xmlOutput.getWriter().toString().replaceFirst(">", ">\n");
			return out.split("\n");
		} catch (Exception e) {
		}
		return new String[] { xml };
	}
}
