package entrega_2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import entrega_1.modelo.Pessoa;

public class TelaPessoa extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		TelaPessoa field = new TelaPessoa();
		field.testaJFormattedTextField();
	}

	static Pessoa pessoa = null;

	private void testaJFormattedTextField() {
		final SimpleDateFormat dMA = new SimpleDateFormat("dd/MM/yyyy");
		Container janela = getContentPane();
		setLayout(null);

		// Define os r�tulos dos bot�es
		JLabel labelNome = new JLabel("Nome: ");
		JLabel labelDataNascimento = new JLabel("Data de nasc: ");
		JLabel labelAltura = new JLabel("Altura: ");
		JLabel labelRg = new JLabel("RG: ");
		JLabel labelDoouSangue = new JLabel("Doou sangue: ");
		JLabel labelUltimaDoacao = new JLabel("�ltima doa��o: ");
		final JLabel labelInfo = new JLabel("");
		final JLabel labelTv = new JLabel();
		final JLabel labelDoacao = new JLabel();

		labelNome.setBounds(50, 20, 100, 20);
		labelDataNascimento.setBounds(50, 40, 100, 20);
		labelAltura.setBounds(50, 60, 100, 20);
		labelRg.setBounds(50, 80, 100, 20);
		labelDoouSangue.setBounds(50, 100, 100, 20);
		labelUltimaDoacao.setBounds(50, 120, 40, 20);
		labelInfo.setBounds(150, 200, 200, 200);
		labelTv.setBounds(351, 200, 150, 150);
		labelDoacao.setBounds(150, 290, 200, 200);

		// Define as m�scaras
		MaskFormatter mascaraData = null;

		NumberFormatter formatter = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
			NumberFormat format = NumberFormat.getInstance();
			formatter = new NumberFormatter(format);
			formatter.setValueClass(Integer.class);
			formatter.setMinimum(0);
			formatter.setMaximum(Integer.MAX_VALUE);
			formatter.setAllowsInvalid(false);
			formatter.setCommitsOnValidEdit(true);

		} catch (ParseException excp) {
			System.err.println("Erro na formata��o: " + excp.getMessage());
			System.exit(-1);
		}

		// Seta as m�scaras nos objetos JFormattedTextField
		final JFormattedTextField jFDataNascimento = new JFormattedTextField(mascaraData);
		jFDataNascimento.setText("01/01/1999");
		final JTextField jFNome = new JTextField("");
		jFNome.setText("Leo");
		final JFormattedTextField jFAltura = new JFormattedTextField(formatter);
		jFAltura.setText("1");
		final JTextField jFRg = new JTextField();
		jFRg.setText("523308292");
		final JCheckBox jDoouSangue = new JCheckBox();
		jDoouSangue.setSelected(true);
		final JFormattedTextField jFUltimaDoancao = new JFormattedTextField(mascaraData);
		jFUltimaDoancao.setText("01/09/2020");
		jFNome.setBounds(150, 20, 140, 20);
		jFDataNascimento.setBounds(150, 40, 70, 20);
		jFAltura.setBounds(150, 60, 70, 20);
		jFRg.setBounds(150, 80, 70, 20);
		jDoouSangue.setBounds(150, 100, 70, 20);
		jFUltimaDoancao.setBounds(150, 120, 70, 20);

		// buttons
		JButton jBTerFilho = new JButton("Ter + 1 filho");
		JButton jBDoarSangue = new JButton("Doar Sangue");

		jBTerFilho.setBounds(150, 140, 200, 30);
		jBDoarSangue.setBounds(351, 140, 200, 30);

		// adiciona funções

		jBTerFilho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (pessoa == null) {
						pessoa = new Pessoa(jFNome.getText().toString(),
								dMA.parse(jFDataNascimento.getText().toString()),
								Double.parseDouble(jFAltura.getText().toString()), jFRg.getText().toString(),
								jDoouSangue.isSelected(), dMA.parse(jFUltimaDoancao.getText().toString()));
					}
					pessoa.aumentarFilho(1);
					labelInfo.setText(pessoa.mostrarInformacoes(dMA));
					if (pessoa.getQtdFilho() >= 5) {
						BufferedImage image = null;
						try {
							image = ImageIO.read(pessoa.getImagePresente());
						} catch (IOException e1) {
						}
						ImageIcon imageIcon = new ImageIcon(image);
						labelTv.setIcon(imageIcon);
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});

		labelTv.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				BufferedImage image = null;
				try {
					image = ImageIO.read(pessoa.getImageTv());
				} catch (IOException e1) {
				}
				ImageIcon imageIcon = new ImageIcon(image);
				labelTv.setIcon(imageIcon);

			}
		});
		
		jBDoarSangue.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (pessoa == null) {
					try {
						pessoa = new Pessoa(jFNome.getText().toString(),
								dMA.parse(jFDataNascimento.getText().toString()),
								Double.parseDouble(jFAltura.getText().toString()), jFRg.getText().toString(),
								jDoouSangue.isSelected(), dMA.parse(jFUltimaDoancao.getText().toString()));
					} catch (NumberFormatException | ParseException e1) {
					}
				}
				labelDoacao.setText(pessoa.doarSangue());
			}
		});

		// Adiciona os rótulos e os campos de textos com m�scaras na tela
		janela.add(labelDataNascimento);
		janela.add(labelNome);
		janela.add(labelAltura);
		janela.add(labelRg);
		janela.add(labelDoouSangue);
		janela.add(labelUltimaDoacao);
		janela.add(labelDoacao);
		janela.add(labelTv);
		janela.add(labelInfo);


		janela.add(jFDataNascimento);
		janela.add(jFNome);
		janela.add(jFAltura);
		janela.add(jFRg);
		janela.add(jDoouSangue);
		janela.add(jFUltimaDoancao);

		janela.add(jBTerFilho);
		janela.add(jBDoarSangue);

		
		setSize(700, 500);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}