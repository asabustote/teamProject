package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.searchMeasuredPerson.SearchParams;
import model.searchMeasuredPerson.SelectedValueMaps;

public class SelectedValueMapLogic {
	private String[] keyForNameMap    = {"名前"}; 
	private String[] keysForDecadeMap = {"10代未満","10代","20代","30代","40代","50代","60代","70代","80代","90代"};
	private String[] keysForKindMap   = {"男性","女性","子ども"};
	private String[] keysForHardness  = {"硬め","普通","柔らかめ"};
	private String[] keysForThickness = {"太め","普通","細め"};
	
	private String   emptyString     = "";
	
	private String beginningOfOptionTag = "<option value=";
	private String endOfOptionTag       = "</option>";
	
	public List<String> createEachOptionTagList (Map<String,String> eachSelectedValueMap,
			  									 String[]           eachKeysForMap) {
		List<String> eachOptiontagList = new ArrayList<String>();
		
		for (int i = 0; i < eachSelectedValueMap.size(); i++) {
			eachOptiontagList.add(this.beginningOfOptionTag + eachKeysForMap[i] + ">" + eachKeysForMap[i] + this.endOfOptionTag);
		}
		
		return eachOptiontagList;
	}
	
	/*
	 * 利用目的：選択されたかどうか確認後の各項目の選択状況を管理するMapをフィールドに持つクラスを生成する
	 * 引数　　：フォームで選択された値
	 * 戻り値　：SelectedValueMaps　選択後の状態を管理するMapをフィールドに持つクラス
	 */
	public SelectedValueMaps createCheckedSelectedValueMapsClass (SearchParams searchParams) {
		//各項目の選択状態を管理するMapをフィールドにもつクラスを生成
		SelectedValueMaps selectedValueMaps = new SelectedValueMaps();
		
		//選択された値(key)にselect(value)を選択されていない値(key)に空文字(value)をセットする
		//氏名の選択状態を管理するMap
		Map<String,String> inputedValueMapForName = this.checkInputedValue(this.createinputedValueMapForName(),
																			this.keyForNameMap,
																			searchParams.getName());
		//Mapを管理するクラスのフィールドへMapをセット
		selectedValueMaps.setInputedValueMapForName(inputedValueMapForName);
		
		//年代の選択状態を管理するMap
		Map<String,String> selectedValueMapForDecade = this.checkSelectedValue(this.createSelectedValueMapForDecade(),
													   						   this.keysForDecadeMap, 
													   						   searchParams.getDecade());
		//Mapを管理するクラスのフィールドへMapをセット
		selectedValueMaps.setSelectedValueMapForDecade(selectedValueMapForDecade);
		
		//性別（男性・女性・子ども）の選択状態を管理するMap
		Map<String,String> selectedValueMapForKind = this.checkSelectedValue(this.createSelectedValueMapForKind(), 
																			 this.keysForKindMap, 
																			 searchParams.getKind());
		//Mapを管理するクラスのフィールドへMapをセット
		selectedValueMaps.setSelectedValueMapForKind(selectedValueMapForKind);
		
		//硬さの選択状態を管理するMap
		Map<String,String> selectedValueMapForHardness = this.checkSelectedValue(this.createSelectedValueMapForHardness(), 
				 																 this.keysForHardness, 
				 																 searchParams.getHardness());
		//Mapを管理するクラスのフィールドへMapをセット
		selectedValueMaps.setSelectedValueMapForHardness(selectedValueMapForHardness);
		
		//太さの選択状態を管理するMap
		Map<String,String> selectedValueMapForThickness = this.checkSelectedValue(this.createSelectedValueMapForThickness(), 
																				  this.keysForThickness, 
																				  searchParams.getThickness());
		//Mapを管理するクラスのフィールドへMapをセット
		selectedValueMaps.setSelectedValueMapForThickness(selectedValueMapForThickness);
		
		return selectedValueMaps;
	}
	
	
	/*
	 * 利用方法；各項目の選択状態を管理するMapの初期状態をフィールドにもつクラスを生成
	 * 引数　　：なし
	 * 戻り値　：SelectedValueMapsクラス　各項目の選択状況が初期状態（空文字）のMapをフィールドに持つクラス
	 * */
	public SelectedValueMaps createSelectedValueMapsClass () {
		//各項目の選択状態を管理するMapをフィールドにもつクラスを生成
		SelectedValueMaps selectedValueMaps = new SelectedValueMaps();
		//各フィールドの初期状態Mapを格納
		//氏名の選択状態を管理するMap
		selectedValueMaps.setInputedValueMapForName    (this.createinputedValueMapForName());
		//年代の選択状態を管理するMap
		selectedValueMaps.setSelectedValueMapForDecade  (this.createSelectedValueMapForDecade());
		//性別（男性・女性・子ども）の選択状態を管理するMap
		selectedValueMaps.setSelectedValueMapForKind    (this.createSelectedValueMapForKind());
		//硬さの選択状態を管理するMap
		selectedValueMaps.setSelectedValueMapForHardness(this.createSelectedValueMapForHardness());
		//太さの選択状態を管理するMap
		selectedValueMaps.setSelectedValueMapForThickness(this.createSelectedValueMapForThickness());
		return selectedValueMaps;
	}
	
