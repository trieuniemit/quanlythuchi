package Forms.Panels;

import Library.Helper;
import Library.State;
import Model.InComesModel;
import Entity.InCome;
import Model.MainFormModel;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
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
public class InComes extends javax.swing.JPanel {
    InComesModel inComesModel = new InComesModel();
    MainFormModel mainFormModel = new MainFormModel();
    
    HashMap minMaxDate;
    public static ArrayList<InCome> inComeShowInTable;
            
    int currentMonth = 0;
    int currentYear = 0;
    
    /**
     * Creates new form InComes
     */
    public InComes() {
        initComponents();
        
        //add placeholder for search field
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Nhập từ khóa...")) {
                    searchField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("Nhập từ khóa...");
                }
            }
        });
        
        initTableStyles();
       
        //get min max date and init current year, month
        new Thread(() -> {
            minMaxDate = inComesModel.getMinMaxDate();
            btnNextMonth.setVisible(false);
            initControlDate(true);
        }).start();
        
        //set visible for delete button
        btnDelete.setVisible(false);
        //add event for edit table
        incomesTable.getModel().addTableModelListener(new InComesTableModelListener(incomesTable, this));
    }
    
    private  void initTableStyles() {
        incomesTable.getTableHeader().setPreferredSize(new Dimension(100, 30));
        incomesTable.getColumnModel().getColumn(0).setMaxWidth(50);
        incomesTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        incomesTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        incomesTable.getColumnModel().getColumn(3).setPreferredWidth(180);
        incomesTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        
        //set padding and wrap word for table cell
//        for(int i = 0; i < incomesTable.getColumnCount(); i++) {
//            incomesTable.getColumnModel().getColumn(i).setCellRenderer(new WordWrapCellRenderer());;
//        }
        
        //set align for column of table
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        incomesTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        incomesTable.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
    }
    
    public void getAllInComes() {
        inComeShowInTable = inComesModel.getAllInComes();
        showInComesToTable(inComeShowInTable);
    }
    
    private void showInComesToTable(ArrayList<InCome> data) {
        DefaultTableModel tableModel = (DefaultTableModel) incomesTable.getModel();
        tableModel.setRowCount(0);
        int rowIndex = 0;
        int total = 0;
        for(InCome row: data) {
            total += row.getAmount();
            tableModel.addRow(new Object[] {++rowIndex, row.getTitle(), Helper.currencyFormat(row.getAmount()), row.getNote(), row.getDatetime()});
        }
        
        totalAmount.setText(Helper.currencyFormat(total));
        
        Helper.updateUserTotalAmountInUI(mainFormModel.totalUserAmount());
    }
    
    public void initControlDate(boolean isReGetMinMaxDate) {
        if(isReGetMinMaxDate) {
            minMaxDate = inComesModel.getMinMaxDate();
            currentMonth = Integer.valueOf(minMaxDate.get("max_month").toString());
            currentYear = Integer.valueOf(minMaxDate.get("max_year").toString());
        }
        lbMonthYear.setText(Helper.monthsInYear[currentMonth-1] + ", "+ currentYear);
        
        if(currentMonth == Integer.parseInt(minMaxDate.get("min_month").toString()) && currentYear == Integer.parseInt(minMaxDate.get("min_year").toString())) {
            btnPrevMonth.setVisible(false);
        } else {
            btnPrevMonth.setVisible(true);
        }
        
        if(currentMonth == Integer.parseInt(minMaxDate.get("max_month").toString()) && currentYear == Integer.parseInt(minMaxDate.get("max_year").toString())) {
            btnNextMonth.setVisible(false);
        } else {
            btnNextMonth.setVisible(true);
        }
        
        inComeShowInTable = inComesModel.getInComesByMonth(currentMonth, currentYear);
        showInComesToTable(inComeShowInTable);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addNewDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        titleFiled = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noteField = new javax.swing.JTextArea();
        btnReset = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        dateField = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        incomesTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnViewAll = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAddNew = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelControlDate = new javax.swing.JPanel();
        btnPrevMonth = new javax.swing.JLabel();
        lbMonthYear = new javax.swing.JLabel();
        btnNextMonth = new javax.swing.JLabel();

        addNewDialog.setTitle("Thêm thu nhập mới");
        addNewDialog.setAlwaysOnTop(true);
        addNewDialog.setMinimumSize(new java.awt.Dimension(390, 357));
        addNewDialog.setResizable(false);
        addNewDialog.setType(java.awt.Window.Type.POPUP);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thêm thu nhập");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tiêu đề");

        titleFiled.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ghi chú");

        amountField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số tiền");

        noteField.setColumns(20);
        noteField.setRows(5);
        jScrollPane2.setViewportView(noteField);

        btnReset.setBackground(new java.awt.Color(0, 102, 102));
        btnReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Nhập lại");
        btnReset.setFocusable(false);
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnResetMousePressed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 102, 102));
        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Lưu lại");
        btnSave.setFocusable(false);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSaveMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ngày tháng");

        javax.swing.GroupLayout addNewDialogLayout = new javax.swing.GroupLayout(addNewDialog.getContentPane());
        addNewDialog.getContentPane().setLayout(addNewDialogLayout);
        addNewDialogLayout.setHorizontalGroup(
            addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(addNewDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addNewDialogLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(addNewDialogLayout.createSequentialGroup()
                        .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amountField)
                            .addComponent(dateField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(titleFiled))
                        .addGap(20, 20, 20))))
        );
        addNewDialogLayout.setVerticalGroup(
            addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNewDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý thu nhập");

        incomesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tiêu đề", "Số tiền", "Ghi chú", "Thời gian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        incomesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        incomesTable.setFocusable(false);
        incomesTable.setRowHeight(30);
        incomesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                incomesTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(incomesTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnViewAll.setBackground(new java.awt.Color(0, 102, 102));
        btnViewAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnViewAll.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAll.setText("Xem tất cả");
        btnViewAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAll.setFocusable(false);
        btnViewAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnViewAllMousePressed(evt);
            }
        });

        searchField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchField.setText("Nhập từ khóa...");
        searchField.setPreferredSize(new java.awt.Dimension(102, 31));

        btnSearch.setBackground(new java.awt.Color(0, 102, 102));
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setFocusable(false);
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSearchMousePressed(evt);
            }
        });

        btnAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/plus.png"))); // NOI18N
        btnAddNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddNewMousePressed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/delete.png"))); // NOI18N
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDeleteMousePressed(evt);
            }
        });

        totalAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalAmount.setText("1.000.000đ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tổng cộng:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAmount)
                .addGap(18, 18, 18)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewAll)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnViewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelControlDate.setMaximumSize(new java.awt.Dimension(487, 24));
        panelControlDate.setMinimumSize(new java.awt.Dimension(487, 24));

        btnPrevMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/prev-page.png"))); // NOI18N
        btnPrevMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrevMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPrevMonthMousePressed(evt);
            }
        });

        lbMonthYear.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lbMonthYear.setForeground(new java.awt.Color(0, 153, 153));
        lbMonthYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMonthYear.setText("Tháng 4, 2019");

        btnNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/next-page.png"))); // NOI18N
        btnNextMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNextMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNextMonthMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelControlDateLayout = new javax.swing.GroupLayout(panelControlDate);
        panelControlDate.setLayout(panelControlDateLayout);
        panelControlDateLayout.setHorizontalGroup(
            panelControlDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlDateLayout.createSequentialGroup()
                .addComponent(btnPrevMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312)
                .addComponent(lbMonthYear, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addComponent(btnNextMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelControlDateLayout.setVerticalGroup(
            panelControlDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNextMonth)
            .addComponent(btnPrevMonth)
            .addComponent(lbMonthYear, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelControlDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(panelControlDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllMousePressed
        if(lbMonthYear.isVisible()) {
            getAllInComes();
            btnNextMonth.setVisible(false);
            btnPrevMonth.setVisible(false);
            lbMonthYear.setVisible(false);
            btnViewAll.setText("Xem theo tháng");
            panelControlDate.setPreferredSize(new Dimension(487, 24));
        } else {
            initControlDate(true);
            lbMonthYear.setVisible(true);
            btnViewAll.setText("Xem tất cả");
        }
    }//GEN-LAST:event_btnViewAllMousePressed

    private void btnPrevMonthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMonthMousePressed
        if(currentMonth == 1) {
            currentMonth = 12;
            currentYear--;
        } else {
            currentMonth--;
        }
        initControlDate(false);
    }//GEN-LAST:event_btnPrevMonthMousePressed

    private void btnNextMonthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMonthMousePressed
        if(currentMonth == 12) {
            currentMonth = 1;
            currentYear++;
        } else {
            currentMonth++;
        }
        initControlDate(false);
    }//GEN-LAST:event_btnNextMonthMousePressed

    private void btnSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMousePressed
        ArrayList<InCome> inComeByMonthYear = inComesModel.searchInComes(searchField.getText());
        showInComesToTable(inComeByMonthYear);
        btnNextMonth.setVisible(false);
        btnPrevMonth.setVisible(false);
        lbMonthYear.setVisible(false);
        panelControlDate.setPreferredSize(new Dimension(487, 24));
    }//GEN-LAST:event_btnSearchMousePressed

    private void btnResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMousePressed
        titleFiled.setText("");
        noteField.setText("");
        amountField.setText("");
    }//GEN-LAST:event_btnResetMousePressed

    private void btnSaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMousePressed
        if(titleFiled.getText().trim().isEmpty() || amountField.getText().trim().isEmpty()) {
            showMessageDialog(addNewDialog, "Trường tiêu đề và số tiền không được bỏ trống.", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Date date = dateField.getDate();
        
        String dateStr = null;
        try {
            dateStr = "20"+(date.getYear() - 100)+"-"+date.getMonth()+"-"+date.getDate() + " 00:00:00";
        } catch(Exception e) {
        }
        
        InCome inCome = new InCome(
            -1,
            State.currentUser.getId(),
            titleFiled.getText(),
            noteField.getText(),
            Integer.valueOf(Helper.rmNotNumber(amountField.getText())),
            dateStr
        );
        
        boolean resuilt = inComesModel.insertNewInCome(inCome);
        if(resuilt) {
            //showMessageDialog(addNewDialog, "Đã thêm vào bảng thu nhập.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            initControlDate(true);
            titleFiled.setText("");
            noteField.setText("");
            amountField.setText("");
            addNewDialog.dispose();
            lbMonthYear.setVisible(true);
            btnViewAll.setText("Xem tất cả");
        } else {
            showMessageDialog(addNewDialog, "Có lỗi trong quá trình thêm vào bảng thu nhập.", "Lỗi!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveMousePressed

    private void btnAddNewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewMousePressed
        addNewDialog.setLocationRelativeTo(null);
        addNewDialog.show();
    }//GEN-LAST:event_btnAddNewMousePressed

    private void incomesTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_incomesTableMousePressed
        if(incomesTable.getSelectedRow() >= 0) {
            btnDelete.setVisible(true);
        }
    }//GEN-LAST:event_incomesTableMousePressed

    private void btnDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMousePressed
        int resuiltConfirm = JOptionPane.showConfirmDialog(panelControlDate, "Bạn có chắc chắn muốn xóa các mục đã chọn?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(resuiltConfirm != 1) {
            
            int[] selectedRows = incomesTable.getSelectedRows();
            //delete in database
            for(int row: selectedRows) {
                inComesModel.deteteInComes(inComeShowInTable.get(row).getId());
            }
            
            //delete in table
            DefaultTableModel tableModel = (DefaultTableModel) incomesTable.getModel();
            for(int i = selectedRows.length - 1; i>=0; i--) {
                tableModel.removeRow(selectedRows[i]);
            }
        }
        Helper.updateUserTotalAmountInUI(mainFormModel.totalUserAmount());
    }//GEN-LAST:event_btnDeleteMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog addNewDialog;
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel btnAddNew;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnNextMonth;
    private javax.swing.JLabel btnPrevMonth;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewAll;
    private com.toedter.calendar.JDateChooser dateField;
    private javax.swing.JTable incomesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lbMonthYear;
    private javax.swing.JTextArea noteField;
    private javax.swing.JPanel panelControlDate;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField titleFiled;
    private javax.swing.JLabel totalAmount;
    // End of variables declaration//GEN-END:variables
}




class InComesTableModelListener implements TableModelListener {
  JTable table;
  InComes inComesPanel;
  InComesModel inComesModel = new InComesModel();
  
  InComesTableModelListener(JTable table, InComes inComesPanel) {
    this.table = table;
    this.inComesPanel = inComesPanel;
  }

  @Override
  public void tableChanged(TableModelEvent e) {
    int firstRow = e.getFirstRow();
    int column = e.getColumn();
    String[] colsInDb = {"title", "amount", "note", "datetime"};

    if (e.getType() == TableModelEvent.UPDATE) { 
        int currentInComeId = InComes.inComeShowInTable.get(firstRow).getId();
        String value = table.getValueAt(firstRow, column).toString();
        if(column == 2) { //is amount
            value = Helper.rmNotNumber(value);
        }
        boolean resuilt = inComesModel.updateInComesCol(currentInComeId, colsInDb[column-1], value);
        
        if(!resuilt) 
            showMessageDialog(table, "Có lỗi trong quá trình cập nhật, vui lòng kiểm tra lại dữ liệu nhập vào.", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else {
            if(inComesPanel.lbMonthYear.isVisible()) {
                inComesPanel.initControlDate(true);
            } else {
                inComesPanel.getAllInComes();
            }
        }
    }
  }
}