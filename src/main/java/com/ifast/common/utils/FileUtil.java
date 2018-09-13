package com.ifast.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

public class FileUtil {

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static String renameToUUID(String fileName) {
		return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	/**
	 * 获取向浏览器输出的文件名称
	 * @param request
	 * @param fileName
	 * @return
	 */
	public static String getOutPutFileName(HttpServletRequest request, String fileName){
		String userAgent=request.getHeader("User-Agent");
		//针对IE或者以IE为内核的浏览器：
		//非IE浏览器的处理：
		try {
			if(userAgent.contains("MSIE")||userAgent.contains("Trident")) {
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			} else {
				fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fileName="";
		}
		return fileName;
	}

	/**
	 * 向网页输出文件
	 * @param request
	 * @param response
	 * @param fileName 文件名
	 */
	public static void writeFj(HttpServletRequest request, HttpServletResponse response, String fileName, InputStream in){
		OutputStream out=null;
		try {
			response.reset();
			response.setContentType("multipart/form-data");
			fileName=getOutPutFileName(request, fileName);
			// 设置输出的格式
			try {
				response.setHeader("Content-Disposition","attachment;filename="+fileName);
			} catch (Exception e) {
				response.setHeader("Content-Disposition","attachment;filename="+fileName);
				e.printStackTrace();
			}
			// 循环取出流中的数据
			out=response.getOutputStream();
			byte[] buffer = new byte[1024];
			int r;
			while ((r = in.read(buffer)) >= 0) {
				out.write(buffer,0,r);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(out!=null){
					out.close();
				}
				if(in!=null){
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
