package logic;

import java.util.ArrayList;
import java.util.List;

import model.searchMeasuredPerson.SearchParams;

public class DynamicSQLBuilder {
	
	public  String buildQuery(SearchParams searchParams) {
        // WHERE句の条件を格納するリスト
        List<String> conditions = new ArrayList<>();
        
        

        // 名前の条件
        if (!"".equals(searchParams.getName())) {
            conditions.add("name = '" + searchParams.getName() + "'");
        }

        // 性別の条件
        if (!searchParams.getKind().equals("unselected")) {
        	String convertedKind = this.convertKind(searchParams.getKind());
            conditions.add("kind = '" + convertedKind + "'");
        }

        // 年代の条件
        String convertedDecade = this.convertDecade(searchParams.getDecade());
        String decade = this.decideDecade(convertedDecade);
        if (!searchParams.getDecade().equals("unselected")) {
            conditions.add("age BETWEEN " + decade);
        }    
        
        // 硬度の条件
        if (!searchParams.getHardness().equals("unselected")) {
            conditions.add("hardness = '" + searchParams.getHardness() + "'");
        }

        // 太さの条件
        if (!searchParams.getThickness().equals("unselected")) {
            conditions.add("thickness = '" + searchParams.getThickness() + "'");
        }
        
        

        // SQLクエリを構築
        StringBuffer query = new StringBuffer("SELECT * FROM measured_foot");

        if (!conditions.isEmpty()) {
            query.append(" WHERE ");
            query.append(String.join(" AND ", conditions));
        }
        
        query.append(";");
        
        return query.toString();
    }
	
	
	private String decideDecade (String selectedDecade) {
		String decade = "";
		for (int i = 0; i < 10; i++) {
			String tensPlace = i + "0";
			if (tensPlace .equals(selectedDecade)) {
				decade = i + "0 AND " + i + "9";
			}
			if (tensPlace .equals(selectedDecade)) {
				break;
			}
		}
		return decade;
	}
	
	/*
	 * 利用目的：検索条件のvalueのn代をnへ変換する
	 * 　　　　　10代→10などに変換
	 * 引数　　 :String selectedDecade (選択された年代)
	 * 戻り値　 ：String selectedDecade (変換後の値) 
	 */
	private String convertDecade (String selectedDecade) {
		
	 	String searchParamDecade = "";
	 	if ("10代未満".equals(selectedDecade)) {
	 		searchParamDecade = "00";
		}
		else if ("10代".equals(selectedDecade)) {
			searchParamDecade = "10";
		}
		else if ("20代".equals(selectedDecade)) {
			searchParamDecade = "20";
		}
		else if ("30代".equals(selectedDecade)) {
			searchParamDecade = "30";
		}
		else if ("40代".equals(selectedDecade)) {
			searchParamDecade = "40";
		}
		else if ("50代".equals(selectedDecade)) {
			searchParamDecade = "50";
		}
		else if ("60代".equals(selectedDecade)) {
			searchParamDecade = "60";
		}
		else if ("70代".equals(selectedDecade)) {
			searchParamDecade = "70";
		}
		else if ("80代".equals(selectedDecade)) {
			searchParamDecade = "80";
		}
		else if ("90代".equals(selectedDecade)) {
			searchParamDecade = "90";
		}
		
		return searchParamDecade;
	}
	
	/*
	 * 利用目的：検索条件のvalueの"男性"を"男"へ,"女性"を"女"へ変換する
	 * 　　　　　10代→10などに変換
	 * 引数　　 :String selectedDecade (選択された年代)
	 * 戻り値　 ：String selectedDecade (変換後の値) 
	 */
	private String convertKind (String selectedValueOfKind) {
		String searchParamKind = "";
		
		if ("男性".equals(selectedValueOfKind)) {
			searchParamKind = "男";
		} else if ("女性".equals(selectedValueOfKind)) {
			searchParamKind = "女";
		} 
		
		return searchParamKind;
	}
}
