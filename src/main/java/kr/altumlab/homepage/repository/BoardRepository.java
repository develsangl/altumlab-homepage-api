package kr.altumlab.homepage.repository;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kr.altumlab.homepage.domain.Board;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

//@Operation(summary = "Send Messages to Ibm Mq", description = "Send Message to the related ibm mq")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success Response",
                content = @Content(schema = @Schema(implementation = BoardRepository.class), mediaType = "application/json")),
        @ApiResponse(responseCode = "500", description = "Internal System Error",
                content = @Content(schema = @Schema(implementation = BoardRepository.class), mediaType = "application/json")),
        @ApiResponse(responseCode = "400", description = "Invalid Parameter Request",
                content = @Content(schema = @Schema(implementation = BoardRepository.class), mediaType = "application/json"))
})
@RepositoryRestResource
public interface BoardRepository extends PagingAndSortingRepository<Board, Long> {

    @RestResource(path = "/title")
    List<Board> findBoardByTitle(String title);

    @RestResource(path = "/contents")
    List<Board> findBoardByTitleContainsOrContentsContains(String title, String contents);
}
