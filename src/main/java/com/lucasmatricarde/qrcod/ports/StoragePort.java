package com.lucasmatricarde.qrcod.ports;

public interface StoragePort {

    String uploadFile(byte[] fileData, String filename, String contentType);
}
