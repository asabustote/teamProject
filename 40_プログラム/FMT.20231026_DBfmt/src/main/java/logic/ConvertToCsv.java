package logic;

import java.util.List;

import model.searchMeasuredPerson.ResultMeasuredPearson;

public class ConvertToCsv {

	/*
	 * 利用目的：データベースから取得した結果のリストの情報を
	 * 　　　　　CSVファイルとして出力する
	 * 引数　　：ResultMeasuredPersonList　(データベースから取得した被測定者のリストが入っている)
	 * 戻り値　：String　（引数のString .ver） 
	 * 
	 * 
	 */
	public String createCsvData (List<ResultMeasuredPearson> resultMeasuredPearsonsList) {
		StringBuffer stringBuffer = new StringBuffer();
		
		String titleLine ="被測定者ID,ふりがな,氏名,性別（男性・女性・子ども）,年齢,身長,体重,通常時の靴のサイズ,測定日,記入者,左足の足長さ,左足の体重のかかった時の左足の太さ,左足の通常時の左足の太さ,左足の体重のかかった時の左足の幅,左足の通常時の幅,右足の足長さ,右足の体重のかかった時の左足の太さ,右足の通常時の左足の太さ,右足の体重のかかった時の左足の幅,右足の通常時の幅,硬さ,最適なサイズ,太さ";
		//タイトル行
		stringBuffer.append(titleLine);
				
		//被測定者の各情報を行として追加
		for (int i = 0; i < resultMeasuredPearsonsList.size(); i++) {
			stringBuffer.append("\n");
			//基本情報
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getMeasuredPersonId());//被測定者ID
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getKana());//ふりがbな
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getName());//氏名
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getKind());//性別（男性・女性・子ども）
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getAge());//年齢
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getHeight());//身長
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getBodyWeight());//体重
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getOrdinaryShoesSize());//通常時の靴のサイズ
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getMeasuredDate());//測定日
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getWrittenBy());//記入者
			stringBuffer.append(",");
			
			//左足の情報
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getLFootLength());//左足の足長さ
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getLFootCWeith());//左足の体重のかかった時の左足の太さ
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getLFootCRegu());//左足の通常時の左足の太さ
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getLFootWidthWeith());//左足の体重のかかった時の左足の幅
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getLFootWidthRegu());//左足の通常時の幅
			stringBuffer.append(",");
			
			//右足の情報
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getRFootLength());//右足の足長さ
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getRFootCWeith());//右足の体重のかかった時の左足の太さ
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getRFootCRegu());//右足の通常時の左足の太さ
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getRFootWidthWeith());//右足の体重のかかった時の左足の幅
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getRFootWidthRegu());//右足の通常時の幅
			stringBuffer.append(",");
			
			//結果の情報
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getHardness());//硬さ
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getRecomendSize());//最適なサイズ
			stringBuffer.append(",");
			stringBuffer.append(resultMeasuredPearsonsList.get(i).getThickness());//太さ
		}
		
		return stringBuffer.toString();
	}
	
	
	
}
