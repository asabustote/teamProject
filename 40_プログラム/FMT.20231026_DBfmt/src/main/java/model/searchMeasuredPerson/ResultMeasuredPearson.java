package model.searchMeasuredPerson;

import java.io.Serializable;

public class ResultMeasuredPearson  implements Serializable {
	//10
	private int    measuredPersonId; //被測定者ID
	private String kana;  //ふりがな
	private String name;  //氏名
	private String kind;  //性別（男性・女性・子ども）
	private int    age;    //年齢
	private int    height;//身長
	private int    bodyWeight;  //体重
	private double	ordinaryShoesSize; //通常時の靴のサイズ
	private String measuredDate;  //測定日
	private String writtenBy;  //記入者		
	
	//5
	private int LFootLength;  //左足の足長
	private int LFootCWeith;  //体重のかかった時の左足の太さ
	private int LFootCRegu;    //通常時の左足の太さ
	private int LFootWidthWeith;  //体重のかかった時の左足の幅
	private int LFootWidthRegu;  //通常時の左足の幅
	
	//5
	private int RFootLength;  //右足の足長
	private int RFootCWeith;  //体重のかかった時の右足の太さ
	private int RFootCRegu;  //通常時の右足の太さ
	private int RFootWidthWeith;  //体重のかかった時の右足の幅
	private int RFootWidthRegu;  //通常時の右足の幅
	
	//3
	private String  hardness; 			//硬さ
	private double recomendSize;       //サイズ
	private String  thickness;		 //太さ

	public ResultMeasuredPearson() {};
	
	public ResultMeasuredPearson (int    measuredPersonId,
								   String kana,
								   String name,
								   String kind,
								   int    age,
								   int    height,
								   int    bodyWeight,
								   double	ordinaryShoesSize,
								   String measuredDate,
								   String writtenBy,
								   int LFootLength,
								   int LFootCWeith,
								   int LFootCRegu,
								   int LFootWidthWeith,
								   int LFootWidthRegu,
								   int RFootLength,
								   int RFootCWeith,
								   int RFootCRegu,
								   int RFootWidthWeith,
								   int RFootWidthRegu,
								   String  hardness,
								   double recomendSize,
								   String  thickness) {
		
								   this.measuredPersonId = measuredPersonId;
								   this.kana = kana;
								   this.name = name;
								   this.kind = kind;
								   this.age = age;
								   this.height = height;
								   this.bodyWeight = bodyWeight;
								   this.ordinaryShoesSize = ordinaryShoesSize;
								   this.measuredDate = measuredDate;
								   this.writtenBy = writtenBy;
								   this.LFootLength = LFootLength;
								   this.LFootCWeith = LFootCWeith;
								   this.LFootCRegu = LFootCRegu;
								   this.LFootWidthWeith = LFootWidthWeith;
								   this.LFootWidthRegu = LFootWidthRegu;
								   this.RFootLength = RFootLength;
								   this.RFootCWeith = RFootCWeith;
								   this.RFootCRegu = RFootCRegu;
								   this.RFootWidthWeith = RFootWidthWeith;
								   this.RFootWidthRegu = RFootWidthRegu;	
								   this.hardness = hardness;
								   this.recomendSize = recomendSize;
								   this.thickness = thickness;							  
	}

	public int getMeasuredPersonId() {
		return measuredPersonId;
	}
	
	public String getName() {
		return name;
	}


	public String getKana() {
		return kana;
	}

	public String getKind() {
		return kind;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getBodyWeight() {
		return bodyWeight;
	}

	public double getOrdinaryShoesSize() {
		return ordinaryShoesSize;
	}

	public String getMeasuredDate() {
		return measuredDate;
	}

	public String getWrittenBy() {
		return writtenBy;
	}

	public int getLFootLength() {
		return LFootLength;
	}

	public int getLFootCWeith() {
		return LFootCWeith;
	}

	public int getLFootCRegu() {
		return LFootCRegu;
	}

	public int getLFootWidthWeith() {
		return LFootWidthWeith;
	}

	public int getLFootWidthRegu() {
		return LFootWidthRegu;
	}

	public int getRFootLength() {
		return RFootLength;
	}

	public int getRFootCWeith() {
		return RFootCWeith;
	}

	public int getRFootCRegu() {
		return RFootCRegu;
	}

	public int getRFootWidthWeith() {
		return RFootWidthWeith;
	}

	public int getRFootWidthRegu() {
		return RFootWidthRegu;
	}

	public String getHardness() {
		return hardness;
	}

	public double getRecomendSize() {
		return recomendSize;
	}

	public String getThickness() {
		return thickness;
	}

	public void setMeasuredPersonId(int measuredPersonId) {
		this.measuredPersonId = measuredPersonId;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setBodyWeight(int bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public void setOrdinaryShoesSize(double ordinaryShoesSize) {
		this.ordinaryShoesSize = ordinaryShoesSize;
	}

	public void setMeasuredDate(String measuredDate) {
		this.measuredDate = measuredDate;
	}

	public void setWrittenBy(String writtenBy) {
		this.writtenBy = writtenBy;
	}

	public void setLFootLength(int lFootLength) {
		LFootLength = lFootLength;
	}

	public void setLFootCWeith(int lFootCWeith) {
		LFootCWeith = lFootCWeith;
	}

	public void setLFootCRegu(int lFootCRegu) {
		LFootCRegu = lFootCRegu;
	}

	public void setLFootWidthWeith(int lFootWidthWeith) {
		LFootWidthWeith = lFootWidthWeith;
	}

	public void setLFootWidthRegu(int lFootWidthRegu) {
		LFootWidthRegu = lFootWidthRegu;
	}

	public void setRFootLength(int rFootLength) {
		RFootLength = rFootLength;
	}

	public void setRFootCWeith(int rFootCWeith) {
		RFootCWeith = rFootCWeith;
	}

	public void setRFootCRegu(int rFootCRegu) {
		RFootCRegu = rFootCRegu;
	}

	public void setRFootWidthWeith(int rFootWidthWeith) {
		RFootWidthWeith = rFootWidthWeith;
	}

	public void setRFootWidthRegu(int rFootWidthRegu) {
		RFootWidthRegu = rFootWidthRegu;
	}

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}

	public void setRecomendSize(double recomendSize) {
		this.recomendSize = recomendSize;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
}
