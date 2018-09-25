package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Util {


	/**
	 * 复制整个文件夹内容
	 */
	public static void copyFolder(String oldPath, String newPath) {
		try {
			File oldfile = new File(oldPath);
			if (!oldfile.exists()) {
				System.out.println("复制整个文件夹内容操作出错,文件路径不存在：" + oldPath);
			}
			File newfile = new File(newPath);
			if (!newfile.exists()) {
				newfile.mkdirs();
			}
			FileUtils.copyDirectory(oldfile, newfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 复制单个文件
	 */
	public static void copyFile(String oldPath, String newPath) {
		try {
			String mkdpath = newPath.substring(0, newPath.lastIndexOf(File.separator));
			File mkdfile = new File(mkdpath);
			if (!mkdfile.exists()) {
				mkdfile.mkdirs();
			}
			File oldfile = new File(oldPath);
			if (!oldfile.exists()) {
				System.out.println("复制单个文件操作出错,文件路径不存在：" + oldPath);
			}
			File newfile = new File(newPath);
			if (!newfile.exists()) {
				newfile.createNewFile();
			}
			FileUtils.copyFile(oldfile, newfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写文件
	 */
	@SuppressWarnings("deprecation")
	public static void writeFile(String path, String content,boolean isreplace) {
		try {
			File file = new File(path);
			if (!isreplace) {
				FileUtils.write(file, content, true);
			} else {
				file.createNewFile();
				FileUtils.write(file, content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读文件
	 */
	public static String readFile(String path,String code) {
		String content = null;
		try {
			File file = new File(path);
			if (!file.exists()) {
				System.out.println("文件路径不存在：" + path);
			}
			content = FileUtils.readFileToString(file, code);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * 删除文件夹
	 */
	public static void deleteAllFilesOfDir(File path) {  
	    if (!path.exists())  
	        return;  
	    if (path.isFile()) {  
	        path.delete();  
	        return;  
	    }  
	    File[] files = path.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        deleteAllFilesOfDir(files[i]);  
	    }  
	    path.delete();  
	}  
	

}
