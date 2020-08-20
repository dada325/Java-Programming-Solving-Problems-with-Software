
/**
 * addition function to the String of the DNA
 * 
 * @author Wenda Zheng
 * @version 0.01
 */
public class Part3 {
    public boolean twoOccurrences (String stringa, String stringb) {
        // initiate the count of the string a in string b
        int n = 0;
        // loop over string b
        while (stringb.indexOf(stringa) != - 1) {
            n += 1;
            int startIndex = stringb.indexOf(stringa) + stringa.length();
            stringb = stringb.substring(startIndex);
        }
        
        if ( n > 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public String lastPart ( String stringa, String stringb) {
        int startIndex = stringb.indexOf(stringa);
        if (startIndex == -1){
            return stringb;
        } else {
            return stringb.substring( startIndex + stringa.length());
        }
    }
    
    
    public void testing () {
        //test 
        System.out.println(twoOccurrences ("a", "banana"));
        System.out.println(twoOccurrences ("by", "A story by Abby Long"));
        System.out.println(twoOccurrences ("atg", "ctgtatgta"));
        String stringa = "an";
        String stringb = "banana";
        System.out.println("The part of the string after "+ stringa +" in " + stringb + " is " + lastPart(stringa, stringb) + ".");
    }
}
