package servicosprestador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class CadServicosPrestador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadServicosPrestador frame = new CadServicosPrestador();
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
	public CadServicosPrestador() {
		setTitle("Cadastro dos Servi\u00E7os de um Prestador de Servi\u00E7os");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 344, 726, 51);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(CadServicosPrestador.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CadServicosPrestador.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(CadServicosPrestador.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(CadServicosPrestador.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 726, 111);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo do Prestador de Servi\u00E7os:");
		lblNewLabel.setBounds(10, 11, 203, 14);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(207, 5, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(207, 36, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(207, 67, 86, 20);
		panel_1.add(textField_2);
		
		JLabel lblCdigoDoServio = new JLabel("C\u00F3digo do Servi\u00E7o:");
		lblCdigoDoServio.setBounds(10, 42, 129, 14);
		panel_1.add(lblCdigoDoServio);
		
		JLabel lblValorDoServio = new JLabel("Valor do Servi\u00E7o:");
		lblValorDoServio.setBounds(10, 73, 142, 14);
		panel_1.add(lblValorDoServio);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(CadServicosPrestador.class.getResource("/Imagens/Zoom-icon.png")));
		button_4.setToolTipText("Pesquisar");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		button_4.setBounds(303, 5, 29, 20);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(CadServicosPrestador.class.getResource("/Imagens/Zoom-icon.png")));
		button_5.setToolTipText("Pesquisar");
		button_5.setOpaque(false);
		button_5.setFocusPainted(false);
		button_5.setBackground(new Color(240, 240, 241));
		button_5.setBounds(303, 35, 29, 20);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(CadServicosPrestador.class.getResource("/Imagens/Files-New-File-icon.png")));
		button_6.setToolTipText("Pesquisar");
		button_6.setOpaque(false);
		button_6.setFocusPainted(false);
		button_6.setBackground(new Color(240, 240, 241));
		button_6.setBounds(342, 35, 29, 20);
		panel_1.add(button_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 112, 726, 51);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(CadServicosPrestador.class.getResource("/Imagens/table-row-insert-icon.png")));
		button_8.setToolTipText("Salvar");
		button_8.setOpaque(false);
		button_8.setFocusPainted(false);
		button_8.setBackground(new Color(240, 240, 241));
		panel_2.add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setIcon(new ImageIcon(CadServicosPrestador.class.getResource("/Imagens/table-row-delete-icon.png")));
		button_9.setToolTipText("Deletar");
		button_9.setOpaque(false);
		button_9.setFocusPainted(false);
		button_9.setBackground(new Color(240, 240, 241));
		panel_2.add(button_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 163, 726, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"C\u00F3digo Servi\u00E7o", "Descri\u00E7\u00E3o do Servi\u00E7o", "Valor do Servi\u00E7o"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(0).setMinWidth(115);
		table.getColumnModel().getColumn(1).setMinWidth(450);
		table.getColumnModel().getColumn(2).setMinWidth(105);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	}
}
