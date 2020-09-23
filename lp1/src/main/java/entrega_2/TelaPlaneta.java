package entrega_2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import entrega_1.modelo.Jupiter;
import entrega_1.modelo.Marte;
import entrega_1.modelo.Mercurio;
import entrega_1.modelo.Netuno;
import entrega_1.modelo.Planeta;
import entrega_1.modelo.Saturno;
import entrega_1.modelo.Terra;
import entrega_1.modelo.Urano;
import entrega_1.modelo.Venus;
import entrega_1.util.ImageUtils;

public class TelaPlaneta extends JFrame {
	private static final long serialVersionUID = 1L;

	static Planeta planeta = null;

	public static void main(String[] args) {
		TelaPlaneta telaPlaneta = new TelaPlaneta();
		telaPlaneta.iniciarPlaneta();
	}

	public void iniciarPlaneta() {
		ImageUtils imageUtils = new ImageUtils();
		JLabel labelInfo = new JLabel("Clique em algum planeta para ver informações");
		JLabel labelMercurio = new JLabel("");
		JLabel labelVenus = new JLabel("");
		JLabel labelTerra = new JLabel("");
		JLabel labelMarte = new JLabel("");
		JLabel labelJupiter = new JLabel("");
		JLabel labelSaturno = new JLabel("");
		JLabel labelUrano = new JLabel("");
		JLabel labelNetuno = new JLabel("");

		final String mensagem = "Selecione um planeta";

		final JButton jButtonViajar = new JButton("Viajar");
		final JButton jButtonLua = new JButton("Qtd luas");
		jButtonViajar.setBounds(110, 300, 200, 30);
		jButtonLua.setBounds(380, 300, 200, 30);

		labelInfo.setBounds(190, -50, 300, 300);
		labelInfo.setForeground(Color.WHITE);
		labelMercurio.setBounds(98, 195, 30, 30);
		labelVenus.setBounds(127, 190, 50, 50);
		labelTerra.setBounds(180, 190, 30, 30);
		labelMarte.setBounds(240, 190, 30, 30);
		labelJupiter.setBounds(290, 190, 30, 30);
		labelSaturno.setBounds(390, 190, 30, 30);
		labelUrano.setBounds(490, 190, 30, 30);
		labelNetuno.setBounds(590, 190, 30, 30);

		final JFrame f = new JFrame();
		setLayout(null);

		JLabel labelFundo = new JLabel();

		BufferedImage image = null;
		try {
			image = ImageIO.read(imageUtils.getImageSistemaSolar());
			ImageIcon imageIcon = new ImageIcon(image);
			labelFundo.setIcon(imageIcon);
			f.setContentPane(labelFundo);
		} catch (IOException e1) {
		}

		jButtonViajar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (planeta == null) {
					JOptionPane.showMessageDialog(f, mensagem);
				} else {
					JOptionPane.showMessageDialog(f, planeta.viajarPara());
				}
			}
		});

		jButtonLua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (planeta == null) {
					JOptionPane.showMessageDialog(f, mensagem);
				} else {
					JOptionPane.showMessageDialog(f, planeta.quantasLuasPossui());
				}

			}
		});

		labelMercurio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				planeta = new Mercurio();
				jButtonViajar.setText("Viajar para " + planeta.getNome());
			}
		});

		labelVenus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				planeta = new Venus();
				jButtonViajar.setText("Viajar para " + planeta.getNome());
			}
		});

		labelTerra.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				planeta = new Terra();
				jButtonViajar.setText("Viajar para " + planeta.getNome());
			}
		});

		labelMarte.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				planeta = new Marte();
				jButtonViajar.setText("Viajar para " + planeta.getNome());
			}
		});

		labelJupiter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				planeta = new Jupiter();
				jButtonViajar.setText("Viajar para " + planeta.getNome());
			}
		});

		labelSaturno.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				planeta = new Saturno();
				jButtonViajar.setText("Viajar para " + planeta.getNome());
			}
		});

		labelUrano.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				planeta = new Urano();
				jButtonViajar.setText("Viajar para " + planeta.getNome());
			}
		});

		labelNetuno.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				planeta = new Netuno();
				jButtonViajar.setText("Viajar para " + planeta.getNome());
			}
		});

		f.add(labelInfo);
		f.add(labelVenus);
		f.add(labelMercurio);
		f.add(labelVenus);
		f.add(labelTerra);
		f.add(labelMarte);
		f.add(labelJupiter);
		f.add(labelSaturno);
		f.add(labelUrano);
		f.add(labelNetuno);
		f.add(jButtonViajar);
		f.add(jButtonLua);
		f.pack();
		this.setLocationRelativeTo(null);
		f.setVisible(true);

	}
}
