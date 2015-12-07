package autotradingsim.ui;

import autotradingsim.application.TradingApplication;
import autotradingsim.engine.StrategyEngine;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.rules.IRule;
import autotradingsim.strategy.rules.Rule;
import autotradingsim.strategy.rules.RuleID;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Bill Feng
 */
public class StrategyViewer extends javax.swing.JFrame {
    
        
    /**
     * Creates new form StrategyViewer
     */
    StrategyList parent;
    DefaultListModel conditionListModel = new DefaultListModel();
    DefaultListModel actionListModel = new DefaultListModel();
    DefaultComboBoxModel actionBoxModel = new DefaultComboBoxModel();
    IStrategy strategy;
    StrategyEngine strategyEngine = StrategyEngine.getInstance();
    public StrategyViewer(StrategyList parent, IStrategy strategy) {
        this.parent = parent;
        initComponents();
        name.setText(strategy.getName());
        this.setLocation(parent.getX() + parent.getWidth()/2 - this.getWidth()/2,
                parent.getY() + parent.getHeight()/2 - this.getHeight()/2);
        ruleComboBox.setModel(actionBoxModel);
        conditionList.setModel(conditionListModel);
        //actionList.setModel(actionListModel);
        this.strategy = strategy;
        name.setText(strategy.getName());
        setRuleComboBox();
    }
    
    protected void setRuleComboBox(){
        Set<RuleID> rules = strategy.getRules();
        actionBoxModel.removeAllElements();
        rules.stream().forEach((ruleID) -> {
            actionBoxModel.addElement(strategy.getRuleName(ruleID));
        });
    }
    
    protected void setConditionList(){
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        conditionList = new javax.swing.JList();
        ruleComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        actionList = new javax.swing.JList();
        edit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        addCondition = new javax.swing.JButton();
        addAction = new javax.swing.JButton();
        deleteCondition = new javax.swing.JButton();
        deleteAction = new javax.swing.JButton();
        AddRuleButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Strategy Viewer");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        name.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Name: NAME_OF_STRATEGY");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("Conditions");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setText("Actions");

        conditionList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(conditionList);

        ruleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleComboBoxActionPerformed(evt);
            }
        });

        actionList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jScrollPane2.setViewportView(actionList);

        edit.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        edit.setText("Edit");
        edit.setPreferredSize(new java.awt.Dimension(100, 50));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        back.setText("Back");
        back.setPreferredSize(new java.awt.Dimension(100, 50));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        addCondition.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        addCondition.setText("Add New");
        addCondition.setPreferredSize(new java.awt.Dimension(190, 50));
        addCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addConditionActionPerformed(evt);
            }
        });

        addAction.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        addAction.setText("Add New");
        addAction.setPreferredSize(new java.awt.Dimension(190, 50));
        addAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionActionPerformed(evt);
            }
        });

        deleteCondition.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        deleteCondition.setText("Delete");
        deleteCondition.setPreferredSize(new java.awt.Dimension(190, 50));
        deleteCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteConditionActionPerformed(evt);
            }
        });

        deleteAction.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        deleteAction.setText("Delete");
        deleteAction.setPreferredSize(new java.awt.Dimension(190, 50));
        deleteAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionActionPerformed(evt);
            }
        });

        AddRuleButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddRuleButton.setText("Add Rule");
        AddRuleButton.setToolTipText("Open prompt window to add a new rule");
        AddRuleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddRuleButtonMouseClicked(evt);
            }
        });
        AddRuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRuleButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Viewing Rule:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(addCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteAction, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(addAction, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(ruleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AddRuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ruleComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(AddRuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteAction, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(addCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAction, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2,
                this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        dialogInput di = new dialogInput(this, true);
        String text = di.run();
        if(text.length() > 0){
            name.setText("Name: " + text);
        }
    }//GEN-LAST:event_editActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2,
                this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        this.setVisible(false);
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void addConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addConditionActionPerformed
        ConditionPicker cp = new ConditionPicker(this, true);
        String conditionName = cp.run();
        if(!conditionName.equals("") && !conditionListModel.contains(conditionName)){
            conditionListModel.addElement(conditionName);
        }
    }//GEN-LAST:event_addConditionActionPerformed

    private void addActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionActionPerformed
        ActionPicker ap = new ActionPicker(this, true);
        String actionName = ap.run();
        if(!actionName.equals("") && !actionListModel.contains(actionName)){
            actionListModel.addElement(actionName);
        }
    }//GEN-LAST:event_addActionActionPerformed

    private void deleteConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteConditionActionPerformed
        if(conditionList.getSelectedIndex() == -1){
            dialogMessage dm = new dialogMessage(this, true, "Select an item to delete!");
            dm.setVisible(true);
        }else{
            dialogConfirm dc = new dialogConfirm(this, true);
            if(dc.run()){
                conditionListModel.remove(conditionList.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_deleteConditionActionPerformed

    private void deleteActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionActionPerformed
        if(actionList.getSelectedIndex() == -1){
            dialogMessage dm = new dialogMessage(this, true, "Select an item to delete!");
            dm.setVisible(true);
        }else{
            dialogConfirm dc = new dialogConfirm(this, true);
            if(dc.run()){
                actionListModel.remove(actionList.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_deleteActionActionPerformed

    private void AddRuleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddRuleButtonMouseClicked
       
    }//GEN-LAST:event_AddRuleButtonMouseClicked

    private void ruleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruleComboBoxActionPerformed

    private void AddRuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRuleButtonActionPerformed
        // TODO add your handling code here:
        dialogInput di = new dialogInput(this, true);
        String ruleName = di.run();
        //System.out.println(ruleName);
        if(!ruleName.isEmpty()){
            IRule newRule = new Rule(ruleName, "");
            strategy.addRule(newRule);
            strategyEngine.saveStrategy(strategy);
            setRuleComboBox();
        }
    }//GEN-LAST:event_AddRuleButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddRuleButton;
    private javax.swing.JList actionList;
    private javax.swing.JButton addAction;
    private javax.swing.JButton addCondition;
    private javax.swing.JButton back;
    private javax.swing.JList conditionList;
    private javax.swing.JButton deleteAction;
    private javax.swing.JButton deleteCondition;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel name;
    private javax.swing.JComboBox<String> ruleComboBox;
    // End of variables declaration//GEN-END:variables
}
