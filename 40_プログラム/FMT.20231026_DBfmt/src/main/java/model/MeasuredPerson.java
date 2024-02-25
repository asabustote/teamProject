package model;

import java.io.Serializable;

public class MeasuredPerson implements Serializable {
	
	private String kana = "";  //ふりがな
	private String name = "";  //氏名
	private String kind = "";  //性別
	private int    age;    //年齢
	private String writtenBy = "";  //記入者		
	private double	ordinaryShoesSize; //通常時の靴のサイズ
	private int    height;//身長
	private int    bodyWeight;  //体重
	private String measuredDate;  //測定日
	
	
	//Think:足測定情報もここに持たせるか検討 Oct.11th.23
//	private LeftFoot;
//	private RightFoot;
	
	public MeasuredPerson () {}
	
	public MeasuredPerson (String kana, 
						   String name, 
						   String kind, 
						   int age, 
						   String writtenBy, 
						   double ordinaryShoesSize, 
						   int height, 
						   int bodyWeight,
						   String measuredDate) {
		
	this.kana = kana;
	this.name = name;
	this.kind = kind;
	this.age = age;
	this.writtenBy = writtenBy;
	this.ordinaryShoesSize = ordinaryShoesSize;
	this.height = height;
	this.bodyWeight = bodyWeight;
	this.measuredDate = measuredDate;
	}


	public String getKana() {
		return kana;
	}


	public String getName() {
		return name;
	}


	public String getKind() {
		return kind;
	}


	public String getWrittenBy() {
		return writtenBy;
	}


	public int getAge() {
		return age;
	}


//	public double getOrdinaryShoesSize() {
//		return ordinaryShoesSize;
//	}


	public int getHeight() {
		return height;
	}


	public int getBodyWeight() {
		return bodyWeight;
	}
	
	public String getMeasuredDate() {
		return measuredDate;
	}

	public double getOrdinaryShoesSize() {
		return ordinaryShoesSize;
	}
	
}
