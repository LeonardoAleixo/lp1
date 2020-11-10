package entrega_4.tela;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entrega_1.modelo.InstrumentoMusical;
import entrega_1.modelo.Profissional;
import entrega_4.repository.ProfissionalRepository;

public class ProfissionalTela extends JFrame {
	public static void main(String[] args) {
		ProfissionalTela profissionalTela = new ProfissionalTela();
		profissionalTela.iniciarTela();
	}

	ProfissionalRepository profissionalRepository = new ProfissionalRepository();

	List<Profissional> listaProfissional = null;
	String[] colunas = { "ID", "Cargo", "Salario", "Area" };
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable jTProfissional = null;

	JTextField jTFCargo = new JTextField("");
	JTextField jTFSalario = new JTextField("");
	JTextField jTFArea = new JTextField("");

	JButton jBNovo = new JButton("Novo");
	JButton jBExcluir = new JButton("Excluir");
	JButton jBSalvar = new JButton("Salvar");

	Profissional profissional = null;

	public void iniciarTela() {
		Container janela = getContentPane();
		setLayout(null);
		JFrame jFrameTemp = this;

		JLabel labelCargo = new JLabel("Nome: ");
		JLabel labelSalario = new JLabel("Salario: ");
		JLabel labelArea = new JLabel("Area: ");

		jTProfissional = new JTable(tableModel);

		labelCargo.setBounds(50, 20, 100, 20);
		jTFCargo.setBounds(50, 40, 100, 20);
		labelSalario.setBounds(50, 60, 100, 20);
		jTFSalario.setBounds(50, 80, 100, 20);
		labelArea.setBounds(50, 100, 100, 20);
		jTFArea.setBounds(50, 120, 100, 20);
		jBNovo.setBounds(200, 40, 100, 20);
		jBExcluir.setBounds(200, 60, 100, 20);
		jBSalvar.setBounds(50, 140, 100, 20);
		jTProfissional.setBounds(400, 50, 400, 500);

		
		jBSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (profissional == null) {
					profissional = new Profissional(jTFCargo.getText(), Double.parseDouble(jTFSalario.getText()), 
							jTFArea.getText());
				} else {
					profissional = new Profissional(jTFCargo.getText(), Double.parseDouble(jTFSalario.getText()), 
							jTFArea.getText(), profissional.getIdProfissional());
				}
				
				try {
					if (profissional.getIdProfissional() == null){
						profissionalRepository.inserir(profissional);
						JOptionPane.showMessageDialog(jFrameTemp, "Salvo com sucesso!");
					} else {
						profissionalRepository.editar(profissional);
						JOptionPane.showMessageDialog(jFrameTemp, "Editado com sucesso!");
					}
				} catch (Exception exp) {
					exp.printStackTrace();
					JOptionPane.showMessageDialog(jFrameTemp, "Ocorreu um erro ao inserir/editar os dados");
				}
				buscarDados();

			}
		});
		
		
		jTProfissional.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JTable source = (JTable) e.getSource();
				int row = source.rowAtPoint(e.getPoint());
				String ID = source.getModel().getValueAt(row, 0) + "";
				for (Profissional pro : listaProfissional) {
					if (pro.getIdProfissional().toString().equals(ID)) {
						profissional = pro;
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
				profissional = new Profissional("", 0.0, "");
				preencherCampos();
			}
		});

		jBExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				profissionalRepository.delete(profissional);
				buscarDados();
			}
		});

		janela.add(labelCargo);
		janela.add(jTFCargo);
		janela.add(labelSalario);
		janela.add(jTFSalario);
		janela.add(labelArea);
		janela.add(jTFArea);
		janela.add(jBSalvar);
		janela.add(jTProfissional);
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
		jTFCargo.setText(this.profissional.getCargo());
		jTFArea.setText(this.profissional.getArea());
		jTFSalario.setText(this.profissional.getSalario().toString());
	}

	public void buscarDados() {
		this.listaProfissional = profissionalRepository.listarTodos();

		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}

		for (Profissional profissional : listaProfissional) {
			Object[] o = { profissional.getIdProfissional(), profissional.getCargo(), profissional.getSalario(),
					profissional.getArea() };
			tableModel.addRow(o);
		}

	}
}
