package autotradingsim.application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import autotradingsim.experiment.*;
import autotradingsim.stocks.IStock;
import autotradingsim.stocks.StockLoader;
import autotradingsim.strategy.*;

public class TradingApplication implements ITradingApplication {
	
	private String PathToExperiments;
	private String PathToStrategies;
	
	private HashMap<Integer, IStrategy> strategies;
	private HashSet<String> strategyNames;
	
	private HashMap<Integer, IExperiment> experiments;
	private HashSet<String> experimentNames;
	
	private StockLoader loader;
	private HashMap<String, IStock> stocks;

	private static TradingApplication instance = null;
	
	protected TradingApplication() {
		this.loader = new StockLoader();
		
		this.strategies = new HashMap<Integer, IStrategy>();
		this.strategyNames = new HashSet<String>();
		
		this.experiments = new HashMap<Integer, IExperiment>();
		this.experimentNames = new HashSet<String>();
		
		this.stocks = new HashMap<String, IStock>();
		
		PathToExperiments = System.getProperty("user.dir") + "//DATA//EXPERIMENTS//";
		PathToStrategies = System.getProperty("user.dir") + "//DATA//STRATEGIES//";
		
		instance = this;
		
		//Initialize Directory for storing experiments
		File experimentDir = new File(PathToExperiments);
		if(!experimentDir.exists())
			experimentDir.mkdir();
		
		//Initialize Directory for storing strategies
		File strategyDir = new File(PathToStrategies);
		if(!strategyDir.exists())
			strategyDir.mkdir();
	}
	
	public static TradingApplication getInstance(){
		if (instance == null){
			instance = new TradingApplication();
		}
		return instance;
	}
	
	/**
	 * Add an experiment by name into the application
	 * Name given and name found in experiment don't need
	 * to match, but after being loaded, must use name found
	 * in IExperiment class
	 * 
	 * @param experimentName name under which to store experiment
	 * @param experiment Experiment object which will be stored
	 * @return true if experiment added into Application successfully
	 */
	@Override
	public boolean setExperiment(String experimentName, IExperiment experiment){
		if(experiment == null || experimentName == null)
			return false;
		
		if(experiments.containsKey(experimentName.hashCode())){
			assert(experimentNames.contains(experimentName));
			return false;
		}
		experimentNames.add(experimentName);
		experiments.put(experimentName.hashCode(), experiment);
		
		this.saveExperiment(experiment);
		return true;
	}

	/**
	 * Return experiment object associated with given name
	 * Tries to load the experiment from memory if able
	 * 
	 * @param experimentName ID associated with experiment
	 * @return experiment object found with ID. Null if no experiment by name found
	 */
	@Override
	public IExperiment getExperiment(String experimentName){
		if(experiments.containsKey(experimentName.hashCode())){
			return experiments.get(experimentName.hashCode());
		}else{
			IExperiment result = loadExperiment(experimentName);
			if(result != null)
				this.setExperiment(experimentName, result);
			return result;
		}
	}
	
	/**
	 * Save an experiment to file. Experiment is saved by it's given name.
	 * 
	 * @param experiment which will be saved to file under EXPERIMENTS dir
	 */
	private void saveExperiment(IExperiment experiment){
		String path = PathToExperiments + experiment.getName() + ".bin";
		File experimentFileObj = new File(path);
		ObjectOutputStream serializer = null;
		FileOutputStream experimentFile = null;
		try {
			if(!experimentFileObj.exists())
				experimentFileObj.createNewFile();
		} catch (IOException e) {
			System.err.println("Error in creating file for saving the experiment");
			e.printStackTrace();
			return;
		}
		try{
			experimentFile = new FileOutputStream(experimentFileObj);
			serializer = new ObjectOutputStream(experimentFile);
			serializer.writeObject(experiment);
			serializer.close();

		}catch (IOException e) {
			try {
				if(serializer != null)
					serializer.close();
			} catch (IOException e1) {
				assert("false" == "this should never happen");
				e1.printStackTrace();
			}
			experimentFileObj.delete();
			System.err.println("IO Exception occured in saving experiment");
			e.printStackTrace();
		}
	}
	
