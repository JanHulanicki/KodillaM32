package com.crud.tasks.service;

import com.crud.tasks.domain.AttachmentByType;
import com.crud.tasks.domain.TrelloDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TheRestTestSuite {
    @Test
    public void testRestoFClass() {
        //Given
        AttachmentByType attachmentByType = new AttachmentByType();
        TrelloDto trelloDto = new TrelloDto();
        trelloDto.setBoard(1);
        trelloDto.setCard(1);
        //when
        attachmentByType.setTrello(trelloDto);
        //Then
        assertEquals(attachmentByType.getTrello().getBoard(), 1);
        assertEquals(attachmentByType.getTrello().getCard(), 1);
    }
}
