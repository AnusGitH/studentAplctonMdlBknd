package com.prototype.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prototype.model.UploadDetails;
import com.prototype.services.UploadService;

@RestController
@RequestMapping("/api") 
public class UploadController {
	@Autowired
	private UploadService uploadService;
	
	UploadDetails upDtls = new UploadDetails();
	
	@PostMapping("/imgUpload")   
	public boolean uploadImage( @RequestParam("img") MultipartFile img) throws IOException {
		System.out.println("Raw image byte size - " + img.getBytes().length);
		upDtls.setImg_name(img.getOriginalFilename());
		upDtls.setImg_type(img.getContentType());
		upDtls.setImg_pic_byte(cmprsImg(img.getBytes()));
	    return uploadService.uploadImage(upDtls);
	}
	
	@PostMapping("/sigUpload")   
	public boolean uploadSig( @RequestParam("sig") MultipartFile sig) throws IOException {
		System.out.println("Raw signature byte size - " + sig.getBytes().length);
    	upDtls.setSig_name(sig.getOriginalFilename());
		upDtls.setSig_type(sig.getContentType());
		upDtls.setSig_pic_byte(cmprsImg(sig.getBytes()));
	    return uploadService.uploadSig(upDtls);
	}
	
	@GetMapping("/img")
	public UploadDetails getImg() { 
		final Optional<UploadDetails> retrievedImage = uploadService.getImg();
		UploadDetails img = new UploadDetails(null, retrievedImage.get().getImg_name(), retrievedImage.get().getImg_type(),
				dcmprsImg(retrievedImage.get().getImg_pic_byte()), null, null, null,null);
		return img;
	}
	
	@GetMapping("/imgUpldStat")
	public boolean imgUpldStat() { 
		return uploadService.imgUpldStat();
	}
	
	@GetMapping("/sig")
	public UploadDetails getSig() { 
		final Optional<UploadDetails> retrievedImage = uploadService.getSig();
		UploadDetails sig = new UploadDetails(null, null, null, null, retrievedImage.get().getSig_name(), retrievedImage.get().getSig_type(),
				dcmprsImg(retrievedImage.get().getSig_pic_byte()),null);
		return sig;
	} 
	
	@GetMapping("/sigUpldStat")
	public boolean sigUpldStat() { 
		return uploadService.sigUpldStat();
	}
	
		public static byte[] cmprsImg(byte[] data) {
			Deflater df = new Deflater();
			df.setInput(data);
			df.finish();

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!df.finished()) {
				int count = df.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			return outputStream.toByteArray();
		}

		public static byte[] dcmprsImg(byte[] data) {
			Inflater infltr = new Inflater();
			infltr.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!infltr.finished()) {
					int count = infltr.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
		
		@DeleteMapping("/delUpload")   
		public boolean delUpload() {
			upDtls.setAppId(null);
			upDtls.setImg_name(null);
			upDtls.setImg_pic_byte(null);
			upDtls.setImg_type(null);
			upDtls.setSig_name(null);
			upDtls.setSig_pic_byte(null);
			upDtls.setSig_type(null);
			
		    return uploadService.delUpload();
		}
}
