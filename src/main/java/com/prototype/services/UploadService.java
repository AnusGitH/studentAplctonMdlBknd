package com.prototype.services;

import java.util.Optional;

import com.prototype.model.UploadDetails;

public interface UploadService {
boolean uploadImage(UploadDetails upDtls);
boolean imgUpldStat();
boolean uploadSig(UploadDetails upDtls);
boolean sigUpldStat();
Optional<UploadDetails> getImg();
Optional<UploadDetails> getSig();
boolean delUpload();
}
