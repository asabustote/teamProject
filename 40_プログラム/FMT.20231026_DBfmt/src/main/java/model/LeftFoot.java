package model;

import java.io.Serializable;

public class LeftFoot  implements Serializable  {
	
	private int LFootLength;  //左足の足長
	private int LFootCWeith;  //体重のかかった時の左足の太さ
	private int LFootCRegu;    //通常時の左足の太さ
	private int LFootWidthWeith;  //体重のかかった時の左足の幅
	private int LFootWidthRegu;  //通常時の左足の幅
	
	public LeftFoot () {}
	
	public LeftFoot (int LFootLength, 
					  int LFootCWeith, 
					  int LFootCRegu, 
					  int LFootWidthWeith, 
					  int LFootWidthRegu) {
		
		this.LFootLength     = LFootLength;
		this.LFootCWeith     = LFootCWeith;
		this.LFootCRegu      = LFootCRegu;
		this.LFootLength     = LFootLength;
		this.LFootWidthWeith = LFootWidthWeith;
		this.LFootWidthRegu  = LFootWidthRegu;		
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

}
