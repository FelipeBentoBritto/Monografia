package cidade;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import menu.MenuPrincipal;
import proprietario.CadProprietario;

public class ConCidade extends JFrame {

	private JPanel contentPane;
	private JTextField tfCidade;
	private static JTable table;
	private CidadeTableModel tableModel;
	private Cidade cidade;
	public static TableRowSorter<TableModel> rowSorter;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConCidade frame = new ConCidade();
					frame.setVisible(true);
					for (UIManager.LookAndFeelInfo lnf : UIManager.getInstalledLookAndFeels()) {
						if ("Metal".equals(lnf.getName())) {
							UIManager.setLookAndFeel(lnf.getClassName());
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConCidade() {
		setTitle("Consulta de Cidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 476, 84);
		contentPane.add(panel);
		
		JLabel lblPesquisarPorCidade = new JLabel("Pesquisar por Cidade:");
		lblPesquisarPorCidade.setBounds(10, 11, 168, 14);
		panel.add(lblPesquisarPorCidade);
		
		tfCidade = new JTextField();
		tfCidade.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String filtro = tfCidade.getText().trim();
			    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
			}
		});

		
		tfCidade.setBounds(10, 36, 237, 20);
		panel.add(tfCidade);
		tfCidade.setColumns(10);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadCidade().setVisible(true);
				ConCidade.this.dispose();;
			}
		});
		button_5.setIcon(new ImageIcon(ConCidade.class.getResource("/Imagens/Files-New-File-icon.png")));
		button_5.setToolTipText("Pesquisar");
		button_5.setOpaque(false);
		button_5.setFocusPainted(false);
		button_5.setBackground(new Color(240, 240, 241));
		button_5.setBounds(257, 35, 29, 20);
		panel.add(button_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 85, 476, 249);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        if(e.getClickCount() == 2){
		        	if (CadProprietario.visivel == true) {
		        		ConCidade.this.dispose();
		        		int linhaSel = table.getSelectedRow();
		        		cidade = tableModel.getCidade(linhaSel);
		        		CadProprietario.SetarCidade(cidade);
		        	}
		        	if (CadCidade.aberto == true) {
		        		ConCidade.this.dispose();;
			        	CadCidade.btnExcluir.setVisible(true);
			        	int linhaSel = table.getSelectedRow();
			        	cidade = tableModel.getCidade(linhaSel);
			        	CadCidade.SetarDados(cidade);
		        	}
		        	else if ((CadProprietario.visivel == false) && (CadCidade.aberto == false)) {
		        	new CadCidade().setVisible(true);
					ConCidade.this.dispose();;
		        	CadCidade.btnExcluir.setVisible(true);
		        	int linhaSel = table.getSelectedRow();
		        	cidade = tableModel.getCidade(linhaSel);
		        	CadCidade.SetarDados(cidade);
		        	}
		        	
		        	CadProprietario.visivel = false;
		        	CadCidade.aberto = false;
			}
			}
		});
		scrollPane.setViewportView(table);
		tableModel = new CidadeTableModel();
		table.setModel(tableModel);
		setRowSorter();
		
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setMinWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 335, 476, 60);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (CadCidade.fecharSemMenu == true) {
					ConCidade.this.dispose();
				}
				if (CadProprietario.fecharSemMenu == true) {
					ConCidade.this.dispose();
				} 
				
			else if((CadCidade.fecharSemMenu == false) && (CadProprietario.fecharSemMenu2 == false)){
					new MenuPrincipal().setVisible(true);
					ConCidade.this.dispose();
				}
				CadProprietario.fecharSemMenu = false;
				MenuPrincipal.fecharComMenu = false;
				CadCidade.fecharSemMenu = false;
			}
		});
		button_4.setIcon(new ImageIcon(ConCidade.class.getResource("/Imagens/logout-icon.png")));
		button_4.setToolTipText("Sair");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		panel_2.add(button_4);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		//DEIXAR POR ULTIMO NO CODIGO
		addWindowListener(new WindowAdapter()  
	    {  
	      public void windowOpened(WindowEvent e)  
	      {tfCidade.requestFocus();}  
	    });
		
	}
	
	private void setRowSorter() {
		  if (rowSorter == null) {
		   rowSorter = new TableRowSorter<TableModel>(table.getModel());
		   table.setRowSorter(rowSorter);
		  }
		 }

}
