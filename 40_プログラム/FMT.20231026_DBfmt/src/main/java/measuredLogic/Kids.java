package measuredLogic;

import model.ResultMeasure;

/*
 * a = 右足JIS表で足長下に(a)段目
 * b = 右足JIS表で荷重足囲右(ｂ)段目
 * c = 右足JIS表で非荷重足囲右に(c)段目
 * d = 右足JIS表で非荷重足幅右に(d)段目
 * e = 右足JIS表で非荷重足幅右に(e)段目
 * f = 右足足幅時調節値
 * t = 調節
 * 
 * h = 左足JIS表で足長下に(h)段目
 * i = 左足JIS表で荷重足囲右(i)段目
 * j = 左足JIS表で非荷重足囲右に(j)段目
 * k = 左足JIS表で非荷重足幅右に(k)段目
 * l = 左足JIS表で非荷重足幅右に(l)段目
 * m = 左足足幅時調節値* 
 * q = 調節
 * 
 * String[] y = {"0", "195", "200", "205", "210", "215", "220", "225", "230", "235", "240", "245", "250", "255", "260", "265", "270"};
 * String[] z = {0, A, B, C, D, E, EE, EEE, EEEE, F}
 * 
 */
public class Kids {
	
	public ResultMeasure measure (int RFootLength,
								   int RFootCWeith,
								   int RFootCRegu,
								   int RFootWidthWeith,
								   int RFootWidthReg,
								   int LFootLength,
								   int LFootCWeith,
								   int LFootCRegu,
								   int LFootWidthWeith,
								   int LFootWidthReg) {

			
		/*右足-----------------------------------------*/
		int t = 0;	
		if(((RFootLength - 103) % 5) >= 0) {//これいる？　+1でよくね？
			t++; 
		}
		//JIS表で(a)段目
		int a = ((RFootLength - 103) / 5) + t;
		//JIS表で荷重足囲右に(ｂ)段目
		int b = (RFootCWeith - (95 + (4 * (a - 1)))) / 6 + 1;
		//JIS表で非荷重足囲右に(c)段目
		int c = (RFootCRegu - (95 + (4 * (a - 1)))) / 6 + 1;
	/*--------------------------------------------------------------------------------------------*/	
		//足幅調整値：
		int f = 0;
		switch (a) {
			case 1:
				f += 0;
				break;
			case 2:
				f += 2;
				break;
			case 3:
				f += 3;
				break;
			case 4:
				f += 5;
				break;
			case 5:
				f += 7;
				break;
			case 6:
				f += 8;
				break;
			case 7:
				f += 10;
				break;
			case 8:
				f += 12;
				break;
			case 9:
				f += 14;
				break;
			case 10:
				f += 15;
				break;
			case 11:
				f += 17;
				break;
			case 12:
				f += 19;
				break;
			case 13:
				f += 20;
				break;
			case 14:
				f += 22;
				break;
			case 15:
				f += 24;
				break;
			case 16:
				f += 25;
				break;
			case 17:
				f += 27;
				break;
			case 18:
				f += 29;
				break;
			case 19:
				f += 30;
				break;
			case 20:
				f += 32;
				break;
			case 21:
				f += 34;
				break;
			case 22:
				f += 36;
				break;
			case 23:
				f += 38;
				break;
			case 24:
				f += 39;
				break;	
			case 25:
				f += 41;
				break;
			case 26:
				f += 42;
				break;
			case 27:
				f += 44;
				break;
			case 28:
				f += 46;
				break;
			case 29:
				f += 47;
				break;
			case 30:
				f += 49;
				break;
			case 31:
				f += 51;
				break;
			case 32:
				f += 52;
				break;
							
		}	
		//d = JIS表で非荷重足幅右に(d)段目
		int d = (RFootWidthWeith - (39 + f)) / 2 + 1;
		//e = JIS表で非荷重足幅右に(e)段目
		int e = (RFootWidthReg - (39 +  f)) / 2 + 1;
	/*---------------------左足-----------------------------------------------*/	
		int q = 0;
		if(((LFootLength - 103) % 5) >= 0) {//これいる？　+1でよくね？
			q++; 
		}
		//JIS表で(h)段目
		int h = ((LFootLength - 103) / 5) + q;
		//JIS表で荷重足囲右に(i)段目
		int i = (LFootCWeith - (95 + (4 * (h - 1)))) / 6 + 1;
		//JIS表で非荷重足囲右に(j)段目
		int j = (LFootCRegu - (95 + (4 * (h - 1)))) / 6 + 1;
	/*--------------------------------------------------------------*/	
		//足幅調整値：
		int m = 0;
		switch (h) {
			case 1:
				m += 0;
				break;
			case 2:
				m += 2;
				break;
			case 3:
				m += 3;
				break;
			case 4:
				m += 5;
				break;
			case 5:
				m += 7;
				break;
			case 6:
				m += 8;
				break;
			case 7:
				m += 10;
				break;
			case 8:
				m += 12;
				break;
			case 9:
				m += 14;
				break;
			case 10:
				m += 15;
				break;
			case 11:
				m += 17;
				break;
			case 12:
				m += 19;
				break;
			case 13:
				m += 20;
				break;
			case 14:
				m += 22;
				break;
			case 15:
				m += 24;
				break;
			case 16:
				m += 25;
				break;
			case 17:
				m += 27;
				break;
			case 18:
				m += 29;
				break;
			case 19:
				m += 30;
				break;
			case 20:
				m += 32;
				break;
			case 21:
				m += 34;
				break;
			case 22:
				m += 36;
				break;
			case 23:
				m += 38;
				break;
			case 24:
				m += 39;
				break;	
			case 25:
				m += 41;
				break;
			case 26:
				m += 42;
				break;
			case 27:
				m += 44;
				break;
			case 28:
				m += 46;
				break;
			case 29:
				m += 47;
				break;
			case 30:
				m += 49;
				break;
			case 31:
				m += 51;
				break;
			case 32:
				m += 52;
				break;	
				
		}
		//d = JIS表で非荷重足幅右に(d)段目
		int k = (LFootWidthWeith - (39 + m)) / 2 + 1;
		//e = JIS表で非荷重足幅右に(e)段目
		int l = (LFootWidthReg - (39 +  m)) / 2 + 1;
		double[] y = {0,10.5, 11.0, 11.5, 12.0, 12.5, 13.0, 13.5, 14.0, 14.5, 15.0, 15.5, 16.0, 16.5, 17.0, 17.5, 18.0, 18.5, 19.0, 19.5, 20.0, 20.5, 21.0};
		String[] z = {"0", "B", "C", "D", "E", "EE", "EEE", "EEEE", "F", "G"};
		String[] x = {"柔らかめ", "普通", "硬め"};
		String[] w = {"細め", "普通", "太め"};
/*--------------------硬度に返す--------------------------------*/
		//足幅：硬＜12　　軟＞8　足囲：19>軟   12<硬
		int o = LFootCWeith - LFootCRegu;//左足囲の増減
		int p = RFootCWeith - RFootCRegu;//右足囲の増減
		
		int r = 0;
		if(o > p) {//差の大きな方を採用
			 r = o;
		}else if(o < p) {
			 r = p;
		}else{
			 r = o;
		}
		String v = "";//30
		if(r <= 12) {
			v = x[0];
			System.out.println(v);
		}else if(r >= 19) {
			v = x[1];
			System.out.println(v);
		}else {
			v = x[2];
			System.out.println(v);
		}
		
	/*---------------足長--------------------------------*/	
		double s = 0;//お薦めサイズ
		if(a > h) {
			s = y[a] + 0.5;
		}else{
			s = y[h] + 0.5;
		}
	/*---------------太さ------------------------------*/	
		String u = "";//32
		if(b < i) {
			if(i <= 2) {
				u = w[0];
				System.out.println(u);
			}else if(i >=3 && i <= 5) {
				u = w[1];
				System.out.println(u);
			}else {
				u = w[2];
				System.out.println(u);
			}
		}else{
			if(b <= 2) {
				u = w[0];
				System.out.println(u);
			}else if(b >=3 && b <= 5) {
				u = w[1];
				System.out.println(u);
			}else {
				u = w[2];
				System.out.println(u);
			}
		}
	
		//z[b]:結果、右足の体重のかかった時の太さ
				String result_Right_Weighted_Thickness  = z[b];
				//z[c]:結果、右足の通常時の太さ
				String result_Right_Regular_Thickness   = z[c];
				//z[d]:結果、右足の体重のかかった時の幅
				String result_Right_Weighted_Width      = z[d];
				//z[e]:結果、右足の通常時の幅
				String result_Right_Regular_Width       = z[e];
				
				//z[i]:結果、左足の体重のかかった時の太さ
				String result_Left_Weighted_Thickness   = z[i];
				//z[j]:結果、左足の通常時の太さ
				String result_Left_Regular_Thickness    = z[j];
				//z[k]:結果、左足の体重のかかった時の幅
				String result_Left_Weighted_Width        = z[k];
				//z[l]:結果、左足の通常時の幅
				String result_Left_Regular_Width         = z[l];
				
				//v:硬度
				String hardness = v;
				//s:お薦めサイズ
				double    recomendSize  = s;
//				double recomendSize_double = Double.parseDouble(recomendSize);
				//u:太さ
				String thickness = u;  //太さ
				
				
				
				//測定結果クラスのフィールドは左足の値からフィールドが設定されている
				ResultMeasure resultMeasure = new ResultMeasure(result_Left_Weighted_Thickness,
																  result_Left_Regular_Thickness,
																  result_Left_Weighted_Width,
																  result_Left_Regular_Width,
																  result_Right_Weighted_Thickness,
																  result_Right_Regular_Thickness,
																  result_Right_Weighted_Width,
																  result_Right_Regular_Width,
																  hardness,
																  recomendSize,
																  thickness);
				
				return resultMeasure;
		
	}

}