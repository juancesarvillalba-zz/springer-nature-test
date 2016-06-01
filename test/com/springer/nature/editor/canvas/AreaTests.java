package com.springer.nature.editor.canvas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by juanvillalba on 31/05/16.
 */
public class AreaTests {

    Area area;

    @Before
    public void setUp() throws Exception {
        area = new Area(2, 5);
    }

    @Test
    public void newAreaShouldCreateAreaWithRightWidthAndHeight() {
        assertEquals(2, area.getWidth());
        assertEquals(5, area.getHeight());
    }

    @Test
    public void newAreaShouldInitializeElementsWithSpaceChar() {
        for (int i = 0; i < area.getHeight(); i++) {
            for (int j = 0; j < area.getWidth(); j++) {
                assertTrue(Character.isSpaceChar(area.getElement(i, j)));
            }
        }
    }

    @Test
    public void setElementShouldPutElementInTheRightPosition() {
        area.setElement(2, 4, 'D');
        assertEquals(Character.valueOf('D'), area.getElement(2, 4));
    }

    @Test
    public void setElementInAWrongPositionShouldNotSetTheElementAndReturnSpaceChar() {
        area.setElement(44, 55, 'D');
        assertEquals(Character.valueOf(' '), area.getElement(44, 55));
    }
}