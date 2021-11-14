package com.vrhotelservice.Controller;

import com.vrhotelservice.Entity.CommentsEntity;
import com.vrhotelservice.Service.CommentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/hotel-comments")
@Tag(name = "HotelComments", description = "The Hotel comments api")
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	@GetMapping
	@Operation(description = "Find all comments", summary = "Returns a list of Comments" ,tags = {"HotelComments"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = CommentsEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public List<CommentsEntity> findAllComments(){
		return commentsService.findAllComments();
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Find Comment by Id", summary = "Returns a single comment" ,tags = {"HotelComments"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = CommentsEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public CommentsEntity findComment(@PathVariable("id") Long commentId) {
	 return commentsService.findComment(commentId);	
	}	
	
	@PostMapping("/{hotelId}")
	@Operation(description = "Create comment", summary = "returns the created comment" ,tags = {"HotelComments"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = CommentsEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public CommentsEntity createComment(@PathVariable("hotelId") Long hotelId,
			@RequestBody CommentsEntity comment) {
		return commentsService.createComment(hotelId, comment);
	}
	
	@DeleteMapping("/{id}")
	@Operation(description = "Delete Comment", summary = "Returns the deletion success message" ,tags = {"HotelComments"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation"),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public String deleteComment(@PathVariable("id") Long commentId) {
		return commentsService.deleteComment(commentId);
	}
	
	@PutMapping("/{id}")
	@Operation(description = "Update comment", summary = "Returns the updated comment" ,tags = {"HotelComments"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = CommentsEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public ResponseEntity<CommentsEntity> updateComment(@PathVariable("id") Long commentId,
			@RequestBody CommentsEntity comment){
		return ResponseEntity.ok(this.commentsService.updateComment(commentId, comment));
	}
}
