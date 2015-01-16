/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Objektit.Kortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juuso
 */
public class KorttiTest {
    
    public KorttiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    private boolean UusiKorttiTiedotOikeat(int numero, int maa) {
        Kortti kortti = new Kortti(numero, maa);
        if (kortti.getNumero() == numero && kortti.getMaa() == maa) {
            return true;
        }
        return false;
    }
    @Test
    public void hertta8LuontiTesti() {
        assertEquals(true, UusiKorttiTiedotOikeat(8,Kortti.MAA_HERTTA));
    }
    
    @Test
    public void ristiAssaLuontiTesti() {
        assertEquals(true, UusiKorttiTiedotOikeat(Kortti.NUMERO_ASSA,Kortti.MAA_RISTI));
    }
}
