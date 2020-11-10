package entrega_4.tela;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entrega_1.modelo.Calcado;
import entrega_1.modelo.InstrumentoMusical;
import entrega_4.repository.InstrumentoRepository;

public class InstrumentoTela extends JFrame implements ActionListener {

	public static void main(String[] args) {
		InstrumentoTela instrumentoTela = new InstrumentoTela();
		instrumentoTela.iniciartela();
	}

	InstrumentoRepository instrumentoRepository = new InstrumentoRepository();

	List<InstrumentoMusical> listaInstrumento = null;

	InstrumentoMusical instrumentoMusical = null;

	String[] colunas = { "ID", "Nome", "Marca", "Modelo", "Afinado" };
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable jTInstrumento = null;

	JButton jBNovo = new JButton("Novo");
	JButton jBExcluir = new JButton("Excluir");
	JTextField jTFNome = new JTextField("");
	JTextField jTFMarca = new JTextField("");
	JCheckBox jCAfinado = new JCheckBox("Não");
	JCheckBox jCPossuiCordas = new JCheckBox("Não");
	JTextField jTFModelo = new JTextField("");
	JButton jBSalvar = new JButton("Salvar");
	
	public void iniciartela() {
		Container janela = getContentPane();
		setLayout(null);
		
		JFrame jFrameTemp = this;
		JLabel labelNome = new JLabel("Nome: ");
		JLabel labelMarca = new JLabel("Marca: ");
		JLabel labelAfinado = new JLabel("Afinado: Não");
		JLabel labelCordas = new JLabel("Possui Cordas: Não");
		JLabel labelModelo = new JLabel("Modelo:");

		jTInstrumento = new JTable(tableModel);

		labelNome.setBounds(50, 20, 100, 20);
		jTFNome.setBounds(50, 40, 100, 20);
		labelMarca.setBounds(50, 60, 100, 20);
		jTFMarca.setBounds(50, 80, 100, 20);
		labelAfinado.setBounds(50, 120, 100, 20);
		jCAfinado.setBounds(50, 140, 100, 20);
		labelCordas.setBounds(50, 160, 150, 20);
		jCPossuiCordas.setBounds(50, 180, 100, 20);
		labelModelo.setBounds(50, 200, 100, 20);
		jTFModelo.setBounds(50, 220, 100, 20);
		jBSalvar.setBounds(50, 240, 100, 20);

		jTInstrumento.setBounds(400, 50, 400, 500);
		jBNovo.setBounds(200, 40, 100, 20);
		jBExcluir.setBounds(200, 60, 100, 20);

		jBSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (instrumentoMusical == null) {
					instrumentoMusical = new InstrumentoMusical(jTFNome.getText(), jTFMarca.getText(),
							jTFModelo.getText(), jCPossuiCordas.isSelected());
				} else {
					instrumentoMusical = new InstrumentoMusical(jTFNome.getText(), jTFMarca.getText(),
							jTFModelo.getText(), jCPossuiCordas.isSelected(), instrumentoMusical.getIdInstrumento(), false);
				}
				instrumentoMusical.setAfinado(jCAfinado.isSelected());
				try {
					if (instrumentoMusical.getIdInstrumento() == null){
						instrumentoRepository.inserir(instrumentoMusical);
						JOptionPane.showMessageDialog(jFrameTemp, "Salvo com sucesso!");
					} else {
						instrumentoRepository.editar(instrumentoMusical);
						JOptionPane.showMessageDialog(jFrameTemp, "Editado com sucesso!");
					}
				} catch (Exception exp) {
					exp.printStackTrace();
					JOptionPane.showMessageDialog(jFrameTemp, "Ocorreu um erro ao inserir/editar os dados");
				}
				buscarDados();

			}
		});

		jTInstrumento.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JTable source = (JTable) e.getSource();
				int row = source.rowAtPoint(e.getPoint());
				String ID = source.getModel().getValueAt(row, 0) + "";
				for (InstrumentoMusical musical : listaInstrumento) {
					if (musical.getIdInstrumento().toString().equals(ID)) {
						instrumentoMusical = musical;
						
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
		
		jBNovo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				instrumentoMusical = new InstrumentoMusical("", "", "", false);
				preencherCampos();
			}
		});

		jBExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				instrumentoRepository.delete(instrumentoMusical);
				buscarDados();
			}
		});

		janela.add(labelNome);
		janela.add(jTFNome);
		janela.add(labelMarca);
		janela.add(jTFMarca);
		janela.add(labelAfinado);
		janela.add(jCAfinado);
		janela.add(labelCordas);
		janela.add(jCPossuiCordas);
		janela.add(labelModelo);
		janela.add(jTFModelo);

		janela.add(jBSalvar);
		janela.add(jTInstrumento);
		janela.add(jBNovo);
		janela.add(jBExcluir);

		setSize(1024, 768);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// inicialização
		buscarDados();

	}

	public void preencherCampos() {
		this.jTFNome.setText(instrumentoMusical.getNome());
		this.jTFMarca.setText(instrumentoMusical.getMarca());
		this.jCAfinado.setSelected(instrumentoMusical.getAfinado());
		this.jCPossuiCordas.setSelected(instrumentoMusical.getPossuiCordas());
		this.jTFModelo.setText(instrumentoMusical.getModelo());
	}

	public void buscarDados() {
		this.listaInstrumento = instrumentoRepository.listarTodos();

		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}

		for (InstrumentoMusical musical : listaInstrumento) {
			Object[] o = { musical.getIdInstrumento(), musical.getNome(), musical.getMarca(), musical.getModelo(),
					musical.getAfinado() ? "Afinado" : "Desafinado" };
			tableModel.addRow(o);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
