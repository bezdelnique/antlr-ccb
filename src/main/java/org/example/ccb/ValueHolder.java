package org.example.ccb;

public class ValueHolder {
    public static ValueHolder VOID = new ValueHolder(new Object());

    private final Object value;

    public ValueHolder(Object value) {
        this.value = value;
    }

    public Boolean asBoolean() {
        return (Boolean) value;
    }

    public Double asDouble() {
        return (Double) value;
    }

    public String asString() {
        return String.valueOf(value);
    }

    public boolean isDouble() {
        return value instanceof Double;
    }

    @Override
    public int hashCode() {
        if (value == null) {
            return 0;
        }
        return this.value.hashCode();
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (value == o) {
            return true;
        }

        if (value == null || o == null) {
            return false;
        }

        ValueHolder that = (ValueHolder) o;
        if (that.value.getClass() != value.getClass()) {
            return false;
        }

        return this.value.equals(that.getValue());
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
