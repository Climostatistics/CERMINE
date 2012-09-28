package pl.edu.icm.coansys.metaextr.metadata.zoneclassification.features;

import pl.edu.icm.coansys.metaextr.tools.classification.features.FeatureCalculator;
import pl.edu.icm.coansys.metaextr.structure.model.BxChunk;
import pl.edu.icm.coansys.metaextr.structure.model.BxLine;
import pl.edu.icm.coansys.metaextr.structure.model.BxPage;
import pl.edu.icm.coansys.metaextr.structure.model.BxWord;
import pl.edu.icm.coansys.metaextr.structure.model.BxZone;

/** 
 * @author Pawel Szostek (p.szostek@icm.edu.pl) 
 */

public class FontHeightMeanFeature implements FeatureCalculator<BxZone, BxPage> {

    private static String featureName = "FontHeightMean";

    @Override
    public String getFeatureName() {
        return featureName;
    }

    @Override
    public double calculateFeatureValue(BxZone zone, BxPage page) {
    	Double heightSum = 0.0;
    	Integer heightNumber = 0;
    	for(BxLine line: zone.getLines())
    		for(BxWord word: line.getWords())
    			for(BxChunk chunk: word.getChunks()) {
    				heightSum += chunk.getBounds().getHeight();
    				++heightNumber;
    			}
    	return heightSum/heightNumber;
    }

}
