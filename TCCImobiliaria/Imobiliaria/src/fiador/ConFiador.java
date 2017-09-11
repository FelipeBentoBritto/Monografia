package fiador;

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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import menu.MenuPrincipal;

public class ConFiador extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	
	private FiadorTableModel tableModel;
	private Fiador fiador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConFiador frame = new ConFiador();
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
	public ConFiador() {

		setTitle("Consulta de Fiador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 726, 84);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Pesquisar por Nome:");
		label.setBounds(10, 11, 168, 14);
		panel.add(label);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(10, 36, 237, 20);
		panel.add(tfNome);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadFiador().setVisible(true);
				ConFiador.this.dispose();;
			}
		});
		button_5.setIcon(new ImageIcon(ConFiador.class.getResource("/Imagens/Files-New-File-icon.png")));
		button_5.setToolTipText("Pesquisar");
		button_5.setOpaque(false);
		button_5.setFocusPainted(false);
		button_5.setBackground(new Color(240, 240, 241));
		button_5.setBounds(257, 35, 29, 20);
		panel.add(button_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 85, 726, 203);
		contentPane.add(scrollPane);
		
		table = new JTable();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        if(e.getClickCount() == 2){
		        	new CadFiador().setVisible(true);
					ConFiador.this.dispose();;
		        	CadFiador.btnExcluir.setVisible(true);
		        	int linhaSel = table.getSelectedRow();
		        	fiador = tableModel.getFiador(linhaSel);
		        	CadFiador.SetarDados(fiador);
			}
			}
		});


		scrollPane.setViewportView(table);
		tableModel = new FiadorTableModel();
		table.setModel(tableModel);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(115);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.getColumnModel().getColumn(9).setPreferredWidth(120);
		table.getColumnModel().getColumn(10).setPreferredWidth(200);
		table.getColumnModel().getColumn(11).setPreferredWidth(110);
		table.getColumnModel().getColumn(12).setPreferredWidth(150);
		table.getColumnModel().getColumn(13).setPreferredWidth(150);
		table.getColumnModel().getColumn(14).setPreferredWidth(150);
		table.getColumnModel().getColumn(15).setPreferredWidth(120);
		table.getColumnModel().getColumn(16).setPreferredWidth(90);
		table.getColumnModel().getColumn(17).setPreferredWidth(90);
		table.getColumnModel().getColumn(18).setPreferredWidth(100);
		table.getColumnModel().getColumn(19).setPreferredWidth(115);
		table.getColumnModel().getColumn(20).setPreferredWidth(100);
		table.getColumnModel().getColumn(21).setPreferredWidth(200);
		table.getColumnModel().getColumn(22).setPreferredWidth(90);
		table.getColumnModel().getColumn(23).setPreferredWidth(90);
		table.getColumnModel().getColumn(24).setPreferredWidth(120);
		table.getColumnModel().getColumn(25).setPreferredWidth(150);
		table.getColumnModel().getColumn(26).setPreferredWidth(150);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    


		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 287, 726, 47);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ConFiador.class.getResource("/Imagens/Actions-go-first-view-icon.png")));
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(ConFiador.class.getResource("/Imagens/Actions-go-previous-view-icon.png")));
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel_1.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ConFiador.class.getResource("/Imagens/Basic-Minus-icon.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_1.add(textField_2);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(ConFiador.class.getResource("/Imagens/Actions-go-next-view-icon.png")));
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(ConFiador.class.getResource("/Imagens/Actions-go-last-view-icon.png")));
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel_1.add(button_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 335, 726, 60);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MenuPrincipal().setVisible(true);;
				ConFiador.this.dispose();
			}
		});
		button_4.setIcon(new ImageIcon(ConFiador.class.getResource("/Imagens/logout-icon.png")));
		button_4.setToolTipText("Sair");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		panel_2.add(button_4);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		//DEIXAR POR ULTIMO NO CODIGO
		addWindowListener(new WindowAdapter()  
	    {  
	      public void windowOpened(WindowEvent e)  
	      {tfNome.requestFocus();}  
	    });
	}
}
