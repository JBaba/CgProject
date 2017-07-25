package leetcode.sol.extra;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CH5 ABI ABA AUW CFC CHC CS1 CS2 CWI CHT DDS DHM MFP PCA SPM SPD OTH
		
		List<UaAssessmentResultsCargo> cargos = new ArrayList<>();
		cargos.add(new UaAssessmentResultsCargo("DDS"));
		cargos.add(new UaAssessmentResultsCargo("ABI"));
		cargos.add(new UaAssessmentResultsCargo("OTH"));
		cargos.add(new UaAssessmentResultsCargo("CS1"));
		
		Map<String,UaAssessmentResultsCargo> waiverMap = new HashMap<>();
		
		if (!cargos.isEmpty()) {
			for (UaAssessmentResultsCargo cargo : cargos) {
				waiverMap.put(cargo.getBasasmtCd(), cargo);
			}
		}
		
		List<UaAssessmentResultsCargo> ordered = new ArrayList<UaAssessmentResultsCargo>();
		if(waiverMap.get("CH5")!=null)
			ordered.add(waiverMap.get("CH5"));
		if(waiverMap.get("ABI")!=null)
			ordered.add(waiverMap.get("ABI"));
		if(waiverMap.get("ABA")!=null)
			ordered.add(waiverMap.get("ABA"));
		if(waiverMap.get("AUW")!=null)
			ordered.add(waiverMap.get("AUW"));
		if(waiverMap.get("CFC")!=null)
			ordered.add(waiverMap.get("CFC"));
		if(waiverMap.get("CHC")!=null)
			ordered.add(waiverMap.get("CHC"));
		if(waiverMap.get("CS1")!=null)
			ordered.add(waiverMap.get("CS1"));
		if(waiverMap.get("CS2")!=null)
			ordered.add(waiverMap.get("CS2"));
		if(waiverMap.get("CWI")!=null)
			ordered.add(waiverMap.get("CWI"));
		if(waiverMap.get("CHT")!=null)
			ordered.add(waiverMap.get("CHT"));
		if(waiverMap.get("DDs")!=null)
			ordered.add(waiverMap.get("DDS"));
		if(waiverMap.get("DHM")!=null)
			ordered.add(waiverMap.get("DHM"));
		if(waiverMap.get("MFP")!=null)
			ordered.add(waiverMap.get("MFP"));
		if(waiverMap.get("PCA")!=null)
			ordered.add(waiverMap.get("PCA"));
		if(waiverMap.get("SPM")!=null)
			ordered.add(waiverMap.get("SPM"));
		if(waiverMap.get("SPD")!=null)
			ordered.add(waiverMap.get("SPD"));
		if(waiverMap.get("OTH")!=null)
			ordered.add(waiverMap.get("OTH"));
	}

}

class UaAssessmentResultsCargo{
	public String basasmtCd = "";

	public UaAssessmentResultsCargo(String w) {
		this.basasmtCd = w;
	}
	
	public String getBasasmtCd() {
		return basasmtCd;
	}

	public void setBasasmtCd(String basasmtCd) {
		this.basasmtCd = basasmtCd;
	}
	
}
