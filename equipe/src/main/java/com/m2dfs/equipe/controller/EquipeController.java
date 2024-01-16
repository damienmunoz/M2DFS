package com.m2dfs.equipe.controller;

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
import com.m2dfs.equipe.model.EquipeModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Equipe", description = "REST Api d'Equipe")
@RestController
public class EquipeController {
   
	List<String> joueurs1 = new ArrayList<String>();
	{
		joueurs1.add("Igor Stavo");
		joueurs1.add("Jacques Bravo");
		joueurs1.add("Fran Lucas");
	};
	List<String> joueurs2 = new ArrayList<String>();
	{
		joueurs2.add("Pio Rinia");
		joueurs2.add("Ian Pelo");
		joueurs2.add("Killian Otis");
	};

    List<EquipeModel> equipes = new ArrayList<EquipeModel>();
	{
		equipes.add(new EquipeModel("1", "Real Madrid", "Espagne", joueurs1));
		equipes.add(new EquipeModel("2", "FC Barcelona", "Espagne", joueurs2));
	}


    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Suceess|OK"),
        @ApiResponse(code = 401, message = "not authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })

	@ApiOperation(value = "Retourne la liste des equipes", response = EquipeModel.class, tags = "Equipe")
	@GetMapping(value = "/getEquipes")
	public List<EquipeModel> getEquipes() {
		return equipes;
	}

	@ApiOperation(value = "Retourne une equipe avec l'id", response = EquipeModel.class, tags = "Equipe")
	@GetMapping(value = "/getEquipe/{id}")
	public EquipeModel getEquipe(@PathVariable(value = "id") String id) {
		return equipes.stream().filter(x -> x.getId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0);
	}

	@ApiOperation(value = "Ajout d'une equipe", response = EquipeModel.class, tags = "Equipe")
	@PostMapping(path = "/postEquipe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EquipeModel> create(@RequestBody EquipeModel newEquipe) throws Exception {
		if (newEquipe == null) {
			throw new Exception();
		} else {
			equipes.add(newEquipe);
			return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
		}
	}

	@ApiOperation(value = "Modification d'une equipe", response = EquipeModel.class, tags = "Equipe")
	@PutMapping(path = "/putEquipe/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EquipeModel> update(@PathVariable String id, @RequestBody EquipeModel modEquipe) throws Exception {
		EquipeModel existingEquipe = equipes.stream().filter(x -> x.getId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0);
		if (modEquipe == null) {
			throw new Exception();
		} else {
			existingEquipe.setName(modEquipe.getName());
			existingEquipe.setCountry(modEquipe.getCountry());
			existingEquipe.setJoueurs(modEquipe.getJoueurs());
			return new ResponseEntity<>(modEquipe, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Suppression d'une equipe", response = EquipeModel.class, tags = "Equipe")
	@DeleteMapping("/delEquipe/{id}")
	public ResponseEntity<String> delEquipe(@PathVariable String id) {
		EquipeModel existingEquipe = equipes.stream().filter(x -> x.getId().equalsIgnoreCase(id)).findFirst().orElse(null);

		if (existingEquipe == null) {
			return new ResponseEntity<>("L'équipe avec l'ID " + id + " n'a pas été trouvée.", HttpStatus.NOT_FOUND);
		}
		equipes.remove(existingEquipe);
		return new ResponseEntity<>("L'équipe avec l'ID " + id + " a été supprimée avec succès.", HttpStatus.OK);
	}

}
