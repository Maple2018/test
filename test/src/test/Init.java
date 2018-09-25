package test;


import java.util.ArrayList;
import java.util.List;


public class Init {
	private String filePath = "resource/table.txt";


	public Init() {

	}

	public Init( String filePath) {
		if(!filePath.isEmpty()){
			this.filePath = filePath;
		}
	}

	public void excute() {
		System.out.println("Initializing file!");
		initFile();
	}

	/**
	 * 加载文件
	 */
	public void initFile() {
		String content = Util.readFile(filePath,"GB2312");
		List<createBiao> createBiaoList = new ArrayList<createBiao>();
		String[] tables = content.split("@");
		for(int x = 0;x<tables.length;x++){
			createBiao createBiao = new createBiao();
			List<biao> biaoList = new ArrayList<biao>();
			String tablecontent = tables[x];
			String[] array = tablecontent.split("\n");
			for (int i = 0; i < array.length; i++) {
				String[] contents = array[i].trim().split("\\s+");
				if(array[i].contains("TABLE")){
					for(int j = 0; j < contents.length; j++){
						if(contents[j].trim().contains("`")){
							String biaoName =contents[j].trim().substring(contents[j].trim().indexOf("`")+1,contents[j].trim().lastIndexOf("`"));
							createBiao.setBiaoName(biaoName);
						}
					}
				}else{
					if(contents[0].trim().contains("`")){
						biao biao = new biao();
						biao.setZiduan(contents[0].trim().substring(contents[0].trim().indexOf("`")+1,contents[0].trim().lastIndexOf("`")));
						biao.setZiduanleixing(contents[1].trim());
						if(array[i].contains("COMMENT")){
							biao.setZiduanhanyi(contents[contents.length-1].trim().substring(contents[contents.length-1].trim().indexOf("'")+1,contents[contents.length-1].trim().lastIndexOf("'")));
						}else{
							biao.setZiduanhanyi("");
						}
						if(array[i].contains("NOT NULL")){
							biao.setIsnull("Not null");
						}else{
							biao.setIsnull("");
						}
						biao.setZhujian("");
						biaoList.add(biao);
					}else{
						if(array[i].contains("COMMENT")){
							String biaoNameMs=contents[contents.length-1].trim().substring(contents[contents.length-1].trim().indexOf("'")+1,contents[contents.length-1].trim().lastIndexOf("'"));
							createBiao.setBiaoNameMs(biaoNameMs);
						}
						if(array[i].contains("PRIMARY")){
							String KEY=contents[contents.length-1].trim().substring(contents[contents.length-1].trim().indexOf("`")+1,contents[contents.length-1].trim().lastIndexOf("`"));
							createBiao.setKey(KEY);
						}
					}
				}
				createBiao.setBiaoList(biaoList);
			}
			createBiao.findKey();
			createBiaoList.add(createBiao);
		}
		createWord.createBiaoList = createBiaoList;
	}
}

