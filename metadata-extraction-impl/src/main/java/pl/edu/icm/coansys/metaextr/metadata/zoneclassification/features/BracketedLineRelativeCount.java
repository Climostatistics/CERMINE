package pl.edu.icm.coansys.metaextr.metadata.zoneclassification.features;

import pl.edu.icm.coansys.metaextr.tools.classification.features.FeatureCalculator;
import pl.edu.icm.coansys.metaextr.structure.model.BxLine;
import pl.edu.icm.coansys.metaextr.structure.model.BxPage;
import pl.edu.icm.coansys.metaextr.structure.model.BxZone;

public class BracketedLineRelativeCount implements FeatureCalculator<BxZone, BxPage> {
	private static String featureName = "BracketedRelativeLineCount";
	
	@Override
	public String getFeatureName() {
		return featureName;
	}

	@Override
	public double calculateFeatureValue(BxZone zone, BxPage page) {
		int lines = 0;
		int bracketedLines = 0;
		
		for(BxLine line: zone.getLines()) {
			++lines;
			if(line.toText().charAt(0) == '[' || line.toText().charAt(0) == ']')
				++bracketedLines;
		}
		return (new Double(bracketedLines))/(new Double(lines));
	}
}
