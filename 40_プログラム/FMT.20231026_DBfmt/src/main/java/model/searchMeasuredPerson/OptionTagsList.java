package model.searchMeasuredPerson;

import java.io.Serializable;
import java.util.List;

public class OptionTagsList implements Serializable {
	private List<String> decadeOptionTagList;
	private List<String> kindOptionTagList;
	private List<String> hardnessOptionTagList;
	private List<String> thicknessOptionTagList;
	
	public OptionTagsList () {};

	public List<String> getDecadeOptionTagList() {
		return decadeOptionTagList;
	}

	public void setDecadeOptionTagList(List<String> decadeOptionTagList) {
		this.decadeOptionTagList = decadeOptionTagList;
	}

	public List<String> getKindOptionTagList() {
		return kindOptionTagList;
	}

	public void setKindOptionTagList(List<String> kindOptionTagList) {
		this.kindOptionTagList = kindOptionTagList;
	}

	public List<String> getHardnessOptionTagList() {
		return hardnessOptionTagList;
	}

	public void setHardnessOptionTagList(List<String> hardnessOptionTagList) {
		this.hardnessOptionTagList = hardnessOptionTagList;
	}

	public List<String> getThicknessOptionTagList() {
		return thicknessOptionTagList;
	}

	public void setThicknessOptionTagList(List<String> thicknessOptionTagList) {
		this.thicknessOptionTagList = thicknessOptionTagList;
	}
}
