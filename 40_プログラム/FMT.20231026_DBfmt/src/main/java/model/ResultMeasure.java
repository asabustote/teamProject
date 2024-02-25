package model;

public class ResultMeasure {
		
	private String result_Left_Weighted_Thickness; //体重のかかった時の左足の太さの結果
	private String result_Left_Regular_Thickness;  //通常時の左足の太さの結果
	
	private String result_Left_Weighted_Width;     //体重のかかった時の左足の幅の結果
	private String result_Left_Regular_Width;//通常時の左足の幅の結果
	
	private String result_Right_Weighted_Thickness;  //体重のかかった時の右足の太さ
	private String result_Right_Regular_Thickness;   //通常時の右足の太さの結果
	
	private String result_Right_Weighted_Width;      //体重のかかった時の右足の幅の結果
	private String result_Right_Regular_Width;       //通常時の右足の幅の結果

	private String hardness; //硬さ
	private double    recomendSize;       //サイズ
	private String thickness;  //太さ
	
	public ResultMeasure () {}
	
	public ResultMeasure (String  result_Left_Weighted_Thickness,
						   String  result_Left_Regular_Thickness,
						   String  result_Left_Weighted_Width,
						   String  result_Left_Regular_Width,
						   String  result_Right_Weighted_Thickness,
						   String  result_Right_Regular_Thickness,
						   String  result_Right_Weighted_Width,
						   String  result_Right_Regular_Width,
						   String  hardness,
						   double recomendSize,
						   String  thickness) {
		
		this.result_Left_Weighted_Thickness  = result_Left_Weighted_Thickness;
		this.result_Left_Regular_Thickness   = result_Left_Regular_Thickness;
		this.result_Left_Weighted_Width      = result_Left_Weighted_Width;
		this.result_Left_Regular_Width       = result_Left_Regular_Width;
		
		this.result_Right_Weighted_Thickness = result_Right_Weighted_Thickness;
		this.result_Right_Regular_Thickness  = result_Right_Regular_Thickness;
		this.result_Right_Weighted_Width     = result_Right_Weighted_Width;
		this.result_Right_Regular_Width      = result_Right_Regular_Width;
		
		this.hardness                        = hardness;
		this.recomendSize                    = recomendSize;
		this.thickness                       = thickness;
	}

	public String getResult_Left_Weighted_Thickness() {
		return result_Left_Weighted_Thickness;
	}

	public String getResult_Left_Regular_Thickness() {
		return result_Left_Regular_Thickness;
	}

	public String getResult_Left_Weighted_Width() {
		return result_Left_Weighted_Width;
	}

	public String getResult_Left_Regular_Width() {
		return result_Left_Regular_Width;
	}

	public String getResult_Right_Weighted_Thickness() {
		return result_Right_Weighted_Thickness;
	}

	public String getResult_Right_Regular_Thickness() {
		return result_Right_Regular_Thickness;
	}

	public String getResult_Right_Weighted_Width() {
		return result_Right_Weighted_Width;
	}

	public String getResult_Right_Regular_Width() {
		return result_Right_Regular_Width;
	}

	public String getHardness() {
		return hardness;
	}

//	public double getRecomendSize() {
//		return recomendSize;
//	}

	public String getThickness() {
		return thickness;
	}

	public double getRecomendSize() {
		return recomendSize;
	}

}
