import edu.duke.*;

/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
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
    
    public String findGene (String dna,int where) {
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
    
    public void testFindGene (){
        String dna = "ATGTTTCCCTAACCC";
        System.out.println(findGene(dna, 0));
        
    }
    
    public void printAllGenes(String dna){
        int startIndex = 0;
        
        while ( true ){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }
    
    public StorageResource getAllGenes(String dna){
        StorageResource sr = new StorageResource();
        
        int startIndex = 0;
        
        while ( true ){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            sr.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return sr;
    }
    
    
    public double cgRatio(String dna) {
        char matchc = 'C';
        char matchg = 'G';
        double count = 0;
        double all = dna.length();
        // 
        for (int i = 0; i < dna.length(); i++) { 
            if (dna.charAt(i) == matchc || dna.charAt(i) == matchg){
                count += 1;
            }
        }
        double ratio = count / all;
        return ratio;
    }
    
    public int countCtg (String dna) {
        String toFind = "CTG";
        int startIndex = 0;
        int count = 0;
        
        while ( true ){
            if (dna.indexOf(toFind, startIndex) == -1) {
                break;
            }
            count += 1;
            startIndex = dna.indexOf(toFind, startIndex) + toFind.length();
        }
        return count;
    } 
    
    public void processGenes (StorageResource sr){
        for (String gene : sr.data()) {
            if (gene.length() > 9){
                System.out.println(gene);
            }
            
        }
        int countOf9 = 0;
        for (String gene : sr.data()) {
            if (gene.length() > 60){
                countOf9 += 1;
            }
            
        }
        System.out.println(countOf9);
        
        for (String gene : sr.data()){
            if (cgRatio(gene) > 0.35) {
                System.out.println(gene);
            }
        }
        
        int cgCount = 0;
        for (String gene : sr.data()){
            if (cgRatio(gene) > 0.35) {
                cgCount +=1;
            }
        }
        System.out.println(cgCount);
        
        int temp = 0;
        for (String gene : sr.data()){
            if (gene.length() > temp) {
                temp = gene.length();
            }
            
        }
        System.out.println(temp);
    }
    
    public void countAllGenes (StorageResource sr){
        int count = 0;
        for (String gene : sr.data()){ 
            count += 1;
        }
        System.out.println(count);
    }
    
    public void testProcessGenes() {
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        System.out.println(dna);
        printAllGenes(dna);
    }
}
