package models;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Responsavel por controlar a digitação dos campos de numero
 *
 * @author Tiago Teixeira
 */
public class ClsControlaCpNumeric extends PlainDocument {

    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException {
        super.insertString(offset, str.replaceAll("[^0-9|^,|^.|^R|^$]", ""), attr);

    }

    public void replace(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException {
        super.insertString(offset, str.replaceAll("[^0-9|^,|^.|^R|^$]", ""), attr);

    }

}
