package org.clojug.gradle.services;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

/**
 * Implementación de {@link Expressions} usando SpEL
 */
@Service
public class ExpressionsSpring implements Expressions {

    /**
     * {@inheritDoc}
     */
    @Override
    public String evaluate(final String expression) throws Exception {
        SpelExpressionParser parser = new SpelExpressionParser();
        return parser.parseExpression(expression).getValue().toString();
    }
}
