/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botanique;

/**
 *
 * @author stagjava
 */
public class LOOIterator {
    private ListOfOrganes list;
    private int current;
    
    public LOOIterator (ListOfOrganes list) {
        this.list = list;
        current = 0;
    }
    
    public Organable next() {
        current++;
        if (current < list.size()) {
            return list.get(current);
        } else {
            return null;
        }
    }
    
    public boolean hasNext() {
        if (current < list.size())
            return true;
        else return false;
    }
}
