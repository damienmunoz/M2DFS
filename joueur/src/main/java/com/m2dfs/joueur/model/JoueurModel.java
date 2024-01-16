package com.m2dfs.joueur.model;

import io.swagger.annotations.ApiModelProperty;

public class JoueurModel {
    @ApiModelProperty(notes = "Id du joueur",name="id",required=true,value="1")
	private String id;
    @ApiModelProperty(notes = "Nom du joueur",name="name",required=true,value="Igor Stavo")
	private String name;
	@ApiModelProperty(notes = "Role du joueur",name="role",required=true,value="Mdf")
	private String role;


	public JoueurModel() {
	}

	public JoueurModel(String id, String name, String role) {
		super();
		this.name = name;
		this.id = id;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
}
