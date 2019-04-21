package Forms.Panels;

import Library.DBManager;
import Library.Helper;
import Library.State;
import Model.SpendModel;
import entity.Spend;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ho Sy Huy
 */
public class Spends extends javax.swing.JPanel {
    
    int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    SpendModel spendsModel = new SpendModel();
    /**
     * Creates new form InComes
     */
    public Spends() {
        initComponents();
        showDataWithMonth();
    }
    
    private void showData(){
        ArrayList<Spend> data = spendsModel.getAllSpends();
        DefaultTableModel tableModel = (DefaultTableModel) tableSpends.getModel();
        tableModel.setRowCount(0);
        
        for(Spend row : data){
            Object[] rowValues = {row.getId(),row.getTitle(),row.getNote(),row.getAmount(),row.getDatetime()};
            tableModel.addRow(rowValues);
        }
    }
    
    private void showDataWithMonth(){
        lbDate.setText(Helper.monthsInYear[currentMonth-1] + " - "+currentYear);
        ArrayList<Spend> data = spendsModel.getMonthYear(currentMonth, currentYear);
        DefaultTableModel tableModel = (DefaultTableModel) tableSpends.getModel();
        tableModel.setRowCount(0);
        
        for(Spend row : data){
            Object[] rowValues = {row.getId(),row.getTitle(),row.getNote(),Helper.currencyFormat(row.getAmount()),row.getDatetime()};
            tableModel.addRow(rowValues);
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

        dialogAdd = new javax.swing.JDialog();
        btnAdd = new javax.swing.JButton();
        btnRetype = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtTittle = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareaNotes = new javax.swing.JTextArea();
        lbTittle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAddSpend = new javax.swing.JButton();
        btnEditSpend = new javax.swing.JButton();
        btnDeleteSpend = new javax.swing.JButton();
        btnFindSpend = new javax.swing.JButton();
        tbFindSpend = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSpends = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();

        dialogAdd.setMinimumSize(new java.awt.Dimension(392, 340));
        dialogAdd.setName("dialogAdd"); // NOI18N

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRetype.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnRetype.setText("Nhập lại");
        btnRetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetypeActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txtTittle.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Tiêu đề");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Số tiền");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Ghi chú");
        jLabel6.setToolTipText("");

        txtareaNotes.setColumns(20);
        txtareaNotes.setRows(5);
        jScrollPane2.setViewportView(txtareaNotes);

        lbTittle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTittle.setText("Thêm chi tiêu");

        javax.swing.GroupLayout dialogAddLayout = new javax.swing.GroupLayout(dialogAdd.getContentPane());
        dialogAdd.getContentPane().setLayout(dialogAddLayout);
        dialogAddLayout.setHorizontalGroup(
            dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAddLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(lbTittle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dialogAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogAddLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRetype)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit)
                        .addGap(90, 90, 90))
                    .addGroup(dialogAddLayout.createSequentialGroup()
                        .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAmount)
                            .addComponent(jScrollPane2)
                            .addComponent(txtTittle))
                        .addGap(44, 44, 44))))
        );
        dialogAddLayout.setVerticalGroup(
            dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogAddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTittle)
                .addGap(33, 33, 33)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(9, 9, 9)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetype)
                    .addComponent(btnExit)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        dialogAdd.getAccessibleContext().setAccessibleName("dialogAdd");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý chi tiêu");

        btnAddSpend.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnAddSpend.setText("Thêm");
        btnAddSpend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSpendActionPerformed(evt);
            }
        });

        btnEditSpend.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnEditSpend.setText("Sửa");
        btnEditSpend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSpendActionPerformed(evt);
            }
        });

        btnDeleteSpend.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnDeleteSpend.setText("Xóa");

        btnFindSpend.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnFindSpend.setText("Tìm kiếm");

        tbFindSpend.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        tableSpends.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableSpends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tiêu đề", "Ghi chú", "Số tiền", "Thời gian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSpends.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tableSpends);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Danh sách chi tiêu");

        lbDate.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbDate.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnAddSpend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditSpend, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteSpend, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(tbFindSpend, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindSpend))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSpend)
                    .addComponent(btnEditSpend)
                    .addComponent(btnDeleteSpend)
                    .addComponent(btnFindSpend)
                    .addComponent(tbFindSpend, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        btnAddSpend.getAccessibleContext().setAccessibleName("btnAdd");
        btnAddSpend.getAccessibleContext().setAccessibleDescription("");
        lbDate.getAccessibleContext().setAccessibleName("lbDate");
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSpendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSpendActionPerformed
        // TODO add your handling code here:
        dialogAdd.show();
        btnAdd.setText("Thêm");
        lbTittle.setText("Thêm chi tiêu");
        
    }//GEN-LAST:event_btnAddSpendActionPerformed

    private void btnEditSpendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSpendActionPerformed
        // TODO add your handling code here:
        dialogAdd.show();
        btnAdd.setText("Sửa");
        lbTittle.setText("Sửa chi tiêu");
    }//GEN-LAST:event_btnEditSpendActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        txtTittle.setText("");
        txtAmount.setText("");
        txtareaNotes.setText("");
        dialogAdd.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        if(txtTittle.getText().isEmpty() || txtAmount.getText().isEmpty()){
            showMessageDialog(dialogAdd,"Bạn chưa nhập tiêu đề hoặc số tiền !","Thông báo",JOptionPane.ERROR_MESSAGE);
        return;
        }
        Spend spend = new Spend(
                State.currentUser.getId(),
                Integer.valueOf(txtAmount.getText()),
                txtTittle.getText(),
                txtareaNotes.getText()
        );
        if(btnAdd.getText() == "Thêm"){
        spendsModel.insertSpend(spend);
        showDataWithMonth();
        dialogAdd.dispose();
        }
        else{
            tableSpends.getSelectedRow();
            spendsModel.updateSpend(spend);
            showDataWithMonth();
            dialogAdd.dispose();
        }
        txtTittle.setText("");
        txtAmount.setText("");
        txtareaNotes.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRetypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetypeActionPerformed
        // TODO add your handling code here:
        txtTittle.setText("");
        txtAmount.setText("");
        txtareaNotes.setText("");
    }//GEN-LAST:event_btnRetypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddSpend;
    private javax.swing.JButton btnDeleteSpend;
    private javax.swing.JButton btnEditSpend;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFindSpend;
    private javax.swing.JButton btnRetype;
    private javax.swing.JDialog dialogAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbTittle;
    private javax.swing.JTable tableSpends;
    private javax.swing.JTextField tbFindSpend;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtTittle;
    private javax.swing.JTextArea txtareaNotes;
    // End of variables declaration//GEN-END:variables
}
