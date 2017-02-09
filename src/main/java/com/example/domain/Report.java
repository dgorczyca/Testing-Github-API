package com.example.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by dg on 09/02/2017.
 */
@Data
@RequiredArgsConstructor
public class Report {
    @NonNull
    private String title;
    @NonNull
    private String[] labels;
    @NonNull
    private String[] values;

    public String getPrintedLabels() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (String label :
                labels) {
            stringBuilder.append("\"");
            stringBuilder.append(label);
            stringBuilder.append("\"");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String getPrintedValues() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (String value :
                values) {
            stringBuilder.append(value);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
