package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinScriptEngine;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ForeachTest extends BaseTest {

    public void testForeach() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$sum := 0\nforeach $x in g:list(1,2,3,4)\n$sum := $sum + $x\nend\n$sum\n", context);
        printPerformance("foreach statement", 4, "iterations w/ returns", this.stopWatch());
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 0);
        assertNull(results.get(1));
        assertEquals(results.get(2), 10);
    }

    public void testEmbeddedForeach() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$counter := 0\nforeach $x in g:list(1,2,3,4)\nforeach $y in g:list(5,6,7,8)\n$counter := $counter + 1\nend\nend\n$counter\n", context);
        printPerformance("foreach statement", 2, "embedded iterations w/ returns", this.stopWatch());
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 0);
        assertNull(results.get(1));
        assertEquals(results.get(2), 16);
    }
}