package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.searchMeasuredPerson.OptionTagsList;
import model.searchMeasuredPerson.SelectedValueMaps;

public class OptionTagLogic {
	private String beginningOfOptionTag = "<option value=";
	private String[] values_array;
	private String endOfOptionTag       = "</option>";
	
	/*
	 * 利用目的：フォームの各opution tagのListをフィールドに持つクラスの生成
	 * 引数1　　：SelectedValueMaps selectedValueMaps　  選択状況を管理するMapをフィールドにもつクラス
	 * 引数2　　：String[]          KeysForDecadeMap     年代の選択状況を管理するMapのkey
	 * 戻り値　 ：OptionTagList     OptionTagList        各オプションタグが格納されたリストを持つクラス
	 */
	public OptionTagsList createOptionTagListClass (SelectedValueMaps     selectedValueMaps,
												    SelectedValueMapLogic selectedValueMapLogic) {
		OptionTagsList optionTagsList = new OptionTagsList();
		
		//各年代に関するオプションタグを格納したListを生成
		List<String> decadeOptionTagsList = this.createDecadeOptionTagList(selectedValueMaps.getSelectedValueMapForDecade(), 
																		   selectedValueMapLogic.getKeysForDecadeMap());
		//各オプションタグのListをフィールドに持つクラスにListを格納
		optionTagsList.setDecadeOptionTagList(decadeOptionTagsList);
		
		//各性別（男性・女性・子ども）に関するオプションタグを格納したListを生成
		List<String> kindOptionTagsList = this.createKindOptionTagList(selectedValueMaps.getSelectedValueMapForKind(), 
																		selectedValueMapLogic.getKeysForKindMap());
		//各オプションタグのListをフィールドに持つクラスにListを格納
		optionTagsList.setKindOptionTagList(kindOptionTagsList);
	
		//各硬さに関するオプションタグを格納したListを生成
		List<String> hardnessOptionTagsList = this.createHardnessOptionTagList(selectedValueMaps.getSelectedValueMapForHardness(),
																			   selectedValueMapLogic.getKeysForHardness());
		//各オプションタグのListをフィールドに持つクラスにListを格納
		optionTagsList.setHardnessOptionTagList(hardnessOptionTagsList);
		
		//各太さに関するオプションタグを格納したListを生成
		List<String> thicknessOptionTagsList = this.createThicknessOptionTagList(selectedValueMaps.getSelectedValueMapForThickness(),
																				 selectedValueMapLogic.getKeysForThickness());
		//各オプションタグのListをフィールドに持つクラスにListを格納
		optionTagsList.setThicknessOptionTagList(thicknessOptionTagsList);
		
		return optionTagsList;
	}

	/*
	 * 利用目的：下記年代に関するオプションタグを格納したリストを生成する
	 *　　　　　　<option value=n年代 selected/"">n年代</option> 
	 *引数1　　：SelectedValueMaps selectedValueMaps　  選択状況を管理するMapをフィールドにもつクラス
	 *引数2　　：String[]          KeysForDecadeMap     年代の選択状況を管理するMapのkey
	 *戻り値　 ：List<String>      decadeOptionTagList  年代ごとのオプションタグの格納されたリスト
	 */
	private List<String> createDecadeOptionTagList (Map<String,String> selectedValueMapForDecade,
											        String[]              KeysForDecadeMap) {
		List<String> decadeOptionTagList = new ArrayList<String>();

		this.values_array = KeysForDecadeMap;
		
		for (int i = 0; i < selectedValueMapForDecade.size(); i++) {
			decadeOptionTagList.add(this.beginningOfOptionTag + this.values_array[i] +
									" " +
									selectedValueMapForDecade.get(KeysForDecadeMap[i]) +
								    " >" + KeysForDecadeMap[i] + this.endOfOptionTag);
		}

		return decadeOptionTagList;
	}
	
	/*
	 * 利用目的：下記、性別（男性・女性・子ども）に関するオプションタグを格納したリストを生成する
	 *　　　　　　<option value=男性 selected/"">男性</option> 
	 *引数1　　：SelectedValueMaps selectedValueMaps　  選択状況を管理するMapをフィールドにもつクラス
	 *引数2　　：String[]          KeysForKindeMap      性別（男性・女性・子ども）の選択状況を管理するMapのkey
	 *戻り値　 ：List<String>      KindOptionTagList  性別（男性・女性・子ども）ごとのオプションタグの格納されたリスト
	 */
	private List<String> createKindOptionTagList (Map<String,String> selectedValueMapForKind,
											      String[]            KeysForKindMap) {
		List<String> kindOptionTagList = new ArrayList<String>();

		this.values_array = KeysForKindMap;
		
		for (int i = 0; i < selectedValueMapForKind.size(); i++) {
			kindOptionTagList.add(this.beginningOfOptionTag + this.values_array[i] +
									" " +
									selectedValueMapForKind.get(KeysForKindMap[i]) +
								    " >" + KeysForKindMap[i] + this.endOfOptionTag);
		}

		return kindOptionTagList;
	}
	
	/*
	 * 利用目的：下記、硬さに関するオプションタグを格納したリストを生成する
	 *　　　　　　<option value=硬め selected/"">硬め</option> 
	 *引数1　　：SelectedValueMaps selectedValueMaps　  選択状況を管理するMapをフィールドにもつクラス
	 *引数2　　：String[]          KeysForHardnessMap      硬さの選択状況を管理するMapのkey
	 *戻り値　 ：List<String>      hardnessOptionTagList  硬さごとのオプションタグの格納されたリスト
	 */
	private List<String> createHardnessOptionTagList (Map<String,String> selectedValueMapForHardness,
											          String[]           KeysForHardnessMap) {
		List<String> hardnessOptionTagList = new ArrayList<String>();

		this.values_array = KeysForHardnessMap;
		
		for (int i = 0; i < selectedValueMapForHardness.size(); i++) {
			hardnessOptionTagList.add(this.beginningOfOptionTag + this.values_array[i] +
									" " +
									selectedValueMapForHardness.get(KeysForHardnessMap[i]) +
								    " >" + KeysForHardnessMap[i] + this.endOfOptionTag);
		}

		return hardnessOptionTagList;
	}
	
	/*
	 * 利用目的：下記、太さに関するオプションタグを格納したリストを生成する
	 *　　　　　　<option value=太め selected/"">太め</option> 
	 *引数1　　：SelectedValueMaps selectedValueMaps　    選択状況を管理するMapをフィールドにもつクラス
	 *引数2　　：String[]          KeysForThicknessMap    太さの選択状況を管理するMapのkey
	 *戻り値　 ：List<String>      thicknessOptionTagList  太さごとのオプションタグの格納されたリスト
	 */
	private List<String> createThicknessOptionTagList (Map<String,String> selectedValueMapForThickness,
											           String[]           KeysForThicknessMap) {
		List<String> thicknessOptionTagList = new ArrayList<String>();

		this.values_array = KeysForThicknessMap;
		
		for (int i = 0; i < selectedValueMapForThickness.size(); i++) {
			thicknessOptionTagList.add(this.beginningOfOptionTag + this.values_array[i] +
									" " +
									selectedValueMapForThickness.get(KeysForThicknessMap[i]) +
								    " >" + KeysForThicknessMap[i] + this.endOfOptionTag);
		}

		return thicknessOptionTagList;
	}
}
