package com.coderscampus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class CustomArrayListTest {
        private CustomArrayList<String> list;

        @BeforeEach
        void setUp() {
            list = new CustomArrayList<>();
        }

        @Test
        void testAddAtIndex() {
            // Arrange
            list.add("Item 1");
            list.add("Item 2");

            // Act
            boolean result = list.add(1, "Middle");

            // Assert
            assertTrue(result);
            assertEquals(3, list.getSize());
            assertEquals("Middle", list.get(1));
        }

        @Test
        void test_index_out_of_bounds_boundary_conditions() {
            list.add("First");

            // Test add boundaries
            assertThrows(IndexOutOfBoundsException.class,
                    () -> list.add(100, "Out of bounds"));
            assertThrows(IndexOutOfBoundsException.class,
                    () -> list.add(-1, "Negative index"));

            // Test get boundaries
            assertThrows(IndexOutOfBoundsException.class,
                    () -> list.get(1));
            assertThrows(IndexOutOfBoundsException.class,
                    () -> list.get(-1));

            // Test remove boundaries
            assertThrows(IndexOutOfBoundsException.class,
                    () -> list.remove(1));
            assertThrows(IndexOutOfBoundsException.class,
                    () -> list.remove(-1));
        }

        @Test
        void test_remove() {
            // Arrange
            list.add("Item 1");

            // Act
            String removed = list.remove(0);

            // Assert
            assertEquals("Item 1", removed);
            assertEquals(0, list.getSize());
        }

        @Test
        void test_array_scale() {
            // Arrange
            for (int i = 0; i < 20; i++) {
                list.add("Item " + i);
            }

            // Act
            list.add(15, "New Item");

            // Assert
            assertEquals(21, list.getSize());
            assertEquals("Item 0", list.get(0));
            assertEquals("New Item", list.get(15));
            assertEquals("Item 19", list.get(20));
        }



    @Test
    void test_complex_operations() {

        // Act
        list.add("A");
        list.add("B");
        list.add(1, "C");

        // Act and Assert
        assertAll(
                "Complex Operations",
                () -> assertEquals("C", list.remove(1)),
                () -> assertEquals(2, list.getSize()),
                () -> assertEquals("A", list.get(0)),
                () -> assertEquals("B", list.get(1))
        );
    }

    @Test
    void test_array_resize_edge_cases() {
        // Arrange
        for (int i = 0; i < 5; i++) {
            list.add("Item " + i);
        }

        // Act and Assert
        assertAll(
                "Resize Edge Cases",
                () -> assertThrows(IndexOutOfBoundsException.class,
                        () -> list.add(6, "Beyond size")),
                () -> assertThrows(IndexOutOfBoundsException.class,
                        () -> list.add(-1, "Negative index")),
                () -> assertTrue(list.add(5, "At size")) // Should work at exactly size
        );
    } }

