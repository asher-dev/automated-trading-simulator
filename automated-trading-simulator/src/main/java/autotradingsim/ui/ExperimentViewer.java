package autotradingsim.ui;
import autotradingsim.application.*;
import autotradingsim.engine.*;
import autotradingsim.experiment.*;
import autotradingsim.strategy.IDecision;
import autotradingsim.strategy.IStrategy;
import java.time.LocalDate;
import javax.swing.*;
import java.util.*;
import autotradingsim.util.Pair;
import java.lang.String;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author Bill Feng
 */
public class ExperimentViewer extends javax.swing.JFrame {

    /**
     * Creates new form ExperimentViewer
     */
    ExperimentList parent;
    TradingApplication application = TradingApplication.getInstance();
    ExperimentEngine experimentEngine = ExperimentEngine.getInstance();
    DefaultListModel strategyListModel = new DefaultListModel();
    DefaultListModel stockListModel = new DefaultListModel();
    IExperiment experiment;
    //IExperiment experiment = application.getExperiment(name.getText());
    public ExperimentViewer(ExperimentList parent, IExperiment experiment) {
        this.parent = parent;
        initComponents();
        this.setLocation(parent.getX() + parent.getWidth()/2 - this.getWidth()/2,
                parent.getY() + parent.getHeight()/2 - this.getHeight()/2);
        startDate.setText("2015-10-16");
        endDate.setText("2015-10-17");
        strategyList.setModel(strategyListModel);
        stockList.setModel(stockListModel);
        this.experiment = experiment;
    }
    
    protected void settimeSetValidationField(){
        Pair<LocalDate, LocalDate> timeset= experimentEngine.generateTimeSet(experiment);
        if(timeset == null){
            //timeSetValidationField.setText("Experiment has no valid timeset");
        }else{
            //timeSetValidationField.setText("Valid time period: "+timeset.x+"-"+timeset.y);
        }
    }


