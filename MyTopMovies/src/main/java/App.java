import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.plaf.basic.DefaultMenuLayout;

class Frame extends JFrame{
        public static void createGui() throws Exception{
            String path = "src/main/java/MyMovies.txt";
            ArrayList<Movie> MyMovies = Scan.ScanFile(path);

            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            Font font = new Font("Arial", Font.BOLD, 18);
            Font font1 = new Font("Arial", Font.BOLD, 20);
            Font font2 = new Font("Arial", Font.BOLD, 24);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension monitor = toolkit.getScreenSize();

            //////////////////////////  MyTop Frame  /////////////////////////////
            JFrame MyTop = new JFrame("Movie Top");
            int MyTopWidth = 750;
            int MyTopHeight = 600;
            MyTop.setBounds(monitor.width/2-MyTopWidth/2, monitor.height/2-MyTopHeight/2, MyTopWidth, MyTopHeight);

            JPanel MyTopPanel = new JPanel();
            MyTopPanel.setLayout(new BorderLayout());

            JTextArea MyTopTitle = new JTextArea();
            MyTopTitle.setText("Мой топ фильмов\n");
            MyTopTitle.setFont(font2);
            MyTopPanel.add(MyTopTitle, BorderLayout.NORTH);

            JTextArea MyToptextArea = new JTextArea();
            MyToptextArea.setText(Movie.ListToString(MyMovies));
            MyToptextArea.setFont(font1);
            final JScrollPane scrollPane = new JScrollPane(MyToptextArea);
            MyTopPanel.add(scrollPane, BorderLayout.CENTER);

            JPanel MyTopButtons = new JPanel();
            MyTopButtons.setLayout(new FlowLayout());
            JButton add = new JButton("Добавить");
            add.setFont(font);
            MyTopButtons.add(add);
            JButton clear = new JButton("Очистить");
            clear.setFont(font);
            MyTopButtons.add(clear);
            JButton defaultlist = new JButton("Default\nlist");
            defaultlist.setFont(font);
            MyTopButtons.add(defaultlist);
            JButton back = new JButton("Назад");
            back.setFont(font);
            MyTopButtons.add(back);
            MyTopPanel.add(MyTopButtons, BorderLayout.SOUTH);

            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MyTop.setVisible(false);
                }
            });

            defaultlist.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //FileWriter fw = new FileWriter(path);
                        //fw.write("Форма голоса: 10 \n"+"Этот глупый свин не понимает мечту девочки зайки: 10\n" + "Пасажиры: 10\n" + "Воспоминания об убийстве: 10\n" + "Отель гранд будапешт: 10\n"+ "Джокер: 10\n" + "Жмурки: 10\n" + "Тачки (все части): 10\n" + "Зеленая миля: 9\n" + "Подозрительные лица: 9\n" + "Пластиковые воспоминания: 8\n" + "Чудачества любви не помеха: 8\n" + "Сядь за руль моей машины: 8\n" + "Назад в будущее(все части): 8\n" + "Жозе, тигр и рыба: 8\n" + "Таксист: 8\n" + "Брат: 8\n" + "Класс превосходства: 7\n"+ "Драйв: 7\n" + "Американский психопат: 7");
                        //fw.close();
                        Scan.SetDefaultListIntoFile(path);
                        Scan.SetDefaultList(MyMovies, path);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    MyToptextArea.setText(Movie.ListToString(MyMovies));
                }
            });

            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Movie New = new Movie();
                    JFrame AddFrame = new JFrame("Добавить");
                    int AddFrameWidth = 400;
                    int AddFrameHeight = 200;
                    AddFrame.setBounds(monitor.width/2-AddFrameWidth/2, monitor.height/2-AddFrameHeight/2, AddFrameWidth, AddFrameHeight);
                    JPanel AddFramePanel = new JPanel();
                    AddFramePanel.setLayout(new GridLayout(3, 1, 10, 10));

                    JTextArea message = new JTextArea("Введите название:");
                    message.setFont(font);
                    AddFramePanel.add(message);

                    JTextField input = new JTextField("",5);
                    input.setFont(font);
                    AddFramePanel.add(input);
                    input.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            input.setEnabled(false);
                            message.setText("Укажите оценку: ");
                            New.name = input.getText();
                            String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                            JComboBox comboBox = new JComboBox(numbers);
                            comboBox.setFont(font);
                            AddFramePanel.add(comboBox);
                            comboBox.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    New.rate = Integer.parseInt((String)comboBox.getSelectedItem());
                                    MyMovies.add(New);
                                    try {
                                        FileWriter fw = new FileWriter(path);
                                        fw.write(Movie.ListToStringForFile(MyMovies));
                                        fw.close();
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    MyToptextArea.setText(Movie.ListToString(MyMovies));
                                    AddFrame.setVisible(false);
                                }
                            });
                        }
                    });

                    AddFrame.getContentPane().add(AddFramePanel);
                    AddFrame.setVisible(true);
                }
            });

            clear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame ClearFrame = new JFrame("Очистить");
                    int ClearFrameWidth = 200;
                    int ClearFrameHeight = 90;
                    ClearFrame.setBounds(monitor.width/2-ClearFrameWidth/2, monitor.height/2-ClearFrameHeight/2, ClearFrameWidth, ClearFrameHeight);
                    JPanel ClearFramePanel = new JPanel();
                    ClearFramePanel.setLayout(new BorderLayout());

                    JPanel ClearFramePanel2 = new JPanel();
                    ClearFramePanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
                    JButton Yes = new JButton("Да");
                    Yes.setFont(font);
                    JButton No = new JButton("Нет");
                    No.setFont(font);
                    ClearFramePanel2.add(Yes);
                    ClearFramePanel2.add(No);
                    ClearFramePanel.add(ClearFramePanel2, BorderLayout.CENTER);

                    Yes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            MyMovies.clear();
                            try {
                                FileWriter fw = new FileWriter(path);
                                fw.write("");
                                fw.close();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            MyToptextArea.setText(Movie.ListToString(MyMovies));
                            ClearFrame.setVisible(false);
                        }
                    });
                    No.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ClearFrame.setVisible(false);
                        }
                    });
                    ClearFrame.getContentPane().add(ClearFramePanel);
                    ClearFrame.setVisible(true);
                }
            });

            MyTop.getContentPane().add(MyTopPanel);
            //////////////////////////  MyTop Frame  /////////////////////////////

            //////////////////////////  KinoAfisha Frame  /////////////////////////////
            JFrame KinoTopNumber = new JFrame("?");
            int KinoTopNumberWidth = 360;
            int KinoTopNumberHeight = 120;
            KinoTopNumber.setBounds(monitor.width/2-KinoTopNumberWidth/2, monitor.height/2-KinoTopNumberHeight/2, KinoTopNumberWidth, KinoTopNumberHeight);
            JPanel KinoTopNumberPanel = new JPanel();
            KinoTopNumberPanel.setLayout(new GridLayout(2,1,10,10));

            JTextArea KinoTopNumberTitle = new JTextArea();
            KinoTopNumberTitle.setText("Укажите количество фильмов(0-100):");
            KinoTopNumberTitle.setFont(font);
            KinoTopNumberTitle.setEnabled(false);
            KinoTopNumberPanel.add(KinoTopNumberTitle);

            JTextField NumberInput = new JTextField("",5);
            NumberInput.setFont(font);
            KinoTopNumberPanel.add(NumberInput);
            NumberInput.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    KinoTopNumber.setVisible(false);
                    JFrame KinoTop = new JFrame("Movie Top");
                    int KinoTopWidth = 750;
                    int KinoTopHeight = 600;
                    KinoTop.setBounds(monitor.width/2-KinoTopWidth/2, monitor.height/2-KinoTopHeight/2, KinoTopWidth, KinoTopHeight);

                    JPanel KinoTopPanel = new JPanel();
                    KinoTopPanel.setLayout(new BorderLayout());

                    JTextArea KinoAfishaTitle = new JTextArea();
                    KinoAfishaTitle.setText("Топ фильмов по версии сайта kinoafisha:\n");
                    KinoAfishaTitle.setFont(font2);
                    KinoTopPanel.add(KinoAfishaTitle, BorderLayout.NORTH);

                    JTextArea KinoAfishatextArea = new JTextArea();
                    try {
                        KinoAfishatextArea.setText(Movie.GetKinoAfishaTop(Integer.parseInt(NumberInput.getText())));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    KinoAfishatextArea.setFont(font1);
                    final JScrollPane KinoAfishascrollPane = new JScrollPane(KinoAfishatextArea);
                    //KinoAfishascrollPane.getViewport().getView().setEnabled(false);// - Set Enabled False, но хуже видно
                    KinoTopPanel.add(KinoAfishascrollPane, BorderLayout.CENTER);

                    JButton KinoAfishaback = new JButton("Назад");
                    KinoAfishaback.setFont(font);
                    KinoTopPanel.add(KinoAfishaback, BorderLayout.SOUTH);
                    KinoTop.setVisible(true);

                    KinoAfishaback.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            KinoTop.setVisible(false);
                        }
                    });

                    KinoTop.getContentPane().add(KinoTopPanel);
                }
            });
            KinoTopNumber.getContentPane().add(KinoTopNumberPanel);

            //////////////////////////  KinoAfisha Frame  /////////////////////////////

            //////////////////////////  MainMenu Frame  /////////////////////////////
            JFrame MainMenu = new JFrame("Welcome!");
            int MainMenuWidth = 350;
            int MainMenuHeight = 400;
            MainMenu.setBounds(monitor.width/2-MainMenuWidth/2, monitor.height/2-MainMenuHeight/2, MainMenuWidth, MainMenuHeight);
            MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel MainMenuPanel = new JPanel();
            MainMenuPanel.setLayout(new GridLayout(3, 1, 20, 20));

            JButton MainTitle = new JButton();
            MainTitle.setText("Выберите функцию: ");
            MainTitle.setFont(font2);
            MainTitle.setEnabled(false);
            MainMenuPanel.add(MainTitle);
            JButton MyTopButton = new JButton("Мой топ");
            MyTopButton.setFont(font1);
            MainMenuPanel.add(MyTopButton);
            JButton AfishaTopButton = new JButton("Топ Киноафиша");
            AfishaTopButton.setFont(font1);
            MainMenuPanel.add(AfishaTopButton);
            MainMenu.getContentPane().add(MainMenuPanel);

            AfishaTopButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    KinoTopNumber.setVisible(true);
                }
            });
            MyTopButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MyTop.setVisible(true);
                }
            });

            MainMenu.getContentPane().add(MainMenuPanel);
            MainMenu.setVisible(true);
            //////////////////////////  MainMenu Frame  /////////////////////////////
        }
}