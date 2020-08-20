
/**
 * Write a description of Part4 here.
 * 
 * @author Wenda Zheng
 * @version (a version number or a date)
 */

import edu.duke.*;

public class Part4 {
    
    public String getURL () {
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        // keyword to extract
        String key = "youtube.com";
        String output_url = "";
        for (String wordOriginal : ur.lines()) {
            String word = wordOriginal.toLowerCase();
            // iterate over the web page to check the youtube keyword
            if (word.indexOf(key) != -1) {
                int startPos = word.lastIndexOf("\"", word.indexOf(key));
                int endPos = word.indexOf("\"", word.indexOf(key));
                output_url += wordOriginal.substring(startPos, endPos + 1) + "\n";
            } else {
                ;
            }
        }
        return output_url;
    }
    
    public void testing () {
        String text = "";
        text = getURL();
        System.out.println("part 4 start");
        System.out.println(text);
    }

}

