package com.crud.tasks.service;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrelloMapperTestSuite {
    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void testMapBoardDtoToBoard() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        TrelloListDto trelloListDto = new TrelloListDto();
        trelloListDto.setId("1");
        trelloListDto.setName("name1");
        trelloListDto.setClosed(true);
        trelloBoardDto.setId("1");
        trelloBoardDto.setName("name1");
        ArrayList<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(0, trelloListDto);
        trelloBoardDto.setLists(trelloListsDto);
        //when
        TrelloBoard trelloBoard = trelloMapper.mapToBoard(trelloBoardDto);
        //Then
        assertEquals(trelloBoard.getId(), "1");
        assertEquals(trelloBoard.getName(), "name1");
        assertEquals(trelloBoard.getLists().get(0).getId(), "1");
        assertEquals(trelloBoard.getLists().get(0).getName(), "name1");
        assertTrue(trelloBoard.getLists().get(0).isClosed());
    }

    @Test
    public void testMapBoardsDtoToBoards() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        TrelloListDto trelloListDto = new TrelloListDto();
        trelloListDto.setId("1");
        trelloListDto.setName("name1");
        trelloListDto.setClosed(true);
        trelloBoardDto.setId("1");
        trelloBoardDto.setName("name1");
        ArrayList<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(0, trelloListDto);
        trelloBoardDto.setLists(trelloListsDto);
        trelloBoardDtos.add(trelloBoardDto);
        //when
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);
        //Then
        assertEquals(trelloBoards.get(0).getId(), "1");
        assertEquals(trelloBoards.get(0).getName(), "name1");
        assertEquals(trelloBoards.get(0).getLists().get(0).getId(), "1");
        assertEquals(trelloBoards.get(0).getLists().get(0).getName(), "name1");
        assertTrue(trelloBoards.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testmaptoBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> trelloLists = new ArrayList<>();
        TrelloList trelloList = new TrelloList();
        TrelloBoard trelloBoard = new TrelloBoard();
        trelloBoard.setId("1");
        trelloBoard.setName("name1");
        trelloList.setId("1");
        trelloList.setName("name1");
        trelloList.setClosed(true);
        trelloBoard.setLists(trelloLists);
        trelloLists.add(trelloList);
        trelloBoard.setLists(trelloLists);
        trelloBoards.add(trelloBoard);
        //when
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.maptoBoardsDto(trelloBoards);
        //Then
        assertEquals(trelloBoardDtos.get(0).getId(), "1");
        assertEquals(trelloBoardDtos.get(0).getName(), "name1");
        assertEquals(trelloBoardDtos.get(0).getLists().get(0).getId(), "1");
        assertEquals(trelloBoardDtos.get(0).getLists().get(0).getName(), "name1");
        assertTrue(trelloBoardDtos.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto();
        trelloCardDto.setName("name1");
        trelloCardDto.setDescription("description1");
        trelloCardDto.setPos("pos1");
        trelloCardDto.setListId("listId1");
        //when
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals(trelloCard.getName(), "name1");
        assertEquals(trelloCard.getDescription(), "description1");
        assertEquals(trelloCard.getPos(), "pos1");
        assertEquals(trelloCard.getListId(), "listId1");
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard();
        trelloCard.setName("name1");
        trelloCard.setDescription("description1");
        trelloCard.setPos("pos1");
        trelloCard.setListId("listId1");
        //when
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals(trelloCardDto.getName(), "name1");
        assertEquals(trelloCardDto.getDescription(), "description1");
        assertEquals(trelloCardDto.getPos(), "pos1");
        assertEquals(trelloCardDto.getListId(), "listId1");
    }

    @Test
    public void testCreateTrelloCard() {
        TrelloCardDto trelloCardDto = new TrelloCardDto();
        trelloCardDto.setName("name1");
        trelloCardDto.setDescription("description1");
        trelloCardDto.setPos("pos1");
        trelloCardDto.setListId("listId1");
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        assertEquals(trelloCard.getName(), "name1");
        assertEquals(trelloCard.getDescription(), "description1");
        assertEquals(trelloCard.getPos(), "pos1");
        assertEquals(trelloCard.getListId(), "listId1");

    }
}
