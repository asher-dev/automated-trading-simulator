package autotradingsim.strategy;

import autotradingsim.util.Pair;

import java.math.BigDecimal;
import java.util.function.Predicate;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Functional class that can compare an Indicator against some Predicate
 */
public interface ICondition {

    public enum Comparator {
        GT, LT, GEQ, LEQ, EQ, NEQ
    }

    /**
     * Creates a Predicate function which compares to values in a Pair using a given comparator.
     * @param comp Comparison operator
     * @return New Predicate built with given comparison operator
     */
    default Predicate<Pair<BigDecimal, BigDecimal>> makeComparator(Comparator comp) {
        switch (comp) {
            case GT:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.compareTo(pair.y) > 0);
            case LT:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.compareTo(pair.y) < 0);
            case GEQ:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.compareTo(pair.y) >= 0);
            case LEQ:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.compareTo(pair.y) <= 0);
            case EQ:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.equals(pair.y));
            case NEQ:
                return (Pair<BigDecimal, BigDecimal> pair) -> (!pair.x.equals(pair.y));
            default:
                return null;
        }
    }

    int getBufferSize();

    Predicate<IBufferAdapter> getFunction();


}