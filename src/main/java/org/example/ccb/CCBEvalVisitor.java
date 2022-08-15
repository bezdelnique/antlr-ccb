package org.example.ccb;

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
    public ValueHolder visitEqualityExpr(CCBParser.EqualityExprContext ctx) {
        ValueHolder left = this.visit(ctx.expr(0));
        ValueHolder right = this.visit(ctx.expr(1));

        if (left.getClass() != right.getClass()) {
            throw new RuntimeException(String.format(
                    "Incompatible types %s and %s",
                    left.getClass().getName(),
                    right.getClass().getName()));
        }

        return new ValueHolder(left.equals(right));
    }

    @Override
    public ValueHolder visitParExpr(CCBParser.ParExprContext ctx) {
        return super.visitParExpr(ctx);
    }

    @Override
    public ValueHolder visitIntegerAtom(CCBParser.IntegerAtomContext ctx) {
        return new ValueHolder(Integer.valueOf(ctx.getText()));
    }

    @Override
    public ValueHolder visitFloatAtom(CCBParser.FloatAtomContext ctx) {
        return super.visitFloatAtom(ctx);
    }

    @Override
    public ValueHolder visitBooleanAtom(CCBParser.BooleanAtomContext ctx) {
        return ctx.TRUE() != null
                ? new ValueHolder(Boolean.TRUE)
                : new ValueHolder(Boolean.FALSE);
    }

    @Override
    public ValueHolder visitContextObjectAtom(CCBParser.ContextObjectAtomContext ctx) {
        return super.visitContextObjectAtom(ctx);
    }

    @Override
    public ValueHolder visitStringAtom(CCBParser.StringAtomContext ctx) {
        String value = ctx.getText();
        value = value.replaceAll("^\"|\"$", "");
        value = value.replaceAll("^\'|\'$", "");
        return new ValueHolder(value);
    }
}
