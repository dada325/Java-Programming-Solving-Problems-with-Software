
/**
 * A improve version of the Part 1. 
 * 
 * @author Wenda Zheng
 * @version 0.002
 */
public class Part2 {
    
    public String findSimpleGene(String dna_input){
        char[] array_dna = dna_input.toCharArray();
        //make sure the case is uppercase
        String dna = dna_input.toUpperCase();
        //find the start condon ATG
        int startCodon = dna.indexOf("ATG");
        int stopCodon = dna.indexOf("TAA", startCodon);
        if (stopCodon == -1){
            return "";
        } else {
            if ( (stopCodon - startCodon) % 3 == 0 ){
                if (Character.isUpperCase(array_dna[0])){
                    return dna.substring(startCodon, stopCodon + 3);
                } else {
                    return dna.substring(startCodon, stopCodon + 3).toLowerCase();
                }
                
            } else {
                return "";
            }
            
        }
    }
    
    public void testSimpleGene () {
        String A = "AAATGCCCTAACTAGATTAAGAAACC";
        String B = "AATATATAGGGATAA";
        String C = "AATATATAGGGATAG";
        String D = "AATATGTAGGGAGTAA";
        String E = "aatatgtagggataa";
        System.out.println(findSimpleGene(A));
        System.out.println(findSimpleGene(B));
        System.out.println(findSimpleGene(C));
        System.out.println(findSimpleGene(D));
        System.out.println(findSimpleGene(E));
    }

}
