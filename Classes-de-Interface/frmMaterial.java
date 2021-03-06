package ClassesDeInterface;
import User.AgenteAmbiental;
import User.Material;
import com.intersys.objects.CacheException;
import com.intersys.objects.Id;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmMaterial extends javax.swing.JFrame {

    Material m;
    Conexao con;
    public static int codMat;

    
    public frmMaterial() 
    {
        initComponents();
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }
    
    private void LimpaCampos()
    {
        txtCodMaterial.setText(null);
        txtDescricao.setText(null);
        txtNome.setText(null);
        txtTempoDecomposicao.setText(null);
        txtTipo.setText(null);
    }

     private void LimpaJTable()
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
             
        jTable1.setModel(model);
    }
    
    private void PreencheJTable()
    {
        String[] cabecalhos = {"Código do Material", "Nome", "Tipo", "Tempo de decomposição", "descrição"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setColumnIdentifiers(cabecalhos);
        
        try
        {
            con = new Conexao();
            m =  new Material(con.getDbconnection());
            Iterator iter =  m.openByQuery(con.getDbconnection(), null, null);
            
            Object[][] objects = new Object[500][5];
            int i = 0;         
            
            while(iter.hasNext())
            {
                    m = new Material(con.getDbconnection());
                    m = (Material) iter.next();
                
                    objects[i][0]= m.getcodMaterial();
                    objects[i][1]= m.getnome();
                    objects[i][2]= m.gettipo();
                    objects[i][3]= m.gettempoDecomposicao();
                    objects[i][4]= m.getdescricao();
                    
                    model.addRow(new Object[]{objects[i][0], objects[i][1], objects[i][2], objects[i][3], objects[i][4]});
            }
        }
        catch(CacheException ex)
        {
            Logger.getLogger(frmAgenteAmbiental.class.getName()).log(Level.SEVERE, null, ex);
        }       
                jTable1.setModel(model);       
    
    }      

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodMaterial = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtTempoDecomposicao = new javax.swing.JTextField();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btEditar1 = new javax.swing.JButton();
        btImportar = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/paper.png"))); // NOI18N

        jLabel2.setText("Nome:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Tempo de Decomposição(anos):");

        jLabel5.setText("Descrição:");

        jLabel6.setText("Código Material:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("Material");

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/draw.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/broom.png"))); // NOI18N
        btEditar1.setText("Limpar");
        btEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar1ActionPerformed(evt);
            }
        });

        btImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(34, 34, 34))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodMaterial)
                                    .addComponent(txtNome)
                                    .addComponent(txtTipo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTempoDecomposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(txtCodMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTempoDecomposicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btEditar)
                    .addComponent(btExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btImportar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        con = new Conexao();
        try 
        {
            m = new Material(con.getDbconnection());
            m.setcodMaterial(Integer.parseInt(txtCodMaterial.getText()));
            m.setdescricao(txtDescricao.getText());
            m.setnome(txtNome.getText());
            m.settempoDecomposicao(Integer.parseInt(txtTempoDecomposicao.getText()));
            m.settipo(txtTipo.getText());
            m.save();
            JOptionPane.showMessageDialog(null, "Material cadastrado com sucesso!");
            LimpaCampos();
            LimpaJTable();
            PreencheJTable();
        } 
        catch (CacheException ex) 
        {
            Logger.getLogger(frmMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        con = new Conexao();
        try 
        {
            m = (Material) Material._open(con.getDbconnection(), new Id(txtCodMaterial.getText()));
            m.setdescricao(txtDescricao.getText());
            m.setnome(txtNome.getText());
            m.settempoDecomposicao(Integer.parseInt(txtTempoDecomposicao.getText()));
            m.settipo(txtTipo.getText());
            m.save();
            JOptionPane.showMessageDialog(null, "Material editado com sucesso!");
            LimpaCampos();
            LimpaJTable();
            PreencheJTable();
        } 
        catch (CacheException ex) 
        {
            Logger.getLogger(frmMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
       con = new Conexao();
        try 
        {
            m = (Material) Material._open(con.getDbconnection(), new Id(txtCodMaterial.getText()));
            m.delete();
            JOptionPane.showMessageDialog(null, "Material deletado com sucesso!");
            LimpaCampos();
            LimpaJTable();
            PreencheJTable();
        } 
        catch (CacheException ex) 
        {
            Logger.getLogger(frmMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int linha = jTable1.getSelectedRow();
        txtCodMaterial.setText(String.valueOf(jTable1.getValueAt(linha, 0)));
        txtNome.setText(String.valueOf(jTable1.getValueAt(linha, 1)));
        txtTipo.setText(String.valueOf(jTable1.getValueAt(linha, 2)));
        txtTempoDecomposicao.setText(String.valueOf(jTable1.getValueAt(linha, 3)));
        txtDescricao.setText(String.valueOf(jTable1.getValueAt(linha, 4)));
    }//GEN-LAST:event_jTable1MouseClicked

    private void btImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportarActionPerformed
        codMat = Integer.parseInt(txtCodMaterial.getText());
        dispose();;
    }//GEN-LAST:event_btImportarActionPerformed

    private void btEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar1ActionPerformed
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btEditar1ActionPerformed

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMaterial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEditar1;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btImportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCodMaterial;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTempoDecomposicao;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
