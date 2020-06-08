/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.testjunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;

/**
 *
 * @author stagjava
 */
public class RectangleTest {
    
    public RectangleTest() {
    }
    @Test
    public void testGetSurface() {
        Rectangle r = new Rectangle(3,4);
        int res = r.getSurface();
        assertEquals(12, res);
    }
    @Test
    @Timeout(100)
    public void testGetPerimetre() {
        Rectangle r = new Rectangle(3,4);
        int res = r.getPerimetre();
        assertEquals(14, res);
        
    }
}
