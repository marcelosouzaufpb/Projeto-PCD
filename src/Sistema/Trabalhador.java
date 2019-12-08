package Sistema;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Trabalhador {
	public ArrayList<String> tipoPesquisa;

	public Trabalhador() {
		this.tipoPesquisa = new ArrayList<String>();
	}

	public void add(String s) {
		this.tipoPesquisa.add(s);
	}

	public void remuve(String s) {
		this.tipoPesquisa.remove(s);
	}

	public ArrayList<String> getTipoPesquisa() {
		return tipoPesquisa;
	}

	public void setTipoPesquisa(ArrayList<String> tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}

}
