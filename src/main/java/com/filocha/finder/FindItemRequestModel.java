package com.filocha.finder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class FindItemRequestModel {
    private String item;
    private String email;

}
