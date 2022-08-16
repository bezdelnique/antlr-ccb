package org.example.ccb;

import java.math.BigDecimal;

public class ValueHolder implements Comparable<Object> {
    // public static ValueHolder VOID = new ValueHolder(new Object());

    private final Object value;

    public ValueHolder(Object value) {
        if (!(value instanceof String || value instanceof BigDecimal || value instanceof Boolean)) {
            throw new RuntimeException("Unsupported type: " + value.getClass().getName());
        }
        this.value = value;
    }

    public static ValueHolder fromInt(int value) {
        return new ValueHolder(new BigDecimal(value));
    }

    public Boolean asBoolean() {
        return (Boolean) value;
    }

    public BigDecimal asNumber() {
        return (BigDecimal) value;
    }

    public String asString() {
        return String.valueOf(value);
    }

    public boolean isNumber() {
        return value instanceof BigDecimal;
    }

    public boolean isString() {
        return value instanceof String;
    }

    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    @Override
    public int hashCode() {
        if (value == null) {
            return 0;
        }
        return this.value.hashCode();
    }

    public Object getRawValue() {
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

        return value.equals(that.getRawValue());
    }

    @Override
    public int compareTo(Object o) {
        if (value == null || o == null) {
            throw new RuntimeException("Unable to compare null values");
        }

        ValueHolder that = (ValueHolder) o;
        if (that.value.getClass() != value.getClass()) {
            throw new RuntimeException(String.format(
                    "Incompatible types %s and %s",
                    that.value.getClass().getName(),
                    value.getClass().getName()));
        }

        if (isString()) {
            return asString().compareTo(that.asString());
        } else if (isNumber()) {
            return asNumber().compareTo(that.asNumber());
        } else if (isBoolean()) {
            return asBoolean().compareTo(that.asBoolean());
        } else {
            throw new RuntimeException("Unhandled type: " + value.getClass().getName());
        }
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
