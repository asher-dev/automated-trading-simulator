package autotradingsim.engine;

import autotradingsim.application.*;
import autotradingsim.strategy.*;
import autotradingsim.strategy.ICondition.Comparator;
import autotradingsim.strategy.simpleimpl.SimpleStrategy;

import java.math.BigDecimal;

public class Engine {

	public TradingApplication TradingSimApp = TradingApplication.getInstance();
	public ExperimentEngine expEngine = ExperimentEngine.getInstance();
	public StrategyEngine stratEngine = StrategyEngine.getInstance();
	
	private Engine(){
		
	}

	
	
	
	
}
