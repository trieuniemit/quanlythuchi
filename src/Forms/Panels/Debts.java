package Forms.Panels;

import Entity.Debt;
import Library.Helper;
import Library.WordWrapCellRenderer;
import Library.State;
import Model.DebtsModel;
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
public class Debts extends javax.swing.JPanel {
    DebtsModel debtsModel = new DebtsModel();
    HashMap minMaxDate;
    MainFormModel mainFormModel = new MainFormModel();
    
    public static ArrayList<Debt> debtsShowInTable;
            
    int currentMonth = 0;
    int currentYear = 0;
    
    /**
     * Creates new form InComes
     */
    public Debts() {
        initComponents();
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
            minMaxDate = debtsModel.getMinMaxDate();
            currentMonth = Integer.valueOf(minMaxDate.get("max_month").toString());
            currentYear = Integer.valueOf(minMaxDate.get("max_year").toString());
            //view all
            getAllDebts();
            btnNextMonth.setVisible(false);
            btnPrevMonth.setVisible(false);
            lbMonthYear.setVisible(false);
            btnViewAll.setText("Xem theo tháng");
            panelControlDate.setPreferredSize(new Dimension(487, 24));
        }).start();
        
        //set visible for delete button
        btnDelete.setVisible(false);
        //add event for edit table
        debtsTable.getModel().addTableModelListener(new DebtsTableModelListener(debtsTable, this));
    }
    
    private  void initTableStyles() {
        debtsTable.getTableHeader().setPreferredSize(new Dimension(100, 30));
        debtsTable.getColumnModel().getColumn(0).setMaxWidth(50);
        debtsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        debtsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        debtsTable.getColumnModel().getColumn(3).setPreferredWidth(180);
        debtsTable.getColumnModel().getColumn(5).setPreferredWidth(150);
        
        //set padding and wrap word for table cell
        for(int i = 0; i < debtsTable.getColumnCount(); i++) {
            if(i == 4) continue;
            debtsTable.getColumnModel().getColumn(i).setCellRenderer(new WordWrapCellRenderer());
        }
        
        //set align for column of table
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        debtsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        debtsTable.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
    }
    
    private void getAllDebts() {
        debtsShowInTable = debtsModel.getAllDebts();
        showDebtsToTable(debtsShowInTable);
    }
    
    private void showDebtsToTable(ArrayList<Debt> data) {
        DefaultTableModel tableModel = (DefaultTableModel) debtsTable.getModel();
        tableModel.setRowCount(0);
        int rowIndex = 0;
        int totalCount = 0, unpaidCount = 0, paidCount = 0;
        for(Debt row: data) {
            totalCount += row.getAmount();
            if(row.getStatus() == 1) {
                paidCount += row.getAmount();
            } else {
                unpaidCount += row.getAmount();
            }
            
            tableModel.addRow(new Object[] {
                ++rowIndex, 
                row.getTitle(), 
                Helper.currencyFormat(row.getAmount()), 
                row.getNote(), 
                (row.getStatus()==1), 
                row.getDatetime()
            });
        }
        
        //set value for count label
        totalAmount.setText(Helper.currencyFormat(totalCount));
        unpaidAmount.setText(Helper.currencyFormat(unpaidCount));
        paidAmount.setText(Helper.currencyFormat(paidCount));
        State.updateUserTotalAmountInUI(mainFormModel.totalUserAmount());
    }
    
    public void initControlDate() {
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
        
        debtsShowInTable = debtsModel.getDebtsByMonth(currentMonth, currentYear);
        showDebtsToTable(debtsShowInTable);
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
        debtsTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnViewAll = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAddNew = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        panelControlDate = new javax.swing.JPanel();
        btnPrevMonth = new javax.swing.JLabel();
        lbMonthYear = new javax.swing.JLabel();
        btnNextMonth = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        unpaidAmount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        paidAmount = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        addNewDialog.setTitle("Thêm thu nhập mới");
        addNewDialog.setAlwaysOnTop(true);
        addNewDialog.setMinimumSize(new java.awt.Dimension(390, 357));
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
                .addContainerGap()
                .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addNewDialogLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addContainerGap(134, Short.MAX_VALUE))
                    .addGroup(addNewDialogLayout.createSequentialGroup()
                        .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amountField)
                            .addComponent(dateField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(titleFiled))
                        .addContainerGap())))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(addNewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý vay muợn");

        debtsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tiêu đề", "Số tiền", "Ghi chú", "Đã trả", "Thời gian"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        debtsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        debtsTable.setFocusable(false);
        debtsTable.setRowHeight(30);
        debtsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                debtsTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(debtsTable);

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
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewAll)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnViewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        unpaidAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        unpaidAmount.setText("100.000đ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tổng còn nợ:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tổng đã trả:");

        paidAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        paidAmount.setText("100.000đ");

        totalAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalAmount.setText("100.000đ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Tổng:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unpaidAmount)
                .addGap(153, 153, 153)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paidAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAmount)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(paidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(unpaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelControlDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(panelControlDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllMousePressed
        if(lbMonthYear.isVisible()) {
            getAllDebts();
            btnNextMonth.setVisible(false);
            btnPrevMonth.setVisible(false);
            lbMonthYear.setVisible(false);
            btnViewAll.setText("Xem theo tháng");
            panelControlDate.setPreferredSize(new Dimension(487, 24));
        } else {
            initControlDate();
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
        initControlDate();
    }//GEN-LAST:event_btnPrevMonthMousePressed

    private void btnNextMonthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMonthMousePressed
        if(currentMonth == 12) {
            currentMonth = 1;
            currentYear++;
        } else {
            currentMonth++;
        }
        initControlDate();
    }//GEN-LAST:event_btnNextMonthMousePressed

    private void btnSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMousePressed
        ArrayList<Debt> inComeByMonthYear = debtsModel.searchDebts(searchField.getText());
        showDebtsToTable(inComeByMonthYear);
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
        
        Debt debt = new Debt(
            -1,
            State.currentUser.getId(),
            titleFiled.getText(),
            noteField.getText(),
            Integer.valueOf(Helper.rmNotNumber(amountField.getText())),
            dateStr,
            0
        );
        
        boolean resuilt = debtsModel.insertNewDebt(debt);
        if(resuilt) {
            //showMessageDialog(addNewDialog, "Đã thêm vào bảng thu nhập.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            initControlDate();
            titleFiled.setText("");
            noteField.setText("");
            amountField.setText("");
            addNewDialog.dispose();
            initControlDate();
        } else {
            showMessageDialog(addNewDialog, "Có lỗi trong quá trình thêm vào bảng thu nhập.", "Lỗi!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveMousePressed

    private void btnAddNewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewMousePressed
        addNewDialog.setLocationRelativeTo(null);
        addNewDialog.show();
    }//GEN-LAST:event_btnAddNewMousePressed

    private void debtsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_debtsTableMousePressed
        if(debtsTable.getSelectedRow() >= 0) {
            btnDelete.setVisible(true);
        }
    }//GEN-LAST:event_debtsTableMousePressed

    private void btnDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMousePressed
        int resuiltConfirm = JOptionPane.showConfirmDialog(panelControlDate, "Bạn có chắc chắn muốn xóa các mục đã chọn?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(resuiltConfirm != 1) {
            
            int[] selectedRows = debtsTable.getSelectedRows();
            //delete in database
            for(int row: selectedRows) {
                debtsModel.deteteDebts(debtsShowInTable.get(row).getId());
            }
            
            //delete in table
            DefaultTableModel tableModel = (DefaultTableModel) debtsTable.getModel();
            for(int i = selectedRows.length - 1; i>=0; i--) {
                tableModel.removeRow(selectedRows[i]);
            }
        }
        State.updateUserTotalAmountInUI(mainFormModel.totalUserAmount());
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
    private javax.swing.JTable debtsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMonthYear;
    private javax.swing.JTextArea noteField;
    private javax.swing.JLabel paidAmount;
    private javax.swing.JPanel panelControlDate;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField titleFiled;
    private javax.swing.JLabel totalAmount;
    private javax.swing.JLabel unpaidAmount;
    // End of variables declaration//GEN-END:variables
}




class DebtsTableModelListener implements TableModelListener {
  Debts debtsPanel;
  JTable table;
  DebtsModel debtsModelListener = new DebtsModel();
  
  DebtsTableModelListener(JTable table, Debts debts) {
    this.table = table;
    this.debtsPanel = debts;
  }

  @Override
  public void tableChanged(TableModelEvent e) {
    int firstRow = e.getFirstRow();
    int column = e.getColumn();
    String[] colsInDb = {"title", "amount", "note", "status", "datetime"};
    
    if (e.getType() == TableModelEvent.UPDATE) {
        int currentInComeId = Debts.debtsShowInTable.get(firstRow).getId();
        Object value = table.getValueAt(firstRow, column);
        String updateValue = "";
        
        switch(column) {
            case 2: 
                updateValue = Helper.rmNotNumber(value.toString());
                Debts.debtsShowInTable.get(firstRow).setAmount(Integer.valueOf(updateValue));
                break;
            case 4: 
                updateValue = (boolean)table.getValueAt(firstRow, column)?"1":"0";
                Debts.debtsShowInTable.get(firstRow).setStatus(Integer.valueOf(updateValue));
                break;
            default:
                updateValue = value.toString();
        }
        
        
        
        boolean resuilt = debtsModelListener.updateDebtCol(currentInComeId, colsInDb[column-1], updateValue);
        if(!resuilt) 
            showMessageDialog(table, "Có lỗi trong quá trình cập nhật, vui lòng kiểm tra lại dữ liệu nhập vào.", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else 
            debtsPanel.initControlDate();
    }
  }
}