	/*
	 * 利用目的；氏名に関する項目の選択状況を管理するマップを生成
	 * 　　　　　指名の場合、検索条件クラス（SearchParams）のnameフィールドを参照すれば良いだけだが
	 * 　　　　　統一感を持たせるため、氏名もMapで管理することにした。Oct.21st 23
	 * 引数　　：なし
	 * 戻り値　：年代に関する項目の選択状況を管理するマップ
	 * 　　　　　初期状態：各Keyのvalueは空文字が　生成される
	 */
	private Map<String,String> createinputedValueMapForName () {
		Map<String,String> inputedValueMapForName = new HashMap<String,String>();
		//年代に関する項目の選択状況を管理するマップの初期値（空文字）を設定
		for (int i = 0; i < this.keyForNameMap.length; i++) {
			inputedValueMapForName.put(this.keyForNameMap[i], this.emptyString);
		}
		return inputedValueMapForName;
	}
	
	/*
	 *利用目的；年代に関する項目の選択状況を管理するマップを生成
	 * 引数：なし
	 * 戻り値：年代に関する項目の選択状況を管理するマップ
	 * 　　　　初期状態：各Keyのvalueは空文字が　生成される
	 */
	private Map<String,String> createSelectedValueMapForDecade () {
		Map<String,String> selectedValueMapForDecade = new HashMap<String,String>();
		//年代に関する項目の選択状況を管理するマップの初期値（空文字）を設定
		for (int i = 0; i < this.keysForDecadeMap.length; i++) {
			selectedValueMapForDecade.put(this.keysForDecadeMap[i], this.emptyString);
		}
		return selectedValueMapForDecade;
	}
	
	/*
	 * 利用目的；性別（男性・女性・子ども）に関する項目の選択状況を管理するマップを生成
	 * 引数　　：なし
	 * 戻り値　：性別（男性・女性・子ども）に関する項目の選択状況を管理するマップ
	 * 　　　　　初期状態：各Keyのvalueは空文字が　生成される
	 */
	private Map<String,String> createSelectedValueMapForKind () {
		Map<String,String> selectedValueMapForKind = new HashMap<String,String>();
		//年代に関する項目の選択状況を管理するマップの初期値（空文字）を設定
		for (int i = 0; i < this.keysForKindMap.length; i++) {
			selectedValueMapForKind.put(this.keysForKindMap[i], this.emptyString);
		}
		return selectedValueMapForKind;
	}

