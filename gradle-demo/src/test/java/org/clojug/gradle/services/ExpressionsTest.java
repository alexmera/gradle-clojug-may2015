package org.clojug.gradle.services;

import org.clojug.gradle.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ExpressionsTest {

    @Autowired
    private Expressions expr;

    @Test
    public void evaluateOk() throws Exception {
        assertEquals("27", expr.evaluate("3 ^ 3"));
    }

    @Test(expected = Exception.class)
    public void evaluateError() throws Exception {
        expr.evaluate("ssdsd + 45");
    }
}
