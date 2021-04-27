package dev.codefoundry.lld;

import java.util.function.Predicate;

public class PasswordChecker {
    private List<PasswordSpec<String>> conditions;

    public PasswordChecker(List<PasswordSpec<String>> conditions) {
        this.conditions = conditions;
    }

    public int measureStrength(String password) {
        int strength = 0;
        for (PasswordSpec<String> condition : conditions) {
            if (condition.matches(password)) {
                strength++;
            }
        }

        return strength;
    }

    static interface Sizable {
        int length();
    }

    interface PasswordSpec<T> {
        public boolean matches(T t);
    }

    class NegatePasswordSpec implements PasswordSpec<T> {
        private final PasswordSpec<T> spec;
        public NegatePasswordSpec(PasswordSpec<T> spec) {
            this.spec = spec;
        }

        public boolean matches(T t) {
            return !spec.matches(t);
        }
    }

    class ContainsSpec implements PasswordSpec<T> {
        private final Set<T> values;

        public ContainsSpec(Set<T> allowedValues) {
            this.values = values;
        }

        public boolean matches(T t) {
            return this.values.contains(t);
        }
    }

    class NotContainsSpec extends NegatePasswordSpec<T> {
        public NotContainsSpec(ContainsSpec<T> spec) {
            super(spec);
        }
    }

    class AndSpec implements PasswordSpec<T> {
        private final PasswordSpec<T> left;
        private final PasswordSpec<T> right;

        public AndSpec(PasswordSpec<T> left, PasswordSpec<T> right) {
            this.left = left;
            this.right = right;
        }

        public boolean matches(T t) {
            return left.matches(t) && right.matches(t);
        }
    }

    class MinLengthSpec<T extends Sizable> implements PasswordSpec<T> {
        private final int minLength;
        
        public MinLengthSpec(final int minLength) {
            this.minLength = minLength;
        }

        @Override
        public boolean matches(T t) {
            return t.length() >= this.minLength;
        }

    }

    class MaxLengthSpec<T extends Sizable> implements PasswordSpec<T> {
        private final int maxLength;

        public MaxLengthSpec(final int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public boolean matches(T t) {
            return t.length() <= this.maxLength;
        }
    }

    class LengthSpec<T extends Sizable> extends AndSpec<T> {
        public LengthSpec(MinLengthSpec<T> left, MaxLengthSpec<T> right) {
            super(left, right);
        }
    }
}