	/**
	 * Load experiment from memory with given name. 
	 * Null on error with error printed to System.err
	 * 
	 * @param name of experiment to load
	 * @return experiment in file or null on error
	 */
	private IExperiment loadExperiment(String name){
		String path = PathToExperiments + name + ".bin";
		File experimentFileObj = new File(path);
		ObjectInputStream serializer = null;
		FileInputStream experimentFile = null;
		IExperiment result = null;
		
		if(!experimentFileObj.exists())
			return result;
		
		try {
			experimentFile = new FileInputStream(experimentFileObj);
			serializer = new ObjectInputStream(experimentFile);
			result = (IExperiment) serializer.readObject();
			serializer.close();
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error loading experiment from memory");
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * get all available experiment names in application
	 * @return a set of experiment names
	 */
	public Set<String> getAvailableExperiments(){
		File experiments = new File(this.PathToExperiments);
		Set<String> returningSet = new HashSet<String>();
		if(experiments.exists() && experiments.isDirectory()){
			for(File experiment : experiments.listFiles())
				returningSet.add(experiment.getName());
		}
		return returningSet;
	}

	/**
	 * Add a strategy by name into the application
	 * StrategyName should match with name found under newStrat object
	 * 
	 * @param StrategyName name under to which to store experiment
	 * @param newStrat IStrategy object which is to be added to application
	 * @return true if strategy added successfully into application
	 */
	@Override
	public boolean setStrategy(String stratName, IStrategy strat){
		if(strategies.containsKey(stratName.hashCode())) {
			assert(strategyNames.contains(stratName));
			return false;
		}
		strategyNames.add(stratName);
		strategies.put(stratName.hashCode(), strat);
		return true;
	}
	

	/**
	 * Retrieves a strategy by it's given name
	 * 
	 * @param stratname strategy name which was used to store strategy
	 * @return strategy with the associated name or null on none found
	 */
	@Override
	public IStrategy getStrategy(String stratName){
		return strategies.get(stratName.hashCode());
	}
	
	/**
	 * return a set of available strategies loaded into memory
	 * @return set of names of strategies
	 */
	@Override
	public Set<String> getAvailableStrategies() {
		Set<String> returningSet = new HashSet<String>();
		for(String name : this.strategyNames)
			returningSet.add(name);
		return returningSet;
	}

	
	/**
	 * Loads a Stock to memory.
	 * @param symbol: String representing the stock symbol to be loaded.
	 */
	private void loadStock(String symbol){
		if (this.stockExists(symbol)){
			stocks.put(symbol, this.loader.fetchStock(symbol));
		}
	}
	
	/**
	 * Retrieve a Stock from application. This is a lazy loading method, 
	 * will only retrieve a Stock when asked for.
	 * @param symbol:
	 * @return
	 */
	public IStock getStock(String symbol) {
		if (stocks.containsKey(symbol)){
			return this.stocks.get(symbol);
		} else {
			this.loadStock(symbol);
			return this.stocks.get(symbol);
		}
    }
	
	/**
	 * Check if a Stock symbol is available in data.
	 * @param symbol: String of a stock symbol, not case sensitive.
	 * @return true if stock exists in data, false otherwise.
	 */
	public boolean stockExists(String symbol) {
        return loader.exists(symbol);
    }
	
	/**
	 * Get an iterator of loaded stock symbols.
	 * @return Iterator<String> of stock symbols that are loaded.
	 */
	public Iterator<String> getStockSymbols(){
		// TODO Change this so we can get a list of all possible stocks.
		return this.stocks.keySet().iterator();
	}

	/**
	 * Clear the Applications internal cache
	 */
	@Override
	public void clearMemory() {
		strategies.clear();
		strategyNames.clear();
		
		experiments.clear();
		experimentNames.clear();

		stocks.clear();
	}
	
	/**
	 * Destroy the instance of the object and set it to null
	 */
	public static void destructObject() {
		instance.clearMemory();
		instance = null;
	}
}