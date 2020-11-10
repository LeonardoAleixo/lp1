package entrega_3.main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entrega_3.modelo.Produto;
import entrega_3.modelo.Venda;

public class TelaVenda extends JFrame implements ActionListener {
	private static final String TAB = "&#9;";
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		TelaVenda field = new TelaVenda();
		field.testaJFormattedTextField();
	}

	Produto produtoSelecionado = null;
	JLabel labelPreco = null;
	List<Venda> listaVendas = new ArrayList<Venda>();
	String[] colunas = { "Produto", "Preço", "Cliente" };
	JTable jTVendas = null;
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTextField jfCliente = null;
	JTextField jfFiltroNome = null;
	JTextField jfFiltroValor = null;
	JFrame jFrameTemp = this;

	private void testaJFormattedTextField() {
		Container janela = getContentPane();
		setLayout(null);
		// fiz um Set para criar produtos que não sejam repetidos
		Set<Produto> produtos = getListaProduto();

		JLabel labelProduto = new JLabel("Produto: ");
		labelProduto.setBounds(50, 20, 100, 20);
		// apliquei o set.toArray para converter e conseguir instanciar o
		// JComboBox com valores
		JComboBox produtoList = new JComboBox(produtos.toArray());
		produtoList.setBounds(50, 40, 100, 20);
		labelPreco = new JLabel("Valor: ");
		labelPreco.setBounds(50, 60, 100, 20);
		produtoList.setSelectedIndex(0);
		produtoList.addActionListener(this);

		JLabel labelCliente = new JLabel("Nome do Cliente: ");
		labelCliente.setBounds(50, 80, 100, 20);

		jfCliente = new JTextField("");
		jfCliente.setBounds(50, 110, 100, 20);

		JButton jbVender = new JButton("Vender");
		jbVender.setBounds(50, 130, 100, 20);

		jbVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaVendas.add(new Venda(produtoSelecionado, jfCliente.getText()));
				adicionarVenda();
			}
		});

		JLabel labelFiltro = new JLabel("produto/cliente");
		labelFiltro.setBounds(300, 10, 90, 20);
		jfFiltroNome = new JTextField();
		jfFiltroNome.setBounds(300, 30, 90, 20);
		JLabel labelFiltro2 = new JLabel("valor");
		labelFiltro2.setBounds(500, 10, 100, 20);
		jfFiltroValor = new JTextField();
		jfFiltroValor.setBounds(500, 30, 90, 20);

		jTVendas = new JTable(tableModel);
		jTVendas.setBounds(400, 50, 400, 500);

		JButton jbFiltrar = new JButton("Filtrar");
		jbFiltrar.setBounds(600, 30, 90, 20);

		jbFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jfFiltroNome.getText().equals("") && jfFiltroValor.getText().equals("")) {
					JOptionPane.showMessageDialog(jFrameTemp, "Insira pelo menos um filtro");
				}
				Map<String, String> filtro = new HashMap<String, String>();
				filtro.put("nome", jfFiltroNome.getText());
				filtro.put("valor", jfFiltroValor.getText());
				filtrar(filtro);
			}
		});

		janela.add(labelProduto);
		janela.add(produtoList);
		janela.add(labelPreco);
		janela.add(jbVender);
		janela.add(jTVendas);
		janela.add(labelCliente);
		janela.add(jfCliente);
		janela.add(labelFiltro);
		janela.add(labelFiltro2);
		janela.add(jfFiltroNome);
		janela.add(jfFiltroValor);
		janela.add(jbFiltrar);
		setSize(1024, 768);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void filtrar(Map<String, String> filtro) {

		String filtroNome = filtro.get("nome").toString();
		Double filtroValor = filtro.get("valor").toString().equals("") ? new Double(0)
				: Double.parseDouble(filtro.get("valor").toString());
		List<Venda> listaTemp = new ArrayList<>();
		for (Venda venda : listaVendas) {
			if (!filtroNome.equals("") && filtroValor > 0){
				if ((!filtroNome.equals("") && (venda.getCliente().toLowerCase().contains(filtroNome.toLowerCase())
						|| venda.getProduto().getNome().toLowerCase().contains(filtroNome.toLowerCase())))
						&& venda.getProduto().getValor().compareTo(filtroValor) == 0) {
					listaTemp.add(venda);
				}	
			}else{
				if ((!filtroNome.equals("") && (venda.getCliente().toLowerCase().contains(filtroNome.toLowerCase())
						|| venda.getProduto().getNome().toLowerCase().contains(filtroNome.toLowerCase())))
						|| venda.getProduto().getValor().compareTo(filtroValor) == 0) {
					listaTemp.add(venda);
				}	
			}
			
		}

		if (listaTemp != null && !listaTemp.isEmpty()) {
			while (tableModel.getRowCount() > 0) {
				tableModel.removeRow(0);
			}
			for (Venda venda : listaTemp) {
				Object[] o = { venda.getProduto().getNome(), venda.getProduto().getValor(), venda.getCliente() };
				tableModel.addRow(o);
			}

			jTVendas = new JTable(tableModel);
		} else {
			JOptionPane.showMessageDialog(jFrameTemp, "Nenhum dado encontrado para filtrar");
		}

	}

	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox) e.getSource();
		produtoSelecionado = (Produto) cb.getSelectedItem();
		labelPreco.setText("Valor: " + produtoSelecionado.getValor());
	}

	public void adicionarVenda() {
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}

		for (Venda venda : listaVendas) {
			Object[] o = { venda.getProduto().getNome(), venda.getProduto().getValor(), venda.getCliente() };
			tableModel.addRow(o);
		}

		jTVendas = new JTable(tableModel);

	}

	public Set<Produto> getListaProduto() {
		Set<Produto> produtos = new HashSet<>(Arrays.asList(new Produto("Bolo", 5.0)));
		produtos.add(new Produto("Bolacha", 2.0));
		produtos.add(new Produto("Sorvete", 10.5));
		produtos.add(new Produto("Donuts", 5.0));
		return produtos;
	}
}
