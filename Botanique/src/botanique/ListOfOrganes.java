/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botanique;

import java.util.ArrayList;

/**
 *
 * @author stagjava
 */
public class ListOfOrganes extends ArrayList<Organable> {
    
    public LOOIterator getIterator() {
        return new LOOIterator(this);
    }
}
