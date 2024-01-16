package com.m2dfs.joueur.controller;

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
import com.m2dfs.joueur.model.JoueurModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Joueur", description = "REST Api de Joueur")
@RestController
public class JoueurController {
    List<JoueurModel> joueurs = new ArrayList<JoueurModel>();
	{
		joueurs.add(new JoueurModel("1", "Igor Stavo", "MDF"));
		joueurs.add(new JoueurModel("2", "Jacques Bravo", "BU"));
		joueurs.add(new JoueurModel("3", "Fran Lucas", "GB"));

		joueurs.add(new JoueurModel("4", "Pio Rinia", "DC"));
        joueurs.add(new JoueurModel("5", "Ian Pelo", "MDF"));
		joueurs.add(new JoueurModel("6", "Killian Otis", "BU"));
	}

    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Suceess|OK"),
        @ApiResponse(code = 401, message = "not authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })

	@ApiOperation(value = "Retourne la liste des joueurs", response = JoueurModel.class, tags = "Joueur")
	@GetMapping(value = "/getJoueurs")
	public List<JoueurModel> getJoueurs() {
		return joueurs;
	}

	@ApiOperation(value = "Retourne un joueur avec l'id", response = JoueurModel.class, tags = "Joueur")
	@GetMapping(value = "/getJoueur/{id}")
	public JoueurModel getJoueur(@PathVariable(value = "id") String id) {
		return joueurs.stream().filter(x -> x.getId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0);
	}

	@ApiOperation(value = "Ajout d'un joueur", response = JoueurModel.class, tags = "Joueur")
	@PostMapping(path = "/postJoueur", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JoueurModel> create(@RequestBody JoueurModel newJoueur) throws Exception {
		if (newJoueur == null) {
			throw new Exception();
		} else {
			joueurs.add(newJoueur);
			return new ResponseEntity<>(newJoueur, HttpStatus.CREATED);
		}
	}

	@ApiOperation(value = "Modification d'un joueur", response = JoueurModel.class, tags = "Joueur")
	@PutMapping(path = "/putJoueur/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JoueurModel> update(@PathVariable String id, @RequestBody JoueurModel modJoueur) throws Exception {
		JoueurModel existingJoueur = joueurs.stream().filter(x -> x.getId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0);
		if (modJoueur == null) {
			throw new Exception();
		} else {
			existingJoueur.setName(modJoueur.getName());
			existingJoueur.setRole(modJoueur.getRole());
			return new ResponseEntity<>(modJoueur, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Suppression d'un joueur", response = JoueurModel.class, tags = "Joueur")
	@DeleteMapping("/delJoueur/{id}")
	public ResponseEntity<String> delJoueur(@PathVariable String id) {
		JoueurModel existingJoueur = joueurs.stream().filter(x -> x.getId().equalsIgnoreCase(id)).findFirst().orElse(null);

		if (existingJoueur == null) {
			return new ResponseEntity<>("Le joueur avec l'ID " + id + " n'a pas été trouvée.", HttpStatus.NOT_FOUND);
		}
		joueurs.remove(existingJoueur);
		return new ResponseEntity<>("Le joueur avec l'ID " + id + " a été supprimé avec succès.", HttpStatus.OK);
	}

}
