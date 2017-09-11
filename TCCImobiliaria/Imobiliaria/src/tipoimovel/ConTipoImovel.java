package tipoimovel;

import imovel.CadImovel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import org.apache.lucene.util.Sorter;

import menu.MenuPrincipal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class ConTipoImovel extends JFrame {

	private JPanel contentPane;
	private JTextField tfDescricao;
	public static JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private TipoImovelTableModel tableModel;
	private TipoImovel tipoimovel;
	public static TableRowSorter<TableModel> rowSorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConTipoImovel frame = new ConTipoImovel();
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
	public ConTipoImovel() {
		setTitle("Consulta de Tipo de Im\u00F3vel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 476, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPesquisarPorDescrio = new JLabel("Pesquisar por Descri\u00E7\u00E3o:");
		lblPesquisarPorDescrio.setBounds(10, 11, 168, 14);
		panel.add(lblPesquisarPorDescrio);
		
		tfDescricao = new JTextField();
		tfDescricao.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				String text = tfDescricao.getText().trim();
			    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
			}
		});

		tfDescricao.setBounds(10, 36, 237, 20);
		panel.add(tfDescricao);
		tfDescricao.setColumns(10);
		
		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadTipoImovel().setVisible(true);
				ConTipoImovel.this.dispose();;
			}
		});
		btnNovo.setIcon(new ImageIcon(ConTipoImovel.class.getResource("/Imagens/Files-New-File-icon.png")));
		btnNovo.setToolTipText("Pesquisar");
		btnNovo.setOpaque(false);
		btnNovo.setFocusPainted(false);
		btnNovo.setBackground(new Color(240, 240, 241));
		btnNovo.setBounds(257, 35, 29, 20);
		panel.add(btnNovo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 85, 476, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        if(e.getClickCount() == 2){
		        	if (CadImovel.visivel == true) {
		        		ConTipoImovel.this.dispose();
		        		int linhaSel = table.getSelectedRow();
		        		tipoimovel = tableModel.getTipoImovel(linhaSel);
		        		CadImovel.SetarTipoImovel(tipoimovel);
		        	}
		        	if (CadTipoImovel.aberto == true) {
		        		ConTipoImovel.this.dispose();
			        	CadTipoImovel.btnExcluir.setVisible(true);
			        	int linhaSel = table.getSelectedRow();
			        	tipoimovel = tableModel.getTipoImovel(linhaSel);
			        	CadTipoImovel.SetarDados(tipoimovel);
		        	}
		        	else if ((CadImovel.visivel == false) && (CadTipoImovel.aberto == false)){
		        	new CadTipoImovel().setVisible(true);
					ConTipoImovel.this.dispose();
		        	CadTipoImovel.btnExcluir.setVisible(true);
		        	int linhaSel = table.getSelectedRow();
		        	tipoimovel = tableModel.getTipoImovel(linhaSel);
		        	CadTipoImovel.SetarDados(tipoimovel);
		        	}
		        	
		        	CadImovel.visivel = false;
		        	CadTipoImovel.aberto = false;
			}
			}
		});
		scrollPane.setViewportView(table);
		tableModel = new TipoImovelTableModel();
		table.setModel(tableModel);
		setRowSorter();
		
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		table.getColumnModel().getColumn(1).setMinWidth(350);
		

		Color color = new Color(240,240,241);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 280, 476, 54);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton btnPrimeiro = new JButton("");
		panel_1.add(btnPrimeiro);
		btnPrimeiro.setIcon(new ImageIcon(ConTipoImovel.class.getResource("/Imagens/Actions-go-first-view-icon.png")));
		btnPrimeiro.setBackground(color);
		btnPrimeiro.setOpaque(false);
		btnPrimeiro.setFocusPainted(false);
		
		JButton btnAnterior = new JButton("");
		panel_1.add(btnAnterior);
		btnAnterior.setIcon(new ImageIcon(ConTipoImovel.class.getResource("/Imagens/Actions-go-previous-view-icon.png")));
		
		btnAnterior.setBackground(color);
		btnAnterior.setOpaque(false);
		btnAnterior.setFocusPainted(false);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDe = new JLabel("");
		lblDe.setIcon(new ImageIcon(ConTipoImovel.class.getResource("/Imagens/Basic-Minus-icon.png")));
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDe.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblDe);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnProximo = new JButton("");
		panel_1.add(btnProximo);
		btnProximo.setIcon(new ImageIcon(ConTipoImovel.class.getResource("/Imagens/Actions-go-next-view-icon.png")));
		
		btnProximo.setBackground(color);
		btnProximo.setOpaque(false);
		btnProximo.setFocusPainted(false);
		
		JButton btnUltimo = new JButton("");
		panel_1.add(btnUltimo);
		btnUltimo.setIcon(new ImageIcon(ConTipoImovel.class.getResource("/Imagens/Actions-go-last-view-icon.png")));
		
		btnUltimo.setBackground(color);
		btnUltimo.setOpaque(false);
		btnUltimo.setFocusPainted(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 335, 476, 60);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (CadTipoImovel.fecharSemMenu == true) {
					ConTipoImovel.this.dispose();
				}
				if (CadImovel.fecharSemMenu == true) {
					ConTipoImovel.this.dispose();
				} 
				else if ((CadTipoImovel.fecharSemMenu == false) && (CadImovel.fecharSemMenu == false)){
					new MenuPrincipal().setVisible(true);
					ConTipoImovel.this.dispose();
				}
				CadImovel.fecharSemMenu = false;
				MenuPrincipal.fecharComMenu = false;
				CadTipoImovel.fecharSemMenu = false;
			}
		});
		btnSair.setIcon(new ImageIcon(ConTipoImovel.class.getResource("/Imagens/logout-icon.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setOpaque(false);
		btnSair.setFocusPainted(false);
		btnSair.setBackground(new Color(240, 240, 241));
		panel_2.add(btnSair);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		//DEIXAR POR ULTIMO NO CÓDIGO
		addWindowListener(new WindowAdapter()  
	    {  
	      public void windowOpened(WindowEvent e)  
	      {tfDescricao.requestFocus();}  
	    });
		
		
	}
	private void setRowSorter() {
		  if (rowSorter == null) {
		   rowSorter = new TableRowSorter<TableModel>(table.getModel());
		   table.setRowSorter(rowSorter);
		  }
		 }

	}
