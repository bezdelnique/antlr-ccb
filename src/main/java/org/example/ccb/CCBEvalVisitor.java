package org.example.ccb;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CCBEvalVisitor extends CCBBaseVisitor<ValueHolder> {
    private final CCBDatasource ccbDatasource;

    public CCBEvalVisitor(CCBDatasource ccbDatasource) {
        super();
        this.ccbDatasource = ccbDatasource;
    }

    @Override
    public ValueHolder visitParse(CCBParser.ParseContext ctx) {
        return super.visitParse(ctx);
    }

    @Override
    public ValueHolder visitBlock(CCBParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public ValueHolder visitStat(CCBParser.StatContext ctx) {
        return super.visitStat(ctx);
    }

    @Override
    public ValueHolder visitIf_stat(CCBParser.If_statContext ctx) {
        ValueHolder valueHolder = this.visit(ctx.condition_block().expr());

        if (valueHolder.asBoolean()) {
            return this.visit(ctx.stat_block(0));
        } else {
            return this.visit(ctx.stat_block(1));
        }
    }

    @Override
    public ValueHolder visitStat_block(CCBParser.Stat_blockContext ctx) {
        return super.visit(ctx.expr());
    }

    @Override
    public ValueHolder visitAtomExpr(CCBParser.AtomExprContext ctx) {
        return super.visitAtomExpr(ctx);
    }


    @Override
    public ValueHolder visitCompareExpr(CCBParser.CompareExprContext ctx) {
        ValueHolder left = this.visit(ctx.expr(0));
        ValueHolder right = this.visit(ctx.expr(1));

        if (left.getClass() != right.getClass()) {
            throw new RuntimeException(String.format(
                    "Incompatible types %s and %s",
                    left.getClass().getName(),
                    right.getClass().getName()));
        }

        Boolean result = switch (ctx.op.getType()) {
            case CCBParser.EQ -> left.equals(right);
            case CCBParser.NEQ -> !left.equals(right);
            case CCBParser.GT -> left.compareTo(right) > 0;
            case CCBParser.GTEQ -> left.compareTo(right) >= 0;
            case CCBParser.LT -> left.compareTo(right) < 0;
            case CCBParser.LTEQ -> left.compareTo(right) <= 0;
            default -> throw new RuntimeException("Unhandled operator");
        };

        return new ValueHolder(result);
    }

    @Override
    public ValueHolder visitLogicalExpr(CCBParser.LogicalExprContext ctx) {
        ValueHolder left = this.visit(ctx.expr(0));
        ValueHolder right = this.visit(ctx.expr(1));

        Boolean result = switch (ctx.op.getType()) {
            case CCBParser.OR -> left.asBoolean() || right.asBoolean();
            case CCBParser.AND -> left.asBoolean() && right.asBoolean();
            default -> throw new RuntimeException("Unhandled operator");
        };

        return new ValueHolder(result);
    }


    @Override
    public ValueHolder visitNumberAtom(CCBParser.NumberAtomContext ctx) {
        return new ValueHolder(new BigDecimal(ctx.getText().replace(",", ".")));
    }

    @Override
    public ValueHolder visitBooleanAtom(CCBParser.BooleanAtomContext ctx) {
        return ctx.TRUE() != null
                ? new ValueHolder(Boolean.TRUE)
                : new ValueHolder(Boolean.FALSE);
    }


    @Override
    public ValueHolder visitCondition_block(CCBParser.Condition_blockContext ctx) {
        return super.visitCondition_block(ctx);
    }

    @Override
    public ValueHolder visitMdbfAtom(CCBParser.MdbfAtomContext ctx) {
        return ccbDatasource.getMultidimensionalBillFactorValue(ctx.getText());
    }

    @Override
    public ValueHolder visitContextObjectAtom(CCBParser.ContextObjectAtomContext ctx) {
        return ccbDatasource.getContextObjectValue(ctx.getText());
    }

    @Override
    public ValueHolder visitStringAtom(CCBParser.StringAtomContext ctx) {
        String value = ctx.getText();
        value = value.replaceAll("^\"|\"$", "");
        value = value.replaceAll("^\'|\'$", "");
        return new ValueHolder(value);
    }

    @Override
    public ValueHolder visitCompareParenthesisExpr(CCBParser.CompareParenthesisExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ValueHolder visitNotExpr(CCBParser.NotExprContext ctx) {
        ValueHolder visit = visit(ctx.expr());
        if (!visit.isBoolean()) {
            throw new RuntimeException("Only boolean type supports negation");
        }
        return new ValueHolder(!visit.asBoolean());
    }

    @Override
    public ValueHolder visitOperatorIn(CCBParser.OperatorInContext ctx) {
        List<CCBParser.ExprContext> exprs = ctx.expr();

        ValueHolder left = visit(exprs.get(0));
        Set<ValueHolder> right = new HashSet<>();

        for (int i = 1; i < exprs.size(); i++) {
            right.add(visit(exprs.get(i)));
        }

        return new ValueHolder(right.contains(left));
    }
}
