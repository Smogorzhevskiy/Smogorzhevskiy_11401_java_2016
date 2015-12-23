import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Checkers extends JFrame implements Serializable {
    int size;
    JButton[][] buttons;
    Checker[][] checker;
    final int buttonSize = 70;
    int myCheckers;
    int yourCheckers;
    JButton highlightedButton = new JButton();
    JButton actionButton = new JButton();
    Queue<JButton> queue = new LinkedList<JButton>();
    ImageIcon[] image = new ImageIcon[5];
    Queue<Checker> result;
    Queue<Checker> input;
    Checker check;
    volatile boolean isJump;
    volatile boolean moveLimit;
    volatile boolean move;
    ObjectOutputStream os;
    ObjectInputStream is;
    JTextPane jTextPane;
    volatile int how_checkers = 0;

    private void newGame() {
        try {
            this.moveLimit = (boolean) is.readObject();
            this.isJump = false;
            move= !moveLimit;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Checkers(final int size, final int myCheckers, final int yourCheckers, ObjectOutputStream os,
                    ObjectInputStream is) {
        this.size = size;
        this.os = os;
        this.is = is;
        this.myCheckers = myCheckers;
        this.yourCheckers = yourCheckers;
        this.buttons = new JButton[size][size];
        this.checker = new Checker[size][size];
        this.result = new LinkedList<Checker>();
        newGame();
        createImg();
        setTitle("Checkers");
        setBounds(70, 70, buttonSize * size + buttonSize, buttonSize * size + buttonSize * 3/2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GroupLayout(getContentPane()));
        final JTextPane jTextPane = new JTextPane();
        jTextPane.setBounds(size * buttonSize/7*2, size * buttonSize, buttonSize*4, buttonSize/2);
        String string = "Not your. So it makes you angry";
        if(move)
            string = "Your turn";
        jTextPane.setText(string);
        add(jTextPane);
        this.jTextPane =jTextPane;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final JButton jb = new JButton();
                if ((i + j) % 2 == 1) {
                    jb.setBackground(Color.BLACK);
                    jb.setEnabled(false);
                } else {
                    if (i > 4) {
                        jb.setIcon(image[myCheckers]);
                        checker[i][j] = new Checker(myCheckers);
                    } else {
                        if (i < 3) {
                            jb.setIcon(image[yourCheckers]);
                            checker[i][j] = new Checker(yourCheckers);
                        } else
                            checker[i][j] = new Checker(0);
                    }
                    buttons[i][j] = jb;
                    jb.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (move) {
                                JButton jb = (JButton) e.getSource();
                                int j = (jb.getX() / buttonSize);
                                int i = (jb.getY() / buttonSize);
                                setJump(i, j, jb);

                                if (!moveLimit) {
                                    actionButton = jb;
                                    if (checker[i][j].getColor() == myCheckers) {
                                        if (!checker[i][j].isQueen()) {
                                            if (!isJump) {
                                                moveChecker(i, j, -1, 1);
                                                moveChecker(i, j, -1, -1);
                                            } else {
                                                eatChecker(i, j, -1, 1);
                                                eatChecker(i, j, -1, -1);
                                            }
                                            eatChecker(i, j, 1, 1);
                                            eatChecker(i, j, 1, -1);
                                        } else {
                                            eatQueen(i, j, 1, 1, isJump);
                                            eatQueen(i, j, 1, -1, isJump);
                                            eatQueen(i, j, -1, 1, isJump);
                                            eatQueen(i, j, -1, -1, isJump);
                                        }
                                    }
                                }
                                if (queue.size() == 0 && isJump) {
                                    moveLimit = true;
                                }
                                if (moveLimit){
                                    move = false;
                                    jTextPane.setText("Not your. So it makes you angry");
                                }
                            }
                        }
                    });
                }
                jb.setBounds(j * buttonSize, i * buttonSize, buttonSize, buttonSize);

                add(jb);
            }
        }
        setVisible(true);
    }

    private void setJump(int i, int j, JButton jb) {
        // selected button has a checker
        while ((highlightedButton = queue.poll()) != null) {
        //
            if (jb == highlightedButton) {
                int x = (actionButton.getY() / buttonSize);
                int y = (actionButton.getX() / buttonSize);
                checker[i][j].setColor(checker[x][y].getColor());
                checker[i][j].setImage(checker[x][y].getImage());
                if (i == 0) {
                    checker[i][j].setQueen();
                }
                checker[x][y].setX(x);
                checker[x][y].setY(y);
                actionButton.setIcon(image[0]);
                checker[x][y].setColor(0);
                result.add(checker[x][y]);
                jb.setIcon(image[checker[i][j].getImage()]);
                if (abs(x - i) > 1 && abs(y - j) > 1) {
                    int i1 = (x - i) / abs(x - i);
                    int j1 = (y - j) / abs(y - j);
                    openButton(x, y, i, j, i1, j1);
                } else {
                    moveLimit = true;
                }
                isJump = true;
                checker[i][j].setX(i);
                checker[i][j].setY(j);
                result.add(checker[i][j]);
            }
        }
    }


    private void openButton(int x, int y, int i, int j, int i1, int j1) {
        boolean f = true;
        while (i != (x - i1)) {
            i += i1;
            j += j1;
            if (checker[i][j].getColor() == yourCheckers) {
                checker[i][j].setX(i);
                checker[i][j].setY(j);
                result.add(checker[i][j]);
                how_checkers = how_checkers +1;
                f = false;
            }
            buttons[i][j].setIcon(image[0]);
            checker[i][j].setColor(0);
        }
        moveLimit = f;
    }

    private void eatQueen(int i, int j, int k, int n, boolean f1) {
        if (i + k > -1 && j + n > -1 && i + k < size && j + n < size) {
            int i1 = i;
            int j1 = j;
            Queue<JButton> queue1 = new LinkedList<JButton>();
            boolean b = true;
            boolean b1 = true;
            boolean f = false;
            while (i1 + k > -1 && j1 + n > -1 && i1 + k < size && j1 + n < size &&
                    !(checker[i1 + k][j1 + n].getColor() == myCheckers) && (b | b1)) {
                if (checker[i1 + k][j1 + n].getColor() == 0) {
                    queue1.add(buttons[i1 + k][j1 + n]);
                    b = true;
                    if(checker[i1][j1].getColor() == yourCheckers)
                        f = true;
                } else if (checker[i1 + k][j1 + n].getColor() == yourCheckers) {
                    b1 = b & b1;
                    b = false;
                }
                i1 += k;
                j1 += n;
            }

            if (!f1 || f) {
                while ((highlightedButton = queue1.poll()) != null) {
                    queue.add(highlightedButton);

                }
            }
        }
    }

    private void moveChecker(int i, int j, int k, int n) {
        if (i + k < size && j + n < size && i + k > -1 && j + n > -1) {
            if (checker[i + k][j + n].getColor() == 0) {
                queue.add(buttons[i + k][j + n]);
            } else {
                eatChecker(i, j, k, n);
            }
        }
    }

    private void eatChecker(int i, int j, int k, int n) {
        if (i + 2 * k < size && j + 2 * n < size && i + 2 * k > -1 && j + 2 * n > -1 &&
                checker[i + k][j + n].getColor() == yourCheckers) {
            k *= 2;
            n *= 2;
            if (checker[i + k][j + n].getColor() == 0) {
                buttons[i + k][j + n].setBackground(Color.ORANGE);
                queue.add(buttons[i + k][j + n]);
            }
        }
    }

    public void createImg() {
        image[0] = null;
        image[1] = setIcon(new ImageIcon("black.png"), buttonSize);
        image[2] = setIcon(new ImageIcon("white.png"), buttonSize);
        image[3] = setIcon(new ImageIcon("Qblack.png"), buttonSize);
        image[4] = setIcon(new ImageIcon("Qwhite.png"), buttonSize);
    }

    public ImageIcon setIcon(ImageIcon icon, int size) {
        Image img = icon.getImage().getScaledInstance(size * 4 / 5, size * 4 / 5, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        return icon;
    }
}
