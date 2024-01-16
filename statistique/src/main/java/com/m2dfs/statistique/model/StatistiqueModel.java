package com.m2dfs.statistique.model;

import io.swagger.annotations.ApiModelProperty;

public class StatistiqueModel {
    @ApiModelProperty(notes = "Id de statistique",name="id",required=true,value="1")
	private String id;
    @ApiModelProperty(notes = "But de statistique",name="goal",required=true,value="3")
	private String goal;
    @ApiModelProperty(notes = "Victoire de statistique",name="win",required=true,value="1")
	private String win;
    @ApiModelProperty(notes = "Défaite de statistique",name="loss",required=true,value="2")
	private String loss;
    @ApiModelProperty(notes = "Name de statistique",name="name",required=true,value="Real Madrid")
	private String name;

	public StatistiqueModel() {
	}

	public StatistiqueModel(String id, String goal, String win, String loss, String name) {
		super();
		this.goal = goal;
		this.id = id;
        this.win = win;
		this.loss = loss;
        this.name = name;
	}

	public String getGoal() {
		return goal;
	}

	public String getId() {
		return id;
	}

    public String getWin() {
		return win;
	}

	public String getLoss() {
		return id;
	}

    public String getName() {
		return name;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public void setId(String id) {
		this.id = id;
	}

    public void setWin(String win) {
		this.win = win;
	}

	public void setLoss(String loss) {
		this.loss = loss;
	}

    public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Joueur [id=" + id + ", but=" + goal + ", win=" + win + ", loss=" + loss + ", name=" + name + "]";
	}
}
