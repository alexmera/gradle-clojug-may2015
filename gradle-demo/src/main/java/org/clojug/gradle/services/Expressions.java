package org.clojug.gradle.services;

/**
 * Operaciones para el procesamiento de expresiones.
 */
public interface Expressions {

    /**
     * Evalua y procesa una expresión
     *
     * @param expression La expresión
     * @return El resultado de la evaluación
     * @throws Exception Sí ocurre un error al evaluar la expresión
     */
    String evaluate(String expression) throws Exception;
}
