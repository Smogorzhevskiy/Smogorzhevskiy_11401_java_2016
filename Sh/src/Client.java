import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class Client {
    ObjectOutputStream os;
    ObjectInputStream is;
    Socket s;

    public void connection() throws IOException {
        int port = 3456;
        String host = "localhost";
        s = new Socket(host, port);
        this.os = new ObjectOutputStream(s.getOutputStream());
        this.is = new ObjectInputStream(s.getInputStream());
    }

    public Client(LookingForwardAnAssailant l) throws IOException, ClassNotFoundException {
        connection();
        int i = (Integer) is.readObject();
        l.dispose();
        int j;
        if (i == 1)
            j = 2;
        else j = 1;
        Checkers checkers = new Checkers(8, i, j, os, is);
        while (true) {
            if (!checkers.move && checkers.moveLimit) {
                send(checkers);
                input(checkers);
            }
        }
    }
// отправить данные о шашках другому игроку
    public void send(Checkers client) {
        try {
            os.reset();
            os.writeObject(client.result);
            os.reset();
            os.writeObject(client.how_checkers);
            client.result = new LinkedList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void input(Checkers client) throws IOException {
        try {
            boolean b = (boolean) is.readObject();
            if (b) {
                client.input = (Queue) is.readObject();
                while ((client.check = client.input.poll()) != null) {
                    if (client.check.getColor() == client.myCheckers) {
                        client.checker[7 - client.check.getX()][7 - client.check.getY()].setColor(0);
                        client.buttons[7 - client.check.getX()]
                                [7 - client.check.getY()].setIcon(client.image[client.checker[7 - client.check.getX()]
                                [7 - client.check.getY()].getImage()]);
                    } else {
                        client.checker[7 - client.check.getX()][7 - client.check.getY()] = client.check;
                        client.buttons[7 - client.check.getX()][7 - client.check.getY()].setIcon(client.image[client.check.getImage()]);
                    }
                }
                client.moveLimit = false;
                client.isJump = false;
                client.move = true;
                client.jTextPane.setText("Your turn");
                client.how_checkers = 0;
            } else {
                String string = "You lose!";
                boolean isWin = (boolean) is.readObject();
                if (isWin)
                    string = "You win!";
                if (JOptionPane.showConfirmDialog(null, "Game is over! " + string + "Would you like to play more?", string,
                        JOptionPane.YES_NO_OPTION) == 0) {
                    client.dispose();
                    new Client(new LookingForwardAnAssailant());
                    os.writeObject(true);
                } else {
                    client.dispose();
                    os.writeObject(false);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class LookingForwardAnAssailant extends JFrame {
        public LookingForwardAnAssailant(){
            JButton jb = new JButton();
            setBounds(700, 450, 500, 350);
            setLayout(new GroupLayout(getContentPane()));
            jb.setBounds(0,0,500, 350);
            jb.setText("Looking forward an assailant");
            add(jb);
            setVisible(true);

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LookingForwardAnAssailant wait = new LookingForwardAnAssailant();
        new Client(wait);
    }
}
