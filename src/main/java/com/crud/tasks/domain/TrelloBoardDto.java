package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrelloBoardDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lists")
    private List<TrelloListDto> lists;

    @Override
    public String toString() {
        return "TrelloBoardDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lists=" + lists +
                '}';
    }
}
