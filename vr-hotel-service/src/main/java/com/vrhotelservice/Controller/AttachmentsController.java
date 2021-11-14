package com.vrhotelservice.Controller;

import com.vrhotelservice.Entity.AttachmentsEntity;
import com.vrhotelservice.Service.AttachmentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/attachments")
@Tag(name = "HotelAttachment", description = "The Hotel attachments api")
public class AttachmentsController {
	
	@Autowired
	private AttachmentsService attachmentsService;
	
	@GetMapping
	@Operation(description = "Find all Attachments", summary = "Returns a list of attachments." ,tags = {"HotelAttachment"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = AttachmentsEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public List<AttachmentsEntity> findAllAttachments() {
		return attachmentsService.findAllAttachments();
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Find attachment by Id", summary = "Returns a single attachment" ,tags = {"HotelAttachment"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = AttachmentsEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public AttachmentsEntity findAttachment(@PathVariable("id") Long attachmentId) {
		return attachmentsService.findAttachment(attachmentId);
	}
	
	@DeleteMapping("/{id}")
	@Operation(description = "Delete Attachment", summary = "Returns the deletion success message" ,tags = {"HotelAttachment"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation"),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public String deleteAttachment(Long attachmentId) {
		return attachmentsService.deleteAttachment(attachmentId);
	}
	
	@PostMapping(value = "/{hotelId}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	@Operation(description = "Create attachment", summary = "returns the created attachment" ,tags = {"HotelAttachment"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = AttachmentsEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public AttachmentsEntity createAttachment(@RequestParam("file") MultipartFile file, 
			@PathVariable("hotelId") Long hotelId ) throws IOException {
		return attachmentsService.createAttachment(file, hotelId);
	}
	
	@GetMapping("/download")
	@Operation(description = "download attachment", summary = "downloads the file" ,tags = {"HotelAttachment"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = AttachmentsEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
    public void download(@RequestParam("file") String fileName,
                         HttpServletResponse resp, HttpServletRequest req) throws Exception{
		         attachmentsService.downloadAttachment(req, resp, fileName);
    }	
}