    protected void setNameText(String filename){
        name.setText("Name: " + filename);
    }
    /**
     * populates strategy drop down with list of strategy
     */
    protected void setStrategyList(){
        for(IStrategy stratname: experiment.getAllStrategies()){
            strategyListModel.addElement(stratname.getName());
        }
    }
    /**
     * populates stock drop down with list of stock symbols
    */
    protected void setStockList(){
       // Iterator symbols = application.getStockSymbols();
        Set<String> stocks = experiment.getAllStockSymbols();
        for (String symbol : stocks) {
            stockListModel.addElement(symbol);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        strategyList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        stockList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        run = new javax.swing.JButton();
        addTrial = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        startDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        endDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        trials = new javax.swing.JSpinner();
        duration = new javax.swing.JSpinner();
        viewStocks = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Experiment Viewer");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        edit.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        edit.setText("Edit");
        edit.setPreferredSize(new java.awt.Dimension(150, 50));

        back.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        back.setText("Back");
        back.setPreferredSize(new java.awt.Dimension(150, 50));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        name.setText("Name: NAME_OF_EXPERIMENT");
        name.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("Strategies");

        strategyList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        strategyList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        strategyList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                strategyListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(strategyList);

        stockList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        stockList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(stockList);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Stocks");

        run.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        run.setText("Run");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        addTrial.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        addTrial.setText("Add Trial");
        addTrial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrialActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setText("Start Date:");

        startDate.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        startDate.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("End Date:");

        endDate.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        endDate.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("# of Trials:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel6.setText("Duration (days):");

        trials.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        duration.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        viewStocks.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        viewStocks.setText("See All Stocks");
        viewStocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStocksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                        .addGap(17, 17, 17)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewStocks, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(trials, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(duration))
                        .addGap(26, 26, 26)
                        .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(addTrial, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewStocks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addTrial, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2,
                this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void strategyListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_strategyListMouseClicked
        stockListModel.clear();
        Map<String, List<String>> strategyToStocks = this.experiment.getAllTrials();
        String strategy = (String)strategyListModel.get(strategyList.getSelectedIndex());
        strategyToStocks.keySet().stream().forEach((s) -> {
            //System.out.println(s);
        });
        for (Iterator<String> it = strategyToStocks.get(strategy).iterator(); it.hasNext();) {
            String stockname = it.next();
            stockListModel.addElement(stockname);
        }
    }//GEN-LAST:event_strategyListMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2, 
                           this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        this.setVisible(false);
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void addTrialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrialActionPerformed
        TrialPicker tp = new TrialPicker(this, true);
        Pair<String, String> trial = tp.run();
        experiment.addTrial(trial.x, trial.y);
        experimentEngine.saveExperiment(experiment);
        //application.addExperiment(experiment);
        strategyListModel.addElement(trial.x);
        stockListModel.addElement(trial.y);

    }//GEN-LAST:event_addTrialActionPerformed

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed

        // Retrieving All instantiate a TimeSet.
        int numTrials = (int) duration.getValue();
        int trialDuration = (int) trials.getValue();

        String[] startDateTokens = startDate.getText().trim().split("-");
        int startYear = Integer.parseInt(startDateTokens[0]),
                startMonth = Integer.parseInt(startDateTokens[1]),
                startDayOfMonth = Integer.parseInt(startDateTokens[2]);

        String[] endDateTokens = endDate.getText().trim().split("-");
        int endYear = Integer.parseInt(endDateTokens[0]),
                endMonth = Integer.parseInt(endDateTokens[1]),
                endDayOfMonth = Integer.parseInt(endDateTokens[2]);

        LocalDate startDate = LocalDate.of(startYear, startMonth, startDayOfMonth);
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDayOfMonth);
        TimeSet timeSet = new TimeSet(numTrials, trialDuration, startDate, endDate);

        dialogResult dialogResult; 
        dialogResult = new dialogResult(this, true, 
                experiment.getName());

        ExperimentResults experimentResults = this.experiment.runExperiment(timeSet);

        List<String> myResults = new ArrayList<String>(); 
        BigDecimal sumOfAssetsValue = BigDecimal.ZERO;
         for (int i = 0; i < experimentResults.size(); i++){
        	myResults.add("\n\nResults for timeset from: "
        			+ experimentResults.getResultAt(i).getStartDate().toString()
        			+ " to " + experimentResults.getResultAt(i).getEndDate().toString());
        	
                myResults.add("\nOpening balance: " + experimentResults.getResultAt(i).getOpeningBalance());
                
                List<ResultDay> results = experimentResults.getResultAt(i).getResultDays();
                ResultDay endDay = results.get(results.size()-1);
	        for (ResultDay result : results){
	        	myResults.add("\n\t" + result.getDate().toString());
                        
                        for(String decisionString : result.getDecisionStrings())
                            myResults.add("\n\t" + decisionString);
                        myResults.add("\n\t relative change: " + result.getClosingBalance().subtract(result.getOpeningBalance()));
                        List<Pair<String, Integer>> StockToShares = result.getNumShares();
                }
                BigDecimal assetsValue = BigDecimal.ZERO;
                for(Pair<String, Integer> StockToShare: endDay.getNumShares()){
                            BigDecimal sharesTotalValue = TradingApplication.getInstance()
                                    .getStock(StockToShare.x)
                                    .getDay(endDay.getDate())
                                    .getValue()
                                    .multiply(BigDecimal.valueOf(StockToShare.y));
                            myResults.add("\n\t"+StockToShare.x+" Number of Shares: "+StockToShare.y 
                                    + "\nValue of Shares: " + sharesTotalValue.toString());
                            assetsValue = assetsValue.add(sharesTotalValue);
                }
                
                myResults.add("\nClosing balance: " + experimentResults.getResultAt(i).getClosingBalance());
                myResults.add("\nTotal value of non-cash assets: " + assetsValue.toString());
                sumOfAssetsValue = sumOfAssetsValue.add(assetsValue);
        }
        if (experimentResults.size() != 0) {
            myResults.add("\n\nAverage value of assets across all trials: $" + sumOfAssetsValue.divide(BigDecimal.valueOf(experimentResults.size()), 
                    BigDecimal.ROUND_HALF_EVEN).toString());
        }
        
        System.out.println("setting result text");
        dialogResult.setResultText(myResults);
        
        dialogResult.setVisible(true);
    }//GEN-LAST:event_runActionPerformed

    private void viewStocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStocksActionPerformed
        // TODO add your handling code here:
        stockListModel.clear();
        setStockList();
    }//GEN-LAST:event_viewStocksActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTrial;
    private javax.swing.JButton back;
    private javax.swing.JSpinner duration;
    private javax.swing.JButton edit;
    private javax.swing.JTextField endDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel name;
    private javax.swing.JButton run;
    private javax.swing.JTextField startDate;
    private javax.swing.JList stockList;
    private javax.swing.JList strategyList;
    private javax.swing.JSpinner trials;
    private javax.swing.JButton viewStocks;
    // End of variables declaration//GEN-END:variables
}
