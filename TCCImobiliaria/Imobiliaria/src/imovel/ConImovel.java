package imovel;

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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

import procuracao.DataCellRenderer;

public class ConImovel extends JFrame {

	private JPanel contentPane;
	private JTextField tfPesquisar;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private ImovelTableModel tableModel;
	private ImovelConsulta imovelConsulta;
	public static TableRowSorter<TableModel> rowSorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConImovel frame = new ConImovel();
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
	public ConImovel() {
		setTitle("Consulta de Im\u00F3vel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 726, 84);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Pesquisar:");
		label.setBounds(10, 11, 168, 14);
		panel.add(label);
		
		tfPesquisar = new JTextField();
		tfPesquisar.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				String filtro = tfPesquisar.getText().trim();
			    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
			}
		});
		tfPesquisar.setColumns(10);
		tfPesquisar.setBounds(10, 36, 237, 20);
		panel.add(tfPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 85, 726, 203);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        if(e.getClickCount() == 2){
		        	if (CadImovel.aberto == true) {
		        		ConImovel.this.dispose();;
						CadImovel.btnExcluir.setVisible(true);
			        	int linhaSel = table.getSelectedRow();
			        	imovelConsulta = tableModel.getImovel(linhaSel);
			        	CadImovel.SetarDados(imovelConsulta);
		        	}
		        	if (CadImovel.aberto == false) {
		        	new CadImovel().setVisible(true);
					ConImovel.this.dispose();;
					CadImovel.btnExcluir.setVisible(true);
		        	int linhaSel = table.getSelectedRow();
		        	imovelConsulta = tableModel.getImovel(linhaSel);
		        	CadImovel.SetarDados(imovelConsulta);
		        	}
		        	CadImovel.aberto = false;
			}
			}
		});
		scrollPane.setViewportView(table);
		tableModel = new ImovelTableModel();
		table.setModel(tableModel);
		table.getColumnModel().getColumn(16).setCellRenderer(new DataCellRenderer());
		setRowSorter();

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 287, 726, 47);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ConImovel.class.getResource("/Imagens/Actions-go-first-view-icon.png")));
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel_2.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(ConImovel.class.getResource("/Imagens/Actions-go-previous-view-icon.png")));
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel_2.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ConImovel.class.getResource("/Imagens/Basic-Minus-icon.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(ConImovel.class.getResource("/Imagens/Actions-go-next-view-icon.png")));
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(ConImovel.class.getResource("/Imagens/Actions-go-last-view-icon.png")));
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel_2.add(button_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 335, 726, 60);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CadImovel.fecharSemMenu2 == true) {
					ConImovel.this.dispose();
				}
				if (CadImovel.fecharSemMenu2 == false) {
				ConImovel.this.dispose();
				new MenuPrincipal().setVisible(true);
				}
				CadImovel.fecharSemMenu2 = false;
			}
		});
		button_4.setIcon(new ImageIcon(ConImovel.class.getResource("/Imagens/logout-icon.png")));
		button_4.setToolTipText("Sair");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		panel_3.add(button_4);
		
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		//DEIXAR POR ULTIMO NO CÓDIGO
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
