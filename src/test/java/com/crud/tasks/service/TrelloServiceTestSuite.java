package com.crud.tasks.service;

import com.crud.tasks.domain.TrelloBoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrelloServiceTestSuite {
    @Autowired
    TrelloService trelloService;

    @Test
    public void testFetchTrelloBoards() throws URISyntaxException {
        //Given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        //when
        trelloBoardDto = trelloService.fetchTrelloBoards();
        assertFalse(trelloBoardDto.isEmpty());
    }
}
