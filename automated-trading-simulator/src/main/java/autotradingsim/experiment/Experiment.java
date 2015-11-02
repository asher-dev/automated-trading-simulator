package autotradingsim.experiment;

import autotradingsim.stocks.*;
import autotradingsim.strategy.Strategy;

import java.util.ArrayList;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill, Shirley
 * 
 * Experiments apply Strategies to particular stocks over a set of time periods.
 *
 * Public Methods:
 *      addStock(String)
 * 
 * Modifications on 2015-10-30
 * -changes to experiment constructor to include name
 */
public class Experiment implements IExperiment {

    StockLoader loader;
    ArrayList<IStock> stocks;
    ArrayList<Strategy> strategies;
    String name;
    public Experiment(String name){
        this.loader = new StockLoader();
        this.stocks = new ArrayList<>();
        this.strategies = new ArrayList<>();
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    /**
     * Use a StockLoader to fetchStockDateRange a stock with the given symbol, if it does not exist in the sample already
     *
     * @param symbol the symbol of a stock
     */
    @Override
    public void addStock(String symbol){
        boolean existing = false;
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                existing = true;
            }
        }
        if(!existing) {
            IStock temp = loader.fetchStock(symbol);
            if (temp != null) {
                stocks.add(temp);
            }
        }
    }

    @Override
    public Stock getStock(String symbol) {
        return null;
    }

    @Override
    public void addStrategy(String name){

    }

    @Override
    public Strategy getStrategy(String name){
        return null;
    }
}
