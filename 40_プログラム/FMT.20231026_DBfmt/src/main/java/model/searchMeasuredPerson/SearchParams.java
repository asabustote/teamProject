package model.searchMeasuredPerson;

public class SearchParams {
	//MeasuredFootDAOクラスのsearchMeasuredPersonメソッドへsearchMeasuredpersonByIdメソッドを統合の為
//	private int	measuredPersonId; ゆくゆく仕様予定 Oct 19th 23 
	private String name;
	private String kind;
	private String decade;
	private String hardness;
	private String thickness;
	
	public SearchParams () {}
	
	public SearchParams (
						 //int	 measuredPersonId, ゆくゆく仕様予定 Oct 19th 23
						  String name,
						  String kind,
						  String decade,
						  String hardness,
						  String thickness
						  ){
						
//						  this.measuredPersonId = measuredPersonId; ゆくゆく仕様予定 Oct 19th 23
						  this.name      = name;
						  this.kind      = kind;
						  this.decade    = decade;
						  this.hardness  = hardness;
						  this.thickness = thickness;
						  
	}

	
	public String getName() {
		return name;
	}

	public String getKind() {
		return kind;
	}

	public String getDecade() {
		return decade;
	}

	public String getHardness() {
		return hardness;
	}

	public String getThickness() {
		return thickness;
	};
	
}
