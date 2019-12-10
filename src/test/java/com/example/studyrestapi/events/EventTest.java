package com.example.studyrestapi.events;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}