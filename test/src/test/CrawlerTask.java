package test;

public class CrawlerTask {
	
	private static String filepath = "";
	private static String newfilepath = "";
	public static void main(String[] args) {
		
		//加载需要的文件
		Init init = new Init(filepath);
		init.excute();
		//生成word文档
		createWord createWord = new createWord(newfilepath);
		createWord.excute();
	}

}
