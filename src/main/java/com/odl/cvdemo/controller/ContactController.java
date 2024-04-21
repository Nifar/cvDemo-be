package com.odl.cvdemo.controller;

import com.odl.cvdemo.DTO.ContactForm;
import com.odl.cvdemo.service.MsgSenderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/contact")
public class ContactController {

    private final MsgSenderService service;

    @PostMapping
    public void contact(@RequestBody @Valid ContactForm form) {
        service.sendNotify(form);
    }
}
