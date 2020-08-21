
/**
 * Write a description of Part3 here.
 * 
 * @author (Wenda Zheng
 * @version (0.01
 */
public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int stopIndex;
        stopIndex = dna.indexOf(stopCodon, startIndex);
        if ((stopIndex - startIndex) % 3 == 0) {
            return stopIndex;
        } else {
            return dna.length();
        }
        
    }
    
    public void testFindStopCodon() {
        int testa = findStopCodon("ATTTAATAATAG", 0, "TGG");
        System.out.println(testa);
    }
    
    public String findGene(String dna,int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        int tagTaa = findStopCodon(dna, startIndex, "TAA");
        int tagTag = findStopCodon(dna, startIndex, "TAG");
        int tagTga = findStopCodon(dna, startIndex, "TGA");
        int tagMin = 0;
        
        if (tagTaa == -1 || ( tagTga != -1 && tagTga < tagTaa)) {
            tagMin = tagTga;
        } else {
            tagMin = tagTaa;
        }
        if (tagMin == -1 || ( tagTag != -1 && tagTag < tagMin)) {
            tagMin = tagTag;
        }
        if (tagMin == -1) {
            return "";
        }
        return dna.substring(startIndex, tagMin +3);
    }
    
    public int countGenes (String dna){
        int startIndex = 0;
        int geneCount = 0;
        
        while ( true ){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            geneCount += 1;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneCount;
    }
    
    public void testCountGenes (){
        int n = countGenes("ATGTAAGATGCCCTAGT");
        System.out.println(n);
        
    }

}
