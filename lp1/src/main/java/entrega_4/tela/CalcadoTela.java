package entrega_4.tela;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entrega_1.modelo.Calcado;
import entrega_4.repository.CalcadoRepository;

public class CalcadoTela extends JFrame implements ActionListener {

	String genero = "";
	String[] colunas = { "ID", "Modelo", "Fabricante", "Cor", "Número" };
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable jTCalcados = null;
	final CalcadoRepository calcadoRepository = new CalcadoRepository();
	Calcado gCalcado = null;
	List<Calcado> listaCalcados = null;

	// components

	JTextField jTFNumero = new JTextField("");
	JTextField jTFFabricante = new JTextField("");
	JTextField jTFCor = new JTextField("");
	JTextField jTFModelo = new JTextField("");
	JCheckBox jCAberto = new JCheckBox("Não");
	JComboBox jCGenero = null;
	JButton jBNovo = new JButton("Novo");
	JButton jBExcluir = new JButton("Excluir");

	 JCheckBox jCMataBarata = new JCheckBox("Não");
	 JButton jBSalvar = new JButton("Salvar");

	public static void main(String[] args) {
		CalcadoTela field = new CalcadoTela();
		field.iniciartela();

	}

	public void iniciartela() {
		Container janela = getContentPane();
		setLayout(null);

		// definições
		Set<String> produtos = getGenero();

		JFrame jFrameTemp = this;

		// labels
		JLabel labelNumero = new JLabel("Número: ");
		JLabel labelFabricante = new JLabel("Fabricante: ");
		JLabel labelCor = new JLabel("Cor");
		JLabel labelModelo = new JLabel("Modelo: ");
		JLabel labelAmarrado = new JLabel("Amarrado: Não");
		JLabel labelAberto = new JLabel("Aberto: ");
		JLabel labelGenero = new JLabel("Gênero: ");
		JLabel labelMataBarata = new JLabel("Mata barata: ");
		JLabel labelLimpo = new JLabel("Limpo: ");

		jCGenero = new JComboBox(produtos.toArray());
		jCGenero.setSelectedIndex(0);
		jCGenero.addActionListener(this);
		jTCalcados = new JTable(tableModel);

		// bounds
		labelNumero.setBounds(50, 20, 100, 20);
		jTFNumero.setBounds(50, 40, 100, 20);
		jBNovo.setBounds(200, 40, 100, 20);
		jBExcluir.setBounds(200, 60, 100, 20);
		labelFabricante.setBounds(50, 60, 100, 20);
		jTFFabricante.setBounds(50, 80, 100, 20);
		labelCor.setBounds(50, 100, 100, 20);
		jTFCor.setBounds(50, 120, 100, 20);
		labelModelo.setBounds(50, 140, 100, 20);
		jTFModelo.setBounds(50, 160, 100, 20);
		labelAmarrado.setBounds(50, 180, 100, 20);
		labelAberto.setBounds(50, 200, 100, 20);
		jCAberto.setBounds(50, 220, 100, 20);
		labelGenero.setBounds(50, 240, 100, 20);
		jCGenero.setBounds(50, 260, 100, 20);
		labelMataBarata.setBounds(50, 280, 100, 20);
		jCMataBarata.setBounds(50, 300, 100, 20);
		labelLimpo.setBounds(50, 320, 100, 20);
		jBSalvar.setBounds(50, 340, 100, 20);
		jTCalcados.setBounds(400, 50, 400, 500);

		// events
		jCAberto.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				jCAberto.setText(e.getStateChange() == 1 ? "Sim" : "Não");
			}
		});
		jCMataBarata.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				jCMataBarata.setText(e.getStateChange() == 1 ? "Sim" : "Não");
			}
		});
		jBSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gCalcado == null) {
					gCalcado = new Calcado(Integer.parseInt(jTFNumero.getText()), jTFFabricante.getText(),
							jTFCor.getText(), jTFModelo.getText(), jCAberto.isSelected(), jCMataBarata.isSelected(),
							genero.equals("Masculino") ? 'M' : 'F');
				} else {
					gCalcado = new Calcado(Integer.parseInt(jTFNumero.getText()), jTFFabricante.getText(),
							jTFCor.getText(), jTFModelo.getText(), jCAberto.isSelected(), jCMataBarata.isSelected(),
							genero.equals("Masculino") ? 'M' : 'F', gCalcado.getIdCalcado());
				}

				try {
					if (gCalcado.getIdCalcado() == null) {
						calcadoRepository.inserir(gCalcado);
						JOptionPane.showMessageDialog(jFrameTemp, "Salvo com sucesso!");
					} else {
						calcadoRepository.editar(gCalcado);
						JOptionPane.showMessageDialog(jFrameTemp, "Editado com sucesso!");
					}
					gCalcado = null;
				} catch (Exception error) {
					error.printStackTrace();
					JOptionPane.showMessageDialog(jFrameTemp, "Ocorreu um erro ao inserir/editar os dados");
				}
				buscarDados();
			}
		});

		jBNovo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gCalcado = new Calcado(0, "", "", "", false, false, 'F');
				preencherCampos();
			}
		});
		
		jBExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calcadoRepository.delete(gCalcado);
				buscarDados();
			}
		});
		jTCalcados.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JTable source = (JTable) e.getSource();
				int row = source.rowAtPoint(e.getPoint());
				String ID = source.getModel().getValueAt(row, 0) + "";
				for (Calcado calcado : listaCalcados) {
					if (calcado.getIdCalcado().toString().equals(ID)) {
						gCalcado = calcado;
						
						break;
					}
				}
				preencherCampos();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		// add janela
		janela.add(labelNumero);
		janela.add(jTFNumero);
		janela.add(labelFabricante);
		janela.add(jTFFabricante);
		janela.add(labelCor);
		janela.add(jTFCor);
		janela.add(labelModelo);
		janela.add(jTFModelo);
		janela.add(labelAmarrado);
		janela.add(labelAberto);
		janela.add(jCAberto);
		janela.add(labelGenero);
		janela.add(jCGenero);
		janela.add(labelMataBarata);
		janela.add(jCMataBarata);
		janela.add(jBSalvar);
		janela.add(jBNovo);
		janela.add(jBExcluir);
		janela.add(jTCalcados);

		setSize(1024, 768);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// inicialização
		buscarDados();
	}

	public Set<String> getGenero() {
		Set<String> lista = new HashSet<>(Arrays.asList(""));
		lista.add("Masculino");
		lista.add("Feminino");
		return lista;
	}

	public void preencherCampos() {
		jTFNumero.setText(gCalcado.getNumero().toString());
		jTFFabricante.setText(gCalcado.getFabricante());
		jTFCor.setText(gCalcado.getCor());
		jTFModelo.setText(gCalcado.getModelo());
		jCAberto.setSelected(gCalcado.getAberto());
		jCGenero.setSelectedIndex(gCalcado.getGenero().compareTo('M') == 0 ? 2 : 1);
		jCMataBarata.setSelected(gCalcado.getMataBarata());
	}

	public void buscarDados() {
		listaCalcados = calcadoRepository.listarTodos();

		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}

		for (Calcado calcado : listaCalcados) {
			Object[] o = { calcado.getIdCalcado(), calcado.getModelo(), calcado.getFabricante(), calcado.getCor(),
					calcado.getNumero() };
			tableModel.addRow(o);
		}

		jTCalcados = new JTable(tableModel);
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox) e.getSource();
		genero = (String) cb.getSelectedItem();
	}
}
