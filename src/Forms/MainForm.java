package Forms;

import Entity.User;
import Forms.Panels.Debts;
import Forms.Panels.InComes;
import Forms.Panels.Loans;
import Forms.Panels.Notes;
import Forms.Panels.Spends;
import Forms.Panels.Users;
import Library.Helper;
import Library.State;
import Model.MainFormModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import javax.swing.JOptionPane;

/**
 *
 * @author Trieu Tai Niem
 */
public class MainForm extends javax.swing.JFrame {
    User _currentUser = null;
    Point initialClick;
    MainFormModel mainFormModel = new MainFormModel();
    
    GridBagLayout gridBagLayout = new GridBagLayout();
    Dimension contentSize;
    
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        contentSize = TabContent.getSize();
        //
        State.userAmount = lbTotal;
        
        initTabContent(new InComes());
        TabBarItem1.setBackground(new Color(0, 153, 153));
        lbUsername.setText(State.currentUser.getUsername().toUpperCase());
        lbTotal.setText(Helper.currencyFormat(mainFormModel.totalUserAmount()));
        
        if(State.currentUser.getRole() != 1) 
            TabBarItem8.setVisible(false);
    }

    private void initTabContent(javax.swing.JPanel panel) {
        TabContent.setLayout(gridBagLayout);
        TabContent.removeAll();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel.setPreferredSize(contentSize);
        TabContent.add(panel, gridBagConstraints);
        TabContent.updateUI();
    }
    
    private void resetTabItemStyle() {
        //initTabContent(new Spends());
        TabBarItem1.setBackground(new Color(0, 102,102));
        TabBarItem2.setBackground(new Color(0, 102,102));
        TabBarItem3.setBackground(new Color(0, 102,102));
        TabBarItem4.setBackground(new Color(0, 102,102));
        TabBarItem5.setBackground(new Color(0, 102,102));
        TabBarItem8.setBackground(new Color(0, 102,102));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        Container = new javax.swing.JPanel();
        TabBar = new javax.swing.JPanel();
        lbUsername = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TabBarItem1 = new javax.swing.JPanel();
        Item1Label = new javax.swing.JLabel();
        ItemIcon1 = new javax.swing.JLabel();
        TabBarItem2 = new javax.swing.JPanel();
        ItemLabel2 = new javax.swing.JLabel();
        ItemIcon2 = new javax.swing.JLabel();
        TabBarItem3 = new javax.swing.JPanel();
        ItemLabel3 = new javax.swing.JLabel();
        ItemIcon3 = new javax.swing.JLabel();
        TabBarItem4 = new javax.swing.JPanel();
        ItemLabel4 = new javax.swing.JLabel();
        ItemIcon4 = new javax.swing.JLabel();
        TabBarItem5 = new javax.swing.JPanel();
        ItemLabel5 = new javax.swing.JLabel();
        ItemIcon5 = new javax.swing.JLabel();
        TabBarItem8 = new javax.swing.JPanel();
        ItemLabel8 = new javax.swing.JLabel();
        ItemIcon8 = new javax.swing.JLabel();
        TabBarItem7 = new javax.swing.JPanel();
        ItemLabel7 = new javax.swing.JLabel();
        ItemIcon7 = new javax.swing.JLabel();
        TabContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý tài chính cá nhân");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(500, 300));
        setResizable(false);

        Container.setAlignmentX(0.0F);
        Container.setAlignmentY(0.0F);

        TabBar.setBackground(new java.awt.Color(0, 102, 102));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, Container, org.jdesktop.beansbinding.ELProperty.create("${preferredSize}"), TabBar, org.jdesktop.beansbinding.BeanProperty.create("preferredSize"));
        bindingGroup.addBinding(binding);

        lbUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(255, 255, 255));
        lbUsername.setText("TRIEUNIEMIT");

        lbTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(204, 204, 204));
        lbTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/dollar.png"))); // NOI18N
        lbTotal.setText("9.999.999.999");
        lbTotal.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><p style=\"text-align: center\">Deverlope by Trieu Tai Niem and Ho Sy Huy. Version 1.0</p></html>");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TabBarItem1.setBackground(new java.awt.Color(0, 102, 102));
        TabBarItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabBarItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabBarItem1MousePressed(evt);
            }
        });

        Item1Label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Item1Label.setForeground(new java.awt.Color(255, 255, 255));
        Item1Label.setText("Thu nhập");

        ItemIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/card.png"))); // NOI18N

        javax.swing.GroupLayout TabBarItem1Layout = new javax.swing.GroupLayout(TabBarItem1);
        TabBarItem1.setLayout(TabBarItem1Layout);
        TabBarItem1Layout.setHorizontalGroup(
            TabBarItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ItemIcon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Item1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarItem1Layout.setVerticalGroup(
            TabBarItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabBarItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Item1Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemIcon1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabBarItem2.setBackground(new java.awt.Color(0, 102, 102));
        TabBarItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabBarItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabBarItem2MousePressed(evt);
            }
        });

        ItemLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ItemLabel2.setForeground(new java.awt.Color(255, 255, 255));
        ItemLabel2.setText("Chi tiêu");

        ItemIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/spend.png"))); // NOI18N

        javax.swing.GroupLayout TabBarItem2Layout = new javax.swing.GroupLayout(TabBarItem2);
        TabBarItem2.setLayout(TabBarItem2Layout);
        TabBarItem2Layout.setHorizontalGroup(
            TabBarItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ItemIcon2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarItem2Layout.setVerticalGroup(
            TabBarItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabBarItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ItemLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemIcon2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabBarItem3.setBackground(new java.awt.Color(0, 102, 102));
        TabBarItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabBarItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabBarItem3MousePressed(evt);
            }
        });

        ItemLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ItemLabel3.setForeground(new java.awt.Color(255, 255, 255));
        ItemLabel3.setText("Vay mượn");

        ItemIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/debt.png"))); // NOI18N

        javax.swing.GroupLayout TabBarItem3Layout = new javax.swing.GroupLayout(TabBarItem3);
        TabBarItem3.setLayout(TabBarItem3Layout);
        TabBarItem3Layout.setHorizontalGroup(
            TabBarItem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ItemIcon3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarItem3Layout.setVerticalGroup(
            TabBarItem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabBarItem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ItemLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemIcon3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabBarItem4.setBackground(new java.awt.Color(0, 102, 102));
        TabBarItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabBarItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabBarItem4MousePressed(evt);
            }
        });

        ItemLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ItemLabel4.setForeground(new java.awt.Color(255, 255, 255));
        ItemLabel4.setText("Cho vay");

        ItemIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/loan.png"))); // NOI18N

        javax.swing.GroupLayout TabBarItem4Layout = new javax.swing.GroupLayout(TabBarItem4);
        TabBarItem4.setLayout(TabBarItem4Layout);
        TabBarItem4Layout.setHorizontalGroup(
            TabBarItem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ItemIcon4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarItem4Layout.setVerticalGroup(
            TabBarItem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabBarItem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ItemLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemIcon4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabBarItem5.setBackground(new java.awt.Color(0, 102, 102));
        TabBarItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabBarItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabBarItem5MousePressed(evt);
            }
        });

        ItemLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ItemLabel5.setForeground(new java.awt.Color(255, 255, 255));
        ItemLabel5.setText("Ghi chú");

        ItemIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/note.png"))); // NOI18N

        javax.swing.GroupLayout TabBarItem5Layout = new javax.swing.GroupLayout(TabBarItem5);
        TabBarItem5.setLayout(TabBarItem5Layout);
        TabBarItem5Layout.setHorizontalGroup(
            TabBarItem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarItem5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ItemIcon5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarItem5Layout.setVerticalGroup(
            TabBarItem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabBarItem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ItemLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemIcon5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabBarItem8.setBackground(new java.awt.Color(0, 102, 102));
        TabBarItem8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabBarItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabBarItem8MousePressed(evt);
            }
        });

        ItemLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ItemLabel8.setForeground(new java.awt.Color(255, 255, 255));
        ItemLabel8.setText("Người dùng");

        ItemIcon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/user_2.png"))); // NOI18N

        javax.swing.GroupLayout TabBarItem8Layout = new javax.swing.GroupLayout(TabBarItem8);
        TabBarItem8.setLayout(TabBarItem8Layout);
        TabBarItem8Layout.setHorizontalGroup(
            TabBarItem8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarItem8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ItemIcon8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TabBarItem8Layout.setVerticalGroup(
            TabBarItem8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabBarItem8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ItemLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemIcon8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabBarItem7.setBackground(new java.awt.Color(0, 102, 102));
        TabBarItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabBarItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabBarItem7MousePressed(evt);
            }
        });

        ItemLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ItemLabel7.setForeground(new java.awt.Color(255, 255, 255));
        ItemLabel7.setText("Đăng xuất");

        ItemIcon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/shutdown.png"))); // NOI18N

        javax.swing.GroupLayout TabBarItem7Layout = new javax.swing.GroupLayout(TabBarItem7);
        TabBarItem7.setLayout(TabBarItem7Layout);
        TabBarItem7Layout.setHorizontalGroup(
            TabBarItem7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ItemIcon7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        TabBarItem7Layout.setVerticalGroup(
            TabBarItem7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem7Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(TabBarItem7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ItemLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemIcon7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout TabBarLayout = new javax.swing.GroupLayout(TabBar);
        TabBar.setLayout(TabBarLayout);
        TabBarLayout.setHorizontalGroup(
            TabBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TabBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(TabBarItem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabBarItem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabBarItem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabBarItem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabBarItem5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabBarItem8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabBarItem7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TabBarLayout.setVerticalGroup(
            TabBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(TabBarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabBarItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabBarItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabBarItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabBarItem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabBarItem8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabBarItem7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TabContent.setOpaque(false);

        javax.swing.GroupLayout TabContentLayout = new javax.swing.GroupLayout(TabContent);
        TabContent.setLayout(TabContentLayout);
        TabContentLayout.setHorizontalGroup(
            TabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
        );
        TabContentLayout.setVerticalGroup(
            TabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addComponent(TabBar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContainerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(TabBar, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabBarItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabBarItem1MousePressed
        // TODO add your handling code here:
        resetTabItemStyle();
        evt.getComponent().setBackground(new Color(0, 153, 153));
        initTabContent(new InComes());
    }//GEN-LAST:event_TabBarItem1MousePressed

    private void TabBarItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabBarItem2MousePressed
        // TODO add your handling code here:
        resetTabItemStyle();
        evt.getComponent().setBackground(new Color(0, 153, 153));
        initTabContent(new Spends());
    }//GEN-LAST:event_TabBarItem2MousePressed

    private void TabBarItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabBarItem3MousePressed
        // TODO add your handling code here:
        resetTabItemStyle();
        evt.getComponent().setBackground(new Color(0, 153, 153));
        initTabContent(new Debts());
    }//GEN-LAST:event_TabBarItem3MousePressed

    private void TabBarItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabBarItem4MousePressed
        // TODO add your handling code here:
        resetTabItemStyle();
        evt.getComponent().setBackground(new Color(0, 153, 153));
        initTabContent(new Loans());
    }//GEN-LAST:event_TabBarItem4MousePressed

    private void TabBarItem5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabBarItem5MousePressed
        // TODO add your handling code here:
        resetTabItemStyle();
        evt.getComponent().setBackground(new Color(0, 153, 153));
        initTabContent(new Notes());
    }//GEN-LAST:event_TabBarItem5MousePressed

    private void TabBarItem7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabBarItem7MousePressed
        int resuiltConfirm = JOptionPane.showConfirmDialog(this, "Bạn sẽ đăng xuất khỏi hệ thống?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(resuiltConfirm != 1) {
            State.currentUser = null;
            new LoginForm().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_TabBarItem7MousePressed

    private void TabBarItem8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabBarItem8MousePressed
        // TODO add your handling code here:
        resetTabItemStyle();
        evt.getComponent().setBackground(new Color(0, 153, 153));
        initTabContent(new Users());
    }//GEN-LAST:event_TabBarItem8MousePressed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JLabel Item1Label;
    private javax.swing.JLabel ItemIcon1;
    private javax.swing.JLabel ItemIcon2;
    private javax.swing.JLabel ItemIcon3;
    private javax.swing.JLabel ItemIcon4;
    private javax.swing.JLabel ItemIcon5;
    private javax.swing.JLabel ItemIcon7;
    private javax.swing.JLabel ItemIcon8;
    private javax.swing.JLabel ItemLabel2;
    private javax.swing.JLabel ItemLabel3;
    private javax.swing.JLabel ItemLabel4;
    private javax.swing.JLabel ItemLabel5;
    private javax.swing.JLabel ItemLabel7;
    private javax.swing.JLabel ItemLabel8;
    private javax.swing.JPanel TabBar;
    private javax.swing.JPanel TabBarItem1;
    private javax.swing.JPanel TabBarItem2;
    private javax.swing.JPanel TabBarItem3;
    private javax.swing.JPanel TabBarItem4;
    private javax.swing.JPanel TabBarItem5;
    private javax.swing.JPanel TabBarItem7;
    private javax.swing.JPanel TabBarItem8;
    private javax.swing.JPanel TabContent;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbUsername;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
