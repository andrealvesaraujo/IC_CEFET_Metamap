import java.util.List;

import gov.nih.nlm.nls.metamap.Ev;
import gov.nih.nlm.nls.metamap.Mapping;
import gov.nih.nlm.nls.metamap.MetaMapApi;
import gov.nih.nlm.nls.metamap.MetaMapApiImpl;
import gov.nih.nlm.nls.metamap.PCM;
import gov.nih.nlm.nls.metamap.Result;
import gov.nih.nlm.nls.metamap.Utterance;

public class EntradaGrande {
public static void main(String[] args) throws Exception{
		
		MetaMapApi api = new MetaMapApiImpl();
		List<Result> resultList = api.processCitationsFromString(
				"Had infusions of both Actemra & Rituxan only had strange side effects during 2nd Rituxan infusion."
				+ "Turns out my sore throat is from an inflamed larynx, which is pretty normal for people who have dry throat and/or use their voices a lot, but it sucks still."
				+ "I'm on pain meds and antibiotics and sleeping a lot til I see my regular dentist on Wednesday. ");
	    int totalMap=0;
	    int totalEv=0;
	    
	    for(Result r : resultList){
	    	for(Utterance ut : r.getUtteranceList()){
	    		//System.out.println(ut);
	    		for(PCM pcm: ut.getPCMList()){
	    			
	    			System.out.println("Phrase:" + pcm.getPhrase().getPhraseText());
	    			if(pcm.getMappingList().size() == 0){
	    				System.out.println("Não foi mapeado");
	    			}
	    			for(Mapping m :pcm.getMappingList()){
	    				
	    				totalMap++;
	    				System.out.println("Unico mapeamento ");
	    				for(Ev v : m.getEvList()){
	    					System.out.println("[Score]" +  v.getScore());
	    					System.out.println("[ID] "+v.getConceptId() +" [Conceito] " + v.getConceptName() +" [Preferido] "+ v.getPreferredName());
	    					System.out.println("[Grupos Semanticos] "+v.getSemanticTypes());
	    					System.out.println("[Fontes] " + v.getSources());
	    					System.out.println();
	    					totalEv++;
	    				}
	    				break;
	    			}
	    			System.out.println("------------------------------------");
    				
	    			
	    		}
	    	}
	    }
	    
	    System.out.println("Total de mapeamentos " + totalMap);
	    System.out.println("Total de conceitos " + totalEv);
	}

}
