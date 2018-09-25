package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class createWord {
	public static List<createBiao> createBiaoList;
	private String filePath = "resource/create_table.docx";


	public createWord(String filePath){
		if(!filePath.isEmpty()){
			this.filePath = filePath;
		}
		
	}
	public void excute() {
		System.out.println("create File!");
		createFile();
	}
	/**
	 * 生成文件
	 */
	public void createFile() {
		try {
			XWPFDocument document = new XWPFDocument();
			FileOutputStream out;
			File f = new File(filePath);
			out = new FileOutputStream(f);
			for(int i =0 ;i<createBiaoList.size();i++){
				createBiao createBiao = createBiaoList.get(i);
				document = createTxt(document, createBiao);
				document = createTable(document, createBiao);
			}
			document.write(out);
	    	out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("create_table.docx written successully");
	}
	
	public XWPFDocument createTable(XWPFDocument document,createBiao createBiao) {
		XWPFTable table = document.createTable();
		table.setWidth(1000);
		
		XWPFTableRow tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("字段");
		tableRowOne.addNewTableCell().setText("字段含义");
		tableRowOne.addNewTableCell().setText("主键/外键");
		tableRowOne.addNewTableCell().setText("字段类型");
		tableRowOne.addNewTableCell().setText("是否为空");

		for(int i = 0;i<createBiao.getBiaoList().size();i++){
			XWPFTableRow tableRow = table.createRow();
			biao biao = createBiao.getBiaoList().get(i);
			tableRow.getCell(0).setText(biao.getZiduan());
			tableRow.getCell(1).setText(biao.getZiduanhanyi());
			tableRow.getCell(2).setText(biao.getZhujian());
			tableRow.getCell(3).setText(biao.getZiduanleixing());
			tableRow.getCell(4).setText(biao.getIsnull());
		}
		   return document;
	}

	
	public XWPFDocument createTxt(XWPFDocument document,createBiao createBiao) {
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		String s = createBiao.getBiaoNameMs()+":"+createBiao.getBiaoName();
		run.setText(s);
		run.setTextPosition(35);//设置行间距
        run.setBold(true);//加粗
        run.setFontFamily("宋体");//字体
        run.setFontSize(12);//字体大小
        return document;
	}
}
