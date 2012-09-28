package pl.edu.icm.coansys.metaextr.metadata.zoneclassification.features;

import pl.edu.icm.coansys.metaextr.tools.classification.features.FeatureCalculator;
import pl.edu.icm.coansys.metaextr.structure.model.BxPage;
import pl.edu.icm.coansys.metaextr.structure.model.BxZone;

public class BracketRelativeCount implements FeatureCalculator<BxZone, BxPage> {

	private static String featureName = "BracketRelativeCount";
	
	@Override
	public String getFeatureName() {
		return featureName;
	}

	@Override
	public double calculateFeatureValue(BxZone zone, BxPage page) {
		double brackets = new BracketCountFeature().calculateFeatureValue(zone, page);
		double chars = new CharCountFeature().calculateFeatureValue(zone, page);
		return brackets/chars; 
	}
}
