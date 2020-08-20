
/**
 * A simple method to find the start with ATG and end with TAA codon and 
 * verified if it contain a gene.
 * 
 * @Wenda Zheng
 * @version 0.01
 */
public class Part1 {
    public String findSimpleGene(String s){
        //find the start condon ATG
        int startIndex = s.indexOf("ATG");
        int stopIndex = s.indexOf("TAA", startIndex);
        if (stopIndex == -1){
            return "";
        } else {
            if ( (stopIndex - startIndex) % 3 == 0 ){
                return s.substring(startIndex, stopIndex + 3);
            } else {
                return "";
            }
            
        }
    }
    
    public void testSimpleGene () {
        String A = "AATATGTAGGGATAA";
        String B = "AATATATAGGGATAA";
        String C = "AATATATAGGGATAG";
        String D = "AATATGTAGGGAGTAA";
        System.out.println(findSimpleGene(A));
        System.out.println(findSimpleGene(B));
        System.out.println(findSimpleGene(C));
        System.out.println(findSimpleGene(D));
    }
}
