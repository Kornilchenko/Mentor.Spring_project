package com.example.springproject.controller;

import com.example.springproject.entity.GenericEntity;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/en")
public class GenericEntityController {
    private List<GenericEntity> entityList = new ArrayList<>();
    {
        entityList.add(new GenericEntity(1L,"vasiliy"));
        entityList.add(new GenericEntity(2L,"sergey"));
        entityList.add(new GenericEntity(3L,"nikolay"));
        entityList.add(new GenericEntity(4L,"sveta"));
    }

    @RequestMapping("/entity/all")
    @ApiResponse(code = 200, message = "some", reference = "some")
    @GetMapping("/entity/all")
    public List<GenericEntity> findAll() {
        return entityList;
    }

    @RequestMapping(value = "/entity", method = RequestMethod.POST)
    public GenericEntity addEntity(GenericEntity entity) {
        entityList.add(entity);
        return entity;
    }

    @RequestMapping("/entity/findby/{id}")
    public GenericEntity findById(@PathVariable Long id) {
        return entityList.stream().
                filter(entity -> entity.getId().equals(id)).
                findFirst().get();
    }
}

/*@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;
    private String massage = "щось пишемо у відповідь";

    *//*@GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, 1);
    }*//*

    @GetMapping
    public String showStatus() {
        return massage;
    }

    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {

        final BaseResponse response;

        String sharedKey = "SHARED_KEY";
        if (sharedKey.equalsIgnoreCase(key)) {
            int userId = request.getUserId();
            String itemId = request.getItemId();
            double discount = request.getDiscount();
            // Process the request
            // ....
            // Return success response to the client.
            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return response;
    }
}*/
