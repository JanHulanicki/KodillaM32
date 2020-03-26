package com.crud.tasks.service;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;


public class TrelloMapperTestSuite {
    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void testMapBoardDtoToBoard() {
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        TrelloListDto trelloListDto = new TrelloListDto();
        trelloListDto.setId("1");
        trelloListDto.setName("name1");
        trelloListDto.setClosed(true);
        trelloBoardDto.setId("1");
        trelloBoardDto.setName("name1");

        ArrayList<TrelloListDto> trelloListsDto = new ArrayList<>(Collections.singleton(trelloListDto));

        trelloBoardDto.setLists(trelloListsDto);
        TrelloBoard trelloBoard = trelloMapper.mapToBoard(trelloBoardDto);

        assertEquals(trelloBoard.getId(), "1");
        assertEquals(trelloBoard.getName(), "name1");
        assertEquals(trelloBoard.getLists().get(0).getId(), "1");
        (customer.getOrderItems())
                .extracting("name", "quantity")
                .containsExactly(tuple("Table", 2L));


    }
}
