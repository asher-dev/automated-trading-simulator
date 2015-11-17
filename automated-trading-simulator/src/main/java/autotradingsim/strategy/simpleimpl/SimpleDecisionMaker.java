package autotradingsim.strategy.simpleimpl;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.*;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Asher on 2015-10-30.
 *
 * Basic implementation of IDecisionMaker.  Will be useful for early testing and a sample beginner strategy.
 *
 */
public class SimpleDecisionMaker implements IDecisionMaker {

    private SimpleRule rule;
    private IStock stock;

    public SimpleDecisionMaker (SimpleRule rule) {
        this.rule = rule;
        this.stock = null;
    }

    @Override
    public void assignStock(IStock stock) {
        this.stock = stock;
    }

    @Override
    public boolean hasStockAssigned() {
        return stock == null;
    }

    @Override
    public Iterator<IDecision> getDecisions(LocalDate date) {
        List<IDecision> decisionList = new ArrayList<>();
        // TODO: deal with casting -- BAD BAD BAD
        BufferAdapter buffer = (BufferAdapter) stock.getNewBuffer(date, 1);
        IDecision decision = getDecision(buffer);
        if (decision != null) {
            decisionList.add(decision);
        }
        return decisionList.iterator();
    }

    private IDecision getDecision(BufferAdapter buffer) {
        ICondition condition = rule.getConditions().get(0);
        IAction action = rule.getActions().get(0);

        if (condition.getFunction().test(buffer)) {
            IActionQuantity q = action.getQuantity();
            return new Decision(buffer.getLastEntry().getDate(), action.getActionType(), stock, action.getQuantity());
        }
        else return null;
    }
}