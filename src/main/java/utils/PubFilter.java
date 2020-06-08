package utils;

import generator.Filter;
import generator.Operator;
import generator.Publication;
import generator.Subscription;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class PubFilter {

    public static boolean matchPub(Publication pub, Set<List<Filter>> subs){
        for(List<Filter> filters : subs) {
            Subscription sub = new Subscription(filters);

            if(sub.contains("company")) {
                Filter filter = sub.get("company");
                String sub_value = filter.getValue().toString();
                String pub_value = pub.getCompany().getCompanyName();
                Operator op = filter.getOperator();

                if(op == Operator.EQ && !pub_value.equals(sub_value)) {
                    continue;
                }
                if(op == Operator.NEQ && pub_value.equals(sub_value)) {
                    continue;
                }
            }

            if(sub.contains("stockValue")) {
                Filter filter = sub.get("stockValue");
                double sub_value = (Double)filter.getValue();
                double pub_value = pub.getStockValue();
                Operator op = filter.getOperator();

                if(op == Operator.EQ && pub_value != sub_value) {
                    continue;
                }
                if(op == Operator.NEQ && pub_value == sub_value) {
                    continue;
                }
                if(op == Operator.GT && pub_value <= sub_value) {
                    continue;
                }
                if(op == Operator.GTEQ && pub_value < sub_value) {
                    continue;
                }
                if(op == Operator.L && pub_value >= sub_value) {
                    continue;
                }
                if(op == Operator.LEQ && pub_value > sub_value) {
                    continue;
                }
            }

            if(sub.contains("change")) {
                Filter filter = sub.get("change");
                double sub_value = (Double)filter.getValue();
                double pub_value = pub.getChange();
                Operator op = filter.getOperator();

                if(op == Operator.EQ && pub_value != sub_value) {
                    continue;
                }
                if(op == Operator.NEQ && pub_value == sub_value) {
                    continue;
                }
                if(op == Operator.GT && pub_value <= sub_value) {
                    continue;
                }
                if(op == Operator.GTEQ && pub_value < sub_value) {
                    continue;
                }
                if(op == Operator.L && pub_value >= sub_value) {
                    continue;
                }
                if(op == Operator.LEQ && pub_value > sub_value) {
                    continue;
                }
            }

            if(sub.contains("variation")) {
                Filter filter = sub.get("variation");
                double sub_value = (Double)filter.getValue();
                double pub_value = pub.getVariation();
                Operator op = filter.getOperator();

                if(op == Operator.EQ && pub_value != sub_value) {
                    continue;
                }
                if(op == Operator.NEQ && pub_value == sub_value) {
                    continue;
                }
                if(op == Operator.GT && pub_value <= sub_value) {
                    continue;
                }
                if(op == Operator.GTEQ && pub_value < sub_value) {
                    continue;
                }
                if(op == Operator.L && pub_value >= sub_value) {
                    continue;
                }
                if(op == Operator.LEQ && pub_value > sub_value) {
                    continue;
                }
            }

            if(sub.contains("date")) {
                Filter filter = sub.get("date");
                Date sub_value = (Date)filter.getValue();
                Date pub_value = pub.getDate();
                Operator op = filter.getOperator();

                if(op == Operator.EQ && pub_value.compareTo(sub_value) != 0) {
                    continue;
                }
                if(op == Operator.NEQ && pub_value.compareTo(sub_value) == 0) {
                    continue;
                }
                if(op == Operator.GT && pub_value.compareTo(sub_value) <= 0) {
                    continue;
                }
                if(op == Operator.GTEQ && pub_value.compareTo(sub_value) < 0) {
                    continue;
                }
                if(op == Operator.L && pub_value.compareTo(sub_value) >= 0) {
                    continue;
                }
                if(op == Operator.LEQ && pub_value.compareTo(sub_value) > 0) {
                    continue;
                }
            }

            return true;
        }
        return false;
    }
}
