package Forms.Panels;

import Entity.User;
import Library.Helper;
//import Library.WordWrapCellRenderer;
import Model.UsersModel;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trieu Tai Niem
 */
public class Users extends javax.swing.JPanel {
    UsersModel usersModel = new UsersModel();
    
    public static ArrayList<User> usersShowInTable;
            
    public Users() {
        initComponents();
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("Mật khẩu...")) {
                    passwordField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Mật khẩu...");
                }
            }
        });
        
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals("Tên tài khoản...")) {
                    usernameField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setText("Tên tài khoản...");
                }
            }
        });
        
        initTableStyles();
       
        //view all
        getAllUsers();
        
        //set visible for delete button
        btnDelete.setVisible(false);
        //add event for edit table
        usersTable.getModel().addTableModelListener(new UsersTableModelListener(usersTable, this));
    }
    
    private  void initTableStyles() {
        usersTable.getTableHeader().setPreferredSize(new Dimension(100, 30));
        usersTable.getColumnModel().getColumn(0).setMaxWidth(50);
        usersTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        usersTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        usersTable.getColumnModel().getColumn(3).setPreferredWidth(70);
        
        //set align for column of table
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        usersTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        usersTable.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
    }
    
    public void getAllUsers() {
        usersShowInTable = usersModel.getAllUsers();
        showDebtsToTable(usersShowInTable);
    }
    
    private void showDebtsToTable(ArrayList<User> data) {
        DefaultTableModel tableModel = (DefaultTableModel) usersTable.getModel();
        tableModel.setRowCount(0);
        int rowIndex = 0;
        for(User row: data) {
            tableModel.addRow(new Object[] {
                ++rowIndex, 
                row.getUsername(),
                "**********", 
                (row.getRole()==1),
                row.getCreatedAt()
            });
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        passwordField = new javax.swing.JTextField();
        btnAddNewUser = new javax.swing.JButton();
        btnDelete = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        cbbRole = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý người dùng");

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên tài khoản", "Mật khẩu", "Quyền quản trị", "Thời gian tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usersTable.setFocusable(false);
        usersTable.setRowHeight(30);
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usersTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(usersTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordField.setText("Mật khẩu...");
        passwordField.setPreferredSize(new java.awt.Dimension(102, 31));

        btnAddNewUser.setBackground(new java.awt.Color(0, 102, 102));
        btnAddNewUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddNewUser.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewUser.setText("Thêm mới");
        btnAddNewUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddNewUser.setFocusable(false);
        btnAddNewUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddNewUserMousePressed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/delete.png"))); // NOI18N
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDeleteMousePressed(evt);
            }
        });

        usernameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameField.setText("Tên tài khoản...");
        usernameField.setPreferredSize(new java.awt.Dimension(102, 31));

        cbbRole.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản trị", "Người dùng" }));
        cbbRole.setSelectedIndex(1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDelete)
                .addGap(136, 136, 136)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddNewUser)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbRole))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewUserMousePressed
        if(usernameField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()) {
            showMessageDialog(this, "Tên người dùng và mật khẩu không được phép để trống.", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        User user = new User(
            -1,
            usernameField.getText(),
            passwordField.getText(),
            cbbRole.getSelectedIndex() + 1
        );
        
        if(!usersModel.insertNewUser(user)) {
            showMessageDialog(this, "Tên người dùng đã tồn tại hoặc có lỗi bất ngờ xảy ra.", "Lỗi!", JOptionPane.ERROR_MESSAGE);
        } else {
            getAllUsers();
        }
    }//GEN-LAST:event_btnAddNewUserMousePressed

    private void usersTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMousePressed
        if(usersTable.getSelectedRow() >= 0) {
            btnDelete.setVisible(true);
        }
    }//GEN-LAST:event_usersTableMousePressed

    private void btnDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMousePressed
        int resuiltConfirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa các mục đã chọn?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(resuiltConfirm != 1) {
            
            int[] selectedRows = usersTable.getSelectedRows();
            //delete in database
            for(int row: selectedRows) {
                usersModel.deteteUsers(usersShowInTable.get(row).getId());
            }
            
            //delete in table
            DefaultTableModel tableModel = (DefaultTableModel) usersTable.getModel();
            for(int i = selectedRows.length - 1; i>=0; i--) {
                tableModel.removeRow(selectedRows[i]);
            }
        }
    }//GEN-LAST:event_btnDeleteMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewUser;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JComboBox<String> cbbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}


class UsersTableModelListener implements TableModelListener {
  Users usersPanel;
  JTable table;
  UsersModel usersModelListener = new UsersModel();
  
  UsersTableModelListener(JTable table, Users users) {
    this.table = table;
    this.usersPanel = users;
  }

  @Override
  public void tableChanged(TableModelEvent e) {
    int firstRow = e.getFirstRow();
    int column = e.getColumn();
    String[] colsInDb = {"username", "password", "role"};
    
    if (e.getType() == TableModelEvent.UPDATE) {
        int currentInComeId = Users.usersShowInTable.get(firstRow).getId();
        Object value = table.getValueAt(firstRow, column);
        String updateValue = "";
        
        switch(column) {
            case 2:
                if(value.toString().matches("\\*{6,}")) {
                    return;
                }
                
                updateValue = Helper.md5(value.toString());
                break;
            case 3:
                updateValue = (boolean)table.getValueAt(firstRow, column)?"1":"0";
                break;
            default:
                updateValue = value.toString();
        }
        
        
        
        boolean resuilt = usersModelListener.updateUserCol(currentInComeId, colsInDb[column-1], updateValue);
        if(!resuilt) 
            showMessageDialog(table, "Có lỗi trong quá trình cập nhật, vui lòng kiểm tra lại dữ liệu nhập vào.", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else
            usersPanel.getAllUsers();
    }
  }
}