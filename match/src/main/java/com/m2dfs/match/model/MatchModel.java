package com.m2dfs.match.model;

import io.swagger.annotations.ApiModelProperty;

public class MatchModel {
    @ApiModelProperty(notes = "Id du match",name="id",required=true,value="1")
	private String id;
    @ApiModelProperty(notes = "Score du match",name="score",required=true,value="1-1")
	private String score;
    @ApiModelProperty(notes = "Equipe 1 du match",name="equipe1",required=true,value="Real Madrid")
	private String equipe1;
    @ApiModelProperty(notes = "Equipe 2 du match",name="equipe2",required=true,value="FC Barcelone")
	private String equipe2;



	public MatchModel() {
	}

	public MatchModel(String id, String score, String equipe1, String equipe2) {
		super();
		this.score = score;
		this.id = id;
        this.equipe1 = equipe1;
		this.equipe2 = equipe2;
	}

	public String getScore() {
		return score;
	}

	public String getId() {
		return id;
	}

    public String getEquipe1() {
		return equipe1;
	}

	public String getEquipe2() {
		return equipe2;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public void setId(String id) {
		this.id = id;
	}

    public void setEquipe1(String equipe1) {
		this.equipe1 = equipe1;
	}

	public void setEquipe2(String equipe2) {
		this.equipe2 = equipe2;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", score=" + score + ", equipe1=" + equipe1 + ", equipe2=" + equipe2 + "]";
	}
}
