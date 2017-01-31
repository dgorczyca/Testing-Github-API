package com.example.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * Created by dg on 30/01/2017.
 */
@Data
@AllArgsConstructor
public class Language {
    String language;
    Integer byteCount;
}
