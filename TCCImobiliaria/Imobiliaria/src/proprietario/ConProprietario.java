package proprietario;

import imovel.CadImovel;

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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import menu.MenuPrincipal;
import fiador.CadFiador;
import fiador.ConFiador;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

import procuracao.DataCellRenderer;

public class ConProprietario extends JFrame {

	private JPanel contentPane;
	private JTextField tfPesquisar;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private static JButton btnSair;
	
	
	private ProprietarioTableModel tableModel;
	private ProprietarioCidade proprietarioCidade;
	private Proprietario proprietario;
	public static TableRowSorter<TableModel> rowSorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConProprietario frame = new ConProprietario();
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
	public ConProprietario() {
		setTitle("Consulta de Propriet\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 726, 84);
		contentPane.add(panel);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(10, 11, 168, 14);
		panel.add(lblPesquisar);
		
		tfPesquisar = new JTextField();
		tfPesquisar.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String filtro = tfPesquisar.getText().trim();
			    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
			}
		});
		tfPesquisar.setColumns(10);
		tfPesquisar.setBounds(10, 36, 237, 20);
		panel.add(tfPesquisar);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadProprietario().setVisible(true);
				ConProprietario.this.dispose();;
			}
		});
		button_5.setIcon(new ImageIcon(ConProprietario.class.getResource("/Imagens/Files-New-File-icon.png")));
		button_5.setToolTipText("Adicionar Propriet\u00E1rio");
		button_5.setOpaque(false);
		button_5.setFocusPainted(false);
		button_5.setBackground(new Color(240, 240, 241));
		button_5.setBounds(257, 35, 29, 20);
		panel.add(button_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 85, 726, 203);
		contentPane.add(scrollPane);
		
		table = new JTable();
		

		
		scrollPane.setViewportView(table);
		tableModel = new ProprietarioTableModel();
		table.setModel(tableModel);
		
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(90);
		table.getColumnModel().getColumn(3).setMinWidth(300);
		table.getColumnModel().getColumn(4).setMinWidth(250);
		table.getColumnModel().getColumn(5).setMinWidth(110);
		table.getColumnModel().getColumn(6).setMinWidth(200);
		table.getColumnModel().getColumn(7).setMinWidth(130);
		table.getColumnModel().getColumn(8).setMinWidth(120);
		table.getColumnModel().getColumn(9).setMinWidth(120);
		table.getColumnModel().getColumn(10).setMinWidth(150);
		table.getColumnModel().getColumn(11).setMinWidth(150);
		table.getColumnModel().getColumn(12).setMinWidth(120);
		table.getColumnModel().getColumn(13).setMinWidth(170);
		table.getColumnModel().getColumn(14).setMinWidth(120);
		table.getColumnModel().getColumn(15).setMinWidth(120);
		table.getColumnModel().getColumn(16).setMinWidth(120);
		table.getColumnModel().getColumn(17).setMinWidth(130);
		table.getColumnModel().getColumn(18).setMinWidth(120);
		table.getColumnModel().getColumn(19).setMinWidth(160);
		table.getColumnModel().getColumn(20).setMinWidth(120);
		table.getColumnModel().getColumn(21).setMinWidth(120);
		table.getColumnModel().getColumn(22).setMinWidth(120);
		table.getColumnModel().getColumn(23).setMinWidth(250);
		table.getColumnModel().getColumn(24).setMinWidth(170);
		table.getColumnModel().getColumn(25).setMinWidth(200);
		table.getColumnModel().getColumn(26).setMinWidth(120);
		table.getColumnModel().getColumn(27).setMinWidth(150);
		table.getColumnModel().getColumn(28).setMinWidth(150);
		table.getColumnModel().getColumn(29).setMinWidth(140);
		table.getColumnModel().getColumn(30).setMinWidth(120);
		table.getColumnModel().getColumn(31).setMinWidth(150);
		table.getColumnModel().getColumn(32).setMinWidth(250);
		table.getColumnModel().getColumn(33).setMinWidth(120);
		table.getColumnModel().getColumn(34).setMinWidth(120);
		table.getColumnModel().getColumn(35).setMinWidth(140);
		table.getColumnModel().getColumn(36).setMinWidth(150);
		table.getColumnModel().getColumn(37).setMinWidth(150);
		table.getColumnModel().getColumn(16).setCellRenderer(new DataCellRenderer());
		table.getColumnModel().getColumn(17).setCellRenderer(new DataCellRenderer());
		table.getColumnModel().getColumn(35).setCellRenderer(new DataCellRenderer());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        if(e.getClickCount() == 2){
		        	if (CadImovel.visivelProprietario == true) {
		        		ConProprietario.this.dispose();
		        		int linhaSel = table.getSelectedRow();
		        		proprietarioCidade = tableModel.getProprietario(linhaSel);
		        		CadImovel.SetarProprietario(proprietarioCidade);
		        	}
		        	if ((CadProprietario.aberto == true)) {
		        		ConProprietario.this.dispose();;
			        	CadProprietario.btnExcluir.setVisible(true);
			        	int linhaSel = table.getSelectedRow();
			        	proprietarioCidade = tableModel.getProprietario(linhaSel);
			        	CadProprietario.SetarDados(proprietarioCidade);
		        	}
		        	
		        	else if ((CadImovel.visivelProprietario == false) && (CadProprietario.aberto == false)) {
		        	new CadProprietario().setVisible(true);
					ConProprietario.this.dispose();;
		        	CadProprietario.btnExcluir.setVisible(true);
		        	int linhaSel = table.getSelectedRow();
		        	proprietarioCidade = tableModel.getProprietario(linhaSel);
		        	CadProprietario.SetarDados(proprietarioCidade);
		        	}
		        	CadImovel.visivelProprietario = false;
		        	CadProprietario.aberto = false;
			}
			}
		});
		setRowSorter();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 287, 726, 47);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ConProprietario.class.getResource("/Imagens/Actions-go-first-view-icon.png")));
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(ConProprietario.class.getResource("/Imagens/Actions-go-previous-view-icon.png")));
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel_1.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ConProprietario.class.getResource("/Imagens/Basic-Minus-icon.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_1.add(textField_2);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(ConProprietario.class.getResource("/Imagens/Actions-go-next-view-icon.png")));
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(ConProprietario.class.getResource("/Imagens/Actions-go-last-view-icon.png")));
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel_1.add(button_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 335, 726, 60);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (CadProprietario.fecharSemMenu2 == true) {
					ConProprietario.this.dispose();
				} 
				if (CadImovel.fecharSemMenu == true) {
					ConProprietario.this.dispose();
				} 
				if ((CadImovel.fecharSemMenu == false) && (CadProprietario.fecharSemMenu2 == false)) {
					new MenuPrincipal().setVisible(true);
					ConProprietario.this.dispose();
				}
					CadProprietario.fecharSemMenu2 = false;
					MenuPrincipal.fecharComMenu = false;
					CadImovel.fecharSemMenu = false;
				
			}
		});
		btnSair.setIcon(new ImageIcon(ConProprietario.class.getResource("/Imagens/logout-icon.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setOpaque(false);
		btnSair.setFocusPainted(false);
		btnSair.setBackground(new Color(240, 240, 241));
		panel_2.add(btnSair);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		//DEIXAR POR ULTIMO NO CODIGO
		addWindowListener(new WindowAdapter()  
	    {  
	      public void windowOpened(WindowEvent e)  
	      {tfPesquisar.requestFocus();}  
	    });
	}
	
	private void setRowSorter() {
		  if (rowSorter == null) {
		   rowSorter = new TableRowSorter<TableModel>(table.getModel());
		   table.setRowSorter(rowSorter);
		  }
		 }
	
}
