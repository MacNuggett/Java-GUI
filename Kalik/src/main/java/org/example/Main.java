package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {

    public static void main(String[] args) {
        new Frame();
    }
}

    class Frame extends JFrame {
        public Frame() {
            JFrame Frame = new JFrame();
            Frame.setTitle("Калькулятор");
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension monitor = toolkit.getScreenSize();
            int width = 300;
            int height = 350;
            Frame.setBounds(monitor.width / 2 - width / 2, monitor.height / 2 - height / 2, width, height);
            Frame.setDefaultCloseOperation(3);
            Panel MyPanel = new Panel();
            Frame.add(MyPanel);
            Frame.setVisible(true);
        }
    }

    class Panel extends JPanel {
        JButton text;
        int firstNumber = 0;
        int secondNumber = 0;
        String operation = "";
        boolean start = true;
        int res = 0;

        public Panel() {
            Font font2 = new Font("Arial", 1, 20);
            this.setLayout(new BorderLayout());
            this.text = new JButton(" ");
            this.text.setFont(new Font("Arial", 1, 40));
            this.text.setEnabled(false);
            this.add(this.text, "North");
            JPanel Panel = new JPanel();
            Panel.setLayout(new GridLayout(4, 4));
            final JButton b1 = new JButton("7");
            b1.setFont(font2);
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.firstNumber == 0 && Panel.this.secondNumber == 0 && Panel.this.operation.equals("")) {
                        Panel.this.text.setText(" ");
                    }

                    JButton var10000 = Panel.this.text;
                    String var10001 = Panel.this.text.getText();
                    var10000.setText(var10001 + b1.getText());
                    Panel var2;
                    if (Panel.this.operation.equals("")) {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.firstNumber);
                        var2.firstNumber = Integer.valueOf(var10001 + b1.getText());
                    } else {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.secondNumber);
                        var2.secondNumber = Integer.valueOf(var10001 + b1.getText());
                    }

                }
            });
            Panel.add(b1);
            final JButton b2 = new JButton("8");
            b2.setFont(font2);
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.firstNumber == 0 && Panel.this.secondNumber == 0 && Panel.this.operation.equals("")) {
                        Panel.this.text.setText(" ");
                    }

                    JButton var10000 = Panel.this.text;
                    String var10001 = Panel.this.text.getText();
                    var10000.setText(var10001 + b2.getText());
                    Panel var2;
                    if (Panel.this.operation.equals("")) {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.firstNumber);
                        var2.firstNumber = Integer.valueOf(var10001 + b2.getText());
                    } else {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.secondNumber);
                        var2.secondNumber = Integer.valueOf(var10001 + b2.getText());
                    }

                }
            });
            Panel.add(b2);
            final JButton b3 = new JButton("9");
            b3.setFont(font2);
            b3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.firstNumber == 0 && Panel.this.secondNumber == 0 && Panel.this.operation.equals("")) {
                        Panel.this.text.setText(" ");
                    }

                    JButton var10000 = Panel.this.text;
                    String var10001 = Panel.this.text.getText();
                    var10000.setText(var10001 + b3.getText());
                    Panel var2;
                    if (Panel.this.operation.equals("")) {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.firstNumber);
                        var2.firstNumber = Integer.valueOf(var10001 + b3.getText());
                    } else {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.secondNumber);
                        var2.secondNumber = Integer.valueOf(var10001 + b3.getText());
                    }

                }
            });
            Panel.add(b3);
            final JButton b4 = new JButton("/");
            b4.setFont(font2);
            b4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.operation.equals("")) {
                        Panel.this.operation = b4.getText();
                        JButton var10000 = Panel.this.text;
                        String var10001 = Panel.this.text.getText();
                        var10000.setText(var10001 + Panel.this.operation);
                    } else if (Panel.this.secondNumber != 0) {
                        Panel.this.firstNumber = Panel.this.Calculate(Panel.this.firstNumber, Panel.this.secondNumber, Panel.this.operation);
                        Panel.this.operation = b4.getText();
                        Panel.this.secondNumber = 0;
                        Panel.this.text.setText(Panel.this.firstNumber + Panel.this.operation);
                    } else {
                        Panel.this.operation = b4.getText();
                        Panel.this.text.setText(Panel.this.firstNumber + Panel.this.operation);
                    }

                }
            });
            Panel.add(b4);
            final JButton b5 = new JButton("4");
            b5.setFont(font2);
            b5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.firstNumber == 0 && Panel.this.secondNumber == 0 && Panel.this.operation.equals("")) {
                        Panel.this.text.setText(" ");
                    }

                    JButton var10000 = Panel.this.text;
                    String var10001 = Panel.this.text.getText();
                    var10000.setText(var10001 + b5.getText());
                    Panel var2;
                    if (Panel.this.operation.equals("")) {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.firstNumber);
                        var2.firstNumber = Integer.valueOf(var10001 + b5.getText());
                    } else {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.secondNumber);
                        var2.secondNumber = Integer.valueOf(var10001 + b5.getText());
                    }

                }
            });
            Panel.add(b5);
            final JButton b6 = new JButton("5");
            b6.setFont(font2);
            b6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.firstNumber == 0 && Panel.this.secondNumber == 0 && Panel.this.operation.equals("")) {
                        Panel.this.text.setText(" ");
                    }

                    JButton var10000 = Panel.this.text;
                    String var10001 = Panel.this.text.getText();
                    var10000.setText(var10001 + b6.getText());
                    Panel var2;
                    if (Panel.this.operation.equals("")) {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.firstNumber);
                        var2.firstNumber = Integer.valueOf(var10001 + b6.getText());
                    } else {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.secondNumber);
                        var2.secondNumber = Integer.valueOf(var10001 + b6.getText());
                    }

                }
            });
            Panel.add(b6);
            final JButton b7 = new JButton("6");
            b7.setFont(font2);
            b7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.firstNumber == 0 && Panel.this.secondNumber == 0 && Panel.this.operation.equals("")) {
                        Panel.this.text.setText(" ");
                    }

                    JButton var10000 = Panel.this.text;
                    String var10001 = Panel.this.text.getText();
                    var10000.setText(var10001 + b7.getText());
                    Panel var2;
                    if (Panel.this.operation.equals("")) {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.firstNumber);
                        var2.firstNumber = Integer.valueOf(var10001 + b7.getText());
                    } else {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.secondNumber);
                        var2.secondNumber = Integer.valueOf(var10001 + b7.getText());
                    }

                }
            });
            Panel.add(b7);
            final JButton b8 = new JButton("*");
            b8.setFont(font2);
            b8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.operation.equals("")) {
                        Panel.this.operation = b8.getText();
                        JButton var10000 = Panel.this.text;
                        String var10001 = Panel.this.text.getText();
                        var10000.setText(var10001 + Panel.this.operation);
                    } else if (Panel.this.secondNumber != 0) {
                        Panel.this.firstNumber = Panel.this.Calculate(Panel.this.firstNumber, Panel.this.secondNumber, Panel.this.operation);
                        Panel.this.operation = b8.getText();
                        Panel.this.secondNumber = 0;
                        Panel.this.text.setText(Panel.this.firstNumber + Panel.this.operation);
                    } else {
                        Panel.this.operation = b8.getText();
                        Panel.this.text.setText(Panel.this.firstNumber + Panel.this.operation);
                    }

                }
            });
            Panel.add(b8);
            final JButton b9 = new JButton("1");
            b9.setFont(font2);
            b9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.firstNumber == 0 && Panel.this.secondNumber == 0 && Panel.this.operation.equals("")) {
                        Panel.this.text.setText(" ");
                    }

                    JButton var10000 = Panel.this.text;
                    String var10001 = Panel.this.text.getText();
                    var10000.setText(var10001 + b9.getText());
                    Panel var2;
                    if (Panel.this.operation.equals("")) {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.firstNumber);
                        var2.firstNumber = Integer.valueOf(var10001 + b9.getText());
                    } else {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.secondNumber);
                        var2.secondNumber = Integer.valueOf(var10001 + b9.getText());
                    }

                }
            });
            Panel.add(b9);
            final JButton b10 = new JButton("2");
            b10.setFont(font2);
            b10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.firstNumber == 0 && Panel.this.secondNumber == 0 && Panel.this.operation.equals("")) {
                        Panel.this.text.setText(" ");
                    }

                    JButton var10000 = Panel.this.text;
                    String var10001 = Panel.this.text.getText();
                    var10000.setText(var10001 + b10.getText());
                    Panel var2;
                    if (Panel.this.operation.equals("")) {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.firstNumber);
                        var2.firstNumber = Integer.valueOf(var10001 + b10.getText());
                    } else {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.secondNumber);
                        var2.secondNumber = Integer.valueOf(var10001 + b10.getText());
                    }

                }
            });
            Panel.add(b10);
            final JButton b11 = new JButton("3");
            b11.setFont(font2);
            b11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.firstNumber == 0 && Panel.this.secondNumber == 0 && Panel.this.operation.equals("")) {
                        Panel.this.text.setText(" ");
                    }

                    JButton var10000 = Panel.this.text;
                    String var10001 = Panel.this.text.getText();
                    var10000.setText(var10001 + b11.getText());
                    Panel var2;
                    if (Panel.this.operation.equals("")) {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.firstNumber);
                        var2.firstNumber = Integer.valueOf(var10001 + b11.getText());
                    } else {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.secondNumber);
                        var2.secondNumber = Integer.valueOf(var10001 + b11.getText());
                    }

                }
            });
            Panel.add(b11);
            final JButton b12 = new JButton("-");
            b12.setFont(font2);
            b12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.operation.equals("")) {
                        Panel.this.operation = b12.getText();
                        JButton var10000 = Panel.this.text;
                        String var10001 = Panel.this.text.getText();
                        var10000.setText(var10001 + Panel.this.operation);
                    } else if (Panel.this.secondNumber != 0) {
                        Panel.this.firstNumber = Panel.this.Calculate(Panel.this.firstNumber, Panel.this.secondNumber, Panel.this.operation);
                        Panel.this.operation = b12.getText();
                        Panel.this.secondNumber = 0;
                        Panel.this.text.setText(Panel.this.firstNumber + Panel.this.operation);
                    } else {
                        Panel.this.operation = b12.getText();
                        Panel.this.text.setText(Panel.this.firstNumber + Panel.this.operation);
                    }

                }
            });
            Panel.add(b12);
            JButton b13 = new JButton("c");
            b13.setFont(font2);
            b13.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Panel.this.firstNumber = 0;
                    Panel.this.secondNumber = 0;
                    Panel.this.operation = "";
                    Panel.this.text.setText(" ");
                }
            });
            Panel.add(b13);
            final JButton b14 = new JButton("0");
            b14.setFont(font2);
            b14.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.firstNumber == 0 && Panel.this.secondNumber == 0 && Panel.this.operation.equals("")) {
                        Panel.this.text.setText(" ");
                    }

                    JButton var10000 = Panel.this.text;
                    String var10001 = Panel.this.text.getText();
                    var10000.setText(var10001 + b14.getText());
                    Panel var2;
                    if (Panel.this.operation.equals("")) {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.firstNumber);
                        var2.firstNumber = Integer.valueOf(var10001 + b14.getText());
                    } else {
                        var2 = Panel.this;
                        var10001 = Integer.toString(Panel.this.secondNumber);
                        var2.secondNumber = Integer.valueOf(var10001 + b14.getText());
                    }

                    if (Panel.this.secondNumber == 0) {
                        if (Panel.this.operation != "+" && Panel.this.operation != "-") {
                            if (Panel.this.operation == "*") {
                                Panel.this.text.setText("0");
                                Panel.this.firstNumber = 0;
                                Panel.this.secondNumber = 0;
                                Panel.this.operation = "";
                            } else if (Panel.this.operation == "/") {
                                Panel.this.text.setText("error");
                                Panel.this.firstNumber = 0;
                                Panel.this.secondNumber = 0;
                                Panel.this.operation = "";
                            }
                        } else {
                            Panel.this.text.setText(Integer.toString(Panel.this.firstNumber));
                        }
                    }

                }
            });
            Panel.add(b14);
            JButton b15 = new JButton("=");
            b15.setFont(font2);
            b15.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.secondNumber == 0) {
                        Panel.this.text.setText(Integer.toString(Panel.this.firstNumber));
                    } else {
                        Panel.this.text.setText(Integer.toString(Panel.this.Calculate(Panel.this.firstNumber, Panel.this.secondNumber, Panel.this.operation)));
                    }

                    Panel.this.firstNumber = 0;
                    Panel.this.secondNumber = 0;
                    Panel.this.operation = "";
                }
            });
            Panel.add(b15);
            final JButton b16 = new JButton("+");
            b16.setFont(font2);
            b16.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Panel.this.operation.equals("")) {
                        Panel.this.operation = b16.getText();
                        JButton var10000 = Panel.this.text;
                        String var10001 = Panel.this.text.getText();
                        var10000.setText(var10001 + Panel.this.operation);
                    } else if (Panel.this.secondNumber != 0) {
                        Panel.this.firstNumber = Panel.this.Calculate(Panel.this.firstNumber, Panel.this.secondNumber, Panel.this.operation);
                        Panel.this.operation = b16.getText();
                        Panel.this.secondNumber = 0;
                        Panel.this.text.setText(Panel.this.firstNumber + Panel.this.operation);
                    } else {
                        Panel.this.operation = b16.getText();
                        Panel.this.text.setText(Panel.this.firstNumber + Panel.this.operation);
                    }

                }
            });
            Panel.add(b16);
            this.add(Panel);
        }

        public int Calculate(int a, int b, String op) {
            if (this.operation.equals("+")) {
                this.res = a + b;
            }

            if (this.operation.equals("-")) {
                this.res = a - b;
            }

            if (this.operation.equals("*")) {
                this.res = a * b;
            }

            if (this.operation.equals("/")) {
                this.res = a / b;
            }

            return this.res;
        }
    }


