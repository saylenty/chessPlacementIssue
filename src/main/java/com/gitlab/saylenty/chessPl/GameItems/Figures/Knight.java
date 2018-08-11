/*
  Saylenty on 11-Apr-17.
  Copyright (c) 2017
 */
package com.gitlab.saylenty.chessPl.GameItems.Figures;

import com.gitlab.saylenty.chessPl.Infrustucture.Space;

import java.awt.*;

public class Knight extends Piece {

    public Knight() {
        this(null, new Space(0, 0));
    }

    public Knight(Color color, Space position) {
        this("Knight", color, position);
    }

    public Knight(String name, Color color, Space position) {
        super(name, color, position);
    }

    public Knight(Color color) {
        this(color, new Space(0, 0));
    }

    @Override
    protected void computeCaptureZone() {
        int x = position.getX();
        int y = position.getY();
        int chessBoardHeight = this.chessBoard.getHeight();
        int chessBoardWidth = this.chessBoard.getWidth();

        up(x, y);
        left(x, y, chessBoardHeight);
        bottom(x, y, chessBoardHeight, chessBoardWidth);
        right(x, y, chessBoardHeight, chessBoardWidth);
    }

    private void up(int x, int y) {
        y -= 2;
        if (y >= 0) {
            int a = x - 1;
            int b = x + 1;
            if (a >= 0) {
                captureZone.add(new Space(a, y));
            }
            if (b >= 0) {
                captureZone.add(new Space(b, y));
            }
        }
    }

    private void bottom(int x, int y, int chessBoardHeight, int chessBoardWidth) {
        y += 2;
        if (y < chessBoardHeight) {
            int a = x - 1;
            int b = x + 1;
            if (a >= 0) {
                captureZone.add(new Space(a, y));
            }
            if (b < chessBoardWidth) {
                captureZone.add(new Space(b, y));
            }
        }
    }

    private void left(int x, int y, int chessBoardHeight) {
        x -= 2;
        if (x >= 0) {
            int a = y - 1;
            int b = y + 1;
            if (a >= 0) {
                captureZone.add(new Space(x, a));
            }
            if (b < chessBoardHeight) {
                captureZone.add(new Space(x, b));
            }
        }
    }

    private void right(int x, int y, int chessBoardHeight, int chessBoardWidth) {
        x += 2;
        if (x < chessBoardWidth) {
            int a = y + 1;
            int b = y - 1;
            if (a < chessBoardHeight) {
                captureZone.add(new Space(x, a));
            }
            if (b >= 0) {
                captureZone.add(new Space(x, b));
            }
        }
    }
}
