package com.taimei;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class FileUitl {

	/** 
	 * 将文件转成base64 字符串 
	 * @param path文件路径 
	 * @return  *  
	 * @throws Exception 
	 */

	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		;
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return new BASE64Encoder().encode(buffer);

	}

	/** 
	 * 将base64字符解码保存文件 
	 * @param base64Code 
	 * @param targetPath 
	 * @throws Exception 
	 */

	public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
		byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
		FileOutputStream out = new FileOutputStream(targetPath);
		out.write(buffer);
		out.close();

	}

	/** 
	 * 将base64字符保存文本文件 
	 * @param base64Code 
	 * @param targetPath 
	 * @throws Exception 
	 */

	public static void toFile(String base64Code, String targetPath) throws Exception {

		byte[] buffer = base64Code.getBytes();
		FileOutputStream out = new FileOutputStream(targetPath);
		out.write(buffer);
		out.close();
	}

	public static void main(String[] args) {
		try {
			/*	String base64Code = encodeBase64File("C:/Users/sasa.zhang/Desktop/a.zip");
				System.out.println(base64Code);
				decoderBase64File(base64Code, "D:/2.tif");
				toFile(base64Code, "D:\\three.txt");*/
			System.out.println("yyyy-MM-dd HH:mm:ss".length());
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
