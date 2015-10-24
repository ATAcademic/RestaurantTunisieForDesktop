package esprit.rt.utilities;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

/**
 *
 * @author Pingouins du désert
 * 
 */

public class FontsPartieRestaurateur {
    private Font fTitle, fLbl, fBtn, fTxtField;
    public static final int TITLE=0, LABEL=1, BUTTON=2, TXTFIELD=3;
    
    public Font getFont(int fontcode) throws FontFormatException, IOException
    {
        switch (fontcode)
        {
            case TITLE:
                Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/track.ttf"));
            case LABEL:
                return Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/onramp.ttf"));
            case BUTTON:
                return Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/franchise_bold.ttf"));
            case TXTFIELD:
                return Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/lato.ttf"));
        }       
        return null;
    }
    public Font getFont(int fontcode, float size) throws FontFormatException, IOException
    {
        switch (fontcode)
        {
            case TITLE:
                Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/track.ttf")).deriveFont(size);
            case LABEL:
                return Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/onramp.ttf")).deriveFont(size);
            case BUTTON:
                return Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/franchise_bold.ttf")).deriveFont(size);
            case TXTFIELD:
                return Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/lato.ttf")).deriveFont(size);
        }       
        return null;
    }
}
