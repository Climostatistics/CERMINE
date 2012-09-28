package pl.edu.icm.coansys.metaextr.metadata.zoneclassification.features;

import pl.edu.icm.coansys.metaextr.tools.classification.features.FeatureCalculator;
import pl.edu.icm.coansys.metaextr.structure.model.BxLine;
import pl.edu.icm.coansys.metaextr.structure.model.BxPage;
import pl.edu.icm.coansys.metaextr.structure.model.BxWord;
import pl.edu.icm.coansys.metaextr.structure.model.BxZone;

/**
 *
 * @author Dominika Tkaczyk (d.tkaczyk@icm.edu.pl)
 */
public class UppercaseWordRelativeCountFeature implements FeatureCalculator<BxZone, BxPage> {

    private static String featureName = "UppercaseWordRelativeCount";

    @Override
    public String getFeatureName() {
        return featureName;
    }

    @Override
    public double calculateFeatureValue(BxZone zone, BxPage page) {
        int count = 0;
        int allCount = 0;
        for (BxLine line : zone.getLines()) {
            for (BxWord word : line.getWords()) {
                allCount++;
                if(!word.getChunks().isEmpty()) {
                	String s = word.getChunks().get(0).toText();
                	if (!s.isEmpty() && Character.isUpperCase(s.charAt(0))) {
                		count++;
                	}
                }
            }
        }
        return (double) count / (double) allCount;
    }
}
