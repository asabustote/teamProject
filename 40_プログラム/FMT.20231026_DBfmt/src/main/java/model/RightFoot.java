package model;

import java.io.Serializable;

public class RightFoot  implements Serializable {
	
	private int RFootLength;  //右足の足長
	private	 int RFootCWeith;  //体重のかかった時の右足の太さ
	private int RFootCRegu;  //通常時の右足の太さ
	private int RFootWidthWeith;  //体重のかかった時の右足の幅
	private int RFootWidthRegu;  //通常時の右足の幅
	
	public RightFoot () {}
	
	public RightFoot (int RFootLength, 
					   int RFootCWeith, 
					   int RFootCRegu, 
					   int RFootWidthWeith, 
					   int RFootWidthRegu) {
		
		this.RFootLength     = RFootLength;
		this.RFootCWeith     = RFootCWeith;
		this.RFootCRegu      = RFootCRegu;
		this.RFootWidthWeith = RFootWidthWeith;
		this.RFootWidthRegu  = RFootWidthRegu;		
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
	
	
}
