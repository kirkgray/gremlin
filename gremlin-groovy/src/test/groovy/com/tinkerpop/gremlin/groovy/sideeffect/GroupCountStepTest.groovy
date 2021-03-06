package com.tinkerpop.gremlin.groovy.sideeffect

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.test.UtilitiesTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GroupCountStepTest extends com.tinkerpop.gremlin.test.sideeffect.GroupCountStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        UtilitiesTest.testCompliance(this.getClass());
    }

    public void test_g_V_outXcreatedX_groupCountXm__nameX() {
        def m = [:]
        super.test_g_V_outXcreatedX_groupCountXm__nameX(g.V.out('created').groupCount(m) {it.name}, m);
    }

    public void test_g_V_outXcreatedX_groupCountXm__name__plus_2X() {
        def m = [:]
        super.test_g_V_outXcreatedX_groupCountXm__name__plus_2X(g.V.out('created').groupCount(m) {it.name} {it + 2l}, m);
    }

    public void test_g_V_outXcreatedX_groupCountXnameX_cap() {
        super.test_g_V_outXcreatedX_groupCountXnameX_cap(g.V.out('created').groupCount {it.name}.cap);
    }
}

