package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.blueprints.pgm.IndexableGraph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IndexElementsPipeTest extends TestCase {

    public void testPipeBasic() {
        IndexableGraph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Vertex, Vertex> pipe = new IndexElementsPipe<Vertex>(graph.getIndex(Index.VERTICES, Vertex.class), "lang", "java");
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            assertTrue(vertex.equals(graph.getVertex(3)) || vertex.equals(graph.getVertex(5)));
        }
        assertEquals(counter, 2);
    }
}
