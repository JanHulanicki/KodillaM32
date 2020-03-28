package com.crud.tasks.service;

import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.CreatedTrelloCartDto;
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
        AttachmentByTypeDto attachmentByTypeDto = new AttachmentByTypeDto();
        Badges badges = new Badges();
        Trello trello = new Trello();
        BadgesDto badgesDto = new BadgesDto();
        TrelloDto trelloDto = new TrelloDto();
        TrelloBadgesDto trelloBadgesDto = new TrelloBadgesDto();
        CreatedTrelloCartDto createdTrelloCartDto = new CreatedTrelloCartDto();
        trelloDto.setBoard(1);
        trelloDto.setCard(1);
        trello.setBoard(1);
        trello.setCard(1);
        attachmentByTypeDto.setTrello(trelloDto);
        badges.setAttachmentByType(attachmentByType);
        badges.setVotes(10);
        badgesDto.setAttachmentByType(attachmentByType);
        badgesDto.setVotes(10);
        trelloBadgesDto.setId("1");
        trelloBadgesDto.setName("name1");
        trelloBadgesDto.setClosed(true);
        createdTrelloCartDto.setId("1");
        createdTrelloCartDto.setName("name1");
        createdTrelloCartDto.setShortUrl("url1");
        //when
        attachmentByType.setTrello(trelloDto);
        attachmentByTypeDto.setTrello(trelloDto);
        //Then
        assertEquals(attachmentByType.getTrello().getBoard(), 1);
        assertEquals(attachmentByType.getTrello().getCard(), 1);
        assertEquals(attachmentByTypeDto.getTrello().getBoard(), 1);
        assertEquals(attachmentByTypeDto.getTrello().getCard(), 1);
        assertEquals(badges.getVotes(), 10);
        assertEquals(badgesDto.getVotes(), 10);
        assertEquals(badges.getAttachmentByType().getTrello().getCard(), 1);
        assertEquals(badges.getAttachmentByType().getTrello().getBoard(), 1);
        assertEquals(badgesDto.getVotes(), 10);
        assertEquals(badgesDto.getAttachmentByType().getTrello().getBoard(), 1);
        assertEquals(badgesDto.getAttachmentByType().getTrello().getCard(), 1);
        assertEquals(trelloBadgesDto.getId(), "1");
        assertEquals(trelloBadgesDto.getName(), "name1");
        assertEquals(trelloBadgesDto.isClosed(), true);
        assertEquals(createdTrelloCartDto.getId(), "1");
        assertEquals(createdTrelloCartDto.getName(), "name1");
        assertEquals(createdTrelloCartDto.getShortUrl(), "url1");
    }
}
