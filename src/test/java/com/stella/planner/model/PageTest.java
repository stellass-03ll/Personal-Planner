package com.stella.planner.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PageTest {
    private static final String ID = "user123";
    private static final String TITLE = "Test Page";
    private static final String CONTENT = "abc";
    private Page testPage;
    private List<Page> l1;
    private List<Page> l2;
    private Page p1;
    private Page p2;

    @BeforeEach 
    void runBefore() {
        testPage = new Page(ID, TITLE);
        l1 = new ArrayList<>();
        l2 = new ArrayList<>();
        p1 = new Page("u1", "Page 1");
        p2 = new Page("u2", "Page 2");
    }

    @Test 
    void testConstructor() {
        assertEquals(ID, testPage.getID());
        assertEquals(TITLE, testPage.getTitle());
        assertNull(testPage.getContent());
        assertNull(testPage.getParent());
        assertEquals(l1, testPage.getChildren());
    }

    @Test
    void testAddChild() {
        l2.add(p1);
        l2.add(p2);
        testPage.addChild(p1);
        testPage.addChild(p2);
        assertEquals(l2.size(), testPage.getChildren().size());
        assertEquals(l2, testPage.getChildren());
        assertEquals(p1, testPage.getChildren().get(0));
        assertEquals(p2, testPage.getChildren().get(1));
        assertEquals(p1.getParent(), testPage);
        assertEquals(p2.getParent(), testPage);
    }

    @Test 
    void testRemoveChild() {
        l2.add(p1);
        testPage.addChild(p1);
        testPage.addChild(p2);
        testPage.removeChild(p2);
        assertEquals(l2.size(), testPage.getChildren().size());
        assertEquals(l2, testPage.getChildren());
        assertEquals(p1, testPage.getChildren().get(0));
        assertEquals(p1.getParent(), testPage);
        assertNull(p2.getParent());
    }

    @Test 
    void testAddNestedChildren() {
        testPage.addChild(p1);
        p1.addChild(p2);
        l1.add(p1);
        l2.add(p2);
        assertEquals(l1, testPage.getChildren());
        assertEquals(p1.getParent(), testPage);
        assertEquals(l2, p1.getChildren());
        assertEquals(p2.getParent(), p1);
    }
}
