package domain.DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import domain.ItemPatrimonio;

public class PatrimonioDAO {

	private ItemPatrimonio item;
	private ArrayList<ItemPatrimonio> itens;
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "./bd/patrimonio.csv";
	private SimpleDateFormat form = new SimpleDateFormat("DD/MM/YYYY"); //Sera impressa como formato de data

	//Metodo para abrir arquivo
	public ArrayList<ItemPatrimonio> abrir() { //Conteudo retorna como lista, cada linha do arquivo eh um item da lista
		itens = new ArrayList<>();
		
		try { //Bloco que eh monitorado para erros
			br = new BufferedReader(new FileReader(arquivo)); //Nos da o arquivo que vai ser lido
			String line = "";
			
			//Vai percorrer o arquivo ate o final
			while ((line = br.readLine()) != null) { //Armazena cada linha lida na variavel 'line' enquanto for diferente de nulo
				String[] pose = line.split(";"); //Vai separar cada atributo (id, data, etc.) com ';' armazenando no vetor 'pose'
				//Colocando os valores em cada um dos indices dos vetores (Integer, Double, String)
				item = new ItemPatrimonio(Integer.valueOf(pose[0]), form.parse(pose[1]), pose[2], Double.valueOf(pose[3]));
				itens.add(item); //Vai adicionar cada item na lista 'itens'
			}
			br.close();
		} catch (IOException e) { //Tratamento de erros
			System.out.println("Erro ao abrir arquivo: " + e);
		} catch (NumberFormatException e) {  //A String nao tem formato apropriado para ser convertida em tipos numéricos
			System.out.println("Erro ao converter números: " + e);
		} catch (ParseException e) { //Um erro inesperado
			System.out.println("Erro ao converter datas: " + e);
		}
		return itens;
	}

	//Método para salvar o arquivo
	public boolean salvar(ArrayList<ItemPatrimonio> vs) { //O conteudo atraves de lista
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false)); //Da um nome e um boolean para quando anexar os dados escritos
			for (ItemPatrimonio p : vs) { //Percorre cada item da lista 
				bw.write(p.toCSV()); //Vai escrever no arquivo CSV cada item que foi percorrido na lista 
			}
			bw.close();
			return true;
		} catch (IOException e) {
			System.out.println("Erro ao salvar arquivo: " + e);
			return false; //Caso de erro vai retornar falso
		}
	}
}
