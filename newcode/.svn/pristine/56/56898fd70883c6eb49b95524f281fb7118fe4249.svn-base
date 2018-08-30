package com.dpm.unity.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FileUtils {
	private static Logger logger = LoggerFactory.getLogger(FileUtils.class);
	private static final String FTLBASEPATH = "templates/ftl/";
	public static final String SQWTS_SUFFIX = "sqwts.docx";
	public static final String FTL_SQWTS = "sqwts.ftl";

	/**
	 * 生成word文件
	 * 
	 * @param dataMap
	 *            word中需要展示的动态数据，用map集合来保存
	 * @param templateName
	 *            word模板名称，例如：test.ftl
	 * @param filePath
	 *            文件生成的目标路径，例如：D:/wordFile/
	 * @param fileName
	 *            生成的文件名称，例如：test.doc
	 */
	@SuppressWarnings({ "deprecation" })
	public static File createWord(Map<String,Object> dataMap, String templateName) {
		// 输出文件
		File outFile = null;
		try {
			// 创建配置实例
			Configuration configuration = new Configuration();

			// 设置编码
			configuration.setDefaultEncoding("UTF-8");

			// ftl模板文件
			configuration.setClassForTemplateLoading(FileUtils.class, "/");

			// 获取模板
			Template template = configuration.getTemplate(FTLBASEPATH + templateName);

			// 输出文件
			outFile = File.createTempFile("tmp", SQWTS_SUFFIX);

			// 如果输出目标文件夹不存在，则创建
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			
			Writer w = new OutputStreamWriter(new FileOutputStream(outFile), "utf-8");  
			template.process(dataMap, w);

			outFile.deleteOnExit();
			
		} catch (Exception e) {
			logger.error("创建word失败", e);
		}
		return outFile;
	}
	
}
