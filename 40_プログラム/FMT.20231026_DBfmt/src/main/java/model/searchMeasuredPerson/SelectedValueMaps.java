package model.searchMeasuredPerson;

import java.io.Serializable;
import java.util.Map;

public class SelectedValueMaps implements Serializable {
	//名前の入力状況を管理するMap
	private Map<String,String> inputedValueMapForName;
	//年代の選択状況を管理するMap
	private Map<String,String> selectedValueMapForDecade;
	//性別（男性・女性・子ども）の選択状況を管理するMap
	private Map<String,String> selectedValueMapForKind;
	//硬さの選択状況を管理するMap
	private Map<String,String> selectedValueMapForHardness;
	//太さの選択状況を管理するMap
	private Map<String,String> selectedValueMapForThickness;
	
	public SelectedValueMaps () {};

	public Map<String, String> getInputedValueMapForName() {
		return inputedValueMapForName;
	}

	public void setInputedValueMapForName(Map<String, String> selectedValueMapForName) {
		this.inputedValueMapForName = selectedValueMapForName;
	}
	
	public Map<String, String> getSelectedValueMapForDecade() {
		return selectedValueMapForDecade;
	}

	public void setSelectedValueMapForDecade(Map<String, String> selectedValueMapForDecade) {
		this.selectedValueMapForDecade = selectedValueMapForDecade;
	}

	public Map<String, String> getSelectedValueMapForKind() {
		return selectedValueMapForKind;
	}

	public void setSelectedValueMapForKind(Map<String, String> selectedValueMapForKind) {
		this.selectedValueMapForKind = selectedValueMapForKind;
	}

	public Map<String, String> getSelectedValueMapForHardness() {
		return selectedValueMapForHardness;
	}

	public void setSelectedValueMapForHardness(Map<String, String> selectedValueMapForHardness) {
		this.selectedValueMapForHardness = selectedValueMapForHardness;
	}

	public Map<String, String> getSelectedValueMapForThickness() {
		return selectedValueMapForThickness;
	}

	public void setSelectedValueMapForThickness(Map<String, String> selectedValueMapForThickness) {
		this.selectedValueMapForThickness = selectedValueMapForThickness;
	}
}
