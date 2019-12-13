package com.example.studyrestapi.events;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class EventTest {
    @Test
    public void builder() {
        Event event = Event.builder().build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() throws Exception{
        //given
        Event event = new Event();
        String test = "test";
        event.setName(test);

        //when
        assertThat(event.getName()).isEqualTo(test);
        //then
    }

    @Test
    @Parameters
    public void testFree(int basePrice, int maxPrice, boolean isFree) throws Exception{
        //given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        //when
        event.update();

        //then
        assertThat(event.isFree()).isEqualTo(isFree);
    }

    private Object[] parametersForTestFree() {
        return new Object[][] {
            new Object[] {0, 0, true},
            new Object[] {100, 0, false}
        };
    }

    @Test
    @Parameters
    public void testOffline(String location, boolean isOffLine) throws Exception {
        //given
        Event event = Event.builder()
                .location(location)
                .build();

        //when
        event.update();

        //then
        assertThat(event.isOffline()).isEqualTo(isOffLine);
    }

    private Object[] parametersForTestOffline() {
        return new Object[][] {
                new Object[] {"강남역", true},
                new Object[] {null, false}
        };
    }

}