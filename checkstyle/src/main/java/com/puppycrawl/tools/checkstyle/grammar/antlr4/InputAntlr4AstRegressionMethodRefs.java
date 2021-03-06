package com.puppycrawl.tools.checkstyle.grammar.antlr4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;
import java.util.function.Supplier;

public class InputAntlr4AstRegressionMethodRefs {
   interface LambdaInt {
        <S, T> void m(S p1, T p2);
    }

    interface MyFunctionalInterface {
        void invokeMethodReference();
    }

    static class LambdaImpl implements LambdaInt {
        <S, T> LambdaImpl(S p1, T p2) {
        }

        public <S, T> void m(S p1, T p2) {
        }
    }

    public void m() {
    }

    public void main(String[] args) {
        MyFunctionalInterface fi =
                new InputAntlr4AstRegressionMethodRefs()::<Integer, String, Long> m;
        LambdaInt li = LambdaImpl::<@TA Object, @TB Object> new;
        Supplier s = Bar1::<String> m;
        li = li::<@TA Object, @TB Object> m;
        s = Bar1::<List<String>> m;
        s = Bar1::<List<List<?>>> m;
    }
}

class Bar1<T> {
    static Object m() {
        return null;
    }
}

@Target({ ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
@interface TA {
}

@Target({ ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
@interface TB {
}

