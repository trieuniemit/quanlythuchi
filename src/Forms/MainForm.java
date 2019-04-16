package Forms;

import Entity.User;
import Forms.Panels.Debts;
import Forms.Panels.InComes;
import Forms.Panels.Loans;
import Forms.Panels.Notes;
import Forms.Panels.Spends;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;

/**
 *
 * @author Trieu Tai Niem
 */
public class MainForm extends javax.swing.JFrame {
    User _currentUser = null;
    private Point initialClick;
    
    GridBagLayout gridBagLayout = new GridBagLayout();
    Dimension contentSize;
    
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    /**
     * @param user
     */
    public MainForm(User user) {
        initComponents();
        setLocationRelativeTo(null);
        _currentUser = user;
        contentSize = TabContent.getSize();
        initTabContent(new InComes());
        TabBarItem1.setBackground(new Color(0, 153, 153));
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
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        Container = new javax.swing.JPanel();
        TabBar = new javax.swing.JPanel();
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
        lbUsername = new javax.swing.JLabel();
        tbTotal = new javax.swing.JLabel();
        TabBarItem5 = new javax.swing.JPanel();
        ItemLabel5 = new javax.swing.JLabel();
        ItemIcon5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TabContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý tài chính cá nhân");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(500, 300));

        Container.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Container.setAlignmentX(0.0F);
        Container.setAlignmentY(0.0F);

        TabBar.setBackground(new java.awt.Color(0, 102, 102));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, Container, org.jdesktop.beansbinding.ELProperty.create("${preferredSize}"), TabBar, org.jdesktop.beansbinding.BeanProperty.create("preferredSize"));
        bindingGroup.addBinding(binding);

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
                .addContainerGap())
        );
        TabBarItem1Layout.setVerticalGroup(
            TabBarItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabBarItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Item1Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemIcon1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(ItemIcon2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(ItemIcon3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(ItemIcon4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lbUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(255, 255, 255));
        lbUsername.setText("TRIEUNIEMIT");

        tbTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbTotal.setForeground(new java.awt.Color(204, 204, 204));
        tbTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/dollar.png"))); // NOI18N
        tbTotal.setText("9.999.999.999");
        tbTotal.setToolTipText("");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarItem5Layout.createSequentialGroup()
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
                    .addComponent(ItemIcon5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><p style=\"text-align: center\">Deverlope by Trieu Tai Niem and Ho Sy Huy. Version 1.0</p></html>");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TabBarLayout = new javax.swing.GroupLayout(TabBar);
        TabBar.setLayout(TabBarLayout);
        TabBarLayout.setHorizontalGroup(
            TabBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabBarItem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabBarItem2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabBarItem3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabBarItem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabBarItem5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(TabBarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(TabBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        TabBarLayout.setVerticalGroup(
            TabBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(TabBarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(TabBarItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(TabBarItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(TabBarItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(TabBarItem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TabContent.setOpaque(false);

        javax.swing.GroupLayout TabContentLayout = new javax.swing.GroupLayout(TabContent);
        TabContent.setLayout(TabContentLayout);
        TabContentLayout.setHorizontalGroup(
            TabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );
        TabContentLayout.setVerticalGroup(
            TabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addComponent(TabBar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContainerLayout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(TabContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 0, Short.MAX_VALUE))
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
    private javax.swing.JLabel ItemLabel2;
    private javax.swing.JLabel ItemLabel3;
    private javax.swing.JLabel ItemLabel4;
    private javax.swing.JLabel ItemLabel5;
    private javax.swing.JPanel TabBar;
    private javax.swing.JPanel TabBarItem1;
    private javax.swing.JPanel TabBarItem2;
    private javax.swing.JPanel TabBarItem3;
    private javax.swing.JPanel TabBarItem4;
    private javax.swing.JPanel TabBarItem5;
    private javax.swing.JPanel TabContent;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel tbTotal;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
