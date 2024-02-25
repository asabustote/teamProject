package measuredLogic;

import model.ResultMeasure;

/*
 * Kindを受け取った数によってメソットを選択
 * switchを使用
 * 
 * 
 * 
 */

public class DicideKind {
	
	Mens   mens;
	Womens womens;
	Kids   kids;
	ResultMeasure resultMeasure;
	
	public DicideKind () {
		this.mens = new Mens();
		this.womens = new Womens();
		this.kids          = new Kids();
		this.resultMeasure = new ResultMeasure();
	};
	
	public ResultMeasure dicideKind (String kind,
									  int RFootLength_int, 
									  int RFootCWeith_int,
									  int  RFootCRegu_int, 
									  int  RFootWidthWeith_int, 
									  int  RFootWidthRegu_int, 
									  int  LFootLength_int, 
									  int  LFootCWeith_int, 
									  int  LFootCRegu_int, 
									  int  LFootWidthWeith_int, 
									  int  LFootWidthRegu_int) {
		switch(kind) {
		
		case "男":
			Mens mens = new Mens();
			this.resultMeasure = mens.measure(RFootLength_int, 
														 RFootCWeith_int, 
														 RFootCRegu_int, 
														 RFootWidthWeith_int, 
														 RFootWidthRegu_int, 
														 LFootLength_int, 
														 LFootCWeith_int, 
														 LFootCRegu_int, 
														 LFootWidthWeith_int, 
														 LFootWidthRegu_int);
			break;
			
		case "女":
			Womens womens = new Womens();
			this.resultMeasure = womens.measure(RFootLength_int, 
																  RFootCWeith_int, 
																  RFootCRegu_int, 
																  RFootWidthWeith_int, 
																  RFootWidthRegu_int, 
																  LFootLength_int, 
																  LFootCWeith_int, 
																  LFootCRegu_int, 
																  LFootWidthWeith_int, 
																  LFootWidthRegu_int);
			break;
		
		case "子ども":
			Kids kids = new Kids();
			resultMeasure = kids.measure(RFootLength_int, 
																  RFootCWeith_int, 
																  RFootCRegu_int, 
																  RFootWidthWeith_int, 
																  RFootWidthRegu_int, 
																  LFootLength_int, 
																  LFootCWeith_int, 
																  LFootCRegu_int, 
																  LFootWidthWeith_int, 
																  LFootWidthRegu_int);
			break;
		}
		
		return resultMeasure;
	}
}	
	//試作１	
//	System.out.println("■靴のサイズ出し■");
//	System.out.println("性別を選択する");
//	System.out.println("1:男性用  2:女性用  3:子供用");
	
	
//	int selected = new java.util.Scanner(System.in).nextInt();
//	
//	//性別を選択する
//	switch(kind) {
//		case 1:
//		System.out.println("男性用");
//		Mens mens = new Mens();   //生成
//		
//		break;
//		
//		case 2:
//		System.out.println("女性用");
//		Womens womens = new Womens("女性", '右', '左', kind, kind, kind, kind, kind);
//		break;
//		
//		case 3:
//		System.out.println("子供用");
//		Kids kids = new Kids("子供", '右', '左',  kind, kind, kind, kind, kind);
//		break;
		
//		int a = 3;
//		switch(selected) {
//		
//		case 1:
//			Mens.Mens();
//			break;
//			
//		case 2:
//	//		System.out.println();
//			Womens.Womens();
//			break;
//		
//		case 3:
//			Kids.Kids();
//			break;
//		}
//	}
	
	
