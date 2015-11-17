package autotradingsim.experiment;
import autotradingsim.application.TradingApplication;

import autotradingsim.strategy.simpleimpl.SimpleStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bill Feng on 15-11-02.
 *
 */
public class ExperimentTest {

    @Test
    public void testExperimentName(){
        Experiment test1 = new Experiment("experiment1");
        assertEquals(test1.getName(),"experiment1");
    }

    @Test
    public void testExperimentSetName(){
        Experiment test2 = new Experiment("experiment1");
        test2.setName("experiment2");
        assertEquals(test2.getName(), "experiment2");
    }

    @Test
    public void testExperimentAddStock(){
        Experiment test3 = new Experiment("experiment3");
        assertEquals(test3.addStock("AAPL"), true);
    }

    @Test
    public void testAddingNonExistingStock(){
        Experiment test4 = new Experiment("experiment4");
        assertEquals(test4.addStock("LOL"),false);
    }

    @Test
    public void testExperimentAddStrategy(){
        Experiment test5 = new Experiment("experiment5");
        SimpleStrategy s = new SimpleStrategy();
        TradingApplication.getInstance().setStrategy(s.getName(), s);
        assertEquals(test5.addStrategy(s.getName()), true);
    }

    @Test
    public void testAddNonExistingStrategy(){
        Experiment test6 = new Experiment("experiment6");
        assertFalse(test6.addStrategy("nameA"));
    }

    @Test
    public void testRunExperiment1(){
        Experiment test7 = new Experiment("experiment7");
        test7.addStock("AAPL");
        test7.addStock("MSFT");

        SimpleStrategy s = new SimpleStrategy();
        String id = s.getName();
        //TradingApplication.getInstance().saveStrategy(s);

        test7.addTrial(id, "AAPL");
        test7.addTrial(id, "MSFT");

        test7.addStrategy(id);
        //TODO fix run experiment
        //test7.runExperiment();
    }
}