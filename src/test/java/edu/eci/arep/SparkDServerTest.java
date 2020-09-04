package edu.eci.arep;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SparkDServerTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SparkDServerTest(String testName )
    {
        super( testName );
    }

    /**
     * Suite test.
     *
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SparkDServerTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
