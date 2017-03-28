package com.amazon.design;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {
	
	Board chessBoard = null;
	Player blackP = null;
	Player whiteP = null;
	
	public ChessGame() {
		init();
	}
	
	private void init() {
		chessBoard = new Board();
		blackP = new Player(chessBoard,ChessPlayer.BLACK);
		whiteP = new Player(chessBoard,ChessPlayer.WHITE);
		
		blackP.setPicese();
		whiteP.setPicese();
	}
	

	private void play() {
		Location source = new Location(0, 0);
		Location destination = new Location(5, 0);
		whiteP.move(source,destination);
		
		source = new Location(0, 0);
		destination = new Location(5, 0);
		blackP.move(source,destination);
	}

	public static void main(String[] args) {
		ChessGame chessGame= new ChessGame();
		chessGame.play();
	}


}

class Location{
	public int x,y;
	public Location(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

enum ChessPlayer {
	BLACK,WHITE;
}

class Player{

	Board chessBoard = null;
	ChessPlayer chessPlayer = null;
	List<Piceses> killedByPlayer =null;
	
	public Player(Board chessBoard, ChessPlayer chessPlayer) {
		this.chessBoard=chessBoard;
		this.chessPlayer=chessPlayer;
		killedByPlayer = new ArrayList<Piceses>();
	}

	public void move(Location source, Location destination) {
		Move move = new Move(chessPlayer,source,destination);
		Piceses anyKilled = chessBoard.move(move);
		if(anyKilled!=null)
			killedByPlayer.add(anyKilled);
	}

	public void setPicese() {
		if(ChessPlayer.WHITE == this.chessPlayer){
			chessBoard.setWhitePicese();
		}else{
			chessBoard.setBlackPicese();
		}
	}
	
}

class Move{

	ChessPlayer chessPlayer;
	Location source,destination;
	
	public Move(ChessPlayer chessPlayer, Location source, Location destination) {
		this.chessPlayer = chessPlayer;
		this.source = source;
		this.destination = destination;
	}
	
}

class Board{

	Piceses[][] board = null;
	List<Move> allGameMoves = null;
	
	public Board() {
		board = new Piceses[8][8];
		allGameMoves = new ArrayList<Move>();
	}
	
	private Piceses getPices(Location location){
		return board[location.x][location.y];
	}

	public Piceses move(Move move) {
		Piceses picese = getPices(move.source);
		
		return null;
	}

	public void setWhitePicese() {
		
	}

	public void setBlackPicese() {
		
	}
	
}

interface Piceses{
	public Piceses isValid();
	public Piceses move();
}

class King implements Piceses{

	ChessPlayer chessPlayer;
	
	public King(ChessPlayer chessPlayer) {
		this.chessPlayer=chessPlayer;
	}
	
	@Override
	public Piceses isValid() {
		return null;
	}

	@Override
	public Piceses move() {
		return null;
	}
	
}