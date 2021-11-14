package com.vrtouristservice.Controller;

import com.vrtouristservice.Entity.TouristEntity;
import com.vrtouristservice.Service.TouristService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("api/v1/tourists")
@Tag(name="Tourist", description = "Tourist api")
public class TouristController {
    @Autowired
    private TouristService touristService;
    @GetMapping
    @Operation(summary = "Find all tourists", description = "Returns a list of tourists", tags = {"Tourist"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "successful operation",content = @Content(schema = @Schema(implementation = TouristEntity.class))),
            @ApiResponse(responseCode = "400", description = "Failure operation")
    })
    public ResponseEntity<List<TouristEntity>> findAllTourists(){
        log.info("inside findAllTourists method of TouristController");
        return ResponseEntity.status(HttpStatus.OK).body(touristService.findAllTourists());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a tourist by Id", description = "Returns a single tourist", tags = {"Tourist"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "successful operation",content = @Content(schema = @Schema(implementation = TouristEntity.class))),
            @ApiResponse(responseCode = "400", description = "Failure operation")
    })
    public ResponseEntity<TouristEntity> findTourist(@PathVariable("id") Long touristId){
        log.info("inside findTourist method of TouristController");
        return ResponseEntity.status(HttpStatus.OK).body(touristService.findTourist(touristId));
    }

    @PostMapping
    @Operation(summary = "Create a tourist", description = "Returns the created tourist", tags = {"Tourist"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "successful operation",content = @Content(schema = @Schema(implementation = TouristEntity.class))),
            @ApiResponse(responseCode = "400", description = "Failure operation")
    })
    public ResponseEntity<TouristEntity> createTourist(@RequestBody TouristEntity tourist){
        log.info("inside createTourist method of TouristController");
        return ResponseEntity.status(HttpStatus.CREATED).body(touristService.createTourist(tourist));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete tourist", description = "Returns a delete success message", tags = {"Tourist"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Failure operation")
    })
    public ResponseEntity<String> deleteTourist(@PathVariable("id") Long touristId){
        log.info("inside deleteTourist method of TouristController");
        return ResponseEntity.status(HttpStatus.OK).body(touristService.deleteTourist(touristId));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update tourist", description = "Returns the updated tourist", tags = {"Tourist"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "successful operation",content = @Content(schema = @Schema(implementation = TouristEntity.class))),
            @ApiResponse(responseCode = "400", description = "Failure operation")
    })
    public ResponseEntity<TouristEntity> updateTourist(@PathVariable("id") Long touristId, @RequestBody TouristEntity tourist){
        log.info("inside updateTourist method of TouristController");
        return ResponseEntity.status(HttpStatus.OK).body(touristService.updateTourist(tourist,touristId));
    }

}
