package com.gitlab.saylenty.chessPl;

import com.gitlab.saylenty.chessPl.GameItems.ChessBoard;
import com.gitlab.saylenty.chessPl.GameItems.Figures.Figure;
import com.gitlab.saylenty.chessPl.Infrustucture.FiguresFactory;
import com.gitlab.saylenty.chessPl.Logic.BFRecursiveStrategy;
import com.gitlab.saylenty.chessPl.Logic.ChessGame;
import com.google.common.base.Stopwatch;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Created by Saylenty on 11-Apr-17.
 * Copyright (c) 2017
 * </p>
 */

public class Main {

    public static void main(String[] args) {
        // create the ChessGame
        ChessGame game = new ChessGame();

        // create the game board
        ChessBoard chessBoard = new ChessBoard(9, 6);

        // create figures and add them to the game board
        ArrayList<Figure> figures = new ArrayList<>(6);

        FiguresFactory figuresFactory = new FiguresFactory();
        figures.add(figuresFactory.queen(Color.black, chessBoard)); // one Queen
        figures.add(figuresFactory.rock(Color.black, chessBoard)); // one Rock
        figures.add(figuresFactory.knight(Color.black, chessBoard)); // one Knight
        figures.add(figuresFactory.bishop(Color.black, chessBoard)); // one Bishop
        figures.add(figuresFactory.king(Color.black, chessBoard)); // two Kings
        figures.add(figuresFactory.king(Color.white, chessBoard)); // two Kings

        // print the message about game start
        System.out.println(String.format("Game has been started at %s", new Date().toString()));

        // create timer
        Stopwatch timer = Stopwatch.createStarted();

        int result = game.start(new BFRecursiveStrategy(chessBoard, figures));

        // stop the timer
        timer.stop();

        // print the result of the game
        System.out.println(String.format("The result is %d", result));
        System.out.println(String.format("Elapsed time (ms) %d", timer.elapsed(TimeUnit.MILLISECONDS)));
    }
}
