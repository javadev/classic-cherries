package org.paukov.heap;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov
 */
public class SimpleMaxHeapTest {

    @Test
    public void create_simple_max_heap() {
        final SimpleMaxHeap simpleMaxHeap = new SimpleMaxHeap();

        simpleMaxHeap.add(17);
        simpleMaxHeap.add(3);
        simpleMaxHeap.add(19);
        simpleMaxHeap.add(2);
        simpleMaxHeap.add(7);
        simpleMaxHeap.add(25);
        simpleMaxHeap.add(100);
        simpleMaxHeap.add(1);
        simpleMaxHeap.add(36);

        assertThat(simpleMaxHeap).isNotNull();
        assertThat(simpleMaxHeap.getLastElementIndex()).isEqualTo(8);

        assertThat(simpleMaxHeap.getNodeValue(0)).isEqualTo(100);
        assertThat(simpleMaxHeap.getNodeValue(1)).isEqualTo(36);
        assertThat(simpleMaxHeap.getNodeValue(2)).isEqualTo(25);
        assertThat(simpleMaxHeap.getNodeValue(3)).isEqualTo(7);
        assertThat(simpleMaxHeap.getNodeValue(4)).isEqualTo(3);
        assertThat(simpleMaxHeap.getNodeValue(5)).isEqualTo(17);
        assertThat(simpleMaxHeap.getNodeValue(6)).isEqualTo(19);
        assertThat(simpleMaxHeap.getNodeValue(7)).isEqualTo(1);
        assertThat(simpleMaxHeap.getNodeValue(8)).isEqualTo(2);
    }

}
