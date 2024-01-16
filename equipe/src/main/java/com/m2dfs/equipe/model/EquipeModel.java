package com.m2dfs.equipe.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class EquipeModel {

    @ApiModelProperty(notes = "Id de l'équipe",name="id",required=true,value="1")
	private String id;
    @ApiModelProperty(notes = "Nom de l'équipe",name="name",required=true,value="FC Barcelone")
	private String name;
	@ApiModelProperty(notes = "Pays de l'équipe",name="country",required=true,value="Barcelone")
	private String country;
	@ApiModelProperty(notes = "Joueur de l'équipe",name="joueurs",required=true,value="Espagne")
	List<String> joueurs = new ArrayList<String>();;

	public EquipeModel() {
	}

	public EquipeModel(String id, String name, String country, List<String> joueurs) {
		super();
		this.name = name;
		this.id = id;
		this.country = country;
        this.joueurs = joueurs;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

    public List<String> getJoueurs() {
		return joueurs;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setJoueurs(List<String> joueurs) {
		this.joueurs = joueurs;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", name=" + name + ", country=" + country + ", players=" + joueurs + "]";
	}
}
