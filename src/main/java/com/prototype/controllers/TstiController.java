package com.prototype.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.model.TstiDetails;
import com.prototype.model.UploadDetails;
import com.prototype.services.TstiService;

@RestController
@RequestMapping("/api") 
public class TstiController {
	@Autowired
	private TstiService tstiService;
	
	@PostMapping("/tstiUpld1")   
	public boolean uploadTsti(@RequestBody Tstdt1 tstdt, UploadDetails upDtls) {
		for(int i=0;i<=tstdt.tstiDetails.length-1;i++) {
			System.out.println("mrkstStd= "+tstdt.tstiDetails[i].getMrkstStd());
			tstdt.tstiDetails[i].setMrkst_pic_byte(compressBytes(tstdt.tstiDetails[i].getMrkstStd().getBytes()));
			tstdt.tstiDetails[i].setCrtft_pic_byte(compressBytes(tstdt.tstiDetails[i].getCrtftStd().getBytes()));
		}
		tstiService.uploadTsti1(tstdt, upDtls);
		return false;
	}
	
	@GetMapping("/tDetails1")
	 public Tstdt1 tDetails1() {
		for(int i=0;i<=tstiService.tDetails1().tstiDetails1.length-1;i++) {
		TstiDetails tDet1 = new TstiDetails(tstiService.tDetails1().tstiDetails1[i].getDegree(),
				 decompressBytes(tstiService.tDetails1().tstiDetails1[i].getMrkst_pic_byte()), tstiService.tDetails1().tstiDetails1[i].getPassyear(), decompressBytes(tstiService.tDetails1().tstiDetails1[i].getCrtft_pic_byte()));
		tstiService.tDetails1().tstiDetails1[i].setMrkstStd(new String(tDet1.getMrkst_pic_byte(),StandardCharsets.UTF_8));
		tstiService.tDetails1().tstiDetails1[i].setMrkst_pic_byte(null);
        tstiService.tDetails1().tstiDetails1[i].setCrtftStd(new String(tDet1.getCrtft_pic_byte(),StandardCharsets.UTF_8));
        tstiService.tDetails1().tstiDetails1[i].setCrtft_pic_byte(null);
  	}
	  return tstiService.tDetails1();
	}
	
	@GetMapping("/tstiUpldStat")
	 public boolean tstiUpldStat() {
		System.out.println("tstiUpldStat= "+tstiService.tstiUpldStat());
	  return tstiService.tstiUpldStat();
	}

	@DeleteMapping("/delTsti")
	public boolean delDetails() {
	return tstiService.delTsti();
	}
	
	// compress the image bytes before storing it in the database
			public static byte[] compressBytes(byte[] data) {
				Deflater deflater = new Deflater();
				deflater.setInput(data);
				deflater.finish();

				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				while (!deflater.finished()) {
					int count = deflater.deflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				try {
					outputStream.close();
				} catch (IOException e) {
				}
				System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
				return outputStream.toByteArray();
			}
			
	// uncompress the image bytes before returning it to the angular application
			public static byte[] decompressBytes(byte[] data) {
				Inflater inflater = new Inflater();
				inflater.setInput(data);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				try {
					while (!inflater.finished()) {
						int count = inflater.inflate(buffer);
						outputStream.write(buffer, 0, count);
					}
					outputStream.close();
				} catch (IOException ioe) {
				} catch (DataFormatException e) {
				}
				System.out.println("decompressed Image Byte Size - " + outputStream.toByteArray().length);
				return outputStream.toByteArray();
			}
}
