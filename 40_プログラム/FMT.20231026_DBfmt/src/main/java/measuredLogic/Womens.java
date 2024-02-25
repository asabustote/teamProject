package measuredLogic;

import model.ResultMeasure;

/*
 * a = JIS表で足長下に(a)段目
 * b = JIS表で荷重足囲右(ｂ)段目
 * c = JIS表で非荷重足囲右に(c)段目
 * d = JIS表で非荷重足幅右に(d)段目
 * e = JIS表で非荷重足幅右に(e)段目
 * f = 足幅時調節値
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
 * 
 * String[] y = {"0", "195", "200", "205", "210", "215", "220", "225", "230", "235", "240", "245", "250", "255", "260", "265", "270"};
 * String[] z = {A-, A, B, C, D, E, EE, EEE, EEEE, F}
 * 
 */
public class Womens {
	
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
		
		int t = 0;
		if(((RFootLength - 193) % 5) >= 0) {//これいる？　+1でよくね？
			t++; 
		}
		//JIS表で(a)段目
		int a = ((RFootLength - 193) / 5) + t;
		//JIS表で荷重足囲右に(ｂ)段目
		int b = (RFootCWeith - (180 + (3 * (a - 1)))) / 6 + 1;
		//JIS表で非荷重足囲右に(c)段目
		int c = (RFootCRegu - (180 + (3 * (a - 1)))) / 6 + 1;
	/*--------------------------------------------------------------------------------------------*/	
		//足幅調整値：2段目以降4サイズ毎に1ｍｍ上がる
		int f = 0;
		if(a == 2) { 
			f += 1; 
			}else if(a > 2 && a < 6){
				f += 1;
			}else if(a >= 6 && a < 10){
				f += 2;
			}else if(a >= 10 && a < 14){
				f += 3;
			}else if(a >= 14 && a < 18){
				f += 4;
			}else {
				f = 0;
			}
		//d = JIS表で非荷重足幅右に(d)段目
		int d = (RFootWidthWeith - (75 + (a - 1 + f))) / 2 + 1;
		//e = JIS表で非荷重足幅右に(e)段目
		int e = (RFootWidthReg - (75 +  (a - 1 + f))) / 2 + 1;
		/*------左足---------------------------------------------------*/
	int q = 0;
		if(((LFootLength - 193) % 5) >= 0) {//これいる？　+1でよくね？
			q++; 
		}
		//JIS表で(h)段目
		int h = ((LFootLength - 193) / 5) + q;
		//JIS表で荷重足囲右に(i)段目
		int i = (LFootCWeith - (180 + (3 * (h - 1)))) / 6 + 1;
		//JIS表で非荷重足囲右に(j)段目
		int j = (LFootCRegu - (180 + (3 * (h - 1)))) / 6 + 1;
		//足幅調整値：2段目以降4サイズ毎に1ｍｍ上がる
		int m = 0;
		if(h == 2) { 
			m += 1; 
			}else if(h > 2 && h < 6){
				m += 1;
			}else if(h >= 6 && h < 10){
				m += 2;
			}else if(h >= 10 && h < 14){
				m += 3;
			}else if(h >= 14 && h < 18){
				m += 4;
			}else {
				m = 0;
			}
		//k = JIS表で非荷重足幅右に(k)段目
		int k = (LFootWidthWeith - (75 + (h - 1 + m))) / 2 + 1;
		//l = JIS表で非荷重足幅左に(l)段目
		int l = (LFootWidthReg - (75 +  (h - 1 + m))) / 2 + 1;
		double[] y = {0, 19.5, 20.0, 20.5, 21.0, 21.5, 22.0, 22.5, 23.0, 23.5, 24.0, 24.5, 25.0, 25.5, 26.0, 26.5, 27.0};
		String[] z = {"A-", "A", "B", "C", "D", "E", "EE", "EEE", "EEEE", "F", "G"};
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

