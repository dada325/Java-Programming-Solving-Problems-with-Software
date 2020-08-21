
/**
 * Write a description of Part2 here.
 * 
 * @author Wenda Zheng
 * @version 0.01
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int startIndex = 0;
        int matchCount = 0;
        int matchIndex = 0;
        while ( true ){
            matchIndex = stringb.indexOf(stringa, startIndex);
            if (matchIndex != -1) {
                matchCount += 1;
                startIndex = matchIndex + stringa.length();
            } else {
                break;
            }
            
        }
        return matchCount;
    }
    
    public void test(){
        int a = howMany("AA","ATAAAA");
        System.out.println(a);
    }

}