	/*
	 * 利用目的：硬さに関する項目の選択状況を管理するマップを生成
	 * 引数　　：なし
	 * 戻り値　：硬さに関する項目の選択状況を管理するマップ
	 * 　　　　　初期状態：各Keyのvalueは空文字が　生成される
	 */
	private Map<String,String> createSelectedValueMapForHardness () {
		Map<String,String> selectedValueMapForHardness = new HashMap<String,String>();
		//年代に関する項目の選択状況を管理するマップの初期値（空文字）を設定
		for (int i = 0; i < this.keysForHardness.length; i++) {
			selectedValueMapForHardness.put(this.keysForHardness[i], this.emptyString);
		}
		return selectedValueMapForHardness;
	}
	
	/*
	 * 利用目的；太さに関する項目の選択状況を管理するマップを生成
	 * 引数　　：なし
	 * 戻り値　：太さに関する項目の選択状況を管理するマップ
	 * 　　　　　初期状態：各Keyのvalueは空文字が　生成される
	 */
	private Map<String,String> createSelectedValueMapForThickness () {
		Map<String,String> selectedValueMapForHardness = new HashMap<String,String>();
		//年代に関する項目の選択状況を管理するマップの初期値（空文字）を設定
		for (int i = 0; i < this.keysForThickness.length; i++) {
			selectedValueMapForHardness.put(this.keysForThickness[i], this.emptyString);
		}
		return selectedValueMapForHardness;
	}
	
	/*
	 * 利用目的：選択された値(Mapのkey)と一致するMapのvalueにselectedをセット
	 *　　　　　 選択されていない値(Mapのkey)のMapのvalueに空文字をセットする
	 * 第1引数 ；各選択状況を管理しているMap
	 * 第2引数 ；各選択状況を管理しているMapのKey
	 * 第3引数 ；選択された値（SearchParamsの各フィールド getterで取れる）
	 * 戻り値  ：選択状況の現状が入った各Map
	 */
	
	private Map<String,String> checkSelectedValue(Map<String,String> eachSelectedValueMap,
												  String[]           eachKeysForMap,
												  String             selectedValue) {
		
		for (int i = 0; i < eachSelectedValueMap.size(); i++) {
			if (eachKeysForMap[i].equals(selectedValue)) {
				eachSelectedValueMap.put(eachKeysForMap[i], "selected");
			}
			if (!eachKeysForMap[i].equals(selectedValue)) {
				eachSelectedValueMap.put(eachKeysForMap[i], this.emptyString);
			}
		}
		
		return eachSelectedValueMap;
	}
	
	/*
	 * 利用目的：input type="text"のコントロールに値が有れば
	 *        　Mapの任意のkeyに入力された値をvalueとしてセットする
	 * 第1引数 ；各選択状況を管理しているMap
	 * 第2引数 ；各選択状況を管理しているMapのKey
	 * 第3引数 ；選択された値（SearchParamsの各フィールド getterで取れる）
	 * 戻り値  ：選択状況の現状が入った各Map
	 */
	private Map<String,String> checkInputedValue(Map<String,String> eachInputedValueMap,
			  									 String[]           eachKeysForMap,
			  									 String             inputedValue) {
		
		for (int i = 0; i < eachInputedValueMap.size(); i++) {
			if (!this.emptyString.equals(inputedValue)) {
				eachInputedValueMap.put(eachKeysForMap[i], inputedValue);
			}
			if(this.emptyString.equals(inputedValue)) {
				eachInputedValueMap.put(eachKeysForMap[i], this.emptyString);
			}
		}
		return eachInputedValueMap;
	}

	public String[] getKeyForNameMap() {
		return keyForNameMap;
	}

	public String[] getKeysForDecadeMap() {
		return keysForDecadeMap;
	}

	public String[] getKeysForKindMap() {
		return keysForKindMap;
	}

	public String[] getKeysForHardness() {
		return keysForHardness;
	}

	public String[] getKeysForThickness() {
		return keysForThickness;
	}

	
}
