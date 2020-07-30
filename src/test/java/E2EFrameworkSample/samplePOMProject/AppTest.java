package E2EFrameworkSample.samplePOMProject;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import resources.Base;

/**
 * Unit test for simple App.
 */
public class AppTest 

{
	
	public static Logger log = LogManager.getLogger(AppTest.class.getName());
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
