package test;

import java.util.List;

public class createBiao {
	private  List<biao> biaoList;
	private  String  biaoName;
	private  String  biaoNameMs;
	private  String  key;
	
	public List<biao> getBiaoList() {
		return biaoList;
	}
	public void setBiaoList(List<biao> biaoList) {
		this.biaoList = biaoList;
	}
	public String getBiaoName() {
		return biaoName;
	}
	public void setBiaoName(String biaoName) {
		this.biaoName = biaoName;
	}
	public String getBiaoNameMs() {
		return biaoNameMs;
	}
	public void setBiaoNameMs(String biaoNameMs) {
		this.biaoNameMs = biaoNameMs;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public void findKey(){
		for(int i =0 ;i<biaoList.size();i++){
			biao biao = biaoList.get(i);
			if(biao.getZiduan().equals(key)){
				biao.setZhujian("Ö÷¼ü");
				break;
			}
		}
	}

}
