package com.lucasmatricarde.qrcod.controller;

import com.lucasmatricarde.qrcod.dto.QrCodeGenerateResponse;
import com.lucasmatricarde.qrcod.dto.QrCodeGenereateRequest;
import com.lucasmatricarde.qrcod.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenereateRequest request){
        try{
            QrCodeGenerateResponse response = qrCodeGeneratorService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
