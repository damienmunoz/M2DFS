package com.m2dfs.match.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.m2dfs.match.model.MatchModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Match", description = "REST Api de Match")
@RestController
public class MatchController {
    List<MatchModel> matchs = new ArrayList<MatchModel>();
	{
		matchs.add(new MatchModel("1", "1-1", "Real Madrid", "FC Barcelona"));
		matchs.add(new MatchModel("2", "2-1", "FC Barcelona", "Real Madrid"));
		matchs.add(new MatchModel("3", "2-3", "Real Madrid", "FC Barcelona"));
	}

    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Suceess|OK"),
        @ApiResponse(code = 401, message = "not authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })

	@ApiOperation(value = "Retourne la liste des matchs", response = MatchModel.class, tags = "Match")
	@GetMapping(value = "/getMatchs")
	public List<MatchModel> getMatchs() {
		return matchs;
	}

	@ApiOperation(value = "Retourne un match avec l'id", response = MatchModel.class, tags = "Match")
	@GetMapping(value = "/getMatch/{id}")
	public MatchModel getMatch(@PathVariable(value = "id") String id) {
		return matchs.stream().filter(x -> x.getId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0);
	}

	@ApiOperation(value = "Ajout d'un match", response = MatchModel.class, tags = "Match")
	@PostMapping(path = "/postMatch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MatchModel> create(@RequestBody MatchModel newMatch) throws Exception {
		if (newMatch == null) {
			throw new Exception();
		} else {
			matchs.add(newMatch);
			return new ResponseEntity<>(newMatch, HttpStatus.CREATED);
		}
	}

	@ApiOperation(value = "Modification d'un match", response = MatchModel.class, tags = "Match")
	@PutMapping(path = "/putMatch/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MatchModel> update(@PathVariable String id, @RequestBody MatchModel modMatch) throws Exception {
		MatchModel existingMatch = matchs.stream().filter(x -> x.getId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0);
		if (modMatch == null) {
			throw new Exception();
		} else {
			existingMatch.setScore(modMatch.getScore());
            existingMatch.setEquipe1(modMatch.getEquipe1());
            existingMatch.setEquipe2(modMatch.getEquipe2());
			return new ResponseEntity<>(modMatch, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Suppression d'un match", response = MatchModel.class, tags = "Match")
	@DeleteMapping("/delMatch/{id}")
	public ResponseEntity<String> delMatch(@PathVariable String id) {
		MatchModel existingMatch = matchs.stream().filter(x -> x.getId().equalsIgnoreCase(id)).findFirst().orElse(null);

		if (existingMatch == null) {
			return new ResponseEntity<>("Le match avec l'ID " + id + " n'a pas été trouvée.", HttpStatus.NOT_FOUND);
		}
		matchs.remove(existingMatch);
		return new ResponseEntity<>("Le match avec l'ID " + id + " a été supprimé avec succès.", HttpStatus.OK);
	}
}