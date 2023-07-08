package View;

import Controller.BookRoomControl;
import Controller.GuestControl;
import Controller.TypeRoomControl;
import Model.Guest;
import com.raven.form.FormDatPhong;
import com.raven.form.FormDoiMatKhau;
import com.raven.form.FormTTKhach;
import connection.ConnectionProvider;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestHomeForm extends javax.swing.JFrame {
    
    private String username;
    LocalDate endThenFindRoom;
    LocalDate startThenFindRoom;
    boolean checkFindRoom = false;
    Guest g = new Guest();
    public void reload() {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        checkFindRoom = false;
        for (Component component : jRoompanel.getComponents()) {
            if (component instanceof JPanel panel) {
                for (Component component1 : panel.getComponents()) {
                    if (component1 instanceof JPanel panel1) {
                        String typeRoom = null;
                        String statusRoom = null;
                        int check = 0;
                        for (Component component2 : panel1.getComponents()) {
                            if (component2 instanceof JLabel label) {
                                if (label.getText().contains("Phòng")) {
                                    statusRoom = Controller.InforRoom.setStatusRoom(label.getText().substring(6), conn);
                                    typeRoom = Controller.InforRoom.setTypeRoom(label.getText().substring(6), conn);
                                } else if (check == 0) {
                                    label.setText(statusRoom);
                                    check += 1;
                                } else {
                                    label.setText(typeRoom);
                                    switch (typeRoom) {
                                        case "Phòng VIP" ->
                                            label.setForeground(new java.awt.Color(255, 255, 153));
                                        case "Phòng Đôi" ->
                                            label.setForeground(new java.awt.Color(204, 0, 102));
                                        default ->
                                            label.setForeground(new java.awt.Color(102, 102, 102));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        jdateStart.setDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
        jdateEnd.setDate(java.sql.Timestamp.valueOf(LocalDateTime.now().plusDays(1)));
    }
    
    public GuestHomeForm() {
        initComponents();
        jdateStart.setDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
        jdateEnd.setDate(java.sql.Timestamp.valueOf(LocalDateTime.now().plusDays(1)));
        getContentPane().setBackground(new Color(63, 109, 217));
        jTextField1.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextField3.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextField4.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextField2.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextField5.setBackground(new java.awt.Color(0, 0, 0, 1));
        jname.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextField8.setBackground(new java.awt.Color(0, 0, 0, 1));
        setLocationRelativeTo(null);
        setResizable(false);
        reload();
    }
    
    public GuestHomeForm(String username) {
        initComponents();
        this.username = username;
        jdateStart.setDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
        jdateEnd.setDate(java.sql.Timestamp.valueOf(LocalDateTime.now().plusDays(1)));
        getContentPane().setBackground(new Color(63, 109, 217));
        jTextField1.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextField3.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextField4.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextField2.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextField5.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextField8.setBackground(new java.awt.Color(0, 0, 0, 1));
        jname.setBackground(new java.awt.Color(0, 0, 0, 1));
        String[] name = GuestControl.getNameByUsername(username).split(" ");
        jname.setText(name[name.length-1]);
        g = GuestControl.findByUsername(username);
        setLocationRelativeTo(null);
        setResizable(false);
        reload();
    }

//    public void showForm(Component com){
//        body.removeAll();
//        body.add(com);
//        body.revalidate();
//        body.repaint();
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuRoom = new javax.swing.JPopupMenu();
        datphong = new javax.swing.JMenuItem();
        bg = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jname = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        btn_tk = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_changepass = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jRoompanel = new javax.swing.JPanel();
        jPanelTang1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabelP1T1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        JPanelTang2 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel96 = new javax.swing.JPanel();
        jLabel288 = new javax.swing.JLabel();
        jLabel289 = new javax.swing.JLabel();
        jLabel290 = new javax.swing.JLabel();
        jPanel98 = new javax.swing.JPanel();
        jLabel294 = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        jLabel296 = new javax.swing.JLabel();
        jPanel100 = new javax.swing.JPanel();
        jLabel300 = new javax.swing.JLabel();
        jLabel301 = new javax.swing.JLabel();
        jLabel302 = new javax.swing.JLabel();
        jPanel103 = new javax.swing.JPanel();
        jLabel309 = new javax.swing.JLabel();
        jLabel310 = new javax.swing.JLabel();
        jLabel311 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jLabel306 = new javax.swing.JLabel();
        jLabel307 = new javax.swing.JLabel();
        jLabel308 = new javax.swing.JLabel();
        jPanel99 = new javax.swing.JPanel();
        jLabel297 = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        jPanel97 = new javax.swing.JPanel();
        jLabel291 = new javax.swing.JLabel();
        jLabel292 = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        jPanel94 = new javax.swing.JPanel();
        jLabel282 = new javax.swing.JLabel();
        jLabel283 = new javax.swing.JLabel();
        jLabel284 = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        jLabel285 = new javax.swing.JLabel();
        jLabel286 = new javax.swing.JLabel();
        jLabel287 = new javax.swing.JLabel();
        jPanel101 = new javax.swing.JPanel();
        jLabel303 = new javax.swing.JLabel();
        jLabel304 = new javax.swing.JLabel();
        jLabel305 = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        jLabel279 = new javax.swing.JLabel();
        jLabel280 = new javax.swing.JLabel();
        jLabel281 = new javax.swing.JLabel();
        jPanelTang3 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jPanel104 = new javax.swing.JPanel();
        jLabel312 = new javax.swing.JLabel();
        jLabel313 = new javax.swing.JLabel();
        jLabel314 = new javax.swing.JLabel();
        jPanel105 = new javax.swing.JPanel();
        jLabel315 = new javax.swing.JLabel();
        jLabel316 = new javax.swing.JLabel();
        jLabel317 = new javax.swing.JLabel();
        jPanel115 = new javax.swing.JPanel();
        jLabel345 = new javax.swing.JLabel();
        jLabel346 = new javax.swing.JLabel();
        jLabel347 = new javax.swing.JLabel();
        jPanel111 = new javax.swing.JPanel();
        jLabel333 = new javax.swing.JLabel();
        jLabel334 = new javax.swing.JLabel();
        jLabel335 = new javax.swing.JLabel();
        jPanel112 = new javax.swing.JPanel();
        jLabel336 = new javax.swing.JLabel();
        jLabel337 = new javax.swing.JLabel();
        jLabel338 = new javax.swing.JLabel();
        jPanel114 = new javax.swing.JPanel();
        jLabel342 = new javax.swing.JLabel();
        jLabel343 = new javax.swing.JLabel();
        jLabel344 = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        jLabel327 = new javax.swing.JLabel();
        jLabel328 = new javax.swing.JLabel();
        jLabel329 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        jLabel318 = new javax.swing.JLabel();
        jLabel319 = new javax.swing.JLabel();
        jLabel320 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jLabel321 = new javax.swing.JLabel();
        jLabel322 = new javax.swing.JLabel();
        jLabel323 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        jLabel324 = new javax.swing.JLabel();
        jLabel325 = new javax.swing.JLabel();
        jLabel326 = new javax.swing.JLabel();
        jPanel110 = new javax.swing.JPanel();
        jLabel330 = new javax.swing.JLabel();
        jLabel331 = new javax.swing.JLabel();
        jLabel332 = new javax.swing.JLabel();
        jPanel113 = new javax.swing.JPanel();
        jLabel339 = new javax.swing.JLabel();
        jLabel340 = new javax.swing.JLabel();
        jLabel341 = new javax.swing.JLabel();
        jPanel116 = new javax.swing.JPanel();
        jLabel348 = new javax.swing.JLabel();
        jLabel349 = new javax.swing.JLabel();
        jLabel350 = new javax.swing.JLabel();
        jPanel119 = new javax.swing.JPanel();
        jLabel357 = new javax.swing.JLabel();
        jLabel358 = new javax.swing.JLabel();
        jLabel359 = new javax.swing.JLabel();
        jPanel117 = new javax.swing.JPanel();
        jLabel351 = new javax.swing.JLabel();
        jLabel352 = new javax.swing.JLabel();
        jLabel353 = new javax.swing.JLabel();
        jPanel118 = new javax.swing.JPanel();
        jLabel354 = new javax.swing.JLabel();
        jLabel355 = new javax.swing.JLabel();
        jLabel356 = new javax.swing.JLabel();
        jPanelTang4 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jPanel135 = new javax.swing.JPanel();
        jLabel405 = new javax.swing.JLabel();
        jLabel406 = new javax.swing.JLabel();
        jLabel407 = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        jLabel360 = new javax.swing.JLabel();
        jLabel361 = new javax.swing.JLabel();
        jLabel362 = new javax.swing.JLabel();
        jPanel121 = new javax.swing.JPanel();
        jLabel363 = new javax.swing.JLabel();
        jLabel364 = new javax.swing.JLabel();
        jLabel365 = new javax.swing.JLabel();
        jPanel122 = new javax.swing.JPanel();
        jLabel366 = new javax.swing.JLabel();
        jLabel367 = new javax.swing.JLabel();
        jLabel368 = new javax.swing.JLabel();
        jPanel128 = new javax.swing.JPanel();
        jLabel384 = new javax.swing.JLabel();
        jLabel385 = new javax.swing.JLabel();
        jLabel386 = new javax.swing.JLabel();
        jPanel129 = new javax.swing.JPanel();
        jLabel387 = new javax.swing.JLabel();
        jLabel388 = new javax.swing.JLabel();
        jLabel389 = new javax.swing.JLabel();
        jPanel133 = new javax.swing.JPanel();
        jLabel399 = new javax.swing.JLabel();
        jLabel400 = new javax.swing.JLabel();
        jLabel401 = new javax.swing.JLabel();
        jPanel136 = new javax.swing.JPanel();
        jLabel408 = new javax.swing.JLabel();
        jLabel409 = new javax.swing.JLabel();
        jLabel410 = new javax.swing.JLabel();
        jPanel126 = new javax.swing.JPanel();
        jLabel378 = new javax.swing.JLabel();
        jLabel379 = new javax.swing.JLabel();
        jLabel380 = new javax.swing.JLabel();
        jPanel123 = new javax.swing.JPanel();
        jLabel369 = new javax.swing.JLabel();
        jLabel370 = new javax.swing.JLabel();
        jLabel371 = new javax.swing.JLabel();
        jPanel124 = new javax.swing.JPanel();
        jLabel372 = new javax.swing.JLabel();
        jLabel373 = new javax.swing.JLabel();
        jLabel374 = new javax.swing.JLabel();
        jPanel125 = new javax.swing.JPanel();
        jLabel375 = new javax.swing.JLabel();
        jLabel376 = new javax.swing.JLabel();
        jLabel377 = new javax.swing.JLabel();
        jPanel127 = new javax.swing.JPanel();
        jLabel381 = new javax.swing.JLabel();
        jLabel382 = new javax.swing.JLabel();
        jLabel383 = new javax.swing.JLabel();
        jPanel130 = new javax.swing.JPanel();
        jLabel390 = new javax.swing.JLabel();
        jLabel391 = new javax.swing.JLabel();
        jLabel392 = new javax.swing.JLabel();
        jPanel132 = new javax.swing.JPanel();
        jLabel396 = new javax.swing.JLabel();
        jLabel397 = new javax.swing.JLabel();
        jLabel398 = new javax.swing.JLabel();
        jPanel134 = new javax.swing.JPanel();
        jLabel402 = new javax.swing.JLabel();
        jLabel403 = new javax.swing.JLabel();
        jLabel404 = new javax.swing.JLabel();
        jPanel131 = new javax.swing.JPanel();
        jLabel393 = new javax.swing.JLabel();
        jLabel394 = new javax.swing.JLabel();
        jLabel395 = new javax.swing.JLabel();
        jPanelTang5 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jPanel137 = new javax.swing.JPanel();
        jLabel411 = new javax.swing.JLabel();
        jLabel412 = new javax.swing.JLabel();
        jLabel413 = new javax.swing.JLabel();
        jPanel138 = new javax.swing.JPanel();
        jLabel414 = new javax.swing.JLabel();
        jLabel415 = new javax.swing.JLabel();
        jLabel416 = new javax.swing.JLabel();
        jPanel145 = new javax.swing.JPanel();
        jLabel435 = new javax.swing.JLabel();
        jLabel436 = new javax.swing.JLabel();
        jLabel437 = new javax.swing.JLabel();
        jPanel146 = new javax.swing.JPanel();
        jLabel438 = new javax.swing.JLabel();
        jLabel439 = new javax.swing.JLabel();
        jLabel440 = new javax.swing.JLabel();
        jPanel148 = new javax.swing.JPanel();
        jLabel444 = new javax.swing.JLabel();
        jLabel445 = new javax.swing.JLabel();
        jLabel446 = new javax.swing.JLabel();
        jPanel150 = new javax.swing.JPanel();
        jLabel450 = new javax.swing.JLabel();
        jLabel451 = new javax.swing.JLabel();
        jLabel461 = new javax.swing.JLabel();
        jPanel153 = new javax.swing.JPanel();
        jLabel459 = new javax.swing.JLabel();
        jLabel460 = new javax.swing.JLabel();
        jPanel154 = new javax.swing.JPanel();
        jLabel462 = new javax.swing.JLabel();
        jLabel463 = new javax.swing.JLabel();
        jLabel464 = new javax.swing.JLabel();
        jPanel155 = new javax.swing.JPanel();
        jLabel465 = new javax.swing.JLabel();
        jLabel466 = new javax.swing.JLabel();
        jLabel467 = new javax.swing.JLabel();
        jPanel156 = new javax.swing.JPanel();
        jLabel468 = new javax.swing.JLabel();
        jLabel469 = new javax.swing.JLabel();
        jLabel470 = new javax.swing.JLabel();
        jPanel157 = new javax.swing.JPanel();
        jLabel471 = new javax.swing.JLabel();
        jLabel472 = new javax.swing.JLabel();
        jLabel473 = new javax.swing.JLabel();
        jPanel158 = new javax.swing.JPanel();
        jLabel474 = new javax.swing.JLabel();
        jLabel475 = new javax.swing.JLabel();
        jLabel476 = new javax.swing.JLabel();
        jPanel159 = new javax.swing.JPanel();
        jLabel477 = new javax.swing.JLabel();
        jLabel478 = new javax.swing.JLabel();
        jLabel479 = new javax.swing.JLabel();
        jPanel160 = new javax.swing.JPanel();
        jLabel480 = new javax.swing.JLabel();
        jLabel481 = new javax.swing.JLabel();
        jLabel482 = new javax.swing.JLabel();
        jPanel161 = new javax.swing.JPanel();
        jLabel483 = new javax.swing.JLabel();
        jLabel484 = new javax.swing.JLabel();
        jLabel485 = new javax.swing.JLabel();
        jPanel162 = new javax.swing.JPanel();
        jLabel486 = new javax.swing.JLabel();
        jLabel487 = new javax.swing.JLabel();
        jLabel488 = new javax.swing.JLabel();
        jPanel163 = new javax.swing.JPanel();
        jLabel489 = new javax.swing.JLabel();
        jLabel490 = new javax.swing.JLabel();
        jLabel491 = new javax.swing.JLabel();
        jPanel164 = new javax.swing.JPanel();
        jLabel492 = new javax.swing.JLabel();
        jLabel493 = new javax.swing.JLabel();
        jLabel494 = new javax.swing.JLabel();
        jPanel165 = new javax.swing.JPanel();
        jLabel495 = new javax.swing.JLabel();
        jLabel496 = new javax.swing.JLabel();
        jLabel497 = new javax.swing.JLabel();
        jPanel166 = new javax.swing.JPanel();
        jLabel498 = new javax.swing.JLabel();
        jLabel499 = new javax.swing.JLabel();
        jLabel500 = new javax.swing.JLabel();
        jPanel167 = new javax.swing.JPanel();
        jLabel501 = new javax.swing.JLabel();
        jLabel502 = new javax.swing.JLabel();
        jLabel503 = new javax.swing.JLabel();
        jPanel168 = new javax.swing.JPanel();
        jLabel504 = new javax.swing.JLabel();
        jLabel505 = new javax.swing.JLabel();
        jLabel506 = new javax.swing.JLabel();
        jPanel169 = new javax.swing.JPanel();
        jLabel507 = new javax.swing.JLabel();
        jLabel508 = new javax.swing.JLabel();
        jLabel509 = new javax.swing.JLabel();
        jLabel452 = new javax.swing.JLabel();
        jPanel143 = new javax.swing.JPanel();
        jLabel429 = new javax.swing.JLabel();
        jLabel430 = new javax.swing.JLabel();
        jLabel431 = new javax.swing.JLabel();
        jPanel140 = new javax.swing.JPanel();
        jLabel420 = new javax.swing.JLabel();
        jLabel421 = new javax.swing.JLabel();
        jPanel141 = new javax.swing.JPanel();
        jLabel423 = new javax.swing.JLabel();
        jLabel424 = new javax.swing.JLabel();
        jLabel425 = new javax.swing.JLabel();
        jPanel142 = new javax.swing.JPanel();
        jLabel426 = new javax.swing.JLabel();
        jLabel427 = new javax.swing.JLabel();
        jLabel428 = new javax.swing.JLabel();
        jLabel443 = new javax.swing.JLabel();
        jPanel144 = new javax.swing.JPanel();
        jLabel432 = new javax.swing.JLabel();
        jLabel433 = new javax.swing.JLabel();
        jLabel434 = new javax.swing.JLabel();
        jPanel147 = new javax.swing.JPanel();
        jLabel441 = new javax.swing.JLabel();
        jLabel442 = new javax.swing.JLabel();
        jLabel422 = new javax.swing.JLabel();
        jPanel149 = new javax.swing.JPanel();
        jLabel447 = new javax.swing.JLabel();
        jLabel448 = new javax.swing.JLabel();
        jLabel449 = new javax.swing.JLabel();
        jPanel151 = new javax.swing.JPanel();
        jLabel453 = new javax.swing.JLabel();
        jLabel454 = new javax.swing.JLabel();
        jLabel455 = new javax.swing.JLabel();
        jPanel152 = new javax.swing.JPanel();
        jLabel456 = new javax.swing.JLabel();
        jLabel457 = new javax.swing.JLabel();
        jLabel458 = new javax.swing.JLabel();
        jRoomTypeCombobox = new javax.swing.JComboBox<>();
        jButtonFindRoom = new javax.swing.JButton();
        jdateStart = new com.toedter.calendar.JDateChooser();
        jdateEnd = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        reload = new javax.swing.JButton();

        datphong.setText("Đặt Phòng");
        datphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datphongActionPerformed(evt);
            }
        });
        jPopupMenuRoom.add(datphong);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(204, 204, 255));
        bg.setPreferredSize(new java.awt.Dimension(1200, 700));

        sidepane.setBackground(new java.awt.Color(54, 33, 69));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        sidepane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 200, 20));

        jLabel11.setFont(new java.awt.Font("Algerian", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Hotel System");
        sidepane.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, -1));

        jname.setEditable(false);
        jname.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jname.setForeground(new java.awt.Color(223, 103, 140));
        jname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jname.setBorder(null);
        sidepane.add(jname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 200, 50));

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(223, 103, 140));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("Xin Chào");
        jTextField8.setBorder(null);
        sidepane.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 200, 50));

        btn_tk.setBackground(new java.awt.Color(85, 55, 118));
        btn_tk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tkMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_tkMousePressed(evt);
            }
        });

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/thongke.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Tài khoản");

        javax.swing.GroupLayout btn_tkLayout = new javax.swing.GroupLayout(btn_tk);
        btn_tk.setLayout(btn_tkLayout);
        btn_tkLayout.setHorizontalGroup(
            btn_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_tkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn_tkLayout.setVerticalGroup(
            btn_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_tkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidepane.add(btn_tk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, 40));

        btn_changepass.setBackground(new java.awt.Color(85, 55, 118));
        btn_changepass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_changepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_changepassMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_changepassMousePressed(evt);
            }
        });

        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/thongke.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Đổi mật khẩu");

        javax.swing.GroupLayout btn_changepassLayout = new javax.swing.GroupLayout(btn_changepass);
        btn_changepass.setLayout(btn_changepassLayout);
        btn_changepassLayout.setHorizontalGroup(
            btn_changepassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_changepassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn_changepassLayout.setVerticalGroup(
            btn_changepassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_changepassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_changepassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidepane.add(btn_changepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, 40));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(940, 700));

        jRoompanel.setPreferredSize(new java.awt.Dimension(900, 3000));
        jRoompanel.setLayout(new java.awt.GridLayout(5, 0, 0, 5));

        jPanelTang1.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTang1.setPreferredSize(new java.awt.Dimension(900, 200));
        jPanelTang1.setLayout(new java.awt.GridLayout(5, 6, 2, 2));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("TẦNG 1");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );

        jPanelTang1.add(jPanel3);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPopupMenu1(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });

        jLabelP1T1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelP1T1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelP1T1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelP1T1.setText("Phòng 101H1");
        jLabelP1T1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelP1T1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel74.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 153));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelP1T1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelP1T1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel74)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel2);

        jPanel17.setBackground(new java.awt.Color(153, 204, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(102, 102, 102));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Phòng 102H1");
        jLabel61.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel61.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel62.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(102, 102, 102));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel63.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 153));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel63)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel17);

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Phòng 103H1");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 153));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Phòng 104H1");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel29.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addGap(12, 12, 12)
                .addComponent(jLabel30)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Phòng 105H1");
        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel75.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(102, 102, 102));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel75)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Phòng 106H1");
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 0, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(153, 204, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Phòng 107H1");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 153));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel9);

        jPanel13.setBackground(new java.awt.Color(153, 204, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Phòng 108H1");
        jLabel49.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel49.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel50.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(102, 102, 102));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel76.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 153));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel76)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(153, 204, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(102, 102, 102));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Phòng 109H1");
        jLabel52.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel52.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel53.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel54.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 153));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel53)
                .addGap(12, 12, 12)
                .addComponent(jLabel54)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(153, 204, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Phòng 110H1");
        jLabel55.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel55.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel56.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(102, 102, 102));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel57.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(102, 102, 102));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel56)
                .addGap(12, 12, 12)
                .addComponent(jLabel57)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel15);

        jPanel18.setBackground(new java.awt.Color(153, 204, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(102, 102, 102));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Phòng 111H1");
        jLabel64.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel64.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel65.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(102, 102, 102));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel66.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(102, 102, 102));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel65)
                .addGap(12, 12, 12)
                .addComponent(jLabel66)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(153, 204, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(102, 102, 102));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Phòng 112H1");
        jLabel67.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel67.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel68.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(102, 102, 102));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel69.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(204, 0, 102));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel68)
                .addGap(12, 12, 12)
                .addComponent(jLabel69)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel19);

        jPanel16.setBackground(new java.awt.Color(153, 204, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(102, 102, 102));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Phòng 113H1");
        jLabel58.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel58.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel59.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(102, 102, 102));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel77.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 102, 102));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel77)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel16);

        jPanel20.setBackground(new java.awt.Color(153, 204, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(102, 102, 102));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Phòng 114H1");
        jLabel70.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel70.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel71.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(102, 102, 102));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel60.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(204, 0, 102));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel60)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanelTang1.add(jPanel20);

        jRoompanel.add(jPanelTang1);

        JPanelTang2.setBackground(new java.awt.Color(255, 204, 204));
        JPanelTang2.setPreferredSize(new java.awt.Dimension(940, 142));
        JPanelTang2.setLayout(new java.awt.GridLayout(5, 5, 2, 2));

        jPanel21.setBackground(new java.awt.Color(255, 51, 51));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("TẦNG 2");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );

        JPanelTang2.add(jPanel21);

        jPanel11.setBackground(new java.awt.Color(153, 204, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Phòng 101H2");
        jLabel43.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel43.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel45.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(204, 0, 102));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel45)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(153, 204, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Phòng 102H2");
        jLabel46.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel46.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel47.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 153));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel47)
                .addGap(12, 12, 12)
                .addComponent(jLabel48)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel12);

        jPanel10.setBackground(new java.awt.Color(153, 204, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Phòng 103H2");
        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel41.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41)
                .addGap(12, 12, 12)
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel10);

        jPanel96.setBackground(new java.awt.Color(153, 204, 255));
        jPanel96.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel96.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel96MouseClicked(evt);
            }
        });

        jLabel288.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel288.setForeground(new java.awt.Color(102, 102, 102));
        jLabel288.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel288.setText("Phòng 104H2");
        jLabel288.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel288.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel289.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel289.setForeground(new java.awt.Color(102, 102, 102));
        jLabel289.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel290.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel290.setForeground(new java.awt.Color(102, 102, 102));
        jLabel290.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel288, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel289, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel290, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel288)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel289)
                .addGap(12, 12, 12)
                .addComponent(jLabel290)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel96);

        jPanel98.setBackground(new java.awt.Color(153, 204, 255));
        jPanel98.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel98MouseClicked(evt);
            }
        });

        jLabel294.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel294.setForeground(new java.awt.Color(102, 102, 102));
        jLabel294.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel294.setText("Phòng 105H2");
        jLabel294.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel294.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel295.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel295.setForeground(new java.awt.Color(102, 102, 102));
        jLabel295.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel296.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel296.setForeground(new java.awt.Color(204, 0, 102));
        jLabel296.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel294, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel295, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel296, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel294)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel295)
                .addGap(12, 12, 12)
                .addComponent(jLabel296)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel98);

        jPanel100.setBackground(new java.awt.Color(153, 204, 255));
        jPanel100.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel100MouseClicked(evt);
            }
        });

        jLabel300.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel300.setForeground(new java.awt.Color(102, 102, 102));
        jLabel300.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel300.setText("Phòng 106H2");
        jLabel300.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel300.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel301.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel301.setForeground(new java.awt.Color(102, 102, 102));
        jLabel301.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel302.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel302.setForeground(new java.awt.Color(255, 255, 153));
        jLabel302.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel300, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel301, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel302, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel300)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel301)
                .addGap(12, 12, 12)
                .addComponent(jLabel302)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel100);

        jPanel103.setBackground(new java.awt.Color(153, 204, 255));
        jPanel103.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel103MouseClicked(evt);
            }
        });

        jLabel309.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel309.setForeground(new java.awt.Color(102, 102, 102));
        jLabel309.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel309.setText("Phòng 107H2");
        jLabel309.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel309.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel310.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel310.setForeground(new java.awt.Color(102, 102, 102));
        jLabel310.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel311.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel311.setForeground(new java.awt.Color(102, 102, 102));
        jLabel311.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel309, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel310, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel311, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel309)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel310)
                .addGap(12, 12, 12)
                .addComponent(jLabel311)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel103);

        jPanel102.setBackground(new java.awt.Color(153, 204, 255));
        jPanel102.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel102MouseClicked(evt);
            }
        });

        jLabel306.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel306.setForeground(new java.awt.Color(102, 102, 102));
        jLabel306.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel306.setText("Phòng 108H2");
        jLabel306.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel306.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel307.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel307.setForeground(new java.awt.Color(102, 102, 102));
        jLabel307.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel308.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel308.setForeground(new java.awt.Color(204, 0, 102));
        jLabel308.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel306, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel307, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel102Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel308, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel306)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel307)
                .addGap(12, 12, 12)
                .addComponent(jLabel308)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel102);

        jPanel99.setBackground(new java.awt.Color(153, 204, 255));
        jPanel99.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel99MouseClicked(evt);
            }
        });

        jLabel297.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel297.setForeground(new java.awt.Color(102, 102, 102));
        jLabel297.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel297.setText("Phòng 109H2");
        jLabel297.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel297.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel298.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel298.setForeground(new java.awt.Color(102, 102, 102));
        jLabel298.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel299.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel299.setForeground(new java.awt.Color(255, 255, 153));
        jLabel299.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel297, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel298, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel299, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel297)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel298)
                .addGap(12, 12, 12)
                .addComponent(jLabel299)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel99);

        jPanel97.setBackground(new java.awt.Color(153, 204, 255));
        jPanel97.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel97MouseClicked(evt);
            }
        });

        jLabel291.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel291.setForeground(new java.awt.Color(102, 102, 102));
        jLabel291.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel291.setText("Phòng 110H2");
        jLabel291.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel291.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel292.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel292.setForeground(new java.awt.Color(102, 102, 102));
        jLabel292.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel293.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel293.setForeground(new java.awt.Color(204, 0, 102));
        jLabel293.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel291, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel292, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel293, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel291)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel292)
                .addGap(12, 12, 12)
                .addComponent(jLabel293)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel97);

        jPanel94.setBackground(new java.awt.Color(153, 204, 255));
        jPanel94.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel94MouseClicked(evt);
            }
        });

        jLabel282.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel282.setForeground(new java.awt.Color(102, 102, 102));
        jLabel282.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel282.setText("Phòng 111H2");
        jLabel282.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel282.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel283.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel283.setForeground(new java.awt.Color(102, 102, 102));
        jLabel283.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel284.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel284.setForeground(new java.awt.Color(204, 0, 102));
        jLabel284.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel282, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel283, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel284, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel282)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel283)
                .addGap(12, 12, 12)
                .addComponent(jLabel284)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel94);

        jPanel95.setBackground(new java.awt.Color(153, 204, 255));
        jPanel95.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel95MouseClicked(evt);
            }
        });

        jLabel285.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel285.setForeground(new java.awt.Color(102, 102, 102));
        jLabel285.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel285.setText("Phòng 112H2");
        jLabel285.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel285.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel286.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel286.setForeground(new java.awt.Color(102, 102, 102));
        jLabel286.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel287.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel287.setForeground(new java.awt.Color(102, 102, 102));
        jLabel287.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel285, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel286, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel287, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel285)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel286)
                .addGap(12, 12, 12)
                .addComponent(jLabel287)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel95);

        jPanel101.setBackground(new java.awt.Color(153, 204, 255));
        jPanel101.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel101MouseClicked(evt);
            }
        });

        jLabel303.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel303.setForeground(new java.awt.Color(102, 102, 102));
        jLabel303.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel303.setText("Phòng 113H2");
        jLabel303.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel303.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel304.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel304.setForeground(new java.awt.Color(102, 102, 102));
        jLabel304.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel305.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel305.setForeground(new java.awt.Color(102, 102, 102));
        jLabel305.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel101Layout = new javax.swing.GroupLayout(jPanel101);
        jPanel101.setLayout(jPanel101Layout);
        jPanel101Layout.setHorizontalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel303, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel304, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel305, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel101Layout.setVerticalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel101Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel303)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel304)
                .addGap(12, 12, 12)
                .addComponent(jLabel305)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel101);

        jPanel93.setBackground(new java.awt.Color(153, 204, 255));
        jPanel93.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel93MouseClicked(evt);
            }
        });

        jLabel279.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel279.setForeground(new java.awt.Color(102, 102, 102));
        jLabel279.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel279.setText("Phòng 114H2");
        jLabel279.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel279.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel280.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel280.setForeground(new java.awt.Color(102, 102, 102));
        jLabel280.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel281.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel281.setForeground(new java.awt.Color(255, 255, 153));
        jLabel281.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel279, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel280, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel281, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel279)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel280)
                .addGap(12, 12, 12)
                .addComponent(jLabel281)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        JPanelTang2.add(jPanel93);

        jRoompanel.add(JPanelTang2);

        jPanelTang3.setBackground(new java.awt.Color(204, 204, 255));
        jPanelTang3.setPreferredSize(new java.awt.Dimension(940, 142));
        jPanelTang3.setLayout(new java.awt.GridLayout(5, 5, 2, 2));

        jPanel22.setBackground(new java.awt.Color(255, 51, 51));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("TẦNG 3");
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );

        jPanelTang3.add(jPanel22);

        jPanel104.setBackground(new java.awt.Color(153, 204, 255));
        jPanel104.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel104MouseClicked(evt);
            }
        });

        jLabel312.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel312.setForeground(new java.awt.Color(102, 102, 102));
        jLabel312.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel312.setText("Phòng 101H3");
        jLabel312.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel312.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel313.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel313.setForeground(new java.awt.Color(102, 102, 102));
        jLabel313.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel314.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel314.setForeground(new java.awt.Color(102, 102, 102));
        jLabel314.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel312, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel313, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel314, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel312)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel313)
                .addGap(12, 12, 12)
                .addComponent(jLabel314)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel104);

        jPanel105.setBackground(new java.awt.Color(153, 204, 255));
        jPanel105.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel105MouseClicked(evt);
            }
        });

        jLabel315.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel315.setForeground(new java.awt.Color(102, 102, 102));
        jLabel315.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel315.setText("Phòng 102H3");
        jLabel315.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel315.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel316.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel316.setForeground(new java.awt.Color(102, 102, 102));
        jLabel316.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel317.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel317.setForeground(new java.awt.Color(204, 0, 102));
        jLabel317.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel315, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel316, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel317, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel315)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel316)
                .addGap(12, 12, 12)
                .addComponent(jLabel317)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel105);

        jPanel115.setBackground(new java.awt.Color(153, 204, 255));
        jPanel115.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel115MouseClicked(evt);
            }
        });

        jLabel345.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel345.setForeground(new java.awt.Color(102, 102, 102));
        jLabel345.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel345.setText("Phòng 103H3");
        jLabel345.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel345.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel346.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel346.setForeground(new java.awt.Color(102, 102, 102));
        jLabel346.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel347.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel347.setForeground(new java.awt.Color(255, 255, 153));
        jLabel347.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel115Layout = new javax.swing.GroupLayout(jPanel115);
        jPanel115.setLayout(jPanel115Layout);
        jPanel115Layout.setHorizontalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel345, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel346, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel347, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel115Layout.setVerticalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel115Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel345)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel346)
                .addGap(12, 12, 12)
                .addComponent(jLabel347)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel115);

        jPanel111.setBackground(new java.awt.Color(153, 204, 255));
        jPanel111.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel111MouseClicked(evt);
            }
        });

        jLabel333.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel333.setForeground(new java.awt.Color(102, 102, 102));
        jLabel333.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel333.setText("Phòng 104H3");
        jLabel333.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel333.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel334.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel334.setForeground(new java.awt.Color(102, 102, 102));
        jLabel334.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel335.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel335.setForeground(new java.awt.Color(255, 255, 153));
        jLabel335.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel111Layout = new javax.swing.GroupLayout(jPanel111);
        jPanel111.setLayout(jPanel111Layout);
        jPanel111Layout.setHorizontalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel333, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel334, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel335, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel111Layout.setVerticalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel333)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel334)
                .addGap(12, 12, 12)
                .addComponent(jLabel335)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel111);

        jPanel112.setBackground(new java.awt.Color(153, 204, 255));
        jPanel112.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel112MouseClicked(evt);
            }
        });

        jLabel336.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel336.setForeground(new java.awt.Color(102, 102, 102));
        jLabel336.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel336.setText("Phòng 105H3");
        jLabel336.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel336.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel337.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel337.setForeground(new java.awt.Color(102, 102, 102));
        jLabel337.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel338.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel338.setForeground(new java.awt.Color(102, 102, 102));
        jLabel338.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel336, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel337, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel336)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel337)
                .addGap(12, 12, 12)
                .addComponent(jLabel338)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel112);

        jPanel114.setBackground(new java.awt.Color(153, 204, 255));
        jPanel114.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel114MouseClicked(evt);
            }
        });

        jLabel342.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel342.setForeground(new java.awt.Color(102, 102, 102));
        jLabel342.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel342.setText("Phòng 106H3");
        jLabel342.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel342.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel343.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel343.setForeground(new java.awt.Color(102, 102, 102));
        jLabel343.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel344.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel344.setForeground(new java.awt.Color(204, 0, 102));
        jLabel344.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel114Layout = new javax.swing.GroupLayout(jPanel114);
        jPanel114.setLayout(jPanel114Layout);
        jPanel114Layout.setHorizontalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel342, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel343, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel344, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel114Layout.setVerticalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel342)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel343)
                .addGap(12, 12, 12)
                .addComponent(jLabel344)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel114);

        jPanel109.setBackground(new java.awt.Color(153, 204, 255));
        jPanel109.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel109MouseClicked(evt);
            }
        });

        jLabel327.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel327.setForeground(new java.awt.Color(102, 102, 102));
        jLabel327.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel327.setText("Phòng 107H3");
        jLabel327.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel327.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel328.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel328.setForeground(new java.awt.Color(102, 102, 102));
        jLabel328.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel329.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel329.setForeground(new java.awt.Color(204, 0, 102));
        jLabel329.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel327, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel328, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel329, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel327)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel328)
                .addGap(12, 12, 12)
                .addComponent(jLabel329)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel109);

        jPanel106.setBackground(new java.awt.Color(153, 204, 255));
        jPanel106.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel106MouseClicked(evt);
            }
        });

        jLabel318.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel318.setForeground(new java.awt.Color(102, 102, 102));
        jLabel318.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel318.setText("Phòng 108H3");
        jLabel318.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel318.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel319.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel319.setForeground(new java.awt.Color(102, 102, 102));
        jLabel319.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel320.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel320.setForeground(new java.awt.Color(255, 255, 153));
        jLabel320.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel107.setBackground(new java.awt.Color(153, 204, 255));
        jPanel107.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel321.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel321.setForeground(new java.awt.Color(102, 102, 102));
        jLabel321.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel321.setText("Phòng 101H1");
        jLabel321.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel321.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel322.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel322.setForeground(new java.awt.Color(102, 102, 102));
        jLabel322.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel322.setText("Đang trống");

        jLabel323.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel323.setForeground(new java.awt.Color(102, 102, 102));
        jLabel323.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel323.setText("Phòng Đơn");

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel321, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel322, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel323, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel321)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel322)
                .addGap(12, 12, 12)
                .addComponent(jLabel323)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel108.setBackground(new java.awt.Color(153, 204, 255));
        jPanel108.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel324.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel324.setForeground(new java.awt.Color(102, 102, 102));
        jLabel324.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel324.setText("Phòng 102H1");
        jLabel324.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel324.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel325.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel325.setForeground(new java.awt.Color(102, 102, 102));
        jLabel325.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel325.setText("Đang trống");

        jLabel326.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel326.setForeground(new java.awt.Color(204, 0, 102));
        jLabel326.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel326.setText("Phòng Đôi");

        javax.swing.GroupLayout jPanel108Layout = new javax.swing.GroupLayout(jPanel108);
        jPanel108.setLayout(jPanel108Layout);
        jPanel108Layout.setHorizontalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel324, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel325, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel326, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel108Layout.setVerticalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel108Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel324)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel325)
                .addGap(12, 12, 12)
                .addComponent(jLabel326)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel318, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel319, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel320, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel318)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel319)
                .addGap(12, 12, 12)
                .addComponent(jLabel320)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel106);

        jPanel110.setBackground(new java.awt.Color(153, 204, 255));
        jPanel110.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel110MouseClicked(evt);
            }
        });

        jLabel330.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel330.setForeground(new java.awt.Color(102, 102, 102));
        jLabel330.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel330.setText("Phòng 109H3");
        jLabel330.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel330.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel331.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel331.setForeground(new java.awt.Color(102, 102, 102));
        jLabel331.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel332.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel332.setForeground(new java.awt.Color(102, 102, 102));
        jLabel332.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel110Layout = new javax.swing.GroupLayout(jPanel110);
        jPanel110.setLayout(jPanel110Layout);
        jPanel110Layout.setHorizontalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel330, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel331, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel332, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel110Layout.setVerticalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel330)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel331)
                .addGap(12, 12, 12)
                .addComponent(jLabel332)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel110);

        jPanel113.setBackground(new java.awt.Color(153, 204, 255));
        jPanel113.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel113.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel113MouseClicked(evt);
            }
        });

        jLabel339.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel339.setForeground(new java.awt.Color(102, 102, 102));
        jLabel339.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel339.setText("Phòng 110H3");
        jLabel339.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel339.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel340.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel340.setForeground(new java.awt.Color(102, 102, 102));
        jLabel340.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel341.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel341.setForeground(new java.awt.Color(204, 0, 102));
        jLabel341.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel113Layout = new javax.swing.GroupLayout(jPanel113);
        jPanel113.setLayout(jPanel113Layout);
        jPanel113Layout.setHorizontalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel339, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel340, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel341, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel113Layout.setVerticalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel339)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel340)
                .addGap(12, 12, 12)
                .addComponent(jLabel341)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel113);

        jPanel116.setBackground(new java.awt.Color(153, 204, 255));
        jPanel116.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel116.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel116MouseClicked(evt);
            }
        });

        jLabel348.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel348.setForeground(new java.awt.Color(102, 102, 102));
        jLabel348.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel348.setText("Phòng 111H3");
        jLabel348.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel348.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel349.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel349.setForeground(new java.awt.Color(102, 102, 102));
        jLabel349.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel350.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel350.setForeground(new java.awt.Color(255, 255, 153));
        jLabel350.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel116Layout = new javax.swing.GroupLayout(jPanel116);
        jPanel116.setLayout(jPanel116Layout);
        jPanel116Layout.setHorizontalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel348, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel349, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel350, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel116Layout.setVerticalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel116Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel348)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel349)
                .addGap(12, 12, 12)
                .addComponent(jLabel350)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel116);

        jPanel119.setBackground(new java.awt.Color(153, 204, 255));
        jPanel119.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel119.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel119MouseClicked(evt);
            }
        });

        jLabel357.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel357.setForeground(new java.awt.Color(102, 102, 102));
        jLabel357.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel357.setText("Phòng 112H3");
        jLabel357.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel357.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel358.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel358.setForeground(new java.awt.Color(102, 102, 102));
        jLabel358.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel359.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel359.setForeground(new java.awt.Color(102, 102, 102));
        jLabel359.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel119Layout = new javax.swing.GroupLayout(jPanel119);
        jPanel119.setLayout(jPanel119Layout);
        jPanel119Layout.setHorizontalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel357, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel358, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel359, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel119Layout.setVerticalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel357)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel358)
                .addGap(12, 12, 12)
                .addComponent(jLabel359)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel119);

        jPanel117.setBackground(new java.awt.Color(153, 204, 255));
        jPanel117.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel117MouseClicked(evt);
            }
        });

        jLabel351.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel351.setForeground(new java.awt.Color(102, 102, 102));
        jLabel351.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel351.setText("Phòng 113H3");
        jLabel351.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel351.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel352.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel352.setForeground(new java.awt.Color(102, 102, 102));
        jLabel352.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel353.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel353.setForeground(new java.awt.Color(102, 102, 102));
        jLabel353.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel117Layout = new javax.swing.GroupLayout(jPanel117);
        jPanel117.setLayout(jPanel117Layout);
        jPanel117Layout.setHorizontalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel351, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel352, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel353, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel117Layout.setVerticalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel351)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel352)
                .addGap(12, 12, 12)
                .addComponent(jLabel353)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel117);

        jPanel118.setBackground(new java.awt.Color(153, 204, 255));
        jPanel118.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel118.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel118MouseClicked(evt);
            }
        });

        jLabel354.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel354.setForeground(new java.awt.Color(102, 102, 102));
        jLabel354.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel354.setText("Phòng 114H3");
        jLabel354.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel354.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel355.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel355.setForeground(new java.awt.Color(102, 102, 102));
        jLabel355.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel356.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel356.setForeground(new java.awt.Color(204, 0, 102));
        jLabel356.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel118Layout = new javax.swing.GroupLayout(jPanel118);
        jPanel118.setLayout(jPanel118Layout);
        jPanel118Layout.setHorizontalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel354, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel355, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel356, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel118Layout.setVerticalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel354)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel355)
                .addGap(12, 12, 12)
                .addComponent(jLabel356)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang3.add(jPanel118);

        jRoompanel.add(jPanelTang3);

        jPanelTang4.setBackground(new java.awt.Color(204, 255, 204));
        jPanelTang4.setPreferredSize(new java.awt.Dimension(940, 142));
        jPanelTang4.setLayout(new java.awt.GridLayout(5, 5, 2, 2));

        jPanel23.setBackground(new java.awt.Color(255, 51, 51));

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("TẦNG 4");
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );

        jPanelTang4.add(jPanel23);

        jPanel135.setBackground(new java.awt.Color(153, 204, 255));
        jPanel135.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel135.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel135MouseClicked(evt);
            }
        });

        jLabel405.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel405.setForeground(new java.awt.Color(102, 102, 102));
        jLabel405.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel405.setText("Phòng 101H4");
        jLabel405.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel405.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel406.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel406.setForeground(new java.awt.Color(102, 102, 102));
        jLabel406.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel407.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel407.setForeground(new java.awt.Color(204, 0, 102));
        jLabel407.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel135Layout = new javax.swing.GroupLayout(jPanel135);
        jPanel135.setLayout(jPanel135Layout);
        jPanel135Layout.setHorizontalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel405, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel406, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel407, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel135Layout.setVerticalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel135Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel405)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel406)
                .addGap(12, 12, 12)
                .addComponent(jLabel407)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel135);

        jPanel120.setBackground(new java.awt.Color(153, 204, 255));
        jPanel120.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel120MouseClicked(evt);
            }
        });

        jLabel360.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel360.setForeground(new java.awt.Color(102, 102, 102));
        jLabel360.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel360.setText("Phòng 102H4");
        jLabel360.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel360.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel361.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel361.setForeground(new java.awt.Color(102, 102, 102));
        jLabel361.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel362.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel362.setForeground(new java.awt.Color(102, 102, 102));
        jLabel362.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel120Layout = new javax.swing.GroupLayout(jPanel120);
        jPanel120.setLayout(jPanel120Layout);
        jPanel120Layout.setHorizontalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel360, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel361, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel362, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel120Layout.setVerticalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel360)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel361)
                .addGap(12, 12, 12)
                .addComponent(jLabel362)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel120);

        jPanel121.setBackground(new java.awt.Color(153, 204, 255));
        jPanel121.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel121.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel121MouseClicked(evt);
            }
        });

        jLabel363.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel363.setForeground(new java.awt.Color(102, 102, 102));
        jLabel363.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel363.setText("Phòng 103H4");
        jLabel363.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel363.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel364.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel364.setForeground(new java.awt.Color(102, 102, 102));
        jLabel364.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel365.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel365.setForeground(new java.awt.Color(204, 0, 102));
        jLabel365.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel122.setBackground(new java.awt.Color(153, 204, 255));
        jPanel122.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel366.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel366.setForeground(new java.awt.Color(102, 102, 102));
        jLabel366.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel366.setText("Phòng 101H1");
        jLabel366.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel366.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel367.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel367.setForeground(new java.awt.Color(102, 102, 102));
        jLabel367.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel367.setText("Đang trống");

        jLabel368.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel368.setForeground(new java.awt.Color(102, 102, 102));
        jLabel368.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel368.setText("Phòng Đơn");

        javax.swing.GroupLayout jPanel122Layout = new javax.swing.GroupLayout(jPanel122);
        jPanel122.setLayout(jPanel122Layout);
        jPanel122Layout.setHorizontalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel366, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel367, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel368, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel122Layout.setVerticalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel122Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel366)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel367)
                .addGap(12, 12, 12)
                .addComponent(jLabel368)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel121Layout = new javax.swing.GroupLayout(jPanel121);
        jPanel121.setLayout(jPanel121Layout);
        jPanel121Layout.setHorizontalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel363, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel364, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel365, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel121Layout.setVerticalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel363)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel364)
                .addGap(12, 12, 12)
                .addComponent(jLabel365)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel121);

        jPanel128.setBackground(new java.awt.Color(153, 204, 255));
        jPanel128.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel128.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel128MouseClicked(evt);
            }
        });

        jLabel384.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel384.setForeground(new java.awt.Color(102, 102, 102));
        jLabel384.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel384.setText("Phòng 104H4");
        jLabel384.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel384.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel385.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel385.setForeground(new java.awt.Color(102, 102, 102));
        jLabel385.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel386.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel386.setForeground(new java.awt.Color(255, 255, 153));
        jLabel386.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel128Layout = new javax.swing.GroupLayout(jPanel128);
        jPanel128.setLayout(jPanel128Layout);
        jPanel128Layout.setHorizontalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel384, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel385, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel386, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel128Layout.setVerticalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel384)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel385)
                .addGap(12, 12, 12)
                .addComponent(jLabel386)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel128);

        jPanel129.setBackground(new java.awt.Color(153, 204, 255));
        jPanel129.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel129.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel129MouseClicked(evt);
            }
        });

        jLabel387.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel387.setForeground(new java.awt.Color(102, 102, 102));
        jLabel387.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel387.setText("Phòng 105H4");
        jLabel387.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel387.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel388.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel388.setForeground(new java.awt.Color(102, 102, 102));
        jLabel388.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel389.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel389.setForeground(new java.awt.Color(102, 102, 102));
        jLabel389.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel129Layout = new javax.swing.GroupLayout(jPanel129);
        jPanel129.setLayout(jPanel129Layout);
        jPanel129Layout.setHorizontalGroup(
            jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel387, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel388, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel389, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel129Layout.setVerticalGroup(
            jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel129Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel387)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel388)
                .addGap(12, 12, 12)
                .addComponent(jLabel389)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel129);

        jPanel133.setBackground(new java.awt.Color(153, 204, 255));
        jPanel133.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel133.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel133MouseClicked(evt);
            }
        });

        jLabel399.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel399.setForeground(new java.awt.Color(102, 102, 102));
        jLabel399.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel399.setText("Phòng 106H4");
        jLabel399.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel399.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel400.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel400.setForeground(new java.awt.Color(102, 102, 102));
        jLabel400.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel401.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel401.setForeground(new java.awt.Color(255, 255, 153));
        jLabel401.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel133Layout = new javax.swing.GroupLayout(jPanel133);
        jPanel133.setLayout(jPanel133Layout);
        jPanel133Layout.setHorizontalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel399, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel400, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel401, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel133Layout.setVerticalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel133Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel399)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel400)
                .addGap(12, 12, 12)
                .addComponent(jLabel401)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel133);

        jPanel136.setBackground(new java.awt.Color(153, 204, 255));
        jPanel136.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel136.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel136MouseClicked(evt);
            }
        });

        jLabel408.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel408.setForeground(new java.awt.Color(102, 102, 102));
        jLabel408.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel408.setText("Phòng 107H4");
        jLabel408.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel408.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel409.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel409.setForeground(new java.awt.Color(102, 102, 102));
        jLabel409.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel410.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel410.setForeground(new java.awt.Color(102, 102, 102));
        jLabel410.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel136Layout = new javax.swing.GroupLayout(jPanel136);
        jPanel136.setLayout(jPanel136Layout);
        jPanel136Layout.setHorizontalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel408, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel409, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel410, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel136Layout.setVerticalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel136Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel408)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel409)
                .addGap(12, 12, 12)
                .addComponent(jLabel410)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel136);

        jPanel126.setBackground(new java.awt.Color(153, 204, 255));
        jPanel126.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel126.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel126MouseClicked(evt);
            }
        });

        jLabel378.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel378.setForeground(new java.awt.Color(102, 102, 102));
        jLabel378.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel378.setText("Phòng 108H4");
        jLabel378.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel378.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel379.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel379.setForeground(new java.awt.Color(102, 102, 102));
        jLabel379.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel380.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel380.setForeground(new java.awt.Color(204, 0, 102));
        jLabel380.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel126Layout = new javax.swing.GroupLayout(jPanel126);
        jPanel126.setLayout(jPanel126Layout);
        jPanel126Layout.setHorizontalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel378, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel379, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel380, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel126Layout.setVerticalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel126Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel378)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel379)
                .addGap(12, 12, 12)
                .addComponent(jLabel380)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel126);

        jPanel123.setBackground(new java.awt.Color(153, 204, 255));
        jPanel123.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel123.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel123MouseClicked(evt);
            }
        });

        jLabel369.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel369.setForeground(new java.awt.Color(102, 102, 102));
        jLabel369.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel369.setText("Phòng 109H4");
        jLabel369.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel369.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel370.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel370.setForeground(new java.awt.Color(102, 102, 102));
        jLabel370.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel371.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel371.setForeground(new java.awt.Color(255, 255, 153));
        jLabel371.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel124.setBackground(new java.awt.Color(153, 204, 255));
        jPanel124.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel372.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel372.setForeground(new java.awt.Color(102, 102, 102));
        jLabel372.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel372.setText("Phòng 101H1");
        jLabel372.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel372.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel373.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel373.setForeground(new java.awt.Color(102, 102, 102));
        jLabel373.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel373.setText("Đang trống");

        jLabel374.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel374.setForeground(new java.awt.Color(102, 102, 102));
        jLabel374.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel374.setText("Phòng Đơn");

        javax.swing.GroupLayout jPanel124Layout = new javax.swing.GroupLayout(jPanel124);
        jPanel124.setLayout(jPanel124Layout);
        jPanel124Layout.setHorizontalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel372, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel373, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel374, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel124Layout.setVerticalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel124Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel372)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel373)
                .addGap(12, 12, 12)
                .addComponent(jLabel374)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel125.setBackground(new java.awt.Color(153, 204, 255));
        jPanel125.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel375.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel375.setForeground(new java.awt.Color(102, 102, 102));
        jLabel375.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel375.setText("Phòng 102H1");
        jLabel375.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel375.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel376.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel376.setForeground(new java.awt.Color(102, 102, 102));
        jLabel376.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel376.setText("Đang trống");

        jLabel377.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel377.setForeground(new java.awt.Color(204, 0, 102));
        jLabel377.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel377.setText("Phòng Đôi");

        javax.swing.GroupLayout jPanel125Layout = new javax.swing.GroupLayout(jPanel125);
        jPanel125.setLayout(jPanel125Layout);
        jPanel125Layout.setHorizontalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel375, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel376, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel377, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel125Layout.setVerticalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel125Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel375)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel376)
                .addGap(12, 12, 12)
                .addComponent(jLabel377)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel123Layout = new javax.swing.GroupLayout(jPanel123);
        jPanel123.setLayout(jPanel123Layout);
        jPanel123Layout.setHorizontalGroup(
            jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel369, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel370, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel371, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel123Layout.setVerticalGroup(
            jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel123Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel369)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel370)
                .addGap(12, 12, 12)
                .addComponent(jLabel371)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel123);

        jPanel127.setBackground(new java.awt.Color(153, 204, 255));
        jPanel127.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel127.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel127MouseClicked(evt);
            }
        });

        jLabel381.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel381.setForeground(new java.awt.Color(102, 102, 102));
        jLabel381.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel381.setText("Phòng 110H4");
        jLabel381.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel381.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel382.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel382.setForeground(new java.awt.Color(102, 102, 102));
        jLabel382.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel383.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel383.setForeground(new java.awt.Color(102, 102, 102));
        jLabel383.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel127Layout = new javax.swing.GroupLayout(jPanel127);
        jPanel127.setLayout(jPanel127Layout);
        jPanel127Layout.setHorizontalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel381, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel382, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel383, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel127Layout.setVerticalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel127Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel381)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel382)
                .addGap(12, 12, 12)
                .addComponent(jLabel383)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel127);

        jPanel130.setBackground(new java.awt.Color(153, 204, 255));
        jPanel130.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel130.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel130MouseClicked(evt);
            }
        });

        jLabel390.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel390.setForeground(new java.awt.Color(102, 102, 102));
        jLabel390.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel390.setText("Phòng 111H4");
        jLabel390.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel390.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel391.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel391.setForeground(new java.awt.Color(102, 102, 102));
        jLabel391.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel392.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel392.setForeground(new java.awt.Color(204, 0, 102));
        jLabel392.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel130Layout = new javax.swing.GroupLayout(jPanel130);
        jPanel130.setLayout(jPanel130Layout);
        jPanel130Layout.setHorizontalGroup(
            jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel390, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel391, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel392, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel130Layout.setVerticalGroup(
            jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel130Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel390)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel391)
                .addGap(12, 12, 12)
                .addComponent(jLabel392)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel130);

        jPanel132.setBackground(new java.awt.Color(153, 204, 255));
        jPanel132.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel132.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel132MouseClicked(evt);
            }
        });

        jLabel396.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel396.setForeground(new java.awt.Color(102, 102, 102));
        jLabel396.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel396.setText("Phòng 112H4");
        jLabel396.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel396.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel397.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel397.setForeground(new java.awt.Color(102, 102, 102));
        jLabel397.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel398.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel398.setForeground(new java.awt.Color(255, 255, 153));
        jLabel398.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel132Layout = new javax.swing.GroupLayout(jPanel132);
        jPanel132.setLayout(jPanel132Layout);
        jPanel132Layout.setHorizontalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel396, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel397, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel398, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel132Layout.setVerticalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel132Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel396)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel397)
                .addGap(12, 12, 12)
                .addComponent(jLabel398)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel132);

        jPanel134.setBackground(new java.awt.Color(153, 204, 255));
        jPanel134.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel134.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel134MouseClicked(evt);
            }
        });

        jLabel402.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel402.setForeground(new java.awt.Color(102, 102, 102));
        jLabel402.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel402.setText("Phòng 113H4");
        jLabel402.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel402.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel403.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel403.setForeground(new java.awt.Color(102, 102, 102));
        jLabel403.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel404.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel404.setForeground(new java.awt.Color(102, 102, 102));
        jLabel404.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel134Layout = new javax.swing.GroupLayout(jPanel134);
        jPanel134.setLayout(jPanel134Layout);
        jPanel134Layout.setHorizontalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel402, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel403, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel404, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel134Layout.setVerticalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel134Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel402)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel403)
                .addGap(12, 12, 12)
                .addComponent(jLabel404)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel134);

        jPanel131.setBackground(new java.awt.Color(153, 204, 255));
        jPanel131.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel131.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel131MouseClicked(evt);
            }
        });

        jLabel393.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel393.setForeground(new java.awt.Color(102, 102, 102));
        jLabel393.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel393.setText("Phòng 114H4");
        jLabel393.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel393.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel394.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel394.setForeground(new java.awt.Color(102, 102, 102));
        jLabel394.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel395.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel395.setForeground(new java.awt.Color(204, 0, 102));
        jLabel395.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel131Layout = new javax.swing.GroupLayout(jPanel131);
        jPanel131.setLayout(jPanel131Layout);
        jPanel131Layout.setHorizontalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel393, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel394, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel395, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel131Layout.setVerticalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel131Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel393)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel394)
                .addGap(12, 12, 12)
                .addComponent(jLabel395)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang4.add(jPanel131);

        jRoompanel.add(jPanelTang4);

        jPanelTang5.setBackground(new java.awt.Color(204, 204, 255));
        jPanelTang5.setPreferredSize(new java.awt.Dimension(940, 142));
        jPanelTang5.setLayout(new java.awt.GridLayout(5, 5, 2, 2));

        jPanel24.setBackground(new java.awt.Color(255, 51, 51));

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("TẦNG 5");
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );

        jPanelTang5.add(jPanel24);

        jPanel137.setBackground(new java.awt.Color(153, 204, 255));
        jPanel137.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel137.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel137MouseClicked(evt);
            }
        });

        jLabel411.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel411.setForeground(new java.awt.Color(102, 102, 102));
        jLabel411.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel411.setText("Phòng 101H5");
        jLabel411.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel411.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel412.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel412.setForeground(new java.awt.Color(102, 102, 102));
        jLabel412.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel413.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel413.setForeground(new java.awt.Color(102, 102, 102));
        jLabel413.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel137Layout = new javax.swing.GroupLayout(jPanel137);
        jPanel137.setLayout(jPanel137Layout);
        jPanel137Layout.setHorizontalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel411, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel412, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel413, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel137Layout.setVerticalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel137Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel411)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel412)
                .addGap(12, 12, 12)
                .addComponent(jLabel413)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel137);

        jPanel138.setBackground(new java.awt.Color(153, 204, 255));
        jPanel138.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel138.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel138MouseClicked(evt);
            }
        });

        jLabel414.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel414.setForeground(new java.awt.Color(102, 102, 102));
        jLabel414.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel414.setText("Phòng 102H5");
        jLabel414.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel414.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel415.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel415.setForeground(new java.awt.Color(102, 102, 102));
        jLabel415.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel416.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel416.setForeground(new java.awt.Color(204, 0, 102));
        jLabel416.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel138Layout = new javax.swing.GroupLayout(jPanel138);
        jPanel138.setLayout(jPanel138Layout);
        jPanel138Layout.setHorizontalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel414, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel415, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel416, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel138Layout.setVerticalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel138Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel414)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel415)
                .addGap(12, 12, 12)
                .addComponent(jLabel416)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel138);

        jPanel145.setBackground(new java.awt.Color(153, 204, 255));
        jPanel145.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel145.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel145MouseClicked(evt);
            }
        });

        jLabel435.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel435.setForeground(new java.awt.Color(102, 102, 102));
        jLabel435.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel435.setText("Phòng 103H5");
        jLabel435.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel435.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel436.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel436.setForeground(new java.awt.Color(102, 102, 102));
        jLabel436.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel437.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel437.setForeground(new java.awt.Color(255, 255, 153));
        jLabel437.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel145Layout = new javax.swing.GroupLayout(jPanel145);
        jPanel145.setLayout(jPanel145Layout);
        jPanel145Layout.setHorizontalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel435, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel436, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel437, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel145Layout.setVerticalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel145Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel435)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel436)
                .addGap(12, 12, 12)
                .addComponent(jLabel437)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel145);

        jPanel146.setBackground(new java.awt.Color(153, 204, 255));
        jPanel146.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel146.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel146MouseClicked(evt);
            }
        });

        jLabel438.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel438.setForeground(new java.awt.Color(102, 102, 102));
        jLabel438.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel438.setText("Phòng 104H5");
        jLabel438.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel438.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel439.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel439.setForeground(new java.awt.Color(102, 102, 102));
        jLabel439.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel440.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel440.setForeground(new java.awt.Color(102, 102, 102));
        jLabel440.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel146Layout = new javax.swing.GroupLayout(jPanel146);
        jPanel146.setLayout(jPanel146Layout);
        jPanel146Layout.setHorizontalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel438, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel439, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel440, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel146Layout.setVerticalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel146Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel438)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel439)
                .addGap(12, 12, 12)
                .addComponent(jLabel440)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel146);

        jPanel148.setBackground(new java.awt.Color(153, 204, 255));
        jPanel148.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel148.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel148MouseClicked(evt);
            }
        });

        jLabel444.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel444.setForeground(new java.awt.Color(102, 102, 102));
        jLabel444.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel444.setText("Phòng 105H5");
        jLabel444.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel444.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel445.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel445.setForeground(new java.awt.Color(102, 102, 102));
        jLabel445.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel446.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel446.setForeground(new java.awt.Color(204, 0, 102));
        jLabel446.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel148Layout = new javax.swing.GroupLayout(jPanel148);
        jPanel148.setLayout(jPanel148Layout);
        jPanel148Layout.setHorizontalGroup(
            jPanel148Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel444, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel445, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel446, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel148Layout.setVerticalGroup(
            jPanel148Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel148Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel444)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel445)
                .addGap(12, 12, 12)
                .addComponent(jLabel446)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel148);

        jPanel150.setBackground(new java.awt.Color(153, 204, 255));
        jPanel150.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel150.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel150MouseClicked(evt);
            }
        });

        jLabel450.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel450.setForeground(new java.awt.Color(102, 102, 102));
        jLabel450.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel450.setText("Phòng 106H5");
        jLabel450.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel450.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel451.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel451.setForeground(new java.awt.Color(102, 102, 102));
        jLabel451.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel461.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel461.setForeground(new java.awt.Color(102, 102, 102));
        jLabel461.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel150Layout = new javax.swing.GroupLayout(jPanel150);
        jPanel150.setLayout(jPanel150Layout);
        jPanel150Layout.setHorizontalGroup(
            jPanel150Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel450, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel451, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel150Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel461, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel150Layout.setVerticalGroup(
            jPanel150Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel150Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel450)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel451)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel461)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel150);

        jPanel153.setBackground(new java.awt.Color(153, 204, 255));
        jPanel153.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel153.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel153MouseClicked(evt);
            }
        });

        jLabel459.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel459.setForeground(new java.awt.Color(102, 102, 102));
        jLabel459.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel459.setText("Phòng 107H5");
        jLabel459.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel459.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel460.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel460.setForeground(new java.awt.Color(102, 102, 102));
        jLabel460.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel154.setBackground(new java.awt.Color(153, 204, 255));
        jPanel154.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel462.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel462.setForeground(new java.awt.Color(102, 102, 102));
        jLabel462.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel462.setText("Phòng 101H1");
        jLabel462.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel462.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel463.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel463.setForeground(new java.awt.Color(102, 102, 102));
        jLabel463.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel463.setText("Đang trống");

        jLabel464.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel464.setForeground(new java.awt.Color(102, 102, 102));
        jLabel464.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel464.setText("Phòng Đơn");

        javax.swing.GroupLayout jPanel154Layout = new javax.swing.GroupLayout(jPanel154);
        jPanel154.setLayout(jPanel154Layout);
        jPanel154Layout.setHorizontalGroup(
            jPanel154Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel462, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel463, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel464, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel154Layout.setVerticalGroup(
            jPanel154Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel154Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel462)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel463)
                .addGap(12, 12, 12)
                .addComponent(jLabel464)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel155.setBackground(new java.awt.Color(153, 204, 255));
        jPanel155.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel465.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel465.setForeground(new java.awt.Color(102, 102, 102));
        jLabel465.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel465.setText("Phòng 102H1");
        jLabel465.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel465.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel466.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel466.setForeground(new java.awt.Color(102, 102, 102));
        jLabel466.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel466.setText("Đang trống");

        jLabel467.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel467.setForeground(new java.awt.Color(204, 0, 102));
        jLabel467.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel467.setText("Phòng Đôi");

        jPanel156.setBackground(new java.awt.Color(153, 204, 255));
        jPanel156.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel468.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel468.setForeground(new java.awt.Color(102, 102, 102));
        jLabel468.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel468.setText("Phòng 101H1");
        jLabel468.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel468.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel469.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel469.setForeground(new java.awt.Color(102, 102, 102));
        jLabel469.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel469.setText("Đang trống");

        jLabel470.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel470.setForeground(new java.awt.Color(102, 102, 102));
        jLabel470.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel470.setText("Phòng Đơn");

        javax.swing.GroupLayout jPanel156Layout = new javax.swing.GroupLayout(jPanel156);
        jPanel156.setLayout(jPanel156Layout);
        jPanel156Layout.setHorizontalGroup(
            jPanel156Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel468, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel469, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel470, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel156Layout.setVerticalGroup(
            jPanel156Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel156Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel468)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel469)
                .addGap(12, 12, 12)
                .addComponent(jLabel470)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel155Layout = new javax.swing.GroupLayout(jPanel155);
        jPanel155.setLayout(jPanel155Layout);
        jPanel155Layout.setHorizontalGroup(
            jPanel155Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel465, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel466, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel467, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel155Layout.setVerticalGroup(
            jPanel155Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel155Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel465)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel466)
                .addGap(12, 12, 12)
                .addComponent(jLabel467)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel157.setBackground(new java.awt.Color(153, 204, 255));
        jPanel157.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel471.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel471.setForeground(new java.awt.Color(102, 102, 102));
        jLabel471.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel471.setText("Phòng 109H1");
        jLabel471.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel471.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel472.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel472.setForeground(new java.awt.Color(102, 102, 102));
        jLabel472.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel472.setText("Đang trống");

        jLabel473.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel473.setForeground(new java.awt.Color(255, 255, 153));
        jLabel473.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel473.setText("Phòng VIP");

        jPanel158.setBackground(new java.awt.Color(153, 204, 255));
        jPanel158.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel474.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel474.setForeground(new java.awt.Color(102, 102, 102));
        jLabel474.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel474.setText("Phòng 101H1");
        jLabel474.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel474.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel475.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel475.setForeground(new java.awt.Color(102, 102, 102));
        jLabel475.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel475.setText("Đang trống");

        jLabel476.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel476.setForeground(new java.awt.Color(102, 102, 102));
        jLabel476.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel476.setText("Phòng Đơn");

        javax.swing.GroupLayout jPanel158Layout = new javax.swing.GroupLayout(jPanel158);
        jPanel158.setLayout(jPanel158Layout);
        jPanel158Layout.setHorizontalGroup(
            jPanel158Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel474, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel475, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel476, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel158Layout.setVerticalGroup(
            jPanel158Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel158Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel474)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel475)
                .addGap(12, 12, 12)
                .addComponent(jLabel476)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel159.setBackground(new java.awt.Color(153, 204, 255));
        jPanel159.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel477.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel477.setForeground(new java.awt.Color(102, 102, 102));
        jLabel477.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel477.setText("Phòng 102H1");
        jLabel477.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel477.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel478.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel478.setForeground(new java.awt.Color(102, 102, 102));
        jLabel478.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel478.setText("Đang trống");

        jLabel479.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel479.setForeground(new java.awt.Color(204, 0, 102));
        jLabel479.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel479.setText("Phòng Đôi");

        javax.swing.GroupLayout jPanel159Layout = new javax.swing.GroupLayout(jPanel159);
        jPanel159.setLayout(jPanel159Layout);
        jPanel159Layout.setHorizontalGroup(
            jPanel159Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel477, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel478, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel479, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel159Layout.setVerticalGroup(
            jPanel159Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel159Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel477)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel478)
                .addGap(12, 12, 12)
                .addComponent(jLabel479)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel157Layout = new javax.swing.GroupLayout(jPanel157);
        jPanel157.setLayout(jPanel157Layout);
        jPanel157Layout.setHorizontalGroup(
            jPanel157Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel471, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel472, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel473, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel157Layout.setVerticalGroup(
            jPanel157Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel157Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel471)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel472)
                .addGap(12, 12, 12)
                .addComponent(jLabel473)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel160.setBackground(new java.awt.Color(153, 204, 255));
        jPanel160.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel480.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel480.setForeground(new java.awt.Color(102, 102, 102));
        jLabel480.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel480.setText("Phòng 108H1");
        jLabel480.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel480.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel481.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel481.setForeground(new java.awt.Color(102, 102, 102));
        jLabel481.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel481.setText("Đang trống");

        jLabel482.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel482.setForeground(new java.awt.Color(204, 0, 102));
        jLabel482.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel482.setText("Phòng Đôi");

        javax.swing.GroupLayout jPanel160Layout = new javax.swing.GroupLayout(jPanel160);
        jPanel160.setLayout(jPanel160Layout);
        jPanel160Layout.setHorizontalGroup(
            jPanel160Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel480, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel481, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel482, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel160Layout.setVerticalGroup(
            jPanel160Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel160Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel480)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel481)
                .addGap(12, 12, 12)
                .addComponent(jLabel482)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel161.setBackground(new java.awt.Color(153, 204, 255));
        jPanel161.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel483.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel483.setForeground(new java.awt.Color(102, 102, 102));
        jLabel483.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel483.setText("Phòng 110H1");
        jLabel483.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel483.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel484.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel484.setForeground(new java.awt.Color(102, 102, 102));
        jLabel484.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel484.setText("Đang trống");

        jLabel485.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel485.setForeground(new java.awt.Color(102, 102, 102));
        jLabel485.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel485.setText("Phòng Đơn");

        javax.swing.GroupLayout jPanel161Layout = new javax.swing.GroupLayout(jPanel161);
        jPanel161.setLayout(jPanel161Layout);
        jPanel161Layout.setHorizontalGroup(
            jPanel161Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel483, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel484, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel485, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel161Layout.setVerticalGroup(
            jPanel161Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel161Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel483)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel484)
                .addGap(12, 12, 12)
                .addComponent(jLabel485)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel162.setBackground(new java.awt.Color(153, 204, 255));
        jPanel162.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel486.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel486.setForeground(new java.awt.Color(102, 102, 102));
        jLabel486.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel486.setText("Phòng 103H1");
        jLabel486.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel486.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel487.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel487.setForeground(new java.awt.Color(102, 102, 102));
        jLabel487.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel487.setText("Đang trống");

        jLabel488.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel488.setForeground(new java.awt.Color(255, 255, 153));
        jLabel488.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel488.setText("Phòng VIP");

        javax.swing.GroupLayout jPanel162Layout = new javax.swing.GroupLayout(jPanel162);
        jPanel162.setLayout(jPanel162Layout);
        jPanel162Layout.setHorizontalGroup(
            jPanel162Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel486, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel487, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel488, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel162Layout.setVerticalGroup(
            jPanel162Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel162Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel486)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel487)
                .addGap(12, 12, 12)
                .addComponent(jLabel488)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel163.setBackground(new java.awt.Color(153, 204, 255));
        jPanel163.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel489.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel489.setForeground(new java.awt.Color(102, 102, 102));
        jLabel489.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel489.setText("Phòng 104H1");
        jLabel489.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel489.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel490.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel490.setForeground(new java.awt.Color(102, 102, 102));
        jLabel490.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel490.setText("Đang trống");

        jLabel491.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel491.setForeground(new java.awt.Color(102, 102, 102));
        jLabel491.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel491.setText("Phòng Đơn");

        javax.swing.GroupLayout jPanel163Layout = new javax.swing.GroupLayout(jPanel163);
        jPanel163.setLayout(jPanel163Layout);
        jPanel163Layout.setHorizontalGroup(
            jPanel163Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel489, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel490, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel491, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel163Layout.setVerticalGroup(
            jPanel163Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel163Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel489)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel490)
                .addGap(12, 12, 12)
                .addComponent(jLabel491)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel164.setBackground(new java.awt.Color(153, 204, 255));
        jPanel164.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel492.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel492.setForeground(new java.awt.Color(102, 102, 102));
        jLabel492.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel492.setText("Phòng 111H1");
        jLabel492.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel492.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel493.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel493.setForeground(new java.awt.Color(102, 102, 102));
        jLabel493.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel493.setText("Đang trống");

        jLabel494.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel494.setForeground(new java.awt.Color(204, 0, 102));
        jLabel494.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel494.setText("Phòng Đôi");

        javax.swing.GroupLayout jPanel164Layout = new javax.swing.GroupLayout(jPanel164);
        jPanel164.setLayout(jPanel164Layout);
        jPanel164Layout.setHorizontalGroup(
            jPanel164Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel492, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel493, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel494, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel164Layout.setVerticalGroup(
            jPanel164Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel164Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel492)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel493)
                .addGap(12, 12, 12)
                .addComponent(jLabel494)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel165.setBackground(new java.awt.Color(153, 204, 255));
        jPanel165.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel495.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel495.setForeground(new java.awt.Color(102, 102, 102));
        jLabel495.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel495.setText("Phòng 105H1");
        jLabel495.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel495.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel496.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel496.setForeground(new java.awt.Color(102, 102, 102));
        jLabel496.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel496.setText("Đang trống");

        jLabel497.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel497.setForeground(new java.awt.Color(204, 0, 102));
        jLabel497.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel497.setText("Phòng Đôi");

        javax.swing.GroupLayout jPanel165Layout = new javax.swing.GroupLayout(jPanel165);
        jPanel165.setLayout(jPanel165Layout);
        jPanel165Layout.setHorizontalGroup(
            jPanel165Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel495, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel496, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel497, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel165Layout.setVerticalGroup(
            jPanel165Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel165Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel495)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel496)
                .addGap(12, 12, 12)
                .addComponent(jLabel497)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel166.setBackground(new java.awt.Color(153, 204, 255));
        jPanel166.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel498.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel498.setForeground(new java.awt.Color(102, 102, 102));
        jLabel498.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel498.setText("Phòng 112H1");
        jLabel498.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel498.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel499.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel499.setForeground(new java.awt.Color(102, 102, 102));
        jLabel499.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel499.setText("Đang trống");

        jLabel500.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel500.setForeground(new java.awt.Color(255, 255, 153));
        jLabel500.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel500.setText("Phòng VIP");

        javax.swing.GroupLayout jPanel166Layout = new javax.swing.GroupLayout(jPanel166);
        jPanel166.setLayout(jPanel166Layout);
        jPanel166Layout.setHorizontalGroup(
            jPanel166Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel498, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel499, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel500, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel166Layout.setVerticalGroup(
            jPanel166Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel166Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel498)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel499)
                .addGap(12, 12, 12)
                .addComponent(jLabel500)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel167.setBackground(new java.awt.Color(153, 204, 255));
        jPanel167.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel501.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel501.setForeground(new java.awt.Color(102, 102, 102));
        jLabel501.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel501.setText("Phòng 106H1");
        jLabel501.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel501.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel502.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel502.setForeground(new java.awt.Color(102, 102, 102));
        jLabel502.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel502.setText("Đang trống");

        jLabel503.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel503.setForeground(new java.awt.Color(255, 255, 153));
        jLabel503.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel503.setText("Phòng VIP");

        javax.swing.GroupLayout jPanel167Layout = new javax.swing.GroupLayout(jPanel167);
        jPanel167.setLayout(jPanel167Layout);
        jPanel167Layout.setHorizontalGroup(
            jPanel167Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel501, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel502, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel503, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel167Layout.setVerticalGroup(
            jPanel167Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel167Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel501)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel502)
                .addGap(12, 12, 12)
                .addComponent(jLabel503)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel168.setBackground(new java.awt.Color(153, 204, 255));
        jPanel168.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel504.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel504.setForeground(new java.awt.Color(102, 102, 102));
        jLabel504.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel504.setText("Phòng 113H1");
        jLabel504.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel504.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel505.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel505.setForeground(new java.awt.Color(102, 102, 102));
        jLabel505.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel505.setText("Đang trống");

        jLabel506.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel506.setForeground(new java.awt.Color(102, 102, 102));
        jLabel506.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel506.setText("Phòng Đơn");

        javax.swing.GroupLayout jPanel168Layout = new javax.swing.GroupLayout(jPanel168);
        jPanel168.setLayout(jPanel168Layout);
        jPanel168Layout.setHorizontalGroup(
            jPanel168Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel504, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel505, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel506, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel168Layout.setVerticalGroup(
            jPanel168Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel168Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel504)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel505)
                .addGap(12, 12, 12)
                .addComponent(jLabel506)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel169.setBackground(new java.awt.Color(153, 204, 255));
        jPanel169.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel507.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel507.setForeground(new java.awt.Color(102, 102, 102));
        jLabel507.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel507.setText("Phòng 114H1");
        jLabel507.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel507.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel508.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel508.setForeground(new java.awt.Color(102, 102, 102));
        jLabel508.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel508.setText("Đang trống");

        jLabel509.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel509.setForeground(new java.awt.Color(204, 0, 102));
        jLabel509.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel509.setText("Phòng Đôi");

        javax.swing.GroupLayout jPanel169Layout = new javax.swing.GroupLayout(jPanel169);
        jPanel169.setLayout(jPanel169Layout);
        jPanel169Layout.setHorizontalGroup(
            jPanel169Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel507, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel508, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel509, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel169Layout.setVerticalGroup(
            jPanel169Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel169Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel507)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel508)
                .addGap(12, 12, 12)
                .addComponent(jLabel509)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel452.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel452.setForeground(new java.awt.Color(255, 255, 153));
        jLabel452.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel153Layout = new javax.swing.GroupLayout(jPanel153);
        jPanel153.setLayout(jPanel153Layout);
        jPanel153Layout.setHorizontalGroup(
            jPanel153Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel459, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel460, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel452, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel153Layout.setVerticalGroup(
            jPanel153Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel153Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel459)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel460)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel452)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel153);

        jPanel143.setBackground(new java.awt.Color(153, 204, 255));
        jPanel143.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel143.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel143MouseClicked(evt);
            }
        });

        jLabel429.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel429.setForeground(new java.awt.Color(102, 102, 102));
        jLabel429.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel429.setText("Phòng 108H5");
        jLabel429.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel429.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel430.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel430.setForeground(new java.awt.Color(102, 102, 102));
        jLabel430.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel431.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel431.setForeground(new java.awt.Color(204, 0, 102));
        jLabel431.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel143Layout = new javax.swing.GroupLayout(jPanel143);
        jPanel143.setLayout(jPanel143Layout);
        jPanel143Layout.setHorizontalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel429, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel430, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel431, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel143Layout.setVerticalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel143Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel429)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel430)
                .addGap(12, 12, 12)
                .addComponent(jLabel431)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel143);

        jPanel140.setBackground(new java.awt.Color(153, 204, 255));
        jPanel140.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel140.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel140MouseClicked(evt);
            }
        });

        jLabel420.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel420.setForeground(new java.awt.Color(102, 102, 102));
        jLabel420.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel420.setText("Phòng 109H5");
        jLabel420.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel420.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel421.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel421.setForeground(new java.awt.Color(102, 102, 102));
        jLabel421.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel141.setBackground(new java.awt.Color(153, 204, 255));
        jPanel141.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel423.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel423.setForeground(new java.awt.Color(102, 102, 102));
        jLabel423.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel423.setText("Phòng 101H1");
        jLabel423.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel423.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel424.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel424.setForeground(new java.awt.Color(102, 102, 102));
        jLabel424.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel424.setText("Đang trống");

        jLabel425.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel425.setForeground(new java.awt.Color(102, 102, 102));
        jLabel425.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel425.setText("Phòng Đơn");

        javax.swing.GroupLayout jPanel141Layout = new javax.swing.GroupLayout(jPanel141);
        jPanel141.setLayout(jPanel141Layout);
        jPanel141Layout.setHorizontalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel423, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel424, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel425, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel141Layout.setVerticalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel141Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel423)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel424)
                .addGap(12, 12, 12)
                .addComponent(jLabel425)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel142.setBackground(new java.awt.Color(153, 204, 255));
        jPanel142.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel426.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel426.setForeground(new java.awt.Color(102, 102, 102));
        jLabel426.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel426.setText("Phòng 102H1");
        jLabel426.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel426.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel427.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel427.setForeground(new java.awt.Color(102, 102, 102));
        jLabel427.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel427.setText("Đang trống");

        jLabel428.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel428.setForeground(new java.awt.Color(204, 0, 102));
        jLabel428.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel428.setText("Phòng Đôi");

        javax.swing.GroupLayout jPanel142Layout = new javax.swing.GroupLayout(jPanel142);
        jPanel142.setLayout(jPanel142Layout);
        jPanel142Layout.setHorizontalGroup(
            jPanel142Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel426, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel427, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel428, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel142Layout.setVerticalGroup(
            jPanel142Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel142Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel426)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel427)
                .addGap(12, 12, 12)
                .addComponent(jLabel428)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel443.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel443.setForeground(new java.awt.Color(204, 0, 102));
        jLabel443.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel140Layout = new javax.swing.GroupLayout(jPanel140);
        jPanel140.setLayout(jPanel140Layout);
        jPanel140Layout.setHorizontalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel420, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel421, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel140Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel443, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel140Layout.setVerticalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel140Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel420)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel421)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel443)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel140);

        jPanel144.setBackground(new java.awt.Color(153, 204, 255));
        jPanel144.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel144.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel144MouseClicked(evt);
            }
        });

        jLabel432.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel432.setForeground(new java.awt.Color(102, 102, 102));
        jLabel432.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel432.setText("Phòng 110H5");
        jLabel432.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel432.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel433.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel433.setForeground(new java.awt.Color(102, 102, 102));
        jLabel433.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel434.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel434.setForeground(new java.awt.Color(102, 102, 102));
        jLabel434.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel144Layout = new javax.swing.GroupLayout(jPanel144);
        jPanel144.setLayout(jPanel144Layout);
        jPanel144Layout.setHorizontalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel432, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel433, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel434, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel144Layout.setVerticalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel144Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel432)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel433)
                .addGap(12, 12, 12)
                .addComponent(jLabel434)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel144);

        jPanel147.setBackground(new java.awt.Color(153, 204, 255));
        jPanel147.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel147.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel147MouseClicked(evt);
            }
        });

        jLabel441.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel441.setForeground(new java.awt.Color(102, 102, 102));
        jLabel441.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel441.setText("Phòng 111H5");
        jLabel441.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel441.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel442.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel442.setForeground(new java.awt.Color(102, 102, 102));
        jLabel442.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel422.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel422.setForeground(new java.awt.Color(255, 255, 153));
        jLabel422.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel147Layout = new javax.swing.GroupLayout(jPanel147);
        jPanel147.setLayout(jPanel147Layout);
        jPanel147Layout.setHorizontalGroup(
            jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel441, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(jLabel442, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel147Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel422, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel147Layout.setVerticalGroup(
            jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel147Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel441)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel442)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel422)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel147);

        jPanel149.setBackground(new java.awt.Color(153, 204, 255));
        jPanel149.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel149.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel149MouseClicked(evt);
            }
        });

        jLabel447.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel447.setForeground(new java.awt.Color(102, 102, 102));
        jLabel447.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel447.setText("Phòng 112H5");
        jLabel447.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel447.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel448.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel448.setForeground(new java.awt.Color(102, 102, 102));
        jLabel448.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel449.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel449.setForeground(new java.awt.Color(255, 255, 153));
        jLabel449.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel149Layout = new javax.swing.GroupLayout(jPanel149);
        jPanel149.setLayout(jPanel149Layout);
        jPanel149Layout.setHorizontalGroup(
            jPanel149Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel447, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel448, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel449, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel149Layout.setVerticalGroup(
            jPanel149Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel149Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel447)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel448)
                .addGap(12, 12, 12)
                .addComponent(jLabel449)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel149);

        jPanel151.setBackground(new java.awt.Color(153, 204, 255));
        jPanel151.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel151.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel151MouseClicked(evt);
            }
        });

        jLabel453.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel453.setForeground(new java.awt.Color(102, 102, 102));
        jLabel453.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel453.setText("Phòng 113H5");
        jLabel453.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel453.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel454.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel454.setForeground(new java.awt.Color(102, 102, 102));
        jLabel454.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel455.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel455.setForeground(new java.awt.Color(102, 102, 102));
        jLabel455.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel151Layout = new javax.swing.GroupLayout(jPanel151);
        jPanel151.setLayout(jPanel151Layout);
        jPanel151Layout.setHorizontalGroup(
            jPanel151Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel453, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel454, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel455, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel151Layout.setVerticalGroup(
            jPanel151Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel151Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel453)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel454)
                .addGap(12, 12, 12)
                .addComponent(jLabel455)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel151);

        jPanel152.setBackground(new java.awt.Color(153, 204, 255));
        jPanel152.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel152.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel152MouseClicked(evt);
            }
        });

        jLabel456.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel456.setForeground(new java.awt.Color(102, 102, 102));
        jLabel456.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel456.setText("Phòng 114H5");
        jLabel456.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel456.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel457.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel457.setForeground(new java.awt.Color(102, 102, 102));
        jLabel457.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel457.setText("Đang trống");

        jLabel458.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel458.setForeground(new java.awt.Color(204, 0, 102));
        jLabel458.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel152Layout = new javax.swing.GroupLayout(jPanel152);
        jPanel152.setLayout(jPanel152Layout);
        jPanel152Layout.setHorizontalGroup(
            jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel456, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel457, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel458, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel152Layout.setVerticalGroup(
            jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel152Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel456)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel457)
                .addGap(12, 12, 12)
                .addComponent(jLabel458)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTang5.add(jPanel152);

        jRoompanel.add(jPanelTang5);

        jScrollPane2.setViewportView(jRoompanel);

        jRoomTypeCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "VIP", "Đơn", "Đôi" }));
        jRoomTypeCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRoomTypeComboboxActionPerformed(evt);
            }
        });

        jButtonFindRoom.setText("Tìm Phòng");
        jButtonFindRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindRoomActionPerformed(evt);
            }
        });

        jLabel3.setText("Ngày bắt đầu:");

        jLabel4.setText("Ngày Kết Thúc");

        reload.setText("Làm mới");
        reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sidepane, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(reload)
                        .addGap(113, 113, 113)
                        .addComponent(jRoomTypeCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFindRoom)
                        .addGap(18, 18, 18))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidepane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRoomTypeCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonFindRoom)
                        .addComponent(jLabel3)
                        .addComponent(reload))
                    .addComponent(jdateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6))
                    .addComponent(jdateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 4302, Short.MAX_VALUE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 4400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFindRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindRoomActionPerformed
        // TODO add your handling code here:
        checkFindRoom = true;
        String selectedRoomType = (String) jRoomTypeCombobox.getSelectedItem();
        if (jdateStart == null || jdateEnd.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Chọn ngày muốn đặt phòng ");
            return;
        }
        LocalDate now = LocalDate.now();
        startThenFindRoom = jdateStart.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        endThenFindRoom = jdateEnd.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (startThenFindRoom.isBefore(now)) {
            JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải từ ngày hiện tại trở về sau");
        } else if (endThenFindRoom.isBefore(startThenFindRoom) || endThenFindRoom.isEqual(startThenFindRoom)) {
            JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu");
        } else {
            String s = startThenFindRoom.toString();
            String e = endThenFindRoom.toString();
            for (Component component : jRoompanel.getComponents()) {
                if (component instanceof JPanel panel) {
                    for (Component component1 : panel.getComponents()) {
                        if (component1 instanceof JPanel panel1) {
                            int check = 0;
                            for (Component component2 : panel1.getComponents()) {
                                if (selectedRoomType.equals("Tất cả")) {
                                    if (component2 instanceof JLabel label) {
                                        String labelText = label.getText();
                                        if (labelText.contains("Phòng")) {
                                            for (String rnbuf : BookRoomControl.getListRoomNumBerUnFit(s, e)) {
                                                if (labelText.contains(rnbuf)) {
                                                    check++;
                                                    panel1.setVisible(false);
                                                    break;
                                                }
                                            }
                                            if (check == 1) {
                                                break;
                                            }
                                        }
                                    }
                                    if (check == 0 && component2 instanceof JLabel label) {
                                        panel1.setVisible(true);
                                        panel1.setBackground(Color.decode("#99ccff"));
                                        check++;

                                    } else if (check == 1 && component2 instanceof JLabel label) {
                                        label.setText("Đang Trống");
                                        break;

                                    }
                                } else if (component2 instanceof JLabel label) {
                                    String labelText = label.getText();
                                    if (selectedRoomType.equals("VIP") && labelText.contains("Phòng")) {
                                        for (String rnbuf : BookRoomControl.getListNumberRoomFit(s, e, TypeRoomControl.getIDtRoomByName(selectedRoomType))) {
                                            if (labelText.contains(rnbuf)) {
                                                check++;
                                                panel1.setVisible(true);
                                                break;
                                            }
                                        }
                                    } else if (selectedRoomType.equals("Đơn") && labelText.contains("Phòng")) {
                                        for (String rnbuf : BookRoomControl.getListNumberRoomFit(s, e, TypeRoomControl.getIDtRoomByName(selectedRoomType))) {
                                            if (labelText.contains(rnbuf)) {
                                                check++;
                                                panel1.setVisible(true);
                                                break;
                                            }
                                        }
                                    } else if (selectedRoomType.equals("Đôi") && labelText.contains("Phòng")) {
                                        for (String rnbuf : BookRoomControl.getListNumberRoomFit(s, e, TypeRoomControl.getIDtRoomByName(selectedRoomType))) {
                                            if (labelText.contains(rnbuf)) {
                                                check++;
                                                panel1.setVisible(true);
                                                break;
                                            }
                                        }
                                    } else if (check == 1 && component2 instanceof JLabel label1) {
                                        label1.setText("Đang Trống");
                                        break;
                                    } else if (check == 0) {
                                        panel1.setVisible(false);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonFindRoomActionPerformed

    private void jRoomTypeComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRoomTypeComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRoomTypeComboboxActionPerformed

    private void jPanel152MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel152MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel152.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel152, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel152MouseClicked

    private void jPanel151MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel151MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel151.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel151, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel151MouseClicked

    private void jPanel149MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel149MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel149.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel149, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel149MouseClicked

    private void jPanel147MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel147MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel147.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel147, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel147MouseClicked

    private void jPanel144MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel144MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel144.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel144, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel144MouseClicked

    private void jPanel140MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel140MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel140.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel140, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel140MouseClicked

    private void jPanel143MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel143MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel143.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel143, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel143MouseClicked

    private void jPanel153MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel153MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel153.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel153, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel153MouseClicked

    private void jPanel150MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel150MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel150.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel150, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel150MouseClicked

    private void jPanel148MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel148MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel148.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel148, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel148MouseClicked

    private void jPanel146MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel146MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel146.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel146, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel146MouseClicked

    private void jPanel145MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel145MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel145.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel145, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel145MouseClicked

    private void jPanel138MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel138MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel138.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel138, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel138MouseClicked

    private void jPanel137MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel137MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel137.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel137, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel137MouseClicked

    private void jPanel131MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel131MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel131.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel131, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel131MouseClicked

    private void jPanel134MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel134MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel134.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel134, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel134MouseClicked

    private void jPanel132MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel132MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel132.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel132, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel132MouseClicked

    private void jPanel130MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel130MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel130.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel130, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel130MouseClicked

    private void jPanel127MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel127MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel127.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel127, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel127MouseClicked

    private void jPanel123MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel123MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel123.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel123, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel123MouseClicked

    private void jPanel126MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel126MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel126.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel126, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel126MouseClicked

    private void jPanel136MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel136MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel136.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel136, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel136MouseClicked

    private void jPanel133MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel133MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel133.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel133, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel133MouseClicked

    private void jPanel129MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel129MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel129.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel129, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel129MouseClicked

    private void jPanel128MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel128MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel128.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel128, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel128MouseClicked

    private void jPanel121MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel121MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel121.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel121, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel121MouseClicked

    private void jPanel120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel120MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel120.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel120, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel120MouseClicked

    private void jPanel135MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel135MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel135.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel135, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel135MouseClicked

    private void jPanel118MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel118MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel118.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel118, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel118MouseClicked

    private void jPanel117MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel117MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel117.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel117, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel117MouseClicked

    private void jPanel119MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel119MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel119.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel119, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel119MouseClicked

    private void jPanel116MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel116MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel116.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel116, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel116MouseClicked

    private void jPanel113MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel113MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel113.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel113, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel113MouseClicked

    private void jPanel110MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel110MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel110.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel110, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel110MouseClicked

    private void jPanel106MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel106MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel106.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel106, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel106MouseClicked

    private void jPanel109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel109MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel109.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel109, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel109MouseClicked

    private void jPanel114MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel114MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel114.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel114, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel114MouseClicked

    private void jPanel112MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel112MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel112.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel112, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel112MouseClicked

    private void jPanel111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel111MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel111.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel111, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel111MouseClicked

    private void jPanel115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel115MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel115.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel115, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel115MouseClicked

    private void jPanel105MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel105MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel105.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel105, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel105MouseClicked

    private void jPanel104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel104MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel104.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel104, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel104MouseClicked

    private void jPanel93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel93MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel93.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel93, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel93MouseClicked

    private void jPanel101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel101MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel101.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel101, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel101MouseClicked

    private void jPanel95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel95MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel95.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel95, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel95MouseClicked

    private void jPanel94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel94MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel94.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel94, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel94MouseClicked

    private void jPanel97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel97MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel99.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel99, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel97MouseClicked

    private void jPanel99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel99MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel99.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel99, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel99MouseClicked

    private void jPanel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel102MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel102.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel102, evt.getX(),evt.getY());
    }//GEN-LAST:event_jPanel102MouseClicked

    private void jPanel103MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel103MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel103.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel103, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel103MouseClicked

    private void jPanel100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel100MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel100.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel100, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel100MouseClicked

    private void jPanel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel98MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel98.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel98, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel98MouseClicked

    private void jPanel96MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel96MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel96.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel96, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel96MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel10.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel10, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel12.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel12, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel11.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel11, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel20.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel20, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel16.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel16, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel19.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel19, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel19MouseClicked

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel18.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel18, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel15.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel15, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel14.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel14, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel13.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel13, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel13MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel9.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel9, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel8.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel8, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel7.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel7, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel6.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel6, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel5.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel5, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // TODO add your handling code here:
        for (Component component : jPanel17.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        //JOptionPane.showMessageDialog(jRoompanel, //jPopupMenuRoom.getName());
        jPopupMenuRoom.show(jPanel17, evt.getX(), evt.getY());

    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseReleased

    private void jPopupMenu1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPopupMenu1
        // TODO add your handling code here:
        for (Component component : jPanel2.getComponents()) {
            if (component instanceof JLabel label) {
                String nameRoom = label.getText();
                if (nameRoom.contains("Phòng")) {
                    jPopupMenuRoom.setName(nameRoom);
                    break;
                }

            }
        }
        jPopupMenuRoom.show(jPanel2, evt.getX(), evt.getY());
    }//GEN-LAST:event_jPopupMenu1

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadActionPerformed
        // TODO add your handling code here:
        for (Component component : jRoompanel.getComponents()) {
            if (component instanceof JPanel panel) {
                for (Component component1 : panel.getComponents()) {
                    if (component1 instanceof JPanel panel1) {
                        panel1.setVisible(true);
                    }
                }
            }
        }
        reload();
    }//GEN-LAST:event_reloadActionPerformed

    private void btn_tkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tkMouseClicked
        // TODO add your handling code here:
        FormTTKhach f = new FormTTKhach(username);
        f.show();
    }//GEN-LAST:event_btn_tkMouseClicked

    private void btn_tkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tkMousePressed
        // TODO add your handling code here:
        setColor(btn_tk);
        resetColor(btn_changepass);
    }//GEN-LAST:event_btn_tkMousePressed

    private void btn_changepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_changepassMouseClicked
        // TODO add your handling code here:
        FormDoiMatKhau f = new FormDoiMatKhau(username);
        f.show();
    }//GEN-LAST:event_btn_changepassMouseClicked

    private void btn_changepassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_changepassMousePressed
        // TODO add your handling code here:
        setColor(btn_changepass);
        resetColor(btn_tk);
    }//GEN-LAST:event_btn_changepassMousePressed

    private void datphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datphongActionPerformed
        // TODO add your handling code here:
        if (checkFindRoom) {
            FormDatPhong f = new FormDatPhong(Date.from(startThenFindRoom.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
                    Date.from(endThenFindRoom.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), g.getId());
            f.setName(jPopupMenuRoom.getName());
            f.show();
            checkFindRoom = false;
        } else {
            JOptionPane.showMessageDialog(null, "Hãy Tìm Phòng Trước Khi Đặt");
        }
    }//GEN-LAST:event_datphongActionPerformed

    void setColor(JPanel panel) {
        panel.setBackground(new Color(85, 65, 118));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(64, 43, 100));
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuestHomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuestHomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuestHomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuestHomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuestHomeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelTang2;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btn_changepass;
    private javax.swing.JPanel btn_tk;
    private javax.swing.JMenuItem datphong;
    private javax.swing.JButton jButtonFindRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JLabel jLabel308;
    private javax.swing.JLabel jLabel309;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel310;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel314;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel317;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel319;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel320;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel323;
    private javax.swing.JLabel jLabel324;
    private javax.swing.JLabel jLabel325;
    private javax.swing.JLabel jLabel326;
    private javax.swing.JLabel jLabel327;
    private javax.swing.JLabel jLabel328;
    private javax.swing.JLabel jLabel329;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel330;
    private javax.swing.JLabel jLabel331;
    private javax.swing.JLabel jLabel332;
    private javax.swing.JLabel jLabel333;
    private javax.swing.JLabel jLabel334;
    private javax.swing.JLabel jLabel335;
    private javax.swing.JLabel jLabel336;
    private javax.swing.JLabel jLabel337;
    private javax.swing.JLabel jLabel338;
    private javax.swing.JLabel jLabel339;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel340;
    private javax.swing.JLabel jLabel341;
    private javax.swing.JLabel jLabel342;
    private javax.swing.JLabel jLabel343;
    private javax.swing.JLabel jLabel344;
    private javax.swing.JLabel jLabel345;
    private javax.swing.JLabel jLabel346;
    private javax.swing.JLabel jLabel347;
    private javax.swing.JLabel jLabel348;
    private javax.swing.JLabel jLabel349;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel350;
    private javax.swing.JLabel jLabel351;
    private javax.swing.JLabel jLabel352;
    private javax.swing.JLabel jLabel353;
    private javax.swing.JLabel jLabel354;
    private javax.swing.JLabel jLabel355;
    private javax.swing.JLabel jLabel356;
    private javax.swing.JLabel jLabel357;
    private javax.swing.JLabel jLabel358;
    private javax.swing.JLabel jLabel359;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel360;
    private javax.swing.JLabel jLabel361;
    private javax.swing.JLabel jLabel362;
    private javax.swing.JLabel jLabel363;
    private javax.swing.JLabel jLabel364;
    private javax.swing.JLabel jLabel365;
    private javax.swing.JLabel jLabel366;
    private javax.swing.JLabel jLabel367;
    private javax.swing.JLabel jLabel368;
    private javax.swing.JLabel jLabel369;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel370;
    private javax.swing.JLabel jLabel371;
    private javax.swing.JLabel jLabel372;
    private javax.swing.JLabel jLabel373;
    private javax.swing.JLabel jLabel374;
    private javax.swing.JLabel jLabel375;
    private javax.swing.JLabel jLabel376;
    private javax.swing.JLabel jLabel377;
    private javax.swing.JLabel jLabel378;
    private javax.swing.JLabel jLabel379;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel380;
    private javax.swing.JLabel jLabel381;
    private javax.swing.JLabel jLabel382;
    private javax.swing.JLabel jLabel383;
    private javax.swing.JLabel jLabel384;
    private javax.swing.JLabel jLabel385;
    private javax.swing.JLabel jLabel386;
    private javax.swing.JLabel jLabel387;
    private javax.swing.JLabel jLabel388;
    private javax.swing.JLabel jLabel389;
    private javax.swing.JLabel jLabel390;
    private javax.swing.JLabel jLabel391;
    private javax.swing.JLabel jLabel392;
    private javax.swing.JLabel jLabel393;
    private javax.swing.JLabel jLabel394;
    private javax.swing.JLabel jLabel395;
    private javax.swing.JLabel jLabel396;
    private javax.swing.JLabel jLabel397;
    private javax.swing.JLabel jLabel398;
    private javax.swing.JLabel jLabel399;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel400;
    private javax.swing.JLabel jLabel401;
    private javax.swing.JLabel jLabel402;
    private javax.swing.JLabel jLabel403;
    private javax.swing.JLabel jLabel404;
    private javax.swing.JLabel jLabel405;
    private javax.swing.JLabel jLabel406;
    private javax.swing.JLabel jLabel407;
    private javax.swing.JLabel jLabel408;
    private javax.swing.JLabel jLabel409;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel410;
    private javax.swing.JLabel jLabel411;
    private javax.swing.JLabel jLabel412;
    private javax.swing.JLabel jLabel413;
    private javax.swing.JLabel jLabel414;
    private javax.swing.JLabel jLabel415;
    private javax.swing.JLabel jLabel416;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel420;
    private javax.swing.JLabel jLabel421;
    private javax.swing.JLabel jLabel422;
    private javax.swing.JLabel jLabel423;
    private javax.swing.JLabel jLabel424;
    private javax.swing.JLabel jLabel425;
    private javax.swing.JLabel jLabel426;
    private javax.swing.JLabel jLabel427;
    private javax.swing.JLabel jLabel428;
    private javax.swing.JLabel jLabel429;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel430;
    private javax.swing.JLabel jLabel431;
    private javax.swing.JLabel jLabel432;
    private javax.swing.JLabel jLabel433;
    private javax.swing.JLabel jLabel434;
    private javax.swing.JLabel jLabel435;
    private javax.swing.JLabel jLabel436;
    private javax.swing.JLabel jLabel437;
    private javax.swing.JLabel jLabel438;
    private javax.swing.JLabel jLabel439;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel440;
    private javax.swing.JLabel jLabel441;
    private javax.swing.JLabel jLabel442;
    private javax.swing.JLabel jLabel443;
    private javax.swing.JLabel jLabel444;
    private javax.swing.JLabel jLabel445;
    private javax.swing.JLabel jLabel446;
    private javax.swing.JLabel jLabel447;
    private javax.swing.JLabel jLabel448;
    private javax.swing.JLabel jLabel449;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel450;
    private javax.swing.JLabel jLabel451;
    private javax.swing.JLabel jLabel452;
    private javax.swing.JLabel jLabel453;
    private javax.swing.JLabel jLabel454;
    private javax.swing.JLabel jLabel455;
    private javax.swing.JLabel jLabel456;
    private javax.swing.JLabel jLabel457;
    private javax.swing.JLabel jLabel458;
    private javax.swing.JLabel jLabel459;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel460;
    private javax.swing.JLabel jLabel461;
    private javax.swing.JLabel jLabel462;
    private javax.swing.JLabel jLabel463;
    private javax.swing.JLabel jLabel464;
    private javax.swing.JLabel jLabel465;
    private javax.swing.JLabel jLabel466;
    private javax.swing.JLabel jLabel467;
    private javax.swing.JLabel jLabel468;
    private javax.swing.JLabel jLabel469;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel470;
    private javax.swing.JLabel jLabel471;
    private javax.swing.JLabel jLabel472;
    private javax.swing.JLabel jLabel473;
    private javax.swing.JLabel jLabel474;
    private javax.swing.JLabel jLabel475;
    private javax.swing.JLabel jLabel476;
    private javax.swing.JLabel jLabel477;
    private javax.swing.JLabel jLabel478;
    private javax.swing.JLabel jLabel479;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel480;
    private javax.swing.JLabel jLabel481;
    private javax.swing.JLabel jLabel482;
    private javax.swing.JLabel jLabel483;
    private javax.swing.JLabel jLabel484;
    private javax.swing.JLabel jLabel485;
    private javax.swing.JLabel jLabel486;
    private javax.swing.JLabel jLabel487;
    private javax.swing.JLabel jLabel488;
    private javax.swing.JLabel jLabel489;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel490;
    private javax.swing.JLabel jLabel491;
    private javax.swing.JLabel jLabel492;
    private javax.swing.JLabel jLabel493;
    private javax.swing.JLabel jLabel494;
    private javax.swing.JLabel jLabel495;
    private javax.swing.JLabel jLabel496;
    private javax.swing.JLabel jLabel497;
    private javax.swing.JLabel jLabel498;
    private javax.swing.JLabel jLabel499;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel500;
    private javax.swing.JLabel jLabel501;
    private javax.swing.JLabel jLabel502;
    private javax.swing.JLabel jLabel503;
    private javax.swing.JLabel jLabel504;
    private javax.swing.JLabel jLabel505;
    private javax.swing.JLabel jLabel506;
    private javax.swing.JLabel jLabel507;
    private javax.swing.JLabel jLabel508;
    private javax.swing.JLabel jLabel509;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabelP1T1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel148;
    private javax.swing.JPanel jPanel149;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel150;
    private javax.swing.JPanel jPanel151;
    private javax.swing.JPanel jPanel152;
    private javax.swing.JPanel jPanel153;
    private javax.swing.JPanel jPanel154;
    private javax.swing.JPanel jPanel155;
    private javax.swing.JPanel jPanel156;
    private javax.swing.JPanel jPanel157;
    private javax.swing.JPanel jPanel158;
    private javax.swing.JPanel jPanel159;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel160;
    private javax.swing.JPanel jPanel161;
    private javax.swing.JPanel jPanel162;
    private javax.swing.JPanel jPanel163;
    private javax.swing.JPanel jPanel164;
    private javax.swing.JPanel jPanel165;
    private javax.swing.JPanel jPanel166;
    private javax.swing.JPanel jPanel167;
    private javax.swing.JPanel jPanel168;
    private javax.swing.JPanel jPanel169;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JPanel jPanelTang1;
    private javax.swing.JPanel jPanelTang3;
    private javax.swing.JPanel jPanelTang4;
    private javax.swing.JPanel jPanelTang5;
    private javax.swing.JPopupMenu jPopupMenuRoom;
    private javax.swing.JComboBox<String> jRoomTypeCombobox;
    private javax.swing.JPanel jRoompanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private com.toedter.calendar.JDateChooser jdateEnd;
    private com.toedter.calendar.JDateChooser jdateStart;
    private javax.swing.JTextField jname;
    private javax.swing.JButton reload;
    private javax.swing.JPanel sidepane;
    // End of variables declaration//GEN-END:variables
}
