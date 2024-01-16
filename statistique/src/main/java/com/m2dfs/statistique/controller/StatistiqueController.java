package com.m2dfs.statistique.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.m2dfs.statistique.model.StatistiqueModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Statistique", description = "REST Api de Statistique")
@RestController
public class StatistiqueController {
    List<StatistiqueModel> statistiquesEquipe = new ArrayList<StatistiqueModel>();
	{
		statistiquesEquipe.add(new StatistiqueModel("1", "4", "1", "2", "Real Madrid"));
		statistiquesEquipe.add(new StatistiqueModel("2", "5", "2", "1", "FC Barcelone"));
	}

    List<StatistiqueModel> statistiquesJoueur = new ArrayList<StatistiqueModel>();
	{
		statistiquesJoueur.add(new StatistiqueModel("1", "0", "0", "1","Igor Stavo"));
		statistiquesJoueur.add(new StatistiqueModel("2", "2", "1", "2", "Jacques Bravo"));
		statistiquesJoueur.add(new StatistiqueModel("3", "1", "1", "0", "Fran Lucas"));

		statistiquesJoueur.add(new StatistiqueModel("4", "3", "2", "1", "Pio Rinia"));
        statistiquesJoueur.add(new StatistiqueModel("5", "1", "1", "1", "Ian Pelo"));
		statistiquesJoueur.add(new StatistiqueModel("6", "1", "2", "0", "Killian Otis"));
	}

    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Suceess|OK"),
        @ApiResponse(code = 401, message = "not authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })

    @ApiOperation(value = "Retourne une statistique equipe avec l'id equipe", response = StatistiqueModel.class, tags = "Statistique")
    @GetMapping(value = "/getStatistiqueEquipe/{id}")
    public StatistiqueModel getStatistiqueEquipe(@PathVariable(value = "id") String id) {
        return statistiquesEquipe.stream().filter(x -> x.getId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0);
    }

	@ApiOperation(value = "Retourne une statistique joueur avec l'id joueur", response = StatistiqueModel.class, tags = "Statistique")
	@GetMapping(value = "/getStatistiqueJoueur/{id}")
	public StatistiqueModel getStatistiqueJoueur(@PathVariable(value = "id") String id) {
		return statistiquesJoueur.stream().filter(x -> x.getId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0);
	}
}
