package com.filocha.finder;

import org.springframework.web.bind.annotation.*;

@RestController
public class FindItemController {

    @CrossOrigin
    @RequestMapping(value = "find", method = RequestMethod.POST)
    public FindItemResponseModel findItem(@RequestBody FindItemRequestModel itemRequestModel) {
        FindItemResponseModel response = new FindItemResponseModel();
        response.setResponse("Hello " + itemRequestModel.getItemName());
        return response;
    }
}
