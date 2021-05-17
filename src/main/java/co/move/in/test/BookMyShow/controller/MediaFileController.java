package co.move.in.test.BookMyShow.controller;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.move.in.test.BookMyShow.services.aws.s3.AmazonS3ClientService;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/media/file")
public class MediaFileController {
	
	 	@Autowired
	    private AmazonS3ClientService amazonS3ClientService;
	    
	 
		
		
	    
	    @PostMapping("upload")
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public Map<String, String> uploadFile(@RequestParam(value = "file") MultipartFile file , @RequestParam("file_name") String fileName)
	    {
	 
	        this.amazonS3ClientService.uploadFileToS3Bucket(file,fileName, true);
	        Map<String, String> response = new HashMap<>();
	        response.put("url", this.amazonS3ClientService.getFileLink());
	        response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");
	        return response;
	    }

	    

	    @PostMapping("group/photo")
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public Map<String, String> uploadgroupPhoto(@RequestParam(value = "file") MultipartFile file , @RequestParam("file_name") String fileName){
	    	  this.amazonS3ClientService.uploadFileToS3Bucket(file,fileName, true);

	          Map<String, String> response = new HashMap<>();
	          response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");

	          return response;
	    }
	    
	    
	    @DeleteMapping("profile")
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public Map<String, String> deleteFile(@RequestParam("file_name") String fileName)
	    {
	        this.amazonS3ClientService.deleteFileFromS3Bucket(fileName);

	        Map<String, String> response = new HashMap<>();
	        response.put("message", "file [" + fileName + "] removing request submitted successfully.");

	        return response;
	    }
	    
	    

}
