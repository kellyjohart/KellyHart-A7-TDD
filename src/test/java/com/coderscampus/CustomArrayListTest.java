package com.coderscampus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    @Test
    public void test_add_item_to_empty_list() {
        // Arrange
        CustomArrayList<String> list = new CustomArrayList<>();

        // Act
        boolean result = list.add("Object 1");

        // Assert
        assertTrue(result);
        assertEquals(1, list.getSize());
    }

    @Test
    public void test_add_item_to_list() {
        // Arrange
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Object 1");

        // Act
        boolean result = list.add("Object 2");

        // Assert
        assertTrue(result);
        assertEquals(2, list.getSize());
    }

    @Test
    public void test_add_item_to_list_with_index() {
        // Arrange
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Object 1");

        // Act
        boolean result = list.add(0, "Object 2");

        // Assert
        assertTrue(result);
        assertEquals(2, list.getSize());
    }

    @Test
    public void test_add_item_to_list_with_index_out_of_bounds() {
        // Arrange
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Object 1");

        // Act and Assert
        try {
            list.add(2, "Object 2");
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals(1, list.getSize());
        }
    }

    @Test
    public void test_get_item_from_list() {
        // Arrange
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Object 1");

        // Act
        String element = list.get(0);

        // Assert
        assertEquals("Object 1", element);
    }

    @Test
    public void test_get_item_from_list_with_index_out_of_bounds_exception() {
        // Arrange
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Object 1");

        // Act and Assert
        try {
            list.get(1);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals(1, list.getSize());
        }
    }

    @Test
    public void test_remove_items_from_list() {
        // Arrange
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Object 1");

        // Act
        String element = list.remove(0);

        // Assert
        assertEquals("Object 1", element);
        assertEquals(0, list.getSize());
    }

    @Test
    public void test_remove_item_from_list_with_index_out_of_bounds_exception() {
        // Arrange
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Object 1");

        // Act and Assert
        try {
            list.remove(1);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals(1, list.getSize());
        }
    }

    @Test
    public void test_get_size_of_empty_list() {
        // Arrange
        CustomArrayList<String> list = new CustomArrayList<>();

        // Act and Assert
        assertEquals(0, list.getSize());
    }

    @Test
    public void test_get_size_of_list() {
        // Arrange
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Object 1");

        // Act and Assert
        assertEquals(1, list.getSize());
    }
}